package Actividad_conexion_DB_JAVA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class funciones_de_menu {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    Actividad_conexion_DB_JAVA.conexion acceso = new Actividad_conexion_DB_JAVA.conexion();
    
    public void listar(){
        
        String sql = "Select * from menu_pasteles";
        try {
            
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {                
                contador++;
                System.out.println("");
                System.out.println("**** REGISTRO No. "+contador+" ****");
                System.out.println("Codigo        : "+rs.getInt(1));
                System.out.println("Nombre        : "+rs.getString(2));
                System.out.println("Unidades disp : "+rs.getInt(3));
                System.out.println("Sucursal      : "+rs.getString(4));
                System.out.println("Fecha Ingreso : "+rs.getDate(5));
                System.out.println("Precio        : Q."+rs.getInt(6));
                
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void desplegar(){
        
        String sql = "Select * from menu_pasteles";
        try {
            
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            System.out.println("|*************************************   DATOS   **************************************|");
            System.out.println("|Codigo|Nombre Producto          |Unidades|Sucursal            |Fecha Ingreso|Precio QQ|");
            
            while (rs.next()) {                
                System.out.println("|"+rs.getInt(1)+"     |"+rs.getString(2)+"|"+rs.getInt(3)+"      |"+rs.getString(4)+"|"+rs.getDate(5)+"   |"+rs.getInt(6)+"      |");
                
            }
                
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("|**************************************************************************************|");
        
    }
    
    
    public void crear(int codigo, String nombre, int unidades, String sucursal, String fecha, int precio){
        
        String sql = "insert into menu_pasteles (codigo,nombre,unidades_disp,sucursal,fecha_ingreso,precio) values (?,?,?,?,?,?);";
        
        try {
            
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, unidades);
            ps.setString(4, sucursal);
            ps.setString(5, fecha);
            ps.setInt(6, precio);
            
            ps.executeUpdate();
            
            System.out.println(" *** PRODUCTO AÑADIDO EXITOSAMENTE A INVENTARIO ***");
            
        } catch (Exception e) {
        }
    }
    
    
    public void modificar(String nombre, int unidades, String sucursal, String fecha, int precio, int codigo){
        
        String sql = "update menu_pasteles set nombre=?, unidades_disp=?, sucursal=?, fecha_ingreso=?, precio=? where codigo=?;";
        
        try {
            
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setInt(2, unidades);
            ps.setString(3, sucursal);
            ps.setString(4, fecha);
            ps.setInt(5, precio);
            ps.setInt(6, codigo);
            
            ps.executeUpdate();
            
            System.out.println(" *** PRODUCTO MODIFICADO EXITOSAMENTE EN INVENTARIO ***");
            
        } catch (Exception e) {
        }
        
    }
    
    
    public void eliminar(int codigo){
        
        String sql = "delete from menu_pasteles where codigo=?;";
        
        try {
            
            con = acceso.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            
            System.out.println(" *** REGISTRO ELIMINADO EXITOSAMENTE DE INVENTARIO ***");
            
        } catch (Exception e) {
        }
        
    }
    
    
}
