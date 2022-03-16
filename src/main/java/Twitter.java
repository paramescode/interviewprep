import java.util.*;

//https://leetcode.com/problems/design-twitter/submissions/

public class Twitter {

        Map<Integer, User> users;
        Map<Integer, List<Integer>> userTweetIds;
        Map<Integer, Tweet> tweets;
        private int timeStamp =0;

        public class User{
            public Integer userid;
            public List<Integer> followees;

            public User( Integer userid){
                this.userid = userid;
                followees = new ArrayList<>();
            }

        }

        public class Tweet{
            public Integer id;
            private int timeInMillis;

            public Tweet(Integer id){
                this.id = id;
                this.timeInMillis = timeStamp++;
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
            this.users = new HashMap<>();
            this.userTweetIds = new HashMap<>();
            this.tweets = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {

            Tweet t = new Tweet(tweetId);
            tweets.put(tweetId,t);

            if(!users.containsKey(userId)){
                User u = new User(userId);
                users.put(userId, u);
            }


            userTweetIds.putIfAbsent(userId, new ArrayList<>());
            userTweetIds.get(userId).add(t.id);

        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {

            List<Tweet> _tweets = new ArrayList<>();

            if(userTweetIds.get(userId) != null){
                for(Integer tid : userTweetIds.get(userId)){
                    if(this.tweets.get(tid) != null)
                        _tweets.add(this.tweets.get(tid));
                }
            }

            //System.out.println("dfdf");

            User u = users.get(userId);
            //System.out.println("dfdf" + u.userid);

            if(u != null && u.followees.size() >0 ){
                for(Integer followeeid : u.followees){
                    //System.out.println("xxxx" + followeeid);
                    if(userTweetIds.get(followeeid) == null)
                        continue;
                    for(Integer tid : userTweetIds.get(followeeid)){
                        if(this.tweets.get(tid) != null)
                            _tweets.add(this.tweets.get(tid));
                    }
                }
            }

            //System.out.println("2222");
            List<Integer> res = new ArrayList<>();
            if(_tweets.size() ==0)
                return res;

            Collections.sort(_tweets, new Comparator<Tweet>(){

                public int compare(Tweet a, Tweet b){
                    return b.timeInMillis - a.timeInMillis;

                }
            });
            //System.out.println("3333");



            int s = _tweets.size() < 10 ?   _tweets.size() : 10;
            //System.out.println("44444 " + s);

            for(int i=0;i < s;i++){
                //System.out.println(_tweets.get(i).id);
                res.add(_tweets.get(i).id);
            }

            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId)
                return;

            if(users.get(followerId) != null){
                if(!users.get(followerId).followees.contains(followeeId))
                    users.get(followerId).followees.add(followeeId);
            }else{
                User u = new User(followerId);
                u.followees.add(followeeId);
                users.put(u.userid, u);
            }



        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {

            if(users.get(followerId) != null){
                users.get(followerId).followees.remove(new Integer(followeeId));
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

