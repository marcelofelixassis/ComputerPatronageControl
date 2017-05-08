/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_NI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import scpmso.patrimonio.informática.ConnectionMySQL;
import sun.util.logging.resources.logging;

/**
 *
 * @author admin
 */
public class EncontrarIpDisponivel {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   String aux;
   
   
   public void encontraripdisponivel(JTextField txt){
       try {
	    st = connection.createStatement();
	     st.executeQuery("select ip from `cpu` WHERE patrimonio = 0 AND usuario = '-'");
            ResultSet rs = st.getResultSet();
       
            while(rs.next()){
	     aux = rs.getString("ip");
	    }
	    txt.setText(aux);
       } catch (Exception e) {
	   e.printStackTrace();
       }
      
   }
    
}
