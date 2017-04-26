/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Animacion.Animacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import scpmso.patrimonio.informática.Computador;
import scpmso.patrimonio.informática.ComputadorNI;
import scpmso.patrimonio.informática.ConnectionMySQL;
import scpmso.patrimonio.informática.EstabNI;
import scpmso.patrimonio.informática.ImpressoraNI;
import scpmso.patrimonio.informática.SupNI;

/**
 *
 * @author admin
 */
public class MainFrame extends javax.swing.JFrame {
    
    
   public DefaultTableModel model = new DefaultTableModel();
   public int vetorParaGrafico[] = {0,1,2,3,4};
   public int idSelecionado;
   public String patrimonioBtnEditar, supcpuBtnEditar, estabBtnEditar, impressoraBtnEditar;
   
   
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   
   
    public MainFrame() {
	initComponents();
	jText_ip.setEnabled(false);
	jTableComputador.setDefaultEditor(Object.class, null);
	this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
	PreencherTabelaComputador();
	ObterValorDoGrafico();
	CarregaGrafico(vetorParaGrafico[0], vetorParaGrafico[1], vetorParaGrafico[2], vetorParaGrafico[3], vetorParaGrafico[4]);
	
	DefaultTableCellRenderer cor = new DefaultTableCellRenderer() {
            public void setValue(Object value) {
                setForeground(new Color(80,151,204));
                super.setValue(value);
            }
        };
	jTableComputador.getColumnModel().getColumn(2).setCellRenderer(cor);
	
	
	

    }
    
    
    /**
     * Metodo para preencher toda a tabelda de computadores
     */
    public void PreencherTabelaComputador(){  
       ArrayList<Computador> usersList = new ArrayList<Computador>();
       model = (DefaultTableModel)jTableComputador.getModel();
       String query = "SELECT * FROM  `cpu` ORDER BY 'ip' ";
       
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
    
    public void PesquisarPeloSetor(String text){  
       ArrayList<Computador> usersList = new ArrayList<Computador>();
       model = (DefaultTableModel)jTableComputador.getModel();
       String query = "SELECT * FROM  `cpu` WHERE setor = "+text;
      
       
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
   
    
    public void ObterValorDoGrafico(){
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
    }
    
    public void CarregaGrafico(int hp, int ibm, int lenovo, int positivo, int nacional){
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	dataset.setValue(hp, "Quantidade", "HP");
	dataset.setValue(ibm, "Quantidade", "IBM");
	dataset.setValue(lenovo, "Quantidade", "LENOVO");
	dataset.setValue(positivo, "Quantidade", "POSITIVO");
	dataset.setValue(nacional, "Quantidade", "NACIONAL");
	
	
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
    
    
    
    
    
    public void PreencherTabelaComputadorNI(){  
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
    
    public void PreencherTabelaSupNI(){  
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
    
    public void PreencherTabelaEstabNI(){  
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
      public void PreencherTabelaImpressoraNI(){  
       ArrayList<ImpressoraNI> usersList = new ArrayList<ImpressoraNI>();
       model = (DefaultTableModel)jTableimpressorani.getModel();
       String query = "SELECT * FROM  `impressorani` ";
       
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
           ImpressoraNI impressorani;
           while(rs.next())
           {
               impressorani = new ImpressoraNI(rs.getInt("patrimonio"));
	       
               usersList.add(impressorani);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.fireTableRowsDeleted(1, 100);
       ArrayList<ImpressoraNI> list = usersList;
       Object[] row = new Object[9];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getPatrimonio();          
	   
           model.addRow(row);
       }
    }
      
      public void PesquisaAvancada(String text, String tipo){
	   ArrayList<Computador> usersList = new ArrayList<Computador>();
       model = (DefaultTableModel)jTableComputador.getModel();
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
   
      
       
       
   
    
    
    

  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        parentPanel = new javax.swing.JPanel();
        jPanelTabela = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTextField_pesquisa = new javax.swing.JTextField();
        jComboBox_pesquisa = new javax.swing.JComboBox<>();
        jButton20 = new javax.swing.JButton();
        aqui = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableComputador = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jText_patrimonio = new javax.swing.JTextField();
        jText_ip = new javax.swing.JTextField();
        jText_setor = new javax.swing.JTextField();
        jText_usuario = new javax.swing.JTextField();
        jText_marca = new javax.swing.JTextField();
        jText_sisope = new javax.swing.JTextField();
        jText_supcpu = new javax.swing.JTextField();
        jText_estab = new javax.swing.JTextField();
        jText_impressora = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanelNI = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablecpuni = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablesupni = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableestabni = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableimpressorani = new javax.swing.JTable();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jText_cpu_ni = new javax.swing.JTextField();
        jText_ip_ni = new javax.swing.JTextField();
        jText_setor_ni = new javax.swing.JTextField();
        jText_usuario_ni = new javax.swing.JTextField();
        jText_marca_ni = new javax.swing.JTextField();
        jText_sisope_ni = new javax.swing.JTextField();
        jText_supcpu_ni = new javax.swing.JTextField();
        jText_estab_ni = new javax.swing.JTextField();
        jText_impressora_ni = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 51));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x48-admin.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x48-almacen.png"))); // NOI18N
        jButton2.setToolTipText("INÍCIO");
        jButton2.setPreferredSize(new java.awt.Dimension(127, 41));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x48-compra.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        parentPanel.setBackground(new java.awt.Color(255, 51, 102));
        parentPanel.setLayout(new java.awt.CardLayout());

        jPanelTabela.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabela.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton8.setText("AIN");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setIconTextGap(8);
        jButton8.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton9.setText("REX");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setIconTextGap(8);
        jButton9.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton10.setText("DCSS");
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setIconTextGap(8);
        jButton10.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton11.setText("BIO");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setIconTextGap(8);
        jButton11.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton12.setText("NI");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.setIconTextGap(8);
        jButton12.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton13.setText("PRO");
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.setIconTextGap(8);
        jButton13.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton14.setText("APL");
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton14.setIconTextGap(8);
        jButton14.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton15.setText("DIG");
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton15.setIconTextGap(8);
        jButton15.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 0));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton16.setText("ATR");
        jButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton16.setIconTextGap(8);
        jButton16.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 0, 0));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton17.setText("ACM");
        jButton17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton17.setIconTextGap(8);
        jButton17.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 0, 0));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton18.setText("CM");
        jButton18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton18.setIconTextGap(8);
        jButton18.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 0, 0));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton19.setText("ARQ");
        jButton19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton19.setIconTextGap(8);
        jButton19.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 0, 0));
        jButton21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton21.setText("SCPMSO");
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton21.setIconTextGap(8);
        jButton21.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextField_pesquisa.setName(""); // NOI18N

        jComboBox_pesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPU", "Suporte", "Estabilizador", "Impressora" }));

        jButton20.setBackground(new java.awt.Color(0, 0, 0));
        jButton20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton20.setText("BUSCAR");
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton20.setIconTextGap(8);
        jButton20.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_pesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_pesquisa))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanelTabela.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1280, 100));

        aqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bajar.png"))); // NOI18N
        aqui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aquiMouseReleased(evt);
            }
        });
        jPanelTabela.add(aqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTableComputador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PATRIMONIO", "IP", "SETOR", "USUARIO", "MARCA", "SIS.OPE", "SUP.CPU", "ESTAB.", "IMPRESSORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableComputador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableComputadorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableComputador);
        if (jTableComputador.getColumnModel().getColumnCount() > 0) {
            jTableComputador.getColumnModel().getColumn(1).setResizable(false);
            jTableComputador.getColumnModel().getColumn(2).setResizable(false);
            jTableComputador.getColumnModel().getColumn(3).setResizable(false);
            jTableComputador.getColumnModel().getColumn(4).setResizable(false);
            jTableComputador.getColumnModel().getColumn(5).setResizable(false);
            jTableComputador.getColumnModel().getColumn(6).setResizable(false);
            jTableComputador.getColumnModel().getColumn(7).setResizable(false);
            jTableComputador.getColumnModel().getColumn(8).setResizable(false);
            jTableComputador.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanelTabela.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1260, 430));

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jInternalFrame1.getContentPane().add(jText_patrimonio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));
        jInternalFrame1.getContentPane().add(jText_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));
        jInternalFrame1.getContentPane().add(jText_setor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, -1));
        jInternalFrame1.getContentPane().add(jText_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, -1));
        jInternalFrame1.getContentPane().add(jText_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 140, -1));
        jInternalFrame1.getContentPane().add(jText_sisope, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, -1));
        jInternalFrame1.getContentPane().add(jText_supcpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, -1));
        jInternalFrame1.getContentPane().add(jText_estab, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, -1));
        jInternalFrame1.getContentPane().add(jText_impressora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 140, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contract.png"))); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recycle-bin.png"))); // NOI18N
        jButton4.setText("EXCLUIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 100, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("IMPRESSORA:");
        jInternalFrame1.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PATRIMONIO:");
        jInternalFrame1.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("IP:");
        jInternalFrame1.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("SETOR:");
        jInternalFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("USUÁRIO:");
        jInternalFrame1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("MARCA:");
        jInternalFrame1.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("SIS.OPE:");
        jInternalFrame1.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("SUP.CPU:");
        jInternalFrame1.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ESTAB:");
        jInternalFrame1.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        jPanelTabela.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 264, 420));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jPanelTabela.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 640, 430));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_minasgeraismarca-1.jpg"))); // NOI18N
        jPanelTabela.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 317, 430));

        parentPanel.add(jPanelTabela, "card2");

        jPanelNI.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablecpuni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PATRIMONIO", "MARCA", "SIS.OPE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablecpuni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablecpuniMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTablecpuni);
        if (jTablecpuni.getColumnModel().getColumnCount() > 0) {
            jTablecpuni.getColumnModel().getColumn(0).setResizable(false);
            jTablecpuni.getColumnModel().getColumn(1).setResizable(false);
            jTablecpuni.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanelNI.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 577, 440));

        jTablesupni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "SUPORTES DISPONIVEIS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablesupni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablesupniMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablesupni);
        if (jTablesupni.getColumnModel().getColumnCount() > 0) {
            jTablesupni.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanelNI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 11, 215, 291));

        jTableestabni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "ESTABILIZADORES DISPONIVEIS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableestabni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableestabniMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableestabni);
        if (jTableestabni.getColumnModel().getColumnCount() > 0) {
            jTableestabni.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanelNI.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 11, 215, 291));

        jTableimpressorani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "IMPRESSORAS DISPONIVEIS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableimpressorani.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableimpressoraniMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableimpressorani);
        if (jTableimpressorani.getColumnModel().getColumnCount() > 0) {
            jTableimpressorani.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanelNI.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 11, 215, 291));

        jInternalFrame2.setVisible(true);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jInternalFrame2.getContentPane().add(jText_cpu_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));
        jInternalFrame2.getContentPane().add(jText_ip_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));
        jInternalFrame2.getContentPane().add(jText_setor_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, -1));
        jInternalFrame2.getContentPane().add(jText_usuario_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 140, -1));
        jInternalFrame2.getContentPane().add(jText_marca_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 140, -1));
        jInternalFrame2.getContentPane().add(jText_sisope_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, -1));
        jInternalFrame2.getContentPane().add(jText_supcpu_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, -1));
        jInternalFrame2.getContentPane().add(jText_estab_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, -1));
        jInternalFrame2.getContentPane().add(jText_impressora_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 140, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contract.png"))); // NOI18N
        jButton5.setText("REGISTRAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("IMPRESSORA:");
        jInternalFrame2.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("CPU:");
        jInternalFrame2.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("IP:");
        jInternalFrame2.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("SETOR:");
        jInternalFrame2.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("USUÁRIO:");
        jInternalFrame2.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("MARCA:");
        jInternalFrame2.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("SIS.OPE:");
        jInternalFrame2.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("SUP.CPU:");
        jInternalFrame2.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("ESTAB:");
        jInternalFrame2.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        jPanelNI.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 264, 420));

        parentPanel.add(jPanelNI, "card3");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    
    
    
 /**
* 
* EVENTOS ----------------------------------------------------------------------- 
* 
*/   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	parentPanel.removeAll();
	parentPanel.add(jPanelNI);
	parentPanel.repaint();
	parentPanel.revalidate();
	PreencherTabelaComputadorNI();
	PreencherTabelaSupNI();
	PreencherTabelaEstabNI();
	PreencherTabelaImpressoraNI();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableComputadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableComputadorMouseClicked
	if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableComputador.getSelectedRow();
	    model = (DefaultTableModel) jTableComputador.getModel();
	    idSelecionado = (Integer) (model.getValueAt(index,0));
	    String patrimonio = (model.getValueAt(index,1).toString());
	    patrimonioBtnEditar = (model.getValueAt(index, 1).toString());
	    String ip = (model.getValueAt(index,2).toString());
	    String setor = (model.getValueAt(index,3).toString());
	    String usuario = (model.getValueAt(index,4).toString());
	    String marca = (model.getValueAt(index,5).toString());	 
	    String sisope = (model.getValueAt(index,6).toString());
	    String supcpu = (model.getValueAt(index,7).toString());
	    supcpuBtnEditar = (model.getValueAt(index,7).toString());
	    String estab = (model.getValueAt(index,8).toString());
	    estabBtnEditar = (model.getValueAt(index,8).toString());
	    String impressora = (model.getValueAt(index,9).toString());
	    impressoraBtnEditar = (model.getValueAt(index,9).toString());
	    
	    jText_patrimonio.setText(patrimonio);
	    jText_ip.setText(ip);
	    jText_setor.setText(setor);
	    jText_usuario.setText(usuario);
	    jText_marca.setText(marca);
	    jText_sisope.setText(sisope);
	    jText_supcpu.setText(supcpu);
	    jText_estab.setText(estab);
	    jText_impressora.setText(impressora);
        }
    }//GEN-LAST:event_jTableComputadorMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        PesquisarPeloSetor("'REX'");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        PesquisarPeloSetor("'AIN'");
	Animacion.subir(0,-100,1,jPanel2);
	Animacion.subir(85,0,1,aqui);
	Animacion.subir(95,0,1,jScrollPane2);
	     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        PesquisarPeloSetor("'DCSS'");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        PesquisarPeloSetor("'BIO'");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        PesquisarPeloSetor("'NI'");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PesquisarPeloSetor("'PRO'");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
	    try{
		String query = "update cpu set patrimonio = ?, ip = ?, setor = ?, usuario = ?,"
		    + " marca = ?, so = ?, supcpu = ?, estab = ?, impressora = ? where id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setString(1, jText_patrimonio.getText());
		preparedStmt.setString(2, jText_ip.getText());
		preparedStmt.setString(3, jText_setor.getText());
		preparedStmt.setString(4, jText_usuario.getText());
		preparedStmt.setString(5, jText_marca.getText());
		preparedStmt.setString(6, jText_sisope.getText());
		preparedStmt.setString(7, jText_supcpu.getText());
		preparedStmt.setString(8, jText_estab.getText());
		preparedStmt.setString(9, jText_impressora.getText());
		preparedStmt.setInt(10, idSelecionado);

		preparedStmt.executeUpdate();	
		
		PreencherTabelaComputador();
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    
	    if(!patrimonioBtnEditar.equals(jText_patrimonio.getText())){
		    Object opcoes[] = {"Mover para NI - 316", "Mover para 304", "Exclui-lo"}; //0 1 2
		    int selection = JOptionPane.showOptionDialog(
		    null, "O que deseja fazer com o CPU "+patrimonioBtnEditar+" ?", "",
		    0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		    patrimonioBtnEditar = jText_patrimonio.getText();
	    }
	     if(!supcpuBtnEditar.equals(jText_supcpu.getText())){
		    Object opcoes[] = {"Mover para NI - 316", "Mover para 304", "Exclui-lo"}; //0 1 2
		    int selection = JOptionPane.showOptionDialog(
		    null, "O que deseja fazer com o SUPORTE CPU "+supcpuBtnEditar+" ?", "",
		    0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		    supcpuBtnEditar = jText_supcpu.getText();
	    }
	      if(!estabBtnEditar.equals(jText_estab.getText())){
		    Object opcoes[] = {"Mover para NI - 316", "Mover para 304", "Exclui-lo"}; //0 1 2
		    int selection = JOptionPane.showOptionDialog(
		    null, "O que deseja fazer com o ESTABILIZADOR "+estabBtnEditar+" ?", "",
		    0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		    estabBtnEditar = jText_estab.getText();
	    }
	       if(!impressoraBtnEditar.equals(jText_impressora.getText())){
		    Object opcoes[] = {"Mover para NI - 316", "Mover para 304", "Exclui-la"}; //0 1 2
		    int selection = JOptionPane.showOptionDialog(
		    null, "O que deseja fazer com a IMPRESSORA "+impressoraBtnEditar+" ?", "",
		    0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		    impressoraBtnEditar = jText_impressora.getText();
	    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void aquiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aquiMouseReleased
	int position = aqui.getY();
	if(position > 0){
	    Animacion.subir(0,-100,1,jPanel2);
	    Animacion.subir(85,0,1,aqui);
	    Animacion.subir(95,0,1,jScrollPane2);
	}else{
	    Animacion.bajar(-110,0,1,jPanel2);
	    Animacion.bajar(0,100,1,aqui);
	    Animacion.bajar(0,95,1,jScrollPane2);
	}
    }//GEN-LAST:event_aquiMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        parentPanel.removeAll();
        parentPanel.add(jPanelTabela);
        parentPanel.repaint();
        parentPanel.revalidate();
        PreencherTabelaComputador();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Object opcoes[] = {"Sim", "Não"}; //0 1
	int selection = JOptionPane.showOptionDialog(
	    null, "Deseja excluir todos os dados referentes ao CPU "+jText_patrimonio.getText()+" ?", "",
	    0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
	);
	switch(selection){
	    case 0:
		String ps = "-";
		try{
		String query = "update cpu set patrimonio = ?, ip = ?, setor = ?, usuario = ?,"
		    + " marca = ?, so = ?, supcpu = ?, estab = ?, impressora = ? where id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, jText_ip.getText());
		preparedStmt.setString(3, ps);
		preparedStmt.setString(4, ps);
		preparedStmt.setString(5, ps);
		preparedStmt.setString(6, ps);
		preparedStmt.setString(7, ps);
		preparedStmt.setString(8, ps);
		preparedStmt.setString(9, ps);
		preparedStmt.setInt(10, idSelecionado);

		preparedStmt.executeUpdate();	
		
		PreencherTabelaComputador();
	    }catch(Exception e){
		e.printStackTrace();
	    }
	    break;    
	}
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String pesquisa = jTextField_pesquisa.getText();
	String tipo = jComboBox_pesquisa.getSelectedItem().toString();
	if(tipo.equals("CPU")){
	    tipo = "patrimonio";
	}else if(tipo.equals("Suporte")){
	    tipo = "supcpu";
	}else if(tipo.equals("Estabilizador")){
	    tipo = "estab";
	}else if(tipo.equals("Impressora")){
	    tipo = "impressora";
	}
	PesquisaAvancada(pesquisa, tipo);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTablecpuniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecpuniMouseClicked
	if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTablecpuni.getSelectedRow();
	    model = (DefaultTableModel) jTablecpuni.getModel();	 
	    jText_cpu_ni.setText(model.getValueAt(index, 0).toString());
	    jText_marca_ni.setText(model.getValueAt(index, 1).toString());
	    jText_sisope_ni.setText(model.getValueAt(index, 2).toString());
        }
    }//GEN-LAST:event_jTablecpuniMouseClicked

    private void jTablesupniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablesupniMouseClicked
	if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTablesupni.getSelectedRow();
	    model = (DefaultTableModel) jTablesupni.getModel();	 
	    jText_supcpu_ni.setText(model.getValueAt(index, 0).toString());	  
        }
    }//GEN-LAST:event_jTablesupniMouseClicked

    private void jTableestabniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableestabniMouseClicked
	if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableestabni.getSelectedRow();
	    model = (DefaultTableModel) jTableestabni.getModel();	 
	    jText_estab_ni.setText(model.getValueAt(index, 0).toString());	  
        }
    }//GEN-LAST:event_jTableestabniMouseClicked

    private void jTableimpressoraniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableimpressoraniMouseClicked
	if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableimpressorani.getSelectedRow();
	    model = (DefaultTableModel) jTableimpressorani.getModel();	 
	    jText_impressora_ni.setText(model.getValueAt(index, 0).toString());	  
        }
    }//GEN-LAST:event_jTableimpressoraniMouseClicked

