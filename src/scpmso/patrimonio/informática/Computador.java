/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scpmso.patrimonio.informática;

/**
 *
 * @author admin
 */
public class Computador {
    
    private int id, patrimonio;
    private String ip,setor,usuario,marca,so,supcpu,estab,impressora;
    
    
    public Computador(int id, int patrimonio, String ip, String setor, String usuario, String marca, String so,
	    String supcpu, String estab, String impressora){
	this.id = id;
	this.patrimonio = patrimonio;
	this.ip = ip;
	this.setor = setor;
	this.usuario = usuario;
	this.marca = marca;
	this.so = so;
	this.supcpu = supcpu;
	this.estab = estab;
	this.impressora = impressora;
    }
    
     public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getPatrimonio() {
	return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
	this.patrimonio = patrimonio;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public String getSetor() {
	return setor;
    }

    public void setSetor(String setor) {
	this.setor = setor;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public String getSo() {
	return so;
    }

    public void setSo(String so) {
	this.so = so;
    }

    public String getSupcpu() {
	return supcpu;
    }

    public void setSupcpu(String supcpu) {
	this.supcpu = supcpu;
    }

    public String getEstab() {
	return estab;
    }

    public void setEstab(String estab) {
	this.estab = estab;
    }

    public String getImpressora() {
	return impressora;
    }

    public void setImpressora(String impressora) {
	this.impressora = impressora;
    }
    
    
}
