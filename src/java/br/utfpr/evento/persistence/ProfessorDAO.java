/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Professor;
import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class ProfessorDAO extends GenericDAO<Professor>{
    
     public Professor buscarId(Integer codigo) {
        Professor professor = null;
        try {
            professor = (Professor) getEntityManager().createNamedQuery("Pessoa.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }

    public List<Professor> buscarNome(String nome) {
        List<Professor> professores = null;
        
        nome = "%"+nome+"%";
        
        try {
            professores = getEntityManager().createNamedQuery("Pessoa.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professores;
    }

    public Professor buscarCpf(String cpf) {
        Professor professor = null;
        try {
            professor = (Professor) getEntityManager().createNamedQuery("Pessoa.findByCpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }

    public List<Professor> buscarIdade(Integer idade) {
        List<Professor> professores = null;
        try {
            professores = getEntityManager().createNamedQuery("Pessoa.findByIdade")
                    .setParameter("idade", idade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professores;
    }
    
    public Professor buscarPorUsuario(Usuario usuario) {
        Professor professor = null;
        try {
            professor = (Professor) getEntityManager().createNamedQuery("Pessoa.findByUsuario")
                    .setParameter("id", usuario.getId())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }
    
    public Professor buscarPorLogin(String login) {
        Professor professor = null;
        try {
            professor = (Professor) getEntityManager().createNamedQuery("Pessoa.findByLogin")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }
    
    public Professor buscarSiape(String siape) {
        Professor professor = null;
        try {
            professor = (Professor) getEntityManager().createNamedQuery("Pessoa.findByIdentificacao")
                    .setParameter("identificacao", siape)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professor;
    }
    
    @SuppressWarnings("unchecked")
    public List<Professor> listar() {

        List<Professor> professores = null;
        try {
            professores = getEntityManager().createNamedQuery("Pessoa.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professores;
    }
    
}
