package Classes_NI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class ExcluirNi {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   
   public void excluir(String parametro, String text, JTable cpuni, JTable supni, JTable estabni, JTable impressorani, String nome){
       if(parametro.equals("")){
	   JOptionPane.showMessageDialog(null, "Campo vazio ! Entre com o numero de patrimonio de"+
		   " um "+nome+" que esteja na sala NI para ser excluido");
        }else{
	    Object opcoes[] = {"Sim", "Não"}; //0 1
	    int selection = JOptionPane.showOptionDialog(
		null, "Deseja excluir o "+nome+" de patrimonio:"+parametro+" da sala NI ?", "",
		0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
	    );
	    switch(selection){
		case 0:
		    try {
			st = connection.createStatement();
			st.executeUpdate("DELETE FROM "+text+" WHERE patrimonio ="+parametro);
		    } catch (SQLException e) {
			e.printStackTrace();
		    }
		break;    
	    }   
        }
       if(text.equals("cpuni")){
	   PreencherTabelaComputadorNI preencherTabelaComputadorNI = new PreencherTabelaComputadorNI();
	   preencherTabelaComputadorNI.PreencherTabelaComputadorNI(cpuni);
       }else if(text.equals("supni")){
	   PreencherTabelaSupNI preencherTabelaSupNI = new PreencherTabelaSupNI();
	   preencherTabelaSupNI.PreencherTabelaSupNI(supni);
       }else if(text.equals("estabni")){
	   PreencherTabelaEstabNI preencherTabelaEstabNI = new PreencherTabelaEstabNI();
	   preencherTabelaEstabNI.PreencherTabelaEstab(estabni);
       }else if(text.equals("impressorani")){
	   PreencherTabelaImpressoraNI preencherTabelaImpressoraNI = new PreencherTabelaImpressoraNI();
	   preencherTabelaImpressoraNI.PreencherTabelaImpressoraNI(impressorani);
       }
   }
}
