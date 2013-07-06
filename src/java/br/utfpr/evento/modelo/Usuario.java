package br.utfpr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name="UsuarioGen" , allocationSize=1)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="UsuarioGen", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "senha")
    private String senha;
    
    @OneToOne(cascade= CascadeType.ALL, mappedBy="usuario")
    private Entidade entidade;
    
    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.id = usuId;
    }

    public Integer getUsuId() {
        return id;
    }

    public void setUsuId(Integer usuId) {
        this.id = usuId;
    }

    public String getUsuLogin() {
        return login;
    }

    public void setUsuLogin(String usuLogin) {
        this.login = usuLogin;
    }

    public String getUsuSenha() {
        return senha;
    }

    public void setUsuSenha(String usuSenha) {
        this.senha = usuSenha;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Usuario[ usuId=" + id + " ]";
    }
    
}
