package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    public GUIAnimatinFaceLook() {

    }

    void makeFace(Graphics g) {
        // makeRim(g);
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeMouth(g, w / 2);
    }

    public void makeFace(Graphics g, String emotion) {
     
        if (emotion.equals("normal")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        } else if (emotion.equals("angry")) {
            makeAngryFace(g);
        }
    }

    /*
     * public void makeRim(Graphics g) { g.drawLine(xStart, yStart, xStart + h,
     * yStart); g.drawLine(xStart, yStart, xStart, yStart + w);
     * g.drawLine(xStart, yStart + w, xStart + h, yStart + w); g.drawLine(xStart
     * + h, yStart, xStart + h, yStart + w); }
     */

    void makeEyes(Graphics g, int eyeSize) {
        g.setColor(Color.blue);
        g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 0, 300);
        g.setColor(Color.black);
        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }

    public void makeMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouthSize / 2, yMiddle, xMiddle + mouthSize / 2, yMiddle);
    }

    public void makeAngryFace(Graphics g) {
        int eyeSize = w / 5;
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;

     
        g.setColor(Color.red);
        g.drawArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 30, 120);
        g.drawArc(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 30, 120);
        g.setColor(Color.black);
        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);

        makeNose(g, h / 5);

        g.drawArc(xMiddle - (w / 4), yMiddle - 10, w / 2, w / 4, 0, -180);
    }
}
