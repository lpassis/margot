package chatbot;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Tela extends javax.swing.JFrame {

    String Mensagem_Crianca;
    String Nome, Nome_bot;
    static ChatBot chat;

    public String Resposta_Margot = "";

    public Tela() {
        initComponents();

        chat = new ChatBot();
        Mensagem_Crianca = new String();
        setLocationRelativeTo(null);
        Nome = "Você: ";
        mensagemjTextArea.requestFocusInWindow();
        Nome_bot = "Margot: ";
        chatjTextArea.setText("Margot: Oi.");
        try {
            GravarConversa.salvar("\n\n---INICIO DA CONVERSA---\nMargot: Oi. ");
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatjTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensagemjTextArea = new javax.swing.JTextArea();
        Margot = new javax.swing.JLabel();
        enviarjButton = new javax.swing.JButton();
        //sobrejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Converse com a Margot");
        setResizable(false);

        Fundo.setPreferredSize(new java.awt.Dimension(974, 500));

  /*      chatjTextArea.addKeyListener(new KeyAdapter() {
            boolean ctrlPressed = false;
            boolean cPressed = false;

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_C:
                        cPressed = true;

                        break;
                    case KeyEvent.VK_CONTROL:
                        ctrlPressed = true;
                        break;
                }

                if (ctrlPressed && cPressed) {
                    JOptionPane.showMessageDialog(null, "Não utilize Ctrl + c", "AVISO", JOptionPane.WARNING_MESSAGE);
                    e.consume();// Stop the event from propagating.
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_C:
                        cPressed = false;

                        break;
                    case KeyEvent.VK_CONTROL:
                        ctrlPressed = false;
                        break;
                }

                if (ctrlPressed && cPressed) {
                    JOptionPane.showMessageDialog(null, "Não utilize Ctrl + c", "AVISO", JOptionPane.WARNING_MESSAGE);
                    e.consume();// Stop the event from propagating.
                }
            }
        });
*/
        chatjTextArea.setEditable(false);
        chatjTextArea.setBackground(new java.awt.Color(230, 243, 241));
        chatjTextArea.setColumns(20);
        chatjTextArea.setOpaque(false);
        chatjTextArea.setFont(new java.awt.Font("Ubuntu", 0, 18));
        chatjTextArea.setRows(13);
        chatjTextArea.setLineWrap(true);
        chatjTextArea.setWrapStyleWord(true);
        //chatjTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1 = new JScrollPane(chatjTextArea) {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    Composite composite = ((Graphics2D) g).getComposite();

                    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());

                    ((Graphics2D) g).setComposite(composite);
                    paintChildren(g);
                } catch (IndexOutOfBoundsException e) {
                    super.paintComponent(g);
                }
            }
        };

        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setOpaque(false);

        mensagemjTextArea.setBackground(new java.awt.Color(228, 243, 243));
        mensagemjTextArea.setColumns(20);
        mensagemjTextArea.setFont(new java.awt.Font("Ubuntu", 0, 18));
        mensagemjTextArea.setRows(5);
        mensagemjTextArea.setOpaque(false);
        mensagemjTextArea.setTabSize(10);
        mensagemjTextArea.setToolTipText("");
        mensagemjTextArea.setCaretColor(new java.awt.Color(16, 2, 77));
        mensagemjTextArea.setLineWrap(true);

        jScrollPane2 = new JScrollPane(mensagemjTextArea) {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    Composite composite = ((Graphics2D) g).getComposite();

                    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());

                    ((Graphics2D) g).setComposite(composite);
                    paintChildren(g);
                } catch (IndexOutOfBoundsException e) {
                    super.paintComponent(g);
                }
            }
        };

        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setOpaque(false);

        mensagemjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mensagemjTextAreaKeyReleased(evt);
            }
        });

        Margot.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/margot.png")); // NOI18N
        Fundo = new ImagemFundo(System.getProperty("user.dir") + "/Imagens/mar.png");

        enviarjButton.setFont(new java.awt.Font("Ubuntu", 0, 18));
        enviarjButton.setBackground(new Color(0, 0, 0, 0));
        enviarjButton.setOpaque(false);
        enviarjButton.setBorderPainted(false);
        enviarjButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/Untitled-2.png")); // NOI18N
        enviarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarjButtonActionPerformed(evt);
            }
        });
        //sobrejButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/ICONE.png")); // NOI18N
        //sobrejButton.setText("Sobre o aplicativo");
        /*sobrejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Janela.setVisible(true);
            }
        });*/

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
                FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FundoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FundoLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(enviarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        //.addComponent(sobrejButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(Margot, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)))
                                .addContainerGap())
        );
        FundoLayout.setVerticalGroup(
                FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FundoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FundoLayout.createSequentialGroup()
                                                .addComponent(Margot)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(50, 50, 50)
                                                //.addComponent(sobrejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        )
                                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, FundoLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(enviarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Fundo, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        Sobre = new javax.swing.JPanel();
        Janela = new javax.swing.JFrame("Sobre o projeto");
        Sobre = new javax.swing.JPanel();
        Nomes = new javax.swing.JLabel();
        logos = new javax.swing.JLabel();
        botaoMaisInf = new javax.swing.JButton();

        Nomes.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/nomes.png")); // NOI18N

        logos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"/Imagens/ufvjm.gif")); // NOI18N

        botaoMaisInf.setText("Acesse para maiores informações");
        botaoMaisInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SobreLayout = new javax.swing.GroupLayout(Sobre);
        Sobre.setLayout(SobreLayout);
        SobreLayout.setHorizontalGroup(
                SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SobreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(SobreLayout.createSequentialGroup()
                                                .addComponent(Nomes)
                                                .addContainerGap(41, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SobreLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(logos)
                                                        .addGroup(SobreLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(botaoMaisInf)))
                                                .addGap(175, 175, 175))))
        );
        SobreLayout.setVerticalGroup(
                SobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SobreLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Nomes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoMaisInf)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Janela.setContentPane(Sobre);
        Janela.setBounds(200, 100, 550, 480);
        Janela.setVisible(false);

        pack();
    }// </editor-fold>         

    private void botaoMaisInfActionPerformed(java.awt.event.ActionEvent evt) {
       
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.lucianaassis.pro.br/margot"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void enviarjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mensagemjTextArea.setText(mensagemjTextArea.getText());
        Limpa_Caixa();
    }

    private void mensagemjTextAreaKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Limpa_Caixa();
        }
    }

    private void Limpa_Caixa() {
        String log;
        Mensagem_Crianca = mensagemjTextArea.getText();
        mensagemjTextArea.setText("");

        chatjTextArea.setText(chatjTextArea.getText() + "\n" + Nome + Mensagem_Crianca + "\n");
        log = Nome + Mensagem_Crianca;
        try {
            GravarConversa.salvar(log);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Resposta_Margot.contains("Qual é o seu nome?") || Resposta_Margot.contains("Como você se chama?")) {
            if (!(Mensagem_Crianca.contains("eu me chamo") || Mensagem_Crianca.contains("meu nome é"))) {
                Mensagem_Crianca = "Eu me chamo " + Mensagem_Crianca;
            }
        }

        if (Resposta_Margot.contains("Por favor me explique") || Resposta_Margot.contains("Quero aprender um pouco mais com você") || Resposta_Margot.contains("suas definições")) {
            Mensagem_Crianca = "DEFINIÇÃO";
        }

        Resposta_Margot = chat.Conversa(Mensagem_Crianca);

        if (Resposta_Margot.contains("HPY")) {
            Margot.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/margotHappy.png"));
            Resposta_Margot = Resposta_Margot.replaceAll("HPY", " ");
        }

        if (Resposta_Margot.contains("DFT")) {
            Margot.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/margot.png"));
            Resposta_Margot = Resposta_Margot.replaceAll("DFT", " ");
        }

        if (Resposta_Margot.contains("CNF")) {
            Margot.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/margotConf.png"));
            Resposta_Margot = Resposta_Margot.replaceAll("CNF", " ");
        }
        if (Resposta_Margot.contains("BRV")) {
            Margot.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/Imagens/margotBrava.png"));
            Resposta_Margot = Resposta_Margot.replaceAll("BRV", " ");
        }

        if (Resposta_Margot.contains("QBRA")) {
            String frases[] = Resposta_Margot.split("QBRA");
            log = "";
            for (int x = 0; x < frases.length; x++) {
                //try {    
                chatjTextArea.setText(chatjTextArea.getText() + Nome_bot + frases[x]);
                log = log + Nome_bot + frases[x];
                //  TimeUnit.SECONDS.sleep(2);
                //} catch (InterruptedException ex) {}
            }

        } else {
            chatjTextArea.setText(chatjTextArea.getText() + Nome_bot + Resposta_Margot);
            log = Nome_bot + Resposta_Margot;
        }

        try {
            GravarConversa.salvar(log);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea mensagemjTextArea;
    private javax.swing.JTextArea chatjTextArea;
    private javax.swing.JLabel Margot;
    private javax.swing.JButton enviarjButton;
    private javax.swing.JButton sobrejButton;
    private javax.swing.JPanel Fundo;

    private javax.swing.JLabel Nomes;
    private javax.swing.JButton botaoMaisInf;
    private javax.swing.JLabel logos;
    private javax.swing.JPanel Sobre;
    private javax.swing.JFrame Janela;

}
