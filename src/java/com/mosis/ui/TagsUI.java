
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoAcciones;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Flujos;
import com.mosis.entity.Turnos;
import com.mosis.helper.TagsHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.gmap.GMap;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.Marker;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.LatLng;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class TagsUI implements Serializable {

    private TagsHelper tagsHelper;
    private Etiquetas etiqueta;
    private String pregunta;

    private int idAccionSelected;
    private int idTurnoSelected;
    private CtoServicio servicio;
    private DefaultMapModel simpleModel;
    private GMap map;
    private int idServicioSelected;
    private ArrayList<Marker> newPath;

    private Flujos flujo;

    public int getIdServicioSelected() {
        return idServicioSelected;
    }

    public void setIdServicioSelected(int idServicioSelected) {
        this.idServicioSelected = idServicioSelected;
    }

    public TagsUI() {
        tagsHelper = new TagsHelper();
        etiqueta = new Etiquetas();
        newPath = new ArrayList<>();

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

    public void onMarkerSelect(OverlaySelectEvent event) {
        System.out.println("se selecciono marker");

    }

    public void marcarTagsEnMapa() {
        System.out.println("idServicio: " + idServicioSelected);
        simpleModel = new DefaultMapModel();

        List<Etiquetas> listad = ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(idServicioSelected);
        if (!listad.isEmpty()) {
            for (Etiquetas etiquetas : listad) {
                LatLng coord1 = new LatLng(etiquetas.getLatitud(), etiquetas.getLongitud());
                simpleModel.addOverlay(new Marker(coord1, etiquetas.getNombre(), etiquetas.getNombre(), "http://tagpatrol.com/normal.png", etiquetas.getValorTag() + " id: " + etiquetas.getIdEtiqueta()));
            }
        } else {
            System.out.println("no hay tag para este servicio");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay tag para este servicio", null);

            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    public List<CtoAcciones> getListaAcciones() {
        return ServiceFacadeLocator.getinstanceCtoAccion().getListCtoAcciones();
    }

    public List<Turnos> getListaTurnos() {
        return ServiceFacadeLocator.getTurnosFacade().getListTurnos();
    }

    public void selecciontag(AjaxBehavior behavior) {
// System.err.println("ENTre");
        if (tagsHelper.getEtiqueta() != null) {
            System.out.println("Seleccion de tag de lista de datos");
            System.err.println("se selecciono tag: ");
            System.out.println("1: " + tagsHelper.getEtiqueta().getIdEtiqueta());
            tagsHelper.setEtiqueta(tagsHelper.getEtiqueta());
        }
    }

    public void asignarTareaATag() {
        if (tagsHelper.getEtiqueta().getIdEtiqueta() != null) {
            System.out.println("si se selecciono un tag de la lista");
            System.out.println("acccion: " + idAccionSelected);
            System.out.println("turno: " + idTurnoSelected);
            System.out.println("pregutna: " + pregunta);
            try {
            ServiceFacadeLocator.getInstanceFlujos().registrarTareaATag(tagsHelper.getEtiqueta().getIdEtiqueta(), idAccionSelected, idTurnoSelected, pregunta);
                System.out.println("aqqui metodo para almacenar");
            } catch (Exception ex) {
                System.out.println("idAccion,idturno no valido ");
                Logger.getLogger(TagsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("no hay nada seleccionado");
        }

    }

    public List<Etiquetas> getListalistaEtiquetas() {
        List<Etiquetas> listEtiquetasByServicioID = ServiceFacadeLocator.getInstanceEtiquetas().getListEtiquetasByServicioID(idServicioSelected);
        return listEtiquetasByServicioID;
    }

//    public List<CtoAcciones> getlistaCtoAcciones() {
//        List<CtoAcciones> listCtoAcciones = ServiceFacadeLocator.getinstanceCtoAccion().getListCtoAcciones();
//        return listCtoAcciones;
//    }
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

    public int getIdAccionSelected() {
        return idAccionSelected;
    }

    public void setIdAccionSelected(int idAccionSelected) {
        this.idAccionSelected = idAccionSelected;
    }

    public int getIdTurnoSelected() {
        return idTurnoSelected;
    }

    public void setIdTurnoSelected(int idTurnoSelected) {
        this.idTurnoSelected = idTurnoSelected;
    }

    public ArrayList<Marker> getNewPath() {
        return newPath;
    }

    public void setNewPath(ArrayList<Marker> newPath) {
        this.newPath = newPath;
    }

}
