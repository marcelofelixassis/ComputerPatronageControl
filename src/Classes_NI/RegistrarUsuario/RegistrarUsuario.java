package Classes_NI.RegistrarUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    VerificaIP verificaipziun = new VerificaIP();
    Statement st;
    ResultSet rs;
    
    
    public void registrar(String cpu, String ip, String setor, String usuario, String marca, String sisope,
	    String supcpu, String estab, String impressora, JTextField cp, JTextField i, JTextField se, JTextField usu, JTextField ma,
	    JTextField sis, JTextField su, JTextField est, JTextField imp){
	ConnectionMySQL mysql = new ConnectionMySQL();
	Connection connection = mysql.Conectar();
	if(!cpu.equals("") && !ip.equals("") && !setor.equals("") && !usuario.equals("") && 
	    !marca.equals("") && !sisope.equals("") && !supcpu.equals("") && !estab.equals("") && !impressora.equals("")){	 
	    if(cpuu.verificacpu(cpu) == true){
		if(verificaipziun.verificaip(ip) == true){
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
				    cp.setText("");i.setText("");se.setText("");usu.setText("");ma.setText("");sis.setText("");su.setText("");est.setText("");imp.setText("");
				    JOptionPane.showMessageDialog(null, "Novo usuário registrado!");
				    connection.close();
				}catch(SQLException e){
				    e.printStackTrace();
				}
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
