package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "entidade")
@SequenceGenerator(name="EntidadeGen" , allocationSize=1)
public class Entidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ent_id")
    @GeneratedValue(generator="EntidadeGen", strategy= GenerationType.SEQUENCE)
    private Integer entId;
    
    @Column(name = "ent_nome")
    private String entNome;
    
    @Column(name = "ent_cnpj")
    private String entCnpj;
    
    @Column(name = "ent_email")
    private String entEmail;
    
    @Column(name = "ent_telefone")
    private String entTelefone;
    
    @Column(name = "ent_datacadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entDatacadastro = new Date();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidade")
    private List<ControleEntrada> controleEntradaList;
       
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidade")
    private List<Inscricao> inscricaoList;
    
    @JoinColumn(name="usu_id", referencedColumnName="usu_id")
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entPai")
    private List<Entidade> entidadeList;
    
    @JoinColumn(name = "ent_pai", referencedColumnName = "ent_id")
    @ManyToOne(optional = false)
    private Entidade entPai;
    
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    @ManyToOne(optional = false, cascade= CascadeType.ALL)
    private Endereco endereco;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="entidade_entidade_categoria",
             joinColumns=@JoinColumn(name="ent_id"),
             inverseJoinColumns=@JoinColumn(name="enc_id")
    )
    private List<EntidadeCategoria> entidadeCategoriaList = new ArrayList<EntidadeCategoria>();
            
    public Entidade() {
    }

    public Entidade(Integer entId) {
        this.entId = entId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntNome() {
        return entNome;
    }

    public void setEntNome(String entNome) {
        this.entNome = entNome;
    }

    public String getEntCnpj() {
        return entCnpj;
    }

    public void setEntCnpj(String entCnpj) {
        this.entCnpj = entCnpj;
    }

    public String getEntEmail() {
        return entEmail;
    }

    public void setEntEmail(String entEmail) {
        this.entEmail = entEmail;
    }

    public String getEntTelefone() {
        return entTelefone;
    }

    public void setEntTelefone(String entTelefone) {
        this.entTelefone = entTelefone;
    }

    public Date getEntDatacadastro() {
        return entDatacadastro;
    }

    public void setEntDatacadastro(Date entDatacadastro) {
        this.entDatacadastro = entDatacadastro;
    }

    @XmlTransient
    public List<ControleEntrada> getControleEntradaList() {
        return controleEntradaList;
    }

    public void setControleEntradaList(List<ControleEntrada> controleEntradaList) {
        this.controleEntradaList = controleEntradaList;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Entidade> getEntidadeList() {
        return entidadeList;
    }

    public void setEntidadeList(List<Entidade> entidadeList) {
        this.entidadeList = entidadeList;
    }

    public Entidade getEntPai() {
        return entPai;
    }

    public void setEntPai(Entidade entPai) {
        this.entPai = entPai;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<EntidadeCategoria> getEntidadeCategoriaList() {
        return entidadeCategoriaList;
    }

    public void setEntidadeCategoriaList(List<EntidadeCategoria> entidadeCategoriaList) {
        this.entidadeCategoriaList = entidadeCategoriaList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidade)) {
            return false;
        }
        Entidade other = (Entidade) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Entidade[ entId=" + entId + " ]";
    }
    
}
