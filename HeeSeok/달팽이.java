import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	int[] dx = new int[] { 0, 1, 0, -1 };
	int[] dy = new int[] { 1, 0, -1, 0 };

	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void Solve() throws FileNotFoundException {
		//FileInputStream fis = new FileInputStream("test.txt");
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int[][] map;
		//Scanner sc = new Scanner(fis);
		

		for(int tc = 0; tc<test_case;tc++){
			int N = sc.nextInt(); // 맵 size 입력
			map = new int[N][N];// map 생성
			int number = 1; // map안에 있는 number
			int lastX = 0;// 수행 후 마지막 X
			int lastY = map.length - 1;// 수행 후 마지막 Y
			for (int i = 0; i < N; i++) {
				// map의 첫번째 줄에 1 to N 만큼 입력하기
				map[0][i] = number++;
			}
			int dxyMove = 1;
			for (int i = N - 1; i > 0; i--) {
				int count = 2;// 두번씩 수행하기 위한 변수
				while (count-- > 0) {
					for (int j = 0; j < i; j++) {
						lastX = lastX + dx[dxyMove % 4];
						lastY = lastY + dy[dxyMove % 4];

						if (lastX < map.length && lastY < map.length && lastX >= 0 && lastY >= 0) {
							map[lastX][lastY] = number++;
						}
					}
					dxyMove++;
				}
			}
			System.out.println("#"+(tc+1));
			print(map);
		}

	}

	public static void main(String[] args) throws IOException {
		new Main().Solve();
	}
}
