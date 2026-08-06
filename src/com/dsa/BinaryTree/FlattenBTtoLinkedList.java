package com.dsa.BinaryTree;
import java.util.*;

import java.util.LinkedList;
import java.util.logging.Level;

public class FlattenBTtoLinkedList {

    public LevelOrderTrav.Node prev = null;
    public FlattenBTtoLinkedList(){
        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(3);
        root.left.left = new LevelOrderTrav.Node(4);
        root.right.right = new LevelOrderTrav.Node(5);

        GetFlattenLinkedList(root);
        LevelOrderTrav.Node node = root;
        while(node != null){
            System.out.println(node.data);
            node = node.right;
        }
    }

    public void GetFlattenLinkedList(LevelOrderTrav.Node node){
        if(node == null){
            return;
        }

        GetFlattenLinkedList(node.right);
        GetFlattenLinkedList(node.left);

        node.right = prev;
        node.left = null;

        prev = node;
    }
}
