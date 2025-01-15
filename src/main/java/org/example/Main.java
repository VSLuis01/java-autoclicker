package org.example;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {

        AutoClick.run();



        /*List<Coordinate> path = List.of(
                //Coordinate.of(2014, 154),
                Coordinate.of(3005, 406)
        );

        MyRobot robot = new MyRobot();
        robot.setPath(path);

        Color duelPickerColor = Color.decode("0xA83DB4");

        while (true) {
            robot.getPath().forEach(pos -> {
                robot.checkDuel(duelPickerColor);
                robot.doubleClick(pos);
            });

            Thread.sleep(2000);
        }*/
    }
}