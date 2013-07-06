/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nitrogênio
 */
public class PersistenceFactory {

    
    @PersistenceContext(name="GestaoEventosPU")
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    /**
     * Singleton para criar factory apenas uma vez
     *
     * @return
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GerenciamentoEventosPU");
        }
        return emf;
    }

    /**
     * Retorna ultimo EM aberto e em execucao ou cria um novo.
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        if (em != null && em.isOpen()) {
            return em;
        } else {
            em = getEntityManagerFactory().createEntityManager();
            return em;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();

        emf.close();

        System.out.println("finalize");
    }
}
