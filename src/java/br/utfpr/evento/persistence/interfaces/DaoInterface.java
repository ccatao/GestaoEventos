/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence.interfaces;

import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Nitrogênio
 */
public interface DaoInterface<T> {

    /**
     * Método responsável pela busca de uma instância da classe persistente pela chave-primária.
     *
     * @param pk Integer
     * @return T
     * @throws IllegalArgumentException
     */
    T find(int pk) throws IllegalArgumentException;

    /**
     * Método responsável pela busca de uma instância da classe persistente pela chave-primária.
     *
     * @param pk String
     * @return T
     * @throws IllegalArgumentException
     */
    T find(String pk) throws IllegalArgumentException;

    /**
     * Método responsável pela listagem de instâncias da classe persistente.
     *
     * @return List<T>
     * @throws IllegalArgumentException
     */
    @SuppressWarnings(value = "unchecked")
    Set<T> list() throws IllegalArgumentException;

    /**
     * Método responsável pela atualização de uma instância da classe persistente.
     *
     * @param t T
     * @return Boolean
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    boolean merge(T t) throws IllegalArgumentException, TransactionRequiredException;

    /**
     * Método responsável pela persistência de uma instância da classe persistente.
     *
     * @param t T
     * @return Boolean
     * @throws EntityExistsException
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     * @throws PersistenceException
     */
    boolean persist(T t) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException;

    /**
     * Método responsável pela remoção de uma instância da classe persistente.
     *
     * @param t T
     * @return Boolean
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    boolean remove(T t) throws IllegalArgumentException, TransactionRequiredException;
    
}
