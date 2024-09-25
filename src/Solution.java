import java.util.*;
class Solution {


    StringBuilder sb;
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};
    int graphX, graphY,endX, endY;
    String ans;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb= new StringBuilder();
        graphX = n;
        graphY = m;
        endX = r;
        endY = c;

        int dist = distance(x,y,r,c);
        if(dist >k || (k-dist) %2 ==1){
            return "impossible";
        }

        dfs(x,y,k,0);
        return ans==null?"impossible":ans;
    }

    public void dfs(int cx, int cy, int k, int depth){
        if(ans != null){
            return;
        }

        if(distance(cx,cy,endX,endY)+depth > k){
            return;
        }
        if(depth ==k){
            ans =sb.toString();
            return;
        }

        for(int i=0; i<4; i++){
            int nx =cx +dx[i];
            int ny =cy +dy[i];

            if(nx>0 && nx<=graphX && ny>0 && ny<=graphY){
                sb.append(dir[i]);
                dfs(nx, ny, k, depth+1);
                sb.delete(depth, depth+1);
            }
        }
    }

    private int distance(int x, int y, int r, int c){
        return (int)Math.abs(x-r) + (int)Math.abs(y-c);
    }

}