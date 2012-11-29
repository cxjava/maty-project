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
	<div align="right" style="margin-right: 20px;height: 14px;">
		<a href="?locale=zh_CN">中文</a>
		<a href="?locale=en_US">English</a>
		<a href="?locale=de_DE">Deutsch</a>
		<%-- <img src="${ctx }/captcha.jpg" alt="abc" width="200" height="50"/> --%>
	</div>

	<div id="loading">
		<div class="progress progress-striped active">
			<div class="bar" style="width: 30%;">
				<div id="ext-all-css" class="bar bar-success" style="width: 15%;">ext-all.css</div>
			</div>
			<div class="bar" style="width: 40%;">
				<div id="ext-all" class="bar bar-danger" style="width: 15%;">ext-all.js</div>
			</div>
			<div class="bar" style="width: 30%;">
				<div id="jquery" class="bar bar-warning" style="width: 15%;">jquery.js</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	(function () {
		function loadProgress(id, percent) {
			var bar = document.getElementById(id);
			return {
				timeout : setInterval(function() {
					bar.style.width = (parseFloat(bar.style.width) + percent) + '%';
				}, 500),// 0.5s
				obj : bar
			};
		};
		ctx = '${ctx}', lang = '${language}';
		var progressResult = {
			'ext-all-css' : loadProgress('ext-all-css', 2),
			'ext-all' : loadProgress('ext-all', 1.5),
			'jquery' : loadProgress('jquery', 1)
		};
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
			callback : {
				'ext-all-css' : function(url, result, key) {
					clearInterval(progressResult[key].timeout);
					progressResult[key].obj.style.width = '100%';
				},
				'ext-all' : function(url, result, key) {
					clearInterval(progressResult[key].timeout);
					progressResult[key].obj.style.width = '100%';
				},
				'jquery' : function(url, result, key) {
					clearInterval(progressResult[key].timeout);
					progressResult[key].obj.style.width = '100%';
				}
			},
			complete : function() {
				// remove load prompt
				$('#loading').remove();
				// execute the login.js
				yepnope.injectJs('${ctx}/resources/js/login.js', null, {}, 3e4);// 30s
			}
		});
	}());
	</script>
</body>
</html>
