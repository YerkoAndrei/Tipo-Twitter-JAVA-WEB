/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Vinculohashtag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YerkoAndrei
 */
@Stateless
public class VinculohashtagFacade extends AbstractFacade<Vinculohashtag> {
    @PersistenceContext(unitName = "finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VinculohashtagFacade() {
        super(Vinculohashtag.class);
    }
    
}
