<%-- 
    Document   : addequip
    Created on : Mar 21, 2022, 10:34:25 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href=".../css/patientdt.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <a href="list">Back</a>
        </div>
        <form action=".../equipment/insert" method="POST">
            <table border="1">
                    <tr>
                        <td>Mã Vật Phẩm</td>
                        <td><input type="text" name="eid" /></td>
                    </tr>
                    <tr>
                        <td>Tên Vật Phẩm</td>
                        <td><input type="text" name="ename" /></td>
                    </tr>
                    <tr>
                        <td>Nguồn Hàng</td>
                        <td><input type="text" name="source" /></td>
                    </tr>
                    <tr>
                        <td>Trạng Thái</td>
                        <td><input type="checkbox" name="status" value="good" />Tốt
                        <input type="checkbox" name="status" value="bad" />Kém
                        </td>
                    </tr>
                    <tr>
                        <td>Giá</td>
                        <td><input type="text" name="eprice" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save" /></td>
                    </tr>
            </table>

        </form>
    </body>
</html>
