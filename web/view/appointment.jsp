<%-- 
    Document   : appointment
    Created on : Mar 11, 2022, 11:33:28 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="getappointment" method="POST">
            <table border = "1px solid black">
                <tr>
                    <td>Họ và tên</td>
                    <td><input type="text" name="hname" /></td>
                </tr>
                <tr>
                    <td>Ngày Sinh</td>
                    <td><input type="date" name="hdob" /></td>
                </tr>
                <tr>
                    <td>Giới Tính</td>
                    <td>
                        <input type="radio" value="male" name="hgender"/> Nam 
                        <input type="radio" value="female" name="hgender"/> Nữ
                    </td>
                </tr>
                <tr>
                    <td>Địa Chỉ</td>
                    <td><input type="text" name="haddress" /></td>
                </tr>
                <tr>
                    <td>SĐT</td>
                    <td><input type="text" name="hphone" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Ghi Chú</td>
                    <td><input type="text" name="note" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
