<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理guitars</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/easyui.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/icon.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/demo.css" />
    <script src="<%=request.getContextPath()%>/js/eajquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
</head>
<body>
<center>
管理guitars<br /><br />
<div class="catbox">
	<table id="resultTable" border=2>
		<thead>
			<tr>
				<th>serialNumber</th>
				<th>price</th>
				<th>builder</th>
				<th>model</th>
				<th>type</th>
				<th>numStrings</th>
				<th>backWood</th>
				<th>topWood</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#session.AllGuitarList" id="guitar">
			<tr>
				<td class="serialNumber"><s:property value="#guitar.serialNumber"/></td>
				<td class="price"><s:property value="#guitar.price"/></td>
				<td class="builder"><s:property value="#guitar.spec.builder"/></td>
				<td class="model"><s:property value='#guitar.spec.model'/></td>
				<td class="type"><s:property value="#guitar.spec.type"/></td>
				<td class="numStrings"><s:property value="#guitar.spec.numStrings"/></td>
				<td class="backwWood"><s:property value="#guitar.spec.backWood"/></td>
				<td class="topWood"><s:property value="#guitar.spec.topWood"/></td>
				<td class="delete"><a href="deleteGuitar?serialNumber=<s:property value='#guitar.serialNumber'/>">delete</a></td>
			</tr>

			</s:iterator>
		</tbody>
	</table>
</div>
<br /><br /><br />
<a id="addbtn" class="easyui-linkbutton">添加guitar</a>	
	<div id="addwin">
	添加一个新的guitar，请输入其信息：
		<form id="addform" method="post" enctype="multipart/form-data" action="addGuitar.action">
		<br /><br />
			<div>
				<label for="serialNumber">serialNumber：</label>
				<input id="serialNumber" name="serialNumber"/>
			</div><br />
			<div>
				<label for="price">price：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="price" name="price"/>
			</div><br />
			<div>
				<label for="builder">builder：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="builder" name="builder"/>
			</div><br />
			<div>
				<label for="model">model：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="model" name="model"/>
			</div><br />
			<div>
				<label for="type">type：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="type" name="type"/>
			</div><br />
			<div>
				<label for="numStrings">numStrings：&nbsp;&nbsp;</label>
				<input id="numStrings" name="numStrings"/>
			</div><br />
			<div>
				<label for="backWood">backWood：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="backWood" name="backWood"/>
			</div><br />
			<div>
				<label for="topWood">topWood：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input id="topWood" name="topWood"/>
			</div><br />

			<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="save()">添加</a> 
    		<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a> 
		</form>
		
	</div>		
<script type="text/javascript">
$(function(){
	$('#addbtn').linkbutton({
		onClick:function(){
			$('#addwin').window('open');
		}
	});

	$('#addwin').window({
		width:300,
		title:'添加guitar',
		collapsible:true,
		minimizable:true,
	    maximizable:false, 
	    closable:true,
	    draggable:true,
	    closed:true
		
	});
    $('#btnCancel').click(function(){
    	$('#addwin').window('close');
	});	

})
function save(){
	$('#addform').form('submit',{
		url:'addGuitar.action',
		success: function(){
				$('#addwin').window('close');				
				alert("添加成功！")
		}
	});
};


</script>

</center>
</body>
</html>