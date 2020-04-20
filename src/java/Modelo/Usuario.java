/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author oskardashh
 */
public class Usuario {
    
    String dni;
    String nombre;
    String apellidos;
    String correo;
    String direccion;
    int telefono;
    String contrasenia;
    char activado;
    int rol_id;
    char extranjero;
    char frecuente;

    
    public Usuario(){
    }
    
    
    public Usuario(String dni, String nombre, String apellidos, String correo, String direccion, int telefono, String contrasenia, char activado, int rol_id, char extranjero, char frecuente) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.activado = activado;
        this.rol_id = rol_id;
        this.extranjero = extranjero;
        this.frecuente = frecuente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public char getActivado() {
        return activado;
    }

    public void setActivado(char activado) {
        this.activado = activado;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public char getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(char extranjero) {
        this.extranjero = extranjero;
    }

    public char getFrecuente() {
        return frecuente;
    }

    public void setFrecuente(char frecuente) {
        this.frecuente = frecuente;
    }
    
    
    
    
    
    
    
    
    
}
