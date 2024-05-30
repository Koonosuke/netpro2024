package Thread;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {
    String myAlphabetStr = "noalphabet";

    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args) {
        // 26個のスレッドを作成するループ
        for (int i = 0; i < 26; i++) {

            // CountAZTenRunnable クラスのインスタンスを作成します。
            CountAZTenRunnable ct = new CountAZTenRunnable();

            // インスタンスに対応する文字を設定します。
            char c = (char) (97 + i); // ASCII値 97 は 'a' です。i を加算して次の文字を取得します。
            ct.setAlphabet(c + "_chan");



            // ct を実行する新しいスレッドを作成します。
            Thread th = new Thread(ct, "thread-" + c);

            // スレッドを開始します。これにより、CountAZTenRunnable の run メソッドが呼び出されます。
            th.start();
        }
    }


    

    // character を設定するための setter メソッド
    public void setAlphabet(String alphabetStr) {
        myAlphabetStr = alphabetStr;
    }

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、1 から 10 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for (int i = 1; i <= 10; i++) {
                // スレッド名とカウント値を出力します。
                System.out.println(myAlphabetStr + " runnable thread : i=" + i);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}