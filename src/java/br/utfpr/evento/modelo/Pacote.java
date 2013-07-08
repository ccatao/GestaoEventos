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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pacote")
@SequenceGenerator(name="PacoteGen" , allocationSize=1)
public class Pacote implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="PacoteGen", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @ManyToMany
    @JoinTable(name="PACOTE_INSCRICAO",
            joinColumns=@JoinColumn(name="PACOTE_ID"),
            inverseJoinColumns=@JoinColumn(name="INSNCRICAO_ID")    )
    private List<Inscricao> inscricoes;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="eve_id")
    private Evento evento;
    
    public Pacote() {
    }

    public Pacote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPctId(Integer pctId) {
        this.id = pctId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getPctNome() {
        return nome;
    }

    public void setPctNome(String pctNome) {
        this.nome = pctNome;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacote)) {
            return false;
        }
        Pacote other = (Pacote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
