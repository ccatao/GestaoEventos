/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Palestrante;
import br.utfpr.evento.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class PalestranteDAO extends GenericDAO<Usuario> {

    public Palestrante buscarId(Integer codigo) {
        Palestrante palestrante = null;
        try {
            palestrante = (Palestrante) getEntityManager().createNamedQuery("Pessoa.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrante;
    }

    public List<Palestrante> buscarNome(String nome) {

        List<Palestrante> palestrantes = null;
        
        nome = "%"+nome+"%";
        
        try {
            palestrantes = getEntityManager().createNamedQuery("Pessoa.findByNome")
                    .setParameter("nome", nome)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrantes;
    }

    public Palestrante buscarCpf(String cpf) {
        Palestrante palestrante = null;
        try {
            palestrante = (Palestrante) getEntityManager().createNamedQuery("Pessoa.findByCpf")
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrante;
    }

    public List<Palestrante> buscarIdade(Integer idade) {
        List<Palestrante> palestrantes = null;
        try {
            palestrantes = getEntityManager().createNamedQuery("Pessoa.findByIdade")
                    .setParameter("idade", idade)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrantes;
    }
    
    public Palestrante buscarUsuarioId(Integer codigo) {
        Palestrante palestrante = null;
        try {
            palestrante = (Palestrante) getEntityManager().createNamedQuery("Pessoa.findByUsuarioId")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrante;
    }
    
    public Palestrante buscarIdentificacao(String identificacao) {
        Palestrante palestrante = null;
        try {
            palestrante = (Palestrante) getEntityManager().createNamedQuery("Pessoa.findByIdentificacao")
                    .setParameter("identificacao", identificacao)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrante;
    }
    
    @SuppressWarnings("unchecked")
    public List<Palestrante> listar() {

        List<Palestrante> palestrantes = null;
        try {
            palestrantes = getEntityManager().createNamedQuery("Pessoa.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palestrantes;
    }
}
