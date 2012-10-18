$(document).ready(function() {
	// 提示
	$('p.help-block').tooltip({
		placement : 'bottom',// 提示位置，上面要遮挡密码框，所以改为下面
		selector : "label[rel=tooltip]"// 哪里需要提示
	});
	// 表单验证
	$("#loginForm").submit(function() {
		if ($("#loginForm").validationEngine('validate')) {
			var username = $("#password").val();
			$("#password").val($.md5(username));// 密码加密发送下
		}
	}).validationEngine({
		// 表单提交时才验证，默认的是失去焦点验证
		validationEventTrigger : "submit"
	});
	// 绑定enter键
	$("body").bind('keydown', function(event) {
		// 回车
		if (event.which == 13) {
			$("#submit").trigger("click");
		}
	});
	// 页面初始化后，焦点定位
	if ($.trim($("#username").val()) === "") {
		$("#username").focus();
	} else {
		$("#password").focus();
	}
	$("#reset").click(function() {
		$.post(ctx + "/get", {
			name : 'maty',
			age : 23
		}, function(json) {
			alert(json);
		}, 'json');
	});
});