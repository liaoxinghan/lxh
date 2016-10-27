<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<base href="${path}">
<meta charset="UTF-8">
<title>Basic Panel - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/icon.css">
<script type="text/javascript" src="js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>
<body>
	<div id="baseContent" class="easyui-panel" style="width:99%;height:900px;padding:10px;" data-options="">
		<a href="#" class="easyui-linkbutton" style="float:right" data-options="plain:true">Home</a>
		<a href="#" class="easyui-menubutton" style="float:right" data-options="iconCls:'icon-edit'">Edit</a>
		<a href="#" class="easyui-menubutton" style="float:right" data-options="iconCls:'icon-help'">Help</a>
		<a href="#" class="easyui-menubutton" style="float:right" data-options="">About</a>
		<div class="easyui-layout" data-options="fit:true">
			<div id="left-content" data-options="region:'west',split:true" title="menu" style="width:15%;height:100%">
				<!-- <div class="easyui-accordion" data-options="border:false,onSelect:addTab,selected:-1">
					<div title="Title1" style="padding:10px;">content1</div>
					<div title="Title2" style="padding:10px;">content2</div>
					<div title="Title3" style="padding:10px">content3</div>
				</div> -->
				<ul id="menuTree"></ul>
			</div>
			<div id="right-content" data-options="region:'center',border:false">
				<div id="tabs" class="easyui-tabs" style="height:100%">
					<div title="HomePage" style="padding:10px">
						<div class="easyui-calendar" style="width:250px;height:250px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="mm" class="easyui-menu" data-options="hideOnUnhover:false" style="width:100px;height:100px;">
		<div>New</div>
		<div>
			<span>Open</span>
			<div style="width:150px;">
				<div>
					<b>Word</b>
				</div>
				<div>Excel</div>
				<div>PowerPoint</div>
			</div>
		</div>
		<div data-options="iconCls:'icon-save'">Save</div>
		<div class="menu-sep"></div>
		<div>Exit</div>
	</div>
</body>
<script type="text/javascript">
	function invoke(url,dataType,param,callback) {
		$.ajax({
			type : "POST",
			url : url,
			data : param,
			dataType : dataType,
			success : function(data) {
				if(dataType == "html"){
					callback(data);
				}else if(dataType == "json"){
					if(data.code == "200"){
						callback(data.content);
					}
				};
			}
		});
	}

	function addTab(url,title) {
		//alert(title+" index " + index);
		var mainTabs = $('#tabs');
		if (mainTabs.tabs('exists', title)) {
			mainTabs.tabs('select', title);
		} else {
			mainTabs.tabs('add', {
				href : url, 
				title : title,
				closable : true,
				tools : [ {
					iconCls : 'icon-mini-refresh',
					handler : function() {
						var target = mainTabs.tabs('getTab',title);
						if(target == mainTabs.tabs('getSelected')){
							target.panel('refresh');
						}
					}
				} ]
			});

		}
	}
	function tabSelect(title, index) {

	}

	function refresh() {
		var mainTabs = $("#tabs");
		mainTabs.tabs('select', 0);
		var tabs = mainTabs.tabs('tabs');
		var titles = [];
		$.each(tabs, function() {
			var options = $(this).panel('options');
			if (options.closable) {
				titles.push(options.title);//tabs是一个arrayList
			}

		});
		for ( var i = 0; i < titles.length; i++) {
			mainTabs.tabs('close', titles[i]);
		}
	}
	$(function() {
		/* var mainMenuX = $("#left-content").offset().left;
		var mainMenuY = $("#left-content").offset().top;
		$('#mm').menu('show', {
			left : mainMenuX,
			top : mainMenuY
		}); */
		$("#tabs").tabs({
			onSelect : tabSelect,
			tabWidth : 112,
			tools : [ {
				iconCls : 'icon-reload',
				handler : refresh

			} ]
		});
		var menuData = [ {
			"id" : 1,
			"text" : "Folder1",
			"iconCls" : "icon-save",
			"children" : [ {
				"id" : 1,
				"url" : "people/to",
				"text" : "File1",
				"checked" : true
			}, {
				"text" : "Books",
				"state" : "open",
				"attributes" : {
					"url" : "view/index",
					"price" : 100
				},
				"children" : [ {
					"url"  : "view/people?id=1",
					"text" : "PhotoShop",
					"checked" : true
				}, {
					"id" : 8,
					"text" : "Sub Bookds",
					"state" : "closed"
				} ]
			} ]
		}, {
			"text" : "Languages",
			"state" : "closed",
			"children" : [ {
				"text" : "Java"
			}, {
				"text" : "C#"
			} ]
		} ];
		$('#menuTree').tree({
			data : menuData,
			onClick : function(node) {
				if ($('#menuTree').tree('isLeaf', node.target)) {
					var param = {
						id : node.id
					};
					var path = "${path}" + node.url;
					addTab(path,node.text);
				};
			}
		});
	});
</script>

</html>
