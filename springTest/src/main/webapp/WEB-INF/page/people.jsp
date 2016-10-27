<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<h2>${errorMsg }</h2>

<table id="peopleTable">
	<thead>
		<tr>
			<th data-options="field:'id',width:100">id</th>
			<th data-options="field:'name',width:100">name</th>
			<th data-options="field:'age',width:100">age</th>
			<th data-options="field:'phone',width:100">phone</th>
		</tr>
	</thead>
</table>

<div id="tb" style="padding:5px;height:auto">
	<div>
		<span>name:</span>
		<input name="name" style="line-height:26px;border:1px solid #ccc">
		<span>ageStart:</span>
		<input name="ageStart" style="line-height:26px;border:1px solid #ccc">
		<span>ageEnd:</span>
		<input name="ageEnd" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:;" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#peopleTable').datagrid({
			singleSelect : true,
			fitColumns : true,
			pagination : true,
			autoRowHeight : false,
			pageList : [ 10, 20, 30, 40, 50 ],
			url : "${path}" + "people/get",
			toolbar : '#tb'
		});

		var pager = $('#peopleTable').datagrid('getPager');
		pager.pagination({
			onSelectPage : function(pageNum, pageSize) {
				var opts = $('#peopleTable').datagrid('options');
				opts.pageNumber = pageNum;
				opts.pageSize = pageSize;
				pager.pagination('refresh', {
					pageNumber : pageNum,
					pageSize : pageSize
				});
				var param = getSearch();				
				param["page"] = pageNum;
				param["rows"] = pageSize;
				$.ajax({
					type : "POST",
					url : "${path}" + "people/get",
					data : param,
					dataType : "json",
					success : function(data) {
						$('#peopleTable').datagrid('loadData', data);
					}
				});

			}
		});
	});

	function getSearch() {
		var param = {};
		$("#tb").find("input").each(function() {
			if (Boolean($(this).val())) {
				param[this.name] = $(this).val();
			}
			;
		});
		return param;
	}

	function doSearch() {
		$('#peopleTable').datagrid('load', getSearch());
	}
</script>