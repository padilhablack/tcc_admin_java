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
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findByIdTurma", query = "SELECT t FROM Turma t WHERE t.idTurma = :idTurma"),
    @NamedQuery(name = "Turma.findByNome", query = "SELECT t FROM Turma t WHERE t.nome = :nome")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurma")
    private Integer idTurma;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurma")
    private Collection<Aulas> aulasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurma")
    private Collection<Matricula> matriculaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurma")
    private Collection<Notas> notasCollection;

    public Turma() {
    }

    public Turma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Aulas> getAulasCollection() {
        return aulasCollection;
    }

    public void setAulasCollection(Collection<Aulas> aulasCollection) {
        this.aulasCollection = aulasCollection;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
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
        hash += (idTurma != null ? idTurma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.idTurma == null && other.idTurma != null) || (this.idTurma != null && !this.idTurma.equals(other.idTurma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Turma[ idTurma=" + idTurma + " ]";
    }
    
}
