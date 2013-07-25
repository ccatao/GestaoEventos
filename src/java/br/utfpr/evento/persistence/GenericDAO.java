package br.utfpr.evento.persistence;

import br.utfpr.evento.helper.PersistenceFactory;
import br.utfpr.evento.persistence.interfaces.DaoInterface;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe abstrata responsável por fornecer encapsulamento no acesso aos dados.
 *
 * @author Nitrogênio
 * @param <T> Classe Persistente
 *
 */
public abstract class GenericDAO<T> implements DaoInterface<T> {

    @Override
    public <T> boolean salvar(T entidade) {


        try {
            
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entidade);
            getEntityManager().getTransaction().commit();

            return true;
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public <T> boolean atualizar(T entidade) {

        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entidade);
            getEntityManager().getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            return false;
        }

    }

    @Override
    public <T> boolean remover(T entidade) {

        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(entidade);
            getEntityManager().getTransaction().commit();

            return true;
        } catch (Exception e) {
            getEntityManager().getTransaction().rollback();
            return false;
        }


    }

    @Override
    public EntityManager getEntityManager() {

        return PersistenceFactory.getEntityManager();

    }
}