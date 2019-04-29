/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author silva
 */
public class NewUser extends javax.swing.JFrame {
    public static NewUser newUser;
    
    /**
     * Creates new form NewUser
     */
    public NewUser() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNewLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHorasTotais = new javax.swing.JTextField();
        botaoCriar = new javax.swing.JButton();
        txtHorasConcluidas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nome de login:");

        jLabel2.setText("Horas totais:");

        botaoCriar.setText("Criar");
        botaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarActionPerformed(evt);
            }
        });

        jLabel3.setText("Horas concluídas:");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Para criar um novo arquivo, é necessário cadastrar ao menos um usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(txtHorasConcluidas, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtHorasTotais, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(txtNewLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorasTotais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorasConcluidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCriar)
                    .addComponent(botaoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarActionPerformed
  
        /*
            LOGIN,HORASTOTAIS,HORASCONCLUIDAS
        */
        String login = txtNewLogin.getText();
        
        if(testLogin() != true){
            JOptionPane.showMessageDialog(null, "O campo usuário deve ser preenchido");
            txtNewLogin.requestFocus();
            
            /*Main.txtLog.setText("Operação terminada!");
                Main.newUser.dispose();
                return;*/
        }else{
            String horasTotais = txtHorasTotais.getText();
            if(horasTotais.equals("")){
                txtHorasTotais.setText("0");
                horasTotais = txtHorasTotais.getText();
            }
            String horasConcluidas = txtHorasConcluidas.getText();
            if(horasConcluidas.equals("")){
                txtHorasConcluidas.setText("0");
                horasConcluidas = txtHorasConcluidas.getText();
            }

            JFileChooser salvandoArquivo = new JFileChooser();

            int resultado = salvandoArquivo.showSaveDialog(this);

            if (resultado != JFileChooser.APPROVE_OPTION) {

                return;
            }

            File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();
            Main.filePath = salvarArquivoEscolhido.getAbsolutePath()+".txt";

            if ((salvarArquivoEscolhido.exists())) {
                switch(JOptionPane.showConfirmDialog(this, "O arquivo já existe? Deseja sobrescreve-lo?")){
                    case JOptionPane.OK_OPTION:
                        try(PrintWriter pw = new PrintWriter(new FileWriter(salvarArquivoEscolhido))){
                            pw.println(login+","+horasTotais+","+horasConcluidas);
                            pw.close();
                        }
                        catch(IOException e){
                            Main.txtLog.setText("Error: " + e.getMessage());
                        }
                        finally{
                            Main.filePath = salvarArquivoEscolhido.getAbsolutePath();
                            Main.txtLog.setText("Arquivo criado com sucesso!");
                            Main.newUser.dispose();
                        }
                        break;
                    case JOptionPane.NO_OPTION:
                        Main.filePath = salvarArquivoEscolhido.getAbsolutePath()+".txt";    
                        break;
                    default:
                        break;
                }

            }else{
                try(PrintWriter pw = new PrintWriter(new FileWriter(salvarArquivoEscolhido + ".txt"))){
                            pw.println(login+","+horasTotais+","+horasConcluidas);
                            pw.close();
                        }
                        catch(IOException e){

                        }
                        finally{
                            Main.newUser.dispose();
                        }
            }
        }
    }//GEN-LAST:event_botaoCriarActionPerformed
    
    private boolean testLogin(){
        return !txtNewLogin.getText().equals("");
    }
  
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        Main.txtLog.setText("Operação cancelada!");
        Main.newUser.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                newUser = Main.newUser;
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoCriar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtHorasConcluidas;
    private javax.swing.JTextField txtHorasTotais;
    private javax.swing.JTextField txtNewLogin;
    // End of variables declaration//GEN-END:variables
}
