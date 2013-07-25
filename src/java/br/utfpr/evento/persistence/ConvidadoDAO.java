/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Convidado;
import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class ConvidadoDAO extends GenericDAO<Convidado> {

     public Convidado buscarId(Integer codigo) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findById")
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
            convidados = getEntityManager().createNamedQuery("Pessoa.findByNome")
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
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findByCpf")
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
    
    public Convidado buscarUsuario(Usuario usuario) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findByUsuario")
                    .setParameter("id", usuario.getId())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }
    
    public Convidado buscarIdentificador(String identificador) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findByIdentificacao")
                    .setParameter("identificacao", identificador)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidado;
    }
    
    public Convidado buscarPorLogin(String login) {
        Convidado convidado = null;
        try {
            convidado = (Convidado) getEntityManager().createNamedQuery("Pessoa.findByLogin")
                    .setParameter("login", login)
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
            convidados = getEntityManager().createNamedQuery("Pessoa.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convidados;
    }
}
