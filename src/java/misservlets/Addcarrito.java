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
public class Addcarrito extends HttpServlet {

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

                  
             
             
             
                  
             
             try{
             
                                            
                   Statement st = cn.createStatement();
                   ResultSet rs; 

                        rs = st.executeQuery("Select * from reserva where Codigo_Cliente="+cod_usuario );

                        rs.last();


            if(rs.getRow()>0){


                rs = st.executeQuery("SELECT A.Codigo_Reserva FROM  `reserva` AS A where A.Codigo_Cliente="+cod_usuario );

                rs.next();
                   // out.println("Reserva: "+rs.getString(1));
                     
            if(request.getParameter("cat")!=null){
                
                int cat = Integer.parseInt(request.getParameter("cat"));
                int Id = Integer.parseInt(request.getParameter("Id"));
                
                try{
               
                    String tabla="";
                    switch (cat){
                    
                        case 1:
                            tabla="detalle_reservaArma";
                           
                            break;
                    
                        case 2:
                            
                           tabla="detalle_reservaMunicion";
                            break;
                    
                        case 3:
                            
                           tabla="detalle_resevaAccesorios";
                            break;
                            
                    
                    }
               // out.println("Insert into "+tabla+" Values (null,'"+rs.getString(1)+"','"+Id+"','1')");
                       PreparedStatement st2 = cn.prepareStatement("Insert into "+tabla+" Values (null,'"+rs.getString(1)+"','"+Id+"','1')") ;

                    //   out.println("Insert into reservas Values (null,'"+cod_usuario+"','2013-01-01')");
                       
                         st2.executeUpdate();
                
                   msg=" class='saved'>DATOS GUARDADOS";
                
                }catch (SQLException ex) {
                               msg=" class='nosaved'>DATOS NO GUARDADOS, PRODUCTO YA ESTA EN RESERVA";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            
            
             
             
          
            }
       
                         
                    
                    
                    
                } else{
                
                
             
                }
             
             }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
             
             
            
             
 out.println("<div "+msg+"<br> <a href=\"javascript:history.back(1)\">CONTINUAR</a> </div>");

            
            
            
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
