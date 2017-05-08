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
public class EntradaDeSuporte {
   PreencherTabelaSupNI preencherTabelaSupNI = new PreencherTabelaSupNI();
   Statement st, st2 ;
   ResultSet rs, rs2;
   String query;
   
   public void entradasuporte(int suporte, JTable jTablesupni){
        ConnectionMySQL mysql = new ConnectionMySQL();
        Connection connection = mysql.Conectar();
       try {
	    query = "SELECT * from supni WHERE patrimonio = '" + suporte +"'";
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "O suporte de patrimonio "+suporte+" já está cadastrado");
	    }else{
		query = "SELECT * from cpu WHERE supcpu = '" + suporte +"'";
		st2 = connection.createStatement();
		rs2 = st.executeQuery(query);
		if(rs2.next()){
		    JOptionPane.showMessageDialog(null, "O suporte de patrimonio "+suporte+" já está cadastrado");
		}else{
		    try{
		    query = "INSERT INTO supni (patrimonio) VALUES (?)";
		    PreparedStatement preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setInt(1, suporte);
	
		    preparedStmt.executeUpdate();

		    connection.close();
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		preencherTabelaSupNI.PreencherTabelaSupNI(jTablesupni);
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
