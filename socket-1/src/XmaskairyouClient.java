import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class XmaskairyouClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ポート番号を入力してください（例: 5000）: ");
            int port = scanner.nextInt();
            System.out.println("localhostのポート " + port + " に接続しています...");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました。");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("英語しか話せないサンタだ！（今は魔法で翻訳しているよ）");
            System.out.println("「クリスマス」を英語で入力できるかな？：");
            String message = scanner.next();

            System.out.println("サンタの誕生日は？（〇/〇）：");
            scanner.nextLine(); 
            String content = scanner.nextLine();
            scanner.close();

            XmasPresent present = new XmasPresent();
            present.setMessage(message);
            present.setContent(content);
            oos.writeObject(present);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            XmasPresent returnPresent = (XmasPresent) ois.readObject();
            String returnMsg = returnPresent.getMessage();

            System.out.println("サーバーからのメッセージ: " + returnMsg);
            String returnContent = returnPresent.getContent();
            System.out.println("受け取ったプレゼント: " + returnContent);

            // おすすめの場所とプレゼントを表示
            String recommendedSpot = returnPresent.getRecommendedSpot();
            String recommendedPresent = returnPresent.getRecommendedPresent();
            System.out.println(recommendedSpot);
            System.out.println(recommendedPresent);

            // ラッキーアイテムを表示
            String luckyItem = returnPresent.getLuckyItem();
            System.out.println(luckyItem);

            ois.close();
            oos.close();
            socket.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバーが起動していません。");
            System.err.println("サーバーが起動していることを確認してください。");
            System.err.println("別のポート番号を指定してください（例: 6000）。");
        } catch (Exception e) {
            System.err.println("エラーが発生しました。プログラムを終了します。");
            throw new RuntimeException(e);
        }
    }
}
