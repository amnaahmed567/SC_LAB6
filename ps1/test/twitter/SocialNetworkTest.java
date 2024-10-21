///////* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
////// * Redistribution of original or derived work requires permission of course staff.
////// */
//////package twitter;
//////
//////import static org.junit.Assert.*;
//////
//////import java.util.ArrayList;
//////import java.util.HashMap;
//////import java.util.List;
//////import java.util.Map;
//////import java.util.Set;
//////
//////import org.junit.Test;
//////
//////public class SocialNetworkTest {
//////
//////    /*
//////     * TODO: your testing strategies for these methods should go here.
//////     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
//////     * Make sure you have partitions.
//////     */
//////    
//////    @Test(expected=AssertionError.class)
//////    public void testAssertionsEnabled() {
//////        assert false; // make sure assertions are enabled with VM argument: -ea
//////    }
//////    
//////    @Test
//////    public void testGuessFollowsGraphEmpty() {
//////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
//////        
//////        assertTrue("expected empty graph", followsGraph.isEmpty());
//////    }
//////    
//////    @Test
//////    public void testInfluencersEmpty() {
//////        Map<String, Set<String>> followsGraph = new HashMap<>();
//////        List<String> influencers = SocialNetwork.influencers(followsGraph);
//////        
//////        assertTrue("expected empty list", influencers.isEmpty());
//////    }
//////
//////    /*
//////     * Warning: all the tests you write here must be runnable against any
//////     * SocialNetwork class that follows the spec. It will be run against several
//////     * staff implementations of SocialNetwork, which will be done by overwriting
//////     * (temporarily) your version of SocialNetwork with the staff's version.
//////     * DO NOT strengthen the spec of SocialNetwork or its methods.
//////     * 
//////     * In particular, your test cases must not call helper methods of your own
//////     * that you have put in SocialNetwork, because that means you're testing a
//////     * stronger spec than SocialNetwork says. If you need such helper methods,
//////     * define them in a different class. If you only need them in this test
//////     * class, then keep them in this test class.
//////     */
//////
//////}
////package twitter;
////
////import static org.junit.Assert.*;
////import org.junit.Test;
////
////import java.time.Instant;
////import java.util.*;
////
////public class SocialNetworkTest {
////
////    @Test
////    public void testGuessFollowsGraphEmpty() {
////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
////        assertTrue("expected empty graph", followsGraph.isEmpty());
////    }
////
////    @Test
////    public void testGuessFollowsGraphNoMentions() {
////        Tweet tweet = new Tweet(1, "alice", "Hello world!", Instant.now());
////        List<Tweet> tweets = Arrays.asList(tweet);
////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
////        assertTrue("expected empty graph", followsGraph.isEmpty());
////    }
////
////    @Test
////    public void testGuessFollowsGraphSingleMention() {
////        Tweet tweet = new Tweet(1, "alice", "Hello @bob!", Instant.now());
////        List<Tweet> tweets = Arrays.asList(tweet);
////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
////
////        assertTrue(followsGraph.containsKey("alice"));
////        assertTrue(followsGraph.get("alice").contains("bob"));
////    }
////
////    @Test
////    public void testGuessFollowsGraphMultipleMentions() {
////        Tweet tweet = new Tweet(1, "alice", "Hello @bob and @charlie!", Instant.now());
////        List<Tweet> tweets = Arrays.asList(tweet);
////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
////
////        assertTrue(followsGraph.containsKey("alice"));
////        assertTrue(followsGraph.get("alice").contains("bob"));
////        assertTrue(followsGraph.get("alice").contains("charlie"));
////    }
////
////    @Test
////    public void testGuessFollowsGraphMultipleTweetsFromOneUser() {
////        Tweet tweet1 = new Tweet(1, "alice", "Hello @bob!", Instant.now());
////        Tweet tweet2 = new Tweet(2, "alice", "Hi @charlie!", Instant.now());
////        List<Tweet> tweets = Arrays.asList(tweet1, tweet2);
////        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
////
////        assertTrue(followsGraph.containsKey("alice"));
////        assertTrue(followsGraph.get("alice").contains("bob"));
////        assertTrue(followsGraph.get("alice").contains("charlie"));
////    }
////
////    @Test
////    public void testInfluencersEmptyGraph() {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        List<String> influencers = SocialNetwork.influencers(followsGraph);
////        assertTrue("expected empty list", influencers.isEmpty());
////    }
////
////    @Test
////    public void testInfluencersSingleUserWithoutFollowers() {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        followsGraph.put("alice", new HashSet<>());
////        List<String> influencers = SocialNetwork.influencers(followsGraph);
////        assertTrue("expected empty list", influencers.isEmpty());
////    }
////
////    @Test
////    public void testInfluencersSingleInfluencer() {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
////        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));
////
////        List<String> influencers = SocialNetwork.influencers(followsGraph);
////
////        assertEquals("bob", influencers.get(0));
////    }
////
////    @Test
////    public void testInfluencersMultipleInfluencers() {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob", "charlie")));
////        followsGraph.put("bob", new HashSet<>(Arrays.asList("charlie")));
////
////        List<String> influencers = SocialNetwork.influencers(followsGraph);
////
////        assertEquals("charlie", influencers.get(0));  // charlie should be first with 2 followers
////        assertEquals("bob", influencers.get(1));      // bob should be second with 1 follower
////    }
////
////    @Test
////    public void testInfluencersTiedInfluence() {
////        Map<String, Set<String>> followsGraph = new HashMap<>();
////        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
////        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));
////        followsGraph.put("dave", new HashSet<>(Arrays.asList("eve")));
////        followsGraph.put("frank", new HashSet<>(Arrays.asList("eve")));
////
////        List<String> influencers = SocialNetwork.influencers(followsGraph);
////
////        assertTrue(influencers.contains("bob"));
////     //   assertTrue(influencers.contains("eve"));
////        // Both bob and eve have 2 followers, they should be in the list
////    }
////}
////task3
//package twitter;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//import java.time.Instant;
//import java.util.*;
//
//public class SocialNetworkTest {
//
//    @Test
//    public void testGuessFollowsGraphEmpty() {
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
//        assertTrue("expected empty graph", followsGraph.isEmpty());
//    }
//
//    @Test
//    public void testGuessFollowsGraphNoMentions() {
//        Tweet tweet = new Tweet(1, "alice", "Hello world!", Instant.now());
//        List<Tweet> tweets = Arrays.asList(tweet);
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
//        assertTrue("expected empty graph", followsGraph.isEmpty());
//    }
//
//    @Test
//    public void testGuessFollowsGraphSingleMention() {
//        Tweet tweet = new Tweet(1, "alice", "Hello @bob!", Instant.now());
//        List<Tweet> tweets = Arrays.asList(tweet);
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
//
//        assertTrue(followsGraph.containsKey("alice"));
//        assertTrue(followsGraph.get("alice").contains("bob"));
//    }
//
//    @Test
//    public void testGuessFollowsGraphMultipleMentions() {
//        Tweet tweet = new Tweet(1, "alice", "Hello @bob and @charlie!", Instant.now());
//        List<Tweet> tweets = Arrays.asList(tweet);
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
//
//        assertTrue(followsGraph.containsKey("alice"));
//        assertTrue(followsGraph.get("alice").contains("bob"));
//        assertTrue(followsGraph.get("alice").contains("charlie"));
//    }
//
//    @Test
//    public void testGuessFollowsGraphMultipleTweetsFromOneUser() {
//        Tweet tweet1 = new Tweet(1, "alice", "Hello @bob!", Instant.now());
//        Tweet tweet2 = new Tweet(2, "alice", "Hi @charlie!", Instant.now());
//        List<Tweet> tweets = Arrays.asList(tweet1, tweet2);
//        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
//
//        assertTrue(followsGraph.containsKey("alice"));
//        assertTrue(followsGraph.get("alice").contains("bob"));
//        assertTrue(followsGraph.get("alice").contains("charlie"));
//    }
//
//    @Test
//    public void testInfluencersEmptyGraph() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//        assertTrue("expected empty list", influencers.isEmpty());
//    }
//
//    @Test
//    public void testInfluencersSingleUserWithoutFollowers() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        followsGraph.put("alice", new HashSet<>());
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//        assertTrue("expected empty list", influencers.isEmpty());
//    }
//
//    @Test
//    public void testInfluencersSingleInfluencer() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
//        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));
//
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//
//        assertEquals("bob", influencers.get(0));
//    }
//
//    @Test
//    public void testInfluencersMultipleInfluencers() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob", "charlie")));
//        followsGraph.put("bob", new HashSet<>(Arrays.asList("charlie")));
//
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//
//        assertEquals("charlie", influencers.get(0));  // charlie should be first with 2 followers
//        assertEquals("bob", influencers.get(1));      // bob should be second with 1 follower
//    }
//
//    @Test
//    public void testInfluencersTiedInfluence() {
//        Map<String, Set<String>> followsGraph = new HashMap<>();
//        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
//        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));
//        followsGraph.put("dave", new HashSet<>(Arrays.asList("eve")));
//        followsGraph.put("frank", new HashSet<>(Arrays.asList("eve")));
//
//        List<String> influencers = SocialNetwork.influencers(followsGraph);
//
//        assertTrue(influencers.contains("bob"));
//        assertTrue(influencers.contains("eve"));
//        // Both bob and eve have 2 followers, they should be in the list
//    }
//}
package twitter;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.Instant;
import java.util.*;

