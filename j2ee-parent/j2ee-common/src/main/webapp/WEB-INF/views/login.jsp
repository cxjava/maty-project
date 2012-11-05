<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><fmt:message key="login.title" /></title>
<script type="text/javascript" src="${ctx}/resources/libs/yepnope/yepnope.1.5.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/libs/yepnope/prefixes/yepnope.ie-prefix.min.js"></script>
<link href="${ctx}/resources/libs/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.8.16.custom.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/libs/jquery-ui-bootstrap/css/custom-theme/jquery.ui.1.8.16.ie.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/libs/jquery-validation-engine/css/validationEngine.jquery.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/libs/jquery-layout/layout-default-latest.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/libs/bootstrap/css/bootstrap-responsive.min.css", rel="stylesheet" type="text/css" />
<link href="${ctx}/resources/css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	ctx = "${ctx}";
 	yepnope({
		load : [//load all css
		        "ielt9!${ctx}/resources/libs/others/html5.js"//Le HTML5 shim, for IE6-8 support of HTML elements,must first loading
		        /* "${ctx}/resources/libs/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.8.16.custom.min.css",//jquery ui
		        "ie!${ctx}/resources/libs/jquery-ui-bootstrap/css/custom-theme/jquery.ui.1.8.16.ie.css",//jquery ui
		        "${ctx}/resources/libs/jquery-validation-engine/css/validationEngine.jquery.min.css",//validationEngine.jquery.min.css
		        "${ctx}/resources/libs/jquery-layout/layout-default-latest.min.css",//jquery layout css
		        "${ctx}/resources/libs/bootstrap/css/bootstrap.min.css",//bootstrap css
		        "${ctx}/resources/libs/bootstrap/css/bootstrap-responsive.min.css",//bootstrap css 
		        "${ctx}/resources/css/default.css" */
			]}); 
</script>
<style type="text/css">
/* 
.span5{ width: 500px; } 
.span5{ width:390px; }
*/
.form-horizontal .control-label{ width:90px; }
.form-horizontal .controls{ margin-left:110px; }
.form-horizontal .form-actions {padding-left: 110px;} 
.form-actions{padding-bottom: 0px;}
</style>
</head>
<body>
<div class="container">
	
    <div class="container" id="center" style="position: fixed; left: 50%; top: 50%; z-index: 99; margin-left: -585px; margin-top: -151.5px; ">
		<div class="span6" align="center">
		      <img src="${ctx}/resources/images/googleplus-minik-icon/google_plus_home.png" alt="<fmt:message key="login.title" />" ></img>
		</div>
		<div class="span6" style="width: 390px; ">
	 		<%-- org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME 的值为 shiroLoginFailure，所以el表达式里面这样写 --%>
			<c:if test="${not empty shiroLoginFailure }">
				<div class="control-group">
					<div class="controls ">
						<div class="alert alert-error">
							<button class="close" data-dismiss="alert">×</button>
							登录失败，请重试.
						</div>
					</div>
				</div>
			</c:if>
			<form:form id="loginForm" action="${ctx}/login" method="post" class="form-horizontal well">
				<fieldset>
					<legend>用户登录</legend>
					<div class="control-group">
						<label class="control-label" for="username">用户名</label>
						<div class="controls">
							<div class="input-prepend">
								<span class="add-on"><i class="icon-user"></i></span><input placeholder="用户名" type="text" id="username" name="username" size="50"
									value="${username}" class="validate[required] input-medium" />
							</div>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密　码</label>
						<div class="controls">
							<div class="input-prepend">
								<span class="add-on"><i class="icon-lock"></i></span><input placeholder="密　码" type="password" id="password" name="password"
									size="50" class="validate[required] input-medium" />
							</div>
							<p class="help-block">
								<label class="checkbox inline" for="rememberMe" rel="tooltip" data-original-title="为了确保您的信息安全，请不要在网吧或者公共机房勾选此项！">
								<input type="checkbox" id="rememberMe" name="rememberMe" />记住我
								</label>
							</p>
						</div>
					</div>
					<div class="form-actions">
						<button id="submit" class="btn" type="submit"><i class="icon-ok"></i>登录</button>
						&nbsp;<button id="reset" class="btn" type="reset"><i class="icon-repeat"></i>重置</button>
						<c:if test="${not empty shiroLoginFailure }">
							&nbsp;<a href="">忘记密码?</a>
						</c:if>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
	<script type="text/javascript">
		yepnope({
			load : [ //load all js
					"${ctx}/resources/libs/jquery/jquery-1.7.2.min.js", 
					"${ctx}/resources/libs/jquery-plugin/jquery.center.others.js",//设置在屏幕中央 center 类
					"${ctx}/resources/libs/bootstrap/js/bootstrap.min.js",
					"${ctx}/resources/libs/jquery-layout/jquery.layout-latest.min.js",
					"${ctx}/resources/libs/jquery-ui-bootstrap/js/jquery-ui-1.8.16.custom.min.js",
					"${ctx}/resources/libs/jquery-validation-engine/js/languages/jquery.validationEngine-zh_CN.min.js",
					"${ctx}/resources/libs/jquery-validation-engine/js/jquery.validationEngine.min.js",
					"${ctx}/resources/libs/jquery-plugin/jquery.ba-dotimeout.min.js",//settimeout增强js
					"${ctx}/resources/libs/jquery-plugin/jquery.cookies.2.2.0.min.js",
					"${ctx}/resources/libs/jquery-plugin/jquery.json-2.3.min.js",
					"${ctx}/resources/libs/others/moment.min.js",//日期处理类
					// ie下面对验证会产生影响bug。先注释掉
					//"ie!${ctx}/resources/libs/jquery-plugin/jquery.placeholder.min.js",
					"${ctx}/resources/libs/jquery-plugin/jquery.md5.min.js" //md5加密 
					],
			callback : {
				"jquery.center.others.js" : function() {
					$("#center").center();//登陆框居中
				},
				"jquery.placeholder.min.js" : function() {
					$('input,textarea').placeholder();//ie下面的placeholder
				}
			},
			complete : function() {
				yepnope("${ctx}/resources/js/login.js");
			}
		});
	</script>
</body>
</html>
