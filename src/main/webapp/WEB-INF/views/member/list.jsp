<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>List</title>
	
</head>
<body>
	<script type="text/javascript" src="/resources/service.js"></script>
<h1>

</h1>
<div>
<ul>

</ul>
</div>



<script>

const ul = document.querySelector("ul")

service.sendList().then(res => res.json()).then(result => {
	for (let resultElement of result) {
		ul.innerHTML += "<li>"+JSON.stringify(resultElement)+"</li>"
	}
})

	
</script>


</body>
</html>