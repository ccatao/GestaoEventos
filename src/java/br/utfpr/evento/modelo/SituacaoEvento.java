/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import br.utfpr.evento.modelo.utils.Situacao;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_situacao_evento")
@NamedQueries({
    @NamedQuery(name = "SituacaoEvento.findAll", query = "SELECT s FROM SituacaoEvento s"),
    @NamedQuery(name = "SituacaoEvento.findById", query = "SELECT s FROM SituacaoEvento s WHERE s.id = :id"),
    @NamedQuery(name = "SituacaoEvento.findByDescricao", query = "SELECT s FROM SituacaoEvento s WHERE s.descricao LIKE :descricao")})
public class SituacaoEvento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    //</editor-fold>
    private Integer id;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"situacao\" não deve ser vazio.")
    @Column(name = "descricao", nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    //</editor-fold>
    private Situacao descricao;
    
    public SituacaoEvento() {
    }

    public SituacaoEvento(Integer id) {
        this.id = id;
    }

    public SituacaoEvento(Integer id, Situacao descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Situacao getDescricao() {
        return descricao;
    }

    public void setDescricao(Situacao descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoEvento)) {
            return false;
        }
        SituacaoEvento other = (SituacaoEvento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
