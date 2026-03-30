package pousadaapp;

import br.com.senacead.pousadaappjpa.gui.DadosHospede;

import br.com.senacead.pousadaappjpa.dao.CaixaDAO;
import br.com.senacead.pousadaappjpa.persistencia.Gastos;
import br.com.senacead.pousadaappjpa.dao.GastosDAO;
import br.com.senacead.pousadaappjpa.persistencia.Hospede;
import br.com.senacead.pousadaappjpa.dao.HospedeDAO;
import br.com.senacead.pousadaappjpa.estrutura.Relatorio;
import br.com.senacead.pousadaappjpa.service.FuncService;
import java.awt.Component;

import java.awt.event.KeyEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TelaInicio extends javax.swing.JFrame {

    //Inicialização da classe FunService que chama os DAOs
    FuncService func = new FuncService();
    
    double valorDiaria;

    // Atributo para pegar data atual Formatada
    private final String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

   
    //Método para ajustar largura da tabela de acordo com o maior conteúdo
    public void ajustarLarguraPorConteudo(JTable tabela) {
        TableColumnModel modeloColuna = tabela.getColumnModel();

        for (int col = 0; col < tabela.getColumnCount(); col++) {
            int larguraMaxima = 0;

            for (int row = 0; row < tabela.getRowCount(); row++) {
                TableCellRenderer renderer = tabela.getCellRenderer(row, col);
                Component comp = tabela.prepareRenderer(renderer, row, col);
                larguraMaxima = Math.max(comp.getPreferredSize().width, larguraMaxima);
            }

            TableColumn coluna = modeloColuna.getColumn(col);
            coluna.setPreferredWidth(larguraMaxima + 10); // margem extra
        }
    }

//Método para deixar a Tela Fullscreen
    public void setFullscreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela
        setUndecorated(true); // Remove barra de título e bordas
        setVisible(true); // Torna visível
    }

