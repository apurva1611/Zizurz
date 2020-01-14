/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HouseAgreement;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HouseAgreementWorkRequest;
//import com.itextpdf.text.DocumentException;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

;

/**
 *
 * @author raunak
 */
public class HouseAgreementWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    HouseAgreementWorkRequest request;
    private UserAccount userAccount;
    private EcoSystem business;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private int counter = 0;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public HouseAgreementWorkRequestJPanel(JPanel userProcessContainer, HouseAgreementWorkRequest request, UserAccount userAccount, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.business = business;
        downloadPdfBtn.setEnabled(false);
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model1 = (DefaultTableModel) tblPersonRecords.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tblHousingDetails.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
        if (request.getHomelessPerson() != null) {
            Object[] row = new Object[4];
            row[0] = request.getHomelessPerson().getName();
            row[1] = request.getHomelessPerson().getIncome();
            row[2] = request.getHomelessPerson().getDependents();
            row[3] = request.getHomelessPerson().getContactNo();
            model1.addRow(row);
        }
        Object[] row = new Object[3];
        row[0] = request.getAddressForHomeless().get(0);
        row[1] = request.getAddressForHomeless().get(1);
        row[2] = request.getScheme();
        model2.addRow(row);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonRecords = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHousingDetails = new javax.swing.JTable();
        downloadPdfBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        submitJButton.setBackground(new java.awt.Color(0, 102, 255));
        submitJButton.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(0, 102, 255));
        backJButton.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        backJButton.setText("< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HOUSE AGREEMENT");

        tblPersonRecords.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        tblPersonRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Income", "Dependents", "Contact Number"
            }
        ));
        jScrollPane1.setViewportView(tblPersonRecords);

        tblHousingDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        tblHousingDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "House Address", "Rent", "Scheme Applicable"
            }
        ));
        jScrollPane2.setViewportView(tblHousingDetails);

        downloadPdfBtn.setBackground(new java.awt.Color(0, 102, 255));
        downloadPdfBtn.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        downloadPdfBtn.setText("Download Agreement");
        downloadPdfBtn.setEnabled(false);
        downloadPdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadPdfBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("House will be allocated to:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("House Details:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(764, 764, 764))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(downloadPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadPdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        HouseAgreementWorkAreaJPanel dwjp = (HouseAgreementWorkAreaJPanel) component;
        dwjp.populateReceiveTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        //request.setTestResult("Send to Housing Agreement");
        if (request.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "This request has already been completed by you!");
            return;
        }
        request.setStatus("Completed");
        request.getShelterAllocWorkReq().setTestResult("Completed and Person has been allocated the house!");
        UserAccount account = new UserAccount();
        account.setUsername("None");
        request.getShelterAllocWorkReq().setReceiver(account);
        downloadPdfBtn.setEnabled(true);
        JOptionPane.showMessageDialog(null, "House has been allocated and agreement is generated successfully.");
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void downloadPdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadPdfBtnActionPerformed
        String name = request.getHomelessPerson().getName();
        String houseAddress = request.getAddressForHomeless().get(0);
        String rent = request.getAddressForHomeless().get(1);
        String scheme = request.getScheme();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("HousingAgreement_" + counter + ".pdf"));
            document.open();
            addMetaData(document);
            addTitlePage(document, name, houseAddress, rent, scheme);
            document.close();
            counter++;
            JOptionPane.showMessageDialog(null, "House agreement file has been downloaded");

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Pdf generator error");
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("Housing Agreement PDF");
        document.addSubject("");
        document.addKeywords("");
        document.addAuthor("Nisarg");
        document.addCreator("Nisarg");
    }

    private static void addTitlePage(Document document, String name, String houseAddress, String rent, String scheme)
            throws DocumentException {

        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Housing Agreement", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("House Agreement generated by: " + System.getProperty("user.name") + ", " + new Date(), subFont));
        addEmptyLine(preface, 3);
        String paragraph = "This document is a confirmation that a rental agreement has been signed with the agreement that " + name.toUpperCase()
                + " will be renting a apartment at " + houseAddress + " for 1 year. As mutually agreed, under the scheme - " + scheme
                + ", the monthly rent shall be $(" + rent + ") and shall be payable every 1st day of the month. "
                + "You will also be liable to pay 3 month advance rent as a security deposit.";
        preface.add(new Paragraph(paragraph, smallBold));

        addEmptyLine(preface, 1);

        preface.add(new Paragraph(
                "Please read the agreement carefully. If you agree to the terms and conditions of the agreement, "
                + "please sign the enclosed document. You may move into the apartment 7 days after the signing of the agreement.",
                smallBold));

        document.add(preface);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_downloadPdfBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton downloadPdfBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTable tblHousingDetails;
    private javax.swing.JTable tblPersonRecords;
    // End of variables declaration//GEN-END:variables
}