/* 
 * Copyright 2018 Cafe Sati Polska.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ProductionManagement;

import Frames.LabAssistantFrame;
import Frames.StoremanFrame;
import Frames.AdministratorFrame;
import Frames.HallManagerFrame;
import Frames.CEOFrame;
import Frames.OfficeFrame;
import Frames.OperatorFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Przemysław
 */
public class LogInForm extends javax.swing.JFrame {

    Employee emp;
    JFrame frame;
    DataBaseConnector dbc;

    /**
     * Creates new form LogInForm
     */
    private boolean authUser(String login, String password) {
        dbc = Global.getDataBaseConnector();
        dbc.openSession();
        Employee e = dbc.AuthorizeUser(login, password);

        if (e != null) {
            emp = e;
            Global.setEmployee(emp);
            int delay = 15000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Date sessionStart = new Date(dbc.getSf().getStatistics().getStartTime());
                    Date now = new Date(System.currentTimeMillis());
                    Calendar c = Calendar.getInstance();
                    c.setTime(sessionStart);
                    c.add(Calendar.MINUTE, Global.MINUTES_TO);
                    c.getTime();
                    if (c.getTime().before(now)) {
                        dbc.closeSession();
                        JOptionPane.showMessageDialog(null, "Wylogowano ze wzgledu na zbyt długą nieaktywność.", "Informacja", JOptionPane.ERROR_MESSAGE);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                    }
                }
            };
            new Timer(delay, taskPerformer).start();
            return true;
        }
        return false;

    }

    public LogInForm() {
        initComponents();
        super.setTitle("Okno logowania");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogInFormLoginPanel = new javax.swing.JPanel();
        LogInFormLoginTextField = new javax.swing.JTextField();
        LogInFormLoginLabel = new javax.swing.JLabel();
        LogInFormPasswordLabel = new javax.swing.JLabel();
        LogInFormLoginBurron = new javax.swing.JButton();
        LogInFormPasswordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LogInFormLoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Logowanie"));

        LogInFormLoginTextField.setToolTipText("Wpisz nazwę użytkownika");

        LogInFormLoginLabel.setText("Nazwa Użytkownika");

        LogInFormPasswordLabel.setText("Hasło");

        LogInFormLoginBurron.setText("Zaloguj");
        LogInFormLoginBurron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInFormLoginBurronActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogInFormLoginPanelLayout = new javax.swing.GroupLayout(LogInFormLoginPanel);
        LogInFormLoginPanel.setLayout(LogInFormLoginPanelLayout);
        LogInFormLoginPanelLayout.setHorizontalGroup(
            LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInFormLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LogInFormLoginPanelLayout.createSequentialGroup()
                        .addGroup(LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogInFormLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(LogInFormPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogInFormLoginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(LogInFormPasswordTextField)))
                    .addComponent(LogInFormLoginBurron))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        LogInFormLoginPanelLayout.setVerticalGroup(
            LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInFormLoginPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogInFormLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogInFormLoginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LogInFormLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogInFormPasswordLabel)
                    .addComponent(LogInFormPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogInFormLoginBurron)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogInFormLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogInFormLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInFormLoginBurronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInFormLoginBurronActionPerformed

        String login = LogInFormLoginTextField.getText();
        String password = String.valueOf(LogInFormPasswordTextField.getPassword());
        try {
            if (authUser(login, password) == true) {

                switch (emp.getJobPosition()) {
                    case Global.ADMINISTRATOR:
                        frame = new AdministratorFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.STOREMAN:
                        frame = new StoremanFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.LAB_ASSISTANT:
                        frame = new LabAssistantFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.CEO:
                        frame = new CEOFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.HALL_MANAGER:
                        frame = new HallManagerFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.OPERATOR:
                        frame = new OperatorFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    case Global.OFFICE:
                        frame = new OfficeFrame(emp);
                        frame.setVisible(true);
                        this.dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Błąd logowania", "Błąd", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {

                LogInFormLoginTextField.setText("");
                LogInFormPasswordTextField.setText("");

                JOptionPane.showMessageDialog(null, "Błąd logowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Błąd", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_LogInFormLoginBurronActionPerformed

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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogInFormLoginBurron;
    private javax.swing.JLabel LogInFormLoginLabel;
    private javax.swing.JPanel LogInFormLoginPanel;
    private javax.swing.JTextField LogInFormLoginTextField;
    private javax.swing.JLabel LogInFormPasswordLabel;
    private javax.swing.JPasswordField LogInFormPasswordTextField;
    // End of variables declaration//GEN-END:variables

}
