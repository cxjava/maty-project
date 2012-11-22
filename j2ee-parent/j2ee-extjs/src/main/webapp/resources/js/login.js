!(function() {
	language = Ext.create('Ext.i18n.Bundle', {
		bundle : 'messages',
		lang : language,
		path : 'resources/i18n',
		noCache : true
	});
	language.onReady(function() {
		Ext.define('Maty.View.Login', {
			extend : 'Ext.window.Window',
			alias : 'widget.loginForm',
			initComponent : function() {
				var form = Ext.widget('form', {
					border : false,
					standardSubmit:true,
					bodyPadding : 10,
					fieldDefaults : {
						labelAlign : 'left',
						labelWidth : 80,
						labelStyle : 'font-weight:bold'
					},
					defaults : {
						margins : '0 0 10 0'
					},
					items : [ {
						xtype : 'textfield',
						fieldLabel : language.getMsg("login.form.username"),
						name : 'username',
						allowBlank : false,
						width : 260
					}, {
						xtype : 'textfield',
						fieldLabel : language.getMsg("login.form.password"),
						allowBlank : false,
						name : 'password',
						width : 260,
						inputType : 'password'
					}, {
						xtype : 'textfield',
						fieldLabel : language.getMsg("login.form.password"),
						allowBlank : false,
						name : 'captcha',
						width : 260
					} ],
					buttons : [ {
						text : language.getMsg("login.form.submit"),
						handler : function() {
							var form = this.up('form').getForm();
							var password=form.findField("password");
							password.setValue(CryptoJS.SHA256(CryptoJS.SHA256(password.getValue())));
							var win = this.up('window');
							if (form.isValid()) {
								form.submit({
									clientValidation : true,
									waitMsg : '请稍后',
									waitTitle : '正在验证登录',
									url : ctx+'/login',
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
						text : language.getMsg("login.form.reset"),
						handler : function() {

						}
					} ]
				});
				Ext.apply(this, {
					height : 160,
					width : 320,
					title : language.getMsg('login.windows.title'),
					closeAction : 'hide',
					closable : true,
					iconCls : 'win',
					layout : 'fit',
					modal : false,
					plain : true,
					resizable : true,
					items : form
				});
				this.callParent(arguments);
			}
		});
		Ext.create("Maty.View.Login").show();
	});// end bundle on ready

})();
