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
public class PessoaPK implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    //</editor-fold>
    private int id;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Column(name = "usuario_id", nullable = false)
    //</editor-fold>
    private int usuarioId;
    
    public PessoaPK() {
    }

    public PessoaPK(int id, int usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaPK)) {
            return false;
        }
        PessoaPK other = (PessoaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

}
