<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="language" value="${pageContext.response.locale==null?'en_US':pageContext.response.locale}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="login.page.title"/></title>
	<link rel="shortcut icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
	<link href="${ctx}/resources/css/progress.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/libs/extjs/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/css/default.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		#loading {
			position: absolute;
			left: 25%;
			top: 45%;
			width:50%;
		}
		body {
		    font-family: tahoma,arial,verdana,sans-serif;
		    font-size: 12px;
		}
	</style>
</head>

<body>
	<a href="?locale=zh_CN">中文</a>
    <a href="?locale=en_US">English</a>
    <a href="?locale=de_DE">Deutsch</a>
    
		    <div id="loading" class="progress progress-striped active">
  				<div id="bar" class="bar" style="width: 0%;"></div>&nbsp;<spring:message code="login.load.js"/><span id="loadJSName"></span>
			</div>
	<script type="text/javascript">
		var timeout = {},div= document.getElementById("loading");
		function loadProgress(JSName, percent) {
			var bar = document.getElementById("bar");
			var js = document.getElementById("loadJSName");
			clearInterval(timeout);
			bar.style.width = percent + "%";
			timeout = setInterval(function() {
				bar.style.width = (parseFloat(bar.style.width) + 1) + "%";
			}, 500);
			js.innerHTML = JSName;
		}
	</script>
	
<script type="text/javascript">loadProgress("yepnope.1.5.4.min.js",1)</script>
<script src="${ctx}/resources/libs/yepnope/yepnope.1.5.4.min.js" type="text/javascript"></script>
<script type="text/javascript">loadProgress("ext-all.js",10)</script>
<script src="${ctx}/resources/libs/extjs/ext-all.js" type="text/javascript"></script>
<script type="text/javascript">loadProgress("ext-lang-${language}.js",50)</script>
<script src="${ctx}/resources/libs/extjs/locale/ext-lang-${language}.js" type="text/javascript"></script>
<script type="text/javascript">loadProgress("jquery-1.7.2.min.js",70)</script>
<script src="${ctx}/resources/libs/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">loadProgress("jquery.json-2.3.min.js",80)</script>
<script src="${ctx}/resources/libs/jquery-plugin/jquery.json-2.3.min.js" type="text/javascript"></script>
<script type="text/javascript">loadProgress("jquery.center.min.js",90)</script>
<script src="${ctx}/resources/libs/jquery-plugin/jquery.center.min.js" type="text/javascript"></script>
<script type="text/javascript">clearInterval(timeout);div.style.display="none";/* div.parentNode.removeChild(div);  */</script>
</body>
</html>
