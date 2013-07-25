/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence;

import br.utfpr.evento.modelo.Categoria;
import java.util.List;

/**
 *
 * @author Cleber
 */
public class CategoriaDAO extends GenericDAO<Categoria> {

    public Categoria buscarId(Integer codigo) {
        Categoria categoria = null;
        try {
            categoria = (Categoria) getEntityManager().createNamedQuery("Categoria.findById")
                    .setParameter("id", codigo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    public List<Categoria> buscarDescricao(String descricao) {
        List<Categoria> categorias = null;
        
        descricao = "%" + descricao + "%";
        
        try {
            categorias = getEntityManager().createNamedQuery("Categoria.findByDescricao")
                    .setParameter("descricao", descricao)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

    @SuppressWarnings("unchecked")
    public List<Categoria> listar() {

        List<Categoria> usuarios = null;
        try {
            usuarios = getEntityManager().createNamedQuery("Categoria.findAll")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
