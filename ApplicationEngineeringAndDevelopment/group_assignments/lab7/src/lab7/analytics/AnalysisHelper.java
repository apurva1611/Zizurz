/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {

    // Ex1 find 5 comments which have the most likes
    public void getTopFiveLikedComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(comments.values());

        Comparator<Comment> test = new Comparator<Comment>() {
            public int compare(Comment c1, Comment c2) {
                return c2.getLikes() - c1.getLikes();
            }
        };
        System.out.println("--------------------\nEx.1: FIVE MOST LIKED COMMENTS\n--------------------");
        Collections.sort(commentList, test);
        for (int i = 0; i < comments.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }

    // Ex2 find user with Most Likes
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        System.out.println("--------------------\nEx.2: USER WITH MOST LIKES\n--------------------\nLikes: " + max + "\nUser: " + users.get(maxId));
    }

    //#1 Average No of likes per comment
    public void AverageLikes() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likes = 0;
        for (Comment c : comments.values()) {
            likes += c.getLikes();
        }
        System.out.println("--------------------\n1. AVERAGE NO. OF LIKES PER COMMENT\n--------------------\nAverage Likes: " + likes / comments.values().size());
    }

    // #2 Post with most liked comments
    public void getPostMostLikedComment() {
        Map<Post, List<Comment>> postComment = new HashMap<>();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        for (Post p : posts.values()) {
            postComment.put(p, p.getComments());

        }
        Post post = null;
        int totalSum = 0;
        for (Post p : postComment.keySet()) {
            for (Comment c : postComment.get(p)) {
                if (c.getLikes() > totalSum) {
                    totalSum = c.getLikes();
                    post = p;
                }
            }
        }
        System.out.println("--------------------\n2. POST WITH MOST LIKED COMMENTS\n--------------------");
        System.out.println("Post Id: " + post.getPostId());
        System.out.println("Posting user Id: " + post.getUserId());
        System.out.println("Likes Number: " + totalSum);
        System.out.println("Containing Comments: ");
        List<Comment> comments = postComment.get(post);
        for (Comment comment : comments) {
            System.out.println(comment);
        }

    }

    // #3. Post with most comments
    public void getPostWithMostComments() {
        Post post = null;
        int commentCount = 0;
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        for (Post p : posts.values()) {
            if (p.getComments().size() > commentCount) {
                commentCount = p.getComments().size();
                post = p;
            }
        }
        System.out.println("--------------------\n3. POST WITH MOST COMMENTS\n--------------------");
        System.out.println("Post Id with most comments: " + post.getPostId());
        System.out.println("Comment count of the post: " + commentCount);

    }

    //#4. top 5 inactive users based on total posts number
    public void getInactiveUsersBasedOnPosts() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        // each userid with all its posts
        Map<User, List<Post>> usersWithPost = new HashMap<>();
        for (Post p : posts.values()) {
            User u = searchUserById(p.getUserId());
            if (usersWithPost.containsKey(u)) {
                List<Post> oldposts = usersWithPost.get(u);
                oldposts.add(p);
                usersWithPost.put(u, oldposts);
            } else {
                List<Post> post = new ArrayList<>();
                post.add(p);
                usersWithPost.put(u, post);
            }
        }
        List<List<Post>> postwithusersList = new ArrayList<>(usersWithPost.values());
        Collections.sort(postwithusersList, new Comparator<List<Post>>() {
            @Override
            public int compare(List<Post> p1, List<Post> p2) {
                return p1.size() - p2.size();
            }
        });
        List<User> user = new ArrayList<>();
        int i = 0;
        System.out.println("--------------------\n4. Top 5 inactive users based on total posts number \n--------------------");
        int j = 0;
        int sum = postwithusersList.get(0).size();
        for (List<Post> p : postwithusersList) {
            for (Post onePost : p) {
                if (i == 0) {
                    int k = j + 1;
                    System.out.println("Rank " + k);
                }
                if (j < 4 && i < users.size()) {
                    if (postwithusersList.get(i).size() != sum) {
                        j++;
                        sum = postwithusersList.get(i).size();
                        int k = j + 1;
                        System.out.println("Rank " + k);
                        User u = searchUserById(onePost.getUserId());
                        System.out.println(u);
                        System.out.println("Post size: " + postwithusersList.get(i).size());
                        i++;
                        break;
                    } else {
                        User u = searchUserById(onePost.getUserId());
                        System.out.println(u);
                        System.out.println("Post size: " + postwithusersList.get(i).size());
                        i++;
                        break;
                    }

                }
            }
        }
    }

    //#5. top 5 inactive users based on comments they created
    public void getInactiveUsersBasedOnComments() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(users.values());
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getComments().size() - u2.getComments().size();
            }
        });
        System.out.println("--------------------\n5. Top 5 inactive users based on total comments they created \n--------------------");
        int j = 0;
        int sum = userList.get(0).getComments().size();
        for (int i = 0; i < userList.size() && j < 4; i++) {
            if (i == 0) {
                int k = j + 1;
                System.out.println("Rank " + k);
            }
            if (userList.get(i).getComments().size() != sum) {
                j++;
                int k = j + 1;
                System.out.println("Rank " + k);
                sum = userList.get(i).getComments().size();
                System.out.println(userList.get(i));
            } else {
                System.out.println(userList.get(i));
            }
        }
    }

