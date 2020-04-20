/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oskardashh
 */
public class UsuarioDAO implements Validar {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
   
    
    
    
    
    
    
    public List listar(){
        List<Usuario>lista=new ArrayList<>();
        
        String sql="select * from USUARIO";
        
        try{
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setDni(rs.getString(1));
                u.setNombre(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setDireccion(rs.getString(5));
                u.setContrasenia(rs.getString(6));
               
                
                lista.add(u);
            }
            
        } catch (Exception e){
            
        }
        return lista;
        
        
    }

    
    
    @Override
    public int validar(Usuario usr) {
        int r=0;
        
        String sql="Select * from Usuario where Dni=? and Contrasenia=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getDni());
            ps.setString(2, usr.getContrasenia());
            rs=ps.executeQuery();
            while (rs.next()){
                r=r+1;
                usr.setDni((rs.getString("dni")));
                usr.setContrasenia((rs.getString("contrasenia")));
                
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
        }catch (Exception ex){
            return 0;
        } 
    
    }
    
    public int agregar(Usuario u){
        
        int r=0;
        String sql="insert into usuario (dni, nombre, apellidos, "
                + "correo_electronico, direccion, telefono, contrasenia, activado, "
                + "rol_id, extranjero, frecuente)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getDni());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getDireccion());
            ps.setInt(6, u.getTelefono());
            ps.setString(7, u.getContrasenia());
            //ps.setString(8, u.getActivado());
            //ps.setString(9, u.getDni());
            //ps.setString(10, u.getDni());
            //ps.setString(11, u.getDni());
            
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
       
        }catch (Exception ex){
            
        
    
        }
        return r;
    }
    
}
