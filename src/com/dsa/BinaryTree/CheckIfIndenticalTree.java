package com.dsa.BinaryTree;

public class CheckIfIndenticalTree {

    public  CheckIfIndenticalTree(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.left = new LevelOrderTrav.Node(6);
        root.left.right.right = new LevelOrderTrav.Node(7);
        root.right.right = new LevelOrderTrav.Node(8);

        LevelOrderTrav.Node root1 = new LevelOrderTrav.Node(1);
        root1.left = new LevelOrderTrav.Node(2);
        root1.right = new LevelOrderTrav.Node(3);
        root1.left.left = new LevelOrderTrav.Node(4);
        root1.left.right = new LevelOrderTrav.Node(5);
        root1.left.right.left = new LevelOrderTrav.Node(6);
        root1.left.right.right = new LevelOrderTrav.Node(7);
        root1.right.right = new LevelOrderTrav.Node(9);

        LevelOrderTrav.Node ans = CheckIdenticalTreeRecursion(root, root1);
        if(ans != null){
            System.out.println("Identical Tree!");
        }
        else{
            System.out.println("Non Identical Tree!");
        }
    }

    public LevelOrderTrav.Node CheckIdenticalTreeRecursion(LevelOrderTrav.Node t1, LevelOrderTrav.Node t2){
        if(t1 == null && t2 == null)
            return new LevelOrderTrav.Node(0);

        if(t1 == null || t2 == null)
            return null;
        if(t1.data != t2.data)
            return null;

        LevelOrderTrav.Node l = CheckIdenticalTreeRecursion(t1.left, t2.left);
        LevelOrderTrav.Node r = CheckIdenticalTreeRecursion(t1.right, t2.right);

        if(l != null && r != null)
            return t1;
        else
            return null;
    }
}
