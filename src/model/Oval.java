package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {

    public Oval(Point topLeft, MidiSynth midiSynth) {
        super((int) topLeft.getX(), (int) topLeft.getY(), 0, 0); //note to students: calls the other constructor!
        selected = false;
        this.midiSynth = midiSynth;
        instrument = 0;
        playLineCoord = 0;
        PLAYING_COLOR = new Color(155, 250, 60);
    }

    //EFFECTS: draws the shape
    protected void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);

    }

    //EFFECTS: fills the shape
    protected void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);

    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    protected boolean contains(Point point) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, point.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, point.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, point.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, point.y);
        }
        return  diff <= 1.0 + TOL;
    }

    // Compute square of difference
    // EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }
}

