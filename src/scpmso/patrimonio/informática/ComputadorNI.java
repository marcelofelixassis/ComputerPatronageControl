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
public class ComputadorNI {
    
    private int patrimonio;
    private String marca,so;
    
    
    public ComputadorNI(int patrimonio, String marca, String so){
	this.patrimonio = patrimonio;
	this.marca = marca;
	this.so = so;
    }

    public int getPatrimonio() {
	return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
	this.patrimonio = patrimonio;
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
    
    
    
}
