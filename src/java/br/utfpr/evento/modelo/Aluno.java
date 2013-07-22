/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Aluno extends Pessoa{
   
    public String getRa() {
        return super.getIdentificacao();
    }

    public void setRa(String ra) {
        super.setIdentificacao(ra);
    }
    
}
