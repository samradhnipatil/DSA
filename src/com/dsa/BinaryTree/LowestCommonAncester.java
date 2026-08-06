package com.dsa.BinaryTree;

import java.util.logging.Level;

public class LowestCommonAncester {

    public LowestCommonAncester(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.left = new LevelOrderTrav.Node(6);
        root.left.right.right = new LevelOrderTrav.Node(7);
        root.right.right = new LevelOrderTrav.Node(8);

        LevelOrderTrav.Node node = getLowestCommonAncester(root,4,7);

        System.out.println(node.data);
    }

    public LevelOrderTrav.Node getLowestCommonAncester(LevelOrderTrav.Node node, int p, int q){
        if(node == null || node.data == p || node.data == q)
            return node;

        LevelOrderTrav.Node l = getLowestCommonAncester(node.left,p,q);
        LevelOrderTrav.Node r = getLowestCommonAncester(node.right, p,q);

        if( l == null )
            return r;
        else if( r == null )
            return l;
        else
            return node;
    }
}
