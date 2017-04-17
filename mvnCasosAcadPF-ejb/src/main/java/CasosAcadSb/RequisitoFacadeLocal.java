/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasosAcadSb;

import java.util.List;
import javax.ejb.Local;
import tpi.casosacadpf.libreriamavencasosacadpf.Requisito;

/**
 *
 * @author debian
 */
@Local
public interface RequisitoFacadeLocal {

    
    boolean create(Requisito requisito);

    //void edit(Requisito requisito);

    boolean editar(Requisito requisito);
    
    boolean remove(Requisito requisito);

    Requisito find(Object id);

    List<Requisito> findAll();

    List<Requisito> findRange(int[] range);

    int count();
    
}

