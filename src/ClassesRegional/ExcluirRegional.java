package ClassesRegional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class ExcluirRegional {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   CarregarListRegional carregar = new CarregarListRegional();
   
    
    public void excluindo(int patrimonio, JTable jtable){
	try {
	    st = connection.createStatement();
	    st.executeUpdate("DELETE FROM historico_regional WHERE patrimonio ="+patrimonio);
	    carregar.CarregarListRegional(jtable);
	    JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
}
