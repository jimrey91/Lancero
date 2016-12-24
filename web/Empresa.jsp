
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
          
<h1>EL LANCERO</h1> 
<h4>Es una ARMERIA dedicada al mundo del OCIO, DEFENSA Y AVENTURA</h4>
<p align="justify"><font color="black">Nuestra experiencia, con mas de 20 años en el sector nos ha &nbsp;incentivado para montar una gran armeria, moderna, con todos los servicios profesionales que la sociedad actual demanda.</p>

<p align="justify"><font color="black">En definitiva somos un grupo de profesionales a tu servicio, dispuestos a cubrir cualquier necesidad, tanto si eres <strong>PROFESIONAL COMO AFICIONADO.</strong></p></div></div>


<p align="justify"><font color="black">Abarcamos desde material estrictamente profesional, para cuerpos y fuerzas de seguridad, contando con la mayor y mejor exposición de material táctico y de entrenamiento del mercado nacional, hasta todo tipo de material para el ocio y la aventura, tales como:</p>


<table border="0">
    <tr>
        <td valign="top">
            <h3>Accesorios</h3>
                <ul>
                    <li>guantes</li>
                    <li>brújulas</li>
                    <li>linternas</li>
                    <li>gafas</li>
                    <li>relojes</li>
                    <li>prismáticos</li>
                    <li>visores nocturnos</li>
                    <li>chalecos tácticos</li>
                    <li>chalecos anti-balas</li>
                </ul>
            
        </td>
        
        <td valign="top">
            
            <h3>Replicas de todo tipo de ARMAS</h3>
                <ul>
                    <li>aire comprimido</li>
                    <li>airsoft</li>
                    <li>detonadoras</li>
                    <li>armas de coleccion</li>
                </ul>

            
        </td>
        
    </tr>
    
</table>







<p>Estamos abiertos a cualquier sugerencia para mejorar, <span>ven a conocer nuestra Armeria deportiva.</span> </p>



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