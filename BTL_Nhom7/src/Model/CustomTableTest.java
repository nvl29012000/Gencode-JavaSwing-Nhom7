/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author BINHBILL
 */
public class CustomTableTest extends AbstractTableModel {

    private String header[] = {"ID đề", "Mô tả đề","Thời gian", "Độ khó", "Trạng thái"};
    private Class classes[] = {Integer.class, String.class, Integer.class, Integer.class, String.class};
    private ArrayList<Test> testList = new ArrayList<Test>();

    public CustomTableTest(ArrayList<Test> fullTest) {
        this.testList = fullTest;
    }

    @Override
    public int getRowCount() {
        return testList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return testList.get(rowIndex).getTest_ID();
            case 1:
                return testList.get(rowIndex).getTest_Name();
            case 2:
                return testList.get(rowIndex).getTime();
            case 3:
                switch (testList.get(rowIndex).getLevel()) {
                    case 1:
                        return "Dễ";
                    case 2:
                        return "TB";
                    case 3:
                        return "Khó";
                }
            case 4:
                if(testList.get(rowIndex).isStatus())
                    return "Hoạt động";
                else
                    return "Vô hiệu hóa";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
