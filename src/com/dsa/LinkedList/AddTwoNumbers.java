package com.dsa.LinkedList;

public class AddTwoNumbers {
    public AddTwoNumbers() {
        Node n1 = new Node(2);
        n1.next = null;
        n1.Insertion(n1, 4);
        n1.Insertion(n1, 3);

        Node n2 = new Node(5);
        n2.next = null;
        n2.Insertion(n2, 6);
        n2.Insertion(n2, 7);
        n2.Insertion(n2, 9);

        Node ans = Add(n1,n2);
        while(ans != null){
            System.out.print(ans.val+ " ");
            ans = ans.next;
        }
    }

    public Node Add(Node n1, Node n2){

        int carry = 0;

        int sum = n1.val + n2.val + carry;
        if(sum > 9){
            carry = sum / 10;
            sum = sum % 10;
        }
        Node ans = new Node(sum);
        Node head = ans;
        n1 = n1.next;
        n2 = n2.next;

        while(n1 != null && n2 != null){
            sum = n1.val + n2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            n1 = n1.next;
            n2 = n2.next;
            ans.next = new Node(sum);
            ans = ans.next;
        }
        while(n1 != null){
            sum = n1.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else
                carry = 0;
            n1 = n1.next;
            ans.next = new Node(sum);
            ans = ans.next;
        }
        while(n2 != null){
            sum = n2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
            }
            else
                carry = 0;
            n2 = n2.next;
            ans.next = new Node(sum);
            ans = ans.next;
        }
        if(carry != 0){
            ans.next = new Node(carry);
        }
        return head;
    }
}
