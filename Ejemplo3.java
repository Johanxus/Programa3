/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package xddd.ejemplo3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;



public class Ejemplo3 {
 public ArrayList usuarios ;
    
    public static void main(String name){
        String Usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbc_prueba1";
        Connection conexion1;
        Statement statement;
        ResultSet rs;
         String a = name;
        try {
            conexion1 = DriverManager.getConnection(url, Usuario, password);
            statement = conexion1.createStatement();
            rs = statement.executeQuery("SELECT * FROM datos_usuarios");
            while(rs.next()){
             System.out.println(rs.getString("Nombre"));
            }
          
            String sql = "INSERT INTO datos_usuarios (Nombre) VALUES ('" + a + "')";
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizar(String q,String y){
      String Usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbc_prueba1";
        Connection conexion1;
        Statement statement;
        ResultSet rs;
        String nombre = y;
        String id = q;
        try {
            conexion1 = DriverManager.getConnection(url, Usuario, password);
            statement = conexion1.createStatement();
            rs = statement.executeQuery("SELECT * FROM datos_usuarios");
 
            String sql = "UPDATE `datos_usuarios` SET `Nombre` = '"+ nombre +"' WHERE `datos_usuarios`.`ID` = "+ id + "; ";
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo3.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public void consultar(){
        String Usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbc_prueba1";
        Connection conexion1;
        Statement statement;
        ResultSet rs;
       usuarios = new ArrayList<>();
       
        try {
            conexion1 = DriverManager.getConnection(url, Usuario, password);
            statement = conexion1.createStatement();
            rs = statement.executeQuery("SELECT * FROM datos_usuarios");
            int i = 1;
            while(rs.next()){
             String nm = rs.getString("Nombre");
             usuarios.add(i+" " +nm);
             i++;
            }
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo3.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void eliminar(String q){
        String Usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbc_prueba1";
        Connection conexion1;
        Statement statement;
        ResultSet rs;
        String id = q;
    
     try {
         conexion1 = DriverManager.getConnection(url, Usuario, password);
         statement = conexion1.createStatement();
         rs = statement.executeQuery("SELECT * FROM datos_usuarios");
          String sql = "DELETE FROM datos_usuarios WHERE `datos_usuarios`.`ID` = "+id+"";
         statement.execute(sql);
     } catch (SQLException ex) {
         Logger.getLogger(Ejemplo3.class.getName()).log(Level.SEVERE, null, ex);
     }
            
    }
}