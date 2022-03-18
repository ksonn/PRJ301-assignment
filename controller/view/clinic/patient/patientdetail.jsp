<%-- 
    Document   : patientdetail
    Created on : Mar 17, 2022, 11:49:48 PM
    Author     : Administrator
--%>

<%@page import="model.Service"%>
<%@page import="model.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Patient patient = (Patient) request.getAttribute("patient");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <div class="patientdetail">
            <%if (patient != null) {%>
            <form action="patient/search" method="GET">
            <table>
                <tr>
                    <td>Bác sĩ phụ trách: <%=patient.getTreatment().getDoctor()%></td>
                </tr>
                <tr>
                    <td>Họ và tên</td>
                    <td><%=patient.getPname()%></td>
                    <td>Giới Tính</td>
                    <td><%=patient.isGender()%></td>
                    <td>Ngày Sinh</td>
                    <td><%=patient.getDob()%></td>
                </tr>
                <tr>
                    <td>Nghề Nghiệp</td>
                    <td><%=patient.getJob()%></td>
                    <td>Địa Chỉ</td>
                    <td><%=patient.getAddress()%> </td>
                    <td>SĐT</td>
                    <td><%=patient.getPhone()%></td>
                </tr>
                <tr>
                    <td>CMND</td>
                    <td><%=patient.getCMND()%></td>
                    <td>Ngày Khám</td>
                    <td><%=patient.getDayAdd()%></td>
                    <td>Lí do Khám</td>
                    <td><%=patient.getReason()%></td>
                </tr>
                <tr>
                    <td colspan="2">Dịch Vụ</td>
                    <td colspan="4">Thông tin khám</td>
                </tr>
                <tr>
                    <%for (Service s : patient.getServices()) {
                    %>
                    <td colspan="2"><%=s.getSname()%></td>
                    <%}%>
                    <td colspan="2">Nguyên Nhân:<br><%=patient.getTreatment().getDiagnose()%></td>
                    <td colspan="2">Phương Pháp:<br><%=patient.getTreatment().getSolution()%></td>
                </tr>
            </table>
        </form>
                <%} else {%>
                <h3 style="text-align: center">Chọn 1 bệnh án để xem thông tin chi tiết</h3>
                <%}%>
        </div>
    </body>
</html>