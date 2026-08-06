package com.dsa.BinaryTree;
import java.util.*;

public class SymmetricalBT {
    public SymmetricalBT(){

        LevelOrderTrav.Node root = new LevelOrderTrav.Node(1);
        root.left = new LevelOrderTrav.Node(2);
        root.right = new LevelOrderTrav.Node(2);
        root.left.left = new LevelOrderTrav.Node(4);
        root.left.right = new LevelOrderTrav.Node(5);
        root.right.right = new LevelOrderTrav.Node(4);
        root.right.left = new LevelOrderTrav.Node(5);

        boolean ans = checkSymmetricBT(root);
        System.out.println(ans);
    }

    public boolean checkSymmetricBT(LevelOrderTrav.Node node){
        if(node == null)
            return false;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1 = GetInorder(node.left, arr1);
        arr2 =  GetReverseInOrder(node.right,arr2);
        return arr1.equals(arr2);
    }

    public ArrayList<Integer> GetInorder(LevelOrderTrav.Node node, ArrayList<Integer> arr){
        if(node == null){
            return arr;
        }

        arr = GetInorder(node.left, arr);
        arr.add(node.data);
        arr = GetInorder(node.right, arr);
        return arr;
    }

    public ArrayList<Integer> GetReverseInOrder(LevelOrderTrav.Node node, ArrayList<Integer> arr){
        if(node == null){
            return arr;
        }

        arr = GetReverseInOrder(node.right, arr);
        arr.add(node.data);
        arr = GetReverseInOrder(node.left, arr);
        return arr;
    }

    public int GetInorderData(LevelOrderTrav.Node node){
        if(node == null){
            return 0;
        }

        if(node.left != null){
            GetInorderData(node.left);
        }
        else{
            return node.data;
        }
        if(node.right != null){
            GetInorderData(node.right);
        }
        else{
            return node.data;
        }
        return 0;
    }

    public int GetRevInorderData(LevelOrderTrav.Node node){
        if(node == null){
            return 0;
        }

        if(node.right != null){
            GetRevInorderData(node.right);
        }
        else{
            return node.data;
        }
        if(node.left != null){
            GetRevInorderData(node.left);
        }
        else{
            return node.data;
        }
        return 0;
    }

}
