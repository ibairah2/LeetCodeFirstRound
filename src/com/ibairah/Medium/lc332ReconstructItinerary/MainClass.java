package com.ibairah.Medium.lc332ReconstructItinerary;

import java.util.*;

/**
 * Created by ibairah on 6/28/20.
 *
 * Given a list of airline tickets represented by pairs of
 * departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who
 * departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a
 * single string. For example, the itinerary ["JFK", "LGA"] has a
 * smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR",
 * "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],
 * ["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO",
 * "ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        buildGraph(tickets,g);
        System.out.println("g :"+ g);
        dfs(g,res,"JFK");
        return res;
    }

    private void dfs(Map<String,PriorityQueue<String>> g,
                     LinkedList<String> res,String from){
        PriorityQueue<String> arrivals = g.get(from);
        System.out.println("arrivals  :"+ arrivals);
        while(arrivals != null && !arrivals.isEmpty()){
            String to  = arrivals.poll();
            //System.out.println(" to :"+ to);
            dfs(g,res,to);
        }
        System.out.println("res:"+ res);
        res.addFirst(from);
    }

    private void buildGraph(List<List<String>> tickets,
                            Map<String,PriorityQueue<String>> g){
        for(List<String> travel : tickets){
            String from = travel.get(0);
            String to = travel.get(1);

            if( !g.containsKey(from)){
                g.put(from,new PriorityQueue<>());
            }
            g.get(from).offer(to);
        }
    }
}
public class MainClass {
}
