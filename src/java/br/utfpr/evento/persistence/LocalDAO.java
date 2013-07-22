/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Local;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class LocalDAO extends GenericDAO<Local> {

    public Local buscarId(Integer codigo) {
        Local local = null;
        try {
            local = (Local) getEntityManager().createNamedQuery("Local.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return local;
    }

    public List<Local> buscarNome(String nome) {
        List<Local> locais = null;
        
        nome = "%" + nome + "%";
        
        try {
            locais = getEntityManager().createNamedQuery("Local.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locais;
    }

    public List<Local> buscarReferencia(String referencia) {
        List<Local> locais = null;
        
        referencia = "%" + referencia + "%";
        
        try {
            locais = getEntityManager().createNamedQuery("Local.findByReferencia")
                    .setParameter("referencia", referencia)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locais;
    }

    @SuppressWarnings("unchecked")
    public List<Local> listar() {

        List<Local> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Local.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
