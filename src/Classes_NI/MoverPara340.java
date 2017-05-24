package Classes_NI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com.br
 */
public class MoverPara340 {
   PreencherTabelaComputadorNI preenchertabelacomputdorni = new PreencherTabelaComputadorNI();
   PreencherTabelaSupNI preencherTabelaSupNI = new PreencherTabelaSupNI();
   PreencherTabelaEstabNI preencherTabelaEstabNI = new PreencherTabelaEstabNI();
   PreencherTabelaImpressoraNI preencherTabelaImpressoraNI = new PreencherTabelaImpressoraNI();
   
   
   
   public void moverpara340cpu(JTextField txt, JTable table){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
       if(!txt.getText().isEmpty()){
	   try {
	       String query = "INSERT INTO deposito (patrimonio,tipo,data)"
		    + "VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1,Integer.parseInt(txt.getText()));	  
		preparedStatement.setString(2, "CPU");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
		
		try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM cpuni WHERE patrimonio ="+Integer.parseInt(txt.getText()));  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }   
	   txt.setText("");
	   preenchertabelacomputdorni.PreencherTabelaComputadorNI(table);
        }else{
	   JOptionPane.showMessageDialog(null, "Selecione um patrimonio de CPU!");
        }
   }
   
   
   
   
   public void moverpara340supcpu(JTextField txt, JTable table){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
       if(!txt.getText().isEmpty()){
	   try {
	       String query = "INSERT INTO deposito (patrimonio,tipo,data)"
		    + "VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1,Integer.parseInt(txt.getText()));	  
		preparedStatement.setString(2, "SUPORTE");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
	   try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM supni WHERE patrimonio ="+Integer.parseInt(txt.getText()));  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }   
	   txt.setText("");
	   preencherTabelaSupNI.PreencherTabelaSupNI(table);
       }else{
	   JOptionPane.showMessageDialog(null, "Selecione um patrimonio de Suporte!");
       }
   }
   
   public void moverpara340esatb(JTextField txt, JTable table){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
       if(!txt.getText().isEmpty()){
	   try {
	       String query = "INSERT INTO deposito (patrimonio,tipo,data)"
		    + "VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1,Integer.parseInt(txt.getText()));	  
		preparedStatement.setString(2, "ESTABILIZADOR");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
	   try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM estabni WHERE patrimonio ="+Integer.parseInt(txt.getText()));  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }   
	   txt.setText("");
	   preencherTabelaEstabNI.PreencherTabelaEstab(table);
       }else{
	   JOptionPane.showMessageDialog(null, "Selecione um patrimonio de Estabilizador!");
       }
   }
   
    public void moverpara340impressora(JTextField txt, JTable table){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
        Statement st;
       if(!txt.getText().isEmpty()){
	   try {
	       String query = "INSERT INTO deposito (patrimonio,tipo,data)"
		    + "VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1,Integer.parseInt(txt.getText()));	  
		preparedStatement.setString(2, "IMPRESSORA");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
	   try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM impressorani WHERE patrimonio ="+Integer.parseInt(txt.getText()));  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }   
	   txt.setText("");
	   preencherTabelaImpressoraNI.PreencherTabelaImpressoraNI(table);
       }else{
	   JOptionPane.showMessageDialog(null, "Selecione um patrimonio de Impressora!");
       }
   }
   
}