//Método para atualizar o PainelCaixa
    public void atualizarPainelCaixa() {
        CaixaDAO caixadao = new CaixaDAO();

        double entradas = caixadao.somarEntradas();
        double gastos = caixadao.somarGastos();
        double saldo = entradas - gastos;

        lblEntradas.setText(String.format("%.2f", entradas));
        lblGastos.setText(String.format("%.2f", gastos));
        lblSaldo.setText(String.format("%.2f", saldo));
    }

    public void acessibilidade() {
        btnBusca.setMnemonic(KeyEvent.VK_B);

        btnCdastro.setMnemonic(KeyEvent.VK_H);
        btnSalvarHospede.setMnemonic(KeyEvent.VK_S);
        btnCaixa.setMnemonic(KeyEvent.VK_C);
        btnGastos.setMnemonic(KeyEvent.VK_G);
        btnSalvaGasto.setMnemonic(KeyEvent.VK_O);
        btnSairGastos.setMnemonic(KeyEvent.VK_S);
        btnVoltar.setMnemonic(KeyEvent.VK_V);
        btnSairCaixa.setMnemonic(KeyEvent.VK_E);
        btnSairCadastro.setMnemonic(KeyEvent.VK_0);
    }

    //Configuração Da Tabela de Hospedes
    public void atualizarTabelaHospede(List<Hospede> hospedes) {
        String colunas[] = {"ID", "Nome", "CPF", "Idade", "Contato", "Diarias", "Quarto", "Saldo"};
        String dados[][] = new String[hospedes.size()][colunas.length];

        int i = 0;
        for (Hospede h : hospedes) {
            dados[i] = new String[]{
                String.valueOf(h.getId()),
                h.getNome(),
                h.getCpf(),
                String.valueOf(h.getIdade()),
                h.getContato(),
                Integer.toString(h.getNumeroDeDias()),
                h.getIdentificacaoQuarto(),
                String.format("%.2f", h.getSaldo())
            };
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tbllistaHospede.setModel(model);
        ajustarLarguraPorConteudo(tbllistaHospede);
    }

    //Configuração Da Tabela de Gastos
    public void carregarTabelaGastos(List<Gastos> gastos) {
        String colunas[] = {"ID", "Data", "Descrição", "Valor Gasto"};
        String dados[][] = new String[gastos.size()][colunas.length];

        int i = 0;
        for (Gastos g : gastos) {
            dados[i] = new String[]{
                String.valueOf(g.getId()),
                g.getData(),
                g.getDescricao(),
                Double.toString(g.getValor())
            };
            i++;
        }

        DefaultTableModel tablegasto = new DefaultTableModel(dados, colunas);
        tblGasto.setModel(tablegasto);
        ajustarLarguraPorConteudo(tblGasto);
    }

    public TelaInicio() {
        this.setFullscreen();
        initComponents();

        acessibilidade();
        btnAtualizaTabela.setVisible(false);
        btnConfirma.setVisible(false);
        txtBusca.setVisible(false);
        btnOk.setVisible(false);
        ScpGastos.setVisible(false);
        ScpHospedes.setVisible(false);
        PainelGastos.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        txtEntraExclusao.setVisible(false);
        btnOkExclui.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Painelfundo = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        txtEntraExclusao = new javax.swing.JTextField();
        btnOkExclui = new javax.swing.JButton();
        ScpHospedes = new javax.swing.JScrollPane();
        tbllistaHospede = new javax.swing.JTable();
        ScpGastos = new javax.swing.JScrollPane();
        tblGasto = new javax.swing.JTable();
        btnConfirma = new javax.swing.JButton();
        btnAtualizaTabela = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();
        PainelMenu = new javax.swing.JPanel();
        PainelBotoes = new javax.swing.JPanel();
        btnCdastro = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        PainelCaixa = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblEntradas = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnSairCaixa = new javax.swing.JButton();
        btnRelatorioCompleto = new javax.swing.JButton();
        btnRelatorioResumido = new javax.swing.JButton();
        PainelCadastro = new javax.swing.JPanel();
        btnSalvarHospede = new javax.swing.JButton();
        lblNovoHospede = new javax.swing.JLabel();
        txtNovoHospede = new javax.swing.JTextField();
        lblCpfHospede = new javax.swing.JLabel();
        txtCpfHospede = new javax.swing.JTextField();
        txtContatoHospede = new javax.swing.JTextField();
        lblContatoHospede = new javax.swing.JLabel();
        lblNumeroDiarias = new javax.swing.JLabel();
        txtNumeroDiarias = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblIdadeHospede = new javax.swing.JLabel();
        txtIdadeHospede = new javax.swing.JTextField();
        btnSairCadastro = new javax.swing.JButton();
        cbxQuarto = new javax.swing.JComboBox<>();
        btnExcluirHospede = new javax.swing.JButton();
        PainelGastos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescGastos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorGastos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSairGastos = new javax.swing.JButton();
        btnSalvaGasto = new javax.swing.JButton();
        btnExcluirGasto = new javax.swing.JButton();
        txtDataGasto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        PainelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pousada da Dulci");
        jLabel1.setAlignmentY(0.0F);
        PainelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1502, 156));

        getContentPane().add(PainelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2840, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3264, 168, 1006, -1));

        Painelfundo.setPreferredSize(new java.awt.Dimension(1068, 719));
        Painelfundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBusca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        Painelfundo.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, 30));

        btnOk.setBackground(new java.awt.Color(0, 102, 153));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("OK");
        btnOk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        Painelfundo.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 30));

        txtEntraExclusao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Painelfundo.add(txtEntraExclusao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, 30));

        btnOkExclui.setBackground(new java.awt.Color(0, 102, 153));
        btnOkExclui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOkExclui.setForeground(new java.awt.Color(255, 255, 255));
        btnOkExclui.setText("OK");
        btnOkExclui.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOkExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkExcluiActionPerformed(evt);
            }
        });
        Painelfundo.add(btnOkExclui, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 30));

        ScpHospedes.setAutoscrolls(true);
        ScpHospedes.setEnabled(false);

        tbllistaHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tbllistaHospede.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Idade", "Contato", "Diarias", "Quarto", "Saldo"
            }
        ));
        ScpHospedes.setViewportView(tbllistaHospede);

        Painelfundo.add(ScpHospedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 700, 310));

        ScpGastos.setAutoscrolls(true);
        ScpGastos.setEnabled(false);

        tblGasto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tblGasto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Descrição", "Valor Gasto"
            }
        ));
        ScpGastos.setViewportView(tblGasto);

        Painelfundo.add(ScpGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 172, -1, 310));

        btnConfirma.setBackground(new java.awt.Color(0, 102, 153));
        btnConfirma.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirma.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirma.setText("CONFIRMA");
        btnConfirma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });
        Painelfundo.add(btnConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 110, 30));

        btnAtualizaTabela.setBackground(new java.awt.Color(0, 102, 153));
        btnAtualizaTabela.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualizaTabela.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizaTabela.setText("ATUALIZAR");
        btnAtualizaTabela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtualizaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaTabelaActionPerformed(evt);
            }
        });
        Painelfundo.add(btnAtualizaTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 110, 30));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pousada3.png"))); // NOI18N
        lblFundo.setMaximumSize(new java.awt.Dimension(961, 654));
        lblFundo.setMinimumSize(new java.awt.Dimension(961, 654));
        Painelfundo.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 940, 660));

        getContentPane().add(Painelfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 170, 950, 654));

        PainelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PainelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCdastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCdastro.setForeground(new java.awt.Color(0, 102, 153));
        btnCdastro.setText("Hospedes");
        btnCdastro.setToolTipText("Alt+N");
        btnCdastro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnCdastro.setPreferredSize(new java.awt.Dimension(80, 40));
        btnCdastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdastroActionPerformed(evt);
            }
        });

        btnGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGastos.setForeground(new java.awt.Color(0, 102, 153));
        btnGastos.setText("Gastos");
        btnGastos.setToolTipText("Alt+G");
        btnGastos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnGastos.setPreferredSize(new java.awt.Dimension(80, 40));
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });

        btnCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCaixa.setForeground(new java.awt.Color(0, 102, 153));
        btnCaixa.setText("Caixa");
        btnCaixa.setToolTipText("Alt+C");
        btnCaixa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnCaixa.setPreferredSize(new java.awt.Dimension(80, 40));
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(0, 102, 153));
        btnVoltar.setText("Voltar");
        btnVoltar.setToolTipText("Alt+V");
        btnVoltar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnVoltar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnBusca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBusca.setForeground(new java.awt.Color(0, 102, 153));
        btnBusca.setText("Busca");
        btnBusca.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelBotoesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnCdastro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelBotoesLayout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCdastro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PainelMenu.add(PainelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 540, 550, 110));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblData.setForeground(new java.awt.Color(0, 102, 153));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Caixa");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Saldo");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Gastos");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Entradas");

        lblEntradas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblGastos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnSairCaixa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairCaixa.setForeground(new java.awt.Color(0, 102, 153));
        btnSairCaixa.setText("Sair");
        btnSairCaixa.setToolTipText("Alt+E");
        btnSairCaixa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSairCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCaixaActionPerformed(evt);
            }
        });

        btnRelatorioCompleto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRelatorioCompleto.setForeground(new java.awt.Color(0, 102, 153));
        btnRelatorioCompleto.setText("Relatório Completo");
        btnRelatorioCompleto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnRelatorioCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioCompletoActionPerformed(evt);
            }
        });

        btnRelatorioResumido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRelatorioResumido.setForeground(new java.awt.Color(0, 102, 153));
        btnRelatorioResumido.setText("Relstório Resumido");
        btnRelatorioResumido.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnRelatorioResumido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioResumidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCaixaLayout = new javax.swing.GroupLayout(PainelCaixa);
        PainelCaixa.setLayout(PainelCaixaLayout);
        PainelCaixaLayout.setHorizontalGroup(
            PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(btnRelatorioCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(btnRelatorioResumido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addComponent(btnSairCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelCaixaLayout.setVerticalGroup(
            PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCaixaLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnRelatorioCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorioResumido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSairCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelCaixaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PainelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        PainelMenu.add(PainelCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 215, 550, 170));

        PainelCadastro.setForeground(new java.awt.Color(0, 102, 153));

        btnSalvarHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvarHospede.setForeground(new java.awt.Color(0, 102, 153));
        btnSalvarHospede.setText("Salvar");
        btnSalvarHospede.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSalvarHospede.setMaximumSize(new java.awt.Dimension(76, 27));
        btnSalvarHospede.setMinimumSize(new java.awt.Dimension(76, 27));
        btnSalvarHospede.setPreferredSize(new java.awt.Dimension(77, 27));
        btnSalvarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarHospedeActionPerformed(evt);
            }
        });

        lblNovoHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNovoHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblNovoHospede.setText("Nome:");

        txtNovoHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblCpfHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCpfHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblCpfHospede.setText("CPF");

        txtCpfHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtCpfHospede.setToolTipText("Entre com o CPF: 999.999.999-99");
        txtCpfHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfHospedeActionPerformed(evt);
            }
        });

        txtContatoHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtContatoHospede.setToolTipText("Insira o Telefone 99-999999999");
        txtContatoHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContatoHospedeActionPerformed(evt);
            }
        });

        lblContatoHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblContatoHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblContatoHospede.setText("Contato");

        lblNumeroDiarias.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNumeroDiarias.setForeground(new java.awt.Color(0, 102, 153));
        lblNumeroDiarias.setText("Numero de Diarias");

        txtNumeroDiarias.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNumeroDiarias.setToolTipText("Insira o Numero de Diarias 99");
        txtNumeroDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDiariasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Cadastro de Hospedes");

        lblIdadeHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblIdadeHospede.setForeground(new java.awt.Color(0, 102, 153));
        lblIdadeHospede.setText("Idade");

        txtIdadeHospede.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtIdadeHospede.setToolTipText("Insira a Idade: 99");

        btnSairCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairCadastro.setForeground(new java.awt.Color(0, 102, 153));
        btnSairCadastro.setText("Sair");
        btnSairCadastro.setToolTipText("Alt+0");
        btnSairCadastro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSairCadastro.setMaximumSize(new java.awt.Dimension(76, 27));
        btnSairCadastro.setMinimumSize(new java.awt.Dimension(76, 27));
        btnSairCadastro.setPreferredSize(new java.awt.Dimension(77, 27));
        btnSairCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroActionPerformed(evt);
            }
        });

        cbxQuarto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbxQuarto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quarto 1 ", "Quarto 2", "Quarto 3", "Quarto 4", "Quarto 5" }));

        btnExcluirHospede.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirHospede.setForeground(new java.awt.Color(0, 102, 153));
        btnExcluirHospede.setText("Excluir");
        btnExcluirHospede.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnExcluirHospede.setPreferredSize(new java.awt.Dimension(77, 27));
        btnExcluirHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirHospedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCadastroLayout = new javax.swing.GroupLayout(PainelCadastro);
        PainelCadastro.setLayout(PainelCadastroLayout);
        PainelCadastroLayout.setHorizontalGroup(
            PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblNovoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(txtNovoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblCpfHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(txtCpfHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIdadeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(txtIdadeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(cbxQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblContatoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(txtContatoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblNumeroDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtNumeroDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSalvarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnExcluirHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelCadastroLayout.setVerticalGroup(
            PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastroLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNovoHospede)
                    .addComponent(txtNovoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCpfHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdadeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdadeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContatoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContatoHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelCadastroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PainelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        PainelMenu.add(PainelCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 550, 211));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Novo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Descrição");

        txtDescGastos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Valor");

        txtValorGastos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Gastos");

        btnSairGastos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSairGastos.setForeground(new java.awt.Color(0, 102, 153));
        btnSairGastos.setText("Sair");
        btnSairGastos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSairGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairGastosActionPerformed(evt);
            }
        });

        btnSalvaGasto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvaGasto.setForeground(new java.awt.Color(0, 102, 153));
        btnSalvaGasto.setText("Salvar");
        btnSalvaGasto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSalvaGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaGastoActionPerformed(evt);
            }
        });

        btnExcluirGasto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirGasto.setForeground(new java.awt.Color(0, 102, 153));
        btnExcluirGasto.setText("Excluir");
        btnExcluirGasto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnExcluirGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirGastoActionPerformed(evt);
            }
        });

        txtDataGasto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("Data");

        javax.swing.GroupLayout PainelGastosLayout = new javax.swing.GroupLayout(PainelGastos);
        PainelGastos.setLayout(PainelGastosLayout);
        PainelGastosLayout.setHorizontalGroup(
            PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel7))
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel5)
                .addGap(139, 139, 139)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtDataGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnSalvaGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnExcluirGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnSairGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PainelGastosLayout.setVerticalGroup(
            PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGastosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDataGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(PainelGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvaGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PainelMenu.add(PainelGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 380, 550, 150));

        getContentPane().add(PainelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 170, 576, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaGastoActionPerformed
        Gastos gasto = new Gastos();

        // Validação dos campos obrigatórios
        if (txtDescGastos.getText().isEmpty() || txtValorGastos.getText().isEmpty() || txtDataGasto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os Campos devem Ser Preenchidos");
            return;
        }

        gasto.setDescricao(txtDescGastos.getText());

        String indata = txtDataGasto.getText();
        boolean validaData = indata.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");

        if (!validaData) {
            JOptionPane.showMessageDialog(null, "Informe uma data Válida:\n Ex.: DD/MM/AAAA");
            return;
        }

        gasto.setData(indata);

        try {
            double valor = Double.parseDouble(txtValorGastos.getText());
            gasto.setValor(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico válido para o gasto.");
            return;
        }

        try {
           
            boolean gastocadastrado = func.cadastrarGasto(gasto);

            if (gastocadastrado) {
                JOptionPane.showMessageDialog(null, "Gasto salvo com sucesso:\n"
                        + gasto.getData() + " - " + gasto.getDescricao() + " - R$ " + gasto.getValor());

                txtDataGasto.setText("");
                txtDescGastos.setText("");
                txtValorGastos.setText("");
                //Atualiza a Tabela Gastos 
                List<Gastos> listaGastos = func.listarGastos();
                carregarTabelaGastos(listaGastos);

                atualizarPainelCaixa();

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar gasto.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar gasto: " + ex.getMessage());
            ex.printStackTrace();
        }


    }//GEN-LAST:event_btnSalvaGastoActionPerformed

    private void btnSairGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairGastosActionPerformed

        ScpGastos.setVisible(false);
        tblGasto.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);

    }//GEN-LAST:event_btnSairGastosActionPerformed

    private void btnSairCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroActionPerformed

        btnAtualizaTabela.setVisible(false);
        btnConfirma.setVisible(false);
        txtBusca.setVisible(false);
        btnOk.setVisible(false);
        ScpHospedes.setVisible(false);
        tbllistaHospede.setVisible(false);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
    }//GEN-LAST:event_btnSairCadastroActionPerformed

    private void txtNumeroDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDiariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDiariasActionPerformed

    private void txtContatoHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContatoHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContatoHospedeActionPerformed

    private void txtCpfHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfHospedeActionPerformed

    private void btnSalvarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarHospedeActionPerformed
        Hospede hospede = new Hospede();

