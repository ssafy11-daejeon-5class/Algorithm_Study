import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_대전_05반_김정현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Project[] projects = new Project[N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			projects[n] = new Project(Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()));	
		}
		Arrays.sort(projects);
		
		int start = 301;
		int maxEnd, nextStart = 0;
		int cnt = 0;
		
		while(true) {
			maxEnd = start; 
			for(int i = nextStart; i < N; i++) {
//				System.out.println(projects[i].start + " " + projects[i].end);
				if(projects[i].start > start) {
//					System.out.println("next start: " + projects[i-1].start);
					nextStart = i;
					break;
				}
				if(projects[i].end > maxEnd) {
					maxEnd = projects[i].end;
				}
			}
			if(maxEnd == start) {
				System.out.println("0");
				return;
			}
			cnt++;
			start = maxEnd;
			if(maxEnd > 1130) {
				System.out.println(cnt);
				return;
			}
		}
		
		
		/*
		 * 3월 1일이 포함된 것들 중 종료가 가장 늦은 걸 고른다
		 * 그 종료일이 포함된 것들 중 종료가 가장 늦은 걸 고른다
		 * 반복
		 * 
		 * 매번 정렬을 해야 하나?
		 * 
		 * 그러면 일단 시작일 빠른 순 -> 종료일 늦은 순으로 정렬해놓고
		 * 301보다 시작일 빠른 범위까지 하나씩 탐색하면서 가장 늦은 종료일을 업데이트
		 * 이 다음에는 301을 찾았던 늦은 종료일로 업데이트하고 거기부터 다시 반복
		 * 
		 */
	}
	
}

class Project implements Comparable<Project>{
	int start, end;

	public Project(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Project p) {
		return Integer.compare(this.start, p.start);
	}


}
