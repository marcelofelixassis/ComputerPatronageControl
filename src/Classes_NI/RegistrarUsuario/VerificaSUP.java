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
public class VerificaSUP {
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    public Boolean aux = true;
    
    
    public Boolean verificasup(String patrimonio){
	String query = "SELECT * from cpu WHERE supcpu = '" + patrimonio +"'";
	try {
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "O suporte de patrimonio "+patrimonio+" já está sendo usado");
		aux = false;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return aux;
    }     
}
