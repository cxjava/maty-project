!(function() {
	language = Ext.create('Ext.i18n.Bundle', {
		bundle : 'messages',
		lang : language,
		path : 'resources/i18n',
		noCache : true
	});
	language.onReady(function() {
		Ext.define('MATY.view.Login', {
			extend : 'Ext.window.Window',
			alias : 'widget.loginForm',
			// requires : [ 'Ext.form.*', 'SMS.view.CheckCode' ],
			initComponent : function() {
				var form = Ext.widget('form', {
					border : false,
					bodyPadding : 10,
					fieldDefaults : {
						labelAlign : 'left',
						labelWidth : 55,
						labelStyle : 'font-weight:bold'
					},
					defaults : {
						margins : '0 0 10 0'
					},
					items : [ {
						xtype : 'textfield',
						fieldLabel : '用户名',
						// blankText : '用户名不能为空',
						name : 'UserName',
						id : 'UserName',
						allowBlank : false,
						width : 240
					}, {
						xtype : 'textfield',
						fieldLabel : '密   码',
						allowBlank : false,
						// blankText : '密码不能为空',
						name : 'PassWord',
						id : 'PassWord',
						width : 240,
						inputType : 'password'
					} ],
					buttons : [ {
						text : '登录',
						handler : function() {
							var form = this.up('form').getForm();
							var win = this.up('window');
							if (form.isValid()) {
								form.submit({
									clientValidation : true,
									waitMsg : '请稍后',
									waitTitle : '正在验证登录',
									url : '/server/checklogin.asp',
									success : function(form, action) {
										// 登录成功后。
										// 隐藏登录窗口，并重新加载菜单
										win.hide();
										Ext.getCmp('SystemMenus').store.load();

									},
									failure : function(form, action) {
										Ext.MessageBox.show({
											width : 150,
											title : "登录失败",
											buttons : Ext.MessageBox.OK,
											msg : action.result.msg
										});
									}
								});
							}
						}
					}, {
						text : '取消',
						handler : function() {

						}
					} ]
				});
				Ext.apply(this, {
					height : 160,
					width : 280,
					title : '用户登陆',
					closeAction : 'hide',
					closable : false,
					iconCls : 'win',
					layout : 'fit',
					modal : true,
					plain : true,
					resizable : false,
					items : form
				});
				this.callParent(arguments);
			}
		});
		Ext.create("MATY.view.Login").show();
	});// end bundle on ready

})();
