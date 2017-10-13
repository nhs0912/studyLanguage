import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    int[][] map;
    int[][] results;


    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }

        }
        System.out.println();
    }

    int getWidthSum() {
        int totalSum = 0;

        for (int i = 0; i < map.length; i++) {
            int sum = 0;
            for (int j = 0; j < map[i].length; j++) {
                sum += map[i][j];
            }
            if (totalSum < sum) {
                totalSum = sum;
            }
        }


        return totalSum;
    }

    int getHeightSum() {
        int totalSum = 0;
        for (int i = 0; i < map.length; i++) {
            int sum = 0;

            for (int j = 0; j < map[i].length; j++) {
                sum += map[j][i];
            }
            if (totalSum < sum) {
                totalSum = sum;
            }
        }
        return totalSum;
    }

    int getCrossSum() {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < map.length; i++) {
            leftSum += map[i][i];
        }
        int j = 0;

        for (int i = map.length - 1; i >= 0; i--) {
            rightSum += map[j++][i];
        }


        if (leftSum > rightSum) {
            return leftSum;
        }
        return rightSum;

    }


    int getResult() {
        int widthVal = getWidthSum();
        int heightVal = getHeightSum();
        int crossVal = getCrossSum();
        if (widthVal > heightVal) {
            if (widthVal > crossVal) {
                return widthVal;
            } else {
                return crossVal;
            }
        } else {
            if (heightVal > crossVal) {
                return heightVal;
            } else {
                return crossVal;
            }
        }

    }

    public void solve() throws FileNotFoundException {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("test.txt"));
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int size = 100;
            map = new int[size][size];
            results = new int[3][size * 2 + 2];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + tc + " " + getResult());
        }


    }

    public static void main(String[] args) throws FileNotFoundException {
        new Solution().solve();
    }
}
