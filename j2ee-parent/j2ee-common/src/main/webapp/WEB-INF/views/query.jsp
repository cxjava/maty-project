<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Twitter Bootstrap</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap/css/bootstrap.css" />
<%-- <link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap/css/bootstrap-responsive.css" /> --%>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.js"></script>
<style type="text/css">
/* .form-horizontal .control-label{
width:110px;
}
.form-horizontal .controls {
margin-left: 130px;
}
.form-horizontal .form-actions {
padding-left: 130px;
} */
</style>
</head>
<body>
	<div class="container">
		<h2>Horizontal forms</h2>
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
</body>
</html>
