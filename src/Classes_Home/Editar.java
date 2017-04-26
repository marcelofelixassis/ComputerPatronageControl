/*
 * 
 * CLASSE PARA EDITAR CPU'S, ESTABLIZADORES, SUPORTES E ETC
 * 
 */
package Classes_Home;

import Forms.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class Editar {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   
   
    public void Edit(String patrimonio, String ip, String setor, String usuario, 
	    String marca, String sisop, String supcpu, String estab, String impressora, 
	    int idSelecionado, String patrimonioBtnEditar, String supcpuBtnEditar, 
	    String estabBtnEditar, String impressoraBtnEditar) {
	try{
	   PreparedStatement updateEXP = connection.prepareStatement("UPDATE cpu set patrimonio = '"+patrimonio+"',"
	    + "ip = '"+ip+"',"
	    + "setor = '"+setor+"', "
	    + "usuario = '"+usuario+"',"
	    + "marca = '"+marca+"',"
	    + "so = '"+sisop+"',"
	    + "supcpu = '"+supcpu+"',"
	    + "estab = '"+estab+"',"
	    + "impressora = '"+impressora+"'"
	    + "where id = '"+idSelecionado+"'");
	    updateEXP.executeUpdate();
	}catch(SQLException e){
	    e.printStackTrace();
	}
    }
   
}
