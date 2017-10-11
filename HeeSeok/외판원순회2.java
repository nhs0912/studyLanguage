import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	int[] num;
	int[][] map;
	long totalSum = Long.MAX_VALUE;

	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

	boolean next_permutation(int[] arr, int n) {

		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i -= 1;

		}
		if (i <= 0) {
			return false;
		}

		int j = n - 1;
		while (arr[j] <= arr[i - 1]) {
			j -= 1;
		}

		swap(arr, i - 1, j);
		j = n - 1;
		while (i < j) {
			swap(arr, i, j);
			i += 1;
			j -= 1;
		}
		// print(arr);
		// System.out.println();
		return true;
	}

	public int Factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * Factorial(n - 1);
	}

	public void Solve() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("test.txt");
		Scanner sc = new Scanner(fis);
		// Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int[N];
		map = new int[N][N];
		int cnt = Factorial(N);
		
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int weight = sc.nextInt();
				map[i][j] = weight;				
			}
		}

		do {
			long sum = 0;
			boolean isRoute = true;
			for (int i = 0; i < N - 1; i++) {
				int distance = map[num[i] - 1][num[i + 1] - 1];
				if (distance == 0) {
					isRoute = false;
				} else {
					sum += distance;
				}
			}
			int lastDistance = map[num[N - 1] - 1][num[0] - 1];

			if (isRoute && lastDistance != 0) {
				sum += lastDistance;
				if (totalSum > sum) {
					totalSum = sum;
				}
				// System.out.println("최솟값 route");
				// print(num);
				// System.out.println();
			}
			//print(num);
			
		}while(next_permutation(num, N));
		
			System.out.println(totalSum);
		

	}

	public static void main(String[] args) throws IOException {
		new Main().Solve();
	}
}
