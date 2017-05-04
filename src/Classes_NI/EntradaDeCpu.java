/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class EntradaDeCpu {
   PreencherTabelaComputadorNI preencherTabelaComputadorNI = new PreencherTabelaComputadorNI();
   Statement st, st2 ;
   ResultSet rs, rs2;
   String query;
   
   public void entradacpu(int cpu, String marca, String sisope, JTable jTablecpuni){
        ConnectionMySQL mysql = new ConnectionMySQL();
        Connection connection = mysql.Conectar();
       try {
	    query = "SELECT * from cpuni WHERE patrimonio = '" + cpu +"'";
	    st = connection.createStatement();
	    rs = st.executeQuery(query);
	    if(rs.next()){
		JOptionPane.showMessageDialog(null, "O cpu de patrimonio "+cpu+" já está cadastrado");
	    }else{
		query = "SELECT * from cpu WHERE patrimonio = '" + cpu +"'";
		st2 = connection.createStatement();
		rs2 = st.executeQuery(query);
		if(rs2.next()){
		    JOptionPane.showMessageDialog(null, "O cpu de patrimonio "+cpu+" já está cadastrado");
		}else{
		    try{
		    query = "INSERT INTO cpuni (patrimonio, marca, sisope) VALUES (?, ?, ?)";
		    PreparedStatement preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setInt(1, cpu);
		    preparedStmt.setString(2, marca);
		    preparedStmt.setString(3, sisope);
	 
		    preparedStmt.executeUpdate();

		    connection.close();
		}
		catch (Exception e){
		    e.printStackTrace();
		}
		preencherTabelaComputadorNI.PreencherTabelaComputadorNI(jTablecpuni);
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
