import java.util.ArrayList;
import java.util.HashMap;

public class PrimeCheck {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> primeGroups = new HashMap<>();
        HashMap<String, Integer> pairCount = new HashMap<>();

        for (int i = 3; i <= 100000; i++) {
            if (isPrime(i)) {
                int lastDigit = i % 10;

                // 素数の下一桁をグループ化
                if (!primeGroups.containsKey(lastDigit)) {
                    primeGroups.put(lastDigit, new ArrayList<>());
                }
                primeGroups.get(lastDigit).add(i);

                // 連続する素数の下一桁のペアの出現回数をカウント
                if (i > 3) {
                    int prev = i - 2;
                    String pairKey = prev % 10 + "-" + lastDigit;
                    pairCount.put(pairKey, pairCount.getOrDefault(pairKey, 0) + 1);
                }
            }
        }

        // 素数グループの表示
        System.out.println("素数グループ:");
        for (int key : primeGroups.keySet()) {
            System.out.println("下一桁 " + key + ": " + primeGroups.get(key).size() + " 個の素数");
        }

        // 連続する素数の下一桁のペアの出現回数のランキング
        System.out.println("\n連続する素数の下一桁のペアの出現回数ランキング:");
        pairCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " 回"));
    }

    // 素数かどうかを判定するメソッド
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
