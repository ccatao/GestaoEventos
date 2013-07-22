/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_endereco")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id"),
    @NamedQuery(name = "Endereco.findByDescricao", query = "SELECT e FROM Endereco e WHERE e.descricao LIKE :descricao"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro LIKE :bairro"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")})
public class Endereco implements Serializable {
    
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
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 10, max = 80, message = "O tamanho mínimo é 10 e o máximo 80 caracteres.")
    @Column(name = "descricao", nullable = false, length = 80)
    //</editor-fold>
    private String descricao;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Column(name = "numero", nullable = false)
    //</editor-fold>
    private Integer numero;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 5, max = 55, message = "O tamanho mínimo é 5 e o máximo 55 caracteres.")
    @Column(name = "bairro", nullable = false, length = 55)
    //</editor-fold>
    private String bairro;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 8, max = 8, message = "O campo deve ter 8 caracteres.")
    @Column(name = "cep", nullable = false, length = 8)
    //</editor-fold>
    private String cep;
    
    //<editor-fold defaultstate="collapsed" desc="anotaçães">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    //</editor-fold>
    private Collection<Local> locais;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Cidade cidadeId;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    //</editor-fold>
    private Collection<Pessoa> pessoas;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecoId")
    //</editor-fold>
    private Collection<Entidade> entidades;

    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String descricao, Integer numero, String bairro, String cep) {
        this.id = id;
        this.descricao = descricao;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Collection<Local> getLocais() {
        return locais;
    }

    public void setLocais(Collection<Local> locais) {
        this.locais = locais;
    }

    public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Collection<Entidade> getEntidades() {
        return entidades;
    }

    public void setEntidades(Collection<Entidade> entidades) {
        this.entidades = entidades;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
