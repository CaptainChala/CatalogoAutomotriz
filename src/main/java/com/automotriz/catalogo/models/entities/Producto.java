package com.automotriz.catalogo.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Size(max = 10)
	@Column(name = "codigo")
	private String codigo;

	@NotBlank
	@Size(max = 50)
	@Column(name = "marca")
	private String marca;

	@NotBlank
	@Size(max = 50)
	@Column(name = "modelo")
	private String modelo;

	@NotNull
	@Column(name = "anio")
	private Integer anio;

	@NotNull
	@Column(name = "precio")
	private BigDecimal precio;

	@NotBlank
	@Column(name = "estado")
	private String estado;

	@NotBlank
	@Column(name = "tipo_bencina")
	private String tipoBencina;

	@Column(name = "transmision")
	private String transmision;

	@Column(name = "kilometraje")
	private String kilometraje;

	@Column(name = "imagen")
	private String imagen;

	public Producto() {
	}

	public String getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoBencina() {
		return tipoBencina;
	}

	public void setTipoBencina(String tipoBencina) {
		this.tipoBencina = tipoBencina;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}

	public String getPrecioFormateado() {
		if (precio == null)
			return "0";
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(precio);
	}

	private static final long serialVersionUID = 1L;
}
