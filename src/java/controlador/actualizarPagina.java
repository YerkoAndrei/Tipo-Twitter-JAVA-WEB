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
import ejb.VinculouserFacade;
import entity.Comentarios;
import entity.Seguidores;
import entity.Usuario;
import entity.Vinculohashtag;
import entity.Vinculouser;
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
public class actualizarPagina extends HttpServlet {
    @EJB
    private ComentariosFacade comentariosFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private VinculohashtagFacade vinculohashtagFacade;
    @EJB
    private SeguidoresFacade seguidoresFacade;
    @EJB
    private VinculouserFacade vinculouserFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userActual = (String)request.getSession().getAttribute("sesionActual");
        Usuario usuarioActual = new Usuario();
        List<Usuario> listaUsuarios = usuarioFacade.findAll();
        for(Usuario u : listaUsuarios)
            if(u.getUser().equals(userActual))
                usuarioActual = u;
        listaUsuarios.remove(usuarioActual);
        String nombreSesionActual = usuarioActual.getNombre();
        
        List<Comentarios> listaCo = comentariosFacade.findAll();
        List<Comentarios> listaComentarios = new ArrayList();
                
        List<Seguidores> listaSeguidores = seguidoresFacade.findAll();
        List<Vinculohashtag> listaVi = vinculohashtagFacade.findAll();
        
        List<String> listaHashtags = new ArrayList();
        for(Vinculohashtag vi : listaVi)
            if(!listaHashtags.contains(vi.getHashtag()))
                listaHashtags.add(vi.getHashtag());
        
        
        for(Comentarios co : listaCo)
        {
            if(co.getUser().getUser().equals(userActual))
                listaComentarios.add(co);
            for(Seguidores seg : listaSeguidores)
                if(co.getUser().getUser().equals(seg.getUserSeguido().getUser()) && seg.getUserSeguidor().getUser().equals(userActual))
                    listaComentarios.add(co);
        }
        
        
        request.getSession().setAttribute("listaUsuarios", listaUsuarios);
        request.getSession().setAttribute("listaComentarios", listaComentarios);
        request.getSession().setAttribute("listaHashtags", listaHashtags);
        request.getSession().setAttribute("nombreSesionActual", nombreSesionActual);
        request.getRequestDispatcher("principal.jsp").forward(request, response);
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
