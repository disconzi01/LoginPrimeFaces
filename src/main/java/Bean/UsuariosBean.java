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
    private boolean usuarioInvalido;
    private String exceptionMessage;
    
    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
        usuario = new Usuarios();
        usuarioInvalido = false;
        exceptionMessage = null;
    }
    
    public void validarUsuario(){
        boolean resultado;
        
        try{
            resultado = UsuariosDao.validarUsuario(getUsuario().getEmail(), getUsuario().getContrasena());
            if(resultado)
                iniciarSesion(getUsuario().getEmail());
            else
                setUsuarioInvalido(true);
        }
        catch(Exception ex){
            exceptionMessage = ex.getMessage();
        }
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
        String contrasena;
        
        try{
            contrasena = UsuariosDao.obtenerContrasena(getUsuario().getEmail());
            if(contrasena != null)
                usuario.setContrasena(contrasena);
            else
                setUsuarioInvalido(true);
        }
        catch(Exception ex){
            exceptionMessage = ex.getMessage();
        }
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

    /**
     * @return the usuarioInvalido
     */
    public boolean isUsuarioInvalido() {
        return usuarioInvalido;
    }

    /**
     * @param usuarioInvalido the usuarioInvalido to set
     */
    public void setUsuarioInvalido(boolean usuarioInvalido) {
        this.usuarioInvalido = usuarioInvalido;
    }
    
    /**
     * @return the exceptionMessage
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * @param exceptionMessage the exceptionMessage to set
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}