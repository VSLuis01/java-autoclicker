package org.example;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {

        List<Coordinate> path = List.of(
                //Coordinate.of(2014, 154),
                Coordinate.of(2119, 154)
        );

        MyRobot robot = new MyRobot();
        robot.setPath(path);

        Color duelPickerColor = Color.decode("0x313338");

        while (true) {
            robot.getPath().forEach(pos -> {
                robot.checkDuel(duelPickerColor);
                robot.doubleClick(pos);
            });

            Thread.sleep(2000);
        }
    }
}