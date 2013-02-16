Ext.define('Ext.i18n.reader.Property', {
    extend: 'Ext.data.reader.Json',
    alias : 'reader.i18n.property',

    constructor: function(){
        var me = this,
            Model;

        me.callParent(arguments);
        Model = me.model;

        if(Model){
            // An Implicit Model is created when fields from store are used instead a model definition
            // This has some issues with ids in the model instance:
            // override idProperty since it is not using idProperty from this reader
            // override idgen getRecId method since it won't retrieve the idProp
            Ext.merge(Model.prototype, {
                idProperty: this.getIdProperty(),
                idgen:{
                    getRecId : function(rec){
                        return rec.internalId;
                    }
                }
            });
        }
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
Ext.define('Ext.i18n.reader.Json', {
    extend: 'Ext.data.reader.Json',
    alias : 'reader.i18n.json',

    constructor: function(){
        var me = this,
            Model;

        me.callParent(arguments);
        Model = me.model;

        if(Model){
            // An Implicit Model is created when fields from store are used instead a model definition
            // This has some issues with ids in the model instance:
            // override idProperty since it is not using idProperty from this reader
            // override idgen getRecId method since it won't retrieve the idProp
            Ext.merge(Model.prototype, {
                idProperty: this.getIdProperty(),
                idgen:{
                    getRecId : function(rec){
                        return rec.internalId;
                    }
                }
            });
        }
    },


    extractData: function(root){
       var me = this,
            records = [],
            Model   = me.model,
            length  = root.length,
            keys, key, parts, value,
            convertedValues, node, record, i;
            
        if (!root.length && Ext.isObject(root)) {
            keys = me.getKeys(root);
            length = keys.length;
        }

        for (i = 0; i < length; i++) {
            key = keys[i];
            parts = key.split('.');

            for(j = 0, value = root; j < parts.length; j++){
                value = value[parts[j]];
            }

            node = {key: key, value: value};

            record = new Model(undefined, me.getId(node), node, convertedValues = {});

            // // If the server did not include an id in the response data, the Model constructor will mark the record as phantom.
            // // We  need to set phantom to false here because records created from a server response using a reader by definition are not phantom records.
            record.phantom = false;

            // // Use generated function to extract all fields at once
            me.convertRecordData(convertedValues, node, record);

            records.push(record);
        }

        return records;
    },


    getKeys: function (obj, parent) {
        var me = this, key, keys = [];

        function traverse(obj, parent){
            var path = (parent || ''), key;
            for (key in obj){
                if(obj.hasOwnProperty(key)){
                    path = (path ? path + '.' : '') + key;

                    if(Ext.isObject(obj[key])){
                       path = traverse(obj[key], path);
                    }
                    return path;
                }
            }
        }

        for (key in obj) {
            if (obj.hasOwnProperty(key)) {
                if(Ext.isObject(obj[key])){
                    keys.push(traverse(obj[key], key));
                }else{
                    keys.push(key);
                }
                
            }
        }
        return keys;
    }




});
/**
 * @author Maximiliano Fierro
 * @class Ext.i18n.Bundle
 * @extends Ext.data.Store
 *
 * Bundle is used to load .properties bundle files based in language and expose the bundle's keys thru getMsg method.
 

        Ext.application({
            name: 'AppTest',
            requires: ['Ext.i18n.Bundle'],

            bundle: {
                bundle: 'Application',
                lang: 'en-US',
                path: 'resources',
                noCache: true
            },

            launch: function(){
                Ext.create('Ext.panel.Panel',{
                    renderTo: Ext.getBody(),
                    tbar: Ext.create('Ext.toolbar.Toolbar',{
                        items: [{text: 'text'}]
                    }),
                    items:[{
                        height: 300,
                        html: this.bundle.getMsg('panel.html')
                    }],
                });
            }
        });

 */
Ext.define('Ext.i18n.Bundle', {
	extend: 'Ext.data.Store',
	// modify by cx
	/* requires: [
        'Ext.app.Application',
		'Ext.i18n.reader.Property',
        'Ext.i18n.reader.Json'

        // 'Ext.String'
	],*/// modify by cx

	//@private
	defaultLanguage: 'en-US',

	config: {
        autoLoad: false,
        fields: ['key', 'value'],

		/**
		 * @cfg bundle {String} bundle name for properties file. Default to message
		 */
		bundle: 'message',

        format : 'property',
		/**
		 * @cfg path {String} URI to properties files. Default to resources
		 */
		path: 'resources'

		/**
		 * @cfg lang {String} Language in the form xx-YY where:
		 *		xx: Language code (2 characters lowercase)
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
        me.format = config.format || me.format;

		url = this.buildURL(language);

		delete config.lang;
		delete config.noCache;
		
		Ext.applyIf(config, {
			proxy:{
				type: 'ajax',
				url: url,
				noCache: noCache,
				reader: {
					type: 'i18n.'+ me.format,
                    idProperty: 'key'
				},
				//avoid sending limit, start & group params to server
				getParams: Ext.emptyFn
			}
		});

		me.callParent([config]);

		me.on('load', me.onBundleLoad, me);
        me.getProxy().on('exception', me.loadParent, me, {single: me});
		// modify by cx
		var oldT = window.t;
		me.noConflict = function() {
			window.t = oldT;
			return me.getMsg;
		};
    	//
		window.lang=me;
		//show function name ,like https://github.com/js-coder/x18n
		window.t=me.getMsg;
		// modify by cx
	},
	
	/**
	 * @private
	 */
	guessLanguage: function(){
		return (navigator.language || navigator.browserLanguage || navigator.userLanguage || this.defaultLanguage);
	},
	
	/**
	 * @method: getMsg
	 * Returns the content associated with the bundle key or {bundle key}.undefined if it is not specified.
	 * @param: key {String} Bundle key.
     * @param: values {Mixed...} if the bundle key contains any placeholder then you can add any number of values
     * that will be replaced in the placeholder token.
	 * @return: {String} The bundle key content.
	 */
	getMsg: function(key /*values...*/){
        var values = [].splice.call(arguments, 1),
            rec = lang.getById(key),
            decoded = key + '.undefined',
            args;
	
        if(rec){
            decoded = Ext.util.Format.htmlDecode(rec.get('value'));
            
            if(values){
                args = [decoded].concat(values);
                decoded = Ext.String.format.apply(null, args);
            }
        }

        return decoded;
	},
	/**
	 * @method: onReady The fn will be called when the Bundle file is loaded.
	 * @param: fn {Function}
	 */
	onReady: function(fn){
		var me = this;
		me.readyFn = fn;
		me.on('loaded', me.readyFn, me);
	},
	/**
	 * @private
	 */
	onBundleLoad: function(store, records, success, op) {
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
	

    getResourceExtension: function(){
        return this.format === 'property' ? '.properties' : '.json';
    },

	/**
	 * @private
	 */
	buildURL: function(language){
		var me=this, url = '';
		if (me.path) url+= me.path + '/';
		url+=me.bundle;
		if (language) url+= '_'+language;
		url+=me.getResourceExtension();
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
		var langCodes = lang.split('_'),
            primary, second;
		primary = (langCodes[0]) ? langCodes[0].toLowerCase() : '';
		second = (langCodes[1]) ? langCodes[1].toUpperCase() : '';
	
        return langCodes.length > 1 ? [primary, second].join('_') : primary;
	}

	
}, function(){
    //initialize bundle before app launch
	Ext.override(Ext.app.Application, {
        onBeforeLaunch: function() {
            var me = this,
                overridden = this.onBeforeLaunch.$previous,
                ns;

            //this is solved on 4.1.2
            ns = Ext.namespace(me.name);
            if (ns) {
                ns.getApplication = function() {
                    return me;
                };
            }

            if(me.bundle){
                //configure the bundle instance and defer launch until bundle launch
                me.bundle = Ext.create('Ext.i18n.Bundle', Ext.apply({
                    autoLoad: true,
                    listeners: {
                        loaded: function(){
                            overridden.apply(me);
                        }
                    }
                }, me.bundle));
        }else{
                me.callOverridden();
            }
        }
    });
});