<%-- 
    Document   : principal
    Created on : 26-nov-2010, 12:25:36
    Author     : ING.FERNANDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%

   String codigo = (String) session.getAttribute("cod");//Recoge la session
   String apellidos = (String) session.getAttribute("ape");//Recoge la session
   String nombres = (String) session.getAttribute("nom");//Recoge la session
   String usuario = (String) session.getAttribute("usu");//Recoge la session
   String rol = (String) session.getAttribute("rol");//Recoge la session

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1><%=rol%>,<%=nombres%> <%=apellidos%> </h1>

        <h1><%=codigo%></h1>

        <h1><%=usuario%></h1>

        <h1><a href="cerrar.jsp">CERRAR SESION</a></h1>

    </body>
</html>
