/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Convidado;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class ConvidadoDAO extends GenericDAO<Convidado> {

     public Convidado buscarId(Integer codigo) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Convidado.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }

    public List<Convidado> buscarNome(String nome) {
        List<Convidado> convidados = null;
        
        nome = "%" + nome + "%";
        
        try {
            convidados = getEntityManager().createNamedQuery("Convidado.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidados;
    }

    public Convidado buscarCpf(String cpf) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Convidado.findByCpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }

    public List<Convidado> buscarIdade(Integer idade) {
        List<Convidado> convidados = null;
        try {
            convidados = getEntityManager().createNamedQuery("Pessoa.findByIdade")
                    .setParameter("idade", idade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidados;
    }
    
    public Convidado buscarConvidadoId(Integer codigo) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findByPessoaId")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }
    
    public Convidado buscarIdentificacao(String identificacao) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Convidado.findByIdentificacao")
                    .setParameter("identificacao", identificacao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }
    
    @SuppressWarnings("unchecked")
    public List<Convidado> listar() {

        List<Convidado> convidados = null;
        try {
            convidados = getEntityManager().createNamedQuery("Convidado.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidados;
    }
}
