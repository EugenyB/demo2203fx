package main;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.data.Point;
import main.logic.Logic;

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

    private Logic logic;

    public void initialize() {
        logic = new Logic();
        xCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().x()).asObject());
        yCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().y()).asObject());
    }

    public void tabulate() {
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());

        List<Point> points = logic.tabulatePoints(start, finish, step);
        pointsTable.setItems(FXCollections.observableList(points));
    }


}
