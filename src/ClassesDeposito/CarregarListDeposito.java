package ClassesDeposito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;
import scpmso.patrimonio.informática.Deposito;

/**
 *
 * @uthor Marcelo Félix - marcelofelix.af@gmail.com
 */
public class CarregarListDeposito {
    public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    
     public void CarregarListDeposito (JTable jTabledeposito){  
       ArrayList<Deposito> usersList = new ArrayList<Deposito>();
       model = (DefaultTableModel)jTabledeposito.getModel();
       String query = "SELECT * FROM  `deposito` ";
       
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
           Deposito deposito;
           while(rs.next())
           {
               deposito = new Deposito(rs.getInt("patrimonio"), rs.getString("tipo"),rs.getString("data"));
	       
               usersList.add(deposito);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<Deposito> list = usersList;
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();          
           row[1] = list.get(i).getTipo();
	   row[2] = list.get(i).getData();
           model.addRow(row);
       }
    }  
    
}
