package com.dsa.LinkedList;

public class DetectTheCycle {
    public DetectTheCycle() {
        
    }

    public boolean CycleExists(Node h){
      Node s = h;
      Node f = h;
      while(f.next.next != null && s.next != null){
          s = s.next;
          f = f.next.next;
          if(f == s)
              return true;

      }
      return false;
    }
    
}
