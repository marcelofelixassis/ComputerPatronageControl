package Classes_NI.RegistrarUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class VerificaIP {
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    int patrimonio;
    String usu, setor;
    Boolean aux;
    
    public Boolean verificaip(String ip){
	String query = "SELECT patrimonio, usuario, setor from cpu WHERE ip = '"+ip+"'";
	try {
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    
	    if(rs.next()){
	    patrimonio = rs.getInt("patrimonio");
	    usu = rs.getString("usuario");
	    setor = rs.getString("setor");
	    }
	    if(patrimonio == 0 || usu.equals("-") || setor.equals("-")){
		aux = true;
		
	    }else{
		aux = false;
		JOptionPane.showMessageDialog(null, "O ip "+ ip +" está em uso!");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return aux;
    } 
}
