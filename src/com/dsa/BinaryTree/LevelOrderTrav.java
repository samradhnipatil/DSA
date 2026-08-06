package com.dsa.BinaryTree;
import java.util.*;

public class LevelOrderTrav {
    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public class DS{
        int level;
        Node node;

        public DS(int level, Node node){
            this.level = level;
            this.node = node;
        }
    }

    public LevelOrderTrav(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        getLevelOrderTrav(root);
    }

    public void getLevelOrderTrav(Node node){
        if(node == null){
            return;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<DS> q = new LinkedList<>();
        q.add(new DS(0,node));
        while(!q.isEmpty()){
            DS temp = q.remove();
            if(map.containsKey(temp.level)){
                ArrayList<Integer> finalArrList = map.get(temp.level);
                finalArrList.add(temp.node.data);
                map.put(temp.level, finalArrList);
            }
            else{
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.add(temp.node.data);
                map.put(temp.level, newArray);
            }
            if(temp.node.left != null){
                q.add(new DS((temp.level)+1, temp.node.left));
            }
            if(temp.node.right != null){
                q.add(new DS((temp.level)+1, temp.node.right));
            }
        }
        System.out.println(map.values());
    }
}
