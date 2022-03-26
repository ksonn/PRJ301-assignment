<%-- 
    Document   : edit
    Created on : Mar 26, 2022, 6:31:24 PM
    Author     : Administrator
--%>

<%@page import="model.Treatment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Treatment> t = (ArrayList<Treatment>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href=".../css/patientdt.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <a href="search">Back</a>
        </div>
        <form action="edit" method="Post">
            <table>
                <%for (Treatment treat : t) {%>
                <tr>
                    <td>Mã bệnh nhân</td>
                    <td><%=treat.getTid()%> <input type="hidden" name="tid" value="<%=treat.getTid()%>"/></td>
                </tr>
                <%}%>
                <tr>
                    <td>Bác sĩ điều trị</td>
                    <td><input type="text" name="doctor"/></td>
                </tr>
                <tr>
                    <td>Nguyên Nhân</td>
                    <td><input type="text" name="diagnose"/></td>
                </tr>
                <tr>
                    <td>Phương Pháp</td>
                    <td><input type="text" name="solution"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
