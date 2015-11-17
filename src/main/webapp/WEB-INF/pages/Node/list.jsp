<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/tagslib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">  
    机构名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增机构</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>机构编号</th>
        <th>机构名称</th>
        <th>状态</th>
        <th>管理操作</th>
    </tr>
    </thead>
	     <tr>
            <td>5</td>
            <td>管理员</td>
            <td>1</td>
            <td>
                  <a href="edit.html">编辑</a>
                  
            </td>
        </tr></table>
<div class="inline pull-right page">
         10122 条记录 1/507 页  <a href='#'>下一页</a>     <span class='current'>1</span><a href='#'>2</a><a href='/chinapost/index.php?m=Label&a=index&p=3'>3</a><a href='#'>4</a><a href='#'>5</a>  <a href='#' >下5页</a> <a href='#' >最后一页</a>    </div>
</body>
</html>
<script>
    $(function () {
        
		$('#addnew').click(function(){

				window.location.href="add.html";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>