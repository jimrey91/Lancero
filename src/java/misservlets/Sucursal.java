/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author roberto
 */
public class Sucursal extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
                     Conexion 	db = new Conexion();
                     Connection	cn = db.getConnection();
                     String msg = ">";
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Armas</title>");            
            out.println("</head>");
            out.println("<body>");
           request.getRequestDispatcher("Encabezado2.jsp").include(request, response);

           
            if(request.getParameter("depa")!=null) {

          String Depa=request.getParameter("depa");
          String Nombre=request.getParameter("nombre");
          String Direccion=request.getParameter("direccion");
          String Telefono=request.getParameter("telefono");

             try{
                               
                       PreparedStatement st2 = cn.prepareStatement("INSERT INTO `el_lancero`.`sucursal` (`CODIGO_SUC` ,`CODIGO_DEPA` ,`NOMBRE_SUC` ,`DIRECCION_SUC` ,`TELEFONO_SUC` )VALUES (NULL , '"+Depa+"', '"+Nombre+"', '"+Direccion+"', '"+Telefono+"');") ;

                      // out.println("Insert into accesorio Values (null,"+marcaArma+","+Tacc+","+colorArma+",'"+Talla+"',"+precioArma+","+sucursalArma+")");
                       
                         st2.executeUpdate();
                         msg=" class='saved'>DATOS GUARDADOS";

                           
                           }catch (SQLException ex) {
                               msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
          //  out.println("Insert into arma Values (null,"+marcaArma+","+modeloArma+","+colorArma+","+numSerie+","+numBalistica+","+ precioArma+",1,"+sucursalArma+")");
            
            
            
            }
            
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>REGISTRAR SUCURSAL</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>C&oacute;digo:</td>\n" +
"                          <td><input type=\"text\" name=\"Codigo_regArma\" disabled=\"disabled\"/></td>\n" +
"                      </tr>\n" +
"                   <tr>\n" +
"                         <td><font color=\"red\">*</font>Departamento:</td>\n" +
"                        <td><select name=\"depa\">\n" +
"                                <option value=\"000\" selected=\"selected\">[Seleccione Departamento]</option>\n" +
"                                     " );
 try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from departamento  order by NOMBRE_DEPA asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<option value='"+rs2.getString(1)+"'> "+rs2.getString(2)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            out.println("</td><td><div id='myform_depa_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      " +
"                      \n <tr>\n" +
"                          <td><font color=\"red\">*</font>Nombre:</td>\n" +
"                          <td><input type=\"text\" name=\"nombre\" value=\"\" /></td>\n" +
                 "<td><div id='myform_nombre_errorloc' class=\"error_strings\"></div></td>" +
"                      </tr>\n" +
"                        <tr>\n" +
"                          <td><font color=\"red\">*</font>Direcci&oacute;n:</td>\n" +
"                          <td><input type=\"text\" name=\"direccion\" value=\"\" /></td>\n" +
                         "<td><div id='myform_direccion_errorloc' class=\"error_strings\"></div></td>" +
"                      </tr>\n                      <tr>\n" +
"                          <td><font color=\"red\">*</font>T&eacute;lefono:</td>\n" +
"                          <td><input type=\"text\" name=\"telefono\" value=\"\" /></td>\n" +
                         "<td><div id='myform_telefono_errorloc' class=\"error_strings\"></div></td>" +
"                      </tr>\n" +
"                          <td><input type=\"submit\" value=\"Registrar\" name=\"RegistrarArma\" /></td>\n" +
"                          <td><input type=\"button\" value=\"Cancelar\" name=\"Cancelar\" /></td>\n" +
"                      </tr>\n" +
"                  </tbody>\n" +
"              </table>\n" +
"              <p>Campos Obligatorios *</p>\n" +
"          </form>\n" +
"\n" +
" " +
" " +
"      <script language=\"JavaScript\" type=\"text/javascript\"\n" +
"                                        xml:space=\"preserve\">//<![CDATA[\n" +
"                                    //You should create the validator only after the definition of the HTML form\n" +
"                                      var frmvalidator  = new Validator(\"myform\");\n" +
"                                        frmvalidator.EnableOnPageErrorDisplay();\n" +
"                                        frmvalidator.EnableMsgsTogether();\n" +
"                                        \n" +
"                                        frmvalidator.addValidation(\"depa\",\"dontselect=000\",\"<span class='nosaved'>Seleccione un Departamento para SUCURSAL</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"nombre\",\"req\",\"<span class='nosaved'>Digite la Nombre para SUCURSAL</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"direccion\",\"req\",\"<span class='nosaved'>Digite la Direccion para SUCURSAL</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"telefono\",\"req\",\"<span class='nosaved'>Digite el Telefono para SUCURSAL</span>\");\n" +
"                                        frmvalidator.addValidation(\"telefono\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +     
"                                       \n"         
        + "//]]></script>              ");
                       

                        
                           
            
            out.println("</table></tbody>");
            
                                 
            out.println("<table border=1 cellspacing=0> "
                     + "<tr>"
                     + "    <th>COD</th>"
                     + "    <th>SUCURSAL</th>"
                     + "    <th>DIRECCION</th>"
                     + "    <th>TELEFONO</th>"
                     + "    <th>DEPARTAMENTO</th>"
                     + "</tr>");
             
            try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("SELECT A.CODIGO_SUC, A.NOMBRE_SUC, A.DIRECCION_SUC, A.TELEFONO_SUC, B.NOMBRE_DEPA FROM el_lancero.sucursal as A, el_lancero.departamento as B where A.CODIGO_DEPA=B.CODIGO_DEPA");
                           
                      while(rs2.next()){
                      out.println("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getString(5)+"");
                      
                       }
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
             
            out.println("</table>\n");              
            

            
            
            out.println("     </div>\n" +
"    </div>");
            
request.getRequestDispatcher("PiePagina.jsp").include(request, response);
            out.println("</body>");
            out.println("</html>"); 
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
