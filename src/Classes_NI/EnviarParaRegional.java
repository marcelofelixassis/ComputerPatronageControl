/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_NI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author admin
 */
public class EnviarParaRegional {
    PreencherTabelaComputadorNI preenchertabelacomputdorni = new PreencherTabelaComputadorNI();
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   
   public void enviarpararegional(int patrimonio, String tipo, 
	   JTable jtable, JComboBox jcombobox, JTextArea jTextArea, JButton jbutton){
       if(tipo.equals("CPU")){
	   try {
	       String query = "INSERT INTO historico_regional (patrimonio,tipo,regional,data,observacao)"
		       + "VALUES (?,?,?,?,?)";
	       PreparedStatement preparedStatement = connection.prepareStatement(query);
	       preparedStatement.setInt(1,patrimonio);	  
	       preparedStatement.setString(2, tipo);
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
	   jcombobox.setEnabled(false); jTextArea.setEnabled(false); jbutton.setEnabled(false);
        }else{
	   
       }    
   }  
}