public class SocialNetworkTest {

    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }

    @Test
    public void testGuessFollowsGraphNoMentions() {
        Tweet tweet = new Tweet(1, "alice", "Hello world!", Instant.now());
        List<Tweet> tweets = Arrays.asList(tweet);
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }

    @Test
    public void testGuessFollowsGraphSingleMention() {
        Tweet tweet = new Tweet(1, "alice", "Hello @bob!", Instant.now());
        List<Tweet> tweets = Arrays.asList(tweet);
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(followsGraph.containsKey("alice"));
        assertTrue(followsGraph.get("alice").contains("bob"));
    }

    @Test
    public void testGuessFollowsGraphMultipleMentions() {
        Tweet tweet = new Tweet(1, "alice", "Hello @bob and @charlie!", Instant.now());
        List<Tweet> tweets = Arrays.asList(tweet);
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(followsGraph.containsKey("alice"));
        assertTrue(followsGraph.get("alice").contains("bob"));
        assertTrue(followsGraph.get("alice").contains("charlie"));
    }

    @Test
    public void testGuessFollowsGraphMultipleTweetsFromOneUser() {
        Tweet tweet1 = new Tweet(1, "alice", "Hello @bob!", Instant.now());
        Tweet tweet2 = new Tweet(2, "alice", "Hi @charlie!", Instant.now());
        List<Tweet> tweets = Arrays.asList(tweet1, tweet2);
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(followsGraph.containsKey("alice"));
        assertTrue(followsGraph.get("alice").contains("bob"));
        assertTrue(followsGraph.get("alice").contains("charlie"));
    }

    @Test
    public void testInfluencersEmptyGraph() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        assertTrue("expected empty list", influencers.isEmpty());
    }

    @Test
    public void testInfluencersSingleUserWithoutFollowers() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        followsGraph.put("alice", new HashSet<>());
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        assertTrue("expected empty list", influencers.isEmpty());
    }

    @Test
    public void testInfluencersSingleInfluencer() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));

        List<String> influencers = SocialNetwork.influencers(followsGraph);

        assertEquals("bob", influencers.get(0));
    }

    @Test
    public void testInfluencersMultipleInfluencers() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob", "charlie")));
        followsGraph.put("bob", new HashSet<>(Arrays.asList("charlie")));

        List<String> influencers = SocialNetwork.influencers(followsGraph);

        assertEquals("charlie", influencers.get(0));  // charlie should be first with 2 followers
        assertEquals("bob", influencers.get(1));      // bob should be second with 1 follower
    }

    @Test
    public void testInfluencersTiedInfluence() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        followsGraph.put("alice", new HashSet<>(Arrays.asList("bob")));
        followsGraph.put("charlie", new HashSet<>(Arrays.asList("bob")));
        followsGraph.put("dave", new HashSet<>(Arrays.asList("eve")));
        followsGraph.put("frank", new HashSet<>(Arrays.asList("eve")));

        List<String> influencers = SocialNetwork.influencers(followsGraph);

        assertTrue(influencers.contains("bob"));
        assertTrue(influencers.contains("eve"));
        // Both bob and eve have 2 followers, they should be in the list
    }
}
