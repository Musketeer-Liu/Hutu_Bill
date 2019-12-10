package gui.panel;

import entity.Record;
import gui.model.CategoryComboBowModel;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class RecordPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }
    public static RecordPanel instance = new RecordPanel();
    
    JLabel lSpend = new JLabel("花费（￥");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");
    
    public JTextField tfSpend = new JTextField("0");
    
    public CategoryComboBowModel cbModel = new CategoryComboBowModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    
    JButton bSubmit = new JButton("记一笔");
    
    public RecordPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput = new JPanel();
        JPanel.pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 2, gap, gap));
        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }
}
