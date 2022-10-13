
package com.mycompany.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ColegioDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    Conexion acceso = new Conexion();
    
    public void listar(){
        
        String sql = "Select * from alumnos";
        try {
            
            
            //INICIALIZA LA BASE DE DATOS (REALIZA CONEXION)
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                System.out.println("ID        : "+rs.getInt(1));
                System.out.println("Nombre    : "+rs.getString(2));
                System.out.println("Direccion : "+rs.getString(3));
                System.out.println("Telefono  : "+rs.getInt(4));
                System.out.println("************************************");
                
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void crear(int codigo, String nombre, String direccion, int telefono){
        
        //SENTENCIA SQL PARA INSERTAR VALORES EN BASE DE DATOS 
        //LOS SIGNOS DE INTERROGACION SOLO SON PARA HACER REFERENCIA A LOS VALORES A MOVER
        String sql = "insert into alumnos (codigo,nombre,direccion,telefono) values (?,?,?,?);";
        
        try {
            
            //PARA INSERTAR DATOS FORMA 1 : 
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            //AQUI LE DAMOS LOS VALORES A ENVIAR
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            
            //CUANDO TENEMOS LA DATA, EJECUTAMOS EL UPDATE
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    
    public void modificar(int codigo, String nombre, String direccion, int telefono){
        
        String sql = "update alumnos set nombre=?, direccion=?, telefono=? where codigo=?;";
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            //AQUI EL ORDEN DE POSICION 1, 2, 3 Y 4 LO DA EL CODIGO DE SQL
            //PORQUE CODIGO QUEDA EN CUARTO LUGAR EN EL WHERE, NO ES
            //EN EL ORDEN DE LAS COLUMNAS DE LA BASE DE DATOS
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setInt(4, codigo);
            
            //ACTUALIZAMOS, GRABAMOS O ELIMINAMOS
            ps.executeUpdate();
            
            
        } catch (Exception e) {
        }
        
    }
    
    
    public void eliminar(int codigo){
        
        //EL SIGNO ? ES PORQUE ABAJO SE PUEDE HACER EL PS.* QUE ES DONDE SE 
        //MANDA LA INFORMACION
        //FORMA 1 DE ENVIAR PARAMETROS A SQL
        String sql = "delete from alumnos where codigo=?;";
        //FORMA 2 DE ENVIAR DATOS A SQL
        //String sql = "delete from alumnos where codigo="+codigo+";";
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    
    
    

    public static void main(String[] args) {
        ColegioDAO cl = new ColegioDAO();
        cl.listar();
        
        System.out.println("////////////////////////////////");
        //cl.modificar(3, "Oscar", "KM 15", 11111111);
        cl.eliminar(3);
        cl.listar();
//        cl.crear(3, "Marcos", "KM 11", 00000000);
//        cl.listar();
    }

    
}
