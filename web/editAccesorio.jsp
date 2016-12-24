<%-- 
    Document   : edit
    Created on : 05-13-2013, 09:53:59 PM
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.sql.*"%>

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
     
      <div id="sidebar_container">
        <div class="sidebar">
       
        </div>
      </div>
      <div class="content">
        <h3>Modificar Accesorio</h3>
        <form method="post" action="updateAccesorio.jsp">
        <table border="0">
            <tbody>
                
                <tr><th>Marca</th><th>Tipo Arma</th><th>Color</th><th>Talla</th><th>Precio ($)</th></tr>
<%
String id=request.getParameter("codigo_acc");
int no=Integer.parseInt(id);
int sumcount=0;
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/el_lancero", "root", "root");
String query = "select * from accesorio where codigo_acc='"+no+"'";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(query);
while(rs.next()){
%>
<tr>
<td><input type="text" name="codigo_marca" value="<%=rs.getString("codigo_marca")%>"></td>
<td><input type="text" name="codigo_tacc" value="<%=rs.getString("codigo_tacc")%>"></td>
<td><input type="text" name="codgio_color" value="<%=rs.getString("codigo_color")%>"></td>
<td><input type="text" name="talla_acc" value="<%=rs.getString("talla_acc")%>"></td>
<td><input type="text" name="precio_acc" value="<%=rs.getString("precio_acc")%>"></td>
<td><input type="hidden" name="codigo_acc" value="<%=rs.getString(1)%>"></td>
</tr>
<tr>
<td><input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;"></td>
</tr>
<%
}
}
catch(Exception e){}
%>                
                
            </tbody>
        </table>      
            </form>
      </div>
    </div>
    <%@include file="PiePagina.jsp"%>
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

