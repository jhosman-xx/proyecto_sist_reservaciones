/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.reserva.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Lenovo
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vuelo", catalog = "sist_reserva_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findById", query = "SELECT v FROM Vuelo v WHERE v.id = :id")
    , @NamedQuery(name = "Vuelo.findByOrigen", query = "SELECT v FROM Vuelo v WHERE v.origen = :origen")
    , @NamedQuery(name = "Vuelo.findByDestino", query = "SELECT v FROM Vuelo v WHERE v.destino = :destino")
    , @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vuelo.findByHora", query = "SELECT v FROM Vuelo v WHERE v.hora = :hora")
    , @NamedQuery(name = "Vuelo.findByCapacidad", query = "SELECT v FROM Vuelo v WHERE v.capacidad = :capacidad")
    , @NamedQuery(name = "Vuelo.findByDisponibilidad", query = "SELECT v FROM Vuelo v WHERE v.disponibilidad = :disponibilidad")
    , @NamedQuery(name = "Vuelo.findByJornada", query = "SELECT v FROM Vuelo v WHERE v.jornada = :jornada")
    , @NamedQuery(name = "Vuelo.findByCosto", query = "SELECT v FROM Vuelo v WHERE v.costo = :costo")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "origen", nullable = false, length = 45)
    private String origen;
    @Basic(optional = false)
    @Column(name = "destino", nullable = false, length = 45)
    private String destino;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "capacidad", nullable = false)
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "disponibilidad", nullable = false)
    private int disponibilidad;
    @Basic(optional = false)
    @Column(name = "jornada", nullable = false, length = 45)
    private String jornada;
    @Basic(optional = false)
    @Column(name = "costo", nullable = false)
    private double costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vueloid")
    private List<Reserva> reservaList;

    public Vuelo() {
    }

    public Vuelo(Integer id) {
        this.id = id;
    }

    public Vuelo(Integer id, String origen, String destino, Date fecha, Date hora, int capacidad, int disponibilidad, String jornada, double costo) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
        this.jornada = jornada;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    @JsonIgnore
    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
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
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.reserva.Vuelo[ id=" + id + " ]";
    }
    
}
