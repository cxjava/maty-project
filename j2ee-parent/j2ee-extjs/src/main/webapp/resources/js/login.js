/*Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'Ext.i18n' : 'resources/libs/extjs-i18n'
	}
});*/
//Ext.require('Ext.i18n.Bundle', function() {
	// create global bundle in here
	language = Ext.create('Ext.i18n.Bundle', {
		bundle : 'messages',
		lang : language,
		path : 'resources/i18n',
		noCache : true
	});
//});
Ext.application({
	name : 'AppTest',
	launch : function() {

		language.onReady(function() {
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
		});// end bundle on ready
	}
});
console.log(new Date());
