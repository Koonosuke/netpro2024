package guichat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MovingBallFacesAWT {
    public static void main(String[] args) {
        new MovingBallFacesAWT();
    }

    MovingBallFacesAWT() {
        MovingInnerFFrame f = new MovingInnerFFrame();
        Thread th = new Thread(f);
        th.start();

        f.setSize(500, 500);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);

        int MAXTime = 20;
        for (int i = 0; i < MAXTime; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("残り" + (MAXTime - i) + "秒です");
        }
        System.out.println("終了します");
        f.setTh_enable(false);
        System.out.println("終了しました");
    }

    class MovingInnerFFrame extends Frame implements Runnable {
        int ballnum = 5;
        BallRim[] myBalls = new BallRim[ballnum];

        private boolean th_enable = true;

        public boolean isTh_enable() {
            return th_enable;
        }

        public void setTh_enable(boolean th_enable) {
            this.th_enable = th_enable;
        }

        private int th_counter = 0;

        int w = 500;
        int h = 500;

        public void run() {
            for (int i = 0; i < myBalls.length; i++) {
                myBalls[i] = new BallRim();
            }

            while (th_enable) {
                try {
                    Thread.sleep(100);
                    th_counter++;
                    if (th_counter >= 500) {
                        th_enable = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < myBalls.length; i++) {
                    myBalls[i].move();
                }

                repaint(); // paint()メソッドが呼び出される
            }
        }

        public void paint(Graphics g) {
            for (int i = 0; i < myBalls.length; i++) {
                myBalls[i].draw(g);
            }
        }
    }

    // BallRimクラス
    class BallRim {
        FaceObj fobj;
        Random rdn;
        int w = 500;
        int h = 500;

        int x;
        int y;
        int radius; // ボールの半径
        Color color = Color.RED;

        double xDir;
        double yDir;

        BallRim() {
            rdn = new Random();
            xDir = rdn.nextDouble() * 2 - 1;
            yDir = rdn.nextDouble() * 2 - 1;

            setPosition(rdn.nextInt(w), rdn.nextInt(h));
            setRadius(rdn.nextInt(30) + 30); // 30-60のサイズのランダムな半径

            Color c = new Color(rdn.nextInt(255), rdn.nextInt(255), rdn.nextInt(255));
            setColor(c);

            fobj = new FaceObj();
        }

        void setColor(Color c) {
            this.color = c;
        }

        void move() {
            if ((xDir > 0) && (x + this.radius * 2 >= w)) {
                xDir = -1 * xDir;
            }
            if ((xDir < 0) && (x <= 0)) {
                xDir = -1 * xDir;
            }

            if (xDir > 0) {
                x += 10;
            } else {
                x -= 10;
            }

            if ((yDir > 0) && (y + this.radius * 2 >= h)) {
                yDir = -1 * yDir;
            }
            if ((yDir < 0) && (y <= 0)) {
                yDir = -1 * yDir;
            }

            if (yDir > 0) {
                y += 10;
            } else {
                y -= 10;
            }
        }

        void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setRadius(int r) {
            this.radius = r;
        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, 2 * radius, 2 * radius);
            fobj.setXY(x, y);
            fobj.setSize(2 * radius, 2 * radius);
            fobj.makeFace(g);
        }
    }

    // FaceObjクラス
    class FaceObj {
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
            this.w = w;
        }

        public FaceObj() {
        }

        public void makeFace(Graphics g) {
            makeEyes(g, w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        }

        public void makeEyes(Graphics g, int eyeSize) {
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
    }
}
