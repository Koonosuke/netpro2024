package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class PrintLettersRunnable implements Runnable {
    private String threadName;
    private CountDownLatch latch;
    private char[] letters = "abcdefghij".toCharArray(); // 出力する文字の配列

    public PrintLettersRunnable(String threadName, CountDownLatch latch) {
        this.threadName = threadName;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (char letter : letters) {
            try {
                Thread.sleep(1000); // 1秒の待ち時間
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " prints letter: " + letter);
        }
        latch.countDown(); // タスクが完了したことを知らせる
    }
}

public class ExThreadsMain {
    public static void main(String[] args) {
        final int THREAD_COUNT = 26;
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_COUNT);

        // 26個のスレッドを作成するループ
        for (int i = 0; i < THREAD_COUNT; i++) {
            char c = (char) (97 + i); // ASCII値 97 は 'a' です。i を加算して次の文字を取得します。
            PrintLettersRunnable pn = new PrintLettersRunnable("thread-" + c, latch);

            // 1秒後にスレッドを開始し、その後1秒ごとに実行します
            executorService.scheduleAtFixedRate(pn, 0, 1, TimeUnit.SECONDS);
        }

        try {
            latch.await(); // すべてのスレッドが終了するまで待つ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("All threads have finished their work.");
    }
}
