/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

/**
 *
 * @author JORGE E GANTIVA O
 */
public class ManejadorMensajes {
    
    public static void mostrarInformacion(FacesContext context, String titulo, String mensaje){
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo,  mensaje));
    }
    public static void mostrarError(FacesContext context, String titulo, String mensaje){
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo,  mensaje));
    }
}