/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.ComentariosFacade;
import ejb.UsuarioFacade;
import ejb.VinculohashtagFacade;
import ejb.VinculouserFacade;
import entity.Comentarios;
import entity.Usuario;
import entity.Vinculohashtag;
import entity.Vinculouser;
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
public class anadir_mensaje extends HttpServlet {
    @EJB
    private ComentariosFacade comentariosFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private VinculohashtagFacade vinculohashtagFacade;
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
        
        String texto = request.getParameter("texto");
        
        if(texto.length() >= 1 && texto.length() <= 140)
        {
            Comentarios co = new Comentarios();
            co.setTexto(texto);
            co.setUser(usuarioActual);
            
            String[] sel = texto.split("#");
            String[] sel2 = texto.split("@");
            
            comentariosFacade.create(co);
            
            if(sel.length > 1)
            {
                String selected = sel[1];
                String[] corte = selected.split(" ");
                String hashTag = corte[0];

                Vinculohashtag vih = new Vinculohashtag();
                vih.setIdComentario(co);
                vih.setHashtag(hashTag);
                
                vinculohashtagFacade.create(vih);
            }
            
            if(sel2.length > 1)
            {
                String selected2 = sel2[1];
                String[] corte = selected2.split(" ");
                String user = corte[0];
                
                Usuario userVin = new Usuario();
                for(Usuario u : listaUsuarios)
                    if(u.getUser().equals(user))
                        userVin = u;
                if(userVin.getUser() != null)
                {
                    Vinculouser vus = new Vinculouser();
                    vus.setIdComentario(co);
                    vus.setUser(userVin);
                    vinculouserFacade.create(vus);
                }
            }
            request.getRequestDispatcher("actualizarPagina.do").forward(request, response);
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
