
package br.utfpr.evento.persistence;
 
import br.utfpr.evento.persistence.interfaces.DaoInterface;
import br.utfpr.evento.helper.PersistenceFactory;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
 
/**
 * Classe abstrata responsável por fornecer encapsulamento no acesso aos dados.
 *
 * @author Nitrogênio
 * @param <T> Classe Persistente
 *
 */
public abstract class GenericDAO<T> implements DaoInterface<T> {
        private Class<T> persistentClass;
 
        /**
         * Método responsável pela instanciação e extração da classe persistente.
         */
        @SuppressWarnings("unchecked")
        public GenericDAO() {
                this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
 
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
    @Override
        public boolean persist(T t) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
                EntityManager em = PersistenceFactory.getEntityManager();
 
                try {
                        em.getTransaction().begin();
                        em.persist(t);
                        em.getTransaction().commit();
                        return true;
                } catch(EntityExistsException e) {
                        em.getTransaction().rollback();
                        throw e;
                } catch(IllegalArgumentException e) {
                        em.getTransaction().rollback();
                        throw e;
                } catch(TransactionRequiredException e) {
                        em.getTransaction().rollback();
                        throw e;
                } catch(PersistenceException e) {
                        em.getTransaction().rollback();
                        throw e;
                } finally {
                        em.close();
                }
        }
 
        /**
         * Método responsável pela atualização de uma instância da classe persistente.
         *
         * @param t T
         * @return Boolean
         * @throws IllegalArgumentException
         * @throws TransactionRequiredException
         */
    @Override
        public boolean merge(T t) throws IllegalArgumentException, TransactionRequiredException {
                EntityManager em = PersistenceFactory.getEntityManager();
 
                try {
                        em.getTransaction().begin();
                        em.merge(t);
                        em.getTransaction().commit();
                        return true;
                } catch(IllegalArgumentException e) {
                        em.getTransaction().rollback();
                        throw e;
                } catch(TransactionRequiredException e) {
                        em.getTransaction().rollback();
                        throw e;
                } finally {
                        em.close();
                }
        }
 
        /**
         * Método responsável pela remoção de uma instância da classe persistente.
         *
         * @param t T
         * @return Boolean
         * @throws IllegalArgumentException
         * @throws TransactionRequiredException
         */
    @Override
        public boolean remove(T t) throws IllegalArgumentException, TransactionRequiredException {
                EntityManager em = PersistenceFactory.getEntityManager();
 
                try {
                        em.getTransaction().begin();
                        em.remove(t);
                        em.getTransaction().commit();
                        return true;
                } catch(IllegalArgumentException e) {
                        em.getTransaction().rollback();
                        throw e;
                } catch(TransactionRequiredException e) {
                        em.getTransaction().rollback();
                        throw e;
                } finally {
                        em.close();
                }
        }
 
        /**
         * Método responsável pela busca de uma instância da classe persistente pela chave-primária.
         *
         * @param pk Integer
         * @return T
         * @throws IllegalArgumentException
         */
    @Override
        public T find(int pk) throws IllegalArgumentException {
                EntityManager em = PersistenceFactory.getEntityManager();
 
                try {
                        return em.find(this.persistentClass, pk);
                } finally {
                        em.close();
                }
        }
 
        /**
         * Método responsável pela busca de uma instância da classe persistente pela chave-primária.
         *
         * @param pk String
         * @return T
         * @throws IllegalArgumentException
         */
    @Override
        public T find(String pk) throws IllegalArgumentException {
                EntityManager em = PersistenceFactory.getEntityManager();
 
                try {
                        return em.find(this.persistentClass, pk);
                } finally {
                        em.close();
                }
        }
 
        /**
         * Método responsável pela listagem de instâncias da classe persistente.
         *
         * @return List<T>
         * @throws IllegalArgumentException
         */
        @SuppressWarnings("unchecked")
    @Override
        public Set<T> list() throws IllegalArgumentException {
                EntityManager em = PersistenceFactory.getEntityManager();
                 
                try {
                        return new HashSet<T>(em.createQuery("from " + this.persistentClass.getSimpleName()).getResultList());
                } finally {
                        em.close();
                }
        }
}