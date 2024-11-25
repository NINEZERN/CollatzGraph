import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class CollatzPlot extends ApplicationFrame {

    public CollatzPlot(String title, List<Long> collatzSequence) {
        super(title);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Collatz Sequence",
                "Step",
                "Value",
                createDataset(collatzSequence),
                PlotOrientation.VERTICAL,
                true, true, false);

        XYPlot plot = lineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setMouseWheelEnabled(true); // Allows zooming with the mouse wheel

        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset(List<Long> collatzSequence) {
        XYSeries series = new XYSeries("Collatz Sequence");
        for (int i = 0; i < collatzSequence.size(); i++) {
            series.add(i, collatzSequence.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollatzNumber collatz = new CollatzNumber();

        long number;
        do {
            System.out.print("Number ->");
            try {
                number = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                number = -1;
            }
        } while(number < 1);
        List<Long> collatzSequence = collatz.calculate(number);
        CollatzPlot chart = new CollatzPlot("Collatz Sequence Visualization", collatzSequence);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
