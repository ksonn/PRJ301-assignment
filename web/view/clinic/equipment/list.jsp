<%-- 
    Document   : list
    Created on : Mar 21, 2022, 10:34:10 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Equipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Equipment> equipments = (ArrayList<Equipment>) request.getAttribute("listEquipment");
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
        
        <%if (!equipments.isEmpty()) {%>
        <form method="GET" action=".../equipment/list">
            <a class="addEquip" href="../equipment/insert">Thêm thiết bị</a>
                <br>
                <table border="1" style="margin-top: 20px">
                <thead>
                    <tr>
                        <th>Mã Vật Phẩm</th>
                        <th>Tên Vật Phẩm</th>
                        <th>Nguồn Hàng</th>
                        <th>Trạng Thái</th>
                        <th>Giá</th>
                        <th>Ngày Nhập</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Equipment e : equipments) {%>
                    <tr>
                        <td><%=e.getEid()%></td>
                        <td><%=e.getEname()%></td>
                        <td><%=e.getSource()%></td>
                        <td><%=e.isStatus() == true ? "Tốt" : "Lỗi"%></td>
                        <td><%=e.getEprice()%></td>
                        <td><%=e.getInputday()%></td>
                        <td><a href="#" onclick="deleteEquipment(<%=e.getEid()%>);" >Xóa</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </form>
        <%} else {%>
        <h3> Danh sách trống</h3>
        <%}%>
        <script>
            function deleteEquipment(id) {
                let result = confirm("Xóa thiết bị?");
                if (result) {
                    window.location.href = "../deteleEquipment?id=" + id;
                }
            }
        </script>
    </body>
</html>
