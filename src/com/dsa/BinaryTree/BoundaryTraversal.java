package com.dsa.BinaryTree;
import java.util.*;
import java.util.logging.Level;

public class BoundaryTraversal {
    public BoundaryTraversal(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.left.right.left = new LevelOrderTrav.Node(10);
        root.left.right.right = new LevelOrderTrav.Node(6);
        root.left.right.right.left = new LevelOrderTrav.Node(7);
        root.right.right = new LevelOrderTrav.Node(8);

        ArrayList<Integer> ans = new ArrayList<>();
        ans = getLeftBoundaryOfBT(root, ans);
        ans = getBottomBoundaryOfBT(root, ans);

        Stack<Integer> s = new Stack<>();
        s = getRightBoundaryOfBT(root.right, s);

        while(!s.isEmpty()){
            ans.add(s.pop());
        }

        System.out.println(ans.toString());
    }

    public ArrayList<Integer> getLeftBoundaryOfBT(LevelOrderTrav.Node node ,ArrayList<Integer> ds){
        LevelOrderTrav.Node curr = node;
        while(curr != null){
            if(curr.left != null && curr.right != null){
                ds.add(curr.data);
            }
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return ds;
    }

    public ArrayList<Integer> getBottomBoundaryOfBT(LevelOrderTrav.Node node, ArrayList<Integer> ds){
        if(node == null)
            return null;

        if(node.left == null && node.right == null)
            ds.add(node.data);
        getBottomBoundaryOfBT(node.left, ds);
        getBottomBoundaryOfBT(node.right, ds);

        return ds;
    }

    public Stack<Integer> getRightBoundaryOfBT(LevelOrderTrav.Node node , Stack<Integer> s){
        LevelOrderTrav.Node curr = node;

        while(curr != null){
            if(curr.left != null || curr.right != null)
                s.add(curr.data);
            if(curr.right != null)
                curr =  curr.right;
            else
                curr = curr.left;
        }
        return s;
    }
}

