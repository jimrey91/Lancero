<%-- 
    Document   : delete
    Created on : 05-13-2013, 10:03:31 PM
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%

String id=request.getParameter("codigo_acc");
int no=Integer.parseInt(id);
int sumcount=0;
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/el_lancero", "root", "root");
Statement st = conn.createStatement();
st.executeUpdate("DELETE FROM accesorio WHERE codigo_acc = '"+no+"'");
response.sendRedirect("ModificarAccesorio.jsp");
}
catch(Exception e){}
%>

