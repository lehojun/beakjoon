class Solution {
    int answer = 0;
    
    public void DFS(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer ++;
            }
            return;
        }
        DFS(numbers, depth+1, sum + numbers[depth], target);
        DFS(numbers, depth+1, sum - numbers[depth], target);
    }
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, 0, target);
        return answer;
    }
}