/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.ComentariosFacade;
import ejb.SeguidoresFacade;
import ejb.UsuarioFacade;
import ejb.VinculohashtagFacade;
import entity.Comentarios;
import entity.Vinculohashtag;
import java.io.IOException;
import java.util.ArrayList;
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
public class paginaHashtag extends HttpServlet {
    @EJB
    private ComentariosFacade comentariosFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private VinculohashtagFacade vinculohashtagFacade;
    @EJB
    private SeguidoresFacade seguidoresFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hashtag = request.getParameter("x");
        List<Comentarios> listaComentarios = comentariosFacade.findAll();
        List<Vinculohashtag> listaVi = vinculohashtagFacade.findAll();
        
        List<Comentarios> listaComentariosHashtag = new ArrayList();
        
        for(Comentarios co : listaComentarios)
            for(Vinculohashtag vi : listaVi)
                if(vi.getHashtag().equals(hashtag) && co.getId().equals(vi.getIdComentario().getId()))
                    listaComentariosHashtag.add(co);
        
        request.getSession().setAttribute("hashtagActual", hashtag);
        request.getSession().setAttribute("listaComentariosHashtag", listaComentariosHashtag);
        request.getRequestDispatcher("paginaHashtag.jsp").forward(request, response);
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
