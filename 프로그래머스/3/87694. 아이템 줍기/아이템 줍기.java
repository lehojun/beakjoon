import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    public class Point{
        int x, y;
        public Point(int x, int y) {
            this.x =x;
            this.y =y;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int n = rectangle.length;
        int m = rectangle[0].length;
        int[][] map = new int[102][102];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                rectangle[i][j] *=2;
            }
            
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            
            for(int j=x1; j<=x2; j++) {
                for(int k=y1; k<=y2; k++) {
                    if(j==x1 || j==x2 || k==y1 || k==y2){
                        if(map[j][k]!=2) {
                            map[j][k]=-1;
                        }
                    }
                    else map[j][k]=2;
                }
            }    
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(characterX*2, characterY*2));
        map[characterX*2][characterY*2] = 1;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx>=0 && ny>=0 && nx<102 && ny<102 && map[nx][ny]==-1){
                    map[nx][ny] = map[p.x][p.y]+1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        
        return map[itemX*2][itemY*2]/2;
    }
}