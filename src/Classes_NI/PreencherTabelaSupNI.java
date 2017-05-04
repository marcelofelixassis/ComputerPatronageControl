/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_NI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;
import scpmso.patrimonio.informática.ImpressoraNI;
import scpmso.patrimonio.informática.SupNI;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class PreencherTabelaSupNI {
     public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    
     public void PreencherTabelaSupNI(JTable jTablesupni){  
       ArrayList<SupNI> usersList = new ArrayList<SupNI>();
       model = (DefaultTableModel)jTablesupni.getModel();
       String query = "SELECT * FROM  `supni` ";
       
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
           SupNI supni;
           while(rs.next())
           {
               supni = new SupNI(rs.getInt("patrimonio"));
	       
               usersList.add(supni);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<SupNI> list = usersList;
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();          
	   
           model.addRow(row);
       }
    }
}
