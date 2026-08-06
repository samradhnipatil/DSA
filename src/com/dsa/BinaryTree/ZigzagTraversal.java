package com.dsa.BinaryTree;
import java.lang.reflect.Array;
import java.util.*;

public class ZigzagTraversal {
    public ZigzagTraversal(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(5);
        root.left.right = new LevelOrderTrav.Node(6);
        root.left.right.left = new LevelOrderTrav.Node(11);
        root.right.right = new LevelOrderTrav.Node(8);
        root.right.right.right = new LevelOrderTrav.Node(9);
        root.right.right.left = new LevelOrderTrav.Node(10);

        ArrayList<ArrayList<Integer>>  ans  = getZigzagTraversal(root);
        System.out.println(ans);
    }

    public ArrayList<ArrayList<Integer>> getZigzagTraversal(LevelOrderTrav.Node node){
        if(node == null)
            return null;
        Stack<LevelOrderTrav.Node> stack = new Stack<>();
        Stack<LevelOrderTrav.Node> stack1 = new Stack<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        stack.add(node);
        while(!stack.isEmpty()){
            ArrayList<Integer> A = new ArrayList<>();
            while(!stack.isEmpty()){
                LevelOrderTrav.Node temp = stack.pop();
                A.add(temp.data);
                if(temp.left != null)
                    stack1.add(temp.left);
                if(temp.right != null)
                    stack1.add(temp.right);
            }
            ans.add(A);
            ArrayList<Integer> B = new ArrayList<>();
            while(!stack1.isEmpty()){
                LevelOrderTrav.Node temp = stack1.pop();
                B.add(temp.data);
                if(temp.right != null)
                    stack.add(temp.right);
                if(temp.left != null)
                    stack.add(temp.left);
            }
            ans.add(B);
        }
        return ans;
    }
}
