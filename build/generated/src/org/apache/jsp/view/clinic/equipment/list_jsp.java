package org.apache.jsp.view.clinic.equipment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Equipment;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    ArrayList<Equipment> equipments = (ArrayList<Equipment>) request.getAttribute("listEquipment");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\".../css/patientdt.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <a href=\"../home\">Back</a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");
if (!equipments.isEmpty()) {
      out.write("\n");
      out.write("        <form method=\"GET\" action=\".../equipment/list\">\n");
      out.write("            <a class=\"addEquip\" href=\"../equipment/insert\">Thêm thiết bị</a>\n");
      out.write("                <br>\n");
      out.write("                <table border=\"1\" style=\"margin-top: 10px\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Mã Vật Phẩm</th>\n");
      out.write("                        <th>Tên Vật Phẩm</th>\n");
      out.write("                        <th>Nguồn Hàng</th>\n");
      out.write("                        <th>Trạng Thái</th>\n");
      out.write("                        <th>Giá</th>\n");
      out.write("                        <th>Ngày Nhập</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
for (Equipment e : equipments) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(e.getEid());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(e.getEname());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(e.getSource());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(e.isStatus() == true ? "Tốt" : "Lỗi");
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(e.getEprice());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(e.getInputday());
      out.write("</td>\n");
      out.write("                        <td><a href=\"#\" onclick=\"deleteEquipment(");
      out.print(e.getEid());
      out.write(");\" >Xóa</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <h3> Danh sách trống</h3>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function deleteEquipment(id) {\n");
      out.write("                let result = confirm(\"Xóa thiết bị?\");\n");
      out.write("                if (result) {\n");
      out.write("                    window.location.href = \"../deteleEquipment?id=\" + id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
