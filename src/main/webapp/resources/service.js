const service = (function(){

	function sendList(){
	
		return fetch("http://localhost:8080/manager/listJson" ,
		
		{ method : 'get'}
		
		)	
	}
	
	return {sendList:sendList}
	
})()