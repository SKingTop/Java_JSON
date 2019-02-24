package JSON_Karaev;

/**
 * @author SABIT_KARAEV
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class Frame_1 extends javax.swing.JFrame {

    public Frame_1() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GIT HUB USERINFORMATION");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setMaximumSize(new java.awt.Dimension(682, 487));
        setMinimumSize(new java.awt.Dimension(682, 487));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(40, 60, 830, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Введите имя пользователя");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 20, 990, 30);

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Найти");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(880, 60, 180, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Подписки пользователя");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 110, 280, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Подписчики пользователя");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 110, 300, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Репрозитории пользователя");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 370, 600, 17);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 140, 480, 210);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(580, 140, 480, 210);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(40, 410, 1020, 270);

        setSize(new java.awt.Dimension(1104, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String profile= jTextField1.getText(); //Поля для ввода логина на Git
        String followers = "https://api.github.com/users/"+profile+"/followers"; // Адрес получения JSON - данных
        String json_followers = getHTMLData(followers);
        String following = "https://api.github.com/users/"+profile+"/following"; // Адрес получения JSON - данных
        String json_following = getHTMLData(followers);
        String repos = "https://api.github.com/users/"+profile+"/repos"; // Адрес получения JSON - данных
        String json_repos = getHTMLData(repos);
        StringBuilder subscribe = new StringBuilder("Подписчики пользователя "+profile+":\n \n");
        if (json_followers != null) {
            JSONArray _root = null;
            try {
                  _root = new JSONArray(json_followers);
                  for(int i = 0;i<_root.length();i++ ){
                      JSONObject user = _root.getJSONObject(i);
                      String login = user.getString("login");
                      String html_url = user.getString("html_url");
                      subscribe.append(i+1 +") Логин: "+login+"\n");
                      subscribe.append("Ссылка на профиль: "+html_url+"\n \n");
                  }
                jTextArea1.setText(subscribe.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка код: 1!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        }
        StringBuilder follow = new StringBuilder("Подписки пользователя "+profile+":\n \n");
        if (json_following != null) {
            JSONArray _root = null;
            try {
                  _root = new JSONArray(json_following);
                  for(int i = 0;i<_root.length();i++ ){
                      JSONObject user = _root.getJSONObject(i);
                      String login = user.getString("login");
                      String html_url = user.getString("html_url");
                      follow.append(i+1 +") Логин: "+login+"\n");
                      follow.append("Ссылка на профиль: "+html_url+"\n \n");
                  }
                jTextArea2.setText(follow.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка код: 2!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        } 
        StringBuilder repository = new StringBuilder("Репрозитории пользователя "+profile+":\n \n");
        if (json_repos != null) {
            JSONArray _root = null;
            try {
                  _root = new JSONArray(json_repos);
                  for(int i = 0;i<_root.length();i++ ){
                      JSONObject user = _root.getJSONObject(i);
                      String name = user.getString("name");
                      String html_url = user.getString("html_url");
                      String created_at = user.getString("created_at");
                      String updated_at = user.getString("updated_at");
                      repository.append(i+1 +") Имя репрозитория: "+name+"\n");
                      repository.append("Ссылка на репрозиторий: "+html_url+"\n");
                      repository.append("Дата создания: "+created_at+"\n");
                      repository.append("Последнее обновление: "+updated_at+"\n \n");
                  }
                jTextArea3.setText(repository.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка код: 3!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Метод чтения данных с сети по протоколу HTTP
    public static String getHTMLData(String url) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            int response = connection.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                StringBuilder data = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        data.append(line);
                    }
                } catch (IOException e) {
                }
                return data.toString();
            } else {
                return null;
            }
        } catch (IOException ignored) {
        } finally {
            connection.disconnect();
        }
        return null;
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
