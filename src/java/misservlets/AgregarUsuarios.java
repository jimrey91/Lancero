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
public class AgregarUsuarios extends HttpServlet {

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
            out.println("<html><head>\n" +
            "  <title>El Lancero</title>\n" +
            "  <meta name=\"description\" content=\"website description\" />\n" +
            "  <meta name=\"keywords\" content=\"website keywords, website keywords\" />\n" +
            "  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n" +
            "  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
            "  <!-- modernizr enables HTML5 elements and feature detects -->\n" +
            "  <script type=\"text/javascript\" src=\"js/modernizr-1.5.min.js\"></script>"
                                + "  <script type=\"text/javascript\" src=\"js/gen_validatorv4.js\"></script>\n" +
            "  \n" +
            "  \n" +
            "</head>");
 
           //request.getRequestDispatcher("Encabezado2.jsp").include(request, response);
            
            out.println("<body>\n" +
"    \n" +
"\n" +
"    \n" +
"  <div id=\"main\">\n" +
                    "<header>\n" +
"      <div id=\"logo\">\n" +
"        <div id=\"logo_text\">\n" +
"          <!-- class=\"logo_colour\", allows you to change the colour of the text -->\n" +
"          <h1><a href=\"index.html\">El Lancero<span class=\"logo_colour\"> Armas, Accesorios y Más</span></a></h1>\n" +
"          <h2>El Salvador</h2>\n" +
"        </div>\n" +
"      </div>            \n" +
"      <nav> \n" +
"          <ul class=\"sf-menu\" id=\"nav\">\n" +
"          <li class=\"selected\"><a href=\"index.jsp\">Inicio</a></li>\n" +
"          <li><a href=\"Empresa.jsp\">Nuestra Empresa</a>\n" +
"        \n" +
"          <li><a href=\"Contactenos.jsp\">Contactenos</a></li>              \n" +
"          </ul>\n" +
"      </nav> \n" +
"    </header>"+
"    <div id=\"site_content\">\n" +
"      \n" +
"      <div id=\"sidebar_container\">\n" +
"       <div class=\"sidebar\">\n" +
"     \n" +
"        </div>\n" +
"      </div>\n" +
"      <div class=\"content\">\n" +
"          <h3>Registrarse</h3>  ");

           
            if(request.getParameter("Sexo_cliente")!=null) {

         String nombres=request.getParameter("nombre_cliente");
          String apellidos=request.getParameter("apellido_cliente");
          String direccion=request.getParameter("Direccion_cliente");
          String depa=request.getParameter("departamento_cliente");
          String dui=request.getParameter("dui_cliente");
          String nit=request.getParameter("nit_cliente");
          String licConducir=request.getParameter("licencia_conducir_cliente");
          String tel=request.getParameter("telefono_cliente");
          String cel=request.getParameter("celular_cliente");
          String correo=request.getParameter("Correo_cliente");
          String empresacli=request.getParameter("Empresa_cliente");
          String licArma=request.getParameter("Licencia_Arma_cliente");
          String sexo=request.getParameter("Sexo_cliente");
          String usu=request.getParameter("usuario_cliente");
          String pass=request.getParameter("contrasena_cliente");
          String pass2=request.getParameter("confirmar_contrasena_cliente");
          
   
             try{
                               
                       PreparedStatement st2 = cn.prepareStatement("insert into persona values (null,'"+depa+"','"+nombres+"','"+apellidos+"','"+dui+"','"+nit+"', '"+licConducir+"','"+tel+"','"+cel+"', '"+direccion+"', '"+correo+"','"+empresacli+"','"+sexo+"')") ;


                          
                         st2.executeUpdate();
                         
                Statement st = cn.createStatement();
                ResultSet rs;
                rs = st.executeQuery("SELECT LAST_INSERT_ID( ) ;");
                rs.next();
                
                         
              /*st2 = cn.prepareStatement("insert into cliente  values ('"+nombres+"','"+licArma+"');");
              st2.executeUpdate(); */
                                            
              st2 = cn.prepareStatement("insert into usuario  values (null,'"+rs.getString(1)+"','"+usu+"','"+pass+"','Cliente');");
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
"            <br> <div "+msg+"</div>  \n    \n" +
"          <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">\n" +
"              <table border=\"0\">\n" +
"                  <tbody>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Nombres: </td>\n" +
"                          <td><input type=\"text\" name=\"nombre_cliente\" /></td>"
                    + "<td><div id='myform_nombre_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Apellidos: </td>\n" +
"                          <td><input type=\"text\" name=\"apellido_cliente\"  /></td>"
                    + "<td><div id='myform_apellido_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      \n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> DUI: </td>\n" +
"                          <td><input type=\"text\" name=\"dui_cliente\" /></td>"
                    + "<td><div id='myform_dui_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> NIT: </td>\n" +
"                          <td><input type=\"text\" name=\"nit_cliente\"  /></td>"
                    + "<td><div id='myform_nit_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <td><font color=\"red\">*</font> No. de Licencia de conducir: </td>\n" +
"                          <td><input type=\"text\" name=\"licencia_conducir_cliente\"  /></td>"
                    + "<td><div id='myform_licencia_conducir_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td> Teléfono: </td>\n" +
"                          <td><input type=\"text\" name=\"telefono_cliente\" /></td>"
                    + "<td><div id='myform_telefono_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td> Celular: </td>\n" +
"                          <td><input type=\"text\" name=\"celular_cliente\" /></td>"
                    + "<td><div id='myform_celular_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Dirección: </td>\n" +
"                          <td><input type=\"text\" name=\"Direccion_cliente\" /></td>"
                    + "<td><div id='myform_Direccion_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Departamento: </td>\n" +
"                          <td> <select name=\"departamento_cliente\">\n" +
"                      <option value=\"000\" selected=\"selected\">[Seleccione Departamento]</option>\n" +
"                      <option value=\"1\">San Salvador</option>\n" +
"                      <option value=\"2\">Cuscatlan</option>\n" +
"                      <option value=\"3\">Chalatenango</option>\n" +
"                      <option value=\"4\">La libertad</option>\n" +
"                      <option value=\"5\">La Paz</option>\n" +
"                      <option value=\"6\">Cabañas</option>\n" +
"                      <option value=\"7\">San Vicente</option>\n" +
"                      <option value=\"8\">La Union</option>\n" +
"                      <option value=\"9\">Morazan</option>\n" +
"                      <option value=\"10\">San Miguel</option>\n" +
"                      <option value=\"11\">Usulutan</option>\n" +
"                      <option value=\"12\">Sonsonate</option>\n" +
"                      <option value=\"13\">Santa Ana</option>\n" +
"                      <option value=\"14\">Ahuachapan</option>\n" +
"                              </select></td>"
                    + "<td><div id='myform_departamento_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Correo: </td>\n" +
"                          <td><input type=\"text\" name=\"Correo_cliente\" /></td>"
                    + "<td><div id='myform_Correo_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> No. licencia de portacion de arma: </td>\n" +
"                          <td><input type=\"text\" name=\"Licencia_Arma_cliente\" value=\"\" /></td>"
                    + "<td><div id='myform_Licencia_Arma_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                                                \n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Empresa: </td>\n" +
"                          <td><input type=\"text\" name=\"Empresa_cliente\" value=\"\" /></td>"
                    + "<td><div id='myform_Empresa_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                                                \n" +
"                       <tr>\n" +
"                          <td><font color=\"red\">*</font> Sexo: </td>\n" +
"                          <td><select name=\"Sexo_cliente\">\n" +
"                                  <option value=\"000\" selected=\"selected\">[Seleccione Genero]</option>\n" +
"                                  <option value=\"f\">F</option>\n" +
"                                  <option value=\"m\">M</option>\n" +
"                              </select></td>"
                    + "<td><div id='myform_Sexo_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Usuario: </td>\n" +
"                          <td><input type=\"text\" name=\"usuario_cliente\" value=\"\" /></td>"
                    + "<td><div id='myform_usuario_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Contraseña: </td>\n" +
"                          <td><input type=\"password\" name=\"contrasena_cliente\" /></td>"
                    + "<td><div id='myform_contrasena_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font> Confirmar Contraseña: </td>\n" +
"                          <td><input type=\"password\" name=\"confirmar_contrasena_cliente\" /></td>"
                    + "<td><div id='myform_confirmar_contrasena_cliente_errorloc' class=\"error_strings\"></div></td>\n" +
"                      </tr> \n" +
"                      <tr>\n" +
"                          <td><input type=\"submit\" value=\"Guardar\"  /></td>\n" +
"                          <td></td>\n" +
"                      </tr>\n" +
"                      \n" +
"                  </tbody>\n" +
"              </table>\n" +
"\n" +
"              <p>Campos * obligatorios</p>\n" +
"          </form>"+
                    " " +
"      <script language=\"JavaScript\" type=\"text/javascript\"\n" +
"                                        xml:space=\"preserve\">//<![CDATA[\n" +
"                                    //You should create the validator only after the definition of the HTML form\n" +
"                                      var frmvalidator  = new Validator(\"myform\");\n" +
"                                        frmvalidator.EnableOnPageErrorDisplay();\n" +
"                                        frmvalidator.EnableMsgsTogether();\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"nombre_cliente\",\"req\",\"<span class='nosaved'>Digite Nombre del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"nombre_cliente\",\"maxlen=25\",\"<span class='nosaved'>Valor m&aacute;ximo de 25 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"nombre_cliente\",\"alpha_s\",\"<span class='nosaved'>Unicamente permitidas letras</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"apellido_cliente\",\"req\",\"<span class='nosaved'>Digite Apellidos del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"apellido_cliente\",\"maxlen=25\",\"<span class='nosaved'>Valor m&aacute;ximo de 25 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"apellido_cliente\",\"alpha_s\",\"<span class='nosaved'>Unicamente permitidos letras</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"dui_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de DUI del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"dui_cliente\",\"maxlen=9\",\"<span class='nosaved'>Valor m&aacute;ximo de 9 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"dui_cliente\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"nit_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de NIT del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"nit_cliente\",\"maxlen=14\",\"<span class='nosaved'>Valor m&aacute;ximo de 14 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"nit_cliente\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"licencia_conducir_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de LICENCIA del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"licencia_conducir_cliente\",\"maxlen=14\",\"<span class='nosaved'>Valor m&aacute;ximo de 14 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"licencia_conducir_cliente\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"telefono_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de Telefono del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"telefono_cliente\",\"maxlen=8\",\"<span class='nosaved'>Valor m&aacute;ximo de 8 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"telefono_cliente\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"celular_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de Celular del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"celular_cliente\",\"maxlen=8\",\"<span class='nosaved'>Valor m&aacute;ximo de 8 caracteres</span>\");\n" + 
"                                        frmvalidator.addValidation(\"celular_cliente\",\"numeric\",\"<span class='nosaved'>Unicamente permitidos los N&uacute;meros</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Direccion_cliente\",\"req\",\"<span class='nosaved'>Digite la Direccion del CLIENTE</span>\");\n" +"                                       \n" +
"                                        \n" +
"                                        \n" +
"                                        frmvalidator.addValidation(\"departamento_cliente\",\"dontselect=000\",\"<span class='nosaved'>Seleccione un Departamento del CLIENTE</span>\");\n" +
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Correo_cliente\",\"req\",\"<span class='nosaved'>Digite el Correo Electronico del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"Correo_cliente\",\"email\",\"<span class='nosaved'>Debe ser un Correo valido</span>\");\n" + 
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Licencia_Arma_cliente\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de Licencia Prtacion de ARMA del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"Licencia_Arma_cliente\",\"maxlen=25\",\"<span class='nosaved'>Valor m&aacute;ximo de 25 caracteres</span>\");\n" + 
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"Empresa_cliente\",\"req\",\"<span class='nosaved'>Digite Nombre de Empresa del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"Empresa_cliente\",\"maxlen=25\",\"<span class='nosaved'>Valor m&aacute;ximo de 25 caracteres</span>\");\n" + 
"                                       \n" +
"                                        frmvalidator.addValidation(\"Sexo_cliente\",\"dontselect=000\",\"<span class='nosaved'>Seleccione una Genero del CLIENTE</span>\");\n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"usuario_cliente\",\"req\",\"<span class='nosaved'>Digite el LOGIN del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"usuario_cliente\",\"maxlen=20\",\"<span class='nosaved'>Valor m&aacute;ximo de 20 caracteres</span>\");\n" + 
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"contrasena_cliente\",\"req\",\"<span class='nosaved'>Digite la Contraseña del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"contrasena_cliente\",\"maxlen=10\",\"<span class='nosaved'>Valor m&aacute;ximo de 10 caracteres</span>\");\n" +     
"                                       \n" +
"                                       \n" +
"                                        frmvalidator.addValidation(\"confirmar_contrasena_cliente\",\"req\",\"<span class='nosaved'>Digite la Contraseña del CLIENTE</span>\");\n" +
"                                        frmvalidator.addValidation(\"confirmar_contrasena_cliente\",\"maxlen=10\",\"<span class='nosaved'>Valor m&aacute;ximo de 10 caracteres</span>\");\n" +     
"                                       \n" +
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
