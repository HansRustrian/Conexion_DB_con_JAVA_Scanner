
package com.mycompany.conexion;

import  java.sql.Connection;
import  java.sql.DriverManager;

public class Conexion {
    
        Connection con;
        String url="jdbc:mysql://localhost:3306/colegio";
        String user="root";
        String pass="";
        
       public Connection Conectar(){
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
