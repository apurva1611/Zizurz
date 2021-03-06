/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

/**
 *
 * @author 15085
 */
import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Airplane;
import Business.MasterFlightSchedule;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewAirplaneJPanel extends javax.swing.JPanel {

    private JPanel cardSequenceJPanel;
    private AirlinerDirectory airlineDirectory;
    private Airliner airline;
    private MasterFlightSchedule flightSchedules;
    private Airplane airplane;

    public ViewAirplaneJPanel(JPanel cardSequenceJPanel,Airliner airline,AirlinerDirectory airlineDirectory,MasterFlightSchedule flightSchedules,Airplane airplane) {
        initComponents();
        this.cardSequenceJPanel = cardSequenceJPanel;
        this.airline = airline;
        this.airlineDirectory = airlineDirectory;
        this.flightSchedules = flightSchedules;
        this.airplane = airplane;
        btnSave.setEnabled(false);
        populateFields();
    }
    private void populateFields(){
        txtModelNumber.setEnabled(false);
        txtSerailNum.setEnabled(false);
        txtFuelCapacity.setEnabled(false);
        txtSeatCapacity.setEnabled(false);
        txtModelNumber.setText(airplane.getModelNumber());
        txtSerailNum.setText(Integer.toString(airplane.getSerialNumber()));
        txtFuelCapacity.setText(Double.toString(airplane.getFuelCapacity()));
        txtSeatCapacity.setText(Integer.toString(airplane.getSeatCapacity()));
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
        jLabel2 = new javax.swing.JLabel();
        txtModelNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFuelCapacity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSerailNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSeatCapacity = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Airplane");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Model Number:");

        txtModelNumber.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fuel Capacity:");

        txtFuelCapacity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Serial Number:");

        txtSerailNum.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSerailNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerailNumActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Seat Capacity:");

        txtSeatCapacity.setEditable(false);
        txtSeatCapacity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtSeatCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeatCapacityActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        backBtn.setText("< Back ");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 450, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtModelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSerailNum)
                                            .addComponent(txtFuelCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(txtSeatCapacity))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFuelCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSerailNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSeatCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerailNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerailNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerailNumActionPerformed

    private void txtSeatCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeatCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatCapacityActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        txtModelNumber.setEnabled(true);
        txtSerailNum.setEnabled(true);
        txtFuelCapacity.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if ((txtFuelCapacity.getText().equals("")) || (txtModelNumber.getText().equals("")) || (txtSerailNum.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Please enter the required fields");
            return;
        }
        try {
            Double.parseDouble(txtFuelCapacity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please type in a number for fuel capacity");
            return;
        }
        try {
            Integer.parseInt(txtSerailNum.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please type in a number for Serial Number");
            return;
        }
        airplane.setFuelCapacity(Double.parseDouble(txtFuelCapacity.getText()));
        airplane.setSerialNumber(Integer.parseInt(txtSerailNum.getText()));
        airplane.setModelNumber(txtModelNumber.getText());
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtSerailNum.setEnabled(false);
        txtFuelCapacity.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Airplane updated successfully");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        cardSequenceJPanel.remove(this);
        CardLayout cardLayout = (CardLayout) cardSequenceJPanel.getLayout();
        cardLayout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFuelCapacity;
    private javax.swing.JTextField txtModelNumber;
    private javax.swing.JTextField txtSeatCapacity;
    private javax.swing.JTextField txtSerailNum;
    // End of variables declaration//GEN-END:variables
}