//  6.  Top 5 inactive users overall (sum of comments, posts and likes)
    public void getTopFiveInactiveUsers() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        HashMap<User, Integer> userSum = new HashMap<>();
        Map<User, List<Post>> userPosts = new HashMap<>();

        for (Post p : posts.values()) {
            User u = searchUserById(p.getUserId());
            if (userPosts.containsKey(u)) {
                List<Post> oldposts = userPosts.get(u);
                oldposts.add(p);
                userPosts.put(u, oldposts);
            } else {
                List<Post> post = new ArrayList<>();
                post.add(p);
                userPosts.put(u, post);
            }
        }
        for (User u : users.values()) {
            int likes = 0;
            int totalComments = u.getComments().size();
            for (Comment c : u.getComments()) {
                likes += c.getLikes();
            }
            int totalLikes = likes;
            List<Post> uPost = userPosts.get(u);
            int totalPosts = uPost.size();
            int total = totalComments + totalLikes + totalPosts;
            userSum.put(u, total);
        }

        System.out.println("--------------------\n6. Top 5 inactive users overall (sum of comments, posts and likes) \n--------------------");
        ArrayList<User> userList = new ArrayList<User>();
        TreeMap<User, Integer> sortedMap = sortMapByValue(userSum);

        for(User u : sortedMap.keySet()){
            userList.add(u);
        }
        
        for(int i = 0; i < 5; i++){
            System.out.println("Rank " + i);
            System.out.println(userList.get(i));
        }
    }
    
    
//  7.  Top 5 proactive users overall (sum of comments, posts and likes)
    public void getTopFiveProactiveUsers() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        HashMap<User, Integer> userSum = new HashMap<>();
        Map<User, List<Post>> userPosts = new HashMap<>();

        for (Post p : posts.values()) {
            User u = searchUserById(p.getUserId());
            if (userPosts.containsKey(u)) {
                List<Post> oldposts = userPosts.get(u);
                oldposts.add(p);
                userPosts.put(u, oldposts);
            } else {
                List<Post> post = new ArrayList<>();
                post.add(p);
                userPosts.put(u, post);
            }
        }
        for (User u : users.values()) {
            int likes = 0;
            int totalComments = u.getComments().size();
            for (Comment c : u.getComments()) {
                likes += c.getLikes();
            }
            int totalLikes = likes;
            List<Post> uPost = userPosts.get(u);
            int totalPosts = uPost.size();
            int total = totalComments + totalLikes + totalPosts;
            userSum.put(u, total);
        }

        System.out.println("--------------------\n7. Top 5 proactive users overall (sum of comments, posts and likes) \n--------------------");
        ArrayList<User> userList = new ArrayList<User>();
        TreeMap<User, Integer> sortedMap = sortMapByValueD(userSum);

        for(User u : sortedMap.keySet()){
            userList.add(u);
        }
        
        for(int i = 0; i < 5; i++){
            System.out.println("Rank " + i);
            System.out.println(userList.get(i));
        }
    }

    private User searchUserById(int userId) {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<>(users.values());
        for (User u : userList) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }

    public static TreeMap<User, Integer> sortMapByValue(HashMap<User, Integer> map) {
        Comparator<User> comparator = new ValueComparatorAsc(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<User, Integer> result = new TreeMap<User, Integer>(comparator);
        result.putAll(map);
        return result;
    }
    
      public static TreeMap<User, Integer> sortMapByValueD(HashMap<User, Integer> map) {
        Comparator<User> comparator = new ValueComparatorDesc(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<User, Integer> result = new TreeMap<User, Integer>(comparator);
        result.putAll(map);
        return result;
    }
}

class ValueComparatorAsc implements Comparator<User> {

    HashMap<User, Integer> map = new HashMap<User, Integer>();

    public ValueComparatorAsc(HashMap<User, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(User s1, User s2) {
        if (map.get(s1) <= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}

class ValueComparatorDesc implements Comparator<User> {

    HashMap<User, Integer> map = new HashMap<User, Integer>();

    public ValueComparatorDesc(HashMap<User, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(User s1, User s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
