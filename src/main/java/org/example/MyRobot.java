package org.example;

import java.awt.*;
import java.awt.event.InputEvent;

public class MyRobot extends Robot {
    Coordinate mousePosition;

    public MyRobot(Coordinate mousePosition) throws AWTException {
        super();
        this.mousePosition = mousePosition;
    }

    public void click() {
        this.mouseMove(mousePosition.x(), mousePosition.y());

        // Realiza o clique do mouse
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    public void doubleClick() {
        this.mouseMove(mousePosition.x(), mousePosition.y());

        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        this.delay(200);

        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    @Override
    public String toString() {
        return this.mousePosition.toString();
    }

    public void checkDuel() {
//        this.getPixelColor()
    }
}
