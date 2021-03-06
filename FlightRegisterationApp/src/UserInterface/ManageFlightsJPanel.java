/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Flight;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 15085
 */
public class ManageFlightsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFlightsJPanel
     */
    private JPanel cardSequenceJPanel;
    private Airliner al;

    ManageFlightsJPanel(JPanel cardSequenceJPanel, Airliner al) {
        initComponents();
        this.cardSequenceJPanel = cardSequenceJPanel;
        this.al = al;
        populateTable();
        labelName.setText("Manage Flights for " + al.getAirLinerName());
    }
    
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setRowCount(0);
        for(Flight f : al.getFlights().getFlights()){
            Object row[]= new Object[4];
            row[0] = f;
            row[1] = f.getDepartureCity();
            row[2]=f.getArrivalCity();
            row[3]=f.getTime();
            dtm.addRow(row);
        }
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
        tblFlights = new javax.swing.JTable();
        labelName = new javax.swing.JLabel();
        btnAddFlight = new javax.swing.JButton();

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airplane No.", "From City", "To City", "Departure Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlights);
        if (tblFlights.getColumnModel().getColumnCount() > 0) {
            tblFlights.getColumnModel().getColumn(0).setResizable(false);
            tblFlights.getColumnModel().getColumn(1).setResizable(false);
            tblFlights.getColumnModel().getColumn(2).setResizable(false);
            tblFlights.getColumnModel().getColumn(3).setResizable(false);
        }

        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Manage Flights for ******");
        labelName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAddFlight.setText("Add New Flight");
        btnAddFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFlightActionPerformed
        CreateFlightJPanel createFlightJPanel = new CreateFlightJPanel(cardSequenceJPanel,al);
        CardLayout layout = (CardLayout)cardSequenceJPanel.getLayout();
        cardSequenceJPanel.add("CreatFlighteAirlines",createFlightJPanel);
        layout.next(cardSequenceJPanel);
    }//GEN-LAST:event_btnAddFlightActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFlight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelName;
    private javax.swing.JTable tblFlights;
    // End of variables declaration//GEN-END:variables
}
