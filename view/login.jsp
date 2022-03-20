<%-- 
    Document   : login
    Created on : Mar 6, 2022, 11:08:06 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="css/LoginBackground.css" type="text/css">
    </head>
    <body>
        <div class="header">
            <div class="balance-back">
                <a href="index.html">Back</a>
            </div>
        </div>
        <div class="login-img">
            <img
                src="image\medical-staff-women-reception-hospital-flat-style-vector-illustration-cartoon-character-151282063.jpg" />
        </div>
        <div class="login-form">
            <img src="image\logo1.png"/>
            <div>Đăng nhập để vào hệ thống</div>
            <form method="Post" action="login" border="1px solid black">
                Tài Khoản: <input type="text" name="username"/> <br><br>
                Mật Khẩu: <input type="password" name="password"/> <br><br>
                <input type="submit" value="Đăng Nhập"/>
            </form>
        </div> 
    </body>
</html>
