package study._240312.jeonghyeon;

class 최고의집합 {
    public int[] solution(int n, int s) {
        
        if(n > s)
            return new int[]{-1};
        
        int[] answer = new int[n];
        int basic = s/n;
        int additional = s%n;
        
        for(int i = 0; i < n-additional; i++)
            answer[i] = basic;
        for(int i = n-additional; i < n; i++)
            answer[i] = basic + 1;
        
        return answer;
    }
}