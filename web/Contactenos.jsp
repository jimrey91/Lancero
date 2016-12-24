
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="Conexion.jsp"%>


<!DOCTYPE HTML>
<html>

<head>
  <title>El Lancero</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  
  
</head>

<body>
    

    
  <div id="main">
       <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="">El Lancero<span class="logo_colour"> Armas, Accesorios y Más</span></a></h1>
          <h2>El Salvador</h2>
        </div>
      </div>            
      <nav> 
          <ul class="sf-menu" id="nav">
          <li class="selected"><a href="index.jsp">Inicio</a></li>
          <li><a href="Empresa.jsp">Nuestra Empresa</a>
          <li><a href="Contactenos.jsp">Contactenos</a></li>              
          </ul>
      </nav> 
    </header>
    <div id="site_content">
      
      <div id="sidebar_container">
       <div class="sidebar">
     
        </div>
      </div>
      <div class="content">
          
 
 <h1>Contáctenos</h1>
      <p align="justify"><font color="black">Gracias por su interés y por visitar nuestro sitio web. Para solventar cualquier duda, solicitar información sobre nuestros productos y/o servicios o enviar alguna sugerencia por favor llene con sus datos los campos del siguiente formulario o escríbanos al siguiente correo electrónico: <a href="mailto:contactanos@lancero.com">contactanos@lancero.com </a></p>
	
	  <!-- error de envio -->
	  			
            <form method="post" >
           <label> Nombres: * </label>
           <input name="Nombres" type="text" id="Nombres" size="50" style="width: 340px;" maxlength="100" />
           <br />
           <label> Apellidos: *</label>
           <input name="Apellidos" type="text" id="Apellidos" size="50" style="width: 340px;" maxlength="100" />
           <br />
           
           <label>E-mail: *</label>
           <input name="Email" type="text" id="Email" size="50" style="width: 340px;" maxlength="100" />
           <br />
           <label>Empresa:</label>
           <input name="Empresa" type="text" id="Empresa" size="50" style="width: 340px;" maxlength="100" />
           <br />
           <label>País: *</label>
           <input name="Pais" type="text" id="Pais" size="50" style="width: 340px;" maxlength="100" />
           <br />
		   <label>Teléfono: *</label>
		   <input name="Telefono" type="text" id="Telefono" style="width: 100px;" maxlength="9" />
           <br />
		   <label>¿Por qué medio se entero de nosotros?: *</label>
		   <select name="SeEnteroMedio" id="SeEnteroMedio" >
			<option value=""></option>
			<option value="Prensa">Prensa</option>
			<option value="Radio">Radio</option>
			<option value="Redes sociales">Redes sociales</option>
			<option value="Publicidad en internet">Publicidad en internet</option>
			<option value="Otro">Otro</option>
		   </select>
		   <input name="SeEnteroMedioOtro" type="text" id="SeEnteroMedioOtro" maxlength="100" style="display: none; width: 340px;" disabled="disabled" />
           <br />
           <label>Mensaje: *</label>
           <textarea name="Mensaje" style="width: 340px;" rows="8" id="Mensaje"></textarea>
          
		   <br />
		   
		   
           <br />
          
           <input name="Enviar" type="submit" id="Enviar" value="Enviar Mensaje" />
         </p>
         <p>&nbsp;</p>
         
      </form>


      </div>
    </div>
    <footer>
      El Lancero © 2013
    </footer>
  </div>
  <p>&nbsp;</p>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
  <script type="text/javascript" src="js/jquery.kwicks-1.5.1.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('#images').kwicks({
        max : 600,
        spacing : 2
      });
      $('ul.sf-menu').sooperfish();
    });
  </script>
  
</body>
</html>