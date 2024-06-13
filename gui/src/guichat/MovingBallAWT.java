package guichat;
//課題これ！！！
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MovingBallAWT {
    public static void main(String[] args) {
        FFrame frame = new FFrame();
        frame.setSize(500, 500);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    static class FFrame extends Frame implements Runnable {

        Thread thread;
        Ball[] balls = new Ball[5];
        private boolean running = true;
        private int frameWidth = 500;
        private int frameHeight = 500;

        FFrame() {
            thread = new Thread(this);
            thread.start();
        }

        public void run() {
            Random random = new Random();
            for (int i = 0; i < balls.length; i++) {
                balls[i] = new Ball();
                balls[i].setPosition(50 + random.nextInt(frameWidth - 100), 50 + random.nextInt(frameHeight - 100));
                balls[i].setRadius(30 + random.nextInt(20));
                balls[i].setColor(new Color(random.nextInt(0x1000000)));
                balls[i].setDirection(random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1);
                balls[i].setSpeed(5 + random.nextInt(5));
            }

            while (running) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (Ball ball : balls) {
                    ball.move(frameWidth, frameHeight);
                }

                repaint();
            }
        }

        public void paint(Graphics g) {
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        class Ball {
            int x;
            int y;
            int radius;
            Color color = Color.RED;
            double xDir;
            double yDir;
            int speed;

            void setColor(Color color) {
                this.color = color;
            }

            void setDirection(double xDir, double yDir) {
                this.xDir = xDir;
                this.yDir = yDir;
            }

            void setSpeed(int speed) {
                this.speed = speed;
            }

            void move(int frameWidth, int frameHeight) {
                x += xDir * speed;
                y += yDir * speed;

                if ((x - radius < 0 && xDir < 0) || (x + radius > frameWidth && xDir > 0)) {
                    xDir = -xDir;
                }
                if ((y - radius < 0 && yDir < 0) || (y + radius > frameHeight && yDir > 0)) {
                    yDir = -yDir;
                }
            }

            void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            void setRadius(int radius) {
                this.radius = radius;
            }

            void draw(Graphics g) {
                g.setColor(color);
                g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
                drawFace(g);
            }

            void drawFace(Graphics g) {
                // Eyes
                g.setColor(Color.WHITE);
                g.fillOval(x - radius / 2, y - radius / 2, radius / 2, radius / 2);
                g.fillOval(x + radius / 4, y - radius / 2, radius / 2, radius / 2);
                g.setColor(Color.BLACK);
                g.fillOval(x - radius / 3, y - radius / 3, radius / 6, radius / 6);
                g.fillOval(x + radius / 3, y - radius / 3, radius / 6, radius / 6);

                // Nose
                g.setColor(Color.BLACK);
                g.fillOval(x - radius / 12, y - radius / 6, radius / 6, radius / 6);

                // Mouth
                g.setColor(Color.BLACK);
                g.drawArc(x - radius / 3, y, radius * 2 / 3, radius / 3, 0, -180);
            }
        }
    }
}
