/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonas
 */
@Entity
@Table(name = "financeiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financeiro.findAll", query = "SELECT f FROM Financeiro f"),
    @NamedQuery(name = "Financeiro.findByIdfinaceiro", query = "SELECT f FROM Financeiro f WHERE f.idfinaceiro = :idfinaceiro"),
    @NamedQuery(name = "Financeiro.findByAno", query = "SELECT f FROM Financeiro f WHERE f.ano = :ano"),
    @NamedQuery(name = "Financeiro.findByMes", query = "SELECT f FROM Financeiro f WHERE f.mes = :mes"),
    @NamedQuery(name = "Financeiro.findByValor", query = "SELECT f FROM Financeiro f WHERE f.valor = :valor"),
    @NamedQuery(name = "Financeiro.findByVencimento", query = "SELECT f FROM Financeiro f WHERE f.vencimento = :vencimento"),
    @NamedQuery(name = "Financeiro.findByStatus", query = "SELECT f FROM Financeiro f WHERE f.status = :status")})
public class Financeiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinaceiro")
    private Integer idfinaceiro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mes")
    private String mes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno")
    @ManyToOne(optional = false)
    private Aluno idAluno;

    public Financeiro() {
    }

    public Financeiro(Integer idfinaceiro) {
        this.idfinaceiro = idfinaceiro;
    }

    public Financeiro(Integer idfinaceiro, int ano, String mes, BigDecimal valor, Date vencimento, int status) {
        this.idfinaceiro = idfinaceiro;
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.vencimento = vencimento;
        this.status = status;
    }

    public Integer getIdfinaceiro() {
        return idfinaceiro;
    }

    public void setIdfinaceiro(Integer idfinaceiro) {
        this.idfinaceiro = idfinaceiro;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        hash += (idfinaceiro != null ? idfinaceiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Financeiro)) {
            return false;
        }
        Financeiro other = (Financeiro) object;
        if ((this.idfinaceiro == null && other.idfinaceiro != null) || (this.idfinaceiro != null && !this.idfinaceiro.equals(other.idfinaceiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Financeiro[ idfinaceiro=" + idfinaceiro + " ]";
    }
    
}
