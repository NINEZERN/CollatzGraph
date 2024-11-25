import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Population", "2000");
        dataset.addValue(4, "Population", "2005");
        dataset.addValue(3, "Population", "2010");
        dataset.addValue(5, "Population", "2015");

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Population Growth", // Chart title
                "Year",              // X-Axis label
                "Population (millions)", // Y-Axis label
                dataset
        );

        // Display chart in a frame
        JFrame frame = new JFrame("Simple JFreeChart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
