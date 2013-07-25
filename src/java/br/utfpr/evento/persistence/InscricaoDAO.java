/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Inscricao;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class InscricaoDAO extends GenericDAO<Inscricao> {
    
    public Inscricao buscarId(Integer codigo) {
        Inscricao inscricao = null;
        try {
            inscricao = (Inscricao) getEntityManager().createNamedQuery("Inscricao.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscricao;
    }

    public List<Inscricao> buscarEventoId(Integer codigo) {
        List<Inscricao> inscricoes = null;
        
        try {
            inscricoes = getEntityManager().createNamedQuery("Inscricao.findByEventoId")
                    .setParameter("eventoId", codigo)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscricoes;
    }
    
    public List<Inscricao> buscarParticipanteId(Integer codigo) {
        List<Inscricao> inscricoes = null;
        try {
            inscricoes = getEntityManager().createNamedQuery("Inscricao.findByParticipanteId")
                    .setParameter("participanteId", codigo)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscricoes;
    }

     public List<Inscricao> buscarQtdAtividade(Integer quantidade) {
        List<Inscricao> inscricoes = null;
        try {
            inscricoes = getEntityManager().createNamedQuery("Inscricao.findByQtdatividade")
                    .setParameter("id", quantidade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscricoes;
    }
  
    @SuppressWarnings("unchecked")
    public List<Inscricao> listar() {

        List<Inscricao> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Inscricao.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
