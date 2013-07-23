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
        Evento evento = null;
        try {
            evento = (Evento) getEntityManager().createNamedQuery("Evento.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evento;
    }

    public Evento buscarSituacao(String situacao) {
        Evento evento = null;
        try {
            evento = (Evento) getEntityManager().createNamedQuery("Evento.findBySituacaoEvento")
                    .setParameter("situacao", situacao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evento;
    }

    
    public List<Evento> buscarDescricao(String descricao) {
        List<Evento> eventos = null;
        
        descricao = "%" + descricao + "%";
        
        try {
            eventos = getEntityManager().createNamedQuery("Evento.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventos;
    }
    
    public List<Evento> buscarNome(String nome) {
        List<Evento> eventos = null;
        
        nome = "%"+ nome +"%";
        
        try {
            eventos = getEntityManager().createNamedQuery("Evento.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventos;
    }
    
    public List<Evento> buscarResponsavel(String responsavel) {
        List<Evento> eventos = null;
        
        responsavel = "%"+ responsavel +"%";
        
        try {
            eventos = getEntityManager().createNamedQuery("Evento.findByResponsavel")
                    .setParameter("responsavel", responsavel)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventos;
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
