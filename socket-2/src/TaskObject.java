public class TaskObject implements ITask {
  
    
    private int number;
    private int result;

    @Override
    public void setExecNumber(int x) {
        this.number = x;
    }

    @Override
    public void exec() {



        this.result =larger(number);

    }

    @Override
    public int getResult() {
        return result;
    }

    private int larger(int x) {
        for (int i = x; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1; // 素数が見つからない場合
    }


    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
