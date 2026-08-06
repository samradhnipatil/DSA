package com.dsa.BinaryTree;

import java.util.logging.Level;

public class MaximumPathSum {

    public MaximumPathSum(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.left = new LevelOrderTrav.Node(10);
        root.left.right.right = new LevelOrderTrav.Node(6);
        root.left.right.right.left = new LevelOrderTrav.Node(7);
        root.right.right = new LevelOrderTrav.Node(8);

//        int ans = getMaximumPathSumFromRoot(root, 0 ,0);

        int[] max = new int[]{0};
        int ans = getMaximumPathSum(root, 0, max);
        System.out.println(max[0]);
    }

    public int getMaximumPathSumFromRoot(LevelOrderTrav.Node node, int sum, int max){
        if(node == null)
            return 0;

        int l = getMaximumPathSumFromRoot(node.left,sum, max);
        int r = getMaximumPathSumFromRoot(node.right, sum, max);

        sum = sum + node.data + Math.max(l, r);
        max = Math.max(max, sum);

        return max;
    }

    public int getMaximumPathSum(LevelOrderTrav.Node node, int sum, int[] max) {
        if( node == null)
            return 0;

        int sumL = getMaximumPathSum(node.left, sum, max);
        int sumR = getMaximumPathSum(node.right, sum, max);

        sum = node.data + sumL + sumR;
        max[0] = Math.max(max[0] , sum);

        return (node.data + Math.max(sumL, sumR));
    }
}
