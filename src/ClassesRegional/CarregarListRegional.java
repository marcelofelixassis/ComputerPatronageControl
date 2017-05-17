package ClassesRegional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;
import scpmso.patrimonio.informática.Regional;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class CarregarListRegional {
    public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    
     public void CarregarListRegional(JTable jTableregional){  
       ArrayList<Regional> usersList = new ArrayList<Regional>();
       model = (DefaultTableModel)jTableregional.getModel();
       String query = "SELECT * FROM  `historico_regional` ";
       
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
           Regional regional;
           while(rs.next())
           {
               regional = new Regional(rs.getInt("patrimonio"), rs.getString("tipo"), rs.getString("regional"),
	       rs.getString("data"), rs.getString("observacao"));
	       
               usersList.add(regional);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<Regional> list = usersList;
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();
	   row[1] = list.get(i).getTipo();
	   row[2] = list.get(i).getRegional();
	   row[3] = list.get(i).getData();
	   row[4] = list.get(i).getObservacao();
	   
           model.addRow(row);
       }
    }
}
