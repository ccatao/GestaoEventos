/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Entidade;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class EntidadeDAO extends GenericDAO<Entidade> {

    public Entidade buscarId(Integer codigo) {
        Entidade entidade = null;
        try {
            entidade = (Entidade) getEntityManager().createNamedQuery("Entidade.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidade;
    }

    public List<Entidade> buscarNome(String nome) {
        List<Entidade> entidades = null;
        
        nome = "%" + nome + "%";
        
        try {
            entidades = getEntityManager().createNamedQuery("Entidade.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidades;
    }

    public List<Entidade> buscarEmail(String email) {
        List<Entidade> entidades = null;
        
        email = "%" + email + "%";
        
        try {
            entidades = getEntityManager().createNamedQuery("Entidade.findByEmail")
                    .setParameter("email", email)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidades;
    }
    
    public Entidade buscarCnpj(String cnpj) {
        Entidade entidade = null;
        try {
            entidade = (Entidade) getEntityManager().createNamedQuery("Entidade.findByCnpj")
                    .setParameter("cnpj", cnpj)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entidade;
    }

    @SuppressWarnings("unchecked")
    public List<Entidade> listar() {

        List<Entidade> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Entidade.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
