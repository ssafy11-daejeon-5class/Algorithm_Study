package study.common.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class JavaGrammar {

	public static void print(Object o) {
		System.out.println(o);
	}
	public static void print() {
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {

		String my_str = "abcdef"; // java는 변수 앞에 형 선언

		/* 문자열의 길이 */
		print("\n**string length**");
		print(my_str.length()); // 길이 반환 
		print(my_str.isEmpty()); // 길이가 0이면 True, 아니면 False 반환

		/* 문자열 자르기 */
		//(1) split 함수 
		print("\n**string split**");
		print(my_str.split("c")[0]); // split("분리할 문자열 기준") : "ab" 출력
		print(my_str.split("")[0]); // 띄어쓰기 없는 문자열 str을 한 문자씩 분리해서 배열 반환 : "ab" 출력
		print(my_str.split("c", 2)[0]); // ("분리할 문자열 기준", "배열의 크기 한정") : "ab" 출력

		String[] str1 = my_str.split("c"); // 반복문으로 자른 문자열의 배열
		for (String s: str1){ 
			// 배열에서만 가능한 for 문 
			print(s); // split 된 배열의 각 요소 출력 
		}

		//(2) substring 함수
		print("\n**substring**");
		print(my_str.substring(2)); // 해당 Index 문자열부터 출력 : "cdef" 출력
		print(my_str.substring(0, 2)); // start idx ~ end idx -1 까지 출력 : "ab" 출력

		//(4) trim 
		print("\n**trim : 문자열 앞 뒤 공백 제거**");
		print(my_str.trim()); // my_str의 앞 뒤 공백 제거, 문자열 사이의 공백은 제거 X 

		/* 대소문자 변경 */
		print("\n**UpperCase & LowerCase**");
		String str = "HellO WOrlD!";
		print(str.toUpperCase()); // 문자열 전체 대문자로 : HELLO WORLD!
		print(str.toLowerCase()); // 문자열 전체 소문자로 : hello world!
		print(Character.toUpperCase('c')); //단일 문자 대문자로
		print(Character.toLowerCase('C')); //단일 문자 소문자로

		/*char의 대소문자 확인*/
		char letter = 'a';
		print(Character.isLowerCase(letter)); //소문자니까 true 반환 

		print("\n**문자열 비교**");
		/*문자열 비교*/
		String s = "Starbucks";
		s.equals("Starbucks"); // 같기 때문에 True , 아니라면 False 반환
		s.equalsIgnoreCase("sta"); // 문자열 간의 대소문자를 무시하고 비교 후 값 반환
		s.contains("buck"); // 포함되니까 True, 아니면 False 반환 

		s.startsWith("S"); // "S"로 시작하는지
		s.endsWith("ks"); // "ks"로 끝나는지

		/*위치 찾기*/
		print("\n**문자열 인덱스**");
		String text = "Hello, world!";
		print(text.indexOf("world")); // 문자열이 처음 나타나는 위치의 인덱스 반환 : 7 출력
		print(text.indexOf('o')); // 주어진 문자가 처음 나타나는 인덱스 반환 : 4 출력
		print(text.indexOf('o', 5)); // 'o'라는 문자/문자열이 주어진 인덱스 5 이후에 처음으로 나타는 인덱스 반환 : 7 출력
		print(text.lastIndexOf("o")); // "o"문자의 마지막 인덱스 반환 : 8 출력 

		/*형 변환*/
		print(Integer.parseInt("320")); // 문자열 -> 숫자로 변환 : 출력 320
		print(Integer.toString(320)); // 숫자 -> 문자열로 변환 : 출력 "320"

		/*문자열 뒤집기*/
		str = "hello";
		print(new StringBuilder(str).reverse().toString()); 
		//출력 : olleh
		
		
		
		
		
		
		StringBuilder sb = new StringBuilder();

		sb.append("abc"); // 문자열 추가
		sb.insert(2, "dd"); // 인덱스 2 위치에 dd 추가 

		sb.delete(0, 2); // 0~1 사이 인덱스에 위치한 문자열 삭제 
		sb.deleteCharAt(2); // 인덱스 2에 위치한 문자열 삭제 

		sb.setCharAt(0, 'f'); // 인덱스 0에 위치한 문자를 f로 변경 

		sb.reverse(); // 문자열 뒤집기

		sb.setLength(2); // 문자열 길이를 2로 줄인다 -> "ab"로 바뀜
		sb.setLength(4); // 문자열 길이를 4로 늘린다 -> 뒤가 공백으로 채워짐 


		
		
		
		

		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		list.add("서울"); //리스트 가장 뒤에 서울 삽입
		list.add(1, "대전"); // 인덱스 1의 위치에 대전 삽입
		list.addAll(list); // list 뒤에 list2 전부 삽입! 

		list.get(0); // 인덱스 0의 위치에 있는 값 반환 (서울)
		list.set(0, "대구"); // 0위치의 값을 대구로 바꾸기 

		list.indexOf("대구"); // 대구의 첫 인덱스 반환 
		list.lastIndexOf("대구"); // 대구의 마지막 인덱스 반환

		list.remove(0); // 0 위치의 값 삭제 
		list.remove("대구"); // 첫 "대구" 값을 삭제 
		list.removeAll(list2); // list에서 list2에 들어있는 모든 값을 삭제 
		list.retainAll(list2); // list에서 list2에 들어있는 값을 제외하고 모두 삭제 

		list.clear(); // 전체 초기화
		list.isEmpty();// 길이가 0이면 True
		list.size(); // 리스트의 길이 반환 

		list.contains("서울"); // 서울이 list에 존재하면 true, 아니면 false 
		list.containsAll(list2); // list에 list2의 모든 값이 포함되면 true

		list.removeIf(k -> k != "i"); // 람다식으로 홀수를 list 에서 제거 
		
		
		
		
		/*선언*/
		ArrayList<Integer> integer1 = new ArrayList<>();
		//new ArrayList 쪽 자료형, 크기 전부 생략 가능
		//ex(1): ArrayList<Integer> integer1 = new ArrayList<Integer>();
		//ex(2): ArrayList<Integer> integer1 = new ArrayList<>();
		//ex(3): ArrayList<Integer> integer1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

		/*추가*/
		integer1.add(6);
		integer1.add(2);
		integer1.add(2);
		/*제거*/
		integer1.remove(0); //element 직접 입력 혹은 인덱스 입력 가능
		/*대체*/
		integer1.set(1, 2);
		/*정렬*/

		Collections.sort(integer1); // 오름차순 정렬

		//그 외 string 비슷한 방법들로 handle 가능 
		
		
		
		
		/* 문자열 배열 -> List */
		String[] tmp = {};
		List<String> list1 = new ArrayList<>(Arrays.asList(tmp));

		/* List -> 문자열 배열 */
		list1 = new ArrayList<>();
		tmp = list.toArray(new String[list.size()]);

		/* 정수 배열 -> List */
		int[] tmp2 = {123, 1222, 563, 7531};
		List<Integer> list3 = new ArrayList<>();

		/* List -> 정수 배열 */
		list3 = new ArrayList<>();
		tmp2 = list3.stream().mapToInt(i->i).toArray(); 
		
		
		// String 배열/리스트 -> Int 변환
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//System.out.println(Arrays.asList(st.toString().split(" ")).get(1));
		List<Integer> arr = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		
		

		/*HashMap 선언*/
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(); // key와 value가 전부 integer 
		map1 = new HashMap<>(); //new에서 타입 파라미터 생략 가능
		map1 = new HashMap<>(10); // 초기 크기 설정 가능 
		HashMap<String, String> map2 = new HashMap<>(){{
			put("key1", "value1");
		    put("key2", "value2");
		}}; //초기 값 설정
		
		/*값 추가*/
		HashMap<Integer, String> num_map = new HashMap<Integer, String>();
		num_map.put(1, "one");
		num_map.put(2, "two");
		
		/*값 삭제*/
		num_map = new HashMap<Integer, String>(){{
			put(1,"One");
		    put(2,"Two");
		    }};
		num_map.remove(2); // key값 2 제거 (오직 키 값으로만 제거 가능)
		num_map.clear(); 
		
		/*값 출력*/
		num_map = new HashMap<Integer, String>(){{
			put(1,"One");
		    put(2,"Two");
		    }};
		System.out.println(num_map); // 전체 출력
		System.out.println(num_map.get(1)); // key값이 1인 value 출력 
		
		
		//entrySet을 활용한 출력 -- key, value 모두 필요할 때
		for(Entry<Integer, String> entry: num_map.entrySet())
		{
			System.out.println("[Key]= " + entry.getKey() + "[Value]= " + entry.getValue());
		 }   
		 
		 //KeySet을 활용한 출력 -- key 값만 필요할 때 
		//물론 keySet을 사용하더라도 value까지 추출이 가능하지만 시간 복잡도가 증가하므로 value까지 필요하다면 entrySet을 사용하자!
		 for(Integer i: num_map.keySet()){
		 	System.out.println("[Key]= "+i + "[Value]= "+ num_map.get(i));
		    }
		
		num_map.containsKey(2); //특정 키 포함 여부

		
		
		
		
		
		/*Queue 생성*/
		Queue<Integer> queue = new LinkedList<>();
		Queue<String> s_queue = new LinkedList<>();

		/*add 과정*/
		queue.add(1);
		s_queue.add("wtf");
		queue.offer(3);

		/*꺼내기*/
		int num1 = queue.poll();
		String line = s_queue.poll();

		/*queue의 첫번째로 들어간 값 참조*/
		queue.peek();
		
		
		
		
		
		
		/*priority queue 선언*/
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //int형 priorityQueue 선언 (우선순위가 높은 숫자 순)

		/*priority queue 값 추가 및 제거 */
		priorityQueue.add(3);
		priorityQueue.offer(2);

		priorityQueue.poll();
		priorityQueue.remove();

		/*priorityQueue에서 가장 우선 순위가 높은 값 출력*/
		priorityQueue.peek();
		
		
	}
}
