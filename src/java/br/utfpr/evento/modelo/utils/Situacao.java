/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo.utils;

/**
 *
 * @author Cleber
 */
public enum Situacao {
    
    CA("Cancelado"),
    EA("Em andamento"),
    FZ("Finalizado");
    
    public final String situacao;

 
    Situacao (String situacao){
        this.situacao = situacao;
    }
    
    public static Situacao getCancelado() {
        return CA;
    }

    public static Situacao getEmAndamento() {
        return EA;
    }

    public static Situacao getFinalizado() {
        return FZ;
    }
    
}
