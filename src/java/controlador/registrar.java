/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.UsuarioFacade;
import entity.Usuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YerkoAndrei
 */
public class registrar extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtUser");
        String pass= request.getParameter("txtPass");
        String pass2= request.getParameter("txtPass2");
        String nombre= request.getParameter("txtNombre");
        String error = "";
        
        if(user.trim().equals("") || pass.trim().equals("") || pass2.trim().equals("") || nombre.trim().equals(""))
        {
            error = "Campos vacios";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else
        {
            if(pass.equals(pass2))
            {
                Usuario u = new Usuario();
                u.setUser(user);
                u.setPass(pass);
                u.setNombre(nombre);

                if(usuarioFacade.findByUser(user))
                {
                    error = "Usuario ya existe";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else
                {
                    usuarioFacade.create(u);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            else
            {
                error = "Contraseñas distintas";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
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
