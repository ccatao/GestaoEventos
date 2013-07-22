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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Convidado extends Pessoa{
    
}
