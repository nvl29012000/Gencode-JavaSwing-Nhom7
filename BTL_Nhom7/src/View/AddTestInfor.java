/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DatabaseIO.ChapterDAO;
import DatabaseIO.LessonDAO;
import DatabaseIO.LevelDAO;
import DatabaseIO.QuestionDAO;
import DatabaseIO.TestDAO;
import DatabaseIO.Test_QuestionDAO;
import Model.Chapter;
import Model.Lesson;
import Model.Level;
import Model.Question;
import Model.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author BINHBILL
 */
public class AddTestInfor extends javax.swing.JDialog {

    static boolean isClose;
    public AddTestInfor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    AddTestInfor() {
        isClose = false;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxDifficult = new javax.swing.JComboBox();
        jTextFieldCodeTest = new javax.swing.JTextField();
        jTextFieldTimeTest = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxChapter = new javax.swing.JComboBox();
        jComboBoxLesson = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAmountQuestion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonRandomTest = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm Đề");
        setForeground(new java.awt.Color(240, 240, 240));
        setIconImage(null);
        setPreferredSize(new java.awt.Dimension(783, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setMinimumSize(new java.awt.Dimension(743, 225));

        jPanel2.setName("Thêm đề"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mã đề");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Thời gian(phút)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Độ khó");

        jComboBoxDifficult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCodeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTimeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxDifficult, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDifficult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodeTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTimeTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Chương");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Bài");

        jComboBoxChapter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxChapter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxChapterItemStateChanged(evt);
            }
        });

        jComboBoxLesson.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Số câu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxLesson, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldAmountQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jComboBoxLesson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldAmountQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBoxChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jButtonRandomTest.setText("Tạo ngẫu nhiên");
        jButtonRandomTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRandomTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jButtonRandomTest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonRandomTest)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRandomTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandomTestActionPerformed
        addTest();
        isClose = true;
        
    }//GEN-LAST:event_jButtonRandomTestActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadData();
    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxChapterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxChapterItemStateChanged
        loadCbbLesson();
    }//GEN-LAST:event_jComboBoxChapterItemStateChanged
    void addTest(){
        try {
            TestDAO testDAO = new TestDAO();
            String testCode = jTextFieldCodeTest.getText();
            int numberQuestion = Integer.parseInt(jTextFieldAmountQuestion.getText());        
            int time = Integer.parseInt(jTextFieldTimeTest.getText());
            
            int chapter = jComboBoxChapter.getSelectedIndex()+1;
            int lesson = jComboBoxLesson.getSelectedIndex()+1;
            int level = jComboBoxDifficult.getSelectedIndex();
            
            ArrayList<String> testCodeList = new ArrayList<String>();
            List<Test> listTest = testDAO.getFullListTest();
            for(Test t :listTest)
                testCodeList.add(t.getTest_Name().trim());
            
            if(testCode.compareToIgnoreCase("")==0)
                throw new Exception("Mã đề không được để trống !!!");
            if(testCodeList.contains(testCode))
                throw new Exception("Mã đề đã tồn tại !!!");
            if(time<=0)
                throw new Exception("Thời gian phải lớn hơn 0 !!!");
            if(numberQuestion<=0)
                throw new Exception("Số câu hỏi lớn hơn 0 !!!");
            
            
            Test t = new Test(testCode, time, level+1, true);
            if(testDAO.insertTest(t)){
                ArrayList<Integer> questions = calculatorAmountQuestion(numberQuestion);
                addQuestionByLevel(questions,chapter,lesson,level);
                int chose = JOptionPane.showConfirmDialog(rootPane, "Thêm thành công. Bạn đã muốn thêm đề tiếp không?","Thông báo", JOptionPane.YES_NO_OPTION);
                if (chose == 1) {     
                    this.dispose();
                }
                else
                    clearBox();
            }
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane,("Sai định dạng nhập!!!"));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    void addTestQuestion(int idQuestion){
        Test_QuestionDAO tqDao = new Test_QuestionDAO();
        TestDAO testDAO = new TestDAO();
        int idTestPre = testDAO.getMaxIdTest();//get new id Test by get max of idTest

        tqDao.insertTestQuestion(idTestPre, idQuestion);
    }
    void addTestQuestionRandom(int amountRandom, int chapter, int lesson, int level)throws Exception{//By Level

            QuestionDAO questionDAO = new QuestionDAO();
            List<Question> listAdded = new ArrayList<Question>();
            List<Question> listQuestions = questionDAO.getQuestionstByChapterLessonLevel(chapter,lesson,level);
            
            if(amountRandom>listQuestions.size()){
                deleteTestById();
                throw new Exception("Không đủ câu hỏi để tạo đề!!!");
            }
            int minRange=questionDAO.getMinIdQuestion(level);
            int maxRange=questionDAO.getMaxIdQuestion(level);
            do{
                Random r = new Random();
                int idQuest = minRange+ r.nextInt(maxRange-minRange+1);//just has random from 0 :V
                Question q = new Question();
                    q.setQuestion_ID(idQuest);
                if(!listAdded.contains(q)&&listQuestions.contains(q)){//trường hợp trong khoảng từ 1-20 có lẫn lộn 3 độ khó
                    listAdded.add(q);
                    addTestQuestion(idQuest);
                }
            }
            while(listAdded.size()<amountRandom);
 
    }
    void loadData(){
        jPanel2.setBorder(BorderFactory.createTitledBorder("Đề"));
        jPanel3.setBorder(BorderFactory.createTitledBorder("Giới hạn"));
        jPanel4.setBorder(BorderFactory.createTitledBorder("Chức năng"));
        
        LevelDAO levelDao = new LevelDAO();
        ArrayList<Level> levelList = levelDao.getListLevel();
        for(Level lv:levelList)
            jComboBoxDifficult.addItem(lv.getLevel_Name());
        
        ChapterDAO chapterDao = new ChapterDAO();
        ArrayList<Chapter> chapterList = chapterDao.getFullListChapter();
        for(Chapter ch:chapterList)
            jComboBoxChapter.addItem(ch.getChapter());
        
        loadCbbLesson();
    }
    void loadCbbLesson(){
        LessonDAO lessonDao = new LessonDAO();
        jComboBoxLesson.removeAllItems();
        Integer chap = (Integer)jComboBoxChapter.getSelectedItem();
        ArrayList<Lesson> lessonList = lessonDao.getFullListLessonByChapter(chap);
        for(Lesson ls:lessonList)
            jComboBoxLesson.addItem(ls.getLesson());
        
    }
    ArrayList<Integer> calculatorAmountQuestion(int totalQuestion){
        ArrayList<Integer> question = new ArrayList<Integer>();//defaul easy
        int level1 = (int)(totalQuestion*0.5);
        int level2 = (int)(totalQuestion*0.3);
        int level3 = totalQuestion-level1-level2;
        question.add(level1);
        question.add(level2);
        question.add(level3);
        return question;
    }
    void addQuestionByLevel(ArrayList<Integer> questions, int chapter, int lesson,int level) throws Exception{
            switch(level){
                case 0://Dễ
                    addTestQuestionRandom(questions.get(0),chapter,lesson,1);
                    addTestQuestionRandom(questions.get(1),chapter,lesson,2);
                    addTestQuestionRandom(questions.get(2),chapter,lesson,3);
                    break;
                case 1://TB
                    addTestQuestionRandom(questions.get(0),chapter,lesson,2);
                    addTestQuestionRandom(questions.get(1),chapter,lesson,1);
                    addTestQuestionRandom(questions.get(2),chapter,lesson,3);
                    break;
                case 2://Khó
                    addTestQuestionRandom(questions.get(0),chapter,lesson,3);
                    addTestQuestionRandom(questions.get(1),chapter,lesson,2);
                    addTestQuestionRandom(questions.get(2),chapter,lesson,1);
                    break;
            }     
    }
    boolean deleteTestById(){
        TestDAO testDAO = new TestDAO();
        int idTestPre = testDAO.getMaxIdTest();//get new id Test by get max of idTest      
        return testDAO.deleteTestById(idTestPre);
    }
    void clearBox(){
        jTextFieldAmountQuestion.setText("");
        jTextFieldCodeTest.setText("");
        jTextFieldTimeTest.setText("");
        
        jComboBoxChapter.setSelectedIndex(0);
        jComboBoxDifficult.setSelectedIndex(0);
        jComboBoxLesson.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(AddTestInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTestInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTestInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTestInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddTestInfor dialog = new AddTestInfor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonRandomTest;
    private javax.swing.JComboBox jComboBoxChapter;
    private javax.swing.JComboBox jComboBoxDifficult;
    private javax.swing.JComboBox jComboBoxLesson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldAmountQuestion;
    private javax.swing.JTextField jTextFieldCodeTest;
    private javax.swing.JTextField jTextFieldTimeTest;
    // End of variables declaration//GEN-END:variables
}
