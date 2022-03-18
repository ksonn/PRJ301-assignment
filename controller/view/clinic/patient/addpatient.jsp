<%-- 
    Document   : addpatient
    Created on : Mar 13, 2022, 10:27:01 PM
    Author     : Administrator
--%>

<%@page import="model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Service> services = (ArrayList<Service>)request.getAttribute("services");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action=".../patient/insert" method="Post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="pid" /></td>
                </tr>
                <tr>
                    <td>Họ và Tên</td>
                    <td><input type="text" name="pname" /></td>
                </tr>
                <tr>
                    <td>Giới Tính</td>
                    <td>
                        <input type="radio" value="male" name="gender"/> Nam 
                        <input type="radio" value="female" name="gender"/> Nữ
                    </td>
                </tr>
                <tr>
                    <td>Ngày Sinh</td>
                    <td><input type="date" name="dob" /></td>
                </tr>
                <tr>
                    <td>Nghề Nghiệp</td>
                    <td><input type="text" name="job" /></td>
                </tr>
                <tr>
                    <td>Địa Chỉ</td>
                    <td><input type="text" name="address" /></td>
                </tr>
                <tr>
                    <td>SĐT</td>
                    <td><input type="text" name="phone" /></td>
                </tr>
                <tr>
                    <td>CMND</td>
                    <td><input type="text" name="cmnd" /></td>
                </tr>
                <tr>
                    <td>Lí Do Khám</td>
                    <td><input type="text" name="reason" /></td>
                </tr>
                <% for (Service s : services) {%>
                <tr>
                    <td><input onclick="" type="checkbox" value="<%=s.getSid()%>" name="sid"/><%=s.getSname()%></td>
                    <td><input type="number" value="<%=s.getPrice()%>" name="price"/></td>
                    <td><input type="hidden" value="<%=s.getSname()%>" name="sname"></td>
                </tr>
                <%}%>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Save"/>
                        <!--<button type="submit" formaction="../patient/insert" formmethod="Post" >Submit</button>-->
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
