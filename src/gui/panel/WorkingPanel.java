package gui.panel;

import javax.swing.*;

/**
 * 新建一个类来负责 addListener 接口
 */
public abstract class WorkingPanel extends JPanel {
    public abstract void updateData();
    public abstract void addListener();
}
