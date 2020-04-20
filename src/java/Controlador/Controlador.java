/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oskardashh
 */
public class Controlador extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
        Usuario usu = new Usuario();
        int r;
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        // COMENTARIO PRUEBA GIT
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String dni=request.getParameter("txtDNI");
            String contrasenia=request.getParameter("txtPassword");
            
            usu.setDni(dni);
            usu.setContrasenia(contrasenia);
            
            r=dao.validar(usu);
            if(r==1){
                request.getSession().setAttribute("dni", dni);
                request.getSession().setAttribute("contrasenia", contrasenia);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
              
            }else{
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch (accion){
            case "Listar":
                List<Usuario>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Listar.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
                break;
            
            case "Guardar";
                String id=request.getParameter("txt_dni");
                String nombre=request.getParameter("txt_nombre");
                String apellidos=request.getParameter("txt_apellidos");
            
                
                
            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
    
}
