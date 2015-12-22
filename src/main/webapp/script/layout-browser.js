Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('Ext.ux', 'script/extjs/ux');

Ext.require([
    'Ext.tip.QuickTipManager',
    'Ext.container.Viewport',
    'Ext.layout.*',
    'Ext.form.Panel',
    'Ext.form.Label',
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.tree.*',
    'Ext.selection.*',
    'Ext.tab.Panel',
    'Ext.ux.layout.Center'  
]);

Ext.onReady(function(){
	Ext.tip.QuickTipManager.init();
	
	var detailEl;
	
	var layoutExamples=[];
	
	Ext.Object.each(getBasicLayouts(),function(name,example){
        layoutExamples.push(example);
    });

    Ext.Object.each(getCombinationLayouts(),function(name,example){
        layoutExamples.push(example);
    });

    Ext.Object.each(getCustomLayouts(),function(name,example){
        layoutExamples.push(example);
    });

    //中间模块
    var contentPanel={
        id:'content-panel',
        region:'center',
        layout:'card',
        margins:'2 5 5 0',
        activeItem:0,
        border:false,
        items:layoutExamples
    };

    //右边树菜单
    var store =Ext.create('Ext.data.TreeStore',{
        root:{
            expanded:true
        },
        autoLoad:true,
        proxy:{
            type:'ajax',
            url:'script/extjs/tree-data.json'
        }
    });

    var treePanel =Ext.create('Ext.tree.Panel',{
        id:'tree-panel',
        title:'Tree',
        region:'north',
        split:true,
        height:360,
        minSize:150,
        rootVisible:false,
        autoScroll:true,
        store:store
    });

    treePanel.getSelectionModel().on('select',function(selModel,record){
        if (record.get('leaf')) {
            Ext.Msg.alert("您的选择是",record.getId()+'-panel');
            Ext.getCmp('content-panel').layout.setActiveItem(record.getId()+'-panel');
            if (!detailEl) {
                var bd =Ext.getCmp('details-panel').body;
                bd.update('').setStyle('background','#fff');
                detailEl = bd.createChile();
            }
            detailEl.hide().update(Ext.getDom(record.getId()+'-details').innerHTML).slideIn('l',{stopAnimation:true,duration:200});
        }
    });

    var detailsPanel={
        id:'details-panel',
        title:'Details',
        region:'center',
        bodyStyle:'padding-bottom:15px;background:#eee;',
        autoScroll:true,
        html:'<p class="details-info">Test</p>'
    };

    var topPanel={
        id:'top-panel',
        title:'Top',
        region:'north',
        bodyStyle:'padding-bottom:15px;background:#eee;',
        autoScroll:true,
        html:'<p class="details-info">Test</p>'
    };

    Ext.create('Ext.Viewport',{
        layout:'border',
        title:'SQL Browser',
        items:[
        {
            xtype:'box',
            id:'header',
            region:'north',
            html:'<h1>SQL Browser</h1>',
            height:30
        },
        topPanel,
        {
            layout: 'border',
            id:'layout-browser',
            region:'west',
            border:false,
            split:true,
            margins:'2 0 5 5',
            width:290,
            minSize:100,
            maxSize:500,
            items:[treePanel,detailsPanel]
        },
            contentPanel

        ],
        renderTo:Ext.getBody()
    });
});
