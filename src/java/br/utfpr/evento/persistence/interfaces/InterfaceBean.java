/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.persistence.interfaces;

import java.util.List;

/**
 *
 * @author Cleber
 */
public interface InterfaceBean<T> {

    public String novo();

    public String enviar();

    public String editar();

    public String apagar();

    public List<T> listarTodos();
    
}
