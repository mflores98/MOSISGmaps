/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Usuarios;
import com.mosis.ui.UsuarioUILogin;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.Part;

public class EtiquetaHelper implements Serializable {

    private Etiquetas currentEtiqueta;
    private CtoServicio servicioSelected;
    private Usuarios usuarioActual;
    private int servicioIDint;

    private Part image;
    private boolean upladed;

    ////////////
    private UsuarioUILogin login;

    public EtiquetaHelper() {
        currentEtiqueta = new Etiquetas();
        servicioSelected = new CtoServicio();
//        usuarioActual = new Usuarios();
//        login = new UsuarioUILogin();
    }

    public List<Etiquetas> getEtiquetas() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
    }

    public Etiquetas getCurrentEtiqueta() {
        return currentEtiqueta;
    }

    public void setCurrentEtiqueta(Etiquetas currentEtiqueta) {
        this.currentEtiqueta = currentEtiqueta;
    }

    public CtoServicio getServicioSelected() {
        return servicioSelected;
    }

    public void setServicioSelected(CtoServicio servicioSelected) {
        this.servicioSelected = servicioSelected;
    }

    public Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    public List<CtoServicio> getLsitaSer() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void setUsuarioActual(Usuarios usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public void registrarEtiqueta() throws Exception {
        if (getCurrentEtiqueta().getNombre() != null) {
            try {

                ServiceFacadeLocator.getInstanceEtiquetas().registrarEtiqueta(currentEtiqueta, servicioIDint, 20);/// byte[] imagen//usuario 20 , login.getUsuario().getIdUsuario()
            } catch (Exception ex) {
                System.out.println("error: " + ex.getLocalizedMessage());
                throw new Exception("");

            }
        } else {
            System.out.println("no hay sesion");
            throw new Exception("");
        }
    }

    /*
public byte[] doUpload() {
        try {
            InputStream in = image.getInputStream();

            File f = new File("/Users/Miguel/Desktop/upload/" + image.getSubmittedFileName());
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            upladed = true;

            return buffer;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     */
//    public void eliminar() throws MyException {
//        ServiceFacadeLocator.getInstanceEtiquetas().deleteEtiquetas(currentEtiqueta.getIdEtiqueta());
//    }
    public void modificarEtiqueta() {
//        System.out.println("id etiquetaa editar: " + currentEtiqueta.getIdEtiqueta());
//        System.out.println("serviio: " + servicioSelected.getIdCtoServicio());
        if (currentEtiqueta != null) {
            try {
                ServiceFacadeLocator.getInstanceEtiquetas().actualizarEtiqueta(currentEtiqueta.getIdEtiqueta(), currentEtiqueta, servicioIDint, 20);//usuario 9 
            } catch (Exception e) {
                System.out.println("Algo salio mal: " + e);
            }
        }
    }

    public int getServicioIDint() {
        return servicioIDint;
    }

    public void setServicioIDint(int servicioIDint) {
        this.servicioIDint = servicioIDint;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public boolean isUpladed() {
        return upladed;
    }

    public void setUpladed(boolean upladed) {
        this.upladed = upladed;
    }

}
