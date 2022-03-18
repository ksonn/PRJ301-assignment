<%-- 
    Document   : home
    Created on : Mar 6, 2022, 11:49:36 PM
    Author     : Administrator
--%>

<%@page import="model.Treatment"%>
<%@page import="model.Service"%>
<%@page import="model.Patient"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Patient> patients = (ArrayList<Patient>) request.getAttribute("patients");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/Home.css" type="text/css">
        <script>

        </script>
    </head>
    <body>
        <div class="header">
            <div class="vattu formatheader">Quản lí vật tư</div>
            <div class="lichhen formatheader">Quản lí lịch hẹn</div>
            <div class="benhan formatheader"><a href="patient/insert">Thêm bệnh án</a></div>
            <div class="kham formatheader">Khám bệnh</div>
            <div class="hoadon formatheader">Hóa đơn</div>
            <div class="taikhoan formatheader">Quản lí tài khoản</div>
            <div class="doanhthu formatheader">doanh thu</div>
            <div class="logout formatheader">đăng xuất</div>
        </div>
        <div class="listpatient">
            <%if (!patients.isEmpty()) {%>
            <form action="home" method="GET" border="1px solid black">
                <table>
                    <tr>
                        <td>ID</td>
                        <td>Họ và Tên</td>
                        <td>Giới Tính</td>
                        <td>Ngày Sinh</td>
                        <td>Ngày Nhập</td>
                    </tr>
                    <%for (Patient p : patients) {%>
                    <tr>
                        <td><%=p.getPid()%></td>
                        <td><%=p.getPname()%></td>
                        <td><%=p.isGender()%></td>
                        <td><%=p.getDob()%></td>
                        <td><%=p.getDayAdd()%></td>
                        <td>
                            <button type="submit" formaction="patient/search"
                                    formmethod="GET" name="getpid" value="<%=p.getPid()%>">></button> 
                        </td>
                    </tr>
                    <%}%>
                </table>
            </form>
            <%} else {%>
            <h2>  No record to display</h2>
            <%}%>
        </div>
        <div class="patientdetail">
            <h3 style="text-align: center">Chọn 1 bệnh án để xem thông tin chi tiết</h3>
        </div>
    </body>
</html>
