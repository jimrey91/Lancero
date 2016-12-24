package misservlets;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

    private final String driver= "com.mysql.jdbc.Driver";
    private final String url= "jdbc:mysql://localhost:3306/el_lancero?zeroDateTimeBehavior=convertToNull";
    private final String user= "root";
    private final String password= "Sql2015";


    // creamos un metodo de tipo Connection
    public Connection getConnection() {
    Connection cn= null;

        try{
            Class.forName(driver).newInstance();//Obtenmos el driver de mysql
            cn= DriverManager.getConnection(url, user, password);//Conectamos a nuestra data

        } catch(SQLException e) {
            System.out.println(e.toString());
            cn= null;
        } catch(ClassNotFoundException e) {
            System.out.println(e.toString());
            cn= null;
        } catch (InstantiationException e) {
            System.out.println(e.toString());
            cn= null;
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
            cn= null;
        }
        
        return cn;
    }



}
