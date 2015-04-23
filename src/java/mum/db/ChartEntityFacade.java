/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mum.model.ChartEntity;

/**
 *
 * @author wellocean
 */
@Stateless
public class ChartEntityFacade extends AbstractFacade<ChartEntity> {
    @PersistenceContext(unitName = "MusiBoyPv1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChartEntityFacade() {
        super(ChartEntity.class);
    }
    
}
