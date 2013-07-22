/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Aluno;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class AlunoDAO extends GenericDAO<Aluno> {

    public Aluno buscarId(Integer codigo) {
        Aluno aluno = null;
        try {
            aluno = (Aluno) getEntityManager().createNamedQuery("Pessoa.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;
    }

    public List<Aluno> buscarNome(String nome) {
        List<Aluno> alunos = null;
        
        nome = "%"+nome+"%";
        
        try {
            alunos = getEntityManager().createNamedQuery("Pessoa.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public Aluno buscarCpf(String cpf) {
        Aluno aluno = null;
        try {
            aluno = (Aluno) getEntityManager().createNamedQuery("Pessoa.findByCpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;
    }

    public List<Aluno> buscarIdade(Integer idade) {
        List<Aluno> alunos = null;
        try {
            alunos = getEntityManager().createNamedQuery("Pessoa.findByIdade")
                    .setParameter("idade", idade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alunos;
    }
    
    public Aluno buscarAlunoId(Integer codigo) {
        Aluno aluno = null;
        try {
            aluno = (Aluno) getEntityManager().createNamedQuery("Pessoa.findByUsuarioId")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;
    }
    
    public Aluno buscarIdentificacao(String identificacao) {
        Aluno aluno = null;
        try {
            aluno = (Aluno) getEntityManager().createNamedQuery("Pessoa.findByIdentificacao")
                    .setParameter("identificacao", identificacao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;
    }
    
    @SuppressWarnings("unchecked")
    public List<Aluno> listar() {

        List<Aluno> alunos = null;
        try {
            alunos = getEntityManager().createNamedQuery("Pessoa.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
