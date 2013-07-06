package br.utfpr.evento.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "programacao")
@SequenceGenerator(name="ProgramacaoGen" , allocationSize=1)
public class Programacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="ProgramacaoGen", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<Programa> programaList = new ArrayList<Programa>();
    
    @ManyToMany(mappedBy="programacaoList",cascade= CascadeType.ALL)
    private List<Pacote> pacoteList = new ArrayList<Pacote>();
    
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evento evento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacao")
    private List<LocalProgramacao> localProgramacaoList = new ArrayList<LocalProgramacao>();

    public Programacao() {
    }

    public Programacao(Integer prmId) {
        this.id = prmId;
    }

    public Integer getPrmId() {
        return id;
    }

    public void setPrmId(Integer id) {
        this.id = id;
    }

    public String getPrmNome() {
        return nome;
    }

    public void setPrmNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrmPreco() {
        return preco;
    }

    public void setPrmPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public List<Pacote> getPacoteList() {
        return pacoteList;
    }

    public void setPacoteList(List<Pacote> pacoteList) {
        this.pacoteList = pacoteList;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @XmlTransient
    public List<LocalProgramacao> getLocalProgramacaoList() {
        return localProgramacaoList;
    }

    public void setLocalProgramacaoList(List<LocalProgramacao> localProgramacaoList) {
        this.localProgramacaoList = localProgramacaoList;
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
        if (!(object instanceof Programacao)) {
            return false;
        }
        Programacao other = (Programacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
