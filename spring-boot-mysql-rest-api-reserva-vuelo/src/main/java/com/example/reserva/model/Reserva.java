/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.reserva.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Lenovo
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reserva", catalog = "sist_reserva_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findById", query = "SELECT r FROM Reserva r WHERE r.id = :id")
    , @NamedQuery(name = "Reserva.findByCedula", query = "SELECT r FROM Reserva r WHERE r.cedula = :cedula")
    , @NamedQuery(name = "Reserva.findByNombre", query = "SELECT r FROM Reserva r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Reserva.findByFechaNacimiento", query = "SELECT r FROM Reserva r WHERE r.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Reserva.findByEstado", query = "SELECT r FROM Reserva r WHERE r.estado = :estado")
    , @NamedQuery(name = "Reserva.findByFechaTransac", query = "SELECT r FROM Reserva r WHERE r.fechaTransac = :fechaTransac")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 45)
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_transac", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransac;
    @JoinColumn(name = "Vuelo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Vuelo vueloid;

    public Reserva() {
    }

    public Reserva(Integer id) {
        this.id = id;
    }

    public Reserva(Integer id, String cedula, Date fechaNacimiento, String estado, Date fechaTransac) {
        this.id = id;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.fechaTransac = fechaTransac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTransac() {
        return fechaTransac;
    }

    public void setFechaTransac(Date fechaTransac) {
        this.fechaTransac = fechaTransac;
    }

    public Vuelo getVueloid() {
        return vueloid;
    }

    public void setVueloid(Vuelo vueloid) {
        this.vueloid = vueloid;
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.reserva.Reserva[ id=" + id + " ]";
    }
    
}
