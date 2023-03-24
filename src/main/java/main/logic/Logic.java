package main.logic;

import main.data.Point;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public double f(double x) {
        return Math.sin(x);
    }

    public List<Point> tabulatePoints(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = (int) Math.round((finish - start) / step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x, y));
        }
        return points;
    }
}
