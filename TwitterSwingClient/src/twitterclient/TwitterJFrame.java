/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TwitterJFrame.java
 *
 * Created on 01.04.2010, 13:41:15
 */
package twitterclient;

import java.awt.Color;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import org.netbeans.saas.twitter.TwitterWhatAreYouDoingService;
import org.netbeans.saas.RestResponse;
import twitter.whatareyoudoingservice.twitterresponse.StatusType;
import twitter.whatareyoudoingservice.twitterresponse.UserType;
import twitterclient.utils.*;

/**
 *
 * @author viktor
 */
public class TwitterJFrame extends javax.swing.JFrame {

    private DefaultListModel statuses = new DefaultListModel();
    private final int MAX_INPUT_LENGTH  = 140;

    /** Creates new form TwitterJFrame */
    public TwitterJFrame() {

        this.setLocationRelativeTo(null);
     
        initComponents();
        setProxy();
        initUserInfo();
        getTwitsFromTwitter();        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonUpdate = new javax.swing.JButton();
        jLabelUserIcon = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabelTextLength = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple twitter RESTfull client");
        setResizable(false);

        jButtonUpdate.setText("Update");
        jButtonUpdate.setName("btnUpdate"); // NOI18N
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jLabelUserIcon.setLabelFor(jTextFieldStatus);
        jLabelUserIcon.setText("Icon");
        jLabelUserIcon.setPreferredSize(new java.awt.Dimension(48, 48));

        jTextFieldStatus.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldStatus.setText("Status");
        jTextFieldStatus.setNextFocusableComponent(jButtonUpdate);
        jTextFieldStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldStatusKeyTyped(evt);
            }
        });

        jList1.setModel(statuses);
        jList1.setCellRenderer(new Item());
        jScrollPane1.setViewportView(jList1);

        jLabelTextLength.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTextLength.setText("140");
        jLabelTextLength.setName("lblTextCount"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTextLength, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTextLength, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed

        try {

            String status = jTextFieldStatus.getText().trim();
            String inReplyToStatusId = null;
            String format1 = "xml";

            RestResponse result1 = TwitterWhatAreYouDoingService.updateStatus(status, inReplyToStatusId, format1);
            if (result1.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.StatusType.class) instanceof twitter.whatareyoudoingservice.twitterresponse.StatusType) {
                twitter.whatareyoudoingservice.twitterresponse.StatusType result1Obj = result1.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.StatusType.class);
            } else if (result1.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.NilClasses) {
                twitter.whatareyoudoingservice.twitterresponse.NilClasses result1Obj = result1.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class);
            }
            //TODO - Uncomment the print Statement below to print result.
            //System.out.println("The SaasService returned: "+result1.getDataAsString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed
    
    private void jTextFieldStatusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStatusKeyTyped

        jLabelTextLength.setText(String.valueOf(MAX_INPUT_LENGTH-jTextFieldStatus.getText().length()));
        if (  (MAX_INPUT_LENGTH - jTextFieldStatus.getText().length()) < 0 ) {            
            jLabelTextLength.setForeground(new java.awt.Color(204, 0, 0));
            jButtonUpdate.setEnabled(false);
        } else {
            jLabelTextLength.setForeground(new java.awt.Color(0, 0, 204));
            jButtonUpdate.setEnabled(true);
        }
        
    }//GEN-LAST:event_jTextFieldStatusKeyTyped

    /**
     *
     */
    private void setProxy() {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("proxyPort", "3128");
        System.getProperties().put("proxyHost", "10.8.1.6");
    }

    /**
     * Initializing user information
     */
    private void initUserInfo() {

        try {
            String since = null;
            String sinceId = null;
            String page = null;
            String count = "1";
            String format = "xml";

            RestResponse result = TwitterWhatAreYouDoingService.getUserTimeline(since, sinceId, page, count, format);
            if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.Statuses) {
                twitter.whatareyoudoingservice.twitterresponse.Statuses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class);
            } else if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.NilClasses) {
                twitter.whatareyoudoingservice.twitterresponse.NilClasses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class);
            }

            if (result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.Statuses) {

                twitter.whatareyoudoingservice.twitterresponse.Statuses resultObj = result.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class);

                StatusType st = resultObj.getStatus().get(0);
                jTextFieldStatus.setText(st.getText().trim());
                UserType user = st.getUser();
                String iconSrc = user.getProfileImageUrl();
                URL iconUrl = new URL(iconSrc);
                ImageIcon icon = new ImageIcon(iconUrl, user.getScreenName());
                jLabelUserIcon.setIcon(icon);

            }

            //System.out.println("The SaasService returned: "+result.getDataAsString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class MyTime extends TimerTask {

        @Override
        public void run() {

        try {
                String since2 = null;
                String sinceId1 = null;
                String page1 = null;
                String count1 = "10";
                String format2 = "xml";

                RestResponse result2 = TwitterWhatAreYouDoingService.getFriendsTimeline(since2, sinceId1, page1, count1, format2);
                if (result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.Statuses) {
                    twitter.whatareyoudoingservice.twitterresponse.Statuses result2Obj = result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class);
                } else if (result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.NilClasses) {
                    twitter.whatareyoudoingservice.twitterresponse.NilClasses result2Obj = result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.NilClasses.class);
                }


                if (result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class) instanceof twitter.whatareyoudoingservice.twitterresponse.Statuses) {

                        twitter.whatareyoudoingservice.twitterresponse.Statuses result2Obj = result2.getDataAsObject(twitter.whatareyoudoingservice.twitterresponse.Statuses.class);
                        statuses.clear();
                        for (final StatusType st : result2Obj.getStatus()) {
                                  SwingUtilities.invokeLater(new Runnable() {

                                      public void run() {
                                               statuses.addElement(st);
                                      }
                                  });
                         }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     *  Getting twits from twitter.
     */
    private void getTwitsFromTwitter() {

        Timer t = new Timer("Twitter Updater", false);
        t.scheduleAtFixedRate(new MyTime(), 1500, 75000);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TwitterJFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelTextLength;
    private javax.swing.JLabel jLabelUserIcon;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
