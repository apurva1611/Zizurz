/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ShelterFacilitatorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VerificationEnterprise;
import Business.Network.Network;
import Business.Organization.BackgroundCheckOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BackgroundCheckWorkRequest;
import Business.WorkQueue.ShelterFacilitateWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TILAK PARMAR
 */
public class ShelterFacilitationWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShelterFacilitationWorkRequestJPanel
     */
    JPanel userProcessContainer;
    ShelterFacilitateWorkRequest request;
    private UserAccount userAccount;
    private EcoSystem business;
    ShelterFacilitationWorkRequestJPanel(JPanel userProcessContainer, ShelterFacilitateWorkRequest request, UserAccount userAccount, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.business = business;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model1 = (DefaultTableModel) tblHomelessPersonRecord.getModel();
        model1.setRowCount(0);
        if(request.getHomelessPerson()!=null){
            Object[] row = new Object[6];
            row[0] = request.getHomelessPerson().getName();
            row[1] = request.getHomelessPerson().getContactNo();
            row[2] = request.getHomelessPerson().getEmailAddress();
            row[3] = request.getHomelessPerson().getCurrentAddress();
            row[4] = request.getAddressToBePlaced();
            row[5] = request.getHomelessPerson().getDependents();
            model1.addRow(row);   
        }  
    }
    
    public boolean timeCompare() {
        
        Pattern p = Pattern.compile("^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]+$");
        Matcher m = p.matcher(txtFieldPickupTime.getText());
        boolean b = m.matches();
        return b;
    }
    
    public boolean Datevalidate() {
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");

        matcher = pattern.matcher(txtFieldPickupDate.getText());

        if (matcher.matches()) {

            matcher.reset();

            if (matcher.find()) {

                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31")
                        && (month.equals("4") || month.equals("6") || month.equals("9")
                        || month.equals("11") || month.equals("04") || month.equals("06")
                        || month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if (year % 4 == 0) {
                        if (day.equals("30") || day.equals("31")) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        if (day.equals("29") || day.equals("30") || day.equals("31")) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean DateChecker() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String xyz = sdf.format(new Date());
        Date date1 = sdf.parse(xyz);
        Date date2 = sdf.parse(txtFieldPickupDate.getText());

        if (date2.compareTo(date1) > 0) {
            System.out.println("Entered date is after today's Date");
            return true;
        }
        else {
            return false;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnYes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHomelessPersonRecord = new javax.swing.JTable();
        btnNo = new javax.swing.JButton();
        btnSendMail = new javax.swing.JButton();
        txtFieldPickupTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFieldPickupDate = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnYes.setBackground(new java.awt.Color(0, 102, 255));
        btnYes.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnYes.setText("Yes");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Was the person placed at destination Address?");

        backJButton.setBackground(new java.awt.Color(0, 102, 255));
        backJButton.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        backJButton.setText("< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SHELTER FACILITATOR");

        tblHomelessPersonRecord.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        tblHomelessPersonRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Contact No", "Email Address", "Pickup Address", "Destination Address", "Dependents"
            }
        ));
        tblHomelessPersonRecord.setRowHeight(20);
        jScrollPane1.setViewportView(tblHomelessPersonRecord);

        btnNo.setBackground(new java.awt.Color(0, 102, 255));
        btnNo.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        btnSendMail.setBackground(new java.awt.Color(0, 102, 255));
        btnSendMail.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        btnSendMail.setText("Send Mail to person");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        txtFieldPickupTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPickupTimeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Enter Time of Pickup:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Person Details:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Enter Date of Pickup:");

        txtFieldPickupDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPickupDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldPickupTime, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(btnSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldPickupDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldPickupDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldPickupTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed

        if(request.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null,"This request has already been completed by you!");
            return;
        }
        request.setTestResult("Sent to Background Check");
        request.setStatus("Completed");
        request.getShelterAllocWorkReq().setTestResult("Completed by Shelter Facilitator and send to Background Checker");
        UserAccount account = new UserAccount();
        account.setUsername("None");
        request.getShelterAllocWorkReq().setReceiver(account);
        BackgroundCheckWorkRequest bcRequest = new BackgroundCheckWorkRequest();
        bcRequest.setMessage("Check Background");
        bcRequest.setSender(userAccount);
        bcRequest.setStatus("Sent");
        bcRequest.setHomelessPerson(request.getHomelessPerson());
        bcRequest.setShelterAllocWorkReq(request.getShelterAllocWorkReq());
        Date d = new Date();
        bcRequest.setRequestDate(d); 
         Organization org = null;
        for (Network network : business.getNetworkList()) {
        //Step 2.a: check against each enterprise
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof VerificationEnterprise) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof BackgroundCheckOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(bcRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(bcRequest);
            btnSendMail.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Request Sent to Background check");
        }
    }//GEN-LAST:event_btnYesActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ShelterFacilitatorWorkAreaJPanel wp = (ShelterFacilitatorWorkAreaJPanel) component;
        wp.populateReceiveTable();
        wp.populateSentTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        if(request.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null,"This request has already been completed by you!");
            return;
        }
        btnSendMail.setEnabled(false);
        request.getShelterAllocWorkReq().setTestResult("The request has been denied by Shelter Facilitator as he was unable to locate the person!");
        UserAccount account = new UserAccount();
        account.setUsername("None");
        request.getShelterAllocWorkReq().setReceiver(account);
        request.setStatus("Completed");
        JOptionPane.showMessageDialog(this, "Volunteer has been updated!");
    }//GEN-LAST:event_btnNoActionPerformed

    private void txtFieldPickupTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPickupTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPickupTimeActionPerformed

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
        
        final String password = "abcd@1234";
        final String email = "enchantedhomes.publicshelter@gmail.com";
        if(txtFieldPickupTime.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter a pickup Time");
            return;
        }
        if(txtFieldPickupDate.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter a pickup Date");
            return;
        }
        
        
        if(!Datevalidate()) {
            JOptionPane.showMessageDialog(null, "Please enter valid Pickup Date!\n Format: DD/MM/YYYY");
            return;
        }
        
        try {
            if(!DateChecker()) {
                JOptionPane.showMessageDialog(null, "Pickup Date should be a future date");
                return;
            }
        } catch (ParseException ex) {
            System.out.println("Pickup Date threw exception");
        }
        
        if(!timeCompare()) {
            JOptionPane.showMessageDialog(null, "Please enter valid Pickup Time in 24H Format!");
            return;
        }
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {  
//               char[] passwordCharArray = pwdField.getPassword();
//               String pwd= String.valueOf(passwordCharArray);
                return new PasswordAuthentication(email, password);
            }
        });
        
        try 
        {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getHomelessPerson().getEmailAddress()));
            message.setSubject("Public Shelter Allocation");
            String messg = "You will be picked on " + txtFieldPickupDate.getText() + " at " + txtFieldPickupTime.getText() + " and dropped at " + request.getAddressToBePlaced();
            message.setText(messg);

            Transport.send(message);
            btnSendMail.setEnabled(false);
            JOptionPane.showMessageDialog(null,"Email sent!");
            
        } catch (MessagingException e) 
        {
            JOptionPane.showMessageDialog(null,"Your Email address or password is invalid or you need to stop less secure app authentication in your Gmail account!");
            return;
           // throw new RuntimeException(e);
        }

    }//GEN-LAST:event_btnSendMailActionPerformed

    private void txtFieldPickupDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPickupDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPickupDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JButton btnYes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHomelessPersonRecord;
    private javax.swing.JTextField txtFieldPickupDate;
    private javax.swing.JTextField txtFieldPickupTime;
    // End of variables declaration//GEN-END:variables
}
