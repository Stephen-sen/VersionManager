<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/common/tagslib.jsp" %>
<% 
	request.setAttribute("path",request.getContextPath());
	request.setAttribute("token",request.getSession().getAttribute("token"));
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/"; 
%>

<title>风扬科技版本管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />


<link rel="shortcut icon" href="${path}/themes/images/fy_favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${path}/themes/bootstrap_admin/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/themes/bootstrap_admin/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${path}/themes/bootstrap_admin/Css/style.css" />
<link rel="stylesheet" type="text/css" href="${path}/themes/css/main.css" />

<script type="text/javascript" src="${path}/themes/bootstrap_admin/Js/jquery.js"></script>
<script type="text/javascript" src="${path}/themes/bootstrap_admin/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="${path}/themes/bootstrap_admin/Js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/themes/bootstrap_admin/Js/ckform.js"></script>
<script type="text/javascript" src="${path}/themes/bootstrap_admin/Js/common.js"></script>
<script type="text/javascript" src="${path}/themes/js/jquery.cookie.js"></script>

<style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>