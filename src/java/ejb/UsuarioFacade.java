/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author YerkoAndrei
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public boolean findByUser(String user)
    {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.user = :user");
        query.setParameter("user", user);
        if(query.getResultList().size()  > 0)
            return true;
        return false;
    }
    public boolean findByPass(String pass)
    {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.pass = :pass");
        query.setParameter("pass", pass);
        if(query.getResultList().size()  > 0)
            return true;
        return false;
    }
}
