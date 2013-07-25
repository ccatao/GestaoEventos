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
    @NotNull(message = "O campo \"nome\" não deve ser vazio.")
    @Size(min = 4, max = 60, message = "O campo \"nome\" não deve ter menos que 4 ou mais que 60 caracteres.")
    @Column(name = "nome", nullable = false, length = 60)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    //campo de validação do e-mail
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")
    @Basic(optional = false)
    @NotNull(message = "O campo \"e-mail\" não deve ser vazio.")
    @Size(min = 10, max = 45, message = "O campo \"e-mail\" não deve ter menos que 10 ou mais que 45 caracteres.")
    @Column(name = "email", nullable = false, length = 45)
    //</editor-fold>
    private String email;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo \"CNPJ\" não deve ser vazio.")
    @Size(min = 14, max = 14, message = "O campo \"CNPJ\" deve ter 14 caracteres.")
    @Column(name = "cnpj", nullable = false, length = 14)
    //</editor-fold>
    private String cnpj;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Usuario usuario;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Endereco endereco;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Categoria categoria;

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

    public Usuario getUsuarioId() {
        return usuario;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuario = usuarioId;
    }

    public Endereco getEnderecoId() {
        return endereco;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.endereco = enderecoId;
    }

    public Categoria getCategoriaId() {
        return categoria;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoria = categoriaId;
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

}
