import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartsTry extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Expense Tracker");

        // Create a bar chart to display expenses by category
        CategoryAxis categoryAxis = new CategoryAxis();
        NumberAxis numberAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(categoryAxis, numberAxis);
        barChart.setTitle("Expense by Category");

        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.setName("Expenses");

        // Add sample data (replace with your actual data)
        barSeries.getData().add(new XYChart.Data<>("Food", 500.0));
        barSeries.getData().add(new XYChart.Data<>("Transportation", 250.0));
        barSeries.getData().add(new XYChart.Data<>("Entertainment", 300.0));

        barChart.getData().add(barSeries);

        // Create a pie chart to display expenses by type
        PieChart pieChart = new PieChart();
        pieChart.setTitle("Expense by Type");

        PieChart.Data pieData1 = new PieChart.Data("Food", 500.0);
        PieChart.Data pieData2 = new PieChart.Data("Transportation", 250.0);
        PieChart.Data pieData3 = new PieChart.Data("Entertainment", 300.0);

        pieChart.getData().addAll(pieData1, pieData2, pieData3);

        // Create the layout
        HBox hbox = new HBox(barChart, pieChart);

        // Create the scene
        Scene scene = new Scene(new VBox(hbox), 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
