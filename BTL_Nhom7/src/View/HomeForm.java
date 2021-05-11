/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.Implement.AnswerDAO;
import DAO.Implement.QuestionDAO;
import DAO.Implement.ResultDAO;
import DAO.Implement.TestDAO;
import DAO.Implement.Test_QuestionDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.Result;
import Model.Test;
import Model.Test_Question;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

/**
 *
 * @author mrloc
 */
public class HomeForm extends javax.swing.JFrame {

    int positionX, positionY;
    Account userLogin = null;
    List<Test> listTest = null;
    List<Test_Question> listTest_Question = null;
    ArrayList<Answer> listSelectedAnswer = null;
    Result result = null;
    int QuestionIndex = 0;
    Test chooseTest = null;
    static int minutes, second;
    Thread thread;

    /**
     * Creates new form HomeForm
     */
    public HomeForm() {
        initComponents();
    }

    public HomeForm(Account account) {
        initComponents();
        jLabelUserName.setText(account.getName());
        jScrollPaneListTest.setVisible(false);
        jPanelDoTest.setVisible(false);
        jLabelTime.setVisible(false);
        jScrollButtonQuestion.setVisible(false);
        userLogin = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackGround = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabelWelcome = new javax.swing.JLabel();
        jPanelMove = new javax.swing.JPanel();
        jPanelDashboard = new javax.swing.JPanel();
        jPanelChangePass = new javax.swing.JPanel();
        jLabelChangePassIcon = new javax.swing.JLabel();
        jLabelChangePass = new javax.swing.JLabel();
        jPanelUserName = new javax.swing.JPanel();
        jLabelUserIcon = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jPanelLoadListTest = new javax.swing.JPanel();
        jLabelListTestIcon = new javax.swing.JLabel();
        jLabelListTest = new javax.swing.JLabel();
        jPanelTest = new javax.swing.JPanel();
        jLabelTestIcon = new javax.swing.JLabel();
        jLabelTest = new javax.swing.JLabel();
        jScrollButtonQuestion = new javax.swing.JScrollPane();
        jPanelButtonQuestion = new javax.swing.JPanel();
        jPanelMain = new javax.swing.JPanel();
        jScrollPaneListTest = new javax.swing.JScrollPane();
        jPanelListTest = new javax.swing.JPanel();
        jPanelDoTest = new javax.swing.JPanel();
        jPanelQuestion = new javax.swing.JPanel();
        jPanelListAnswer = new javax.swing.JPanel();
        jPanelControl = new javax.swing.JPanel();
        jButtonSubmit = new javax.swing.JButton();
        jLabelNextArrow = new javax.swing.JLabel();
        jLabelPresArrow = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanelBackGround.setBackground(new java.awt.Color(0, 0, 102));
        jPanelBackGround.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTop.setBackground(new java.awt.Color(0, 51, 153));
        jPanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanelTop.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 44, 44));

        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/mini.png"))); // NOI18N
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseExited(evt);
            }
        });
        jPanelTop.add(jLabelMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 45, 44));

        jLabelTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("00 : 00");
        jPanelTop.add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabelWelcome.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabelWelcome.setForeground(new java.awt.Color(204, 255, 255));
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcome.setText("Welcome !");
        jPanelTop.add(jLabelWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, -1));

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

        javax.swing.GroupLayout jPanelMoveLayout = new javax.swing.GroupLayout(jPanelMove);
        jPanelMove.setLayout(jPanelMoveLayout);
        jPanelMoveLayout.setHorizontalGroup(
            jPanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jPanelMoveLayout.setVerticalGroup(
            jPanelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelTop.add(jPanelMove, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 50));

        jPanelBackGround.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, -1));

        jPanelDashboard.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelChangePass.setBackground(new java.awt.Color(51, 0, 153));
        jPanelChangePass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelChangePassIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChangePassIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/security.png"))); // NOI18N
        jPanelChangePass.add(jLabelChangePassIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabelChangePass.setBackground(new java.awt.Color(255, 255, 255));
        jLabelChangePass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelChangePass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChangePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChangePass.setText("Đổi Mật Khẩu");
        jLabelChangePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelChangePassMousePressed(evt);
            }
        });
        jPanelChangePass.add(jLabelChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 50));

        jPanelDashboard.add(jPanelChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 50));

        jPanelUserName.setBackground(new java.awt.Color(153, 153, 255));
        jPanelUserName.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/human.png"))); // NOI18N
        jPanelUserName.add(jLabelUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabelUserName.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabelUserName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelUserName.add(jLabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 50));

        jPanelDashboard.add(jPanelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 50));

        jPanelLoadListTest.setBackground(new java.awt.Color(51, 0, 153));
        jPanelLoadListTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelListTestIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListTestIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Test.png"))); // NOI18N
        jPanelLoadListTest.add(jLabelListTestIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabelListTest.setBackground(new java.awt.Color(255, 255, 255));
        jLabelListTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelListTest.setForeground(new java.awt.Color(255, 255, 255));
        jLabelListTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListTest.setText("Danh Sách Đề");
        jLabelListTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelListTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelListTestMousePressed(evt);
            }
        });
        jPanelLoadListTest.add(jLabelListTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 50));

        jPanelDashboard.add(jPanelLoadListTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 50));

        jPanelTest.setBackground(new java.awt.Color(51, 0, 153));
        jPanelTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTestIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTestIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/doTest.png"))); // NOI18N
        jPanelTest.add(jLabelTestIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabelTest.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTest.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTest.setText("Làm Bài");
        jLabelTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTestMousePressed(evt);
            }
        });
        jPanelTest.add(jLabelTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 50));

        jPanelDashboard.add(jPanelTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        jScrollButtonQuestion.setBackground(new java.awt.Color(0, 0, 102));
        jScrollButtonQuestion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollButtonQuestion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelButtonQuestion.setBackground(new java.awt.Color(0, 0, 102));
        jPanelButtonQuestion.setLayout(new java.awt.GridLayout(0, 3));
        jScrollButtonQuestion.setViewportView(jPanelButtonQuestion);

        jPanelDashboard.add(jScrollButtonQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 330));

        jPanelBackGround.add(jPanelDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 200, 650));

        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneListTest.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneListTest.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelListTest.setLayout(new java.awt.GridLayout(0, 2));
        jScrollPaneListTest.setViewportView(jPanelListTest);

        jPanelMain.add(jScrollPaneListTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 640));

        jPanelDoTest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelQuestion.setBackground(new java.awt.Color(153, 255, 0));
        jPanelQuestion.setLayout(new java.awt.BorderLayout());
        jPanelDoTest.add(jPanelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 140));

        jPanelListAnswer.setBackground(new java.awt.Color(0, 153, 255));
        jPanelListAnswer.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 10));
        jPanelListAnswer.setLayout(new java.awt.GridLayout(0, 1));
        jPanelDoTest.add(jPanelListAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 840, 410));

        jPanelControl.setBackground(new java.awt.Color(255, 51, 204));

        jButtonSubmit.setBackground(new java.awt.Color(255, 0, 0));
        jButtonSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSubmit.setText("Nộp Bài");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelNextArrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NextArrow.png"))); // NOI18N
        jLabelNextArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelNextArrowMousePressed(evt);
            }
        });

        jLabelPresArrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPresArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PresArrow.png"))); // NOI18N
        jLabelPresArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPresArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelPresArrowMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabelPresArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonSubmit)
                .addGap(33, 33, 33)
                .addComponent(jLabelNextArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPresArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButtonSubmit))
                    .addComponent(jLabelNextArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanelDoTest.add(jPanelControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 840, 80));

        jPanelMain.add(jPanelDoTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 640));

        jPanelBackGround.add(jPanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 840, 640));

        getContentPane().add(jPanelBackGround, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseEntered
        // TODO add your handling code here:
        jLabelExit.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/close_hover.png"))));
    }//GEN-LAST:event_jLabelExitMouseEntered

    private void jLabelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseExited
        // TODO add your handling code here:
        jLabelExit.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))));
    }//GEN-LAST:event_jLabelExitMouseExited

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        // TODO add your handling code here:
        jLabelMinimize.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/mini_hover.png"))));
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        // TODO add your handling code here:
        jLabelMinimize.setIcon((new javax.swing.ImageIcon(getClass().getResource("/Image/mini.png"))));
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thoát chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (input == 0) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            LoginForm f = new LoginForm();
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            f.setVisible(true);
            this.dispose();
            try {
                thread.stop();
            } catch (NullPointerException exep) {
            }
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void loadTime(int minu) {
        minutes = minu;
        second = 0;
        thread = new Thread() {
            @Override
            public void run() {
                while (minutes != -1) {
                    jLabelTime.setText(minutes + " : " + second);
                    if (second == 0) {
                        minutes--;
                        second = 60;
                    }
                    --second;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
                JOptionPane.showMessageDialog(rootPane, "Hết giờ");
                submitResult();
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    private void loadButtonQuestion(List<Answer> list) {
        jPanelButtonQuestion.removeAll();
        jPanelButtonQuestion.revalidate();
        Integer i = 1;
        for (Answer item : list) {
            JButton btn = new JButton(i.toString());
            if (list.get(i - 1).getAnswer_ID() != 0) {
                btn.setBackground(Color.red);
            }
            i++;
            btn.setVisible(true);
            jPanelButtonQuestion.add(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    QuestionIndex = Integer.parseInt(btn.getText()) - 1;
                    loadQuestion();
//                    loadButtonQuestion(list);
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            });
        }
    }

    private void loadQuestion() {
        Test_Question selectedQT = listTest_Question.get(QuestionIndex);
        Question displayQT = new QuestionDAO().findByID(selectedQT.getQuestion_ID());
        JButton btnQuestion = new JButton();
        btnQuestion.setText(displayQT.getQuestion());
        btnQuestion.setFont(new Font(Font.SANS_SERIF, 5, 24));
        btnQuestion.setVisible(true);
        jPanelQuestion.removeAll();
        jPanelQuestion.add(btnQuestion);
        jPanelQuestion.revalidate();
        loadAnswer(displayQT.getQuestion_ID());
    }

    private void loadAnswer(int Question_ID) {
        jPanelListAnswer.removeAll();
        jPanelListAnswer.updateUI();
        List<Answer> listAnswer = new AnswerDAO().getListAnswerByQuestionID(Question_ID);
        Collections.shuffle(listAnswer);
        ButtonGroup groupAnswer = new ButtonGroup();
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        for (Answer item : listAnswer) {                      //Mỗi câu trả lời là 1 radio button cho người dùng chọn
            JRadioButton js = new JRadioButton();
            js.setText("<html>" + item.getAnswer() + "</html>");
            js.setFont(font);
            js.setBorder(new BevelBorder(BevelBorder.LOWERED));
            js.setVisible(true);
            try {
                if (listSelectedAnswer.get(QuestionIndex).getAnswer_ID() == item.getAnswer_ID()) {
                    js.setSelected(true);
                }
            } catch (IndexOutOfBoundsException e) {
            }
            js.addActionListener(new ActionListener() {                     //Mỗi radio button có even chọn sẽ lưu đáp án vào listResult
                @Override
                public void actionPerformed(ActionEvent e) {
                    Answer answerQT = new Answer();
                    answerQT.setAnswer_ID(item.getAnswer_ID());
                    answerQT.setAnswer(item.getAnswer());
                    answerQT.setCorrect(item.isCorrect());
                    answerQT.setQuestion_ID(Question_ID);
                    try {
                        listSelectedAnswer.remove(QuestionIndex);
                        listSelectedAnswer.add(QuestionIndex, answerQT);
                    } catch (IndexOutOfBoundsException oie) {
                        listSelectedAnswer.add(QuestionIndex, answerQT);
                    }
                    loadButtonQuestion(listSelectedAnswer);
                }
            });
            jPanelListAnswer.add(js);
            groupAnswer.add(js);
        }
    }

    private boolean checkTest(int Account_ID, int Test_ID) {
        try {
            return new ResultDAO().findByAccountIDAndTestID(Account_ID, Test_ID) != null;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void submitResult() {
        int Time = chooseTest.getTime() - minutes;              //Lấy thời gian làm bài
        int CorrectQT = listSelectedAnswer.stream().filter(x -> x.isCorrect() == true).collect(Collectors.toList()).size();
        Date now = new Date(new java.util.Date().getTime());
        float Mark = (float)Math.round(CorrectQT*100/listTest_Question.size())/10;
        result = new Result(0, userLogin.getAccount_ID(), chooseTest.getTest_ID(), Time, CorrectQT, now,Mark);
        Integer inserted = new ResultDAO().add(result);          //Kiểu tra insert. Thành công trả về true. Ngược lại false
        try {
            if (inserted != null) {
                jPanelButtonQuestion.removeAll();
                jPanelButtonQuestion.revalidate();
                result = new ResultDAO().findByResultID(inserted);
                seeResult(listSelectedAnswer, result);
                jLabelTime.setVisible(false);
                chooseTest = null;
                listSelectedAnswer = null;
                listTest_Question = null;
                listTest = null;
                jPanelQuestion.removeAll();
                jPanelListAnswer.removeAll();
                jPanelDoTest.setVisible(false);
                jScrollButtonQuestion.setVisible(false);
                resetColor(jPanelTest);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Có lỗi gì đó ! Vui lòng thử lại sau");
        }
    }

    private void seeResult(ArrayList<Answer> listAs, Result resultTest) {
        ResultForm res = new ResultForm(listAs, resultTest);
        res.setLocationRelativeTo(null);
        res.setVisible(true);
        if (thread.getState() == Thread.State.WAITING) {
            thread.stop();
        }
    }

    private void jPanelMoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMoveMousePressed
        // TODO add your handling code here:
        positionX = evt.getX();
        positionY = evt.getY();
    }//GEN-LAST:event_jPanelMoveMousePressed

    private void jPanelMoveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMoveMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getX() + evt.getX() - positionX, this.getY() + evt.getY() - positionY);
    }//GEN-LAST:event_jPanelMoveMouseDragged

    private void jLabelChangePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChangePassMousePressed
        // TODO add your handling code here:
        resetColor(jPanelLoadListTest);
        resetColor(jPanelTest);
        setColor(jPanelChangePass);
        ChangPassForm f = new ChangPassForm(this, true, userLogin);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        resetColor(jPanelChangePass);
    }//GEN-LAST:event_jLabelChangePassMousePressed

    private void jLabelListTestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListTestMousePressed
        // TODO add your handling code here:
        jPanelDoTest.setVisible(false);
        setColor(jPanelLoadListTest);
        resetColor(jPanelChangePass);
        resetColor(jPanelTest);
        jPanelListTest.removeAll();
        jScrollPaneListTest.getVerticalScrollBar().setUnitIncrement(20);
        try {
            listTest.removeAll(listTest);
        } catch (NullPointerException e) {
        }
        listTest = new TestDAO().getFullActiveTest();
        jScrollPaneListTest.setVisible(true);
        for (Test item : listTest) {
            JButton btn = new JButton(item.getTest_Name());
//            btn.setForeground(Color.white);
            btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
            btn.setPreferredSize(new Dimension(250, 100));
            jPanelListTest.add(btn);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkTest(userLogin.getAccount_ID(), item.getTest_ID())) {
                        JOptionPane.showMessageDialog(rootPane, "Tài khoản của bạn đã làm đề này rồi ! Liên hệ giáo viên để làm lại !");
                        return;
                    }
                    if (chooseTest != null) {
                        JOptionPane.showMessageDialog(rootPane, "Hãy hoàn thành đề đã chọn trước khi làm đề mới");
                        return;
                    }
                    if (listTest_Question != null) {
                        listTest_Question.removeAll(listTest_Question);
                    }
                    listTest_Question = new Test_QuestionDAO().findByTestID(item.getTest_ID());
                    Collections.shuffle(listTest_Question);
                    if (listTest_Question.isEmpty()) {                    //Nếu danh sách câu hỏi có size = 0 => Thông báo và return
                        JOptionPane.showMessageDialog(rootPane, item.getTest_Name().trim() + " không có câu hỏi nào");
                        return;
                    }
                    QuestionIndex = 0;
                    listSelectedAnswer = new ArrayList<>();
                    for (int i = 0; i < listTest_Question.size(); i++) {
                        Answer answer = new Answer();
                        answer.setQuestion_ID(listTest_Question.get(i).getQuestion_ID());
                        listSelectedAnswer.add(answer);
                    }
                    chooseTest = item;
                    loadTime(item.getTime());
                    loadButtonQuestion(listSelectedAnswer);
                    jLabelTime.setVisible(true);
                    jScrollPaneListTest.setVisible(false);
                    jPanelDoTest.setVisible(true);
                    jScrollButtonQuestion.setVisible(true);
                    resetColor(jPanelLoadListTest);
                    setColor(jPanelTest);
                    loadQuestion();
                }
            });
        }
    }//GEN-LAST:event_jLabelListTestMousePressed

    private void jLabelTestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTestMousePressed
        // TODO add your handling code here:
        resetColor(jPanelLoadListTest);
        resetColor(jPanelChangePass);
        setColor(jPanelTest);
        jScrollPaneListTest.setVisible(false);
        jPanelDoTest.setVisible(true);
    }//GEN-LAST:event_jLabelTestMousePressed

    private void jLabelPresArrowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPresArrowMousePressed
        // TODO add your handling code here:
        Test_Question tq = null;
        try {
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn đề trước khi làm bài");
            return;
        }
        try {
            QuestionIndex--;
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Đã hết câu hỏi");
            QuestionIndex++;
            return;
        }
        loadQuestion();
    }//GEN-LAST:event_jLabelPresArrowMousePressed

    private void jLabelNextArrowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextArrowMousePressed
        // TODO add your handling code here:
        Test_Question tq = null;
        try {
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn đề trước khi làm bài");
            return;
        }
        try {
            QuestionIndex++;
            tq = listTest_Question.get(QuestionIndex);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Đã hết câu hỏi");
            QuestionIndex--;
            return;
        }
        loadQuestion();
    }//GEN-LAST:event_jLabelNextArrowMousePressed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        try {
            if (chooseTest == null) {
                throw new NullPointerException();
            }
            int chose = JOptionPane.showConfirmDialog(rootPane, "Bạn đã chắc chắn nộp bài chưa?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if (chose == JOptionPane.OK_OPTION) {
                submitResult();
                thread.stop();
            } else {
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn đề và làm trước khi nộp bài");
            return;
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void setColor(JPanel jpanel) {
        jpanel.setBackground(new Color(153, 153, 255));
    }

    private void resetColor(JPanel jpanel) {
        jpanel.setBackground(new Color(51, 0, 153));
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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeForm f = new HomeForm();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelChangePass;
    private javax.swing.JLabel jLabelChangePassIcon;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelListTest;
    private javax.swing.JLabel jLabelListTestIcon;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelNextArrow;
    private javax.swing.JLabel jLabelPresArrow;
    private javax.swing.JLabel jLabelTest;
    private javax.swing.JLabel jLabelTestIcon;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JLabel jLabelUserIcon;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JPanel jPanelBackGround;
    private javax.swing.JPanel jPanelButtonQuestion;
    private javax.swing.JPanel jPanelChangePass;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelDoTest;
    private javax.swing.JPanel jPanelListAnswer;
    private javax.swing.JPanel jPanelListTest;
    private javax.swing.JPanel jPanelLoadListTest;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMove;
    private javax.swing.JPanel jPanelQuestion;
    private javax.swing.JPanel jPanelTest;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JPanel jPanelUserName;
    private javax.swing.JScrollPane jScrollButtonQuestion;
    private javax.swing.JScrollPane jScrollPaneListTest;
    // End of variables declaration//GEN-END:variables
}