// Validação dos campos obrigatórios
        if (txtNovoHospede.getText().isEmpty() || txtCpfHospede.getText().isEmpty() || txtContatoHospede.getText().isEmpty()
                || txtIdadeHospede.getText().isEmpty() || txtNumeroDiarias.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
            return;
        }

        hospede.setNome(txtNovoHospede.getText());

// Validação do CPF
        String incpf = txtCpfHospede.getText();
        if (!incpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Informe um CPF válido:\nEx.: 999.999.999-99");
            return;
        }
        hospede.setCpf(incpf);

// Validação da idade
        String inIdade = txtIdadeHospede.getText();
        if (!inIdade.matches("\\d{1,3}")) {
            JOptionPane.showMessageDialog(null, "Informe uma idade válida:\nEx.: 18");
            return;
        }
        hospede.setIdade(Integer.parseInt(inIdade));

// Validação do número de diárias
        String inNumeroDiarias = txtNumeroDiarias.getText();
        if (!inNumeroDiarias.matches("\\d{1,3}")) {
            JOptionPane.showMessageDialog(null, "Informe um número de diárias válido:\nEx.: 5");
            return;
        }
        hospede.setNumeroDeDias(Integer.parseInt(inNumeroDiarias));

// Validação do contato
        String inContato = txtContatoHospede.getText();
        if (!inContato.matches("\\d{2}-\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Informe um contato válido:\nEx.: 99-999999999");
            return;
        }
        hospede.setContato(inContato);

