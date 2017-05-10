package Classes_NI.RegistrarUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class RegistrarUsuario {
    VerificaCPU cpuu = new VerificaCPU();
    VerificaESTAB estabb = new VerificaESTAB();
    VerificaSUP sup = new VerificaSUP();
    VerificaIMPRESSORA impress = new VerificaIMPRESSORA();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    
    public void registrar(int cpu, String ip, String setor, String usuario, String marca, String sisope,
	    String supcpu, String estab, String impressora){
	if(!String.valueOf(cpu).equals("") && !ip.equals("") && !setor.equals("") && !usuario.equals("") && 
	    !marca.equals("") && !sisope.equals("") && !supcpu.equals("") && !estab.equals("") && !impressora.equals("")){
	    if(cpuu.verificacpu(cpu) == true){
		if(sup.verificasup(supcpu) == true){
		    if(estabb.verificaestab(estab) == true){
			if(impress.verificaimpressora(impressora)){
			    try{
				PreparedStatement updateEXP = connection.prepareStatement("UPDATE cpu set patrimonio = '"+cpu+"',"
				+ "ip = '"+ip+"',"
				+ "setor = '"+setor+"', "
				+ "usuario = '"+usuario+"',"
				+ "marca = '"+marca+"',"
				+ "so = '"+sisope+"',"
				+ "supcpu = '"+supcpu+"',"
				+ "estab = '"+estab+"',"
				+ "impressora = '"+impressora+"'"
				+ "where ip = '"+ip+"'");
				updateEXP.executeUpdate();
			    }catch(SQLException e){
				e.printStackTrace();
			    }
			}
		    }
		}
	    }
	}else{
	    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos, caso não queira use: -");
	}
    }
}
