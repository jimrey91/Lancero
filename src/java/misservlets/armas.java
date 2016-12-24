/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author roberto
 */
public class armas extends HttpServlet {

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
            out.println("<title>Servlet armas</title>");  
            out.println("</head>");
            out.println("<body> ");
            request.getRequestDispatcher("Encabezado2.jsp").include(request, response);
            
            out.println("    <div id='site_content'>      <div id='sidebar_container'> </div>  <div class='content'>");
            
            out.println("          <center>\n" +
"              <h3>Catalogo de Armas</h3>\n" +
"              <table border='0'>\n" +
"                  <tbody>\n" +
"                      <tr><th><center>Arma</center></th><th>Marca</th><th>Modelo de Arma</th><th>Color</th><th>Precio</th></tr>\n" +
"                      \n");

                                try {
                         
                       Statement st = cn.createStatement();
                       ResultSet rs;
                rs = st.executeQuery("select A.Codigo_Arma,B.Nombre_Marca,C.Nombre_Modelo,D.Nombre_Color,A.Precio_Arma from arma as A inner join marca as B ON A.Codigo_Marca=B.Codigo_Marca inner join modelo_arma as C ON A.Codigo_Modelo=C.Codigo_Modelo inner join color as D ON A.Codigo_Color=D.Codigo_Color and A.disponible=1 order by B.Nombre_Marca");
                       
                       while(rs.next()){
                           
                           
                       out.println("<tr><th><center>Arma</center></th><th>"+rs.getString(2)+"</th><th>"+rs.getString(3)+"</th><th>"+rs.getString(4)+"</th><th>"+rs.getString(5)+"</th></tr>\n");
                       
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
