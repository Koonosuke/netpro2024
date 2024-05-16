class Renshu {


    public int doubleValue(int x) {
        return x * 2;
    }

   
    public int sumUpToN(int n) {
        return (n * (n + 1)) / 2;
    }//1からnの整数の和？？

    
    public int sumFromPtoQ(int p, int q) {
        if (p > q) {
            return -1; 
        }
        
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        return sum;
    }
public int sumFromArrayIndex(int[]a,int index){
if(index>=a.length){
    return -1;
}
int sum=0;
for(int i=index;i<a.length;i++){
sum+=a[i];
}return sum;
}
public int selectMaxValue(int[] a){
    int max = Integer.MIN_VALUE;
    for (int num : a) {
        max = Math.max(max, num);
    }
    return max;
}
public int selectMinValue(int[] a){
    int min= Integer.MAX_VALUE;
    for (int num : a) {
        min= Math.min(min, num);
    }
    return min;
}
 public int selectMaxIndex(int[] a) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int selectMinIndex(int[] a) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        if ( i < p.length && j < p.length) {
            int a = p[i];
            p[i] = p[j];
            p[j] = a;
        }
    

}

public boolean swapTwoArrays(int[] a, int[] b) {
    if (a.length == b.length) {
        for (int i = 0; i < a.length; i++) {
            int e = a[i];
            a[i] = b[i];
            b[i] = e;
        }
        return true;
    }
    return false;

}

public class bubbleSort {

    static void bubble_sort(int[] d) {
        // iはi回目の交換する回数
        for (int i = d.length-1; i > 0; i-- ) {
            // j は交換する箇所の前からの番号を示している
            for (int j = 0; j < i; j++) {
                if(d[j]>d[j+1]){
                  //降順にしたい場合は不等号を逆に
                  int box = d[j];
                  d[j] = d[j+1];
                  d[j+1] = box;
                  System.out.println(d[j] + ":" +d[j+1]);
                } else{
                  //そのまま
                }
            }
        }
    }
    static void print_data(int[] d) {
        for(int i = 0; i < d.length; i++) System.out.print(d[i] + " ");
    }
    public static void main(String[] args) {
        int[] data = {5, 10, 3, 7, 8, 1, 9};
        print_data(data);
        bubble_sort(data);
        print_data(data);
    }
}




}
