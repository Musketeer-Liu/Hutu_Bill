package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel implements TableModel {
    String[] columnNames = new String[]{"分类名称","消费次数"};
//    // 模拟数据 List<String>
//    List<String> cs = new ArrayList<>();
//
//    public CategoryTableModel() {
//        cs.add("餐饮");
//        cs.add("交通");
//        cs.add("住宿");
//        cs.add("花费");
//    }

    // 从数据库里读取数据 List<Category>
    public List<Category> cs = new CategoryService().list();

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // 从数据库里读取数据
        // 先通过 cs.get(rowIndex)获取行对应的 Category 对象 然后根据 columnIndex 返回对应的属性
        Category h = cs.get(rowIndex);
        if (0 == columnIndex) {
            return h.name;
        }
        if (1 == columnIndex) {
            return h.recordNumber;
        }
        return null;

//        // 模拟数据
//        if (0 == columnIndex) {
//            return cs.get(rowIndex);
//        }
//        if (1 == columnIndex) {
//            return 0;
//        }
//        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
