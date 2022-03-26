<%-- 
    Document   : patientdetail
    Created on : Mar 17, 2022, 11:49:48 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href=".../css/patientdt.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <a href="../home">Back</a>
        </div>
        <div>
            
            <form action="patient/search" method="GET">
            <table border="1px solid black">
                
                <tr>
                    <td>Họ và tên</td>
                    <td><%=patient.getPname()%></td>
                    <td>Giới Tính</td>
                    <td><%=patient.isGender() == true?"Nam":"Nữ"%></td>
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
                <%if (patient.getTreatment() != null) {%>
                <tr>
                    <td>Bác sĩ phụ trách: <%=patient.getTreatment().getDoctor()%></td>
                </tr>
                <tr>
                    <td colspan="2">Dịch Vụ</td>
                    <td colspan="4">Thông tin khám</td>
                </tr>
                <tr>
                    <td colspan="2">
                    <%for (Service s : patient.getServices()) {
                    %>
                    - <%=s.getSname()%><br>
                    <%}%>
                    </td>
                    <td colspan="2">Nguyên Nhân:<br><%=patient.getTreatment().getDiagnose()%></td>
                    <td colspan="2">Phương Pháp:<br><%=patient.getTreatment().getSolution()%></td>
                </tr>
                <%} else {%>
                <tr>
                    <td><h3 style="text-align: center">Chưa có thông tin khám bệnh</h3></td>
                </tr>
                <%}%>
            </table>
        </form>
                
        </div>
    </body>
</html>
