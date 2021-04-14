package View;

import Model.Answer;
import Model.Question;

/**
 *
 * @author ADMIN
 */
public class ViewAnswerJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ViewAnswerJDialog
     */
    public ViewAnswerJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    // lấy dữ liệu cũ của câu trả lời và hiển thị ra
    public void getOldAnswerData(Question q, Answer asw1, Answer asw2, Answer asw3, Answer asw4){
        txtAreaQuestion.setText(q.getQuestion());
        txtAreaAns1.setText(asw1.getAnswer());
        rdbTrue1.setSelected(asw1.isCorrect());
        txtAreaAns2.setText(asw2.getAnswer());
        rdbTrue2.setSelected(asw2.isCorrect());
        txtAreaAns3.setText(asw3.getAnswer());
        rdbTrue3.setSelected(asw3.isCorrect());
        txtAreaAns4.setText(asw4.getAnswer());
        rdbTrue4.setSelected(asw4.isCorrect());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jRadioButton2 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaAns1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaAns2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaAns3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaAns4 = new javax.swing.JTextArea();
        rdbTrue4 = new javax.swing.JRadioButton();
        rdbTrue3 = new javax.swing.JRadioButton();
        rdbTrue2 = new javax.swing.JRadioButton();
        rdbTrue1 = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAreaQuestion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jRadioButton2.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xem câu trả lời");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách câu trả lời");

        jLabel2.setText("Đáp án 1:");

        jLabel4.setText("Đáp án 2:");

        jLabel5.setText("Đáp án 3:");

        jLabel6.setText("Đáp án 4:");

        txtAreaAns1.setEditable(false);
        txtAreaAns1.setBackground(new java.awt.Color(240, 240, 240));
        txtAreaAns1.setColumns(20);
        txtAreaAns1.setLineWrap(true);
        txtAreaAns1.setRows(5);
        txtAreaAns1.setBorder(null);
        txtAreaAns1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaAns1.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaAns1);

        txtAreaAns2.setEditable(false);
        txtAreaAns2.setBackground(new java.awt.Color(240, 240, 240));
        txtAreaAns2.setColumns(20);
        txtAreaAns2.setLineWrap(true);
        txtAreaAns2.setRows(5);
        txtAreaAns2.setBorder(null);
        txtAreaAns2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaAns2.setEnabled(false);
        jScrollPane3.setViewportView(txtAreaAns2);

        txtAreaAns3.setEditable(false);
        txtAreaAns3.setBackground(new java.awt.Color(240, 240, 240));
        txtAreaAns3.setColumns(20);
        txtAreaAns3.setLineWrap(true);
        txtAreaAns3.setRows(5);
        txtAreaAns3.setBorder(null);
        txtAreaAns3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaAns3.setEnabled(false);
        jScrollPane4.setViewportView(txtAreaAns3);

        txtAreaAns4.setEditable(false);
        txtAreaAns4.setBackground(new java.awt.Color(240, 240, 240));
        txtAreaAns4.setColumns(20);
        txtAreaAns4.setLineWrap(true);
        txtAreaAns4.setRows(5);
        txtAreaAns4.setBorder(null);
        txtAreaAns4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaAns4.setEnabled(false);
        jScrollPane5.setViewportView(txtAreaAns4);

        buttonGroup1.add(rdbTrue4);
        rdbTrue4.setText("Đáp án đúng");
        rdbTrue4.setDoubleBuffered(true);
        rdbTrue4.setEnabled(false);

        buttonGroup1.add(rdbTrue3);
        rdbTrue3.setText("Đáp án đúng");
        rdbTrue3.setDoubleBuffered(true);
        rdbTrue3.setEnabled(false);

        buttonGroup1.add(rdbTrue2);
        rdbTrue2.setText("Đáp án đúng");
        rdbTrue2.setDoubleBuffered(true);
        rdbTrue2.setEnabled(false);

        buttonGroup1.add(rdbTrue1);
        rdbTrue1.setText("Đáp án đúng");
        rdbTrue1.setDoubleBuffered(true);
        rdbTrue1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbTrue4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTrue4))
                .addContainerGap())
        );

        txtAreaQuestion.setEditable(false);
        txtAreaQuestion.setColumns(20);
        txtAreaQuestion.setLineWrap(true);
        txtAreaQuestion.setRows(5);
        txtAreaQuestion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaQuestion.setEnabled(false);
        jScrollPane7.setViewportView(txtAreaQuestion);

        jLabel7.setText("Câu hỏi:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewAnswerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAnswerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAnswerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAnswerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewAnswerJDialog dialog = new ViewAnswerJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JRadioButton rdbTrue1;
    private javax.swing.JRadioButton rdbTrue2;
    private javax.swing.JRadioButton rdbTrue3;
    private javax.swing.JRadioButton rdbTrue4;
    private javax.swing.JTextArea txtAreaAns1;
    private javax.swing.JTextArea txtAreaAns2;
    private javax.swing.JTextArea txtAreaAns3;
    private javax.swing.JTextArea txtAreaAns4;
    private javax.swing.JTextArea txtAreaQuestion;
    // End of variables declaration//GEN-END:variables
}
