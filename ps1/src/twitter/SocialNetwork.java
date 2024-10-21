///////* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
////// * Redistribution of original or derived work requires permission of course staff.
////// */
//////package twitter;
//////
//////import java.util.List;
//////import java.util.Map;
//////import java.util.Set;
//////
///////**
////// * SocialNetwork provides methods that operate on a social network.
////// * 
////// * A social network is represented by a Map<String, Set<String>> where map[A] is
////// * the set of people that person A follows on Twitter, and all people are
////// * represented by their Twitter usernames. Users can't follow themselves. If A
////// * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
////// * as a key in the map; this is true even if A is followed by other people in the network.
////// * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
////// * A username should appear at most once as a key in the map or in any given
////// * map[A] set.
////// * 
////// * DO NOT change the method signatures and specifications of these methods, but
////// * you should implement their method bodies, and you may add new public or
////// * private methods or classes if you like.
////// */
//////public class SocialNetwork {
//////
//////    /**
//////     * Guess who might follow whom, from evidence found in tweets.
//////     * 
//////     * @param tweets
//////     *            a list of tweets providing the evidence, not modified by this
//////     *            method.
//////     * @return a social network (as defined above) in which Ernie follows Bert
//////     *         if and only if there is evidence for it in the given list of
//////     *         tweets.
//////     *         One kind of evidence that Ernie follows Bert is if Ernie
//////     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
//////     *         of evidence may be used at the implementor's discretion.
//////     *         All the Twitter usernames in the returned social network must be
//////     *         either authors or @-mentions in the list of tweets.
//////     */
//////    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
//////        throw new RuntimeException("not implemented");
//////    }
//////
//////    /**
//////     * Find the people in a social network who have the greatest influence, in
//////     * the sense that they have the most followers.
//////     * 
//////     * @param followsGraph
//////     *            a social network (as defined above)
//////     * @return a list of all distinct Twitter usernames in followsGraph, in
//////     *         descending order of follower count.
//////     */
//////    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
//////        throw new RuntimeException("not implemented");
//////    }
//////
//////}
////package twitter;
////
////import java.util.*;
////import java.util.regex.Matcher;
////import java.util.regex.Pattern;
////
////public class SocialNetwork {
////
////    /**
////     * Guess who might follow whom, from evidence found in tweets.
////     * 
////     * @param tweets
////     *            a list of tweets providing the evidence, not modified by this
////     *            method.
////     * @return a social network (as defined above) in which Ernie follows Bert
////     *         if and only if there is evidence for it in the given list of
////     *         tweets.
////     */
////    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        
////        for (Tweet tweet : tweets) {
////            String author = tweet.getAuthor().toLowerCase();
////            Set<String> mentions = extractMentions(tweet.getText());
////
////            // Remove the author from their own mentions
////            mentions.remove(author);
////
////            // If the author is already in the map, add the new mentions
////            followsGraph.putIfAbsent(author, new HashSet<>());
////            followsGraph.get(author).addAll(mentions);
////        }
////        
////        return followsGraph;
////    }
////
////    /**
////     * Helper method to extract @-mentions from a tweet's text.
////     * 
////     * @param text
////     *            the content of the tweet
////     * @return a set of mentioned usernames (in lowercase)
////     */
////    private static Set<String> extractMentions(String text) {
////        Set<String> mentions = new HashSet<>();
////        Pattern pattern = Pattern.compile("@(\\w+)");
////        Matcher matcher = pattern.matcher(text);
////        
////        while (matcher.find()) {
////            mentions.add(matcher.group(1).toLowerCase());
////        }
////        
////        return mentions;
////    }
////
////    /**
////     * Find the people in a social network who have the greatest influence, in
////     * the sense that they have the most followers.
////     * 
////     * @param followsGraph
////     *            a social network (as defined above)
////     * @return a list of all distinct Twitter usernames in followsGraph, in
////     *         descending order of follower count.
////     */
////    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
////        Map<String, Integer> followerCounts = new HashMap<>();
////        
////        // Count followers for each user
////        for (Set<String> follows : followsGraph.values()) {
////            for (String followed : follows) {
////                followerCounts.put(followed, followerCounts.getOrDefault(followed, 0) + 1);
////            }
////        }
////
////        // Sort users by follower count in descending order
////        List<String> influencers = new ArrayList<>(followerCounts.keySet());
////        influencers.sort((a, b) -> followerCounts.get(b) - followerCounts.get(a));
////        
////        return influencers;
////    }
////
////}
////task2
//package twitter;
//
//import java.util.*;
//
//public class SocialNetwork {
//
//    /**
//     * Guess who might follow whom, from evidence found in tweets.
//     * 
//     * @param tweets a list of tweets providing the evidence, not modified by this method.
//     * @return a social network (as defined above) in which a user follows another
//     *         if and only if there is evidence for it in the given list of tweets.
//     */
//    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
//        // Map to store the social network graph (who follows whom)
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        
//        // Iterate through each tweet to build the graph
//        for (Tweet tweet : tweets) {
//            String author = tweet.getAuthor().toLowerCase();  // Normalize usernames to lowercase
//            Set<String> mentionedUsers = getMentions(tweet.getText());
//            
//            // Ensure the author has an entry in the graph
//            followsGraph.putIfAbsent(author, new HashSet<>());
//            
//            // Add all mentioned users to the author's following set, ignoring self-mentions
//            for (String mentionedUser : mentionedUsers) {
//                if (!mentionedUser.equals(author)) {  // Prevent users from "following" themselves
//                    followsGraph.get(author).add(mentionedUser);
//                }
//            }
//        }
//        
//        return followsGraph;
//    }
//
//    /**
//     * Extracts all the mentioned usernames from the given tweet text.
//     * Mentions are case-insensitive and start with '@'.
//     * 
//     * @param text the content of the tweet
//     * @return a set of mentioned usernames
//     */
//    private static Set<String> getMentions(String text) {
//        Set<String> mentions = new HashSet<>();
//        String[] words = text.split("\\s+");  // Split text into words by whitespace
//        
//        // Check each word if it starts with '@' and capture the username
//        for (String word : words) {
//            if (word.startsWith("@") && word.length() > 1) {
//                String username = word.substring(1).toLowerCase();  // Remove '@' and convert to lowercase
//                mentions.add(username);
//            }
//        }
//        
//        return mentions;
//    }
//
//    /**
//     * Returns a list of people sorted by their influence (i.e., by the number of followers they have).
//     * 
//     * @param followsGraph a map where each key is a person and the value is the set of people they follow
//     * @return a list of all people in the follows graph, sorted in descending order by their number of followers
//     */
//    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
//        // Map to store follower count for each user
//        Map<String, Integer> followerCount = new HashMap<>();
//        
//        // Iterate through the follows graph to calculate follower counts
//        for (Set<String> follows : followsGraph.values()) {
//            for (String user : follows) {
//                // Increment the follower count for each mentioned user
//                followerCount.put(user, followerCount.getOrDefault(user, 0) + 1);
//            }
//        }
//        
//        // Ensure users who follow others but are not followed are also included
//        for (String user : followsGraph.keySet()) {
//            followerCount.putIfAbsent(user, 0);  // Users with 0 followers
//        }
//
//        // Sort the users based on their follower count in descending order
//        List<String> influencers = new ArrayList<>(followerCount.keySet());
//        influencers.sort((user1, user2) -> Integer.compare(followerCount.get(user2), followerCount.get(user1)));
//        
//        return influencers;
//    }
//}
//
//
//task3
package twitter;

