/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence.interfaces;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Nitrogênio
 */
public interface DaoInterface<T> {

    public <T> boolean salvar(T entidade);

    public <T> boolean atualizar(T entidade);

    public <T> boolean remover(T entidade);
   
    public EntityManager getEntityManager();
}
