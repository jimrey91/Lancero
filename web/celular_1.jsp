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
          <h1><a href="index.html">El Lancero<span class="logo_colour"> Armas, Accesorios y Más</span></a></h1>
          <h2>El Salvador</h2>
        </div>
      </div>
      <nav>        
          <ul class="sf-menu" id="nav">           
          </ul>        
      </nav>
    </header>
    <div id="site_content">
           
      <div class="content">
          <h3>Ingresar Celular</h3>         
          <form action="enviar" method="POST">
              <table border="0">
                  <tbody>
                      <tr>
                          <td>Celular 1: </td>
                          <td><input type="text" name="nombre" value="" /> Principal</td>
                      </tr>
                      <tr>
                          <td>Celular 2: </td>
                          <td><input type="text" name="nombre" value="" /> Opcional</td>
                      </tr>
                      <tr>
                          <td>Celular 3: </td>
                          <td><input type="text" name="nombre" value="" /> Opcional</td>
                      </tr>
                      <tr>
                          <td><input type="button" value="Guardar" onClick="location.href='registrarse.jsp'"/> </td>
                          <td></td>
                      </tr>
                  </tbody>
              </table>          
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
