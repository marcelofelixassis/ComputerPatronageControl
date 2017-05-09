package Classes_NI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class EntradaDeEstabilizador {
   PreencherTabelaEstabNI preencherTabelaEstabNI = new PreencherTabelaEstabNI();
   Statement st, st2 ;
   ResultSet rs, rs2;
   String query;
   
   public void entradaestabilizador(int estab, JTable jTableestabni){
        ConnectionMySQL mysql = new ConnectionMySQL();
        Connection connection = mysql.Conectar();
       try {
	    query = "SELECT * from estabni WHERE patrimonio = '" + estab +"'";
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "O estabilizador de patrimonio "+estab+" já está cadastrado");
	    }else{
		query = "SELECT * from cpu WHERE estab = '" + estab +"'";
		st2 = connection.createStatement();
		rs2 = st.executeQuery(query);
		if(rs2.next()){
		    JOptionPane.showMessageDialog(null, "O estabilizador de patrimonio "+estab+" já está cadastrado");
		}else{
		    try{
		    query = "INSERT INTO estabni (patrimonio) VALUES (?)";
		    PreparedStatement preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setInt(1, estab);
	
		    preparedStmt.executeUpdate();

		    connection.close();
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		preencherTabelaEstabNI.PreencherTabelaEstab(jTableestabni);
		st.close();
		st2.close();
		rs.close();
		rs2.close();
		}
	    }   
        } catch (Exception e) {
	    e.printStackTrace();
        }
    }  
    
}
