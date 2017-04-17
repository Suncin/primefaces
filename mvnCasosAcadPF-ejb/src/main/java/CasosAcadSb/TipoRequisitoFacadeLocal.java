/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import java.util.List;
import javax.ejb.Local;
import tpi.casosacadpf.libreriamavencasosacadpf.TipoRequisito;

/**
 *
 * @author debian
 */
@Local
public interface TipoRequisitoFacadeLocal {

    boolean create(TipoRequisito tipoRequisito);

    //void edit(TipoRequisito tipoRequisito);
    
    boolean editar(TipoRequisito tipoRequisito);
    
    boolean remove(TipoRequisito tipoRequisito);

    TipoRequisito find(Object id);

    List<TipoRequisito> findAll();

    List<TipoRequisito> findRange(int[] range);
    
    //List<TipoRequisito> findByEstado(boolean estado);

    int count();
    
}
