<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/tagslib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">    
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
	<c:if test='${pagedDate.totalPageCount<1}'>
		<div class="no-data-div">没有查询到数据！</div>
	</c:if>
	<c:if test='${pagedDate.totalPageCount>0}'>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>序号${pageResult.totalCount}</th>
					<th>用户姓名</th>
					<th>性别</th>
					<th>联系电话</th>
					<th>创建时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${pagedDate.result}" varStatus="s">
				<tr>
					<td>${pagedDate.start+s.index+1 }</td>
					<td>${item.userName}</td>
					<td>${item.sex}</td>
					<td>${item.phoneNum}</td>
					<td>${item.updateDate}</td>
					<td><c:if test="${item.status == 0}">禁用</c:if> <c:if
							test="${item.status == 1}">启用</c:if></td>
					<td><a href="${path }/userController/find.do?id=${item.id}"
						class="btn btn-xs btn-primary">修改</a> <a
						href="${path }/userController/deleteUser.do?id=${item.id}"
						class="btn btn-xs btn-primary">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<t:PageBar pageUrl="${path}/userController/userList.do" pageAttrKey="pagedDate"/>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="${path}/userController/view.do";
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