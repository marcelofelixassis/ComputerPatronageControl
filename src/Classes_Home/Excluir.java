package Classes_Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class Excluir {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
    
   public void exclui(String patrimonio, String ip, int idSelecionado){
	Object opcoes[] = {"Sim", "Não"}; //0 1
	    int selection = JOptionPane.showOptionDialog(
		null, "Deseja excluir todos os dados referentes ao CPU "+patrimonio+" ?", "",
		0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
	    );
	switch(selection){
	    case 0:
		String ps = "-";
		try{
		    PreparedStatement updateEXP = connection.prepareStatement("UPDATE cpu set patrimonio = '"+0+"',"
			+ "ip = '"+ip+"',"
			+ "setor = '"+ps+"', "
			+ "usuario = '"+ps+"',"
			+ "marca = '"+ps+"',"
			+ "so = '"+ps+"',"
			+ "supcpu = '"+ps+"',"
			+ "estab = '"+ps+"',"
			+ "impressora = '"+ps+"'"
			+ "where id = '"+idSelecionado+"'");
		    updateEXP.executeUpdate();
		}catch(Exception e){
		    e.printStackTrace();
		}
	    break;    
	}
    }
}
