package Actividad_conexion_DB_JAVA;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    
    Connection con;
        String url="jdbc:mysql://localhost:3306/pasteleria";
        String user="root";
        String pass="";
        
       public Connection conectar(){
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con=DriverManager.getConnection(url,user,pass);
           } catch (Exception e) {
               System.out.println("Error : ");
               System.out.println(e);
           }
           return con;
        
    }
       
    
}
