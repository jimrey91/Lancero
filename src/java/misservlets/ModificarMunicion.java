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
public class ModificarMunicion extends HttpServlet {

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

           
            if(request.getParameter("Precio_regArma")!=null) {
                
                
          String Id =request.getParameter("Codigo_regArma");
          String marcaArma=request.getParameter("Marca_regArma");
          String calibreArma=request.getParameter("Calibre_regArma");
          String precioArma=request.getParameter("Precio_regArma");
          String sucursalArma=request.getParameter("Sucursal_regArma");

             try{
                         //PreparedStatement st2 = cn.prepareStatement("UPDATE  `el_lancero`.`arma` SET  `NUMERO_BALISTICA_ARMA` =  '1900' WHERE  `arma`.`CODIGO_ARMA` =1;") ;
                       PreparedStatement st2 = cn.prepareStatement("UPDATE  `el_lancero`.`municion` SET  Codigo_Marca="+marcaArma+",CODIGO_CALIBRE="+calibreArma+",PRECIO_MU="+ precioArma+",CODIGO_SUCURSAL="+sucursalArma+" where CODIGO_MU="+Id) ;
//                       out.println("UPDATE  `el_lancero`.`municion` SET  Codigo_Marca="+marcaArma+",CODIGO_CALIBRE="+calibreArma+",PRECIO_MU="+ precioArma+",CODIGO_SUCURSAL="+sucursalArma+" where CODIGO_MU="+Id) ;
                       
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
            
            
            if(request.getParameter("Buscar_Municion_regArma")==null){
            
            
 out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>BUSCAR MUNICIONES</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>Marca o Calibre:</td>\n" +
"                          <td><input type=\"text\" name=\"Buscar_Municion_regArma\"/></td> <td>");
out.println("<select name=\"Sucursal_regArma\">\n" +
"                                \n" +
"                                     " );
 try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from sucursal order by Nombre_Suc asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"'> "+rs4.getString(3)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            out.println(" </td> <td> <input type='Submit' value='Buscar'>\n");            
            
            
            } else {
            
            
            
     if(request.getParameter("IdCodigo_regArma")==null){           //If A
           try{
               
             
               String Buscar = request.getParameter("Buscar_Municion_regArma");
               int sucursal = Integer.parseInt(request.getParameter("Sucursal_regArma"));
 
             //  out.println("SELECT A.Codigo_MU, B.Nombre_Marca, C.Nombre_Calibre, A.Precio_MU  FROM municion AS A INNER JOIN marca AS B ON A.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS C ON A.Codigo_Calibre = C.Codigo_Calibre and A.Codigo_Sucursal="+sucursal+" and (B.Nombre_Marca Like '%"+Buscar+"%' or C.Nombre_Calibre  Like '%"+Buscar+"%') ORDER BY B.Nombre_Marca");
               
                       Statement st2 = cn.createStatement();
                       ResultSet rs2;            
                        rs2 = st2.executeQuery("SELECT A.Codigo_MU, B.Nombre_Marca, C.Nombre_Calibre, A.Precio_MU  FROM municion AS A INNER JOIN marca AS B ON A.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS C ON A.Codigo_Calibre = C.Codigo_Calibre and A.Codigo_Sucursal="+sucursal+" and (B.Nombre_Marca Like '%"+Buscar+"%' or C.Nombre_Calibre  Like '%"+Buscar+"%') ORDER BY B.Nombre_Marca");
                        rs2.last();
                        
                        
                if(rs2.getRow()>0){

                    rs2 = st2.executeQuery("SELECT A.Codigo_MU, B.Nombre_Marca, C.Nombre_Calibre, A.Precio_MU  FROM municion AS A INNER JOIN marca AS B ON A.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS C ON A.Codigo_Calibre = C.Codigo_Calibre and A.Codigo_Sucursal="+sucursal+" and (B.Nombre_Marca Like '%"+Buscar+"%' or C.Nombre_Calibre  Like '%"+Buscar+"%') ORDER BY B.Nombre_Marca");
                    
 out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>Buscar Municiones</h3> <br> <div "+msg+"</div>  \n"  +
"            \n");
            
              out.println("<table border=1> <tr> <td> CODMUNICIONES</td>  <td> MARCA</td>  <td> CALIBRE</td>  <td> PRECIO</td> <td> ACCIONES </td> </tr>");
                    
                   while(rs2.next()){
                       
                       
                    out.println("<form action=''method='POST' >  <input type='hidden' name='Buscar_Municion_regArma' value='A'> <input type='hidden' name='IdCodigo_regArma' value='"+rs2.getString(1)+"'> <tr><th>"+rs2.getString(1)+"</th><th>"+rs2.getString(2)+"</th><th>"+rs2.getString(3)+"</th><th>"+rs2.getString(4)+"</th> <th> <input type='Submit' value='MODIFICAR'>  </th>  </tr> </form> \n");
                       
                   }
                   
                   
                    
} else{
                
                
            
            
 out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>BUSCAR MUNICIONES</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\">         <table border=\"0\">\n" +
"                  <tbody>\n"
                    + "<tr>\n" +
"                          <td><font color=\"red\">*</font>Marca o Calibre:</td>\n" +
"                          <td><input type=\"text\" name=\"Buscar_Municion_regArma\"/></td> <td>");
out.println("<select name=\"Sucursal_regArma\">\n" +
"                                \n" +
"                                     " );
 try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from sucursal order by Nombre_Suc asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"'> "+rs4.getString(3)+"</option> \n");
                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            out.println(" </td> <td> <input type='Submit' value='Buscar'>\n");               
                
                }                               
                    
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }                 
                
     }  else {//  Else A
         
                        
              
                        int Codigo = Integer.parseInt(request.getParameter("IdCodigo_regArma"));
                     //   out.println("SELECT A.Codigo_MU, B.Nombre_Marca, C.Nombre_Calibre, A.Precio_MU  FROM municion AS A INNER JOIN marca AS B ON A.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS C ON A.Codigo_Calibre = C.Codigo_Calibre and A.Codigo_MU="+Codigo);

                    try{  
                        
                        Statement st3 = cn.createStatement();
                        ResultSet rs3;            
                        rs3 = st3.executeQuery("SELECT *  FROM municion AS A where A.Codigo_MU="+Codigo);
                        
                        
                  rs3.next();
                           
                           
                       
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>MODIFICAR Y/O ELIMINAR MUNICIONES</h3> <br> <div "+msg+"</div>  \n"  +
"      <form action=\"\" method=\"POST\">         <table border=\"0\">\n" +
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
                       if( Integer.parseInt(rs3.getString(5))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
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
        "                      <tr>\n <td><font color=\"red\">*</font>Calibre:</td>\n" +
"                          <td> <select name=\"Calibre_regArma\">\n" +
"                      <option>--Elija una calibre--</option>\n");
           
                               
                    try{
                               
                       Statement st4 = cn.createStatement();
                       ResultSet rs4;            
                        rs4 = st4.executeQuery("Select * from calibre order by Nombre_Calibre asc");
                           
                        while(rs4.next()){
                           
                           
                       out.println("<option value='"+rs4.getString(1)+"' ");
                       if( Integer.parseInt(rs3.getString(3))==Integer.parseInt(rs4.getString(1))){ out.println("selected"); }
                       out.println("> "+rs4.getString(2)+"</option> \n");

                       
                       }
                        
                           
                           }catch (SQLException ex) {
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                               
out.println("\n" +
"                              </select></td></tr> \n" +
"</tr>\n" +"                      <tr>\n " +
"                          <td><font color=\"red\">*</font>Precio ($):</td>\n" +
"                          <td><input type=\"text\" name=\"Precio_regArma\" value=\""+rs3.getString(4)+"\" /></td>\n" +
"                      </tr>\n" +
"                      <tr>\n" +
"                          <td><input type=\"submit\" value=\"Modificar\" name=\"RegistrarArma\" /></td>\n" +
"                       </form> <form action='' method='POST'> <input type=\"hidden\" name=\"Eliminar_regArma\" value=\"1\" />  <input type=\"hidden\" name=\"Codigo_regArma\" value=\""+rs3.getString(1)+"\" />  <td><input type=\"Submit\" value=\"Eliminar\" name=\"Eliminarr\" /></td>\n" +
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
                
                
                
         
         
     } // Fin ElseA
           
            
            
            } //Fin Else
            
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
