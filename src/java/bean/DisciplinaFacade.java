/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Disciplina;

/**
 *
 * @author Jonas
 */
@Stateless
public class DisciplinaFacade extends AbstractFacade<Disciplina> {
    @PersistenceContext(unitName = "unasp-administracaoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisciplinaFacade() {
        super(Disciplina.class);
    }
    
}
