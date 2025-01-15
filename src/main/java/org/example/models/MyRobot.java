package org.example.models;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;

public class MyRobot extends Robot {
    List<Coordinate> path = new ArrayList<>();

    public MyRobot() throws AWTException {
        super();
    }

    private void click() {
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void simpleClick(Coordinate pos) {
        this.mouseMove(pos.x(), pos.y());

        this.click();
    }

    public void doubleClick(Coordinate pos) {
        this.mouseMove(pos.x(), pos.y());

        this.click();
        this.delay(200);
        this.click();
    }

    public void checkDuel(Color compare) {
        Color duelPickerColor = this.getPixelColor(2991, 411);

        if (!compare.equals(duelPickerColor)) {
            System.out.println("Duel found");
            this.mouseMove(3686, 344);
            this.click();
            this.delay(200);
        }
    }

    public List<Coordinate> getPath() {
        return path;
    }

    public void setPath(List<Coordinate> path) {
        this.path = path;
    }
}
