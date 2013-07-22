/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Pessoa;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class PessoaDAO extends GenericDAO<Pessoa> {
        
    public Pessoa buscarId(Integer codigo) {
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) getEntityManager().createNamedQuery("Pessoa.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public List<Pessoa> buscarNome(String nome) {
        List<Pessoa> pessoas = null;
        
        nome = "%"+nome+"%";
        
        try {
            pessoas = getEntityManager().createNamedQuery("Pessoa.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public Pessoa buscarCpf(String cpf) {
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) getEntityManager().createNamedQuery("Pessoa.findByCpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public List<Pessoa> buscarIdade(Integer idade) {
        List<Pessoa> pessoas = null;
        try {
            pessoas = getEntityManager().createNamedQuery("Pessoa.findByIdade")
                    .setParameter("idade", idade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }
    
    public Pessoa buscarUsuarioId(Integer codigo) {
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) getEntityManager().createNamedQuery("Pessoa.findByUsuarioId")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }
    
    public Pessoa buscarIdentificacao(String identificacao) {
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) getEntityManager().createNamedQuery("Pessoa.findByIdentificacao")
                    .setParameter("identificacao", identificacao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }
    
    @SuppressWarnings("unchecked")
    public List<Pessoa> listar() {

        List<Pessoa> pessoas = null;
        try {
            pessoas = getEntityManager().createNamedQuery("Pessoa.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}
