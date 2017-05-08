package Classes_NI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;
import scpmso.patrimonio.informática.EstabNI;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class PreencherTabelaEstabNI {
    public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    public void PreencherTabelaEstab(JTable jTableestabni){  
       ArrayList<EstabNI> usersList = new ArrayList<EstabNI>();
       model = (DefaultTableModel)jTableestabni.getModel();
       String query = "SELECT * FROM  `estabni` ";
       
       usersList.clear();
       if (model.getRowCount() > 0) {  
           int x = -1;  
           int j = model.getRowCount();  
           do {  
               model.removeRow(0);  
               --j;  
           } while (j > 0);  
       }  
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           EstabNI estabni;
           while(rs.next())
           {
               estabni = new EstabNI(rs.getInt("patrimonio"));
	       
               usersList.add(estabni);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<EstabNI> list = usersList;
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();          
	   
           model.addRow(row);
       }
    }
}
