<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/tagslib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<body>
<form action="${path }/userController/saveUser.do" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="userName"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="passWord"/></td>
    </tr>
    <tr>
        <td class="tableleft">性别</td>
        <td><input type="text" name="sex"/></td>
    </tr>
    <tr>
        <td class="tableleft">电话</td>
        <td><input type="text" name="phoneNum"/></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td>
            <input type="radio" name="status" value="1" checked/> 启用
           <input type="radio" name="status" value="0"/> 禁用
        </td>
    </tr>
    <tr>
        <td class="tableleft">角色</td>
        <td>{$role_checkbox}</td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${path}/userController/userList.do";
		 });

    });
</script>