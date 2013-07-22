/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Evento;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class EventoDAO extends GenericDAO<Evento> {

    public Evento buscarId(Integer codigo) {
        Evento usuario = null;
        try {
            usuario = (Evento) getEntityManager().createNamedQuery("Evento.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Evento buscarDescricao(String descricao) {
        Evento evento = null;
        try {
            evento = (Evento) getEntityManager().createNamedQuery("Evento.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evento;
    }

    public Evento buscarNome(String nome) {
        Evento evento = null;
        try {
            evento = (Evento) getEntityManager().createNamedQuery("Evento.findByNome")
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evento;
    }

    @SuppressWarnings("unchecked")
    public List<Evento> listar() {

        List<Evento> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Evento.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
