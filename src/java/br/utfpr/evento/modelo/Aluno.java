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
@Inheritance(strategy = InheritanceType.JOINED) 
public class Aluno extends Pessoa{
    
   public String getRa(){
       return super.getIdentificacao();
   }
   
   public void setRa(String ra){
       super.setIdentificacao(ra);
   }
    
}
