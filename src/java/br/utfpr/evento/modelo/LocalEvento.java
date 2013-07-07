package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "local_programacao")
public class LocalEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected LocalEventoPK localProgramacaoPK = new LocalEventoPK();
        
    @JoinColumn(name = "lcl_id", referencedColumnName = "lcl_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Local local;

    public LocalEvento() {
    }

    public LocalEvento(LocalEventoPK localProgramacaoPK) {
        this.localProgramacaoPK = localProgramacaoPK;
    }

    public LocalEvento(int prmId, int lclId) {
        this.localProgramacaoPK = new LocalEventoPK(prmId, lclId);
    }

    public LocalEventoPK getLocalProgramacaoPK() {
        return localProgramacaoPK;
    }

    public void setLocalProgramacaoPK(LocalEventoPK localProgramacaoPK) {
        this.localProgramacaoPK = localProgramacaoPK;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localProgramacaoPK != null ? localProgramacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalEvento)) {
            return false;
        }
        LocalEvento other = (LocalEvento) object;
        if ((this.localProgramacaoPK == null && other.localProgramacaoPK != null) || (this.localProgramacaoPK != null && !this.localProgramacaoPK.equals(other.localProgramacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.LocalProgramacao[ localProgramacaoPK=" + localProgramacaoPK + " ]";
    }
    
}
