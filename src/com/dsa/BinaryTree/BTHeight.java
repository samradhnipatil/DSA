package com.dsa.BinaryTree;

public class BTHeight {
    public BTHeight(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        int ans  = getHeight(root);
        System.out.println(ans);
    }

    public int getHeight(LevelOrderTrav.Node node){
        if(node == null){
            return 0;
        };
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
