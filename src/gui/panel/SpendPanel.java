package gui.panel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static SpendPanel instance = new SpendPanel();

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("￥2300");
    JLabel vTodaySpend = new JLabel("￥25");
    JLabel vAvgSpendPerDay = new JLabel("￥120");
    JLabel vMonthAvailable = new JLabel("￥2084");
    JLabel vDayAvgAvailable = new JLabel("￥389");
    JLabel vMonthLeftDay = new JLabel("15 天");

    CircleProgressBar bar;

    private SpendPanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);

        GUIUtil.setColor(ColorUtil.grayColor, lMonthLeft, lTodaySpend, lAvgSpendPerDay, lMonthLeft,
                lDayAvgAvailable, lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(), BorderLayout.CENTER);
        return p;
    }

    private Component center2() {
        return bar;
    }

    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);

        return p;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(SpendPanel.instance);
    }
}
