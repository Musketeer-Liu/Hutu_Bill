package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    // 由数据库读取 Category 实时信息
    public List<Category> cs = new CategoryService().list();
    public Category c;
    public CategoryComboBoxModel() {
        if (!cs.isEmpty()) {
            c = cs.get(0);
        }
    }

//    // 字符串模拟数据
//    public List<String> cs = new ArrayList<>();
//    String c;
//    public CategoryComboBoxModel() {
//        cs.add("餐饮");
//        cs.add("交通");
//        cs.add("住宿");
//        cs.add("话费");
//        c = cs.get(0);
//    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    // 从数据库读取 Category 数据
    @Override
    public Category getElementAt(int index) {
        if (!cs.isEmpty()) {
            return c;
        } else {
            return null;
        }

    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

//    // 字符串模拟数据
//    @Override
//    public String getElementAt(int index) {
//        return cs.get(index);
//    }
//
//    @Override
//    public void setSelectedItem(Object anItem) {
//        c = (String) anItem;
//    }
}
