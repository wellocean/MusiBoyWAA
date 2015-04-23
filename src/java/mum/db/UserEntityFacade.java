/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mum.model.UserEntity;

/**
 *
 * @author wellocean
 */
@Stateless
public class UserEntityFacade extends AbstractFacade<UserEntity> {
    @PersistenceContext(unitName = "MusiBoyPv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(UserEntity.class);
    }
    
}
