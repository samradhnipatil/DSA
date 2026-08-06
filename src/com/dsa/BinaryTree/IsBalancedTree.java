package com.dsa.BinaryTree;

public class IsBalancedTree {

    public IsBalancedTree(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.left = new LevelOrderTrav.Node(6);
        root.left.right.left.left = new LevelOrderTrav.Node(7);

        int ans  = checkIfBalancedBT(root);
        if( ans == -1)
            System.out.println("Not Balanced BT");
        else
            System.out.println("Balanced Tree");
    }

    public int checkIfBalancedBT(LevelOrderTrav.Node node){
        if(node == null){
            return 0;
        }

        int l = checkIfBalancedBT(node.left);
        int r = checkIfBalancedBT(node.right);

        if(Math.abs(l-r) > 1){
            return -1;
        }
        else{
            return 1 + (Math.max(l,r));
        }
    }
}
