package Classes_NI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ComputadorNI;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class PreencherTabelaComputadorNI {
    public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    
     public void PreencherTabelaComputadorNI(JTable jTablecpuni){  
       ArrayList<ComputadorNI> usersList = new ArrayList<ComputadorNI>();
       model = (DefaultTableModel)jTablecpuni.getModel();
       String query = "SELECT * FROM  `cpuni` ";
       
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
           ComputadorNI computadorni;
           while(rs.next())
           {
               computadorni = new ComputadorNI(rs.getInt("patrimonio"), rs.getString("marca"), rs.getString("sisope"));
	       
               usersList.add(computadorni);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<ComputadorNI> list = usersList;
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();          
           row[1] = list.get(i).getMarca();
           row[2] = list.get(i).getSo();           
	   
           model.addRow(row);
       }
    }  
}
