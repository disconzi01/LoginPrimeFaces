/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuarios;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author jorgegantiva
 */
public class UsuariosDao {
 
    public boolean validarUsusario(String email, String contrasena){
        Session session = null;
        List<Usuarios> usuario;
        boolean esValido = false;
        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuarios where email='"+email+"' and contrasena='"+contrasena+"'");
            usuario = query.list();
            
            if(usuario.size()==1)
                esValido = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        catch(Throwable ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(session != null)
               session.close();
        }
        return esValido;
    }
    
    public String obtenerContrasena(String email){
        Session session = null;
        List<Usuarios> usuario;
        String contrasenaUsuario = null;
        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuarios where email='"+email+"'");
            usuario = query.list();
            
            if(usuario.size()==1)
                contrasenaUsuario = usuario.get(0).getContrasena();
        }
        catch(Exception ex){
            
        }
        finally{
            if(session != null)
               session.close();
        }
        return contrasenaUsuario;
    }
}