import java.util.*;

public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets a list of tweets providing the evidence, not modified by this method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        
        for (Tweet tweet : tweets) {
            String author = tweet.getAuthor().toLowerCase();  // Case-insensitive usernames
            Set<String> mentionedUsers = getMentions(tweet.getText());
            
            // Add author to the map if not already present
            followsGraph.putIfAbsent(author, new HashSet<>());
            
            // Add all mentioned users to the author's set of follows
            followsGraph.get(author).addAll(mentionedUsers);
        }
        
        return followsGraph;
    }

    /**
     * Extracts all the mentioned usernames from the given tweet text.
     * Mentions are case-insensitive and start with '@'.
     * 
     * @param text the content of the tweet
     * @return a set of mentioned usernames
     */
    private static Set<String> getMentions(String text) {
        Set<String> mentions = new HashSet<>();
        String[] words = text.split("\\s+");  // Split text into words
        
        for (String word : words) {
            if (word.startsWith("@") && word.length() > 1) {
                String username = word.substring(1).toLowerCase();  // Remove '@' and convert to lowercase
                mentions.add(username);
            }
        }
        
        return mentions;
    }
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        // Map to store follower count for each user
        Map<String, Integer> followerCount = new HashMap<>();
        
        // Iterate over the follows graph
        for (Set<String> follows : followsGraph.values()) {
            for (String user : follows) {
                // Increment the follower count for each mentioned user
                followerCount.put(user, followerCount.getOrDefault(user, 0) + 1);
            }
        }
        
        // Sort the users based on their follower count in descending order
        List<String> influencers = new ArrayList<>(followerCount.keySet());
        influencers.sort((user1, user2) -> followerCount.get(user2) - followerCount.get(user1));
        
        return influencers;
    }
}
