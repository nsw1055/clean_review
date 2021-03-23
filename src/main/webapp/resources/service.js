const service = (function(){

	function sendList(){
	
		return fetch("http://localhost:8080/member/listJson" ,
		
		{ method : 'get'}
		
		)	
	}
	
	return {sendList:sendList}
	
})()