/**
* 
* FIM EVENTOS ----------------------------------------------------------------------
* 
*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new MainFrame().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aqui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox_pesquisa;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelNI;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableComputador;
    private javax.swing.JTable jTablecpuni;
    private javax.swing.JTable jTableestabni;
    private javax.swing.JTable jTableimpressorani;
    private javax.swing.JTable jTablesupni;
    private javax.swing.JTextField jTextField_pesquisa;
    private javax.swing.JTextField jText_cpu_ni;
    private javax.swing.JTextField jText_estab;
    private javax.swing.JTextField jText_estab_ni;
    private javax.swing.JTextField jText_impressora;
    private javax.swing.JTextField jText_impressora_ni;
    private javax.swing.JTextField jText_ip;
    private javax.swing.JTextField jText_ip_ni;
    private javax.swing.JTextField jText_marca;
    private javax.swing.JTextField jText_marca_ni;
    private javax.swing.JTextField jText_patrimonio;
    private javax.swing.JTextField jText_setor;
    private javax.swing.JTextField jText_setor_ni;
    private javax.swing.JTextField jText_sisope;
    private javax.swing.JTextField jText_sisope_ni;
    private javax.swing.JTextField jText_supcpu;
    private javax.swing.JTextField jText_supcpu_ni;
    private javax.swing.JTextField jText_usuario;
    private javax.swing.JTextField jText_usuario_ni;
    private javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
