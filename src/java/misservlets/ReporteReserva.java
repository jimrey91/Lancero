/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author roberto
 */
public class ReporteReserva extends HttpServlet {

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
            out.println("<title>Servlet Reservas</title>");            
            out.println("</head>");
            out.println("<body>");
           request.getRequestDispatcher("Encabezado2.jsp").include(request, response);
            
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            HttpSession session = request.getSession(true);
             Integer carrito = (Integer) session.getAttribute("carrito");
             String msg = ">";
                  String cod_usuario = (String) session.getAttribute("cod");
                  String codigo_usuario ="";

                  
             out.println("        <form action=\"\" method=\"POST\">\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Seleccione producto</td>\n" +
"                        <td><select name=\"Codigo_Producto\">\n" +
"                                <option value=4>Todo</option>\n"
                     + "<option value=1>Arma</option>\n" +
"                                <option value=2>Municion</option>\n" +
"                                <option value=3>Accesorio</option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                    \n" +
"                    <tr>\n" +
"                          <td>Fecha, mayor a:</td>\n" +
"                          <td>Di&aacute;<input type=\"text\"  size=2 name=\"Dia\" value=\"\" />Mes<input type=\"text\" name=\"Mes\"  size=2 value=\"\" />Anio<input type=\"text\" size=4 name=\"Anio\" value=\"\" /><b>Opc</b></td>\n" +
"                      </tr>\n" +
"                     \n" +
"                      <tr>\n" +
"                          <td colspan=2><input type=\"Submit\" value=\"Generar\" name=\"GenerarPedido\" /></td>\n" +
"                          \n" +
"                      </tr>\n" +
"            </table>\n" +
"");
             
    
                 if(request.getParameter("Codigo_Producto")!=null){ 
                     
                     
                     
             
             try{
             
                 String Fecha="";
                 
                 if(request.getParameter("Dia")!=null && request.getParameter("Mes")!=null && request.getParameter("Anio")!=null){ Fecha=" where Fecha>='"+request.getParameter("Anio")+"/"+request.getParameter("Mes")+"/"+request.getParameter("Dia")+"'"; }

               
                 
                       Statement st = cn.createStatement();
                       Statement st3 = cn.createStatement();
                       ResultSet rs,rs3; 
             
                            rs = st.executeQuery("Select Codigo_Reserva from reserva "+Fecha);
  
                            rs.last();
                     
                        
                if(rs.getRow()>0){
                    
                    
                    
                    out.println("<div class='saved'>REPORTE DE RESERVAS</div> <table align='center' border=1 cellspacing=0> ");
                   rs3 = st.executeQuery("Select Codigo_Cliente from reserva "+Fecha+" order by Fecha"); 
                    
                     while(rs3.next()){
                    
                    codigo_usuario = rs3.getString(1);
           
                    rs = st3.executeQuery("SELECT A.Nombre_Persona, A.Apellido_Persona, DATE_FORMAT(B.Fecha, '%d/%m/%Y'),B.Codigo_Reserva FROM  `reserva` AS B INNER JOIN persona AS A ON A.Id_Persona = B.Codigo_Cliente and A.Id_Persona="+codigo_usuario);
                    
                    out.println(" <tr> <th colspan=2> NOMBRES </th>  <th colspan=2> APELLIDOS</th>  <th> FECHA </th> </tr> ");
                    rs.next();
                         
                         out.println(" <tr> <td colspan=2>  "+rs.getString(1)+" </td>  <td colspan=2>  "+rs.getString(2)+" </td>  <td>  "+rs.getString(3)+" </td> </tr>");
                     
                         //out.println("<div class='saved'>DATALLES</div> ");

                         if( Integer.parseInt(request.getParameter("Codigo_Producto")) ==1  || Integer.parseInt(request.getParameter("Codigo_Producto"))==4 ){
                         
                                      try{
             
                                            
                       Statement st2 = cn.createStatement();
                       ResultSet rs2; 
             
                            rs2 = st2.executeQuery("SELECT A.Codigo_Detalle,C.Nombre_Marca,D.Nombre_Modelo,E.Nombre_Color,B.Serie_Arma,A.Cantidad FROM `detalle_reservaArma` as A inner join arma as B ON A.Codigo_Arma=B.Codigo_Arma inner join marca as C ON C.Codigo_Marca = B.Codigo_Marca inner join modelo_arma as D ON D.Codigo_Modelo=B.Codigo_Modelo inner join color as E on E.Codigo_Color=B.Codigo_Color AND A.Codigo_Reserva ="+rs.getString(4) );
                                out.println(" <tr> <th colspan=5> <center> ARMAS </center></th> </tr> <tr> <td> MARCA </td>  <td> MODELO</td>  <td> COLOR</td> <td> SERIE </td>  <td> CANTIDAD </td> </tr>");
                            while(rs2.next()){
                                
                                 out.println(" <tr> <td>  "+rs2.getString(2)+" </td>  <td>  "+rs2.getString(3)+" </td>  <td>  "+rs2.getString(4)+" </td>  <td>  "+rs2.getString(5)+" </td> <td>  "+rs2.getString(6)+" </td>  </tr> ");
                                }
                         
                   
                    
                            }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                     }  
                         
                         
                         
                                             if( Integer.parseInt(request.getParameter("Codigo_Producto")) ==2  || Integer.parseInt(request.getParameter("Codigo_Producto"))==4 ){     
                                      try{
             
                                            
                       Statement st2 = cn.createStatement();
                       ResultSet rs2; 
             
                       //out.println("SELECT A.Codigo_Detalle, C.Nombre_Marca, D.Nombre_Calibre, B.Precio_Mu,A.Cantidad FROM  `detalle_reservaMunicion` AS A INNER JOIN municion AS B ON B.Codigo_Mu = A.Codigo_Municion INNER JOIN marca AS C ON C.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS D ON D.Codigo_Calibre = B.Codigo_Calibre AND A.Codigo_Reserva ="+rs.getString(4) );
                       
                            rs2 = st2.executeQuery("SELECT A.Codigo_Detalle, C.Nombre_Marca, D.Nombre_Calibre, B.Precio_Mu,A.Cantidad FROM  `detalle_reservaMunicion` AS A INNER JOIN municion AS B ON B.Codigo_Mu = A.Codigo_Municion INNER JOIN marca AS C ON C.Codigo_Marca = B.Codigo_Marca INNER JOIN calibre AS D ON D.Codigo_Calibre = B.Codigo_Calibre AND A.Codigo_Reserva ="+rs.getString(4) );
                                out.println("<tr> <th colspan=5> <center> MUNICIONES </center></th> </tr> <tr> <td colspan=2> MARCA </td>  <td> CALIBRE</td>  <td> PRECIO </td>   <td> CANTIDAD </td>");
                            while(rs2.next()){
                                
                                 out.println(" <tr> <td colspan=2>  "+rs2.getString(2)+" </td>  <td>  "+rs2.getString(3)+" </td>  <td>  "+rs2.getString(4)+" </td>  <td>  "+rs2.getString(5)+" </td>  </tr> ");
                                }
                         
                   
                    
                            }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                         
                     }
               
                         if( Integer.parseInt(request.getParameter("Codigo_Producto")) ==3  || Integer.parseInt(request.getParameter("Codigo_Producto"))==4 ){                                             
                                             
                     try{
             
                                            
                       Statement st2 = cn.createStatement();
                       ResultSet rs2; 
             
                            rs2 = st2.executeQuery("SELECT A.Codigo_Detalle, C.Nombre_Marca, D.Nombre_Tacc, B.Talla_Acc, A.Cantidad FROM  `detalle_resevaAccesorios` AS A INNER JOIN accesorio AS B ON B.Codigo_Acc = A.Codigo_Acc INNER JOIN marca AS C ON C.Codigo_Marca = B.Codigo_Marca INNER JOIN tipo_accesorio AS D ON D.Codigo_Tacc = B.Codigo_Tacc AND A.Codigo_Reserva ="+rs.getString(4) );
                                out.println("<tr bgcolor='white'> <th  colspan=5> <center> ACCESORIOS </center></th> </tr> <tr> <td colspan=2> MARCA </td>  <td> TIPO ACCESORIO</td>  <td> TALLA </td>   <td> CANTIDAD </td>");
                            while(rs2.next()){
                                
                                 out.println(" <tr> <td colspan=2>  "+rs2.getString(2)+" </td>  <td>  "+rs2.getString(3)+" </td>  <td>  "+rs2.getString(4)+" </td>  <td>  "+rs2.getString(5)+" </td>  </tr>"
                                         + "<tr color=\"black\"><td colspan=5 color=\"black\"> </td></tr>");
                                }
                         
                   
                    
                            }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     }                 
                    }                    //FIN WHILE
                      out.println("</table> ");
                } else{
                
                
             
            if(carrito==null){
             
            out.println("</tbody> <br> Bienvenido, al crear una session de carrito de reserva usted puede navegar entre nuestrosproductos y agregarlos a un carrito virtual donde al finalizar de seleccionar sus prductos, puede comprarlos si lo desea."
                    + "<form action='' method='POST'> <input name='carrito' value=1 type='hidden'> <table align='ceenter' boder='1' cellspacing='0'> <tr> <td> Crear una Session de Reserva </td> <td> <input value='Crear Carrito de Reservas' type='Submit'> </tr> </form>"
                    + "\n" +
"              </table>\n" +
                    
"          </center>");
            }

                
                }
             
             }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
             
             
            
        } else{





}           


            
            
            
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
