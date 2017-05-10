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
public class VerificaCPU {
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    public Boolean aux = true;
    
    
    public Boolean verificacpu(int patrimonio){
	String query = "SELECT * from cpu WHERE patrimonio = '" + patrimonio +"'";
	try {
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "O cpu de patrimonio "+patrimonio+" já está sendo usado");
		aux = false;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return aux;
    }   
}
