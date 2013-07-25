/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.TipoUsuario;
import br.utfpr.evento.modelo.utils.UsuarioTipo;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class TipoUsuarioDAO extends GenericDAO<TipoUsuario> {

    public TipoUsuario buscarId(Integer codigo) {
        TipoUsuario tipoUsuario = null;
        try {
            tipoUsuario = (TipoUsuario) getEntityManager().createNamedQuery("TipoUsuario.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoUsuario;
    }

    public List<TipoUsuario> buscarDescricao(UsuarioTipo descricao) {
        List<TipoUsuario> tipoUsuario = null;
               
        try {
            tipoUsuario = getEntityManager().createNamedQuery("TipoUsuario.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoUsuario;
    }

    @SuppressWarnings("unchecked")
    public List<TipoUsuario> listar() {

        List<TipoUsuario> tiposUsuarios = null;
        try {
            tiposUsuarios = getEntityManager().createNamedQuery("TipoUsuario.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiposUsuarios;
    }
}
