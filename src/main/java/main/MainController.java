package main;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.data.Point;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private TextField startField;
    @FXML
    private TextField finishField;
    @FXML
    private TextField stepField;

    @FXML
    private TableView<Point> pointsTable;
    @FXML
    private TableColumn<Point, Double> xCol;
    @FXML
    private TableColumn<Point, Double> yCol;

    public double f(double x) {
        return Math.sin(x);
    }

    public void initialize() {
        xCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().x()).asObject());
        yCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().y()).asObject());
    }

    public void tabulate() {
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());

        List<Point> points = new ArrayList<>();
        int n = (int) Math.round((finish - start) / step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x, y));
        }
        pointsTable.setItems(FXCollections.observableList(points));

    }
}
