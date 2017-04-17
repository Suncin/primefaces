/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tpi.casosacadpf.libreriamavencasosacadpf.Paso;

/**
 *
 * @author debian
 */
@Stateless
public class PasoFacade extends AbstractFacade<Paso> implements PasoFacadeLocal {

    @PersistenceContext(unitName = "tpi_CasosAcadPF_mvnCasosAcadPF-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasoFacade() {
        super(Paso.class);
    }
    
}
