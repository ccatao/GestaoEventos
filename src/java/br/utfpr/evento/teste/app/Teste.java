/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.teste.app;

import br.utfpr.evento.modelo.Endereco;
import br.utfpr.evento.modelo.Local;
import br.utfpr.evento.persistence.EnderecoDAO;

/**
 *
 * @author Nitrogênio
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        EnderecoDAO daoEnd = new EnderecoDAO();
        
        end.setBairro("Bairro");
        end.setCep("85885-000");
        
        daoEnd.persist(end);
        
        
        
        
    }
    
}
