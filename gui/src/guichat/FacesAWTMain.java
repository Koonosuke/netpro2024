import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        
        new FacesAWTMain();
    }

    FacesAWTMain() {
       
        FaceFrame f = new FaceFrame();
        
        f.setSize(800, 800);
       
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
      
        f.setVisible(true);
    }

    // 顔を描画するフレームを定義するインナークラスです。
    class FaceFrame extends Frame {

        private FaceObj[][] faces;

        FaceFrame() {
            // 3x3の顔オブジェクトの配列を作成します。
            faces = new FaceObj[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 各顔オブジェクトを初期化します。
                    faces[i][j] = new FaceObj();
                }
            }
        }

        // フレームに描画するメソッドです。
        public void paint(Graphics g) {
            // 顔の幅と高さを設定します。
            int w = 200;
            int h = 200;
            // 描画の開始位置を設定します。
            int xStart = 50;
            int yStart = 50;

            // 3x3の顔を描画します。
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 各顔を描画します。
                    drawFace(g, faces[i][j], xStart + j * (w + 50), yStart + i * (h + 50));
                }
            }
        }

        // 顔を描画するメソッドです。
        public void drawFace(Graphics g, FaceObj face, int x, int y) {
            // 顔の色を設定して楕円を描画します。
            g.setColor(face.getFaceColor());
            g.fillOval(x, y, 200, 200);

            // 目の色を設定します。
            g.setColor(face.getEyeColor());
            int eyeRadius = 200 / 10;
            // 目の形に応じて目を描画します。
            if (face.getEyeShape() == 0) { // 丸い目
                g.fillOval(x + 200 / 4 - eyeRadius, y + 200 / 3 - eyeRadius, eyeRadius * 2, eyeRadius * 2);
                g.fillOval(x + 200 * 3 / 4 - eyeRadius, y + 200 / 3 - eyeRadius, eyeRadius * 2, eyeRadius * 2);
            } else { // 四角い目
                g.fillRect(x + 200 / 4 - eyeRadius, y + 200 / 3 - eyeRadius, eyeRadius * 2, eyeRadius * 2);
                g.fillRect(x + 200 * 3 / 4 - eyeRadius, y + 200 / 3 - eyeRadius, eyeRadius * 2, eyeRadius * 2);
            }

            // 口の色を設定します。
            g.setColor(face.getMouthColor());
            // 口の形に応じて口を描画します。
            switch (face.getMouthShape()) {
                case 0: // 笑顔
                    g.drawArc(x + 200 / 4, y + 200 / 2, 200 / 2, 200 / 3, 0, -180);
                    break;
                case 1: // 無表情
                    g.drawLine(x + 200 / 4, y + 200 * 2 / 3, x + 200 * 3 / 4, y + 200 * 2 / 3);
                    break;
                case 2: // 怒り顔
                    g.drawArc(x + 200 / 4, y + 200 * 2 / 3, 200 / 2, 200 / 3, 0, 180);
                    break;
            }
        }
    }

    // 顔の情報を持つクラスです。
    private class FaceObj {
        private Color faceColor;
        private Color eyeColor;
        private Color mouthColor;
        private int eyeShape; // 0: 丸い目, 1: 四角い目
        private int mouthShape; // 0: 笑顔, 1: 無表情, 2: 怒り顔

        public FaceObj() {
            // ランダムな色を設定します。
            faceColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
            eyeColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
            mouthColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

            // ランダムな形を設定します。
            eyeShape = (int) (Math.random() * 2); // 0か1
            mouthShape = (int) (Math.random() * 3); // 0, 1, 2
        }

        public Color getFaceColor() {
            return faceColor;
        }

        public Color getEyeColor() {
            return eyeColor;
        }

        public Color getMouthColor() {
            return mouthColor;
        }

        public int getEyeShape() {
            return eyeShape;
        }

        public int getMouthShape() {
            return mouthShape;
        }
    }
}
