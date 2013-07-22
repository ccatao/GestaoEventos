/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id"),
    @NamedQuery(name = "Evento.findByDescricao", query = "SELECT e FROM Evento e WHERE e.descricao LIKE :descricao"),
    @NamedQuery(name = "Evento.findByNome", query = "SELECT e FROM Evento e WHERE e.nome LIKE :nome"),
    @NamedQuery(name = "Evento.findByResponsavel", query = "SELECT e FROM Evento e WHERE e.responsavel.nome LIKE :responsavel"),
    @NamedQuery(name = "Evento.findBySituacaoEvento", query = "SELECT e FROM Evento e WHERE e.situacaoEvento = :situacaoEvento")})
public class Evento implements Serializable {
    
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
    @NotNull(message =  "O campo não pode ser vazio.")
    @Size(min = 5, max = 45, message = "O tamanho mínimo é de 5 e o máximo 45 caracteres.")
    @Column(name = "descricao", nullable = false, length = 45)
    //</editor-fold>
    private String descricao;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 10, max = 45, message = "O tamanho mínimo é 10 e o máximo 45 caracteres.")
    @Column(name = "nome", nullable = false, length = 45)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa responsavel;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Enumerated(EnumType.STRING)
    //</editor-fold>
    private Situacao situacaoEvento;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String descricao, String nome, Pessoa responsavel, Situacao situacaoEvento) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.responsavel = responsavel;
        this.situacaoEvento = situacaoEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Situacao getSituacaoEventoId() {
        return situacaoEvento;
    }

    public void setSituacaoEventoId(Situacao situacaoEventoId) {
        this.situacaoEvento = situacaoEventoId;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.utfpr.evento.modelo.Evento[ id=" + id + " ]";
    }
    
}
