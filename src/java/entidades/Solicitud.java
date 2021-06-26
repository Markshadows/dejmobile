/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author scarecrow
 */
@Entity
@Table(name = "SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitud.findByEntrega", query = "SELECT s FROM Solicitud s WHERE s.entrega = :entrega")
    , @NamedQuery(name = "Solicitud.findByTotal", query = "SELECT s FROM Solicitud s WHERE s.total = :total")
    , @NamedQuery(name = "Solicitud.findByFechaHora", query = "SELECT s FROM Solicitud s WHERE s.fechaHora = :fechaHora")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entrega")
    private String entrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "Cliente_rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente clienterut;
    @JoinColumn(name = "Minutos_minutos", referencedColumnName = "idMinutos")
    @ManyToOne
    private Minutos minutosminutos;
    @JoinColumn(name = "Navegacion_cuota", referencedColumnName = "idNavegacion")
    @ManyToOne(optional = false)
    private Navegacion navegacioncuota;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, String entrega, int total, Date fechaHora) {
        this.idSolicitud = idSolicitud;
        this.entrega = entrega;
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public Solicitud(Integer idSolicitud, Navegacion navegacioncuota, Minutos minutosminutos, String entrega, Date fechaHora, int total) {
        this.idSolicitud = idSolicitud;
        this.navegacioncuota = navegacioncuota;
        this.minutosminutos = minutosminutos;
        this.entrega = entrega;

        this.fechaHora = fechaHora;
        this.total = total;

    }

    public Solicitud(Integer idSolicitud, String entrega, int total, Date fechaHora, Cliente clienterut, Minutos minutosminutos, Navegacion navegacioncuota) {
        this.idSolicitud = idSolicitud;
        this.entrega = entrega;
        this.total = total;
        this.fechaHora = fechaHora;
        this.clienterut = clienterut;
        this.minutosminutos = minutosminutos;
        this.navegacioncuota = navegacioncuota;
    }
    
    

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getClienterut() {
        return clienterut;
    }

    public void setClienterut(Cliente clienterut) {
        this.clienterut = clienterut;
    }

    public Minutos getMinutosminutos() {
        return minutosminutos;
    }

    public void setMinutosminutos(Minutos minutosminutos) {
        this.minutosminutos = minutosminutos;
    }

    public Navegacion getNavegacioncuota() {
        return navegacioncuota;
    }

    public void setNavegacioncuota(Navegacion navegacioncuota) {
        this.navegacioncuota = navegacioncuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", entrega=" + entrega + ", total=" + total + ", fechaHora=" + fechaHora + ", clienterut=" + clienterut.getRut() + ", minutosminutos=" + minutosminutos.getIdMinutos() + ", navegacioncuota=" + navegacioncuota.getIdNavegacion() + '}';
    }

    
    

}
