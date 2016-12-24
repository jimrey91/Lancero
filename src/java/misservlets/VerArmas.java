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
public class VerArmas extends HttpServlet {

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
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Armas</title>");            
            out.println("</head>");
            out.println("<body>");
           request.getRequestDispatcher("Encabezado2.jsp").include(request, response);
           
         
           
            
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>EXISTENCIA DE ARMAS</h3>\n" +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n" +
"                   <tr>\n" +
"                         <td>Sucursal</td>\n" +
"                        <td><select name=\"NombreSucursal\">\n" +
"                                <option value=\"000\" selected=\"selected\">[Seleccione Sucursal]</option>\n" +
"                                " +
"                    ");
                               try {
                                   
                      
                         
                       Statement st = cn.createStatement();
                       ResultSet rs;
                rs = st.executeQuery("Select * from sucursal ");
                       
                       while(rs.next()){
                           
                           
                       out.println("<option value='"+rs.getString(1)+"'> "+rs.getString(3)+"</option>\n");
                       
                       }
                        
                       out.println("</td> <td><div id='myform_NombreSucursal_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      <tr>\n" +
"                          <td><input type=\"submit\" value=\"Mostrar registro\" /></td>\n" +
"                          <td></td>\n" +
"                      </tr>                    \n" +
"                  </tbody>\n" +
"              </table>"
                               + 
"      <script language=\"JavaScript\" type=\"text/javascript\"\n" +
"                                        xml:space=\"preserve\">//<![CDATA[\n" +
"                                    //You should create the validator only after the definition of the HTML form\n" +
"                                      var frmvalidator  = new Validator(\"myform\");\n" +
"                                        frmvalidator.EnableOnPageErrorDisplay();\n" +
"                                        frmvalidator.EnableMsgsTogether();\n" +
"                                        \n" +
"                                        frmvalidator.addValidation(\"NombreSucursal\",\"dontselect=000\",\"<span class='nosaved'>Seleccione una Sucursal del ARMA</span>\");\n" +    
        "//]]></script>              ");
                               

                       
              if(request.getParameter("NombreSucursal")!=null) {
               int sucursal = Integer.parseInt(request.getParameter("NombreSucursal"));
           
                       
                           out.println("<table border=1 cellspacing=0> <tr><th><center>ARMA</center></th><th>MARCA</th><th>MODELO</th><th>COLOR</th><th>SERIE</th><th>PRECIO</th> ");
                           if(request.getParameter("carrito")!=null){ out.println("<th> ACCIONES </th>"); }
                           out.println("</tr>");
                           
                           try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("select A.Codigo_Arma,B.Nombre_Marca,C.Nombre_Modelo,D.Nombre_Color,A.Serie_Arma,A.Precio_Arma from arma as A inner join marca as B ON A.Codigo_Marca=B.Codigo_Marca inner join modelo_arma as C ON A.Codigo_Modelo=C.Codigo_Modelo inner join color as D ON A.Codigo_Color=D.Codigo_Color and A.CODIGO_SUCURSAL="+sucursal+" and A.disponible=1 order by B.Nombre_Marca Asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<tr><td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getString(5)+"</td><td>"+rs2.getString(6)+"</td> ");
                       if(request.getParameter("carrito")!=null){ out.println("<th> <a href='Addcarrito?cat=1&Id="+rs2.getString(1)+"'> AGREGAR CARRITO </a> </th>"); }
                       out.println("</tr>\n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                       
                       out.println("<br>");
                       
                       }
                        
                    } catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }        
            
            out.println("</tbody>\n" +
"              </table>\n" +
"          </center>");
            
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
