package org.judy.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.judy.common.util.FileDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
@Log4j
@Controller
@RequestMapping("/common")
public class FileUploadController {

	@GetMapping("/view")
	public ResponseEntity<byte[]> view(String file) {
		
		log.info("file: "+ file);
		ResponseEntity<byte[]> result = null;
			
		String realPath = "";
		
		try {
			
			String path = URLDecoder.decode(file, "UTF-8");
			
			realPath = path.replace("#", ".");
			
			log.info("realPath: "+ realPath);
			
			File targetFile = new File(realPath);
			
			String mimeType = Files.probeContentType(targetFile.toPath());
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", mimeType);
				
			result = new ResponseEntity<>(
			
			FileCopyUtils.copyToByteArray(targetFile) ,
			header ,
			HttpStatus.OK
			);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@PostMapping(value =  "/manager/upload", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<FileDTO>> postUpload(MultipartFile[] files){
	
		
		String path = "C:\\upload\\temp\\admin\\manager";
		
		List<FileDTO> fileList = new ArrayList<>();
		
		for (MultipartFile multipartFile : files) {
		
			log.info(multipartFile);
			log.info(multipartFile.getOriginalFilename());
			
			UUID uuid = UUID.randomUUID();
			
			File uploadPath = new File(path, getFolder());
			
			String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
			
			String sFileName = "s_"+uuid.toString() + "_" + multipartFile.getOriginalFilename();
			
			boolean isImage = multipartFile.getContentType().startsWith("image");
			
			if(uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
			
			File saveFile = new File(uploadPath , fileName);
			
			FileDTO fileDTO = FileDTO.builder().fileName(multipartFile.getOriginalFilename()).uploadPath(uploadPath.toString()).uuid(uuid.toString()).image(isImage).build();
			
			
			try { 
				multipartFile.transferTo(saveFile);
				
				if(isImage) {
					
					FileOutputStream fos = new FileOutputStream(new File(uploadPath , sFileName));
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), fos, 90, 90);
					
					fos.close();
				}
				
				 fileList.add(fileDTO);
				
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		} // end for
		
	return new ResponseEntity<List<FileDTO>>(fileList, HttpStatus.OK);
	
	}
	
	private String getFolder() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	
}
