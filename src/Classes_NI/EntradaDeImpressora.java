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
public class EntradaDeImpressora {
   PreencherTabelaImpressoraNI preencherTabelaImpressoraNI = new PreencherTabelaImpressoraNI();
   Statement st, st2 ;
   ResultSet rs, rs2;
   String query;
   
   public void entradaimpressora(int impressora, JTable jTableimpressorani){
        ConnectionMySQL mysql = new ConnectionMySQL();
        Connection connection = mysql.Conectar();
       try {
	    query = "SELECT * from impressorani WHERE patrimonio = '" + impressora +"'";
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "A impressora de patrimonio "+impressora+" já está cadastrado");
	    }else{
		query = "SELECT * from cpu WHERE impressora = '" + impressora +"'";
		st2 = connection.createStatement();
		rs2 = st.executeQuery(query);
		if(rs2.next()){
		    JOptionPane.showMessageDialog(null, "A impressora de patrimonio "+impressora+" já está cadastrado");
		}else{
		    try{
		    query = "INSERT INTO impressorani (patrimonio) VALUES (?)";
		    PreparedStatement preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setInt(1, impressora);
	
		    preparedStmt.executeUpdate();

		    connection.close();
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		preencherTabelaImpressoraNI.PreencherTabelaImpressoraNI(jTableimpressorani);
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
