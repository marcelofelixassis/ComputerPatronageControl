/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Home;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.Computador;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author admin
 */
public class PesquisasAvancada {
    public DefaultTableModel model = new DefaultTableModel();
    ConnectionMySQL mysql = new ConnectionMySQL();
    Connection connection = mysql.Conectar();
    Statement st;
    ResultSet rs;
    
    public void asdf (JTable ob, String tipo, String text){
	
	if(tipo.equals("CPU")){
	    tipo = "patrimonio";
	}else if(tipo.equals("Suporte")){
	    tipo = "supcpu";
	}else if(tipo.equals("Estabilizador")){
	    tipo = "estab";
	}else if(tipo.equals("Impressora")){
	    tipo = "impressora";
	}
	
       ArrayList<Computador> usersList = new ArrayList<Computador>();
       model = (DefaultTableModel)ob.getModel();
       String query = "SELECT * FROM  `cpu` WHERE "+ tipo +" = "+text;
       
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
           Computador computador;
           while(rs.next())
           {
               computador = new Computador(rs.getInt("id"),rs.getInt("patrimonio"),rs.getString("ip"),
		       rs.getString("setor"), rs.getString("usuario"), rs.getString("marca"), rs.getString("so"),
		       rs.getString("supcpu"), rs.getString("estab"), rs.getString("impressora"));
	       
               usersList.add(computador);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<Computador> list = usersList;
       Object[] row = new Object[10];
       for(int i = 0; i < list.size(); i++)
       {
	   row[0] = list.get(i).getId();
           row[1] = list.get(i).getPatrimonio();
           row[2] = list.get(i).getIp();
           row[3] = list.get(i).getSetor();
	   row[4] = list.get(i).getUsuario();
           row[5] = list.get(i).getMarca();
           row[6] = list.get(i).getSo();
           row[7] = list.get(i).getSupcpu();
	   row[8] = list.get(i).getEstab();
	   row[9] = list.get(i).getImpressora();

	   
           model.addRow(row);
       }
    }
    
}
