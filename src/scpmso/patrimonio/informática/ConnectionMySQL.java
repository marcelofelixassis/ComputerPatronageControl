package scpmso.patrimonio.informática;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Marcelo Félix -- marcelofelix.af@gmail.com
 * 
 */
public class ConnectionMySQL {
    public String db = "patrimonio";
    public String url = "jdbc:mysql://10.16.90.8/"+db;
    public String user = "patrimonio";
    public String pass = "2ehpmxnd";
    
    public ConnectionMySQL(){  
    }
  
    public Connection Conectar(){
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
}