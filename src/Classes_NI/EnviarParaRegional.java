package Classes_NI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class EnviarParaRegional {
   PreencherTabelaComputadorNI preenchertabelacomputdorni = new PreencherTabelaComputadorNI();
   PreencherTabelaSupNI preencherTabelaSupNI = new PreencherTabelaSupNI();
   PreencherTabelaEstabNI preencherTabelaEstabNI = new PreencherTabelaEstabNI();
   PreencherTabelaImpressoraNI preencherTabelaImpressoraNI = new PreencherTabelaImpressoraNI();
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   
   public void enviarpararegionalCPU(int patrimonio, 
	JTable jtable, JComboBox jcombobox, JTextArea jTextArea, JButton jbutton, JButton jbutton2){
       if(!jcombobox.getSelectedItem().toString().equals("SELECIONE UMA REGIONAL")){	   
	    try {
		String query = "INSERT INTO historico_regional (patrimonio,tipo,regional,data,observacao)"
		    + "VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	       preparedStatement.setInt(1,patrimonio);	  
		preparedStatement.setString(2, "CPU");
		preparedStatement.setString(3, jcombobox.getSelectedItem().toString());
		preparedStatement.setString(4, Calendar.getInstance().getTime().toString());
		preparedStatement.setString(5, jTextArea.getText());	   

		preparedStatement.executeUpdate();

		try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM cpuni WHERE patrimonio ="+patrimonio);  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    preenchertabelacomputdorni.PreencherTabelaComputadorNI(jtable);
	    jcombobox.setEnabled(false); jTextArea.setEnabled(false); jbutton.setEnabled(false);jbutton2.setEnabled(false);
       }else{
	   JOptionPane.showMessageDialog(null, "Selecione uma regional!");
       }
    }   
   
   public void enviarpararegionalSUPORTE(int patrimonio, 
	   JTable jtable, JComboBox jcombobox, JTextArea jTextArea, JButton jbutton, JButton jbutton2){
       if(!jcombobox.getSelectedItem().toString().equals("SELECIONE UMA REGIONAL")){	
	    try {
		String query = "INSERT INTO historico_regional (patrimonio,tipo,regional,data,observacao)"
		     + "VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1,patrimonio);	  
		preparedStatement.setString(2, "SUPORTE");
		preparedStatement.setString(3, jcombobox.getSelectedItem().toString());
		preparedStatement.setString(4, Calendar.getInstance().getTime().toString());
		preparedStatement.setString(5, jTextArea.getText());	   

		preparedStatement.executeUpdate();

		try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM supni WHERE patrimonio ="+patrimonio);  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    }catch (Exception e) {
		e.printStackTrace();
	    }
	    preencherTabelaSupNI.PreencherTabelaSupNI(jtable);
	    jcombobox.setEnabled(false); jTextArea.setEnabled(false); jbutton.setEnabled(false);jbutton2.setEnabled(false); 
       }else{
	   JOptionPane.showMessageDialog(null, "Selecione uma regional!");
       }    
   }
   
   public void enviarpararegionalESTABILIZADOR(int patrimonio, 
	   JTable jtable, JComboBox jcombobox, JTextArea jTextArea, JButton jbutton, JButton jbutton2){
       if(!jcombobox.getSelectedItem().toString().equals("SELECIONE UMA REGIONAL")){	
	    try {
		String query = "INSERT INTO historico_regional (patrimonio,tipo,regional,data,observacao)"
		     + "VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1,patrimonio);	  
		preparedStatement.setString(2, "ESTABILIZADOR");
		preparedStatement.setString(3, jcombobox.getSelectedItem().toString());
		preparedStatement.setString(4, Calendar.getInstance().getTime().toString());
		preparedStatement.setString(5, jTextArea.getText());	   

		preparedStatement.executeUpdate();

		try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM estabni WHERE patrimonio ="+patrimonio);  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    preencherTabelaEstabNI.PreencherTabelaEstab(jtable);
	    jcombobox.setEnabled(false); jTextArea.setEnabled(false); jbutton.setEnabled(false);jbutton2.setEnabled(false); 
       }else{
	    JOptionPane.showMessageDialog(null, "Selecione uma regional!");
       } 
   }
   
   public void enviarpararegionalIMPRESSORA(int patrimonio, 
	   JTable jtable, JComboBox jcombobox, JTextArea jTextArea, JButton jbutton, JButton jbutton2){
       if(!jcombobox.getSelectedItem().toString().equals("SELECIONE UMA REGIONAL")){	
	    try {
		String query = "INSERT INTO historico_regional (patrimonio,tipo,regional,data,observacao)"
		    + "VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1,patrimonio);	  
		preparedStatement.setString(2, "IMPRESSORA");
		preparedStatement.setString(3, jcombobox.getSelectedItem().toString());
		preparedStatement.setString(4, Calendar.getInstance().getTime().toString());
		preparedStatement.setString(5, jTextArea.getText());	   

		preparedStatement.executeUpdate();

		try{
		    st = connection.createStatement();
		    st.executeUpdate("DELETE FROM impressorani WHERE patrimonio ="+patrimonio);  
		}catch(Exception e){
		    e.printStackTrace();
		}
		connection.close();  
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    preencherTabelaImpressoraNI.PreencherTabelaImpressoraNI(jtable);
	    jcombobox.setEnabled(false); jTextArea.setEnabled(false); jbutton.setEnabled(false);jbutton2.setEnabled(false); 
        }else{
	   JOptionPane.showMessageDialog(null, "Selecione uma regional!");
        }    
    }  
}

