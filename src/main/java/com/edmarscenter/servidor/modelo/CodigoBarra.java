package com.edmarscenter.servidor.modelo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="codigoBarra")
public class CodigoBarra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_codigoBarra;
	
	private String codPais="786";
	
	private int codigoLocal;
	
	private int codProducto;
	
	private int digitoControl;
	
	private String codigoDeBarra;
	
	private String link;
	
	@OneToMany(mappedBy="codigoBarra")
	private Set<Producto> productos;
	
	public void generarCodigo() {
		this.codigoDeBarra=unirCampos();
	}
	public String cargarCodigoLocal() {//tam de 4
		String cod=String.valueOf(this.codigoLocal);
		String codigo="";
		for (int i=0;i<4-cod.length();i++) {
			codigo+="0";
		}
		codigo+=cod;
		return codigo;
	}
	
	public String cargarCodProducto() {//tama;o de 5
		String cod=String.valueOf(this.codProducto);
		String codigo="";
		for (int i=0;i<5-cod.length();i++) {
			codigo+="0";
		}
		codigo+=cod;
		return codigo;
	}
	
	public String unirCampos(){
		String datos=this.codPais+cargarCodigoLocal()+cargarCodProducto();
		char [] x=datos.toCharArray();
		int sumaPar=0;
		int sumaImpar=0;
		for (int i=x.length-1;i>=0;i--) {//suma de la posicion par
			if(i%2==0) {
				sumaPar+=Integer.parseInt(Character.toString(x[i]));//sumamos todos los impares
			}else {
				sumaImpar+=Integer.parseInt(Character.toString(x[i]));
			}
		}
		int sumatoria=sumaImpar*3+sumaPar;
		System.out.println("Sumatoria:"+sumatoria);
		this.digitoControl=((sumatoria/10)+1)*10-sumatoria;
		return datos+String.valueOf(this.digitoControl);	
	}
	public int getId_codigoBarra() {
		return id_codigoBarra;
	}
	public void setId_codigoBarra(int id_codigoBarra) {
		this.id_codigoBarra = id_codigoBarra;
	}
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public int getCodigoLocal() {
		return codigoLocal;
	}
	public void setCodigoLocal(int codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public int getDigitoControl() {
		return digitoControl;
	}
	public void setDigitoControl(int digitoControl) {
		this.digitoControl = digitoControl;
	}
	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
