package com.dsa.Heap;
import java.util.*;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        ArrayList<ArrayList<Integer>> cmd = new ArrayList<>();
        cmd.add(new ArrayList<>(Arrays.asList(1,1,2)));
        cmd.add(new ArrayList<>(Arrays.asList(1,2,6)));
        cmd.add(new ArrayList<>(Arrays.asList(2,1)));
        cmd.add(new ArrayList<>(Arrays.asList(3,1,2)));
        cmd.add(new ArrayList<>(Arrays.asList(2,1)));
        cmd.add(new ArrayList<>(Arrays.asList(4,1,2)));
        cmd.add(new ArrayList<>(Arrays.asList(1,1,7)));
        cmd.add(new ArrayList<>(Arrays.asList(2,1)));

        for( ArrayList<Integer> i : cmd){
            if(i.getFirst() == 1){
                twitter.postTweet(i.get(1), i.get(2));
            } else if(i.getFirst() == 2){
                System.out.println("News Feed for user " +i.get(1) +": " + twitter.getNewsFeed(i.get(1)));
            } else if(i.getFirst() == 3){
                twitter.follow(i.get(1), i.get(2));
            } else if(i.getFirst() == 4){
                twitter.unFollow(i.get(1), i.get(2));
            }
        }

    }

    public HashMap<Integer, ArrayList<Integer>> follower = new HashMap<>();
    public LinkedList<Node> posts = new LinkedList<>();
    public Node head = null;
    public Twitter(){

    }

    public static class Post{
        int userId;
        int tweetId;

        public Post(int userId, int tweetId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    public static class Node{
        Node prev;
        Node next;
        Post post;

        public Node(Post post){
            this.post = post;
        }
    }

    private void postTweet(int userId, int tweetId) {
        if(head == null){
            head = new Node(new Post(userId, tweetId));
            return;
        }

        Node newPost = new Node(new Post(userId, tweetId));
        head.next = newPost;
        newPost.prev = head;
        head = newPost;
    }

    private ArrayList<Integer> getNewsFeed(int userId){
        Node curr = head;
        int count = 0;
        ArrayList<Integer> newsFeed = new ArrayList<>();
        ArrayList<Integer> followers = follower.get(userId);
        HashSet<Integer> validUsers = new HashSet<>();
        if(followers != null)
           validUsers.addAll(followers);
        validUsers.add(userId);
        while(curr != null && count < 10){
            if(validUsers.contains(curr.post.userId)) {
                newsFeed.add(curr.post.tweetId);
                count++;
            }
            curr = curr.prev;
        }
        return newsFeed;
    }

    private void follow(int followerId, int followeeId){
        if(follower.containsKey(followeeId)) {
            follower.computeIfPresent(followeeId, (k,v) -> {
                v.add(followerId);
                return v;
            });
        }
        else {
            follower.put(followeeId, new ArrayList<>(followerId));
        }
    }

    private void unFollow(int followerId, int followeeId){
        if(follower.containsKey(followeeId)) {
            follower.computeIfPresent(followeeId, (k,v) -> {
                v.remove(followerId);
                return v;
            });
        }
    }

}
