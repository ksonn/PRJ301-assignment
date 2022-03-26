<%-- 
    Document   : listapponitment
    Created on : Mar 12, 2022, 12:26:06 AM
    Author     : Administrator
--%>

<%@page import="model.Appointment"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Appointment> appointments = (ArrayList<Appointment>) request.getAttribute("listAppointment");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/appointment.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="head">
            <a href="home"> Back</a>
        </div>
        <form method="GET" action="listappointment" >
            <table border="1px solid black">
                <tr>
                    <td>Họ và tên</td>
                    <td>Ngày Sinh</td>
                    <td>Giới Tính</td>
                    <td>Địa Chỉ</td>
                    <td>SĐT</td>
                    <td>Email</td>
                    <td>Ngày Nhận</td>
                    <td>Ghi Chú</td>
                </tr>
                <% for (Appointment a : appointments) {%>
                <tr>
                    <td><%=a.getHname()%></td>
                    <td><%=a.getHdob()%></td>
                    <td><%=a.isHgender()%></td>
                    <td><%=a.getHaddress()%></td>
                    <td><%=a.getHphone()%></td>
                    <td><%=a.getEmail()%></td>
                    <td><%=a.getDaysend()%></td>
                    <td><%=a.getNote()%></td>
                    <td><a href="#" onclick="deleteAppointment(<%=a.getHphone()%>);" >Xóa</a></td>
                </tr>
                <%}%>
            </table>
        </form>

        <script>
            function deleteAppointment(phone) {
                let result = confirm("Xóa lịch hẹn?");
                if(result){
                    window.location.href = "DeteleAppointment?phone="+phone;
                }
            };
        </script>

    </body>
</html>
