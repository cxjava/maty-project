(function() {
	Ext.onReady(function() {
		language = Ext.create('Ext.i18n.Bundle', {
			bundle : 'messages',
			lang : language,
			path : 'resources/i18n',
			noCache : true
		});
		language.onReady(function() {
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
					fieldLabel : language.getMsg("login.form.username"),
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
					fieldLabel : language.getMsg("login.form.password"),
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
					fieldLabel : language.getMsg("login.form.captcha"),
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
					alt : language.getMsg("login.form.captcha"),
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
				title : language.getMsg('login.window.title'),
				resizable : true,
				categoryModel : null,
				initComponent : function() {
					this.form = Ext.create("Maty.Login.Form");
					// TODO:判断是否需要验证码，从cookie中取得
					// add buttons
					this.buttons = [{
						text : language.getMsg('login.window.botton.submit'),
						handler : Ext.bind(this.onSubmitClick, this)
					}, {
						text : language.getMsg('login.window.botton.reset'),
						handler : Ext.bind(this.onResetClick, this)
					}];
					this.items = this.form;
					// this.addEvents("save");
					this.callParent(arguments);
					// this.on("show",
					// Ext.bind(this.onShow, this));
				},
				onShow : function() {
					// focus on first item
					this.form.items.first().focus(true, 200);
				},
				/**
				 * form submit
				 */
				onSubmitClick : function() {
					var form = this.form.getForm();
					if (form.isValid()) {
						var password = form.findField("password");
						// crypto password
						password.setValue(CryptoJS.SHA256(CryptoJS.SHA256(password.getValue())));
						form.submit({
							clientValidation : true,
							waitMsg : '请稍后',
							waitTitle : '正在验证登录',
							url : this.loginUrl,
							success : Ext.bind(this.onFormSubmitSuccess, this),
							failure : Ext.bind(this.onFormSubmitFailure, this)
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
					var captcha = this.form.getForm().findField("captcha");
					if (captcha.isHidden()) {
						// set widow more height
						this.setHeight(this.getHeight() + 68);
						captcha.show();
						// don't allow blank
						captcha.allowBlank = false;
						// captcha.labelWidth = 120;
						// show captcha image
						this.onCaptchaImageClick();
					}
				},
				/**
				 * refresh the capthcha image
				 */
				onCaptchaImageClick : function() {
					var captchaImage = this.form.getComponent("captchaImage");
					console.log(captchaImage);
					// if hidden，show it.
					if (captchaImage.isHidden()) {
						captchaImage.show();
						captchaImage.el.dom.title = language.getMsg("login.form.captcha.image.title");
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
				/* Various style settings */
				title : language.getMsg("login.form.captcha.image.title"),

				width : 400,
				height : 125,

				modal : false,
				resizable : true,

				layout : 'anchor',

				bodyStyle : 'padding: 5px;',

				/**
				 * Initializes the login dialog component
				 */
				initComponent : function() {

					this.loginField = Ext.ComponentMgr.create({
						xtype : 'textfield',
						value : "",
						fieldLabel : language.getMsg("login.form.username"),
						anchor : '100%'
					});

					this.passwordField = Ext.ComponentMgr.create({
						xtype : 'textfield',
						inputType : "password",
						value : "",
						fieldLabel : language.getMsg("login.form.password"),
						anchor : '100%'
					});

					Ext.apply(this, {
						items : [this.loginField, this.passwordField],
						dockedItems : [{
							xtype : 'toolbar',
							enableOverflow : false,
							dock : 'bottom',
							ui : 'footer',
							pack : 'start',
							defaults : {
								minWidth : 100
							},
							items : [{
								text : language.getMsg("login.form.submit"),
								icon : 'resources/silkicons/connect.png',
								handler : Ext.bind(this.login, this)
							}, {
								text :language.getMsg("login.form.reset"),
								handler : Ext.bind(this.close, this),
								icon : 'resources/silkicons/cancel.png'
							}]
						}]
					});

					this.callParent(arguments);

					this.on("render", this.assignEnterKey, this);
					// Focus the login field on show
					// @workaround Set the focus 100ms after the dialog has been shown.
					this.on("show", function() {
						this.loginField.focus();
					}, this, {
						delay : 100
					});
				},
				/**
				 * Assigns the enter key to the login window.
				 */
				assignEnterKey : function() {
					var keyMap = this.getKeyMap();
					keyMap.on(Ext.EventObject.ENTER, this.login, this);
				},
				/**
				 * Fires the "login" event
				 */
				login : function() {
					this.fireEvent("login", this.loginField.getValue(), this.passwordField.getValue());
				}

			});

//			Ext.create("Maty.Login.Window").show();
			Ext.create("PartKeepr.LoginDialog").show();
		});
	});

}());