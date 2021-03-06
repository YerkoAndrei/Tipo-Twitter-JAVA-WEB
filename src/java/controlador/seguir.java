/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.SeguidoresFacade;
import ejb.UsuarioFacade;
import entity.Seguidores;
import entity.Usuario;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YerkoAndrei
 */
public class seguir extends HttpServlet {
    @EJB
    private SeguidoresFacade seguidoresFacade;
    @EJB
    private UsuarioFacade usuarioFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userActual = (String)request.getSession().getAttribute("sesionActual");
        Usuario usuarioActual = new Usuario();
        List<Usuario> listaUsuarios = usuarioFacade.findAll();
        for(Usuario u : listaUsuarios)
            if(u.getUser().equals(userActual))
                usuarioActual = u;
        
        String usuarioSelect = request.getParameter("usuarioSelect");
        Usuario usuarioSeguir = new Usuario();
        for(Usuario u : listaUsuarios)
            if(u.getUser().equals(usuarioSelect))
                usuarioSeguir = u;
        
        Seguidores seg = new Seguidores();
        seg.setUserSeguidor(usuarioActual);
        seg.setUserSeguido(usuarioSeguir);
        
        seguidoresFacade.create(seg);
        request.getRequestDispatcher("actualizarPagina.do").forward(request, response);
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
        processRequest(request, response);
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
