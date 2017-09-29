import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static final int RIPEN = 1, UNRIPEN = 0, EMPTY = -1;
	public static int n, m, map[][];
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i, j;
		String line[] = in.readLine().split(" ");
		n = Integer.parseInt(line[1]);
		m = Integer.parseInt(line[0]);
		map = new int[n][m];
		
		//익은 토마토(1)의 위치를 담음
		LinkedList<Elements> pos = new LinkedList<>();
		
		for(i=0;i<n;i++){
			line = in.readLine().split(" ");
			for(j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j]==RIPEN) pos.add(new Elements(i, j));
			}
		}
		
		for(Elements e : pos) {
			bfs(e.x, e.y);
		}
		
		out.write(getMaxDate()+"");
		out.close();
		in.close();
	}
	
	//익은 토마토(1) 부터 시작해서 뻗어나감
	private static void bfs(int a, int b){
		int i, x, y, ax, ay, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

		Queue<Elements> q = new LinkedList<>();
		q.offer(new Elements(a, b));
		
		while(!q.isEmpty()){
			x = q.peek().x; y = q.poll().y;
			
			for(i=0;i<4;i++){
				ax = x+dx[i]; ay = y+dy[i];
				
				if(canSpread(x, y, ax, ay)){
					map[ax][ay] = map[x][y]+1;
					q.offer(new Elements(ax, ay));
				}
			}
		}
	}
	
	/**
	 * 토마토가 다른 곳에 영향을 줄 수 있는가?
	 * 조건 1: 이동 할 장소가 map을 벗어나면 안됨
	 * 조건 2: 이동 할 장소가 안 익은 토마토(0)거나,
	 * 조건 3: 이미 익은 경우 걸린 날짜 보다 더 빨리 익힐 수 있어야 함.
	 * 조건1 && (조건 2 || 조건 3)
	 */
	private static boolean canSpread(int x, int y, int ax, int ay){
		boolean isInRange = (0<=ax&&ax<n)&&(0<=ay&&ay<m);
		return isInRange && (map[ax][ay] == UNRIPEN || map[x][y]+1 < map[ax][ay]);
	}
	
	/**
	 * 1개라도 안 익은 것이 있다면 -1
	 * 모두 익은 경우 최대값 -1 반환
	 */
	private static int getMaxDate(){
		int i, j, max = -1;
		for(i=0;i<n;i++)
			for(j=0;j<m;j++){
				if(map[i][j]==UNRIPEN) return -1;
				else if(max < map[i][j]) max = map[i][j];
			}
		return max-1;
	}	
}

class Elements{
	int x, y;
	public Elements(int x, int y){
		this.x = x;
		this.y = y;
	}
}
