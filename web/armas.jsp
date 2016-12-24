<%@ page import="java.sql.*" %>
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
<%@include file="Encabezado2.jsp"%>
    <div id="site_content">
      
      <div id="sidebar_container">

      </div>
      <div class="content">
          <center>
              <h3>Catalogo de Armas</h3>
              <table border="0">
                  <tbody>
                      <tr><th><center>Arma</center></th><th>Marca</th><th>Modelo de Arma</th><th>Color</th><th>Precio</th></tr>
                      
                        <tr><td><img src="images/taurus_millenium.jpg" width="200" height="100"/></td>
                         <td><center>Taurus</center></td>
                            <td><center>Millenium</center></td>
                            <td><center>Negro</center></td>
                            <td><center>$250</center></td>
                        </tr>
                          
                      
                      
                  </tbody>
              </table>
          </center>        
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
