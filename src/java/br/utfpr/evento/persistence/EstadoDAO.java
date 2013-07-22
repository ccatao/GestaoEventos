/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Estado;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class EstadoDAO extends GenericDAO<Estado> {

    public Estado buscarId(Integer codigo) {
        Estado estado = null;
        try {
            estado = (Estado) getEntityManager().createNamedQuery("Estado.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public Estado buscarNome(String nome) {
        Estado estado = null;
        try {
            estado = (Estado) getEntityManager().createNamedQuery("Estado.findByNome")
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public Estado buscarUf(String uf) {
        Estado estado = null;
        try {
            estado = (Estado) getEntityManager().createNamedQuery("Estado.findByUf")
                    .setParameter("uf", uf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    @SuppressWarnings("unchecked")
    public List<Estado> listar() {

        List<Estado> estados = null;
        try {
            estados = getEntityManager().createNamedQuery("Estado.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }
}
