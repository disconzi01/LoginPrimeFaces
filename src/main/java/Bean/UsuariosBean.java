/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.UsuariosDao;
import Modelo.Usuarios;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge gantiva
 */

@ManagedBean
public class UsuariosBean {
    
    private Usuarios usuario;
    
    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
        usuario = new Usuarios();
    }
    
    public void validarUsuario(){
        UsuariosDao usuariosDao = new UsuariosDao();
       
        boolean resultado = usuariosDao.validarUsusario(getUsuario().getEmail(), getUsuario().getContrasena());
        
        if(resultado)
            iniciarSesion(getUsuario().getEmail());    
    }
    
    private void iniciarSesion(String email){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.setAttribute("user", email);       
        try {
            facesContext.getExternalContext().redirect("bienvenido.xhtml");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void recordarContrasena(){
        UsuariosDao usuariosDao = new UsuariosDao();
        
        //String contrasena = usuariosDao.obtenerContrasena(getUsuario().getEmail());
        
        usuario.setContrasena("Nueva");
    }

    /**
     * @return the usuario
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}