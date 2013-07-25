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
public class Palestrante extends Pessoa{

    public String getCodigoIdentificador(){
        return super.getIdentificacao();
    }
    
    public void setCodigoIdentificador(String identificador){
        super.setIdentificacao(identificador);
    }
}

