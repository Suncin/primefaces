/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tpi.casosacadpf.libreriamavencasosacadpf.TipoRequisito;

/**
 *
 * @author debian
 */
@Stateless
public class TipoRequisitoFacade extends AbstractFacade<TipoRequisito> implements TipoRequisitoFacadeLocal {

    @PersistenceContext(unitName = "tpi_CasosAcadPF_mvnCasosAcadPF-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoRequisitoFacade() {
        super(TipoRequisito.class);
    }
    
}
