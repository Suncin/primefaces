/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import CasosAcadSb.PasoFacadeLocal;
import CasosAcadSb.TipoPasoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import tpi.casosacadpf.libreriamavencasosacadpf.Paso;
import tpi.casosacadpf.libreriamavencasosacadpf.TipoPaso;

/**
 *
 * @author debian
 */
@Named(value = "frmPaso")
@ViewScoped
public class frmPaso implements Serializable{

private LazyDataModel<Paso> modeloPaso;
    private LazyDataModel<TipoPaso> modeloTipo;
    private Paso registro = new Paso();
    private TipoPaso tipo;
    private List<TipoPaso> tipos;
    
    
    @EJB
    private PasoFacadeLocal pfl;
    @EJB
    private TipoPasoFacadeLocal tpfl;
    
    
    @PostConstruct
    public void init(){
        
             this.tipos= tpfl.findAll();
        
             setModeloPaso(new LazyDataModel<Paso>(){

            @Override
            public List<Paso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(pfl != null){
                    this.setRowCount(pfl.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = pfl.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(Paso object) {
                return object.getIdPaso();
            }

            @Override
            public Paso getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<Paso> lista = (List<Paso>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(Paso get : lista) {
                            if(get.getIdPaso().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });

             
             setModeloTipo(new LazyDataModel<TipoPaso>(){

            @Override
            public List<TipoPaso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(tpfl != null){
                    this.setRowCount(tpfl.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = tpfl.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(TipoPaso object) {
                return object.getIdTipoPaso();
            }

            @Override
            public TipoPaso getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<TipoPaso> lista = (List<TipoPaso>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(TipoPaso get : lista) {
                            if(get.getIdTipoPaso().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
             
             
    }
    
     public Integer getTipoSeleccionado(){
     if(registro!= null){
            if(registro.getIdTipoPaso()!= null){
                return this.registro.getIdTipoPaso().getIdTipoPaso();
            } else {
                return null;
            }         
        } else {
            return null;
        }
    }
    
    public void setTipoSeleccionado(Integer idTipo){
        if(idTipo >= 0 && !this.tipos.isEmpty()){
            for(TipoPaso tp : this.getTipos()) {
                if(Objects.equals(tp.getIdTipoPaso(), idTipo)) {
                    if(this.registro.getIdTipoPaso()!= null) {
                        this.registro.getIdTipoPaso().setIdTipoPaso(idTipo);
                    } else {
                        this.registro.setIdTipoPaso(tp);
                    }
                }
            }
        }
    
    }
    
    
          public void btnGuardarAction(ActionEvent ae){
        try {    
            if(this.registro != null && this.pfl != null){
                boolean resultado = this.pfl.create(registro);
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Creado con exito":"Error", null);
                //this.agregar = !resultado;
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        } catch (Exception e) {
           
        }
     
      }
     
     
      public void btnModificarAction(ActionEvent ae){
        try{
            boolean resultado = this.pfl.editar(registro); 
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Modificado con exito":"Error", null);
            //this.editar = resultado;
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }catch(Exception e){
            System.err.println(""+e);
        }
    }

            public void btnEliminarAction(ActionEvent ae) {
        try {
            if(this.registro != null && this.pfl != null){
                boolean resultado = this.pfl.remove(registro);
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, resultado?"Eliminado con exito":"Error", null);
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        } catch (Exception e) {
        }
    }

    
    
    /**
     * Creates a new instance of FrmRequisito
     */
    public frmPaso() {
    }

    public LazyDataModel<Paso> getModeloPaso() {
        return modeloPaso;
    }

    public void setModeloPaso(LazyDataModel<Paso> modeloPaso) {
        this.modeloPaso = modeloPaso;
    }

    public LazyDataModel<TipoPaso> getModeloTipo() {
        return modeloTipo;
    }

    public void setModeloTipo(LazyDataModel<TipoPaso> modeloTipo) {
        this.modeloTipo = modeloTipo;
    }

    public Paso getRegistro() {
        return registro;
    }

    public void setRegistro(Paso registro) {
        this.registro = registro;
    }

    public TipoPaso getTipo() {
        return tipo;
    }

    public void setTipo(TipoPaso tipo) {
        this.tipo = tipo;
    }

    public List<TipoPaso> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoPaso> tipos) {
        this.tipos = tipos;
    }
    
}
