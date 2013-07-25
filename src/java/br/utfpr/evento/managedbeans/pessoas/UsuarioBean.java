/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.managedbeans.pessoas;

import br.utfpr.evento.modelo.Pessoa;
import javax.inject.Named;
import br.utfpr.evento.persistence.interfaces.InterfaceBean;
import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
@Named
public class UsuarioBean implements InterfaceBean<Usuario>{

    Usuario usuario;
    
    public UsuarioBean() {
        novo();
    }
    
    
    
    @Override
    public String novo() {
        usuario = new Usuario();
        
        return "";
    }

    @Override
    public String enviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String apagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
