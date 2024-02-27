import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class mAlgo3_대전_05반_김정현 {
	
	static int N;
	static List<Bongwoori> bongList;
	static Node[] nodeList;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		bongList = new ArrayList<>();
		

		st = new StringTokenizer(br.readLine());
		int nowX = Integer.parseInt(st.nextToken());
		int nowY = Integer.parseInt(st.nextToken());
		boolean isPrevYPlus = (nowY > 0);
		int firstX = Integer.MAX_VALUE;
		
		Bongwoori b = new Bongwoori(Integer.MAX_VALUE);
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nowX = Integer.parseInt(st.nextToken());
			nowY = Integer.parseInt(st.nextToken());
			if((nowY > 0) == isPrevYPlus) 
				continue;
			if(nowY > 0) {
				isPrevYPlus = true;
				b = new Bongwoori(nowX);
			}
			if(nowY < 0) {
				isPrevYPlus = false;
				if(b.startX == Integer.MAX_VALUE) {
					firstX = nowX;
					continue;
				}
				
				if(nowX < b.startX) { 
					b.endX = b.startX;
					b.startX = nowX;
				}
				else 
					b.endX = nowX;
				bongList.add(b);
			}
			
			if(i == N-1 && b.endX == Integer.MAX_VALUE) {
				if(b.endX < firstX) { 
					b.startX = b.endX;
					b.endX = firstX;
				}
				else 
					b.startX = firstX;
				bongList.add(b);
			}
			
		}
		
		bongList.sort(null);
//		
//		for(int i = 0; i < bongList.size(); i++) {
//			System.out.println(bongList.get(i).startX + " " + bongList.get(i).endX);
//		}
		
		nodeList = new Node[bongList.size()];
		Node headNode = new Node(new Bongwoori(Integer.MIN_VALUE, Integer.MAX_VALUE));
		for(int idx = 0; idx < bongList.size(); idx++) {
			Node node = new Node(bongList.get(idx));
			Node nowNode = headNode;
			findMyJokbo(nowNode, node);
			nodeList[idx] = node;
		}
		
		
		int notHuggedCnt = headNode.children.size();
		int notHuggingCnt = 0;
		for(int i = 0; i < nodeList.length; i++) {
			if (nodeList[i].children.size() == 0)
				notHuggingCnt++;
		}
		System.out.println(notHuggedCnt + " " + notHuggingCnt);
		
		
		/*
		 * 
		 * 1. 여전히 아래에 있을 때 => continue
		 * 2. 여전히 위에 있을 때 => continue
		 * 3. 아래에서 위로 올라왔을 때 => 봉우리 객체 생성 및 startX 저장
		 * 		startX를 먼저 저장 후 endX를 저장해주면 됨
		 * 4. 위에서 아래로 내려갔을 때 => 봉우리 객체에 endX 저장 및 큐든 리스트든 어딘가에 삽입
		 * 		처음 입력부터 이렇게 되는 경우 
		 * 
		 * 
		 * 
		 * 입력 후 정렬까지 완료
		 * 이제 재귀로 간다
		 * 어떤 봉우리가 10~90일 때
		 * 다음 봉우리를 확인할 때 notHuggingCnt++
		 * 이 다음 봉우리가 20~80이면
		 * 		만약 10~90 봉우리가 isHugging = true면 notHuggingCnt 변화 x , 
		 * 			false면 true로 바꾸고 notHuggingCnt--; 
		 * 이 다음 봉우리가 100~110이면
		 * 		10~90 봉우리의 함수를 탈출 
		 * 		만약 탈출 후에도 부모가 있다면
		 * 
		 * 		부모 진짜 없으면 notHuggedCnt++
		 * 
		 */
		
		
	}
	
	static boolean findMyJokbo(Node nowNode, Node node) {
		if(nowNode.children.size() == 0) {
			nowNode.children.add(node);
			return true;
		}
		for(int i = 0; i < nowNode.children.size(); i++) {
			if(nowNode.children.get(i).bong.startX < node.bong.startX && nowNode.children.get(i).bong.endX > node.bong.endX) {
				return findMyJokbo(nowNode.children.get(i), node);
			}
		}
		nowNode.children.add(node);
		return true;
		
	}
	
	static class Node{
		Bongwoori bong;
		List<Node> children;
		
		public Node(Bongwoori b) {
			this.bong = b;
			children = new ArrayList<>();
		}
	}
	
	static class Bongwoori implements Comparable<Bongwoori>{
		int startX, endX;

		public Bongwoori(int startX) {
			super();
			this.startX = startX;
			this.endX = Integer.MAX_VALUE;
		}
		
		public Bongwoori(int startX, int endX) {
			super();
			this.startX = startX;
			this.endX = endX;
		}
		
		@Override
		public int compareTo(Bongwoori b) {			
			return this.startX - b.startX;
			
		}
		
	}
}
