package Classes_Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class EnviarPara340 {
   
    
    public void enviarcpu(int patrimonio, String marca, String sisope, int aux){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
	ResultSet rs;
	if(aux == 1){
	    try{
		String query = "INSERT INTO cpuni (patrimonio, marca, sisope) VALUES (?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, patrimonio);
		preparedStmt.setString(2, marca);
		preparedStmt.setString(3, sisope);

		preparedStmt.executeUpdate();
		connection.close();

		JOptionPane.showMessageDialog(null, "Patrimonio CPU cadastrado em NI - 316!");
	    }
	    catch (Exception e){
		e.printStackTrace();
	    }
	}else{
	    try {
	        String query = "INSERT INTO deposito (patrimonio, tipo, data) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, patrimonio);	  
		preparedStatement.setString(2, "CPU");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio CPU cadastrado em DEPOSITO - 340!");
	    }catch(Exception e ){
		e.printStackTrace();
	    }
	}	
    }
    
    
    public void enviarsup(int patrimonio, int aux){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
	ResultSet rs;
	if(aux == 1){
	    try {
		String query = "INSERT INTO supni (patrimonio) VALUES (?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, patrimonio);
	
		preparedStmt.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio SUPORTE cadastrado em NI - 316!");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}else{
	    try {
		String query = "INSERT INTO deposito (patrimonio, tipo, data) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, patrimonio);	  
		preparedStatement.setString(2, "SUPORTE");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio SUPORTE cadastrado em DEPOSITO - 340!");
	    } catch (Exception e) {
	    }
	}	
    }

    public EnviarPara340() {
    }
    
    
    public void enviarestab(int patrimonio, int aux){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
	ResultSet rs;
	if(aux == 1){
	    try {
		String query = "INSERT INTO estabni (patrimonio) VALUES (?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, patrimonio);
	
		preparedStmt.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio ESTABILIZADOR cadastrado em NI - 316!");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}else{
	    try {
		String query = "INSERT INTO deposito (patrimonio, tipo, data) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, patrimonio);	  
		preparedStatement.setString(2, "SUPORTE");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio ESTABILIZADOR cadastrado em DEPOSITO - 340!");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    
    public void enviarimpressora(int patrimonio, int aux){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	Statement st;
	ResultSet rs;
	if(aux == 1){
	    try {
		String query = "INSERT INTO impressorani (patrimonio) VALUES (?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, patrimonio);
	
		preparedStmt.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio IMPRESSORA cadastrado em NI - 316!");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}else{
	     try {
		String query = "INSERT INTO deposito (patrimonio, tipo, data) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, patrimonio);	  
		preparedStatement.setString(2, "IMPRESSORA");
		preparedStatement.setString(3, Calendar.getInstance().getTime().toString());
			   
		preparedStatement.executeUpdate();
		connection.close();
		
		JOptionPane.showMessageDialog(null, "Patrimonio IMPRESSORA cadastrado em DEPOSITO - 340!");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    
	}
    }
}
