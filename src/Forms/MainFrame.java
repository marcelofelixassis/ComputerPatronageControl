package Forms;

import Animacion.Animacion;
import ClassesDeposito.CarregarListDeposito;
import ClassesDeposito.ExcluirDeposito;
import ClassesRegional.CarregarListRegional;
import ClassesRegional.ExcluirRegional;
import Classes_Home.CriarGrafico;
import Classes_Home.Editar;
import Classes_Home.Excluir;
import Classes_Home.PesquisarSetor;
import Classes_Home.PesquisasAvancada;
import Classes_Home.PreencherTabelaHome;
import Classes_NI.EncontrarIpDisponivel;
import Classes_NI.EntradaDeCpu;
import Classes_NI.EntradaDeEstabilizador;
import Classes_NI.EntradaDeImpressora;
import Classes_NI.EntradaDeSuporte;
import Classes_NI.EnviarParaRegional;
import Classes_NI.ExcluirNi;
import Classes_NI.MoverPara340;
import Classes_NI.PreencherTabelaComputadorNI;
import Classes_NI.PreencherTabelaEstabNI;
import Classes_NI.PreencherTabelaImpressoraNI;
import Classes_NI.PreencherTabelaSupNI;
import Classes_NI.RegistrarUsuario.RegistrarUsuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scpmso.patrimonio.informática.ConnectionMySQL;

/**
 *
 * @author Marcelo Félix - marcelofelix.af@gmail.com
 */
public class MainFrame extends javax.swing.JFrame {
    
   public DefaultTableModel model = new DefaultTableModel();
   public int idSelecionado;
   public String patrimonioBtnEditar, supcpuBtnEditar, estabBtnEditar, impressoraBtnEditar;
   public String AuxiliarParaMandarPatrimoniosParaRegionais;
   
   PesquisarSetor pesquisa = new PesquisarSetor();
   CriarGrafico criargrafico = new CriarGrafico();
   PreencherTabelaHome preenchertabelahome = new PreencherTabelaHome();
   PreencherTabelaComputadorNI preenchertabelacomputadorni = new PreencherTabelaComputadorNI();
   PreencherTabelaSupNI preenchertabelasupni = new PreencherTabelaSupNI();
   PreencherTabelaEstabNI preenchertabelaestabni = new PreencherTabelaEstabNI();
   PreencherTabelaImpressoraNI preenchertabelaimpressorani = new PreencherTabelaImpressoraNI();
   EntradaDeCpu entradaDeCpu = new EntradaDeCpu();
   EntradaDeSuporte entradadesuporte = new EntradaDeSuporte();
   EntradaDeEstabilizador entradadeestabilizador = new EntradaDeEstabilizador();
   EntradaDeImpressora entradadeimpressora = new EntradaDeImpressora();
   ExcluirNi excluirni = new ExcluirNi();
   EnviarParaRegional enviarpararegional = new EnviarParaRegional();
   RegistrarUsuario registrar = new RegistrarUsuario();
   CarregarListDeposito deposito = new CarregarListDeposito();
   CarregarListRegional regional = new CarregarListRegional();
   MoverPara340 moverpara340 = new MoverPara340();
   ExcluirDeposito excluir = new ExcluirDeposito();
    ExcluirRegional excluirreg = new ExcluirRegional();
      
   
   ConnectionMySQL mysql = new ConnectionMySQL();
   Connection connection = mysql.Conectar();
   Statement st;
   ResultSet rs;
   
