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
   <%@include file="Encabezado.jsp"%>
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
        <div class="sidebar">
          <h3>Acesso</h3>
          <form action="form" method="POST">
              <table border="0">
                  <tbody>
                      <tr>
                          <td>Usuario: </td>
                          <td><input type="text" name="usuario" value="" /></td>
                      </tr>
                      <tr>
                          <td>Contraseña: </td>
                          <td><input type="password" name="contraseña" value="" /></td>
                      </tr>
                      <tr>
                          <td><input type="button" value="Ingresar" /></td>
                          <td><a href="registrarse.jsp">Registrarse</a></td>
                      </tr>
                  </tbody>
              </table>
          </form>
          
        </div>
      </div>
      <div class="content">
          <h3>Reservar Armas</h3>         
          <form action="enviar" method="POST">
              <table border="0">
                  <tbody>
                      <tr>
                          <td><font color="red"></font> Seleccione Arma: </td>
                          <td><select name="listaArmas">
                                  <option></option>
                                  <option>Bereta</option>
                                  <option>Taurus</option>
                                  <option>38</option>
                                  <option>Colt</option>
                                  <option>Magnum</option>
                              </select></td>
                      </tr>
                      <tr>
                          <td><font color="red"></font> Cantidad: </td>
                          <td><select name="cantidadArma">
                                  <option></option>
                                  <option>1</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                              </select></td>
                      </tr>
                      <tr>
                          <td><font color="red"></font> Sucursal: </td>
                          <td><select name="dia">
                                  <option></option>
                                  <option>Casa Matriz</option>
                                  <option>Col. San Francisco</option>
                                  <option>Soyapango</option>
                                  <option>Col. Escalon</option>                                  
                              </select></td>
                      </tr>
                      <tr>
                          <td><input type="button" value="Reservar" onclick="location.href='confirmacionrsva.jsp'" /></td>
                          <td><input type="submit" value="Cancelar" /></td>
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
