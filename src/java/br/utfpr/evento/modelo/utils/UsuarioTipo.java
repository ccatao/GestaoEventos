/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo.utils;

/**
 *
 * @author Cleber
 */
public enum UsuarioTipo {
    
    ADMIN("Admin"),
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    CONVIDADO("Convidado"),
    PALESTRANTE("Palestrante"),
    OUTRO("Outro");
    
    public final String tipo;

 
    UsuarioTipo (String tipo){
        this.tipo = tipo;
    }

    public static UsuarioTipo getADMIN() {
        return ADMIN;
    }

    public static UsuarioTipo getALUNO() {
        return ALUNO;
    }

    public static UsuarioTipo getPROFESSOR() {
        return PROFESSOR;
    }

    public static UsuarioTipo getCONVIDADO() {
        return CONVIDADO;
    }

    public static UsuarioTipo getPALESTRANTE() {
        return PALESTRANTE;
    }

    public static UsuarioTipo getOUTRO() {
        return OUTRO;
    }
        
}
