package br.com.senacead.pousadaappjpa.gui;


import br.com.senacead.pousadaappjpa.persistencia.Criptografia;
import br.com.senacead.pousadaappjpa.persistencia.Usuario;
import br.com.senacead.pousadaappjpa.persistencia.UsuarioDAO;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import pousadaapp.TelaInicio;
import pousadaapp.TelaInicio2;

/**
 *
 * @author FilipeLuizCouto
 */
public class Login extends javax.swing.JFrame {
    
    public void setFullscreen() {
    setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela
    setUndecorated(true); // Remove barra de título e bordas
    setVisible(true); // Torna visível
}

    public void acessibilidade() {
        btnNovoUsuario.setMnemonic(KeyEvent.VK_N);
        btbSalvarUsuario.setMnemonic(KeyEvent.VK_S);
        btnEntrar.setMnemonic(KeyEvent.VK_E);
        btnLogin.setMnemonic(KeyEvent.VK_L);
        btnSair.setMnemonic(KeyEvent.VK_Q);
    }

    public Login() {
        this.setFullscreen();
        initComponents();
        acessibilidade();
        PainelCadastroUsuario.setVisible(false);
        PainelLogin.setVisible(false);
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelMenu = new javax.swing.JPanel();
        btnNovoUsuario = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PainelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PainelDisplay = new javax.swing.JPanel();
        PainelLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        PainelCadastroUsuario = new javax.swing.JPanel();
        lblNovoUsuario = new javax.swing.JLabel();
        txtNovoUsuario = new javax.swing.JTextField();
        lblnovoLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblNovaSenha = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        lblConfirmaSenha = new javax.swing.JLabel();
        txtConfirmaSenha = new javax.swing.JPasswordField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btbSalvarUsuario = new javax.swing.JButton();
        PainelFundo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PousadaApp1.0");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelMenu.setBackground(new java.awt.Color(153, 153, 255));
        PainelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNovoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoUsuario.setForeground(new java.awt.Color(0, 102, 153));
        btnNovoUsuario.setText("Novo");
        btnNovoUsuario.setToolTipText("Alt+C");
        btnNovoUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnNovoUsuario.setPreferredSize(new java.awt.Dimension(91, 23));
        btnNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuarioActionPerformed(evt);
            }
        });
        PainelMenu.add(btnNovoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 100, 66));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 102, 153));
        btnLogin.setText("Login");
        btnLogin.setToolTipText("Alt+L");
        btnLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        PainelMenu.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 100, 66));

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 102, 153));
        btnSair.setText("Sair");
        btnSair.setToolTipText("Alt+Q");
        btnSair.setAutoscrolls(true);
        btnSair.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 153)));
        btnSair.setPreferredSize(new java.awt.Dimension(91, 23));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        PainelMenu.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 70, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");
        PainelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 126, 45));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUÁRIO");
        PainelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        getContentPane().add(PainelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 280, 660));

        PainelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        PainelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pousada da Dulci");
        jLabel1.setAlignmentY(0.0F);
        PainelTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1502, 156));

        getContentPane().add(PainelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2840, -1));

        PainelDisplay.setBackground(new java.awt.Color(255, 255, 255));
        PainelDisplay.setPreferredSize(new java.awt.Dimension(285, 680));

        lblUsuario.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 102, 153));
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtUsuario.setToolTipText("Entre com o Nome de Usuario");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblSenha.setText("Senha");

        txtSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSenha.setToolTipText("Entre com a Senha do Usuário");

        btnEntrar.setBackground(new java.awt.Color(0, 102, 153));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setToolTipText("Alt+E");
        btnEntrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSenha)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsuario)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelCadastroUsuario.setPreferredSize(new java.awt.Dimension(264, 450));

        lblNovoUsuario.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblNovoUsuario.setForeground(new java.awt.Color(0, 102, 153));
        lblNovoUsuario.setText("Nome de Usuario");

        txtNovoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNovoUsuario.setToolTipText("Digite um Nome para Cadastrar");
        txtNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNovoUsuarioActionPerformed(evt);
            }
        });

        lblnovoLogin.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblnovoLogin.setForeground(new java.awt.Color(0, 102, 153));
        lblnovoLogin.setText("Login");

        txtLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblNovaSenha.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblNovaSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblNovaSenha.setText("Senha:");

        txtNovaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNovaSenha.setToolTipText("Informe uma Senha de 6 Digitos");

        lblConfirmaSenha.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblConfirmaSenha.setForeground(new java.awt.Color(0, 102, 153));
        lblConfirmaSenha.setText("Confirme a Senha");

        txtConfirmaSenha.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtConfirmaSenha.setToolTipText("Repita a Senha");

        lblTipo.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 102, 153));
        lblTipo.setText("Tipo");

        txtTipo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btbSalvarUsuario.setBackground(new java.awt.Color(0, 102, 153));
        btbSalvarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btbSalvarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btbSalvarUsuario.setText("Salvar");
        btbSalvarUsuario.setToolTipText("Alt+S");
        btbSalvarUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btbSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbSalvarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCadastroUsuarioLayout = new javax.swing.GroupLayout(PainelCadastroUsuario);
        PainelCadastroUsuario.setLayout(PainelCadastroUsuarioLayout);
        PainelCadastroUsuarioLayout.setHorizontalGroup(
            PainelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastroUsuarioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PainelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTipo)
                        .addComponent(lblConfirmaSenha)
                        .addComponent(lblNovaSenha)
                        .addComponent(lblnovoLogin)
                        .addComponent(lblNovoUsuario)
                        .addComponent(txtNovoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtLogin)
                        .addComponent(txtNovaSenha)
                        .addComponent(txtConfirmaSenha)
                        .addComponent(txtTipo))
                    .addComponent(btbSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        PainelCadastroUsuarioLayout.setVerticalGroup(
            PainelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(lblNovoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnovoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblConfirmaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btbSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout PainelDisplayLayout = new javax.swing.GroupLayout(PainelDisplay);
        PainelDisplay.setLayout(PainelDisplayLayout);
        PainelDisplayLayout.setHorizontalGroup(
            PainelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PainelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PainelDisplayLayout.setVerticalGroup(
            PainelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDisplayLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PainelCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(PainelDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 290, 660));

        PainelFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\drfil\\OneDrive\\Área de Trabalho\\Filipe\\imgAp\\Trabalho\\Pousada3.png")); // NOI18N
        PainelFundo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 650));

        getContentPane().add(PainelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 950, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuarioActionPerformed

   
        PainelCadastroUsuario.setVisible(true);
        PainelLogin.setVisible(false);


    }//GEN-LAST:event_btnNovoUsuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        PainelLogin.setVisible(true);
        PainelCadastroUsuario.setVisible(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
    String login = txtUsuario.getText();
    String senha =  Criptografia.md5(new String(txtSenha.getPassword()));

    UsuarioDAO dao = new UsuarioDAO();
    Usuario usuarioLogado = dao.buscarPorLoginESenha(login, senha); // retorna o objeto Usuario

    if (usuarioLogado != null) {
        String nome = usuarioLogado.getLogin();
        String tipo = usuarioLogado.getTipo(); // "Administrador", "Operador" ou "Usuario"

        JOptionPane.showMessageDialog(null,
            "Olá " + nome + ", sua permissão é de " + tipo + ". Seja bem-vindo!");

        if(usuarioLogado.getTipo().equalsIgnoreCase("Administrador") || usuarioLogado.getTipo().equalsIgnoreCase("Proprietaria") || usuarioLogado.getTipo().equalsIgnoreCase("Proprietario")){
        
        System.out.println("Usuário retornado: " + (usuarioLogado != null ? usuarioLogado.getLogin() : "null"));
        TelaInicio tela = new TelaInicio();
        tela.setVisible(true);
        txtUsuario.setText("");
        txtSenha.setText("");
        }else{
        System.out.println("Usuário retornado: " + (usuarioLogado != null ? usuarioLogado.getLogin() : "null"));
            TelaInicio2 tela2 = new TelaInicio2();
        tela2.setVisible(true);
        txtUsuario.setText("");
        txtSenha.setText("");
        }
       
    } else {
        JOptionPane.showMessageDialog(null, "Login ou senha inválidos.");
    }
    

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btbSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbSalvarUsuarioActionPerformed
  
        Usuario novoUsuario = new Usuario();
        try {
            
            char[] senha = txtNovaSenha.getPassword();
            char[] confirmaSenha = txtConfirmaSenha.getPassword();

    if (!Arrays.equals(senha, confirmaSenha)) {
        JOptionPane.showMessageDialog(null, "Senha e Confirmação não conferem\nDigite novamente");
        txtNovaSenha.setText("");
        txtConfirmaSenha.setText("");
    } else if (txtNovoUsuario.getText().isEmpty()||txtLogin.getText().isEmpty()||txtTipo.getText().isEmpty() || senha.length == 0 || confirmaSenha.length == 0) {
        JOptionPane.showMessageDialog(null, "Todos os Campos devem ser Preenchidos");
    } else if (senha.length < 6) {
        JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 6 caracteres");
    } else {
            
            novoUsuario.setNome(txtNovoUsuario.getText());
            novoUsuario.setLogin(txtLogin.getText());
            novoUsuario.setSenha(Criptografia.md5(new String (senha)));
            novoUsuario.setTipo(txtTipo.getText());
            
            UsuarioDAO dao = new UsuarioDAO();
            dao.cadastrar(novoUsuario);
    }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Usuario "+ex.getMessage());
        }
    
        txtNovoUsuario.setText("");
        txtNovaSenha.setText("");
        txtConfirmaSenha.setText("");
        txtLogin.setText("");
        txtTipo.setText("");
        
    
       
    }//GEN-LAST:event_btbSalvarUsuarioActionPerformed

    private void txtNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNovoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNovoUsuarioActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelCadastroUsuario;
    private javax.swing.JPanel PainelDisplay;
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JPanel PainelMenu;
    private javax.swing.JPanel PainelTitulo;
    private javax.swing.JButton btbSalvarUsuario;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblConfirmaSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblNovoUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblnovoLogin;
    private javax.swing.JPasswordField txtConfirmaSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JTextField txtNovoUsuario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
