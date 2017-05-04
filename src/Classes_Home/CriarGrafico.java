/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class CriarGrafico {
   public int vetorParaGrafico[] = {0,1,2,3,4};
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
    
    public void criargrafico(JPanel jPanel3){
	String pcs[] = {"'HP'", "'IBM'", "'LENOVO'", "'POSITIVO'", "'NACIONAL'"};
	for(int i = 0; i <= 4; i++){
	    String query = "SELECT * FROM `cpu` WHERE marca = "+pcs[i];
	    	   
	    try{
		st = connection.createStatement();
		rs = st.executeQuery(query);	
		if(rs.last()){
		    int aux = rs.getRow();
		    vetorParaGrafico[i] = aux;
		}
	    }catch(Exception e){
		e.printStackTrace();
	    }    
	}
	
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	dataset.setValue(vetorParaGrafico[0], "Quantidade", "HP");
	dataset.setValue(vetorParaGrafico[1], "Quantidade", "IBM");
	dataset.setValue(vetorParaGrafico[2], "Quantidade", "LENOVO");
	dataset.setValue(vetorParaGrafico[3], "Quantidade", "POSITIVO");
	dataset.setValue(vetorParaGrafico[4], "Quantidade", "NACIONAL");
	
	
	JFreeChart chart = ChartFactory.createBarChart3D(null, null, "Quantidade", dataset, PlotOrientation.VERTICAL, false, true, false);
	CategoryPlot p = chart.getCategoryPlot();
	CategoryItemRenderer renderer = p.getRenderer();
	renderer.setSeriesPaint(0,new Color(80,151,204));
	p.setRangeGridlinePaint(Color.BLACK);
	ChartPanel panel = new ChartPanel(chart);
	panel.setDomainZoomable(true);
	panel.setVisible(true);
	jPanel3.setLayout(new BorderLayout());
	jPanel3.add(panel, BorderLayout.CENTER);
	jPanel3.revalidate(); 
        jPanel3.repaint();
	System.gc();
    }
    
}
