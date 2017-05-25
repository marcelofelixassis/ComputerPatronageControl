package ClassesDeposito;

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
public class ExcluirDeposito {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   CarregarListDeposito carregar = new CarregarListDeposito();
   
   
   public void excluindo(int patrimonio, JTable jtable){
       try {
	    st = connection.createStatement();
	    st.executeUpdate("DELETE FROM deposito WHERE patrimonio ="+patrimonio);
	    carregar.CarregarListDeposito(jtable);
	    JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
   }
}
