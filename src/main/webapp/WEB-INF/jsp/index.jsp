<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.slim.js" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous"></script>


<script src="<c:url value="/resources/js"/>/dropzone.js"></script>

<link type="text/css" href="<c:url value="/resources/css"/>/dropzone.css">



</head>
<body>
<form name="fname" method="post"  onSubmit="return false;"enctype="multipart/form-data">

<input type="text" id="inputVal" name="hello" value="dfdfdf">

<div class="dropzone" id="drZone" style="width:100%; height:300px; background:red">
	<div class="dz-default dz-message"> 파일을 업로드 해주세요.</div>
	
	
	
</div>

	<button onclick="upload()" >저장</button> 
</form>


<script>

var drZone = new Dropzone('#drZone', {  
	url:'/testUpload',
	
    paramName: "files", 
    maxFilesize: 10.0, 
    maxFiles: 4,
    parallelUploads: 10000,
    uploadMultiple: true,
    clickable:true,
    autoProcessQueue: false,
    previewsContainer: ".dropzone",
    success:function(){
    	console.log( " success" );
    },
    error:function(){
    	console.log("fail");
    },
    init:function(){
    	this.on("sending",function(file, xhr, formData){
    		console.log( file );
    		console.log( xhr );
    		formData.append("testData", $("#inputVal").val());
    		console.log( formData );
    	});
    }
});


drZone.on('drop',function(e){
	console.log( e);
});


function upload(){
	drZone.processQueue();
}

</script>

</body>
</html>