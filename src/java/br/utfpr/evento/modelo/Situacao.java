/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

/**
 *
 * @author Cleber
 */
public enum Situacao {

    CO("Cancelado"),
    AT("Em andamento"),
    FZ("Finalizado");
    private final String situacao;

    Situacao(String sit) {
        this.situacao = sit;
    }

    public static Situacao getCO() {
        return CO;
    }

    public static Situacao getAT() {
        return AT;
    }

    public static Situacao getFZ() {
        return FZ;
    }
}
