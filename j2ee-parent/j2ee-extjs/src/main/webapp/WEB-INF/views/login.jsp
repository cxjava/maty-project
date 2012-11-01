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
	<script src="${ctx}/resources/libs/yepnope/yepnope.js" type="text/javascript"></script>
	<link href="${ctx}/resources/css/progress.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/libs/extjs/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/resources/css/default.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		#loading {
			position: absolute;
			left: 5%;
			top: 35%;
			width:90%;
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
			<div id="ext-all" class="bar bar-success" style="width: 1%;">ext-all.js</div>
			<div id="ext-lang" class="bar bar-warning" style="width: 1%;">ext-lang-${language}.js</div>
			<div id="jquery" class="bar bar-danger" style="width: 1%;">jquery-1.7.2.min.js</div>
			<div id="jquery-json" class="bar bar-success" style="width: 1%;">jquery.json-2.3.min.js</div>
			<div id="jquery-center" class="bar bar-warning" style="width: 1%;">jquery.center.min.js</div>
		</div>
		<!-- 
			<div id="bundle" class="bar bar-danger" style="width: 1%;">bundle.js</div>
			<div id="reader-property" class="bar bar-success" style="width: 1%;">reader-property.js</div>
			<div id="model-property" class="bar bar-warning" style="width: 1%;">model-property.js</div>
		< -->
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
		"ext-all" : loadProgress("ext-all", 1),
		"ext-lang" : loadProgress("ext-lang", 1.5),
		'jquery' : loadProgress("jquery", 1.5),
		'jquery-json' : loadProgress("jquery-json", 1.5),
		'jquery-center' : loadProgress("jquery-center", 1.5)/* ,
		'bundle' : loadProgress("bundle", 3.5),
		'reader-property' : loadProgress("reader-property", 3.5),
		'model-property' : loadProgress("model-property", 3.5) */
	},
	yepnope({
		load : { //extjs
			'ext-all' : "${ctx}/resources/libs/extjs/ext-all.js",
			'ext-lang' : "${ctx}/resources/libs/extjs/locale/ext-lang-${language}.js",
			//jquery
			'jquery' : "${ctx}/resources/libs/jquery/jquery-1.7.2.min.js",
			'jquery-json' : "${ctx}/resources/libs/jquery-plugin/jquery.json-2.3.min.js",
			'jquery-center' : "${ctx}/resources/libs/jquery-plugin/jquery.center.min.js" ,
			'reader-property' : "${ctx}/resources/libs/extjs-i18n/reader/Property.js",
			'model-property' : "${ctx}/resources/libs/extjs-i18n/model/Property.js" ,
			'bundle' : "${ctx}/resources/libs/extjs-i18n/Bundle.js",
			'messages-properties' : "preload!${ctx}/resources/i18n/messages_${language}.properties" ,
			'login' : "preload!${ctx}/resources/js/login.js"
		},
		callback : {
			'ext-all' : function(url, result, key) {
				console.log("ext-all");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "30%";
			},
			'ext-lang' : function(url, result, key) {
				console.log("ext-lang");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "20%";
			},
			'jquery' : function(url, result, key) {
				console.log("jquery");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "20%";
			},
			'jquery-json' : function(url, result, key) {
				console.log("jquery-json");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "15%";
			},
			'jquery-center' : function(url, result, key) {
				console.log("jquery-center");
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "15%";
			},
			'login' : function(url, result, key) {
				//yepnope(url);
				console.log("login");
			}/*  ,
			'bundle' : function(url, result, key) {
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			},
			'reader-property' : function(url, result, key) {
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			},
			'model-property' : function(url, result, key) {
				clearInterval(all[key].timeout);
				all[key].obj.style.width = "100%";
			} */
		},
		complete : function() {
			all=null;
			var div=document.getElementById("loading");
			div.parentNode.removeChild(div); 
			yepnope.injectJs("${ctx}/resources/js/login.js", function () {
				  console.log("jQuery loaded!");
				}, {
				  charset: "utf-8"
				}, 5000);
			//div.style.display="none";
			/* Ext.QuickTips.init();
			Ext.form.Field.prototype.msgTarget = 'title';//qtip,title,under,side
			Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
			Ext.BLANK_IMAGE_URL = '${ctx}/resources/extjs/resources/images/default/s.gif';
			yepnope("${ctx}/resources/js/login.js");
			$("#logo-table a").html('<img src="${ctx}/resources/images/login.gif"></img>');*/
		}
	});
</script>
</body>
</html>
