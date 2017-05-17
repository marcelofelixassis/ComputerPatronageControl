package scpmso.patrimonio.informática;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class Regional {
    
    private int patrimonio;
    private String tipo, regional, data, observacao;
    
    
    public Regional(int patrimonio, String tipo, String regional, String data, String observaco){
	this.patrimonio = patrimonio;
	this.tipo = tipo;
	this.regional = regional;
	this.data = data;
	this.observacao = observaco;
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

    public String getRegional() {
	return regional;
    }

    public void setRegional(String regional) {
	this.regional = regional;
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }

    public String getObservacao() {
	return observacao;
    }

    public void setObservacao(String observacao) {
	this.observacao = observacao;
    }
    
    
    
}
