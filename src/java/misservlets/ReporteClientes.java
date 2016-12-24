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
public class ReporteClientes extends HttpServlet {

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


                  
             out.println("   <table border=1 cellspacing=0 align='center'>  <tbody>\n <tr>  	 <th> <center> NOMBRES </center> </th>  	 <th> <center> APELLIDOS </center> </th>  	 <th> <center> DUI </center> </th> 	 <th> <center> NIT </center> </th>  	 <th> <center> LICENCIA DE CONDUCIR </center> </th> 	 <th> <center> TELEFONO </center> </th>  	 <th> <center> CELULAR </center> </th><th> <center> DEPARTAMENTO</th> </tr>  ");
             
                    try{ 
                       Statement st = cn.createStatement();
                       
                       ResultSet rs3; 
                       
                     rs3 = st.executeQuery("SELECT B.Nombre_Depa, A.Nombre_Persona,A.Apellido_Persona,A.Dui_persona,A.Nit_Persona,A.`LICENCIA_CONDUCIR_PERSONA`,A.`TELEFONO_PERSONA`,A.`CELULAR_PERSONA` FROM `persona` as A inner join departamento as B ON B.Codigo_Depa=A.Codigo_Depa order by B.Nombre_Depa,A.Nombre_Persona Asc"); 
                    
                     while(rs3.next()){
                         
                          out.println("<tr> <td> "+rs3.getString(2)+" </td><td> "+rs3.getString(3)+" </td> <td> "+rs3.getString(4)+" </td> <td> "+rs3.getString(5)+" </td> <td> "+rs3.getString(6)+" </td> <td> "+rs3.getString(7)+" </td> <td> "+rs3.getString(8)+" </td><td> "+rs3.getString(1)+" </td> </tr>");
                         
                     }
                    
    
                       
                    }catch (SQLException ex) {
                              // msg=" class='nosaved'>DATOS NO GUARDADOS";
                       // Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
                    }
             


            
            
            
            out.println("    </table></tbody> </div></div>\n" +
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
