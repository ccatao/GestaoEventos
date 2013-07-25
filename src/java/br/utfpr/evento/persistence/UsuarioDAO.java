/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario buscarId(Integer codigo) {
        Usuario usuario = null;
        try {
            usuario = (Usuario) getEntityManager().createNamedQuery("Usuario.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario buscarLogin(String login) {
        Usuario usuario = null;
        try {
            usuario = (Usuario) getEntityManager().createNamedQuery("Usuario.findByLogin")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario buscarSenha(String senha) {
        Usuario usuario = null;
        try {
            usuario = (Usuario) getEntityManager().createNamedQuery("Usuario.findBySenha")
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario buscarSenha(String login, String senha) {
        Usuario usuario = null;
        try {
            usuario = (Usuario) getEntityManager().createNamedQuery("Usuario.findByLoginSenha")
                    .setParameter("senha", senha)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    @SuppressWarnings("unchecked")
    public List<Usuario> listar() {

        List<Usuario> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Usuario.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}