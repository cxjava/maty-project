!(function() {
	language = Ext.create('Ext.i18n.Bundle', {
		bundle : 'messages',
		lang : language,
		path : 'resources/i18n',
		noCache : true
	});
	language.onReady(function() {
		Ext.application({
			name : 'AppTest',
			launch : function() {

				Ext.create('Ext.panel.Panel', {
					renderTo : Ext.getBody(),
					tbar : Ext.create('Ext.toolbar.Toolbar', {
						items : [ {
							text : language.getMsg('login.form.submit')
						} ]
					}),
					items : [ {
						height : 300,
						html : language.getMsg('login.page.title')
					} ],
				});
			}
		});
	});// end bundle on ready
})();
