<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home</title>
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
</head>
<body>
	<div class="container">
		<h2>Horizontal forms</h2>
		<a href="${ctx}/logout">logout</a>
		<div class="row">
		
			<div class="accordion" id="myQuery">
				<div class="accordion-group">
					<div class="accordion-heading">
						<span class="accordion-toggle" data-toggle="collapse" data-target="#collapseOne" style="cursor: pointer;">
						<i class="icon-search"></i>查询
						</span>
					</div>
					<div id="collapseOne" class="accordion-body collapse" style="height: 0px;">
						<div class="accordion-inner">
							<div class="form-horizontal row">
								<div class="span5">
									<div class="control-group">
										<label class="control-label" for="input01">用户名</label>
										<div class="controls">
											<input type="text" class="input-medium" id="input01">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="input02">地址</label>
										<div class="controls">
											<input type="password" class="input-medium" id="input02">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="input02">其他</label>
										<div class="controls">
											<input type="password" class="input-medium" id="input02">
										</div>
									</div>
								</div><%-- .span5 --%>
								<div class="span5">
									<div class="control-group">
										<label class="control-label" for="input02">密 码</label>
										<div class="controls">
											<input type="password" class="input-medium" id="input02">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="input02">QQ</label>
										<div class="controls">
											<select class="input-medium">
								                <option>1</option>
								                <option>2</option>
								                <option>3</option>
								                <option>4</option>
								                <option>5</option>
								              </select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="input02">Test</label>
										<div class="controls">
											<input type="password" class="input-medium" id="input02">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="input02">&nbsp;</label>
										<div class="controls">
											<button class="btn btn-primary" href="#">Primary</button>
										</div>
									</div>
								</div><%-- .span5 --%>
							</div>
						</div><%-- .accordion-inner --%>
					</div><%-- #collapseOne --%>
				</div>
			</div><%-- #myQuery --%>
			
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
