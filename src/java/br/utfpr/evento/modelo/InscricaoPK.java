/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cleber
 */
@Embeddable
public class InscricaoPK implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull
    @Column(name = "evento_id", nullable = false)
    //</editor-fold>
    private int id;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull
    @Column(name = "participante_id", nullable = false)
    //</editor-fold>
    private int participante;

    public InscricaoPK() {
    }

    public InscricaoPK(int id, int participante) {
        this.id = id;
        this.participante = participante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParticipante() {
        return participante;
    }

    public void setParticipante(int participanteId) {
        this.participante = participanteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) participante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoPK)) {
            return false;
        }
        InscricaoPK other = (InscricaoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.participante != other.participante) {
            return false;
        }
        return true;
    }
   
}
