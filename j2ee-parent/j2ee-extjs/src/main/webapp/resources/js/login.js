(function() {
	Ext.onReady(function() {
		lang = Ext.create('Ext.i18n.Bundle', {
			bundle : 'messages',
			lang : lang,
			path : 'resources/i18n',
			noCache : false
		});
		lang.onReady(function() {
			// captcha's url
			var captchaUrl = ctx + '/captcha.jpg?';
			Ext.define('Maty.Login.Form', {
				extend : 'Ext.form.Panel',
				border : false,
				bodyPadding : 10,
				fieldDefaults : {
					// labelAlign : 'right',
					labelWidth : 80,
					allowBlank : false
				},
				defaults : {
					margins : '0 0 2 0'
				},
				defaultType : 'textfield',
				items : [{
					fieldLabel : lang.getMsg("login.form.username"),
					name : 'username',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == e.ENTER) {
								// form submit event
								field.up('window').onSubmitClick();
							}
						}
					}
				}, {
					fieldLabel : lang.getMsg("login.form.password"),
					name : 'password',
					inputType : 'password',
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == e.ENTER) {
								field.up('window').onSubmitClick();
							}
						}
					}
				}, {
					fieldLabel : lang.getMsg("login.form.captcha"),
					allowBlank : true,
					name : 'captcha',
					hidden : true,
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == e.ENTER) {
								field.up('window').onSubmitClick();
							}
						}
					}
				}, {
					xtype : 'image',
					name : 'captchaImage',
					itemId : 'captchaImage',
					hidden : true,
					alt : lang.getMsg("login.form.captcha"),
					width : 150,
					height : 35,
					style : 'margin-left: 85px',
					src : '',
					listeners : {
						click : {
							element : 'el', // bind to the underlying el property on the panel
							fn : function() {
								this.dom.src = captchaUrl + new Date().getTime();
							}
						}
					}
				}],
				/**
				 * captcha image click event
				 */
				onCaptchaImageClick : function() {
					this.dom.src = captchaUrl + new Date().getTime();
				}
			});

			Ext.define('Maty.Login.Window', {
				extend : 'Ext.window.Window',
				closeAction : 'hide',
				layout : 'fit',
				loginUrl : ctx + '/login',
				loginSuccessUrl : ctx + '/',
				border : false,
				width : 270,
				closable : true,
				modal : false,
				plain : true,
				title : lang.getMsg('login.window.title'),
				resizable : true,
				categoryModel : null,
				initComponent : function() {
					var me = this;
					me.form = Ext.create("Maty.Login.Form");
					// TODO:判断是否需要验证码，从cookie中取得
					// add buttons
					me.buttons = [{
						text : lang.getMsg('login.window.botton.submit'),
						handler : Ext.bind(me.onSubmitClick, me)
					}, {
						text : lang.getMsg('login.window.botton.reset'),
						handler : Ext.bind(me.onResetClick, me)
					}];
					me.items = me.form;
					// me.addEvents("save");
					me.callParent(arguments);
					// me.on("show",
					// Ext.bind(me.onShow, me));
				},
				onShow : function() {
					// focus on first item
					this.form.items.first().focus(true, 200);
				},
				/**
				 * form submit
				 */
				onSubmitClick : function() {
					var me = this, form, password;
					form = me.form.getForm();
					if (form.isValid()) {
						password = form.findField("password");
						// crypto password
						password.setValue(CryptoJS.SHA256(CryptoJS.SHA256(password.getValue())));
						form.submit({
							clientValidation : true,
							waitMsg : '请稍后',
							waitTitle : '正在验证登录',
							url : me.loginUrl,
							success : Ext.bind(me.onFormSubmitSuccess, me),
							failure : Ext.bind(me.onFormSubmitFailure, me)
						});
					}
				},
				/**
				 * form reset
				 */
				onResetClick : function() {
					this.form.getForm().reset();
				},
				/**
				 * submit success
				 * 
				 * @param form
				 * @param action
				 */
				onFormSubmitSuccess : function(form, action) {
					location.href = this.loginSuccessUrl;
				},
				/**
				 * submit failure
				 * 
				 * @param form
				 * @param action
				 */
				onFormSubmitFailure : function(form, action) {
					// if(action.result.)
					this.showCaptcha();
					Ext.MessageBox.show({
						width : 150,
						title : "登录失败",
						buttons : Ext.MessageBox.OK,
						msg : action.result.msg
					});
				},
				showCaptcha : function() {
					var me = this, captcha;
					captcha = me.form.getForm().findField("captcha");
					if (captcha.isHidden()) {
						// set widow more height
						me.setHeight(me.getHeight() + 68);
						captcha.show();
						// don't allow blank
						captcha.allowBlank = false;
						// captcha.labelWidth = 120;
						// show captcha image
						me.onCaptchaImageClick();
					}
				},
				/**
				 * refresh the capthcha image
				 */
				onCaptchaImageClick : function() {
					var me = this, captchaImage;
					captchaImage = me.form.getComponent("captchaImage");
					// if hidden，show it.
					if (captchaImage.isHidden()) {
						captchaImage.show();
						captchaImage.el.dom.title = lang.getMsg("login.form.captcha.image.title");
					}
					// set url
					captchaImage.setSrc(captchaUrl + new Date().getTime());

				}
			});

			/**
			 * Defines the login dialog
			 */
			Ext.define('PartKeepr.LoginDialog', {
				extend : 'Ext.Window',
				// closeAction : 'hide',
				title : lang.getMsg('login.window.title'),
				loginUrl : ctx + '/login',
				loginSuccessUrl : ctx + '/',
				width : 270,
				height : 125,
				modal : false,
				resizable : true,
				layout : 'anchor',
				bodyStyle : 'padding: 5px;',
				/**
				 * Initializes the login dialog component
				 */
				initComponent : function() {
					var me = this;
					me.usernameField = Ext.create({
						xtype : 'textfield',
						// value : "",
						fieldLabel : lang.getMsg("login.form.username"),
						anchor : '100%'
					});

					me.passwordField = Ext.create({
						xtype : 'textfield',
						inputType : "password",
						// value : "",
						fieldLabel : lang.getMsg("login.form.password"),
						anchor : '100%'
					});

					me.captchaField = Ext.create({
						xtype : 'textfield',
						// value : "",
						allowBlank : true,
						hidden : true,
						fieldLabel : lang.getMsg("login.form.captcha"),
						anchor : '100%'
					});
					me.captchaImageField = Ext.create({
						xtype : 'box', // 或者xtype: 'component',
						width : 150, // 图片宽度
						height : 35, // 图片高度
						hidden : true,
						style : 'margin-left: 75px',
						autoEl : {
							tag : 'img', // 指定为img标签
							alt : lang.getMsg("login.form.captcha"),
							title : lang.getMsg("login.form.captcha.image.title"),
							onclick : "javacript:$(this).hide().attr('src', " + ctx + "'/captcha.jpg?' " + new Date().getTime() + ").fadeIn();",
							src : ctx + '/captcha.jpg?' + new Date().getTime()// 指定url路径
						},
						anchor : '100%'
					});
					me.toolbar = Ext.create({
						xtype : 'toolbar',
						enableOverflow : false,
						dock : 'bottom',
						defaults : {
							minWidth : 50
						},
						items : [{
							text : lang.getMsg('login.window.botton.submit'),
							handler : Ext.bind(me.onSubmitClick, me)
						}, {
							text : lang.getMsg('login.window.botton.reset'),
							handler : Ext.bind(me.onResetClick, me)
						}]
					});

					Ext.apply(me, {
						items : [me.loginField, me.passwordField, me.captchaField, me.captchaImageField],
						dockedItems : [me.toolbar]
					});

					me.callParent(arguments);

					me.on("render", me.assignEnterKey, me);
					// Focus the login field on show
					// @workaround Set the focus 100ms after the dialog has been shown.
					me.on("show", function() {
						me.usernameField.focus();
					}, me, {
						delay : 100
					});
				},
				/**
				 * Assigns the enter key to the login window.
				 */
				assignEnterKey : function() {
					var keyMap = this.getKeyMap();
					keyMap.on(Ext.EventObject.ENTER, this.onSubmitClick, this);
				},
				/**
				 * Fires the "login" event
				 */
				login : function() {
					this.fireEvent("login", this.loginField.getValue(), this.passwordField.getValue());
				},
				/**
				 * form submit
				 */
				onSubmitClick : function() {
					var me = this;
					if (me.usernameField.isValid() && me.passwordField.isValid() && me.captchaField.isValid()) {
						form.submit({
							clientValidation : true,
							waitMsg : '请稍后',
							waitTitle : '正在验证登录',
							url : me.loginUrl,
							success : Ext.bind(me.onFormSubmitSuccess, me),
							failure : Ext.bind(me.onFormSubmitFailure, me)
						});
						Ext.Ajax.request({
							url : me.loginUrl,
							success : Ext.bind(me.onFormSubmitSuccess, me),
							failure : Ext.bind(me.onFormSubmitFailure, me),
							method : "POST",
							params : {
								username : me.usernameField.getValue(),
								password : CryptoJS.SHA256(CryptoJS.SHA256(me.passwordField.getValue()))
							}
						});
					}
				},
				/**
				 * form reset
				 */
				onResetClick : function() {
					this.form.getForm().reset();
				},
				/**
				 * submit success
				 * 
				 * @param form
				 * @param action
				 */
				onFormSubmitSuccess : function(form, action) {
					location.href = this.loginSuccessUrl;
				},
				/**
				 * submit failure
				 * 
				 * @param form
				 * @param action
				 */
				onFormSubmitFailure : function(form, action) {
					// if(action.result.)
					this.showCaptcha();
					Ext.MessageBox.show({
						width : 150,
						title : "登录失败",
						buttons : Ext.MessageBox.OK,
						msg : action.result.msg
					});
				},
				showCaptcha : function() {
					var me = this, captcha;
					captcha = me.form.getForm().findField("captcha");
					if (captcha.isHidden()) {
						// set widow more height
						me.setHeight(me.getHeight() + 68);
						captcha.show();
						// don't allow blank
						captcha.allowBlank = false;
						// captcha.labelWidth = 120;
						// show captcha image
						me.onCaptchaImageClick();
					}
				},
				/**
				 * refresh the capthcha image
				 */
				onCaptchaImageClick : function() {
					var me = this, captchaImage;
					captchaImage = me.form.getComponent("captchaImage");
					// if hidden，show it.
					if (captchaImage.isHidden()) {
						captchaImage.show();
						captchaImage.el.dom.title = lang.getMsg("login.form.captcha.image.title");
					}
					// set url
					captchaImage.setSrc(captchaUrl + new Date().getTime());

				}
			});

			Ext.create("Maty.Login.Window").show();
			// Ext.create("PartKeepr.LoginDialog").show();
	});
	});

}());