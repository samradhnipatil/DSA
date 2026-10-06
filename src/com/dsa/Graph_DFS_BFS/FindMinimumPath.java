package com.dsa.Graph_DFS_BFS;

public class FindMinimumPath {

    public FindMinimumPath(){}

    private String findShortestPath(int[][] mat, int s1, int s2, int e1, int e2, String path,String ans, int[][] vis){

        if(s1 == e1 && s2 == e2){
            ans = ans.length() > path.length() || ans.isEmpty() ? path : ans;
            System.out.println("Possible Path : "+path);
            return ans;
        }
        // upper
        if(isValid(mat, s1-1, s2) && vis[s1-1][s2] != 1 && mat[s1-1][s2] == 1){
            path = path + "U";
            vis[s1-1][s2] = 1;
            ans = findShortestPath(mat,s1-1, s2, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1-1][s2] = 0;
        }

        // upper-right
        if(isValid(mat, s1-1, s2+1) && vis[s1-1][s2+1] != 1 && mat[s1-1][s2+1] == 1){
            path = path + "W";
            vis[s1-1][s2+1] = 1;
            ans = findShortestPath(mat,s1-1, s2+1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1-1][s2+1] = 0;
        }

        // right
        if(isValid(mat, s1, s2+1) && vis[s1][s2+1] != 1 && mat[s1][s2+1] == 1){
            path = path + "R";
            vis[s1][s2+1] = 1;
            ans = findShortestPath(mat,s1, s2+1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1][s2+1] = 0;
        }

        // right down
        if(isValid(mat, s1+1, s2+1) && vis[s1+1][s2+1] != 1 && mat[s1+1][s2+1] == 1){
            path = path + "X";
            vis[s1+1][s2+1] = 1;
            ans = findShortestPath(mat,s1+1, s2+1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1+1][s2+1] = 0;
        }
        // down

        if(isValid(mat, s1+1, s2) && vis[s1+1][s2] != 1 && mat[s1+1][s2] == 1){
            path = path + "D";
            vis[s1+1][s2] = 1;
            ans = findShortestPath(mat,s1+1, s2, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1+1][s2] = 0;
        }

        // down - left

        if(isValid(mat, s1+1, s2-1) && vis[s1+1][s2-1] != 1 && mat[s1+1][s2-1] == 1){
            path = path + "Y";
            vis[s1+1][s2-1] = 1;
            ans = findShortestPath(mat,s1+1, s2-1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1+1][s2-1] = 0;
        }
        // left
        if(isValid(mat, s1, s2-1) && vis[s1][s2-1] != 1 && mat[s1][s2-1] == 1){
            path = path + "L";
            vis[s1][s2-1] = 1;
            ans = findShortestPath(mat,s1, s2-1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1][s2-1] = 0;
        }

        // left - upper
        if(isValid(mat, s1-1, s2-1) && vis[s1-1][s2-1] != 1 && mat[s1-1][s2-1] == 1){
            path = path + "Z";
            vis[s1-1][s2-1] = 1;
            ans = findShortestPath(mat,s1-1, s2-1, e1, e2, path, ans, vis );
            path = path.substring(0, path.length()-1);
            vis[s1-1][s2-1] = 0;
        }
        return ans;
    }

    private boolean isValid(int[][] mat, int i, int j){
        return i >= 0 && j >= 0 && i < mat.length && j < mat[0].length;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,1},{0,1,1,1},{1,0,1,0},{0,1,1,0}};
        int s1 = 0;
        int s2 = 0;
        int e1 = 3;
        int e2 = 2;

        FindMinimumPath findMinimumPath = new FindMinimumPath();
        String ans = findMinimumPath.findShortestPath(mat, s1,s1,e1,e2,"","",new int[mat.length][mat[0].length]);
        System.out.println(ans);

    }
}
