package com.dsa.BinaryTree;

public class DiameterOfBT {
    public DiameterOfBT(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.right = new LevelOrderTrav.Node(6);
        root.left.right.right.left = new LevelOrderTrav.Node(7);
        root.right.right = new LevelOrderTrav.Node(8);

        int ans = getDiameterOfBT(root);
        System.out.println(ans);

    }

    public int getDiameterOfBT(LevelOrderTrav.Node node){
        int[] max = new int[1];
        getHeight(node, max);
        return max[0];
    }

    public int getHeight(LevelOrderTrav.Node node , int[] max){
        if(node == null){
            return 0;
        }

        int l = getHeight(node.left, max);
        int r = getHeight(node.right, max);

        max[0] = Math.max(max[0], (l+r));

        return 1 + Math.max(l,r);
    }
}
