<%-- 
    Document   : update
    Created on : 05-13-2013, 09:58:18 PM
    Author     : Mario
--%>

<%@page import="java.sql.*"%>

<%
String ide=request.getParameter("codigo_acc");
int num=Integer.parseInt(ide);
String marca=request.getParameter("codigo_marca");
String tipoAcc=request.getParameter("codigo_tacc");
String color=request.getParameter("codigo_color");
String talla=request.getParameter("talla_acc");
String precio=request.getParameter("precio_acc");

try{
Connection conn = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/el_lancero","root", "root");
Statement st=null;
st=conn.createStatement();
st.executeUpdate("update accesorio set codigo_marca='"+marca+"',codigo_tacc='"+tipoAcc+"',codigo_color="+color+",talla_acc='"+talla+"',precio_acc='"+precio+"' where codigo_acc='"+num+"'");
response.sendRedirect("ModificarAccesorio.jsp");
}
catch(Exception e){
System.out.println(e);
    }
%>