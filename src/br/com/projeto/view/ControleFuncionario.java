/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.view;

import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.dao.FuncionarioDAO;
import br.com.projeto.model.dao.conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LucasVerly
 */
public class ControleFuncionario extends javax.swing.JFrame {
    
    
    //Metodo para listar os funcionarios na tabela
    public void listarFuncionarios () throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        ArrayList<Funcionarios> lista = funcionarioDao.selectAll();
        DefaultTableModel dados = (DefaultTableModel) tabelaFuncionarios.getModel();

        dados.setNumRows(0);

        for (Funcionarios f : lista) {
            dados.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                f.getEndereco(),
                f.getCelular(),
                f.getCargo()
            });
        }
    }
    
    //Metodo para fazer a pesquisa por nome 
    public void pesquisarPorNome(String nome) throws SQLException {
        
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        //Funcionarios funcionario = new Funcionarios();
        
        ArrayList<Funcionarios> lista = funcionarioDao.selectForName(nome);
        
        DefaultTableModel tabela = (DefaultTableModel) tabelaFuncionarios.getModel();
        
        tabela.setNumRows(0);
        
        for (Funcionarios funcionario : lista){
            tabela.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getEndereco(),
                funcionario.getCelular(),
                funcionario.getCargo()
            });
        }
    }
    
    //Metodo para excluir funcionario
    public void excluirFuncionario(String cpf) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        funcionarioDao.deleteFuncionario(cpf);
    }
    
    //Metodo para editar um funcionario
    public void editarFuncionario (String cpf) throws SQLException{
                Connection conexao = new Conexao().getConnection();
                FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        
                Funcionarios funcionarioParaSerEditado = funcionarioDao.selectForCpf(cpf);
        
                EditarFuncionario editarFuncionario = new EditarFuncionario ();
                editarFuncionario.setVisible(true);
                
                editarFuncionario.setTxtCodigo(String.valueOf(funcionarioParaSerEditado.getId()));
                editarFuncionario.setTxtNome(funcionarioParaSerEditado.getNome());
                editarFuncionario.setTxtBairro(funcionarioParaSerEditado.getBairro());
                editarFuncionario.setTxtCargo(funcionarioParaSerEditado.getCargo());
                editarFuncionario.setTxtCelular(funcionarioParaSerEditado.getCelular());
                editarFuncionario.setTxtCep(funcionarioParaSerEditado.getCep());
                editarFuncionario.setTxtCidade(funcionarioParaSerEditado.getCidade());
                editarFuncionario.setTxtComplemento(funcionarioParaSerEditado.getComplemento());
                editarFuncionario.setTxtCpf(funcionarioParaSerEditado.getCpf());
                editarFuncionario.setTxtDataNascimento(funcionarioParaSerEditado.getDataNascimento());
                editarFuncionario.setTxtEmail(funcionarioParaSerEditado.getEmail());
                editarFuncionario.setTxtRua(funcionarioParaSerEditado.getEndereco());
                editarFuncionario.setCbEstado(funcionarioParaSerEditado.getEstado());
                editarFuncionario.setCbNivel(funcionarioParaSerEditado.getNivelAcesso());
                editarFuncionario.setTxtNumeroCasa(funcionarioParaSerEditado.getNumero());
                editarFuncionario.setTxtRG(funcionarioParaSerEditado.getRg());
                editarFuncionario.setTxtSenha(funcionarioParaSerEditado.getSenha());
                editarFuncionario.setTxtTelefoneFixo(funcionarioParaSerEditado.getTelefone());
                
                this.dispose();
    }
    
    /**
     * Creates new form Clientes
     */
    public ControleFuncionario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        bntCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Controle de Funcionarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel1)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1098, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome :");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/icons/buscar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Rua", "Celular", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnPesquisar)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1010, 340));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalvar.setText("SALVAR");
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, -1, -1));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 10, 10));

        bntCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bntCancelar.setText("CANCELAR");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bntCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        String nome = "%" + txtNome.getText().trim() + "%";;
        try {
            pesquisarPorNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            listarFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
        if (linhaSelecionada == -1){
            JOptionPane.showMessageDialog(this, "Selecione uma funcionário para editar");
        } else {
            String cpfSelecionado;
            DefaultTableModel Funcionario = (DefaultTableModel) tabelaFuncionarios.getModel();
            cpfSelecionado = tabelaFuncionarios.getValueAt(linhaSelecionada, 1).toString();
            try {
                editarFuncionario(cpfSelecionado);
            } catch (SQLException ex) {
                Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
        if (linhaSelecionada == -1){
            JOptionPane.showMessageDialog(this, "Selecione uma funcionário para excluir");
        } else {
            int op;
            op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o funcionário ?");
            if(op == 0){
                String cpfSelecionado;
                cpfSelecionado = tabelaFuncionarios.getValueAt(linhaSelecionada, 1).toString();
                DefaultTableModel Funcionario = (DefaultTableModel) tabelaFuncionarios.getModel();
                
                Funcionario.removeRow(linhaSelecionada);
                try {
                    excluirFuncionario(cpfSelecionado);
                    JOptionPane.showMessageDialog(this, "Funcionário Excluido !!!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir !!!" + ex);
                }
            }
        }
        try {
            listarFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
        tabelaFuncionarios.clearSelection();
        txtNome.setText("");
        try {
            listarFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyPressed

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
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleFuncionario().setVisible(true);
            }
        });
    }

    public JTable getTabelaFuncionarios() {
        return tabelaFuncionarios;
    }

    public void setTabelaFuncionarios(JTable tabelaFuncionarios) {
        this.tabelaFuncionarios = tabelaFuncionarios;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
