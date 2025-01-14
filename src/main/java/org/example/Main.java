package org.example;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Set<Coordinate> set = Set.of(
                Coordinate.of(2014, 154),
                Coordinate.of(2119, 154)
        );

        List<MyRobot> robots = set.stream().map(coordinate -> {
            try {
                return new MyRobot(coordinate);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        while (true) {
            robots.forEach(robot -> {
                robot.checkDuel();
                robot.doubleClick();
            });

            Thread.sleep(5000);
        }
    }
}