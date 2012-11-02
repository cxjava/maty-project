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
	<script src="${ctx}/resources/libs/yepnope/yepnope.min.js" type="text/javascript"></script>
	<link href="${ctx}/resources/css/progress.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		#loading {
			position: absolute;
			left: 10%;
			top: 45%;
			width:80%;
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
    
    <div id="loading">
		<div class="progress progress-striped active">
			<div  class="bar" style="width: 30%;">
				<div id="ext-all.css" class="bar bar-success" style="width: 1%;">ext-all.css</div>
			</div>
			<div  class="bar" style="width: 40%;">
				<div id="ext-all" class="bar bar-danger" style="width: 1%;">ext-all.js</div>
			</div>
			<div  class="bar" style="width: 30%;">
				<div id="jquery" class="bar bar-warning" style="width: 1%;">jquery.js</div>
			</div>
		</div>
    </div>
<script type="text/javascript">
	function loadProgress(id,percent) {
		var bar = document.getElementById(id);
		return {
			timeout : setInterval(function() {
				bar.style.width = (parseFloat(bar.style.width) + percent) + "%";
			}, 500),
			obj : bar
		};
	}
	ctx = "${ctx}";
	language = "${language}";
	all = {
		"ext-all.css" : loadProgress("ext-all.css", 0.8),
		"ext-all" : loadProgress("ext-all", 1.2),
		'jquery' : loadProgress("jquery", 0.8)
	},
	yepnope({
		load : {
			'ext-all.css' : "${ctx}/resources/libs/extjs/resources/css/ext-all.css",
			'ext-all' : "${ctx}/resources/libs/extjs/ext-all.js",
			'jquery' : "${ctx}/resources/libs/jquery/jquery-1.7.2.min.js",
			'ext-lang' : "${ctx}/resources/libs/extjs/locale/ext-lang-${language}.js",
			'reader-property' : "${ctx}/resources/libs/extjs-i18n/reader/Property.js",
			'model-property' : "${ctx}/resources/libs/extjs-i18n/model/Property.js",
			'bundle' : "${ctx}/resources/libs/extjs-i18n/Bundle.js",
			'login' : "preload!${ctx}/resources/js/login.js",
			'default-css' : "${ctx}/resources/css/default.css"
		},
		callback : {
			'ext-all.css' : function(url, result, key) {
				console.log("ext-all.css");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			},
			'ext-all' : function(url, result, key) {
				console.log("ext-all.js");
				if (!Ext) {
					console.log("load ext-all.js again!");
					yepnope.injectJs("${ctx}/resources/libs/extjs/ext-all.js");
				}
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			},
			'jquery' : function(url, result, key) {
				console.log("jquery.js");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			},
			'login' : function(url, result, key) {
				console.log("login.js");
			}
		},
		complete : function() {
			/* all = null;
			var div = document.getElementById("loading");
			div.parentNode.removeChild(div); */
			//yepnope.injectJs("${ctx}/resources/js/login.js");
		}
	});
</script>
</body>
</html>
