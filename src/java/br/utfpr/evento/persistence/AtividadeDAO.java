/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Atividade;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class AtividadeDAO extends GenericDAO<Atividade> {

    public Atividade buscarId(Integer codigo) {
        Atividade atividade = null;
        try {
            atividade = (Atividade) getEntityManager().createNamedQuery("Atividade.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atividade;
    }

    public List<Atividade> buscarDescricao(String descricao) {
        List<Atividade> atividades = null;
        try {
            atividades = getEntityManager().createNamedQuery("Atividade.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atividades;
    }

    @SuppressWarnings("unchecked")
    public List<Atividade> listar() {

        List<Atividade> atividades = null;
        try {
            atividades = getEntityManager().createNamedQuery("Atividade.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atividades;
    }
}
