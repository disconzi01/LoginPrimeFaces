/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.ResultSet;

/**
 *
 * @author jorgegantiva
 */
public class UsuariosDao {
 
    public static boolean validarUsuario(String email, String contrasena) throws Exception{
        
        boolean esValido = false;
        ManejadorBaseDatos oBaseDatos = null;
        String exceptionMessage = null;
        
        try {
            oBaseDatos = new ManejadorBaseDatos();
            ResultSet resultados = oBaseDatos.consultar("SELECT COUNT(*) FROM Usuarios WHERE email='"+email+"' and contrasena='"+contrasena+"'");
            
            if(resultados.next())
                if(resultados.getInt(1) == 1)
                    esValido = true;
        }
        catch(Exception ex){
            exceptionMessage = ex.getMessage();
        }
        catch(Throwable ex){
            exceptionMessage = ex.getMessage();
        }
        finally{
            if(oBaseDatos != null)
                oBaseDatos.destruirConexion();
        }
        if(exceptionMessage!=null)
            throw new Exception(exceptionMessage);
        
        return esValido;
    }
    
    public static String obtenerContrasena(String email) throws Exception{

        String contrasenaUsuario = null;
        ManejadorBaseDatos oBaseDatos = null;
        String exceptionMessage = null;
               
        try {
            oBaseDatos = new ManejadorBaseDatos();
            ResultSet resultados = oBaseDatos.consultar("SELECT contrasena FROM Usuarios WHERE email='"+email+"'");
            
            if(resultados.next())
                contrasenaUsuario = resultados.getString("contrasena");
        }
        catch(Exception ex){
            exceptionMessage = ex.getMessage();
        }
        catch(Throwable ex){
            exceptionMessage = ex.getMessage();
        }
        finally{
            if(oBaseDatos != null)
                oBaseDatos.destruirConexion();
        }
        if(exceptionMessage!=null)
            throw new Exception(exceptionMessage);
        
        return contrasenaUsuario;
    }
}