/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tpi.casosacadpf.libreriamavencasosacadpf.CasoDetalleRequisito;

/**
 *
 * @author debian
 */
@Stateless
public class CasoDetalleRequisitoFacade extends AbstractFacade<CasoDetalleRequisito> implements CasoDetalleRequisitoFacadeLocal {

    @PersistenceContext(unitName = "tpi_CasosAcadPF_mvnCasosAcadPF-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasoDetalleRequisitoFacade() {
        super(CasoDetalleRequisito.class);
    }
    
}
