import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    int[] arr;
    int[] viewCntArr;

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int leftCheck(int n) {
        if (arr[n - 1] < arr[n - 2]) {
            return arr[n - 2];
        } else {
            return arr[n - 1];
        }
    }


    public int rightCheck(int n) {
        if (arr[n + 1] < arr[n + 2]) {
            return arr[n + 2];
        } else {
            return arr[n + 1];
        }
    }

    public int viewCntCalculator(int n) {
        int rightVal = rightCheck(n);
        int leftVal = leftCheck(n);
        int result = 0;
        if (leftVal > rightVal) {
            result = arr[n] - leftVal;
        } else {
            result = arr[n] - rightVal;
        }

        if (result < 0) {
            result = 0;
        }
        return result;
    }

    public int getTotal() {
        int sum = 0;
        for (int i = 0; i < viewCntArr.length; i++) {
            sum += viewCntArr[i];
        }

        return sum;
    }

    public void solve() throws FileNotFoundException {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("test.txt"));
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            arr = new int[N];
            viewCntArr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 2; i < arr.length - 2; i++) {
                if (arr[i] != 0) {
                    int resultVal = viewCntCalculator(i);
                    viewCntArr[i] = resultVal;
                }
            }
            System.out.println("#" + tc + " " + getTotal());
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        new Solution().solve();

    }
}
