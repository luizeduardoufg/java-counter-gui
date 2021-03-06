/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import services.CalculateRemanescentHours;
import services.Writer;


/**
 *
 * @author silva
 */
public class Program extends javax.swing.JFrame {
    public static Program program;
    Writer writer = new Writer();
    StringBuilder sb = new StringBuilder();
    /**
     * Creates new form Program
     */
    public Program() {
        initComponents();
        this.setLocationRelativeTo(null);
        escreverTexto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEditar = new javax.swing.JMenu();
        menuItemEditarHorasTotais = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtShow.setEditable(false);
        txtShow.setColumns(20);
        txtShow.setRows(5);
        jScrollPane1.setViewportView(txtShow);

        menuEditar.setText("Editar");

        menuItemEditarHorasTotais.setText("Editar horas totais");
        menuItemEditarHorasTotais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarHorasTotaisActionPerformed(evt);
            }
        });
        menuEditar.add(menuItemEditarHorasTotais);

        jMenuItem2.setText("Editar horas concluídas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuEditar.add(jMenuItem2);

        jMenuItem3.setText("Atualizar horas concluídas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuEditar.add(jMenuItem3);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuEditar.add(menuItemSair);

        jMenuBar1.add(menuEditar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEditarHorasTotaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarHorasTotaisActionPerformed
        Double novoHorasTotais = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o novo valor de horas totais:"));
        escreverTexto1(novoHorasTotais);
    }//GEN-LAST:event_menuItemEditarHorasTotaisActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Double novoHorasConcluidas = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o novo valor de horas concluídas:"));
        escreverTexto2(novoHorasConcluidas);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Double attHorasConcluidas = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite as horas concluídas para serem adicionadas:"));
        escreverTexto3(attHorasConcluidas);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        Main.program.dispose();
        Main.txtLog.setText("");
        Main.main.setVisible(true);
    }//GEN-LAST:event_menuItemSairActionPerformed

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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                program = Main.program;
                
                
            }
        });
    }
    
    public void escreverTexto(){
        
        String[] fields = Main.fileContent.split(",");
        CalculateRemanescentHours calculateHours = new CalculateRemanescentHours(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
        
        
        txtShow.setText("Usuário: " + fields[0] +
                "\nHoras totais: " + fields[1] + 
                "\nHoras concluídas: " + fields[2] + 
                "\nHoras remanescentes: " + calculateHours.calculateHours());
    }
    
    public void escreverTexto1(Double novoHorasTotais){
        sb.delete(0, sb.length());
        String[] fields = Main.fileContent.split(",");
        CalculateRemanescentHours calculateHours = new CalculateRemanescentHours(novoHorasTotais, Double.parseDouble(fields[2]));
        
        sb.append(fields[0]).append(",").append(String.format("%.0f", novoHorasTotais)).append(",").append(fields[2]);
        writer.write(Main.filePath,sb.toString());
        Main.fileContent = sb.toString();
        System.out.println(sb);
        txtShow.setText("Usuário: " + fields[0] +
                "\nHoras totais: " + novoHorasTotais + 
                "\nHoras concluídas: " + fields[2] + 
                "\nHoras remanescentes: " + calculateHours.calculateHours());
    }
    
    public void escreverTexto2(Double novoHorasConcluidas){
        sb.delete(0, sb.length());
        String[] fields = Main.fileContent.split(",");
        CalculateRemanescentHours calculateHours = new CalculateRemanescentHours(Double.parseDouble(fields[1]), novoHorasConcluidas);
        
        sb.append(fields[0]).append(",").append(fields[1]).append(",").append(String.format("%.0f", novoHorasConcluidas));
        writer.write(Main.filePath,sb.toString());
        Main.fileContent = sb.toString();
        System.out.println(sb);
        txtShow.setText("Usuário: " + fields[0] +
                "\nHoras totais: " + fields[1] + 
                "\nHoras concluídas: " + novoHorasConcluidas + 
                "\nHoras remanescentes: " + calculateHours.calculateHours());
    }
    
    public void escreverTexto3(Double attHorasConcluidas){
        sb.delete(0, sb.length());
        String[] fields = Main.fileContent.split(",");
        CalculateRemanescentHours calculateHours = new CalculateRemanescentHours(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]));
        
        
        
        sb.append(fields[0]).append(",").append(fields[1]).append(",").append(String.format("%.0f", Double.parseDouble(fields[2]) + attHorasConcluidas));
        writer.write(Main.filePath,sb.toString());
        Main.fileContent = sb.toString();
        System.out.println(sb);
        
        Double novoValor = (Double.parseDouble(fields[2]) + attHorasConcluidas);
        
        txtShow.setText("Usuário: " + fields[0] +
                "\nHoras totais: " + fields[1] + 
                "\nHoras concluídas: " +  String.format("%.0f", novoValor) +
                "\nHoras remanescentes: " + calculateHours.attHours(attHorasConcluidas));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuItemEditarHorasTotais;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables
}
