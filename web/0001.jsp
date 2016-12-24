<%-- 
    Document   : page_inicio
    Created on : 10-oct-2011, 23:08:58
    Author     : Lobo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String pag = request.getParameter("pag");
    String titu = request.getParameter("titu");    
%>

<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>

<div class="clear"></div> <!-- End .clear -->
	
	<div class="content-box"><!-- Start Content Box -->
		
		<div class="content-box-header">
			
			<h3><% out.println(titu); %></h3>
								
			<div class="clear"></div>
			
		</div> <!-- End .content-box-header -->
		
		<div class="content-box-content">
			

			
			<div class="tab-content" id="tab1">
			
				<form action="./resources/partial_forms/0001.jsp" method="POST" name="myform" id="myform">
					
					<fieldset> 
						
						<p>
                                                    <label>NOMBRE</label>
                                                    <div id='myform_nombre_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text"  name="nombre" onKeyPress="return sololetras(event)" />
						</p>
						
						<p>
                                                    <label>APELLIDO</label>
                                                    <div id='myform_apellido_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text" name="apellido" onKeyPress="return sololetras(event)" />
						</p>
						<p>
                                                    <label>NUMERO DE DUI</label>
                                                    <div id='myform_numdui_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text" name="numdui" onKeyPress="return soloNumeros(event)" maxlength="10" /> 
                                                   <br /><small>DUI sin guiones</small>
						</p>
						<p>
                                                    <label>NUMERO DE NIT</label>
                                                    <div id='myform_numnit_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text" name="numnit"  onKeyPress="return soloNumeros(event)" maxlength="14"  /> 
                                                    <br /><small>NIT sin guiones</small>
						</p>
						<p>
                                                    <label>DIRECCION</label>
                                                    <div id='myform_direccion_errorloc' class="error_strings"></div>
                                                    <input class="text-input large-input" type="text" name="direccion" onKeyPress="return sololetras(event)" /> 
						</p>						
						
                                                <p>
                                                    <label>TELEFONO</label>
                                                    <div id='myform_telefono_errorloc' class="error_strings"></div>
                                                    <input class="text-input small-input" type="text" name="telefono" onKeyPress="return soloNumeros(event)" maxlength="8"  />
						</p>
						<p>
                                                    <label>CORREO ELECTRONICO</label>
                                                    <div id='myform_email_errorloc' class="error_strings"></div>
                                                    <input class="text-input medium-input" type="text" name="email"/>
                                                    
						</p>
                                                                                                
						<p>
                                                    <input class="button" type="submit" value="Guardar" name="action"/>
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

                                        frmvalidator.addValidation("nombre","req","<span class='input-notification error png_bg'>Digite el Nombre del Donador</span>");
                                        frmvalidator.addValidation("nombre","minlen=4","<span class='input-notification error png_bg'>Valor m&iacute;nimo de 4 caracteres</span>");
                                        frmvalidator.addValidation("nombre","alpha_s","<span class='input-notification error png_bg'>No se permiten n&uacute;meros en el Nombre del Donador</span>");
                                        
                                        frmvalidator.addValidation("apellido","req","<span class='input-notification error png_bg'>Digite el Apellido del Donador</span>");
                                        frmvalidator.addValidation("apellido","minlen=4","<span class='input-notification error png_bg'>Valor m&iacute;nimo de 4 caracteres</span>");
                                        frmvalidator.addValidation("apellido","alpha_s","<span class='input-notification error png_bg'>No se permiten n&uacute;meros en el Apellido del Donador</span>");
                                        
                                        frmvalidator.addValidation("numdui","req","<span class='input-notification error png_bg'>Digite el N&uacute;mero de DUI del Donador</span>");
                                        frmvalidator.addValidation("numdui","minlen=10","<span class='input-notification error png_bg'>Valor m&iacute;nimo de 10 caracteres</span>");
                                        frmvalidator.addValidation("numdui","numeric","<span class='input-notification error png_bg'>Unicamente permitidos los N&uacute;meros</span>");
                                        
                                        frmvalidator.addValidation("numnit","req","<span class='input-notification error png_bg'>Digite el N&uacute;mero de NIT del Donador</span>");
                                        frmvalidator.addValidation("numnit","minlen=14","<span class='input-notification error png_bg'>Valor m&iacute;nimo de 14 caracteres</span>");
                                        frmvalidator.addValidation("numnit","numeric","<span class='input-notification error png_bg'>Unicamente permitidos los N&uacute;meros</span>");
                                        
                                        frmvalidator.addValidation("direccion","req","<span class='input-notification error png_bg'>Digite la Direccion del Donador</span>");
                                        frmvalidator.addValidation("direccion","alpha_s","<span class='input-notification error png_bg'>No se permiten n&uacute;meros en Direccion del Donador</span>");
                                        
                                        frmvalidator.addValidation("telefono","req","<span class='input-notification error png_bg'>Digite el N&uacute;mero de Tlefono del Donador</span>");
                                        frmvalidator.addValidation("telefono","minlen=8","<span class='input-notification error png_bg'>Valor m&iacute;nimo de 8 caracteres</span>");
                                        frmvalidator.addValidation("telefono","numeric","<span class='input-notification error png_bg'>Unicamente permitidos los N&uacute;meros</span>");
                                        
                                        frmvalidator.addValidation("email","req","<span class='input-notification error png_bg'>Digite el Correo Electronico del Donador</span>");
                                        frmvalidator.addValidation("email","email","<span class='input-notification error png_bg'>Digite un Correo Electronico válido</span>");
                                        
                                        
                                        
                                        
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
      String sql = "INSERT INTO BIBLIOTECA.DONADORES (ID_DONADOR, NOMBRE, APELLIDO, NUM_DUI, NUM_NIT, DIRECCION, TELEFONO, E_MAIL, FECHA_REGISTRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);

      // Bind the value into the prepared statement.
 
     String IdDonador= "null";
     String nombre= request.getParameter("nombre");
     String apellido= request.getParameter("apellido");
     String numdui= request.getParameter("numdui");
     String numnit= request.getParameter("numnit");
     String direccion= request.getParameter("direccion");
     String telefono= request.getParameter("telefono");
     String email= request.getParameter("email");
     String fecha_reg= "20-12-2011";
  
   
      stmt.setString(1, IdDonador);
      stmt.setString(2, nombre);
      stmt.setString(3, apellido);
      stmt.setString(4, numdui);
      stmt.setString(5, numnit);
      stmt.setString(6, direccion);
      stmt.setString(7, telefono);
      stmt.setString(8, email);
      stmt.setString(9, fecha_reg);

      // Execute the completed statement.
     // String but = request.getParameter("action");
     
      //out.println(IdDonador+"<br />\n"+nombre+"<br />\n"+apellido+"<br />\n"+numdui+"<br />\n"+numnit+"<br />\n"+direccion+"<br />\n"+telefono+"<br />\n"+email+"<br />\n"+fecha_reg);
      
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