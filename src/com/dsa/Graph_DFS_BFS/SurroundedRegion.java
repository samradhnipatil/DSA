package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;

public class SurroundedRegion {

    public SurroundedRegion(){}

    private String[][] getSurroundedRegionByX(String[][] reg){
        int[][] vis = new int[reg.length][reg[0].length];
        String[][] ans = reg.clone();
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 1; i < reg.length-1; i++){
            for(int j = 1; j < reg[0].length-1; j++){
                if(reg[i][j].equals("O")){
                    isReplacePossible(reg, vis, i, j, dirs);
                }
            }
        }
        return ans;
    }

    private void isReplacePossible(String[][] reg, int[][] vis, int i, int j, int[][] dirs){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{i, j});
        vis[i][j] = 1;

        while(!stack.isEmpty()){
            int[] temp = stack.peek();

            boolean ans  = true;
            for(int[] dir : dirs){
                int i1 = temp[0] + dir[0];
                int j1 = temp[1] + dir[1];

                if(i1 >= 0 && j1 >= 0 && i1 < reg.length && j1 < reg[0].length && (reg[i1][j1].equals("X") || vis[i1][j1] == 1)){
                    continue;
                }
                else if( i1 > 0 && j1 > 0 && i1 < reg.length-1 && j1< reg[0].length - 1 && reg[i1][j1].equals("O")){
                    stack.add(new int[]{i1,j1});
                    vis[i1][j1] = 1;
                    ans = false;
                }
                else if(i1 == 0 && j1 == 0 && i1 == reg.length-1 && j1 == reg[0].length - 1 && reg[i1][j1].equals("O"))
                    ans = false;
            }

            if(ans) {
                reg[temp[0]][temp[1]] = "X";
                stack.pop();
            }
        }
    }


    public static void main(String[] args) {
        String[][] reg  = {{"X", "X", "X", "O"}, {"X", "X", "X", "X"}, {"O", "X", "X", "X"}, {"X", "X", "X", "X"}};
        SurroundedRegion surroundedRegion = new SurroundedRegion();
        System.out.println(Arrays.deepToString(surroundedRegion.getSurroundedRegionByX(reg)));
    }
}
