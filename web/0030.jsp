<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : page_inicio
    Created on : 10-oct-2011, 23:08:58
    Author     : Lobo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String pag = request.getParameter("pag");
    String titu = request.getParameter("titu");  

       // out.println(pag+"<br />\n"+titu);
%>

<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>


<sql:query var="prueba" dataSource="jdbc/myDatasource">
        SELECT ID_ROL, TIPO_ROL FROM ROLES
</sql:query>
        
<div class="clear"></div> <!-- End .clear -->
	
	<div class="content-box"><!-- Start Content Box -->
		
		<div class="content-box-header">
			
			<h3><% out.println(titu); %></h3>
								
			<div class="clear"></div>
			
		</div> <!-- End .content-box-header -->
		
		<div class="content-box-content">
			
                    <div class="tab-content" id="tab1">
			
                            
				<form action="./resources/partial_forms/0030.jsp" method ="POST" name="myform" id="myform">
					
					<fieldset> 
						
						<p>
                                                    <label>IDENTIFICADOR ROL</label>
                                                    <div id='myform_IdRol_errorloc' class="error_strings"></div>
                                                         <select name="IdRol" class="select">
                                                             <option value="000" selected="selected">[Elige Id]</option>
                                                            <c:forEach var="row" items="${prueba.rows}">
                                                                <option value="${row.ID_ROL}">${row.TIPO_ROL}</option>
                                                            </c:forEach>
                                                        </select>
						</p>
						
						<p>
                                                    <label>NOMBRE</label>
                                                    <div id='myform_nombre_errorloc' class="error_strings"></div>
                                                    <input class="text-input medium-input" type="text" name="nombre" onKeyPress="return sololetras(event)" />
						</p>
						<p>
                                                    <label>APELLIDO</label>
                                                    <div id='myform_apellido_errorloc' class="error_strings"></div>
                                                    <input class="text-input medium-input" type="text" name="apellido" onKeyPress="return sololetras(event)" /> 
						</p>
						<p>
                                                    <label>CARGO</label>
                                                    <div id='myform_cargo_errorloc' class="error_strings"></div>
                                                    <input class="text-input medium-input" type="text" name="cargo"/> 
						</p>
						<p>
                                                    <label>USUARIO LOGIN</label>
                                                    <div id='myform_usuarioLogin_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text" name="usuarioLogin"  onKeyPress="return sololetras(event)" /> 
						</p>						
						<p>
                                                    <label>CONTRASEÑA</label>
                                                    <div id='myform_password_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="password" name="password"/>
						</p>
						
						<p>
                                                    <input class="button" type="submit" value="Guardar" name="action" />
                                                    <input class="button" type="reset" value="Limpiar" />
						</p>
						
					</fieldset>
					
					<div class="clear"></div>

					
				</form>
                        
                        <script language="JavaScript" type="text/javascript"
                                        xml:space="preserve">//<![CDATA[
                                    //You should create the validator only after the definition of the HTML form
                                      var frmvalidator  = new Validator("myform");
                                        frmvalidator.EnableOnPageErrorDisplay();
                                        frmvalidator.EnableMsgsTogether();

                                        frmvalidator.addValidation("IdRol","dontselect=000","<span class='input-notification error png_bg'>Seleccione un Identificador de Rol</span>");

                                 //]]></script>
				
			</div> 
			
		</div>
		
	</div>

<div class="clear"></div>

<%


  // Define a class holding the functions we will use in the main body of the code.
  class PageFunctions extends Object {
      
   public void example_insert (Connection conn, javax.servlet.jsp.JspWriter out, HttpServletRequest request, HttpServletResponse response) throws Exception {
   
       response.setContentType("text/html;charset=UTF-8");
      //PrintWriter out = response.getWriter();
        
      // Prepare an insert statement containing bind variables.
      String sql = "INSERT INTO BIBLIOTECA.USUARIOS (ID_USUARIO, ID_ROL, NOMBRE, APELLIDO, CARGO, USUARIO_LOGIN, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);

      // Bind the value into the prepared statement.
 
     String IdUsuario= "null";
     int idRol = Integer.parseInt(request.getParameter("IdRol"));
     String nombre= request.getParameter("nombre");
     String apellido= request.getParameter("apellido");
     String cargo= request.getParameter("cargo");
     String usuarioLogin= request.getParameter("usuarioLogin");
     String password= request.getParameter("password");
   
      stmt.setString(1, IdUsuario);
      stmt.setInt(2, idRol);
      stmt.setString(3, nombre);
      stmt.setString(4, apellido);
      stmt.setString(5, cargo);
      stmt.setString(6, usuarioLogin);
      stmt.setString(7, password);

      // Execute the completed statement.
     // String but = request.getParameter("action");
     
      if (request.getParameter("action").equals("Guardar")){
      int res = stmt.executeUpdate();
      out.println("Usuario Insertado Satisfactoriamente.<br />\n");
      
      String redirectURL = "http://200.35.185.35:8080/DONACIONESv2/main.htm#";
      response.sendRedirect(redirectURL);
 
      //getServletContext().getRequestDispatcher("../../main.htm").forward(request, response);
      }
      stmt.close();
      stmt = null;

     
    }

    
  }

  // Start the main body of the code.
  try {
    // Instantiate the functions class.
    PageFunctions funcs = new PageFunctions();

    // Connect to the BIBLIOTECA schema of the ORACLE database.
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "biblioteca", "Pa55w0rd");

   out.println("Connected sucessfully.<br /><br />\n");

   funcs.example_insert(conn, out, request, response);
   
    conn.close();
    conn = null;

    out.println("<br />Disconnected sucessfully.<br /><br />\n");
  } catch (Exception ex) {
    //out.println("    Error: " + ex.getLocalizedMessage() + "<br><br>\n");
  }
%>
