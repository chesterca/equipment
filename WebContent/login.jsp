<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/font.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/layout.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/themes.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/ajaxFunction.js"></script>
<title>登录</title>
<style>
body {
	margin: 0;
	padding: 0;
}

.top_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/thime2.jpg")
		no-repeat;
	background-size: 100% 75px;
	overflow: hidden;
}

.image_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/timg3.jpg")
		no-repeat;
	background-size: 100% 300px;
	overflow: hidden;
	text-align: center;
}

.floor_theme {
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/thime2.jpg")
		no-repeat;
	background-size: 100% 75px;
	overflow: hidden;
	text-align: center;
}
.login_theme{
text-align: center;
background-color: white;
}

.login_theme1{
    margin:0 auto;
    border:2px solid #fda100;
    border-radius:5px;
    text-align: left;
    padding-left: 10px;
}
.button_theme{
    background-color: #ff9900;
    border-radius:5px;
    margin:0 auto;
    border: 0px;
}

</style>
</head>
<script type="text/javascript">
  $(document).ready(function(){
   $("#buttonid").click(function(){
        var username=$("#username").val();
        if(username==null||username==""){
            alert("用户名不能为空");
             return;
            }
        var password=$("#password").val();
        if(password==null||password==""){
            alert("密码不能为空");
             return;
            }
        var paremter={
                action:"login",
                msg:username+","+password
                }
         var address='${pageContext.request.contextPath}/login.do';
        var type='post';
        var jsondata=JSON.stringify(paremter);
        var callbackfunction = function (resdata) {
            if (resdata.result_signal != "ok") {
                alert(resdata.result);
            } else {
                window.location.href = "${pageContext.request.contextPath}/function.do";
            }
        };
        useajax(address, type, jsondata, callbackfunction);
	   });


	  });

</script>
<body style="width: 100%; height: 100%;">

	<div class="top_layout top_theme">
		<label class="top_font" style="margin-left: 70px">SmartFactory</label>
	</div>
	<div class="image_lyaout image_theme">
		<label class="title-font">TE设备管理系统</label>
	</div>
	<div class="login_theme">
		     <div style="margin-top: 1px"></div>
			<div class="login_themes">
				<input id="username" type="text" class="login_layout login_theme1 login_font" name="username"
					placeholder="用户名(sfis的用户)" />
			</div>
			<div style="margin-top: 13px"></div>
			<div class=" login_themes">
				<input id ="password" type="password" class="login_layout login_theme1 login_font " name="password"
					placeholder="密码" />
			</div>
			<div style="margin-top: 24px;"></div>
			<div>
				<input id="buttonid" type="button" class="login_layout button_theme button_font" value="登录">
			</div>
	</div>
	<div class="floor_theme">
		<label class="floor_font">版权所有：上海斐讯数据通信有限公司</label>
	</div>
</body>
</html>