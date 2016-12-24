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
public class ModificarArmas extends HttpServlet {

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

           
            if(request.getParameter("NumeroSerie_regArma")!=null) {

          String Codigo_Arma=request.getParameter("Codigo_regArma");
          String marcaArma=request.getParameter("Marca_regArma");
          String modeloArma=request.getParameter("Modelo_regArma");
          String colorArma=request.getParameter("Color_regArma");
          String numSerie=request.getParameter("NumeroSerie_regArma");
          String numBalistica=request.getParameter("NumeroBalistica_regArma");
          String numBalistica2=request.getParameter("NumeroBalistica_regArma2");
          String precioArma=request.getParameter("Precio_regArma");
          String sucursalArma=request.getParameter("Sucursal_regArma");

             try{
                         //PreparedStatement st2 = cn.prepareStatement("UPDATE  `el_lancero`.`arma` SET  `NUMERO_BALISTICA_ARMA` =  '1900' WHERE  `arma`.`CODIGO_ARMA` =1;") ;
                       PreparedStatement st2 = cn.prepareStatement("UPDATE  `el_lancero`.`arma` SET  Codigo_Marca="+marcaArma+",CODIGO_MODELO="+modeloArma+",CODIGO_COLOR="+colorArma+",SERIE_ARMA="+numSerie+",NUMERO_BALISTICA_ARMA="+numBalistica+",CODIGO_SUCURSAL="+sucursalArma+",PRECIO_ARMA="+precioArma+" where CODIGO_ARMA="+Codigo_Arma) ;
                       //out.println("UPDATE  `el_lancero`.`arma` SET  Codigo_Marca="+marcaArma+",CODIGO_MODELO="+modeloArma+",CODIGO_COLOR="+colorArma+",SERIE_ARMA="+numSerie+",NUMERO_BALISTICA_ARMA="+numBalistica+",NUMERO_BALISTICA_ARMA="+ precioArma+",CODIGO_SUCURSAL="+sucursalArma+" where CODIGO_ARMA="+Codigo_Arma);
                       
                         st2.executeUpdate();
                         msg=" class='saved'>DATOS ACTUALIZADOS";

                           
                           }catch (SQLException ex) {
                               msg=" class='nosaved'>DATOS NO ACTUALIZADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
          //  out.println("Insert into arma Values (null,"+marcaArma+","+modeloArma+","+colorArma+","+numSerie+","+numBalistica+","+ precioArma+",1,"+sucursalArma+")");
            
            
            
            }
            
            
            if(request.getParameter("Eliminar_regArma")!=null){
                
            try{
                
                String Codigo_Arma = request.getParameter("Codigo_regArma");
                         //PreparedStatement st2 = cn.prepareStatement("UPDATE  `el_lancero`.`arma` SET  `NUMERO_BALISTICA_ARMA` =  '1900' WHERE  `arma`.`CODIGO_ARMA` =1;") ;
                       PreparedStatement st2 = cn.prepareStatement("Delete From arma where CODIGO_ARMA="+Codigo_Arma) ;
                       //out.println("UPDATE  `el_lancero`.`arma` SET  Codigo_Marca="+marcaArma+",CODIGO_MODELO="+modeloArma+",CODIGO_COLOR="+colorArma+",SERIE_ARMA="+numSerie+",NUMERO_BALISTICA_ARMA="+numBalistica+",NUMERO_BALISTICA_ARMA="+ precioArma+",CODIGO_SUCURSAL="+sucursalArma+" where CODIGO_ARMA="+Codigo_Arma);
                       
                         st2.executeUpdate();
                         msg=" class='saved'>DATOS ELIMINADOS";

                           
                           }catch (SQLException ex) {
                               msg=" class='nosaved'>DATOS NO ELIMINADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                
            
            }
            
            
            if(request.getParameter("Buscar_NumeroSerie_regArma")==null){
            
            
 out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>BUSCAR ARMA</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>Serie:</td>\n" +
"                          <td><input type=\"text\" name=\"Buscar_NumeroSerie_regArma\"/></td>"
                    + "<td><div id='myform_Buscar_NumeroSerie_regArma_errorloc' class=\"error_strings\"></div></td> "
                    + "<td> <input type='Submit' value='Buscar'>\n" +
"                      </tr>\n" +
"                   <tr>\n");
            
            
            
            } else {
            
            
            
                
           try{
               
               String BuscarSerie = request.getParameter("Buscar_NumeroSerie_regArma");
                               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("Select * from arma where Serie_Arma="+BuscarSerie);
                        rs2.last();
                        
                        
                if(rs2.getRow()>0){
                
                    try{    
                        
                        Statement st3 = cn.createStatement();
                        ResultSet rs3;            
                        rs3 = st3.executeQuery("Select * from arma where Serie_Arma="+BuscarSerie);
                        
                        
                  rs3.next();
                           
                           
                       
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>MODIFICAR Y/O ELIMINAR ARMA</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>C&oacute;digo:</td>\n" +
"                          <td><input type=\"text\" name=\"Codigo_regArma\" value='"+rs3.getString(1)+"' readonly/></td>\n" +
"                      </tr>\n" +
"                   <tr>\n" +
"                         <td><font color=\"red\">*</font>Sucursal</td>\n" +
"                        <td><select name=\"Sucursal_regArma\">\n" +
"                                <option>Seleccione...</option>\n" +
"                                     " );
 try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from sucursal order by Nombre_Suc asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"' ");
                       if( Integer.parseInt(rs3.getString(9))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
                       out.println("> "+rs4.getString(3)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            out.println("                       <tbody>\n" +
"                      " +
"                      \n" +
"                      <tr>\n <td><font color=\"red\">*</font>Marca:</td>\n" +
"                          <td> <select name=\"Marca_regArma\">\n" +
"                      <option>--Elija una marca--</option>\n");
           
                               
                    try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from marca order by Nombre_Marca asc");
                           
                        while(rs4.next()){
                           
                           
                        out.println("<option value='"+rs4.getString(1)+"' ");
                       if( Integer.parseInt(rs3.getString(2))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
                       out.println("> "+rs4.getString(2)+"</option> \n");

                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td>\n" +
"                      </tr>\n" +
        "                      <tr>\n <td><font color=\"red\">*</font>Modelo:</td>\n" +
"                          <td> <select name=\"Modelo_regArma\">\n" +
"                      <option>--Elija una modelo--</option>\n");
           
                               
                    try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from modelo_arma order by Nombre_Modelo asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"' ");
                       if( Integer.parseInt(rs3.getString(3))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
                       out.println("> "+rs4.getString(4)+"</option> \n");

                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td>\n" +
"                      </tr>\n" +"                      <tr>\n <td><font color=\"red\">*</font>Color:</td>\n" +
"                          <td> <select name=\"Color_regArma\">\n" +
"                      <option>--Elija una color--</option>\n");
           
                               
                    try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from color order by Nombre_Color asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"' ");
                       if( Integer.parseInt(rs3.getString(4))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
                       out.println("> "+rs4.getString(2)+"</option> \n");

                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font>Nº serie:</td>\n" +
"                          <td><input type=\"text\" name=\"NumeroSerie_regArma\" value=\""+rs3.getString(5)+"\" /></td>\n" +
"                      </tr>\n" +
"                       <tr>\n" +
"                          <td><font color=\"red\">*</font>Confirmar Nº serie:</td>\n" +
"                          <td><input type=\"text\" name=\"NumeroSerie_regArma2\" value=\""+rs3.getString(5)+"\" /></td>\n" +
"                      </tr>\n" +
"                      \n" +
"                     \n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font>Nº balisitca:</td>\n" +
"                          <td><input type=\"text\" name=\"NumeroBalistica_regArma\" value='"+rs3.getString(6)+"' /></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font>Confirmar Nº balisitca:</td>\n" +
"                          <td><input type=\"text\" name=\"NumeroBalistica_regArma2\" value='"+rs3.getString(6)+"' /></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><font color=\"red\">*</font>Precio ($):</td>\n" +
"                          <td><input type=\"text\" name=\"Precio_regArma\" value=\""+rs3.getString(7)+"\" /></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><input type=\"submit\" value=\"Modificar\" name=\"RegistrarArma\" /></td>\n" +
"                       </form> <form action='' method='POST'> <input type=\"hidden\" name=\"Codigo_regArma\" value=\""+rs3.getString(1)+"\" />   <input type=\"hidden\" name=\"Eliminar_regArma\" value=\"1\" />  <td><input type=\"Submit\" value=\"Eliminar\" name=\"Eliminarr\" /></td>\n" +
"                      </tr>\n" +
"                  </tbody>\n" +
"              </table>\n" +
"              <p>Campos Obligatorios *</p>\n" +
"          </form>\n" +
"\n" +
" " +
"                    ");
                       

                        
                       
                       
                       
                       
                       

     
                        
                   
                    
                    } 
                    
                    
                    
                    catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }      
                
                
                } else{
                
                
out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>Buscar Armas  </h3> <br> <div class='nosaved'>No Se encontro el N&uacute;mero de Serie digitado</div>  \n"  +
"      <form action=\"\" method=\"POST\" name=\"myform\" id=\"myform\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>Serie:</td>\n" +
"                          <td><input type=\"text\" name=\"Buscar_NumeroSerie_regArma\"/></td>"
                    + "<td><div id='myform_Buscar_NumeroSerie_regArma_errorloc' class=\"error_strings\"></div></td> "
                    + "<td> <input type='Submit' value='Buscar'>\n" +
"                      </tr>\n" +
"                   <tr>\n");
                            
                
                
                
                }       
                        
                        
                    
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }                 
                
            
           
            
            
            } //Fin Else
            
 out.println("</tbody>\n" +
"              </table>\n" +
"      <script language=\"JavaScript\" type=\"text/javascript\"\n" +
"                                        xml:space=\"preserve\">//<![CDATA[\n" +
"                                    //You should create the validator only after the definition of the HTML form\n" +
"                                      var frmvalidator  = new Validator(\"myform\");\n" +
"                                        frmvalidator.EnableOnPageErrorDisplay();\n" +
"                                        frmvalidator.EnableMsgsTogether();\n" +
"                                        \n" +
"                                        frmvalidator.addValidation(\"Buscar_NumeroSerie_regArma\",\"req\",\"<span class='nosaved'>Digite el N&uacute;mero de Serie del ARMA</span>\");\n" +    
        "//]]></script>        </center>      ");
            
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
