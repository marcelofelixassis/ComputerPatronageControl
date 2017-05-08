package Classes_NI;

import java.sql.Connection;
import java.sql.Statement;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class MoverPara340 {
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
}
