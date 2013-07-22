/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Endereco;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class EnderecoDAO extends GenericDAO<Endereco> {

    public Endereco buscarId(Integer codigo) {
        Endereco endereco = null;
        try {
            endereco = (Endereco) getEntityManager().createNamedQuery("Endereco.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    public List<Endereco> buscarNome(String descricao) {
        List<Endereco> endereco = null;
        
        descricao = "%" + descricao + "%";
        
        try {
            endereco = getEntityManager().createNamedQuery("Endereco.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

     public List<Endereco> buscarNumero(Integer numero) {
        List<Endereco> enderecos = null;
        try {
            enderecos = getEntityManager().createNamedQuery("Endereco.findByNumero")
                    .setParameter("numero", numero)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enderecos;
    }
    
    public List<Endereco> buscarBairro(String bairro) {
        List<Endereco> enderecos = null;
        try {
            enderecos = getEntityManager().createNamedQuery("Endereco.findByBairro")
                    .setParameter("bairro", bairro)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enderecos;
    }
    
    public Endereco buscarCep(String cep) {
        Endereco endereco = null;
        try {
            endereco = (Endereco) getEntityManager().createNamedQuery("Endereco.findByCep")
                    .setParameter("cep", cep)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @SuppressWarnings("unchecked")
    public List<Endereco> listar() {

        List<Endereco> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Endereco.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
