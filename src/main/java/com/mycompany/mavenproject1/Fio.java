/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Вадик
 */
@Entity
@Table(name = "fio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fio.findAll", query = "SELECT f FROM Fio f")
    , @NamedQuery(name = "Fio.findById", query = "SELECT f FROM Fio f WHERE f.id = :id")
    , @NamedQuery(name = "Fio.findByFamily", query = "SELECT f FROM Fio f WHERE f.family = :family")
    , @NamedQuery(name = "Fio.findByName", query = "SELECT f FROM Fio f WHERE f.name = :name")
    , @NamedQuery(name = "Fio.findByLastname", query = "SELECT f FROM Fio f WHERE f.lastname = :lastname")})
public class Fio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "family")
    private String family;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfio")
    private List<Fiocar> fiocarList;
    @JoinColumn(name = "idcity", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City idcity;

    public Fio() {
    }

    public Fio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public List<Fiocar> getFiocarList() {
        return fiocarList;
    }

    public void setFiocarList(List<Fiocar> fiocarList) {
        this.fiocarList = fiocarList;
    }

    public City getIdcity() {
        return idcity;
    }

    public void setIdcity(City idcity) {
        this.idcity = idcity;
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
        if (!(object instanceof Fio)) {
            return false;
        }
        Fio other = (Fio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fio[ id=" + id + " ]";
    }
    
}
