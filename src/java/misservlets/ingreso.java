/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ING.FERNANDO
 */
public class ingreso extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
           //Recogemos variables que son enviadas desde Index.jsp
            String usuario = request.getParameter("usu");
            String contra = request.getParameter("pass");

            //Realizamos acceso a base de Datos
            String [] datos=Sql.getFila ("SELECT p.id_persona,p.apellido_persona,p.nombre_persona,u.usuario,u.rol FROM persona p INNER JOIN usuario u ON p.id_persona=u.id_persona WHERE u.usuario='"+usuario+"' AND u.contrasena='"+contra+"'");

            if(datos==null){

                // nos mostrara esto en caso el usuario no sea encontrado.
                out.println("<html>");
                out.println("<head>");
                out.println("<title> :::AUTENTICACION FALLIDA!::: </title>");
                out.println("</head>");
                out.println("<body bgcolor='#DDEEFF'>");
                out.println("<table border='0' width='50%' align='center'>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                out.println("<tr>");
                out.println("<td align='center'> <font face='Courier New, Courier, monospace' color='#FF0000' size='2'>Autenticación erronea! Verifique que Usuario y Contraseña sean válidos. <a href='index.jsp'>Regresar>></a></font></p></td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");



            }else{

                //Capturamos las variables a mostrar
                String id=datos[0];
                String apellidos=datos[1];
                String nombres=datos[2];
                String usuar=datos[3];
                String rol=datos[4];

                //creamos nuestra sesion
                HttpSession session = request.getSession(true);

                //Obtenemos los obejtos a guardar en session
                session.setAttribute("cod", id);

                session.setAttribute("ape", apellidos);
                session.setAttribute("nom", nombres);
                session.setAttribute("usu", usuar);
                session.setAttribute("rol", rol);
                
                
                //String rol1 = (String) session.getAttribute("rol");//Recoge la session
                
              
                //pagina a donde se enviara si se encuentra el usuario autenticado
               response.sendRedirect("Inicio.jsp");
               

            }
            
            
            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
