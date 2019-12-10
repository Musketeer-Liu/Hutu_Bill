package gui.panel;

import gui.model.CategoryTableModel;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }
    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("");
    public JButton bEdit = new JButton("");
    public JButton bDelete = new JButton("");
    String columnNames[] = new String[] {"分类名称", "消费次数"};

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);

    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
}
