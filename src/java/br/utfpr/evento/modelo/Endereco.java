package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name="EnderecoGen" , allocationSize=1)
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="EnderecoGen",strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String rua;
    
    @Column
    private String numero;
    
    @Column
    private String bairro;
    
    @Column
    private String cep;
    
    @Column
    private String complemento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    private List<Entidade> entidadeList;
    
    @JoinColumn(name = "cdd_id", referencedColumnName = "cdd_id")
    @ManyToOne(optional = false, cascade={CascadeType.REMOVE})
    private Cidade cidade;
    
    @OneToOne(mappedBy = "endereco", cascade= CascadeType.ALL)
    private Local local;
    
    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public List<Entidade> getEntidadeList() {
        return entidadeList;
    }

    public void setEntidadeList(List<Entidade> entidadeList) {
        this.entidadeList = entidadeList;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
