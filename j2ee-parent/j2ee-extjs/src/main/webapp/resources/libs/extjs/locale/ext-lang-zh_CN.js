/**
 * Simplified Chinese translation
 * By DavidHu
 * 09 April 2007
 *
 * update by andy_ghg
 * 2009-10-22 15:00:57
 */Ext.onReady(function(){var e=Ext.ClassManager,t=Ext.Function.bind(e.get,e),n;Ext.Updater&&(Ext.Updater.defaults.indicatorText='<div class="loading-indicator">\u52a0\u8f7d\u4e2d...</div>'),Ext.define("Ext.locale.zh_CN.view.View",{override:"Ext.view.View",emptyText:""}),Ext.define("Ext.locale.zh_CN.grid.Panel",{override:"Ext.grid.Panel",ddText:"\u9009\u62e9\u4e86 {0} \u884c"}),Ext.define("Ext.locale.zh_CN.TabPanelItem",{override:"Ext.TabPanelItem",closeText:"\u5173\u95ed\u6b64\u6807\u7b7e"}),Ext.define("Ext.locale.zh_CN.form.field.Base",{override:"Ext.form.field.Base",invalidText:"\u8f93\u5165\u503c\u975e\u6cd5"}),Ext.define("Ext.locale.zh_CN.view.AbstractView",{override:"Ext.view.AbstractView",msg:"\u8bfb\u53d6\u4e2d..."}),Ext.Date&&(Ext.Date.monthNames=["\u4e00\u6708","\u4e8c\u6708","\u4e09\u6708","\u56db\u6708","\u4e94\u6708","\u516d\u6708","\u4e03\u6708","\u516b\u6708","\u4e5d\u6708","\u5341\u6708","\u5341\u4e00\u6708","\u5341\u4e8c\u6708"],Ext.Date.dayNames=["\u661f\u671f\u65e5","\u661f\u671f\u4e00","\u661f\u671f\u4e8c","\u661f\u671f\u4e09","\u661f\u671f\u56db","\u661f\u671f\u4e94","\u661f\u671f\u516d"],Ext.Date.formatCodes.a="(this.getHours() < 12 ? '\u4e0a\u5348' : '\u4e0b\u5348')",Ext.Date.formatCodes.A="(this.getHours() < 12 ? '\u4e0a\u5348' : '\u4e0b\u5348')",n={g:1,c:"if (/(\u4e0a\u5348)/i.test(results[{0}])) {\nif (!h || h == 12) { h = 0; }\n} else { if (!h || h < 12) { h = (h || 0) + 12; }}",s:"(\u4e0a\u5348|\u4e0b\u5348)",calcAtEnd:!0},Ext.Date.parseCodes.a=Ext.Date.parseCodes.A=n),Ext.MessageBox&&(Ext.MessageBox.buttonText={ok:"\u786e\u5b9a",cancel:"\u53d6\u6d88",yes:"\u662f",no:"\u5426"}),t("Ext.util.Format")&&Ext.apply(Ext.util.Format,{thousandSeparator:",",decimalSeparator:".",currencySign:"\u00a5",dateFormat:"y\u5e74m\u6708d\u65e5"}),Ext.define("Ext.locale.zh_CN.picker.Date",{override:"Ext.picker.Date",todayText:"\u4eca\u5929",minText:"\u65e5\u671f\u5fc5\u987b\u5927\u4e8e\u6700\u5c0f\u5141\u8bb8\u65e5\u671f",maxText:"\u65e5\u671f\u5fc5\u987b\u5c0f\u4e8e\u6700\u5927\u5141\u8bb8\u65e5\u671f",disabledDaysText:"",disabledDatesText:"",monthNames:Ext.Date.monthNames,dayNames:Ext.Date.dayNames,nextText:"\u4e0b\u4e2a\u6708 (Ctrl+Right)",prevText:"\u4e0a\u4e2a\u6708 (Ctrl+Left)",monthYearText:"\u9009\u62e9\u4e00\u4e2a\u6708 (Control+Up/Down \u6765\u6539\u53d8\u5e74\u4efd)",todayTip:"{0} (\u7a7a\u683c\u952e\u9009\u62e9)",format:"y\u5e74m\u6708d\u65e5",ariaTitle:"{0}",ariaTitleDateFormat:"Y\u5e74m\u6708d\u65e5",longDayFormat:"Y\u5e74m\u6708d\u65e5",monthYearFormat:"Y\u5e74m\u6708",getDayInitial:function(e){return e.substr(e.length-1)}}),Ext.define("Ext.locale.zh_CN.picker.Month",{override:"Ext.picker.Month",okText:"\u786e\u5b9a",cancelText:"\u53d6\u6d88"}),Ext.define("Ext.locale.zh_CN.toolbar.Paging",{override:"Ext.PagingToolbar",beforePageText:"\u7b2c",afterPageText:"\u9875,\u5171 {0} \u9875",firstText:"\u7b2c\u4e00\u9875",prevText:"\u4e0a\u4e00\u9875",nextText:"\u4e0b\u4e00\u9875",lastText:"\u6700\u540e\u9875",refreshText:"\u5237\u65b0",displayMsg:"\u663e\u793a {0} - {1}\u6761\uff0c\u5171 {2} \u6761",emptyMsg:"\u6ca1\u6709\u6570\u636e"}),Ext.define("Ext.locale.zh_CN.form.field.Text",{override:"Ext.form.field.Text",minLengthText:"\u8be5\u8f93\u5165\u9879\u7684\u6700\u5c0f\u957f\u5ea6\u662f {0} \u4e2a\u5b57\u7b26",maxLengthText:"\u8be5\u8f93\u5165\u9879\u7684\u6700\u5927\u957f\u5ea6\u662f {0} \u4e2a\u5b57\u7b26",blankText:"\u8be5\u8f93\u5165\u9879\u4e3a\u5fc5\u8f93\u9879",regexText:"",emptyText:null}),Ext.define("Ext.locale.zh_CN.form.field.Number",{override:"Ext.form.field.Number",minText:"\u8be5\u8f93\u5165\u9879\u7684\u6700\u5c0f\u503c\u662f {0}",maxText:"\u8be5\u8f93\u5165\u9879\u7684\u6700\u5927\u503c\u662f {0}",nanText:"{0} \u4e0d\u662f\u6709\u6548\u6570\u503c"}),Ext.define("Ext.locale.zh_CN.form.field.Date",{override:"Ext.form.field.Date",disabledDaysText:"\u7981\u7528",disabledDatesText:"\u7981\u7528",minText:"\u8be5\u8f93\u5165\u9879\u7684\u65e5\u671f\u5fc5\u987b\u5728 {0} \u4e4b\u540e",maxText:"\u8be5\u8f93\u5165\u9879\u7684\u65e5\u671f\u5fc5\u987b\u5728 {0} \u4e4b\u524d",invalidText:"{0} \u662f\u65e0\u6548\u7684\u65e5\u671f - \u5fc5\u987b\u7b26\u5408\u683c\u5f0f\uff1a {1}",format:"y\u5e74m\u6708d\u65e5"}),Ext.define("Ext.locale.zh_CN.form.field.ComboBox",{override:"Ext.form.field.ComboBox",valueNotFoundText:undefined},function(){Ext.apply(Ext.form.field.ComboBox.prototype.defaultListConfig,{loadingText:"\u52a0\u8f7d\u4e2d..."})}),t("Ext.form.field.VTypes")&&Ext.apply(Ext.form.field.VTypes,{emailText:'\u8be5\u8f93\u5165\u9879\u5fc5\u987b\u662f\u7535\u5b50\u90ae\u4ef6\u5730\u5740\uff0c\u683c\u5f0f\u5982\uff1a "user@example.com"',urlText:'\u8be5\u8f93\u5165\u9879\u5fc5\u987b\u662fURL\u5730\u5740\uff0c\u683c\u5f0f\u5982\uff1a "http://www.example.com"',alphaText:"\u8be5\u8f93\u5165\u9879\u53ea\u80fd\u5305\u542b\u534a\u89d2\u5b57\u6bcd\u548c_",alphanumText:"\u8be5\u8f93\u5165\u9879\u53ea\u80fd\u5305\u542b\u534a\u89d2\u5b57\u6bcd,\u6570\u5b57\u548c_"}),Ext.define("Ext.locale.zh_CN.form.field.HtmlEditor",{override:"Ext.form.field.HtmlEditor",createLinkText:"\u6dfb\u52a0\u8d85\u7ea7\u94fe\u63a5:"},function(){Ext.apply(Ext.form.field.HtmlEditor.prototype,{buttonTips:{bold:{title:"\u7c97\u4f53 (Ctrl+B)",text:"\u5c06\u9009\u4e2d\u7684\u6587\u5b57\u8bbe\u7f6e\u4e3a\u7c97\u4f53",cls:Ext.baseCSSPrefix+"html-editor-tip"},italic:{title:"\u659c\u4f53 (Ctrl+I)",text:"\u5c06\u9009\u4e2d\u7684\u6587\u5b57\u8bbe\u7f6e\u4e3a\u659c\u4f53",cls:Ext.baseCSSPrefix+"html-editor-tip"},underline:{title:"\u4e0b\u5212\u7ebf (Ctrl+U)",text:"\u7ed9\u6240\u9009\u6587\u5b57\u52a0\u4e0b\u5212\u7ebf",cls:Ext.baseCSSPrefix+"html-editor-tip"},increasefontsize:{title:"\u589e\u5927\u5b57\u4f53",text:"\u589e\u5927\u5b57\u53f7",cls:Ext.baseCSSPrefix+"html-editor-tip"},decreasefontsize:{title:"\u7f29\u5c0f\u5b57\u4f53",text:"\u51cf\u5c0f\u5b57\u53f7",cls:Ext.baseCSSPrefix+"html-editor-tip"},backcolor:{title:"\u4ee5\u4e0d\u540c\u989c\u8272\u7a81\u51fa\u663e\u793a\u6587\u672c",text:"\u4f7f\u6587\u5b57\u770b\u4e0a\u53bb\u50cf\u662f\u7528\u8367\u5149\u7b14\u505a\u4e86\u6807\u8bb0\u4e00\u6837",cls:Ext.baseCSSPrefix+"html-editor-tip"},forecolor:{title:"\u5b57\u4f53\u989c\u8272",text:"\u66f4\u6539\u5b57\u4f53\u989c\u8272",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyleft:{title:"\u5de6\u5bf9\u9f50",text:"\u5c06\u6587\u5b57\u5de6\u5bf9\u9f50",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifycenter:{title:"\u5c45\u4e2d",text:"\u5c06\u6587\u5b57\u5c45\u4e2d\u5bf9\u9f50",cls:Ext.baseCSSPrefix+"html-editor-tip"},justifyright:{title:"\u53f3\u5bf9\u9f50",text:"\u5c06\u6587\u5b57\u53f3\u5bf9\u9f50",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertunorderedlist:{title:"\u9879\u76ee\u7b26\u53f7",text:"\u5f00\u59cb\u521b\u5efa\u9879\u76ee\u7b26\u53f7\u5217\u8868",cls:Ext.baseCSSPrefix+"html-editor-tip"},insertorderedlist:{title:"\u7f16\u53f7",text:"\u5f00\u59cb\u521b\u5efa\u7f16\u53f7\u5217\u8868",cls:Ext.baseCSSPrefix+"html-editor-tip"},createlink:{title:"\u8f6c\u6210\u8d85\u7ea7\u94fe\u63a5",text:"\u5c06\u6240\u9009\u6587\u672c\u8f6c\u6362\u6210\u8d85\u7ea7\u94fe\u63a5",cls:Ext.baseCSSPrefix+"html-editor-tip"},sourceedit:{title:"\u4ee3\u7801\u89c6\u56fe",text:"\u4ee5\u4ee3\u7801\u7684\u5f62\u5f0f\u5c55\u73b0\u6587\u672c",cls:Ext.baseCSSPrefix+"html-editor-tip"}}})}),Ext.define("Ext.locale.zh_CN.grid.header.Container",{override:"Ext.grid.header.Container",sortAscText:"\u6b63\u5e8f",sortDescText:"\u5012\u5e8f",lockText:"\u9501\u5b9a\u5217",unlockText:"\u89e3\u9664\u9501\u5b9a",columnsText:"\u5217"}),Ext.define("Ext.locale.zh_CN.grid.PropertyColumnModel",{override:"Ext.grid.PropertyColumnModel",nameText:"\u540d\u79f0",valueText:"\u503c",dateFormat:"y\u5e74m\u6708d\u65e5"})});