/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByIdProfessor", query = "SELECT p FROM Professor p WHERE p.idProfessor = :idProfessor"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfessor")
    private Integer idProfessor;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessor")
    private Collection<Disciplina> disciplinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessor")
    private Collection<Aulas> aulasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfessor")
    private Collection<Notas> notasCollection;

    public Professor() {
    }

    public Professor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Disciplina> getDisciplinaCollection() {
        return disciplinaCollection;
    }

    public void setDisciplinaCollection(Collection<Disciplina> disciplinaCollection) {
        this.disciplinaCollection = disciplinaCollection;
    }

    @XmlTransient
    public Collection<Aulas> getAulasCollection() {
        return aulasCollection;
    }

    public void setAulasCollection(Collection<Aulas> aulasCollection) {
        this.aulasCollection = aulasCollection;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfessor != null ? idProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.idProfessor == null && other.idProfessor != null) || (this.idProfessor != null && !this.idProfessor.equals(other.idProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Professor[ idProfessor=" + idProfessor + " ]";
    }
    
}
