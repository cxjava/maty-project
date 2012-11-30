Ext.define('Ext.i18n.reader.Property', {
    extend: 'Ext.data.reader.Json',
    alias : 'reader.property',
	
	constructor: function(config){
		config = config || {};
		
		Ext.applyIf(config, {
	        idProperty: 'key',
	        successProperty: 'success',
	        totalProperty: 'total'
	    });
	
		this.callParent([config]);
	},
	
	getResponseData: function(response){
	    return this.readRecords(response);
	},
	

	getData: function(data){
        var records = [], record, kv,
			f = this.readLines(data),
			l = f.length;
		for(var i = 0; i < l; i++){
			var kl = f[i].search(/[\s:=]/);
				record = {
				    value : this.clearValueExtraChars(f[i].substring(kl+1)),
				    key  :  this.clearKeyExtraChars(f[i].substring(0, kl))
				};
				records[i] = record;
		}
		return records;
	},

	clearKeyExtraChars: function(s){
		return (s ? s.replace(/[:=]/gi, "") : "");
	},
	
	clearValueExtraChars: function(s){
		return (s ? s.replace(/\\\s*\n/gi, "") : "");
	},
	
	//private
	readLines: function(data){
		var file = data.responseText;
		return (file ? file.match(/.*(.*\\\s*\n)+.*|^((?!^\s*[#!]).).*$/gim) : []);
	}
	

});

Ext.define('Ext.i18n.model.Property', {
	extend: 'Ext.data.Model',
	
	idProperty: 'key',
	fields: ['key', 'value']
		

});

/**
 * @author Maximiliano Fierro
 * @class Ext.i18n.Bundle
 * @extends Ext.data.Store
 *
 * Bundle is used to load .properties bundle files based in language and expose the bundle's keys thru getMsg method.
 <code>
Ext.application({
	name: 'AppTest',
	launch: function(){

		bundle = Ext.create('Ext.i18n.Bundle',{
			bundle: 'Application',
			lang: 'es-ES',
			path: 'resources',
			noCache: false
		});

		bundle.onReady(function(){
			Ext.create('Ext.Panel',{
				fullscreen: true,
				html: bundle.getMsg('panel.html')
			});
		});
	}
});

 </code>
 */
Ext.define('Ext.i18n.Bundle', {
	extend: 'Ext.data.Store',
	/*requires: [
		'Ext.i18n.reader.Property',
		'Ext.i18n.model.Property'
	],*/
	
	//@private
	defaultLanguage: 'en-US',
	//@private
	resourceExt: '.properties',
	
	config:{
		/**
		 * @cfg bundle {String} bundle name for properties file. Default to message  
		 */
		bundle: 'message',

		/**
		 * @cfg path {String} URI to properties files. Default to resources
		 */
		path: 'resources'

		/**
		 * @cfg lang {String} Language in the form xx-YY where:
		 * 		xx: Language code (2 characters lowercase) 
    	 *      YY: Country code (2 characters upercase). 
		 * Optional. Default to browser's language. If it cannot be determined default to en-US.
		 */
		
		/**
		 * @cfg noCache {boolean} whether or not to disable Proxy's cache. Optional. Defaults to true. 
		 */
		
	},
	
	
	constructor: function(config){
		config = config || {};

		var me = this,
			language = me.formatLanguageCode(config.lang || me.guessLanguage()),
			noCache = (config.noCache !== false),
			url;

		me.language = language;
		me.bundle = config.bundle || me.bundle;
		me.path = config.path || me.path;
			
		url = this.buildURL(language);

		delete config.lang;
		delete config.noCache;
		
		Ext.applyIf(config, {
			autoLoad: true,
			model: 'Ext.i18n.model.Property',
			proxy:{
				type: 'ajax',
				url: url,
				noCache: noCache,
				reader: {
					type: 'property'
				},
				//avoid sending limit, start & group params to server
				getParams: Ext.emptyFn
			},
			listeners:{
				'load': this.onBundleLoad,
				scope: this
			}
		});

		me.callParent([config]);
		me.getProxy().on('exception', this.loadParent, this, {single: true});
	},
	
	/**
	 * @private
	 */
	guessLanguage: function(){
		return (navigator.language || navigator.browserLanguage
				|| navigator.userLanguage || this.defaultLanguage);
	},
	
	/**
	 * @method: getMsg
	 * Returns the content associated with the bundle key or {bundle key}.undefined if it is not specified.
	 * @param: key {String} Bundle key.
	 * @return: {String} The bundle key content. 
	 */
	getMsg : function(key) {
		var args = Ext.Array.toArray(arguments, 1), result;
		var rec = this.getById(key);
		result = rec ? Ext.util.Format.htmlDecode(rec.get('value')) : key + '.undefined';
		return result.replace(/\{(\d+)\}/g, function(m, i) {
			return args[i];
		});
	},
	
	/**
	 * @method: onReady The fn will be called when the Bundle file is loaded.
	 * @param: fn {Function}
	 */
	onReady: function(fn){
		this.readyFn = fn;
		this.on('loaded', this.readyFn, this);
	},
	
	/**
	 * @private
	 */
	onBundleLoad: function(store, record, success, op) {
		if(success){
			this.fireEvent('loaded');
		}
    },

	/**
	 * @private
	 */
	onProxyLoad: function(op){
		if(op.getRecords()){

			this.callParent(arguments);
		}
	},
	
	/**
	 * @private
	 */
	buildURL: function(language){
		var url = '';
		if (this.path) url+= this.path + '/';
		url+=this.bundle;
		if (language) url+= '_'+language;
		url+=this.resourceExt;
		return url;
	},
	
	/**
	 * @private
	 */
	loadParent: function(){
		this.getProxy().url = this.buildURL();
		this.load();			
	},
	
	/**
	 * @private
	 */
	formatLanguageCode: function(lang){
		var langCodes = lang.split('_');
		langCodes[0] = (langCodes[0]) ? langCodes[0].toLowerCase() : '';
		langCodes[1] = (langCodes[1]) ? langCodes[1].toUpperCase() : '';
		return langCodes.join('_');
	}
	
	
	
});