import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    int T;
    int[][] sdokuMap = new int[9][9];
    boolean[] verticalNumbers;
    boolean[] widthNumbers;
    boolean[] cubeNumbers;    

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();
    }


    public void initArr(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
    }

    public void input() throws FileNotFoundException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("test.txt"));
        T = sc.nextInt();
        int tc = 0;

        int result = 0;
        while (T-- > 0) {
            //input sdoku
            result = 1;
            tc++;
            sdokuMap = new int[9][9];
            verticalNumbers = new boolean[9];
            widthNumbers = new boolean[9];
            cubeNumbers = new boolean[9];
            //sdoku 입력
            for (int i = 0; i < sdokuMap.length; i++) {
                for (int j = 0; j < sdokuMap.length; j++) {
                    sdokuMap[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < sdokuMap.length; i++) {
                //  if (isWidthCheck(sdokuMap, i) || isVerticalCheck(sdokuMap, i)) {
                initArr(widthNumbers);
                initArr(verticalNumbers);
                initArr(cubeNumbers);
                if (isWidthCheck(sdokuMap, i) || isVerticalCheck(sdokuMap, i)) {
                    result = 0;
                    break;
                }

                if (i % 3 == 0) {
                    if (isCubeCheck(sdokuMap, i)) {
                        result = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + tc + " " + result);
           // print(sdokuMap);

        }


    }

    public boolean isCubeCheck(int[][] arr, int n) {
        //true 중복이 있음 , false 중복 없음
        for (int i = n; i < n + 3; i++) {
            for (int j = n; j < n + 3; j++) {
                if (!cubeNumbers[arr[i][j] - 1]) {
                    cubeNumbers[arr[i][j] - 1] = true;
                } else {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean isVerticalCheck(int[][] arr, int n) {
        //true 중복이 있음 , false 중복 없음
        for (int i = 0; i < arr.length; i++) {
            if (!verticalNumbers[arr[i][n] - 1]) {
                verticalNumbers[arr[i][n] - 1] = true;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean isWidthCheck(int[][] arr, int n) {
        //true 중복이 있음 , false 중복 없음
        for (int i = 0; i < arr[n].length; i++) {
            if (!widthNumbers[arr[n][i] - 1]) {
                widthNumbers[arr[n][i] - 1] = true;
            } else {
                return true;
            }
        }
        return false;
    }


    public void Solve() throws FileNotFoundException {
        input();

    }

    public static void main(String[] args) throws FileNotFoundException {
        new Solution().Solve();
    }
}
