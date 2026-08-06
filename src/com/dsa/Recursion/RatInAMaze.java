package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class RatInAMaze {
    public RatInAMaze() {
        int[][] m = {{1,0,0,0},{1,1,0,1},{1,1,0,1},{0,1,1,1}};
        FindPath(m,"");
    }

    public void FindPath( int[][] m,String path){
        HelpTheRat(m,0,0,m.length,new int[m.length][m.length],"");
    }

    public void HelpTheRat(int[][] m, int i, int j, int n , int[][] isVisited, String path){
        if(i == n-1 && j == n-1){
            System.out.println(path);
            return;
        }
        // up
        if(i != 0 && isVisited[i-1][j] != 1 && m[i-1][j] == 1){
            path = path + "U";
            isVisited[i-1][j] = 1;
            HelpTheRat(m,i-1,j,n,isVisited,path);
            isVisited[i-1][j] = 0;
            path = path.substring(0, path.length()-1);
        }
        // left
        if(j != 0 && isVisited[i][j-1] != 1 && m[i][j-1] == 1){
            path = path + "L";
            isVisited[i][j-1] = 1;
            HelpTheRat(m,i, j-1,n,isVisited,path);
            isVisited[i][j-1] = 0;
            path = path.substring(0, path.length()-1);
        }
        // down
        if(i != n-1 && isVisited[i+1][j] != 1 && m[i+1][j] == 1){
            path = path + "D";
            isVisited[i+1][j] = 1;
            HelpTheRat(m,i+1, j,n,isVisited,path);
            isVisited[i+1][j] = 0;
            path = path.substring(0, path.length()-1);
        }
        // right
        if(j != n-1 && isVisited[i][j+1] != 1 && m[i][j+1] == 1){
            path = path + "R";
            isVisited[i][j+1] = 1;
            HelpTheRat(m,i, j+1,n,isVisited,path);
            isVisited[i][j+1] = 0;
            path = path.substring(0, path.length()-1);
        }
    }
}
