package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramaEntidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prog_id")
    private int progId;
    @Basic(optional = false)
    @Column(name = "ent_id")
    private int entId;

    public ProgramaEntidadePK() {
    }

    public ProgramaEntidadePK(int prgId, int entId) {
        this.progId = prgId;
        this.entId = entId;
    }

    public int getProgId() {
        return progId;
    }

    public void setPrgId(int progId) {
        this.progId = progId;
    }

    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) progId;
        hash += (int) entId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaEntidadePK)) {
            return false;
        }
        ProgramaEntidadePK other = (ProgramaEntidadePK) object;
        if (this.progId != other.progId) {
            return false;
        }
        if (this.entId != other.entId) {
            return false;
        }
        return true;
    }
    
}
