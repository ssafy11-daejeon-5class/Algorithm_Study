package study._240312.jeonghyeon;

class 행렬테두리회전하기 {
    
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                map[r][c] = r * columns + c + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            answer[i] = turnAndGetSmallest(queries[i]);
        }
        
        // Arrays.sort(answer);
        
        return answer;
    }
    
    public int turnAndGetSmallest(int[] query){
        int minR = query[0] - 1;
        int minC = query[1] - 1;
        int maxR = query[2] - 1;
        int maxC = query[3] - 1;
        
        int temp = map[minR][minC];
        int minVal = temp;
        
        for(int r = minR; r < maxR; r++){
            map[r][minC] = map[r + 1][minC];
            minVal = Math.min(minVal, map[r][minC]);
        }
        
        for(int c = minC; c < maxC; c++){
            map[maxR][c] = map[maxR][c + 1];
            minVal = Math.min(minVal, map[maxR][c]);
        }
        
        for(int r = maxR; r > minR; r--){
            map[r][maxC] = map[r - 1][maxC];
            minVal = Math.min(minVal, map[r][maxC]);
        }
        
        for(int c = maxC; c > minC; c--){
            map[minR][c] = map[minR][c - 1];
            minVal = Math.min(minVal, map[minR][c]);
        }
        map[minR][minC + 1] = temp;
        
        
        return minVal;
    }
}