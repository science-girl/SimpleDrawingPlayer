package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Point topLeft, MidiSynth midiSynth) {

        //super(topLeft, midiSynth);
        super((int) topLeft.getX(), (int) topLeft.getY(), 0, 0); //note to students: calls the other constructor!
        selected = false;
        this.midiSynth = midiSynth;
        instrument = 0;
        playLineCoord = 0;
        PLAYING_COLOR = new Color(230, 158, 60);

    }

    //EFFECTS: draws the shape
    protected void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    //EFFECTS: fills the shape
    protected void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    protected boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }
}

