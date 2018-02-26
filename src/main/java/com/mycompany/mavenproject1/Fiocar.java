/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Вадик
 */
@Entity
@Table(name = "fiocar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fiocar.findAll", query = "SELECT f FROM Fiocar f")
    , @NamedQuery(name = "Fiocar.findById", query = "SELECT f FROM Fiocar f WHERE f.id = :id")})
public class Fiocar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idcar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Car idcar;
    @JoinColumn(name = "idfio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fio idfio;

    public Fiocar() {
    }

    public Fiocar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getIdcar() {
        return idcar;
    }

    public void setIdcar(Car idcar) {
        this.idcar = idcar;
    }

    public Fio getIdfio() {
        return idfio;
    }

    public void setIdfio(Fio idfio) {
        this.idfio = idfio;
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
        if (!(object instanceof Fiocar)) {
            return false;
        }
        Fiocar other = (Fiocar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fiocar[ id=" + id + " ]";
    }
    
}
