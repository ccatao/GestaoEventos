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
    
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tb_evento_id", nullable = false)
    private int tbEventoId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tb_participante_id", nullable = false)
    private int tbParticipanteId;

    public InscricaoPK() {
    }

    public InscricaoPK(int id, int tbEventoId, int tbParticipanteId) {
        this.id = id;
        this.tbEventoId = tbEventoId;
        this.tbParticipanteId = tbParticipanteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTbEventoId() {
        return tbEventoId;
    }

    public void setTbEventoId(int tbEventoId) {
        this.tbEventoId = tbEventoId;
    }

    public int getTbParticipanteId() {
        return tbParticipanteId;
    }

    public void setTbParticipanteId(int tbParticipanteId) {
        this.tbParticipanteId = tbParticipanteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) tbEventoId;
        hash += (int) tbParticipanteId;
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
        if (this.tbEventoId != other.tbEventoId) {
            return false;
        }
        if (this.tbParticipanteId != other.tbParticipanteId) {
            return false;
        }
        return true;
    }
    
}
