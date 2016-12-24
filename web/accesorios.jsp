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
      <ul id="images">
        <li><img src="images/1.jpg" width="600" height="300" alt="seascape_one" /></li>
        <li><img src="images/2.jpg" width="600" height="300" alt="seascape_two" /></li>
        <li><img src="images/3.jpg" width="600" height="300" alt="seascape_three" /></li>
        <li><img src="images/4.jpg" width="600" height="300" alt="seascape_four" /></li>
        <li><img src="images/5.jpg" width="600" height="300" alt="seascape_five" /></li>
        <li><img src="images/6.jpg" width="600" height="300" alt="seascape_seascape" /></li>
      </ul>
      <div id="sidebar_container">

      </div>
      <div class="content">
          <center>
              <h3>Accesorios</h3>
              <table border="0">
                  <tbody>
                      <tr>
                          <td><img src="images/no disponible.jpg" width="256" height="128" alt="no disponible"/>
                          </td>
                          <td><img src="images/no disponible.jpg" width="256" height="128" alt="no disponible"/>
                          </td>
                      </tr>
                      <tr>
                          <td><center><h5></h5></center></td>
                          <td><center><h5></h5></center></td>
                      </tr>
                      <tr>
                          <td><img src="images/no disponible.jpg" width="256" height="128" alt="no disponible"/>
                          </td>
                          <td><img src="images/no disponible.jpg" width="256" height="128" alt="no disponible"/>
                          </td>
                      </tr>
                      <tr>
                          <td><center><h5></h5></center></td>
                          <td><center><h5></h5></center></td>
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
