/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tb_local")
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findById", query = "SELECT l FROM Local l WHERE l.id = :id"),
    @NamedQuery(name = "Local.findByNome", query = "SELECT l FROM Local l WHERE l.nome LIKE :nome"),
    @NamedQuery(name = "Local.findByReferencia", query = "SELECT l FROM Local l WHERE l.referencia LIKE :referencia")})
public class Local implements Serializable {
    
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
    @NotNull(message = "O campo \"nome\" não deve ser vazio.")
    @Size(min = 4, max = 45, message = "O campo \"nome\" não deve ter menos que 4 ou mais que 20 caracteres.")
    @Column(name = "nome", nullable = false, length = 45)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Size(max = 45, message = "O campo \"nome\" não deve mais que 45 caracteres.")
    @Column(name = "referencia", length = 45)
    //</editor-fold>
    private String referencia;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "responsavel_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Pessoa responsavel;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Endereco endereco;
    
    public Local() {
    }

    public Local(Integer id) {
        this.id = id;
    }

    public Local(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getResponsavelId() {
        return responsavel;
    }

    public void setResponsavelId(Pessoa responsavelId) {
        this.responsavel = responsavelId;
    }

    public Endereco getEnderecoId() {
        return endereco;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.endereco = enderecoId;
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
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
