<%-- 
    Document   : insertTreatment
    Created on : Mar 20, 2022, 8:11:38 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action=".../treatment/insert" method="POST">
            <table border="1">
                    <tr>
                        <td>Nhập mã bệnh án:</td>
                        <td><input type="text" name="pid"/></td>
                    </tr>
                    <tr>
                        <td>Bác sĩ điều trị:</td>
                        <td><input type="text" name="doctor"/></td>
                    </tr>
                    <tr>
                        <td>Nguyên nhân:</td>
                        <td><input type="text" name="diagnose"/></td>
                    </tr>
                    <tr>
                        <td>Phương pháp:</td>
                        <td><input type="text" name="solution"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
