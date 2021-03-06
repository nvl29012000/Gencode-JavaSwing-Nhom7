/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.Implement.ChapterDAO;
import Model.Chapter;
import javax.swing.JOptionPane;

/**
 *
 * @author mrloc
 */
public class AddAndEditChapterForm extends javax.swing.JDialog {

    /**
     * Creates new form AddAndEditChapterForm
     */
    int positionX, positionY;       //Cái này để di chuyển form thôi đừng quan tâm
    SubjectPanel panelparent;       //Cái này để lấy cái panel cha của nó. Để load lại data sau khi thêm ý mà
    Chapter edit;                   //Cái này là cái lưu cái chapter m sửa
    ChapterDAO chapterDAO = new ChapterDAO();

    /**
     * Creates new form AddAndEditChapterForm
     *
     * @param parent
     * @param modal
     */
    //Không dùng constructor mặc định đâu. Đừng quan tâm
    public AddAndEditChapterForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //Constructor này dùng cho việc thêm. Có cái javax.swing.JPanel panel chính là cái panel cha truyền vào khi khởi tạo
    public AddAndEditChapterForm(java.awt.Frame parent, boolean modal, javax.swing.JPanel panel) {
        super(parent, modal);
        initComponents();
        panelparent = (SubjectPanel) panel;         //Gán cái panel cha
        jButtonEdit.setVisible(false);              //Vì là thêm nên nút sửa và title Sửa sẽ được ẩn
        jLabelTitle1.setVisible(false);
    }
    //Constructor này dùng cho việc sửa. Cái Chapter ct chính là cái chapter cần sửa
    public AddAndEditChapterForm(java.awt.Frame parent, boolean modal, Chapter ct) {
        super(parent, modal);
        initComponents();
        edit = ct;              //Gán cái cần sửa cho cái edit khai báo ở trên đầu ý
        jTextChapter.setText(ct.getChapter() + "");         //load lại dữ liệu cũ của chapter sửa và textbox
        jTextChapterName.setText(ct.getChapter_Name());
        jButtonAdd.setVisible(false);           //ẩn cái nút thêm với title thêm đi. À ko cho sửa số chương đâu. Sửa tên thôi
        jLabelTitle.setVisible(false);
        jTextChapter.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jPanelMove = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelChapter = new javax.swing.JLabel();
        jTextChapter = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelChapterName = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jTextChapterName = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jLabelTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTop.setBackground(new java.awt.Color(0, 51, 153));
        jPanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMove.setBackground(new java.awt.Color(0, 51, 153));
        jPanelMove.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelMoveMouseDragged(evt);
            }
        });
        jPanelMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMoveMousePressed(evt);
            }
        });

        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelMoveLayout = new javax.swing.GroupLayout(jPanelMove);
        jPanelMove.setLayout(jPanelMoveLayout);
        jPanelMoveLayout.setHorizontalGroup(
            jPanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMoveLayout.createSequentialGroup()
                .addGap(0, 386, Short.MAX_VALUE)
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMoveLayout.setVerticalGroup(
            jPanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMoveLayout.createSequentialGroup()
                .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanelTop.add(jPanelMove, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jPanel1.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 436, 42));

        jLabelTitle.setFont(new java.awt.Font("Minion Pro", 1, 36)); // NOI18N
        jLabelTitle.setText("Thêm chương");
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabelChapter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelChapter.setText("Chương số :");
        jPanel1.add(jLabelChapter, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 139, -1, -1));

        jTextChapter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextChapter.setBorder(null);
        jPanel1.add(jTextChapter, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 139, 206, -1));

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAdd.setText("Thêm mới");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 278, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 162, 206, 10));

        jLabelChapterName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelChapterName.setText("Tên chương :");
        jPanel1.add(jLabelChapterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 199, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 222, 206, 10));

        jTextChapterName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextChapterName.setBorder(null);
        jPanel1.add(jTextChapterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 199, 206, -1));

        jButtonEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEdit.setText("Cập nhật");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 278, -1, -1));

        jLabelTitle1.setFont(new java.awt.Font("Minion Pro", 1, 36)); // NOI18N
        jLabelTitle1.setText("Sửa chương");
        jPanel1.add(jLabelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        // TODO add your handling code here:
        jLabelExit.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/close_hover.png"))));
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        // TODO add your handling code here:
        jLabelExit.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jPanelMoveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMoveMouseDragged

        // TODO add your handling code here:
        this.setLocation(this.getX() + evt.getX() - positionX, this.getY() + evt.getY() - positionY);
    }//GEN-LAST:event_jPanelMoveMouseDragged

    private void jPanelMoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMoveMousePressed
        // TODO add your handling code here:
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanelMoveMousePressed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        do {
            try {
                int chapter;
                try {
                    chapter = Integer.parseInt(jTextChapter.getText());   
                    if (chapter < 1) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    throw new Exception("Sai định dạng chương");
                }
                if (chapterDAO.findByChapter(chapter) != null) {       
                    throw new Exception("Chương " + chapter + " đã tồn tại");
                }
                String chapterName = jTextChapterName.getText();   
                if (chapterName.trim().equals("")) {     
                    throw new Exception("Tên chương không được để trống");
                }
                Chapter inserted = chapterDAO.add(new Chapter(0, chapter, chapterName));
                panelparent.loadData();
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn tiếp tục thêm không ?", "", JOptionPane.YES_NO_OPTION) 
                        == JOptionPane.NO_OPTION) {
                    this.dispose();
                    break;
                } else {
                    clear();
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
                return;
            }
        } while (true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        try {
            String chapterName = jTextChapterName.getText();
            if (chapterName.trim().equals("")) {
                throw new Exception("Tên chương không được để trống");
            }//Hàm update trả về true hoặc false. Nếu update thanh công thì đóng form. Ngc lại báo lỗi
            Boolean isUpdated = chapterDAO.updateChapterNameByID(new Chapter(edit.getChapter_ID(), edit.getChapter(), chapterName));
            if(isUpdated){
                //Có thể thêm thông báo thành công nếu muốn
                this.dispose();
            }else{
                throw new Exception("Lỗi ! Cập nhật không thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            return;
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void clear() {
        jTextChapter.setText("");
        jTextChapterName.setText("");
        jTextChapter.requestFocus();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAndEditChapterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAndEditChapterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAndEditChapterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAndEditChapterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAndEditChapterForm dialog = new AddAndEditChapterForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabelChapter;
    private javax.swing.JLabel jLabelChapterName;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMove;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextChapter;
    private javax.swing.JTextField jTextChapterName;
    // End of variables declaration//GEN-END:variables
}
