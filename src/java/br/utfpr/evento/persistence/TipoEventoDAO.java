/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.TipoEvento;
import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class TipoEventoDAO extends GenericDAO<Usuario> {

    public TipoEvento buscarId(Integer codigo) {
        TipoEvento tipoEvento = null;
        try {
            tipoEvento = (TipoEvento) getEntityManager().createNamedQuery("TipoEvento.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoEvento;
    }

    public List<TipoEvento> buscarDescricao(String descricao) {
        List<TipoEvento> tipoEventos = null;
        
        descricao = "%" + descricao + "%";
        
        try {
            tipoEventos = getEntityManager().createNamedQuery("TipoEvento.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoEventos;
    }

    @SuppressWarnings("unchecked")
    public List<TipoEvento> listar() {

        List<TipoEvento> tiposEventos = null;
        try {
            tiposEventos = getEntityManager().createNamedQuery("TipoEvento.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiposEventos;
    }
}
