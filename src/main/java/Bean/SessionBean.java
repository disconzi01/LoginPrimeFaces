/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorgegantiva
 */
@ManagedBean
public class SessionBean {

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }

    public String validarLogin(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        String usuarioEmail = "";
        
        if(session.getAttribute("user") != null)
            usuarioEmail = (String)session.getAttribute("user");
        else
            cerrarSesion();
        
        return usuarioEmail;
    }
    
    public void cerrarSesion(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        try {
            session.invalidate();
            facesContext.getExternalContext().redirect("index.xhtml");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void redirigirRecordarContrasena(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {
            facesContext.getExternalContext().redirect("recordarContrasena.xhtml");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}