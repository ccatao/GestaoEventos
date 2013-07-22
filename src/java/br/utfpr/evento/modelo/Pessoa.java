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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Cleber
 */
@Entity
@Table(name = "tb_pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.pessoaPK.id = :id"),
    @NamedQuery(name = "Pessoa.findByUsuarioId", query = "SELECT p FROM Pessoa p WHERE p.pessoaPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome"),
    @NamedQuery(name = "Pessoa.findByIdade", query = "SELECT p FROM Pessoa p WHERE p.idade = :idade"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findByIdentificacao", query = "SELECT p FROM Pessoa p WHERE p.identificacao = :identificacao")})
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @EmbeddedId
    //</editor-fold>
    protected PessoaPK pessoaPK;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 1, max = 50, message = "Tamanho máximo 50 caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    //</editor-fold>
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Column(name = "idade")
    //</editor-fold>
    private Integer idade;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 10, max = 45, message = "Mínimo 10 e máximo 45 caracteres.")
    @Column(name = "email", nullable = false, length = 45)
    //</editor-fold>
    private String email;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ficar vazio.")
    @Size(min = 11, max = 11, message = "O tamanho do campo é 11 caracteres.")
    @Column(name = "cpf", nullable = false, length = 11)
    //</editor-fold>
    private String cpf;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @Basic(optional = false)
    @NotNull(message = "O campo não pode ser vazio.")
    @Size(min = 3, max = 10, message = "Tamanho máximo do campo 10 caracteres.")
    @Column(name = "identificacao", nullable = false, length = 10)
    //</editor-fold>
    private String identificacao;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel")
    //</editor-fold>
    private Collection<Local> locais;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel")
    //</editor-fold>
    private Collection<Atividade> atividades;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Endereco enderecoId;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "entidade_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    //</editor-fold>
    private Entidade entidadeId;
    
    //<editor-fold defaultstate="collapsed" desc="anotações">
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    //</editor-fold>
    private Usuario usuario;
    
    //<editor-fold defaultstate="collapsed" desc="anotacões">
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    //</editor-fold>
    private Collection<Inscricao> inscricoes;

    public Pessoa() {
    }

    public Pessoa(PessoaPK pessoaPK) {
        this.pessoaPK = pessoaPK;
    }

    public Pessoa(PessoaPK pessoaPK, String nome, String cpf, String identificacao) {
        this.pessoaPK = pessoaPK;
        this.nome = nome;
        this.cpf = cpf;
        this.identificacao = identificacao;
    }

    public Pessoa(int id, int usuarioId) {
        this.pessoaPK = new PessoaPK(id, usuarioId);
    }

    public PessoaPK getPessoaPK() {
        return pessoaPK;
    }

    public void setPessoaPK(PessoaPK pessoaPK) {
        this.pessoaPK = pessoaPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Entidade getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(Entidade entidadeId) {
        this.entidadeId = entidadeId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Local> getLocais() {
        return locais;
    }

    public void setLocais(Collection<Local> locais) {
        this.locais = locais;
    }

    public Collection<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Collection<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Collection<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(Collection<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaPK != null ? pessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pessoaPK == null && other.pessoaPK != null) || (this.pessoaPK != null && !this.pessoaPK.equals(other.pessoaPK))) {
            return false;
        }
        return true;
    }

}
