(function() {
	Ext.onReady(function() {
		Ext.create('Ext.i18n.Bundle', {
			bundle : 'messages',
			lang : lang,
			path : 'resources/i18n',
			noCache : false
		}).onReady(function() {
			// captcha's url
			var captchaUrl = ctx + '/captcha.jpg?';
			Ext.define('Maty.Login.Form', {
				extend : 'Ext.form.Panel',
				bodyPadding : 10,
				fieldDefaults : {
					// labelAlign : 'right',
					labelWidth : 'zh_CN' === lang.language ? 70 : 110,
					allowBlank : false
				},
				initComponent : function() {
					var me = this;
					me.username = Ext.create("Ext.form.field.Text", {
						fieldLabel : t('login.form.username'),
						name : 'username',
						anchor : '100%'
					});

					me.password = Ext.create("Ext.form.field.Text", {
						fieldLabel : t('login.form.password'),
						name : 'password',
						inputType : 'password',
						anchor : '100%'
					});

					me.captcha = Ext.create("Ext.form.field.Text", {
						fieldLabel : t('login.form.captcha'),
						allowBlank : true,
						name : 'captcha',
						hidden : true,
						anchor : '100%'
					});
					me.captchaImage = Ext.create("Ext.Img", {
						name : 'captchaImage',
						hidden : true,
						alt : t('login.form.captcha'),
						style : 'margin-left: ' + (this.fieldDefaults.labelWidth + 5) + 'px',
						src : '',
						anchor : '100%',
						listeners : {
							click : {
								element : 'el', // bind to the underlying el property on the panel
								fn : function() {
									this.dom.src = captchaUrl + new Date().getTime();
								}
							}
						}
					});
					me.items = [me.username, me.password, me.captcha, me.captchaImage];
					me.callParent(arguments);
				}
			});

			Ext.define('Maty.Login.Window', {
				extend : 'Ext.window.Window',
				// closeAction : 'hide',
				layout : 'fit',
				loginUrl : ctx + '/login',
				loginSuccessUrl : ctx + '/',
				border : false,
				width : 'zh_CN' === lang.language ? 250 : 300,
				closable : true,
				modal : false,
				plain : true,
				title : t('login.window.title'),
				resizable : true,
				categoryModel : null,
				initComponent : function() {
					var me = this;
					me.form = Ext.create('Maty.Login.Form');
					// TODO:判断是否需要验证码，从cookie中取得
					// add buttons

					me.toolbar = Ext.create("Ext.toolbar.Toolbar", {
						enableOverflow : false,
						dock : 'bottom',
						ui : 'footer',
						defaults : {
							minWidth : 80
						},
						items : [{
							text : t('login.window.botton.submit'),
							iconCls : 'add',
							handler : Ext.bind(me.onSubmitClick, me)
						}, {
							text : t('login.window.botton.reset'),
							iconCls : 'add',
							handler : Ext.bind(me.onResetClick, me)
						}]
					});

					Ext.apply(me, {
						items : [me.form],
						dockedItems : [me.toolbar]
					});

					me.callParent(arguments);
					me.on("render", me.assignEnterKey, me);
				},
				onShow : function() {
					this.form.username.focus(true, 200);
				},
				/**
				 * Assigns the enter key to the login window.
				 */
				assignEnterKey : function() {
					this.getKeyMap().on(Ext.EventObject.ENTER, this.onSubmitClick, this);
				},
				/**
				 * form submit
				 */
				onSubmitClick : function() {
					var me = this, form, password;
					form = me.form.getForm();
					if (form.isValid()) {
						password = me.form.password.getValue();
						// crypto password
						me.form.password.setValue(password.length == 64 ? password : CryptoJS.SHA256(CryptoJS.SHA256(password)));
						form.submit({
							waitMsg : t('login.window.waitmsg'),
							waitTitle : t('login.window.waittitle'),
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
					this.form.username.focus(true, 100);
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
					var me = this;
					Ext.MessageBox.show({
						width : 170,
						title : t('login.failure.title'),
						buttons : Ext.MessageBox.OK,
						icon : Ext.MessageBox.ERROR,
						fn : function(btn) {
							if (btn == 'ok' || btn == 'cancel') {
								me.onBoxClose(action.result);
							}
						},
						msg : t(action.result.msg)
					});
				},
				onBoxClose : function(result) {
					var me = this, captchaImage = me.form.captchaImage;
					if (result.msg.indexOf('username.null') !== -1) {
						me.form.captcha.reset();
						me.form.password.reset();
						me.form.username.focus(true, 100);
					} else if (result.msg.indexOf('captcha') !== -1) {
						me.showCaptcha();
						me.form.captcha.focus(true, 100);
					} else if (result.msg.indexOf('password') !== -1) {
						if (!captchaImage.isHidden()) {
							me.onCaptchaImageClick();
						}
						me.form.password.focus(true, 100);
					} else if (result.msg.indexOf('account') !== -1) {
						if (!captchaImage.isHidden()) {
							me.onCaptchaImageClick();
						}
						me.form.password.reset();
						me.form.username.focus(true, 100);
					}
				},
				showCaptcha : function() {
					var me = this, captcha;
					captcha = me.form.captcha;
					if (captcha.isHidden()) {
						// set widow more height
						me.setHeight(me.getHeight() + 60);
						captcha.show();
						// don't allow blank
						captcha.allowBlank = false;
						// captcha.labelWidth = 120;
						// show captcha image
					}
					me.onCaptchaImageClick();
				},
				/**
				 * refresh the capthcha image
				 */
				onCaptchaImageClick : function() {
					var me = this, captchaImage = me.form.captchaImage;
					// if hidden，show it.
					if (captchaImage.isHidden()) {
						captchaImage.show();
						captchaImage.el.dom.title = t("login.form.captcha.image.title");
					}
					me.form.captcha.reset();
					// set url
					captchaImage.setSrc(captchaUrl + new Date().getTime());
				}
			});

			Ext.create("Maty.Login.Window").show();
		});
	});

}());