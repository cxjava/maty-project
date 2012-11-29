<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="login.page.title" /></title>
<link rel="shortcut icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
<link href="${ctx}/resources/css/progress.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/libs/yepnope/yepnope.js" type="text/javascript"></script>
<style type="text/css">
#loading {
	position: absolute;
	left: 10%;
	top: 45%;
	width: 80%;
}

body {
	font-family: tahoma, arial, verdana, sans-serif;
	font-size: 12px;
}
</style>
</head>

<body>
<a href="${ctx }/logout">logout</a>
	<h1>What is it?</h1>
	<p style="padding: 15px;">各式主流的、实用的、好玩的开源项目大派对。</p>
	
	<h1>What is new?</h1>
	<ul style="padding: 15px;">
		<li>CSS 大装修完毕。</li>
		<li>CXF的SOAP WebService 与 MyBais从Mini-Service搬了过来</li>
		<li>Shiro的授权演示搬了过来</li>
	</ul>
	<script type="text/javascript">
	(function () {
		yepnope({
			load : {
				'default-css' : '${ctx}/resources/css/default.css',
				// if load time is very long ,you should add timeout prefix,
				// and change the default timeout(10s) more long, 30s,60s
				'ext-all-css' : '${ctx}/resources/libs/extjs/resources/css/ext-all.css',
				'jquery' : '${ctx}/resources/libs/jquery/jquery-1.7.2.min.js',
				'ext-all' : '${ctx}/resources/libs/extjs/ext-all.js',
				'ext-lang' : '${ctx}/resources/libs/extjs/locale/ext-lang-${language}.js',
				'sha256' : '${ctx}/resources/libs/cryptojs/sha256.js',
				'bundle' : '${ctx}/resources/libs/extjs-i18n/Bundle.min.js',
				'login' : 'preload!${ctx}/resources/js/login.js'
			},
			complete : function() {
				// remove load prompt
				// execute the login.js
				//yepnope.injectJs('${ctx}/resources/js/login.js', null, {}, 3e4);// 30s
			}
		});
	}());
	</script>
</body>
</html>