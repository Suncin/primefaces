/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
   public List<TipoRequisito> findByEstado(boolean estado){
    
        try{
        if(em!=null){
          
            Query q= em.createNamedQuery("TipoRequisito.findByActivo");
            q.setParameter("activo", estado);
            return q.getResultList();                    
        }        
        }catch(Exception e){
        
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,e.getMessage(),e);
        }
        return new ArrayList();
    }        
    
}
