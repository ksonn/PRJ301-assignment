<%-- 
    Document   : searchTreatment
    Created on : Mar 23, 2022, 3:54:39 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Treatment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Treatment> t = (ArrayList<Treatment>) request.getAttribute("treatment");
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
            <a href="../home">Back</a>
        </div>
        
        <form action="../treatment/search" method="Get">
            <a class="addEquip" href="insert">khám</a>
            <table>
                <tr>
                    <td>Nhập mã bệnh nhân</td>
                    <td><input style="width: 700px" type="text" name="pid"/></td>
                    <td><input type="submit" value="Search" /></td>
                </tr>
            </table>

            <%if (!t.isEmpty()) {%>
            <table>
                <tr>
                    <td>Mã bệnh nhân</td>
                    <td>Bác sĩ điều trị</td>
                    <td>Nguyên Nhân</td>
                    <td>Phương Pháp</td>
                </tr>
                <%for (Treatment treat : t) {%>
                <tr>
                    <td><%=treat.getTid()%></td>
                    <td><%=treat.getDoctor()%></td>
                    <td><%=treat.getDiagnose()%></td>
                    <td><%=treat.getSolution()%></td>
                    <td>
                        <button type="submit" formmethod="Post" name="tid" value="<%=treat.getTid()%>"> Xóa</button>
                        <button type="submit" formaction="edit" formmethod="Get" name="tid" value="<%=treat.getTid()%>"> Sửa</button>
                    </td>
                </tr>
                <%}%>
            </table>
        </form>
        <%} else {%>
        <h1>
            Chưa có bệnh án nào được thực hiện
        </h1>
        <%}%>
    </body>
</html>
