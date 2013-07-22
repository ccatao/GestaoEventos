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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_entidade")
@NamedQueries({
    @NamedQuery(name = "Entidade.findAll", query = "SELECT e FROM Entidade e"),
    @NamedQuery(name = "Entidade.findById", query = "SELECT e FROM Entidade e WHERE e.id = :id"),
    @NamedQuery(name = "Entidade.findByNome", query = "SELECT e FROM Entidade e WHERE e.nome LIKE :nome"),
    @NamedQuery(name = "Entidade.findByEmail", query = "SELECT e FROM Entidade e WHERE e.email LIKE :email"),
    @NamedQuery(name = "Entidade.findByCnpj", query = "SELECT e FROM Entidade e WHERE e.cnpj = :cnpj")})
public class Entidade implements Serializable {
    
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
    @Size(min = 4, max = 60, message = "O tamanho mínimo 4 e o máximo 60 caracteres.")
    @Column(name = "nome", nullable = false, length = 60)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 10, max = 45, message = "O tamanho mínimo é 10 e o máximo 45 caracteres.")
    @Column(name = "email", nullable = false, length = 45)
    //</editor-fold>
    private String email;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 13, max = 14, message = "Tamanho máximo 14 caracteres.")
    @Column(name = "cnpj", nullable = false, length = 14)
    //</editor-fold>
    private String cnpj;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadeId")
    //</editor-fold>
    private Collection<Pessoa> pessoas;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Endereco enderecoId;
    
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Categoria categoriaId;

    public Entidade() {
    }

    public Entidade(Integer id) {
        this.id = id;
    }

    public Entidade(Integer id, String nome, String email, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

       public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
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
        if (!(object instanceof Entidade)) {
            return false;
        }
        Entidade other = (Entidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.utfpr.evento.modelo.Entidade[ id=" + id + " ]";
    }
    
}
