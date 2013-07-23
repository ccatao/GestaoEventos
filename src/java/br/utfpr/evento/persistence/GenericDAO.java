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
    public <T> void salvar(T entidade) {


        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entidade);
        getEntityManager().getTransaction().commit();

    }

    @Override
    public <T> T atualizar(T entidade) {

        T salvo = null;

        getEntityManager().getTransaction().begin();
        salvo = getEntityManager().merge(entidade);
        getEntityManager().getTransaction().commit();


        return salvo;
    }

    @Override
    public <T> void remover(T entidade) {

        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entidade);
        getEntityManager().getTransaction().commit();

    }

    @Override
    public EntityManager getEntityManager() {

        return PersistenceFactory.getEntityManager();

    }
}