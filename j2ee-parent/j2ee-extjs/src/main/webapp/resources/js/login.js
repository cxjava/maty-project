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
//					standardSubmit:true,
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
//						allowBlank : false,
						width : 260
					}, {
						xtype : 'textfield',
						fieldLabel : language.getMsg("login.form.password"),
//						allowBlank : false,
						name : 'password',
						width : 260,
						inputType : 'password'
					}, {
						xtype : 'textfield',
						fieldLabel : language.getMsg("login.form.password"),
//						allowBlank : false,
						name : 'captcha',
		                hidden:true,
//		                src:ctx+'/captcha.jpg'
						width : 260
					},{
		                xtype: 'image',
		                name : 'captcha1',
		                hidden:true,
		                alt:language.getMsg("login.form.password"),
		                width : 175, //图片宽度  
						height : 35, //图片高度 
						style : 'margin-left: 85px',
		                id:'captcha1',
//		                itemId: 'p1',
		                src:''
		                ,listeners:{
		                	click: {
		                        element: 'el', //bind to the underlying el property on the panel
		                        fn: function(img){
		                        	console.log(img);
		                        	console.log(this);
//		                        	p1 = c.getComponent('p1'); // not the same as Ext.getCmp()
		                        	this.dom.src=ctx+'/captcha.jpg?'+new Date().getTime();
		                        	}
		                    }
		                }
					} ],
					buttons : [ {
						text : language.getMsg("login.form.submit"),
						handler : function() {
							var form = this.up('form').getForm();
							console.log(this.up('form'));
							console.log(form);
							console.log(this.up('form').getComponent('p1'));
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
										//win.hide();
										var captcha=form.findField("captcha");
//										var captcha=Ext.get('_checkimage');
										console.log(captcha);
										console.log(form);
										console.log(form.findField("captcha1"));
										if(captcha.isHidden()){
											win.setHeight(win.getHeight()+50);
											captcha.show();
//											this.up('form').getComponent('p1').show(null,null,form);
//											this.up('form').getComponent('p1').dom.src=ctx+'/captcha.jpg?'+new Date().getTime();
											Ext.get('captcha1').show(null,null,form);
											Ext.get('captcha1').dom.src=ctx+'/captcha.jpg?'+new Date().getTime();
											
										}
										//location.href = ctx+'/';
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
					height : 150,
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
