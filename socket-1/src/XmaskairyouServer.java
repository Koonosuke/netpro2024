import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class XmaskairyouServer {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);

            Socket socket = server.accept();
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            XmasPresent present = (XmasPresent) ois.readObject();

            String msgPresent = present.getMessage();
            System.out.println("メッセージは" + msgPresent);
            String presentFromClient = present.getContent();
            System.out.println("答えの内容は" + presentFromClient);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            XmasPresent response = new XmasPresent();

            if (msgPresent.equalsIgnoreCase("Christmas")) {
                response.setMessage("サンタクロースだ！！きっと素敵な人が待っているはず。楽しいクリスマスをお過ごしくれ！");
            } else {
                response.setMessage("サンタクロースだ！今年は諦めなさい！！メリークリスマス！");
            }

            if (presentFromClient.equals("3/15")) {  
                response.setContent("告白の魔法瓶\n" + presentFromClient + "が誕生日じゃ！ありがとう。告白の魔法を使ってみないか？");
            } else {
                response.setContent("間違えたからなしじゃ！！");
            }

            // ランダムにおすすめの場所を選ぶ
            String[] recommendedSpots = {"青の洞窟", "赤い橋", "緑の森", "黄金の滝", "白い浜辺"};
            Random random = new Random();
            String recommendedSpot = recommendedSpots[random.nextInt(recommendedSpots.length)];
            response.setRecommendedSpot("お勧めの場所: " + recommendedSpot);

            // ランダムにおすすめのプレゼントを選ぶ
            String[] recommendedPresents = {"ケーキ", "ネックレス", "腕時計", "バラの花束", "写真立て"};
            String recommendedPresent = recommendedPresents[random.nextInt(recommendedPresents.length)];
            response.setRecommendedPresent("お勧めのプレゼント: " + recommendedPresent);

            // ラッキーアイテムをランダムに選んでセットする
            String[] luckyItems = {"時計", "リング", "ブレスレット", "サングラス", "帽子"};
            String luckyItem = luckyItems[random.nextInt(luckyItems.length)];
            response.setLuckyItem("今日のラッキーアイテム: " + luckyItem);

            oos.writeObject(response);
            oos.flush();

            ois.close();
            oos.close();
            socket.close();
            server.close();

        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
