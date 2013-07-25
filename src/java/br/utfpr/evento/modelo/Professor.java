/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Cleber
 */
@Inheritance(strategy=InheritanceType.JOINED) 
public class Professor extends Pessoa{
    
    public String getSiape(){
        return super.getIdentificacao();
    }
    
    public void setSiape(String siape){
        super.setIdentificacao(siape);
    }
    
}
