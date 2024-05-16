import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RenshuTest {
    Renshu renshu = new Renshu();

    @Test
    void testDoubleValue() {
        assertEquals(4, renshu.doubleValue(2));
        assertEquals(0, renshu.doubleValue(0));
        assertEquals(-6, renshu.doubleValue(-3));
    }

    @Test
    void testSumUpToN() {
        assertEquals(55, renshu.sumUpToN(10));
        assertEquals(0, renshu.sumUpToN(0));
        assertEquals(5050, renshu.sumUpToN(100));
    }
 
    @Test
    void testSumFromPtoQ() {
        assertEquals(5050, renshu.sumFromPtoQ(1, 100));
        assertEquals(6, renshu.sumFromPtoQ(1, 3));
        assertEquals(-1, renshu.sumFromPtoQ(5, 3)); 
    }

    @Test
    void testSumFromArrayIndex() {
        int[] a = { 1, 2, 3, 4, 5 };
        assertEquals(12, renshu.sumFromArrayIndex(a, 2));
        assertEquals(15, renshu.sumFromArrayIndex(a, 0));
        assertEquals(-1, renshu.sumFromArrayIndex(a, 5)); 
    }

    @Test
    void testSelectMaxValue() {
        int[] a = { 1, 3, 5, 7, 9 };
        assertEquals(9, renshu.selectMaxValue(a));
        int[] b = { -1, -3, -5 };
        assertEquals(-1, renshu.selectMaxValue(b));
    }

    @Test
    void testSelectMinValue() {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        assertEquals(1, renshu.selectMinValue(a));
        int[] b = { 5, -1, -5, 3 };
        assertEquals(-5, renshu.selectMinValue(b));
    }

    @Test
    void testSelectMaxIndex() {
        int[] a = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        assertEquals(7, renshu.selectMaxIndex(a));
    }

    @Test
    void testSelectMinIndex() {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        assertEquals(9, renshu.selectMinIndex(a));
        int[] b = { 5, -1, -5, 3, -5 };
        assertEquals(2, renshu.selectMinIndex(b)); 
    }

    @Test
    void testSwapArrayElements() {
        int[] p = { 1, 2, 3, 4, 5 };
        int[] expected = { 5, 2, 3, 4, 1 };
        renshu.swapArrayElements(p, 0, 4);
        assertArrayEquals(expected, p);
    }

    @Test
    void testSwapTwoArrays() {
        int[] a = { 1, 2, 3 };
        int[] b = { 4, 5, 6 };
        assertTrue(renshu.swapTwoArrays(a, b));
        assertArrayEquals(new int[] { 4, 5, 6 }, a);
        assertArrayEquals(new int[] { 1, 2, 3 }, b);
        int[] c = { 1, 2 };
        assertFalse(renshu.swapTwoArrays(a, c)); 
    }





    public static void bubbleSort(int[] a) {
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                  
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
           
            if (!swapped) break;
        }
    }

 
    public static void quickSort(int[] a) {
        quickSortHelper(a, 0, a.length - 1);
    }

    private static void quickSortHelper(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSortHelper(a, low, pi - 1);
            quickSortHelper(a, pi + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
       
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

  
    public static void swapArrayElements(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


    