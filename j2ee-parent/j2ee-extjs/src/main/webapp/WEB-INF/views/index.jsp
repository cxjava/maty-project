<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>Home</title>
	<script>
	</script>
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
</body>
</html>