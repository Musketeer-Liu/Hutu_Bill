package util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import javax.swing.*;
import java.awt.*;

/**
 * Swing不支持生成柱状图，引入第三方包 chart.jar
 */
public class ChartUtil {
    public static int max(double[] sampleValues) {
        int max = 0;
        for (double v : sampleValues) {
            if (v > max) {
                max = (int) v;
            }
            return max;
        }
    }

    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];

        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5) {
                sampleLabels[i] = String.valueOf(i + 1 + "日");
            }
            return sampleLabels;
        }
    }

    /**
     *
     * @param width
     * @param height
     * @return
     */
    public static Image getImage(int width, int height) {
        double[] sampleValues = sampleValues();
        String[] sampleLabels = sampleLabels();
        int max = max(sampleValues);

        Color[] sampleColors = new Color[] {
                ColorUtil.blueColor
        };
        BarChart chart = new BarChart();

        chart.setSampleCount(sampleValues.length);
        chart.setSampleValues(0, sampleValues);
        chart.setSampleLabels(sampleLabels);
        chart.setSampleColors(sampleColors);
        chart.setRange(0, max * 1.2);
        chart.setValueLinesOn(true);
        chart.setSampleLabelsOn(true);
        chart.setSampleLabelStyle(Chart.BELOW);

        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        chart.setLengendOn(true);
        chart.setLengendPosition(Chart.LEFT);
        chart.setLegendLabels(new String[] {"月消费报表"});
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        chart.setChartBackground(Color.white);
        chart.setBackground(ColorUtil.backgroundColor);

        Image im = chart.getImage(width, height);
        return im;
    }

    private static double[] sampleValues() {
        double[] result = new double[30];
        for (int i = 0; i < result.length;i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;
    }

    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        Image img = ChartUtil.getImage(400, 300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
}
