
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Flujos;
import com.mosis.helper.TagsHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.gmap.GMap;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class TagsUI implements Serializable {

    private TagsHelper tagsHelper;
    private Etiquetas etiqueta;
    private CtoServicio servicio;
    private DefaultMapModel simpleModel;
    private GMap map;
    private int idfs;
    private ArrayList<Marker> newPath;
    
    
    private Flujos flujo;

    public int getIdfs() {
        return idfs;
    }

    public void setIdfs(int idfs) {
        this.idfs = idfs;
    }

    public TagsUI() {
        tagsHelper = new TagsHelper();
//        etiqueta = new Etiquetas();
//        servicio = new CtoServicio();
//
//        simpleModel = new DefaultMapModel();
//        newPath = new ArrayList<>();
//        List<Etiquetas> listad = tagsHelper.getDelegateEtiquetas().getListEtiquetas();
//        for (Etiquetas etiquetas : listad) {
//            LatLng coord1 = new LatLng(etiquetas.getLatitud(), etiquetas.getLongitud());
//            simpleModel.addOverlay(new Marker(coord1, etiquetas.getNombre(), etiquetas.getNombre(), "http://tagpatrol.com/normal.png", etiquetas.getValorTag()));
//        }
    }

    public TagsHelper getTagsHelper() {
        return tagsHelper;
    }

    public void setTagsHelper(TagsHelper tagsHelper) {
        this.tagsHelper = tagsHelper;
    }

    public Etiquetas getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiquetas etiqueta) {
        this.etiqueta = etiqueta;
    }

    public CtoServicio getServicio() {
        return servicio;
    }

    public void setServicio(CtoServicio servicio) {
        this.servicio = servicio;
    }

    public List<CtoServicio> getListServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public List<Etiquetas> getListEtiquetasByIdServicio(int id) {
        return ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(id);
    }

//    public void clicBoton(ActionEvent actionEvent) {
    public void clicBoton() {

        System.err.println("ENTre");
//        System.err.println("Valor:"+tagsHelper.getCtoServicio().getIdCtoServicio());
//        List<Etiquetas> d = ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(tagsHelper.getCtoServicio().getIdCtoServicio());
        List<Etiquetas> d = ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(idfs);
//        for (Etiquetas e : d) {
//            System.out.println("dldlds: " + e.getLongitud());
//        }
    }

    /**
     * @return the map
     */
    public GMap getMap() {

        if (map != null) {
            // map.setFitBounds(true);
        }
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(GMap map) {
        //map.setFitBounds(true);

        this.map = map;
    }

    /**
     * @return the simpleModel
     */
    public DefaultMapModel getSimpleModel() {
        return simpleModel;
    }

    /**
     * @param simpleModel the simpleModel to set
     */
    public void setSimpleModel(DefaultMapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public List<Flujos> getListaFlujos() {
        return ServiceFacadeLocator.getInstanceFlujos().getListaFlujos();
    }

    /**
     * @return the flujo
     */
    public Flujos getFlujo() {
        return flujo;
    }

    /**
     * @param flujo the flujo to set
     */
    public void setFlujo(Flujos flujo) {
        this.flujo = flujo;
    }
    
      public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a metodo");
        
        if (flujo != null) {
            System.err.println("Entre");
            
            
        }
        
    }
    
}
