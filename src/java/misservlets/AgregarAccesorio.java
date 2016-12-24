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
public class AgregarAccesorio extends HttpServlet {

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

           
            if(request.getParameter("Marca_regArma")!=null) {

          String marcaArma=request.getParameter("Marca_regArma");
          String Tacc=request.getParameter("Tacc_regArma");
          String colorArma=request.getParameter("Color_regArma");
          String Talla=request.getParameter("Talla_regArma");
          String precioArma=request.getParameter("Precio_regArma");
          String sucursalArma=request.getParameter("Sucursal_regArma");

             try{
                               
                       PreparedStatement st2 = cn.prepareStatement("Insert into accesorio Values (null,"+marcaArma+","+Tacc+","+colorArma+",'"+Talla+"',"+precioArma+","+sucursalArma+")") ;

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
"              <h3>REGISTRAR ACCESORIOS</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>C&oacute;digo:</td>\n" +
"                          <td><input type=\"text\" name=\"Codigo_regArma\" disabled=\"disabled\"/></td>\n" +
"                      </tr>\n" +
"                   <tr>\n" +
"                         <td><font color=\"red\">*</font>Sucursal</td>\n" +
"                        <td><select name=\"Sucursal_regArma\">\n" +
"                                <option value=\"000\" selected=\"selected\">[Seleccione Sucursal]</option>\n" +
"                                     " );
 try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from sucursal order by Nombre_Suc asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<option value='"+rs2.getString(1)+"'> "+rs2.getString(3)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            out.println("</td><td><div id='myform_Sucursal_regArma_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      " +
"                      \n" +
"                      <tr>\n <td><font color=\"red\">*</font>Marca:</td>\n" +
"                          <td> <select name=\"Marca_regArma\">\n" +
"                      <option value=\"000\" selected=\"selected\">[Seleccione Marca]</option>\n");
           
                               
                    try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from marca order by Nombre_Marca asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<option value='"+rs2.getString(1)+"'> "+rs2.getString(2)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select>"
        + "</td><td><div id='myform_Marca_regArma_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      </tr>\n" +
        "                      <tr>\n <td><font color=\"red\">*</font>Tipo Accesorio:</td>\n" +
"                          <td> <select name=\"Tacc_regArma\">\n" +
"                      <option value=\"000\" selected=\"selected\">[Seleccione Tipo Accesorio]</option>\n");
           
                               
                    try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from tipo_accesorio order by Nombre_Tacc asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<option value='"+rs2.getString(1)+"'> "+rs2.getString(2)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td>"
        + "<td><div id='myform_Tacc_regArma_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      </tr>\n" +"                      <tr>\n <td><font color=\"red\">*</font>Color:</td>\n" +
"                          <td> <select name=\"Color_regArma\">\n" +
"                      <option value=\"000\" selected=\"selected\">[Seleccione Color]</option>\n");
           
                               
                    try{
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from color order by Nombre_Color asc");
                           
                        while(rs2.next()){
                           
                           
                       out.println("<option value='"+rs2.getString(1)+"'> "+rs2.getString(2)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td>"
        + "<td><div id='myform_Color_regArma_errorloc' class=\"error_strings\"></div></td></tr>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font>Talla:</td>\n" +
"                          <td><input type=\"text\" name=\"Talla_regArma\" value=\"\" /></td>\n" +
                 "<td><div id='myform_Talla_regArma_errorloc' class=\"error_strings\"></div></td>" +
"                      </tr>\n" +
"                       <tr>\n" +
"                          <td><font color=\"red\">*</font>Precio:</td>\n" +
"                          <td><input type=\"text\" name=\"Precio_regArma\" value=\"\" /></td>\n" +
                         "<td><div id='myform_Precio_regArma_errorloc' class=\"error_strings\"></div></td>" +
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
"                                        frmvalidator.addValidation(\"Sucursal_regArma\",\"dontselect=000\",\"<span class='nosaved'>Seleccione una Sucursal del ACCESORIO</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Marca_regArma\",\"dontselect=000\",\"<span class='nosaved'>Seleccione una Marca del ACCESORIO</span>\");\n" +
"                                        \n" +
"                                        frmvalidator.addValidation(\"Tacc_regArma\",\"dontselect=000\",\"<span class='nosaved'>Seleccione un Tipo del ACCESORIO</span>\");\n" +       
"                                        \n" +
"                                        frmvalidator.addValidation(\"Color_regArma\",\"dontselect=000\",\"<span class='nosaved'>Seleccione una Color del ACCESORIO</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Talla_regArma\",\"req\",\"<span class='nosaved'>Digite la TALLA del ACCESORIO</span>\");\n" +
"                                        frmvalidator.addValidation(\"Talla_regArma\",\"alpha_s\",\"<span class='nosaved'>Unicamente permitidos las Letras</span>\");\n" +

"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Precio_regArma\",\"req\",\"<span class='nosaved'>Digite el Precio del ACCESORIO</span>\");\n" +
"                                        frmvalidator.addValidation(\"Precio_regArma\",\"minlen=3\",\"<span class='nosaved'>Valor m&iacute;nimo de 3 caracteres</span>\");\n" +
"                                        frmvalidator.addValidation(\"Precio_regArma\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +     
"                                       \n"         
        + "//]]></script>              ");
                       

                        
                           
            
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