// Quarto e valor da diária
        hospede.setIdentificacaoQuarto(cbxQuarto.getSelectedItem().toString());

        try {
            valorDiaria = Double.parseDouble(JOptionPane.showInputDialog(
                    "Hospede " + hospede.getNome() + " acomodado no quarto " + hospede.getIdentificacaoQuarto()
                    + "\nEntre com o valor da diária"));

            hospede.setSaldo(hospede.getNumeroDeDias() * valorDiaria);

            
            func.cadastrarHospede(hospede);

            if (func.cadastrarHospede(hospede)) {
                JOptionPane.showMessageDialog(null,
                        "Hospede " + hospede.getNome() + " acomodado no quarto " + hospede.getIdentificacaoQuarto());

                // Limpa os campos
                txtNovoHospede.setText("");
                txtCpfHospede.setText("");
                txtIdadeHospede.setText("");
                txtContatoHospede.setText("");
                txtNumeroDiarias.setText("");
                txtNovoHospede.requestFocus();

                List<Hospede> lista = func.listarHospedes(null);
                atualizarTabelaHospede(lista);

                atualizarPainelCaixa();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar hóspede.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor da diária inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar hóspede: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarHospedeActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed

        btnAtualizaTabela.setVisible(false);
        btnConfirma.setVisible(false);
        txtEntraExclusao.setVisible(false);
        btnOkExclui.setVisible(false);
        txtBusca.setVisible(false);
        btnOk.setVisible(false);
        PainelCaixa.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelGastos.setVisible(false);
        ScpHospedes.setVisible(false);
        tblGasto.setVisible(false);
        PainelCaixa.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelGastos.setVisible(false);
        ScpGastos.setVisible(false);
        lblData.setText("Data: " + dataAtual);
        atualizarPainelCaixa();
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed

        btnAtualizaTabela.setVisible(false);
        btnConfirma.setVisible(false);
        ScpGastos.setVisible(true);
        tblGasto.setVisible(true);

        GastosDAO gastodao = new GastosDAO();
        List<Gastos> listaGastos = gastodao.listar(null);
        carregarTabelaGastos(listaGastos);

        txtBusca.setVisible(false);
        btnOk.setVisible(false);
        ScpHospedes.setVisible(false);
        PainelGastos.setVisible(true);
        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);


    }//GEN-LAST:event_btnGastosActionPerformed

    private void btnCdastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdastroActionPerformed

        HospedeDAO hospedeDAO = new HospedeDAO();
        List<Hospede> lista = hospedeDAO.listar(null);
        atualizarTabelaHospede(lista);

        btnAtualizaTabela.setVisible(false);
        txtEntraExclusao.setVisible(false);
        btnOkExclui.setVisible(false);
        txtBusca.setVisible(false);
        btnOk.setVisible(false);
        ScpGastos.setVisible(false);
        tblGasto.setVisible(false);
        Painelfundo.setVisible(true);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
        PainelCadastro.setVisible(true);
        ScpHospedes.setVisible(true);
        txtBusca.setVisible(false);
        btnOk.setVisible(false);
    }//GEN-LAST:event_btnCdastroActionPerformed

    private void btnSairCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCaixaActionPerformed

        PainelCadastro.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
        ScpGastos.setVisible(false);
    }//GEN-LAST:event_btnSairCaixaActionPerformed

    private void btnExcluirHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirHospedeActionPerformed
        btnConfirma.setVisible(true);
        JOptionPane.showMessageDialog(null, "selecione um Hospede na Tabela \n e tecle CONFIRMA para Excluir");

        txtNovoHospede.setText("");
        txtCpfHospede.setText("");
        txtIdadeHospede.setText("");
        txtNumeroDiarias.setText("");
        txtContatoHospede.setText("");
        txtNovoHospede.requestFocus();


    }//GEN-LAST:event_btnExcluirHospedeActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

        HospedeDAO hospedeDAO = new HospedeDAO();
        List<Hospede> lista = hospedeDAO.listar(null);
        atualizarTabelaHospede(lista);

        JOptionPane.showMessageDialog(null, "Digite o nome do Hospede\n E clique em OK");

        btnAtualizaTabela.setVisible(true);
        btnConfirma.setVisible(false);

        txtEntraExclusao.setVisible(false);
        btnOkExclui.setVisible(false);
        PainelCaixa.setVisible(false);
        PainelGastos.setVisible(false);
        ScpGastos.setVisible(false);
        tblGasto.setVisible(false);
        ScpHospedes.setVisible(true);
        tbllistaHospede.setVisible(true);
        txtBusca.setVisible(true);
        btnOk.setVisible(true);
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtBusca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira um nome para buscar!");
        } else {
            
            String nome = txtBusca.getText();
            List<Hospede> resultado = func.listarHospedes(nome);
            atualizarTabelaHospede(resultado);

            if (!resultado.isEmpty()) {
                DadosHospede dados = new DadosHospede(resultado.get(0));
                dados.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum hóspede encontrado com esse nome.");
            }
            txtBusca.setText("");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnRelatorioCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioCompletoActionPerformed

        HospedeDAO hospedeDAO = new HospedeDAO();
        CaixaDAO caixaDAO = new CaixaDAO();
        Relatorio relatorio = new Relatorio();
        List<Hospede> listaHospedes = hospedeDAO.listar(""); // busca todos
        double entradas = caixaDAO.somarEntradas();
        double gastos = caixaDAO.somarGastos();
        String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (listaHospedes == null || listaHospedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum hóspede encontrado para gerar o relatório.");
            return;
        }
        relatorio.escrevaRelatorioCompleto(listaHospedes, entradas, gastos, dataHoje);
    }//GEN-LAST:event_btnRelatorioCompletoActionPerformed

    private void btnExcluirGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirGastoActionPerformed

        JOptionPane.showMessageDialog(null, "Digite um ID e tecle OK para Excluir");

        txtEntraExclusao.setVisible(true);
        btnOkExclui.setVisible(true);

        txtNovoHospede.setText("");
        txtCpfHospede.setText("");
        txtIdadeHospede.setText("");
        txtNumeroDiarias.setText("");
        txtContatoHospede.setText("");
        txtNovoHospede.requestFocus();

    }//GEN-LAST:event_btnExcluirGastoActionPerformed

    private void btnOkExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkExcluiActionPerformed

        if (txtEntraExclusao.getText().isEmpty() && tblGasto.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Digite um ID para exclusão.");
            return;
        }

        try {

            if (!txtEntraExclusao.getText().isEmpty()) {
                int id = Integer.parseInt(txtEntraExclusao.getText());
                
                func.excluirGasto(id);
            }

            // Atualiza a tabela e limpa o campo
            List<Gastos> listaGastos = func.listarGastos();
            carregarTabelaGastos(listaGastos);
            txtEntraExclusao.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao excluir gasto: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnOkExcluiActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        int linhaSelecionada = tbllistaHospede.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um hóspede na tabela para excluir.");
            return;
        }

        int idHospede = Integer.parseInt(tbllistaHospede.getValueAt(linhaSelecionada, 0).toString());

        try {
            HospedeDAO dao = new HospedeDAO();
            boolean sucesso = dao.excluirHospedePorId(idHospede);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!");
                //Chama a Tabela Hospede Atualizada

                HospedeDAO hospededao = new HospedeDAO();
                List<Hospede> lista = hospededao.listar(null);
                atualizarTabelaHospede(lista);
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não encontrado ou erro ao excluir.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir hóspede: " + ex.getMessage());
            ex.printStackTrace(); // útil pra debug
        }
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed

        int linhaSelecionada = tbllistaHospede.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um hóspede na tabela para excluir.");
            return;
        }

        int idHospede = Integer.parseInt(tbllistaHospede.getValueAt(linhaSelecionada, 0).toString());

        try {
            
            boolean sucesso = func.excluirHospede(idHospede);

            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!");
                //Chama a Tabela Hospede Atualizada

                HospedeDAO hospededao = new HospedeDAO();
                List<Hospede> lista = hospededao.listar(null);
                atualizarTabelaHospede(lista);
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não encontrado ou erro ao excluir.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir hóspede: " + ex.getMessage());
            ex.printStackTrace(); // útil pra debug
        }

        txtNovoHospede.setText("");
        txtCpfHospede.setText("");
        txtIdadeHospede.setText("");
        txtNumeroDiarias.setText("");
        txtContatoHospede.setText("");
        txtNovoHospede.requestFocus();

    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btnRelatorioResumidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioResumidoActionPerformed
        HospedeDAO hospedeDAO = new HospedeDAO();
        CaixaDAO caixaDAO = new CaixaDAO();
        Relatorio relatorio = new Relatorio();
        List<Hospede> listaHospedes = hospedeDAO.listar(""); // busca todos
        double entradas = caixaDAO.somarEntradas();
        double gastos = caixaDAO.somarGastos();
        String dataHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (listaHospedes == null || listaHospedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum hóspede encontrado para gerar o relatório.");
            return;
        }
        relatorio.escrevaRelatorioResumido(listaHospedes, entradas, gastos, dataHoje);
    }//GEN-LAST:event_btnRelatorioResumidoActionPerformed

    private void btnAtualizaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaTabelaActionPerformed
        HospedeDAO hospedeDAO = new HospedeDAO();
        List<Hospede> lista = hospedeDAO.listar(null);
        atualizarTabelaHospede(lista);
    }//GEN-LAST:event_btnAtualizaTabelaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelCadastro;
    private javax.swing.JPanel PainelCaixa;
    private javax.swing.JPanel PainelGastos;
    private javax.swing.JPanel PainelMenu;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JPanel Painelfundo;
    private javax.swing.JScrollPane ScpGastos;
    private javax.swing.JScrollPane ScpHospedes;
    private javax.swing.JButton btnAtualizaTabela;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnCdastro;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JButton btnExcluirGasto;
    private javax.swing.JButton btnExcluirHospede;
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOkExclui;
    private javax.swing.JButton btnRelatorioCompleto;
    private javax.swing.JButton btnRelatorioResumido;
    private javax.swing.JButton btnSairCadastro;
    private javax.swing.JButton btnSairCaixa;
    private javax.swing.JButton btnSairGastos;
    private javax.swing.JButton btnSalvaGasto;
    private javax.swing.JButton btnSalvarHospede;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblContatoHospede;
    private javax.swing.JLabel lblCpfHospede;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEntradas;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JLabel lblIdadeHospede;
    private javax.swing.JLabel lblNovoHospede;
    private javax.swing.JLabel lblNumeroDiarias;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTable tblGasto;
    private javax.swing.JTable tbllistaHospede;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtContatoHospede;
    private javax.swing.JTextField txtCpfHospede;
    private javax.swing.JTextField txtDataGasto;
    private javax.swing.JTextField txtDescGastos;
    private javax.swing.JTextField txtEntraExclusao;
    private javax.swing.JTextField txtIdadeHospede;
    private javax.swing.JTextField txtNovoHospede;
    private javax.swing.JTextField txtNumeroDiarias;
    private javax.swing.JTextField txtValorGastos;
    // End of variables declaration//GEN-END:variables

}
