/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "emprestimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e"),
    @NamedQuery(name = "Emprestimo.findByIdemprestimo", query = "SELECT e FROM Emprestimo e WHERE e.idemprestimo = :idemprestimo"),
    @NamedQuery(name = "Emprestimo.findByDataSaida", query = "SELECT e FROM Emprestimo e WHERE e.dataSaida = :dataSaida"),
    @NamedQuery(name = "Emprestimo.findByDataDevolucao", query = "SELECT e FROM Emprestimo e WHERE e.dataDevolucao = :dataDevolucao")})
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemprestimo")
    private Integer idemprestimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @JoinColumn(name = "idmaterial", referencedColumnName = "idmaterial")
    @ManyToOne(optional = false)
    private Material idmaterial;
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno")
    @ManyToOne(optional = false)
    private Aluno idAluno;

    public Emprestimo() {
    }

    public Emprestimo(Integer idemprestimo) {
        this.idemprestimo = idemprestimo;
    }

    public Emprestimo(Integer idemprestimo, Date dataSaida, Date dataDevolucao) {
        this.idemprestimo = idemprestimo;
        this.dataSaida = dataSaida;
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getIdemprestimo() {
        return idemprestimo;
    }

    public void setIdemprestimo(Integer idemprestimo) {
        this.idemprestimo = idemprestimo;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Material getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(Material idmaterial) {
        this.idmaterial = idmaterial;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemprestimo != null ? idemprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.idemprestimo == null && other.idemprestimo != null) || (this.idemprestimo != null && !this.idemprestimo.equals(other.idemprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emprestimo[ idemprestimo=" + idemprestimo + " ]";
    }
    
}
