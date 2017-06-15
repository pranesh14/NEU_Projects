package pso;

import java.awt.Color;
import java.awt.Shape;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;
import org.jfree.ui.ApplicationFrame;

public class ScatterPlot extends ApplicationFrame {

    private static final String TITLE = "Automated Weed Removal by Swarm Robots";
    private XYSeries agents = new XYSeries("UAVs");
    private XYSeries destination = new XYSeries("Weed Infested Area");

    public ScatterPlot(String title, ArrayList<PSO.Agent> agents, double x, double y) {
        super(title);
        updatePlot(agents, x, y);
        final ChartPanel chartPanel = createPlot();
        this.add(chartPanel, BorderLayout.CENTER);
        JPanel control = new JPanel();
        this.add(control, BorderLayout.SOUTH);
    }

    public void changePosition(ArrayList<PSO.Agent> swarm, double x, double y) {
        agents.clear();
        updatePlot(swarm, x, y);
    }

    private void updatePlot(ArrayList<PSO.Agent> swarm, double x, double y) {
        for (int i = 0; i < swarm.size(); i++) {
            agents.add(new XYDataItem(swarm.get(i).getLocation().getLocation()[0], swarm.get(i).getLocation().getLocation()[1]));
        }
        destination.add(new XYDataItem(x, y));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            System.out.println("Exception: " + ie.getMessage());
        }
    }

    private ChartPanel createPlot() {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(TITLE, "Position X-axis", "Position Y-axis",
                createFieldData(), PlotOrientation.VERTICAL, true, true, false);
        Shape cross = ShapeUtilities.createUpTriangle(1);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setBackgroundPaint(Color.WHITE);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesShape(0, cross);
        renderer.setSeriesPaint(0, Color.BLUE);
        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        domain.setRange(-5.0, 5.0);
        domain.setTickUnit(new NumberTickUnit(0.5));
        NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-5.0, 5.0);
        range.setTickUnit(new NumberTickUnit(0.5));
        return new ChartPanel(jfreechart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
    }

    private XYDataset createFieldData() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(agents);        
        xySeriesCollection.addSeries(destination);
        return xySeriesCollection;
    }

}