    public MainFrame() {
	initComponents();
	jText_ip.setEnabled(false);jComboBox_pesquisa1.setEnabled(false); jTextArea1.setEnabled(false); jButton29.setEnabled(false); jButton32.setEnabled(false);
	jTableComputador.setDefaultEditor(Object.class, null);
	this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
	
	preenchertabelahome.preenchertabelahome(jTableComputador);
	
	criargrafico.criargrafico(jPanel3);
	
	DefaultTableCellRenderer cor = new DefaultTableCellRenderer() {
            public void setValue(Object value) {
                setForeground(new Color(80,151,204));
                super.setValue(value);
            }
        };
	
	jTableComputador.getColumnModel().getColumn(2).setCellRenderer(cor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
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
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        SetaMenuDeSetores = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jText_cpu_ni1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jText_marca_ni1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jText_sisope_ni1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel23 = new javax.swing.JLabel();
        jText_cpu_ni2 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel24 = new javax.swing.JLabel();
        jText_cpu_ni3 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jLabel25 = new javax.swing.JLabel();
        jText_cpu_ni4 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jText_impressora_ni1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jText_estab_ni1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jText_supcpu_ni1 = new javax.swing.JTextField();
        jText_cpu_ni5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jComboBox_pesquisa1 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanelDeposito = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableDeposito = new javax.swing.JTable();
        jPanelRegionais = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableRegional = new javax.swing.JTable();

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

        jButton22.setBackground(new java.awt.Color(0, 0, 0));
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x48-folder.png"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1048, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jButton26.setBackground(new java.awt.Color(0, 0, 0));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton26.setText("ATP");
        jButton26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton26.setIconTextGap(8);
        jButton26.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 0, 0));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton27.setText("CI");
        jButton27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton27.setIconTextGap(8);
        jButton27.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(0, 0, 0));
        jButton28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton28.setText("aline");
        jButton28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton28.setIconTextGap(8);
        jButton28.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 0, 0));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton30.setText("giani");
        jButton30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton30.setIconTextGap(8);
        jButton30.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 0, 0));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-buscar.png"))); // NOI18N
        jButton31.setText("consult");
        jButton31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton31.setIconTextGap(8);
        jButton31.setMargin(new java.awt.Insets(2, 0, 2, 8));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
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
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelTabela.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1280, 100));

        SetaMenuDeSetores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bajar.png"))); // NOI18N
        SetaMenuDeSetores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SetaMenuDeSetoresMouseReleased(evt);
            }
        });
        jPanelTabela.add(SetaMenuDeSetores, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

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

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-editar_doc.png"))); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, 40));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-basura.png"))); // NOI18N
        jButton4.setText("EXCLUIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 40));

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

        jPanelNI.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 577, 470));

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

        jPanelNI.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 215, 470));

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

        jPanelNI.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 215, 470));

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

        jPanelNI.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 215, 470));

        jInternalFrame2.setTitle("NOVO USUÁRIO");
        jInternalFrame2.setVisible(true);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jInternalFrame2.getContentPane().add(jText_cpu_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));
        jInternalFrame2.getContentPane().add(jText_ip_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));
        jInternalFrame2.getContentPane().add(jText_setor_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, -1));
        jInternalFrame2.getContentPane().add(jText_usuario_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 140, -1));
        jInternalFrame2.getContentPane().add(jText_marca_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 140, -1));
        jInternalFrame2.getContentPane().add(jText_sisope_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 140, -1));
        jInternalFrame2.getContentPane().add(jText_supcpu_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 140, -1));
        jInternalFrame2.getContentPane().add(jText_estab_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 140, -1));
        jInternalFrame2.getContentPane().add(jText_impressora_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 140, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-editar_doc.png"))); // NOI18N
        jButton5.setText("REGISTRAR USUÁRIO");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 205, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("IP:");
        jInternalFrame2.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("SETOR:");
        jInternalFrame2.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("USUÁRIO:");
        jInternalFrame2.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("MARCA:");
        jInternalFrame2.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("SIS.OPE:");
        jInternalFrame2.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("CPU:");
        jInternalFrame2.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("SUP.CPU:");
        jInternalFrame2.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("ESTAB:");
        jInternalFrame2.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("IMPRESSORA:");
        jInternalFrame2.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 255));
        jLabel38.setText(" Encontrar ip disponivel");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jInternalFrame2.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 130, -1));

        jPanelNI.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 264, 390));

        jInternalFrame3.setTitle("ENTRADA DE CPU");
        jInternalFrame3.setVisible(true);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jInternalFrame3.getContentPane().add(jText_cpu_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("CPU:");
        jInternalFrame3.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("MARCA:");
        jInternalFrame3.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));
        jInternalFrame3.getContentPane().add(jText_marca_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("SIS.OPE:");
        jInternalFrame3.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));
        jInternalFrame3.getContentPane().add(jText_sisope_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, -1));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-add.png"))); // NOI18N
        jButton6.setText("ADICIONAR");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanelNI.add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 264, 180));

        jInternalFrame4.setTitle("ENTRADA DE SUPORTE");
        jInternalFrame4.setVisible(true);
        jInternalFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("SUPCPU:");
        jInternalFrame4.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));
        jInternalFrame4.getContentPane().add(jText_cpu_ni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));

        jButton23.setBackground(new java.awt.Color(0, 0, 0));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton23.setForeground(new java.awt.Color(0, 102, 255));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-add.png"))); // NOI18N
        jButton23.setText("ADICIONAR");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jInternalFrame4.getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanelNI.add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 700, 264, 180));

        jInternalFrame5.setTitle("ENTRADA DE ESTABILIZADOR");
        jInternalFrame5.setVisible(true);
        jInternalFrame5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("ESTAB:");
        jInternalFrame5.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));
        jInternalFrame5.getContentPane().add(jText_cpu_ni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));

        jButton24.setBackground(new java.awt.Color(0, 0, 0));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton24.setForeground(new java.awt.Color(0, 102, 255));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-add.png"))); // NOI18N
        jButton24.setText("ADICIONAR");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jInternalFrame5.getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanelNI.add(jInternalFrame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 490, 264, 180));

        jInternalFrame6.setTitle("ENTRADA DE IMPRESSORA");
        jInternalFrame6.setVisible(true);
        jInternalFrame6.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("IMPRESSORA:");
        jInternalFrame6.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));
        jInternalFrame6.getContentPane().add(jText_cpu_ni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, -1));

        jButton25.setBackground(new java.awt.Color(0, 0, 0));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton25.setForeground(new java.awt.Color(0, 102, 255));
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-add.png"))); // NOI18N
        jButton25.setText("ADICIONAR");
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanelNI.add(jInternalFrame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 700, 264, 180));

        jInternalFrame7.setVisible(true);
        jInternalFrame7.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-basura.png"))); // NOI18N
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-compra.png"))); // NOI18N
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-compra.png"))); // NOI18N
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-basura.png"))); // NOI18N
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-basura.png"))); // NOI18N
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-compra.png"))); // NOI18N
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-compra.png"))); // NOI18N
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-basura.png"))); // NOI18N
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));
        jInternalFrame7.getContentPane().add(jText_impressora_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("IMPRESSORA:");
        jInternalFrame7.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 30));
        jInternalFrame7.getContentPane().add(jText_estab_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("ESTAB:");
        jInternalFrame7.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 40, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("SUP.CPU:");
        jInternalFrame7.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, 30));
        jInternalFrame7.getContentPane().add(jText_supcpu_ni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 250, -1));
        jInternalFrame7.getContentPane().add(jText_cpu_ni5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 250, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("CPU:");
        jInternalFrame7.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, 30));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-folder.png"))); // NOI18N
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-folder.png"))); // NOI18N
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-folder.png"))); // NOI18N
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x26-folder.png"))); // NOI18N
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jComboBox_pesquisa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE UMA REGIONAL", "ALMENARA", "ARAÇUAÍ", "BARBACENA", "CARATINGA", "CORONEL FABRICIANO", "CURVELO", "DIAMANTINA", "DIVINÓPOLIS", "GOVERNADOR VALADARES", "ITABIRA", "JANAÚBA", "JUIZ DE FORA", "LAVRAS", "LEOPOLDINA", "MONTES CLAROS", "MURIAÉ", "PARACATU", "PASSOS", "PATOS DE MINAS", "POÇOS DE CALDAS", "POUSO ALEGRE", "SAO JOAO DEL REI", "SETE LAGOAS", "TEÓFILO OTONI", "UBÁ", "UBERABA", "UBERLÂNDIA", "VARGINHA", "VIÇOSA" }));
        jInternalFrame7.getContentPane().add(jComboBox_pesquisa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 370, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane6.setViewportView(jTextArea1);

        jInternalFrame7.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 370, 80));

        jLabel43.setText("Observações:");
        jInternalFrame7.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jButton29.setBackground(new java.awt.Color(0, 0, 0));
        jButton29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton29.setForeground(new java.awt.Color(0, 102, 255));
        jButton29.setText("CONCLUIR");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jButton32.setBackground(new java.awt.Color(0, 0, 0));
        jButton32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton32.setForeground(new java.awt.Color(0, 102, 255));
        jButton32.setText("CANCELAR");
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jInternalFrame7.getContentPane().add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jPanelNI.add(jInternalFrame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 434, 390));

        parentPanel.add(jPanelNI, "card3");

        jPanelDeposito.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDeposito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDeposito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PATRIMONIO", "TIPO", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDepositoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableDeposito);
        if (jTableDeposito.getColumnModel().getColumnCount() > 0) {
            jTableDeposito.getColumnModel().getColumn(0).setResizable(false);
            jTableDeposito.getColumnModel().getColumn(1).setResizable(false);
            jTableDeposito.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanelDeposito.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1260, 870));

        parentPanel.add(jPanelDeposito, "card4");

        jPanelRegionais.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegionais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRegional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PATRIMONIO", "TIPO", "REGIONAL", "DATA", "OBSERVACAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRegionalMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableRegional);
        if (jTableRegional.getColumnModel().getColumnCount() > 0) {
            jTableRegional.getColumnModel().getColumn(0).setResizable(false);
            jTableRegional.getColumnModel().getColumn(1).setResizable(false);
            jTableRegional.getColumnModel().getColumn(2).setResizable(false);
            jTableRegional.getColumnModel().getColumn(3).setResizable(false);
            jTableRegional.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanelRegionais.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1260, 870));

        parentPanel.add(jPanelRegionais, "card5");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**		EVENTOS HOME
     * 
     * @IR PARA SALA NI
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	parentPanel.removeAll();
	parentPanel.add(jPanelNI);
	parentPanel.repaint();
	parentPanel.revalidate();
	preenchertabelacomputadorni.PreencherTabelaComputadorNI(jTablecpuni);
	preenchertabelasupni.PreencherTabelaSupNI(jTablesupni);
	preenchertabelaestabni.PreencherTabelaEstab(jTableestabni);
	preenchertabelaimpressorani.PreencherTabelaImpressoraNI(jTableimpressorani);
    }//GEN-LAST:event_jButton1ActionPerformed
     
    /**
     * 
     * @DUPLO CLICK NA TABELA HOME
     */
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
    
    /**
     * 
     * @PESQUISAS MENU DE SETORES
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'REX'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
	pesquisa.pesquisarsetor(jTableComputador, "'AIN'", jPanel2, jScrollPane2, SetaMenuDeSetores); 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'DCSS'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'BIO'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'NI'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'PRO'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton13ActionPerformed
                                        
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'DIG'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'ATR'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'ACM'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'CM'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'ARQ'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'SCPMSO'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        pesquisa.pesquisarsetor(jTableComputador, "'APL'", jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed
    
    /**
     * 
     * @MENU PRINCIPAL 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        parentPanel.removeAll();
        parentPanel.add(jPanelTabela);
        parentPanel.repaint();
        parentPanel.revalidate();
        preenchertabelahome.preenchertabelahome(jTableComputador);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        parentPanel.removeAll();
	parentPanel.add(jPanelDeposito);
	parentPanel.repaint();
	parentPanel.revalidate();
	deposito.CarregarListDeposito(jTableDeposito);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        parentPanel.removeAll();
	parentPanel.add(jPanelRegionais);
	parentPanel.repaint();
	parentPanel.revalidate();
	regional.CarregarListRegional(jTableRegional);
    }//GEN-LAST:event_jButton22ActionPerformed
    
    /**
     * 
     * @EDITAR DADOS TABELA HOME 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Editar editar = new Editar();
	editar.Edit(jText_patrimonio.getText(), jText_ip.getText(), jText_setor.getText(), 
	    jText_usuario.getText(), jText_marca.getText(), jText_sisope.getText(), 
	    jText_supcpu.getText(), jText_estab.getText(), jText_impressora.getText(), 
	    idSelecionado, patrimonioBtnEditar, supcpuBtnEditar, estabBtnEditar, impressoraBtnEditar);  
	
	preenchertabelahome.preenchertabelahome(jTableComputador);

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
    
    /**
     * 
     * @EXCLUIR DADOS TABELA HOME
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Excluir excluir = new Excluir();
	excluir.exclui(jText_patrimonio.getText(), jText_ip.getText(), idSelecionado);
	preenchertabelahome.preenchertabelahome(jTableComputador);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * 
     * @BUSCA AVANÇADA (CPU, SUP, ESTAB) 
     */
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        PesquisasAvancada ps = new PesquisasAvancada();
	ps.asdf(jTableComputador, jComboBox_pesquisa.getSelectedItem().toString(), jTextField_pesquisa.getText(),
	    jPanel2, jScrollPane2, SetaMenuDeSetores);
    }//GEN-LAST:event_jButton20ActionPerformed
    
    /**
     * 
     * @UP/DOWN MENU DE SETORES (SETINHA) 
     */
    private void SetaMenuDeSetoresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetaMenuDeSetoresMouseReleased
        int position = SetaMenuDeSetores.getY();
	if(position > 0){
	    Animacion.subir(0,-100,1,jPanel2);
	    Animacion.subir(100,0,1,SetaMenuDeSetores);
	    Animacion.subir(95,0,1,jScrollPane2);
	}else{
	    Animacion.bajar(-110,0,1,jPanel2);
	    Animacion.bajar(0,100,1,SetaMenuDeSetores);
	    Animacion.bajar(0,95,1,jScrollPane2);
	}
    }//GEN-LAST:event_SetaMenuDeSetoresMouseReleased

    /**		EVENTOS NI
     * 
     * @DUPLO CLICK NAS TABELAS NI
     */
    private void jTablecpuniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablecpuniMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTablecpuni.getSelectedRow();
	    model = (DefaultTableModel) jTablecpuni.getModel();	 
	    jText_cpu_ni5.setText(model.getValueAt(index, 0).toString());
	    jText_marca_ni.setText(model.getValueAt(index, 1).toString());
	    jText_sisope_ni.setText(model.getValueAt(index, 2).toString());
	    jText_cpu_ni.setText(model.getValueAt(index, 0).toString());
	    jText_supcpu_ni1.setText("");jText_estab_ni1.setText("");jText_impressora_ni1.setText("");
	    
        }
    }//GEN-LAST:event_jTablecpuniMouseClicked

    private void jTablesupniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablesupniMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTablesupni.getSelectedRow();
	    model = (DefaultTableModel) jTablesupni.getModel();	 
	    jText_supcpu_ni1.setText(model.getValueAt(index, 0).toString());
	    jText_supcpu_ni.setText(model.getValueAt(index,0).toString());
	    jText_estab_ni1.setText("");jText_impressora_ni1.setText("");jText_cpu_ni5.setText("");
        }
    }//GEN-LAST:event_jTablesupniMouseClicked

    private void jTableestabniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableestabniMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableestabni.getSelectedRow();
	    model = (DefaultTableModel) jTableestabni.getModel();	 
	    jText_estab_ni1.setText(model.getValueAt(index, 0).toString());
	    jText_estab_ni.setText(model.getValueAt(index, 0).toString());
	    jText_cpu_ni5.setText("");jText_supcpu_ni1.setText("");jText_impressora_ni1.setText("");
        }
    }//GEN-LAST:event_jTableestabniMouseClicked

    private void jTableimpressoraniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableimpressoraniMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableimpressorani.getSelectedRow();
	    model = (DefaultTableModel) jTableimpressorani.getModel();	 
	    jText_impressora_ni1.setText(model.getValueAt(index, 0).toString());
	    jText_impressora_ni.setText(model.getValueAt(index, 0).toString());	
	    jText_cpu_ni5.setText("");jText_supcpu_ni1.setText("");jText_estab_ni1.setText("");
        }
    }//GEN-LAST:event_jTableimpressoraniMouseClicked
    
    /**
     * 
     * @ENTRADA DE CPU, SUPCPU, ESTAB, IMPRESSORA
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
	entradaDeCpu.entradacpu(Integer.parseInt(jText_cpu_ni1.getText()),jText_marca_ni1.getText(),jText_sisope_ni1.getText(), jTablecpuni);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
	entradadesuporte.entradasuporte(Integer.parseInt(jText_cpu_ni2.getText()), jTablesupni);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
       entradadeestabilizador.entradaestabilizador(Integer.parseInt(jText_cpu_ni3.getText()), jTableestabni);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        entradadeimpressora.entradaimpressora(Integer.parseInt(jText_cpu_ni4.getText()), jTableimpressorani);	
    }//GEN-LAST:event_jButton25ActionPerformed
    
    /**
     * 
     * @REGISTRAR NOVO USUÁRIO 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        registrar.registrar(jText_cpu_ni.getText(), jText_ip_ni.getText(), 
	jText_setor_ni.getText(), jText_usuario_ni.getText(), 
	jText_marca_ni.getText(), jText_sisope_ni.getText(), 
	jText_supcpu_ni.getText(), jText_estab_ni.getText(), 
	jText_impressora_ni.getText(),jText_cpu_ni, jText_ip_ni, jText_setor_ni, jText_usuario_ni,
	jText_marca_ni, jText_sisope_ni,jText_supcpu_ni, jText_estab_ni, jText_impressora_ni);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * 
     * @EXCLUIR DAS TABELAS DA NI
     */
    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        excluirni.excluir(jText_cpu_ni5.getText(), "cpuni", jTablecpuni, jTablesupni, jTableestabni, jTableimpressorani, "CPU");
	jText_cpu_ni5.setText(""); jText_cpu_ni.setText(""); jText_marca_ni.setText(""); jText_sisope_ni.setText("");
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        excluirni.excluir(jText_supcpu_ni1.getText(), "supni", jTablecpuni, jTablesupni, jTableestabni, jTableimpressorani, "SUPORTE");
	jText_supcpu_ni1.setText(""); jText_supcpu_ni.setText("");
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        excluirni.excluir(jText_estab_ni1.getText(), "estabni", jTablecpuni, jTablesupni, jTableestabni, jTableimpressorani, "ESTABILIZADOR");
	jText_estab_ni1.setText(""); jText_estab_ni.setText("");
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        excluirni.excluir(jText_impressora_ni1.getText(), "impressorani", jTablecpuni, jTablesupni, jTableestabni, jTableimpressorani, "IMPRESSORA");
	jText_impressora_ni1.setText(""); jText_impressora_ni.setText("");
    }//GEN-LAST:event_jLabel36MouseClicked

    /**
     * 
     * @ENCONTRAR IP DISPONIVEL 
     */
    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        EncontrarIpDisponivel entr = new EncontrarIpDisponivel();
	entr.encontraripdisponivel(jText_ip_ni);
    }//GEN-LAST:event_jLabel38MouseClicked

    /**
     * 
     * @MANDAR PATRIMONIOS PARA AS REGIONAIS ---- HABILITAR CAMPOS DE TEXT E BUTTONS
     */
    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        if(!jText_cpu_ni5.getText().equals("")){
	    AuxiliarParaMandarPatrimoniosParaRegionais = "CPU";
	    jComboBox_pesquisa1.setEnabled(true); jTextArea1.setEnabled(true); jButton29.setEnabled(true); jButton32.setEnabled(true);
	}else{JOptionPane.showMessageDialog(null, "Selecione um patrimonio!");}
    }//GEN-LAST:event_jLabel39MouseClicked

    /**
     * 
     * @MANDAR PATRIMONIOS PARA REGIONAIS -- BUTTON CANCELAR 
     */
    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        jComboBox_pesquisa1.setEnabled(false); jTextArea1.setEnabled(false); jButton29.setEnabled(false); jButton32.setEnabled(false);
	jText_cpu_ni5.setText(""); jText_supcpu_ni1.setText(""); jText_estab_ni1.setText(""); jText_impressora_ni1.setText("");
    }//GEN-LAST:event_jButton32ActionPerformed

    /**
     * 
     * @MANDAR PATRIMONIOS PARA REGIONAIS -- BUTTON CONCLUIR 
     */
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        if(AuxiliarParaMandarPatrimoniosParaRegionais.equals("CPU")){
	    enviarpararegional.enviarpararegionalCPU(Integer.parseInt(jText_cpu_ni5.getText()), jTablecpuni, jComboBox_pesquisa1, jTextArea1, jButton29, jButton32);
	    jText_cpu_ni5.setText("");
	}else if(AuxiliarParaMandarPatrimoniosParaRegionais.equals("SUPORTE")){
	    enviarpararegional.enviarpararegionalSUPORTE(Integer.parseInt(jText_supcpu_ni1.getText()), jTablesupni, jComboBox_pesquisa1, jTextArea1, jButton29, jButton32);
	    jText_supcpu_ni1.setText("");
	}else if(AuxiliarParaMandarPatrimoniosParaRegionais.equals("ESTABILIZADOR")){
	    enviarpararegional.enviarpararegionalESTABILIZADOR(Integer.parseInt(jText_estab_ni1.getText()), jTableestabni, jComboBox_pesquisa1, jTextArea1, jButton29, jButton32);
	    jText_estab_ni1.setText("");
	}else if(AuxiliarParaMandarPatrimoniosParaRegionais.equals("IMPRESSORA")){
	    enviarpararegional.enviarpararegionalIMPRESSORA(Integer.parseInt(jText_impressora_ni1.getText()), jTableimpressorani, jComboBox_pesquisa1, jTextArea1, jButton29, jButton32);
	    jText_impressora_ni1.setText("");
	}
    }//GEN-LAST:event_jButton29ActionPerformed

    /**
     * 
     * @MANDAR PATRIMONIOS PARA AS REGIONAIS ---- HABILITAR CAMPOS DE TEXT E BUTTONS
     */
    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        if(!jText_supcpu_ni1.getText().equals("")){
	    AuxiliarParaMandarPatrimoniosParaRegionais = "SUPORTE";
	    jComboBox_pesquisa1.setEnabled(true); jTextArea1.setEnabled(true); jButton29.setEnabled(true); jButton32.setEnabled(true);
	}else{JOptionPane.showMessageDialog(null, "Selecione um patrimonio!");}
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        if(!jText_estab_ni1.getText().equals("")){
	    AuxiliarParaMandarPatrimoniosParaRegionais = "ESTABILIZADOR";
	    jComboBox_pesquisa1.setEnabled(true); jTextArea1.setEnabled(true); jButton29.setEnabled(true); jButton32.setEnabled(true);
	}else{JOptionPane.showMessageDialog(null, "Selecione um patrimonio!");}
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
         if(!jText_impressora_ni1.getText().equals("")){
	    AuxiliarParaMandarPatrimoniosParaRegionais = "IMPRESSORA";
	    jComboBox_pesquisa1.setEnabled(true); jTextArea1.setEnabled(true); jButton29.setEnabled(true); jButton32.setEnabled(true);
	}else{JOptionPane.showMessageDialog(null, "Selecione um patrimonio!");}
    }//GEN-LAST:event_jLabel42MouseClicked

    /*
    *
    * @ENVIAR PARA O DEPOSITO
    */
    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
	moverpara340.moverpara340cpu(jText_cpu_ni5, jTablecpuni);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        moverpara340.moverpara340supcpu(jText_supcpu_ni1, jTablesupni);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        moverpara340.moverpara340esatb(jText_estab_ni1, jTableestabni);
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        moverpara340.moverpara340impressora(jText_impressora_ni1, jTableimpressorani);
    }//GEN-LAST:event_jLabel37MouseClicked

    /*
    *
    * @EVENTO DE DUPLO CLICK NA TABELA DA 340
    */
    private void jTableDepositoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDepositoMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableDeposito.getSelectedRow();
	    model = (DefaultTableModel) jTableDeposito.getModel();
	    Object opcoes[] = {"Sim", "Não"};
	    int selection = JOptionPane.showOptionDialog(
		null, model.getValueAt(index,0)+" / "+model.getValueAt(index,1)
		    +" / "+model.getValueAt(index,2)+"\nDeseja excluir estes dados ?", "",
		0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
	    );
	    switch(selection){
		case 0:
		    excluir.excluindo((Integer) model.getValueAt(index,0), jTableDeposito);
		break;    
	    }  
	}
    }//GEN-LAST:event_jTableDepositoMouseClicked

    private void jTableRegionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRegionalMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int index = jTableRegional.getSelectedRow();
	    model = (DefaultTableModel) jTableRegional.getModel();
	    Object opcoes[] = {"Sim", "Não"};
	    int selection = JOptionPane.showOptionDialog(
		null, model.getValueAt(index,0)+" / "+model.getValueAt(index,1)
		    +" / "+model.getValueAt(index,2)+" / "+model.getValueAt(index,3)+"\nDeseja excluir estes dados ?", "",
		0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
	    );
	    switch(selection){
		case 0:
		    excluirreg.excluindo((Integer) model.getValueAt(index,0), jTableRegional);
		break;    
	    }  
	}
    }//GEN-LAST:event_jTableRegionalMouseClicked
    
    
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
    private javax.swing.JLabel SetaMenuDeSetores;
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
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox_pesquisa;
    private javax.swing.JComboBox<String> jComboBox_pesquisa1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDeposito;
    private javax.swing.JPanel jPanelNI;
    private javax.swing.JPanel jPanelRegionais;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableComputador;
    private javax.swing.JTable jTableDeposito;
    private javax.swing.JTable jTableRegional;
    private javax.swing.JTable jTablecpuni;
    private javax.swing.JTable jTableestabni;
    private javax.swing.JTable jTableimpressorani;
    private javax.swing.JTable jTablesupni;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField_pesquisa;
    private javax.swing.JTextField jText_cpu_ni;
    private javax.swing.JTextField jText_cpu_ni1;
    private javax.swing.JTextField jText_cpu_ni2;
    private javax.swing.JTextField jText_cpu_ni3;
    private javax.swing.JTextField jText_cpu_ni4;
    private javax.swing.JTextField jText_cpu_ni5;
    private javax.swing.JTextField jText_estab;
    private javax.swing.JTextField jText_estab_ni;
    private javax.swing.JTextField jText_estab_ni1;
    private javax.swing.JTextField jText_impressora;
    private javax.swing.JTextField jText_impressora_ni;
    private javax.swing.JTextField jText_impressora_ni1;
    private javax.swing.JTextField jText_ip;
    private javax.swing.JTextField jText_ip_ni;
    private javax.swing.JTextField jText_marca;
    private javax.swing.JTextField jText_marca_ni;
    private javax.swing.JTextField jText_marca_ni1;
    private javax.swing.JTextField jText_patrimonio;
    private javax.swing.JTextField jText_setor;
    private javax.swing.JTextField jText_setor_ni;
    private javax.swing.JTextField jText_sisope;
    private javax.swing.JTextField jText_sisope_ni;
    private javax.swing.JTextField jText_sisope_ni1;
    private javax.swing.JTextField jText_supcpu;
    private javax.swing.JTextField jText_supcpu_ni;
    private javax.swing.JTextField jText_supcpu_ni1;
    private javax.swing.JTextField jText_usuario;
    private javax.swing.JTextField jText_usuario_ni;
    private javax.swing.JPanel parentPanel;
    // End of variables declaration//GEN-END:variables
}
