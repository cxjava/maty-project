<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%-- <c:set var="lang" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}"/> --%>
<c:set var="language" value="${pageContext.response.locale==null?'en_US':pageContext.response.locale}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><spring:message code="login.page.title"/></title>
	<link rel="shortcut icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${ctx }/resources/images/favicon.ico" type="image/x-icon">
	<script src="${ctx}/resources/libs/yepnope/yepnope.1.5.4.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		ctx = "${ctx}";
		language="${language}";
		yepnope({
			load : [ //extjs
			         "${ctx}/resources/libs/extjs/resources/css/ext-all.css",
					 "${ctx}/resources/libs/extjs/ext-all.js", 
					 "${ctx}/resources/libs/extjs/locale/ext-lang-${language}.js", 
					 //jquery
					 "${ctx}/resources/libs/jquery/jquery-1.7.2.min.js", 
					 "${ctx}/resources/libs/jquery/jquery-plugin/jquery.json-2.3-min.js", 
					 "${ctx}/resources/libs/jquery/jquery-plugin/jquery.center-min.js",
			         "${ctx}/resources/css/default.css"
					 ],
			complete : function() {
				/* Ext.QuickTips.init();
				Ext.form.Field.prototype.msgTarget = 'title';//qtip,title,under,side
				Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
				Ext.BLANK_IMAGE_URL = '${ctx}/resources/extjs/resources/images/default/s.gif';
				yepnope("${ctx}/resources/js/login.js");
				$("#logo-table a").html('<img src="${ctx}/resources/images/login.gif"></img>');*/
				} 
			});
	</script>
</head>

<body>
	<a href="?locale=zh_CN">中文</a>
    <a href="?locale=en_US">English</a>
    <a href="?locale=de_DE">Deutsch</a>
</body>
</html>
