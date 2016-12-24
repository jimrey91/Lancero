<%-- 
    Document   : Encabezado2
    Created on : 04-26-2013, 11:46:00 PM
    Author     : Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
  <script type="text/javascript" src="js/gen_validatorv4.js"></script>
<!DOCTYPE html>
<header>
    <div id='main'> 
      <div id="logo">
        <div id="logo_text">
            
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="">El Lancero<span class="logo_colour"> Armas, Accesorios y Más</span></a></h1>
          <h2>El Salvador </h2>
        </div>
      </div>
      <nav>       
          <%  
          
           String rol = "nadie";
          if(session.getAttribute("rol")!=null){
          
            rol = (String) session.getAttribute("rol");//Recoge la session
           
           }
          
          
          if(rol.equals("Cliente")){
          
          %>
          
          <ul class="sf-menu" id="nav">
          <li class="selected"><a href="Inicio.jsp">Inicio</a></li>
          <li><a href="#">Catalogo</a>
             <ul>
                 <li> <a href="VerArmas">Armas</a></li>
                 <li><a href="Municiones">Municiones</a></li>
                 <li><a href="Accesorios">Accesorios</a></li>
               </ul>
          <li><a href="#">Servicios</a>
            <ul>
                <li><a href="#">Reservas en Línea</a>
                    <ul>
                        <a href="Reservas">Hacer Reservas</a>

                    </ul>
            </ul>
          <li><a href="Contactenos.jsp">Contactenos</a></li>              
          <li><a href="Cerrar">Cerrar Sesión</a> </li>
          </ul>        
          
                      </ul>
          
          <% } else{
          
              if(rol.equals("Administrador")){
              
%>              
  
          <ul class="sf-menu" id="nav">
          <li class="selected"><a href="Inicio.jsp">Inicio</a></li>
          <li><a href="#">Inventario</a>
             <ul>
                 <li> <a href="VerArmas">Armas</a></li>
                 <li><a href="Municiones">Municiones</a></li>
                 <li><a href="Accesorios">Accesorios</a></li>
             </ul>
          <li><a href="#">Actividad</a>
            <ul>
                <li><a href="#">Registrar producto</a>
                    <ul>
                        <li><a href="AgregarArmas">Registrar Armas</a></li>
                        <li><a href="AgregarMuniciones">Registrar Municiones</a></li>
                        <li><a href="AgregarAccesorio">Registrar Accesorios</a></li>
                    </ul>
                <li><a href="#">ModificarProducto</a>
                    <ul>
                        <li><a href="ModificarArmas">Modificar Arma</a></li>
                        <li><a href="ModificarMunicion">Modificar municion</a></li>
                        <li><a href="ModificarAccesorios">Modificar Accesorio</a></li>
                    </ul>
                
            </ul>          
          <li><a href="#">Reporteria</a>
              <ul>
                  <li><a href="ReporteReserva">Reporte Reserva</a></li>
                  <li><a href="ReporteClientes">Reporte Cliente</a></li>
              </ul>
          <li><a href="#">Config</a>
              <ul>
                  <li><a href="Mantenimientos">Mantenimiento de Catalogos</a></li>
              </ul>
          <li><a href="Cerrar">Cerrar Sesión</a>
          </ul>


<%
              
              } else {
              
              
%>              


     <ul class="sf-menu" id="nav">
          <li class="selected"><a href="index.jsp">Inicio</a></li>
           <li><a href="#">Catalogo</a>
             <ul>
                 <li> <a href="VerArmas">Armas</a></li>
                 <li><a href="Municiones">Municiones</a></li>
                 <li><a href="Accesorios">Accesorios</a></li>
               </ul>
          <li><a href="Empresa.jsp">Nuestra Empresa</a>
          <li><a href="Contactenos.jsp">Contactenos</a></li>              
          </ul>
<%
              
              }

} %>
        
          
      </nav>
</header>