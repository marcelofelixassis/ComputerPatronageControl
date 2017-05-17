package scpmso.patrimonio.informática;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class Deposito {
    
    private int patrimonio;
    private String tipo, data;
    
    public Deposito(int patrimonio, String tipo, String data){
	this.patrimonio = patrimonio;
	this.tipo = tipo;
	this.data = data;
    }

    public int getPatrimonio() {
	return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
	this.patrimonio = patrimonio;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }


    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }    
}
