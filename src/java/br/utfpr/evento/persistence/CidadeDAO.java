/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Cidade;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class CidadeDAO extends GenericDAO<Cidade> {

    public Cidade buscarId(Integer codigo) {
        Cidade usuario = null;
        try {
            usuario = (Cidade) getEntityManager().createNamedQuery("Cidade.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<Cidade> buscarNome(String nome) {
        List<Cidade> cidades = null;
        
        nome = "%" + nome + "%";
        
        try {
            cidades =  getEntityManager().createNamedQuery("Cidade.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }
   
    @SuppressWarnings("unchecked")
    public List<Cidade> listar() {

        List<Cidade> cidades = null;
        try {
            cidades = getEntityManager().createNamedQuery("Cidade.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }
    
    @SuppressWarnings("unchecked")
    public List<Cidade> listarPorEstado(String uf) {

        List<Cidade> cidades = null;
        try {
            cidades = getEntityManager().createNamedQuery("Cidade.findByUf")
                    .setParameter("uf", uf)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

}
