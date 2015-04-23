/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mum.model.AuthorEntity;

/**
 *
 * @author wellocean
 */
@Stateless
public class AuthorEntityFacade extends AbstractFacade<AuthorEntity> {
    @PersistenceContext(unitName = "MusiBoyPv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorEntityFacade() {
        super(AuthorEntity.class);
    }
    
}
