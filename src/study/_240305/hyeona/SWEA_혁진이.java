import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 현재 메모리 값, 방향, 좌표로 방문한 이력이 있는지 보기?
public class SWEA_혁진이 {
    static class Program{
        int x;
        int y;
        boolean isMeet;
        int dir;
        int memo;

        public Program(int x, int y, boolean isMeet, int dir, int memo) {
            super();
            this.x = x;
            this.y = y;
            this.isMeet = isMeet;
            this.dir = dir;
            this.memo = memo;
        }


    }
    // 오, 왼, 위, 아래
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int R, C;
    static char[][] arr;
    static boolean[][][][] v;
    static boolean endFlag;
    public static void main(String[] args) throws IOException {

    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int i=1; i<=T; i++) {
            endFlag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            sb.append("#").append(i).append(" ");

            arr = new char[R][C];
            v = new boolean[R][C][4][16];

            for(int x=0; x<R; x++) {
                String str = br.readLine();
                for(int y=0; y<C; y++) {
                    arr[x][y] = str.charAt(y);
                }
            }

//            System.out.println(Arrays.deepToString(arr));
//            System.out.println(i);
//            Scanner sc = new Scanner(System.in);
//            sc.nextInt();
            
            
            dfs(new Program(0,0,false,0,0));

            
            if(!endFlag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        
        System.out.println(sb);
        



    }

    private static void dfs(Program p) {

    	// System.out.println(p.x + " " + p.y + " "+ p.dir + " " + p.memo);
    	
    	if(endFlag) {
    		return;
    	}
    	// 무한루프
    	// ? 일 때 무한루프를 만나면 돌아가야하고
    	// ? 가 아니면 flag = 1
        if(v[p.x][p.y][p.dir][p.memo]) {
            return;
        }
        
        if(arr[p.x][p.y] == '@'){
        	endFlag = true;
        	return;
        }
        
        v[p.x][p.y][p.dir][p.memo] = true;

        // 숫자일 때
        if(arr[p.x][p.y]-'0' >=0 && arr[p.x][p.y]-'0' <=9) {
        	// System.out.println("숫자");
            p.memo = arr[p.x][p.y]-'0';
        }

        if(arr[p.x][p.y] == '<') {
        	// System.out.println("<");
            p.dir = 1;
        }


        if(arr[p.x][p.y] == '>') {
        	// System.out.println(">");
            p.dir = 0;
        }

        if(arr[p.x][p.y] == '^') {
        	// System.out.println("^");
            p.dir = 2;
        }

        if(arr[p.x][p.y] == 'v') {
        	// System.out.println("v");
            p.dir = 3;
        }

        if(arr[p.x][p.y] == '_') {
        	// System.out.println("_");
            if(p.memo == 0) p.dir = 0;
            else p.dir = 1;
        }

        if(arr[p.x][p.y] == '|') {
        	// System.out.println("|");
            if(p.memo == 0) p.dir = 3;
            else p.dir = 2;
        }

        if(arr[p.x][p.y] == '+') {
        	// System.out.println("+");
            if(p.memo == 15) p.memo = 0;
            else p.memo+=1;
        }

        if(arr[p.x][p.y] == '-') {
        	// System.out.println("-");
        	//System.out.println(p.memo);
            if(p.memo == 0) p.memo = 15;
            else p.memo-=1;
            
        }

        if(arr[p.x][p.y] == '?') {
            // 방향을 무작위로 바꾸기
            // 4개중에 하나 고를 수 있음

            for(int i=0; i<4; i++) {
            	v[p.x][p.y][0][p.memo] = true;
            	v[p.x][p.y][1][p.memo] = true;
            	v[p.x][p.y][2][p.memo] = true;
            	v[p.x][p.y][3][p.memo] = true;
            	
            	
            	
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(ny == C) ny = 0;
                if(ny == -1) ny = C-1;

                if(nx == R) nx=0;
                if(nx == -1) nx = R-1;

                dfs(new Program(nx, ny, p.isMeet, i, p.memo));
                if(endFlag) return;

            }
            return;

        }



        int nx = p.x+dx[p.dir];
        int ny = p.y+dy[p.dir];

        if(ny == C) ny=0;
        if(ny == -1) ny = C-1;

        if(nx == R) nx=0;
        if(nx == -1) nx = R-1;

        dfs(new Program(nx, ny, p.isMeet, p.dir, p.memo));
    }


}
