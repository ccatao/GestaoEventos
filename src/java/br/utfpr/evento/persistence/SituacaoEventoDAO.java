/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.SituacaoEvento;
import br.utfpr.evento.modelo.SituacaoEvento;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class SituacaoEventoDAO extends GenericDAO<SituacaoEvento> {

    public SituacaoEvento buscarId(Integer codigo) {
        SituacaoEvento situacaoEvento = null;
        try {
            situacaoEvento = (SituacaoEvento) getEntityManager().createNamedQuery("SituacaoEvento.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return situacaoEvento;
    }

    public List<SituacaoEvento> buscarDescricao(String descricao) {
        List<SituacaoEvento> situacaoEventos = null;

        descricao = "%" + descricao + "%";

        try {
            situacaoEventos = getEntityManager().createNamedQuery("SituacaoEvento.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return situacaoEventos;
    }

    @SuppressWarnings("unchecked")
    public List<SituacaoEvento> listar() {

        List<SituacaoEvento> situacaoEventos = null;
        try {
            situacaoEventos = getEntityManager().createNamedQuery("SituacaoEvento.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return situacaoEventos;

    }
}