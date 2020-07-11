package com.ibairah.Medium.lc721AccountsMerge;

import java.util.*;

/**
 * Created by ibairah on 2020/7/11.
 *
 * Given a list accounts, each element accounts[i] is a list of
 * strings, where the first element accounts[i][0] is a name, and
 * the rest of the elements are emails representing emails of the
 * account.
 *
 * Now, we would like to merge these accounts. Two accounts
 * definitely belong to the same person if there is some email that
 * is common to both accounts. Note that even if two accounts have
 * the same name, they may belong to different people as people
 * could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have
 * the same name.
 *
 * After merging the accounts, return the accounts in the following
 * format: the first element of each account is the name, and the
 * rest of the elements are emails in sorted order. The accounts
 * themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
 * ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"],
 * ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the
 * common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their
 * email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer
 * [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        //1.corner case
        if(accounts == null || accounts.size() == 0) return res;

        //2.initialize
        //email 对应 Name
        Map<String,String> emailToName = new HashMap<>();
        //连接每一个email和他的邻居
        Map<String,Set<String>> graph = new HashMap<>();
        //储存所有非重复的email
        Set<String> emails = new HashSet<>();
        //dfs判断时候访问过当前email
        Set<String> visited = new HashSet<>();

        //3. full the structure
        for(List<String> list: accounts){
            String name = list.get(0);
            //处理email,因为一个list可能有多个email
            for(int i = 1; i < list.size(); i++){
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email,name);
                graph.putIfAbsent(email,new HashSet<String>());
                //如果当前i为1，说明这个list中没有多个email则无法互相连接
                if(i == 1) continue;
                //连接当前node和前一个node
                graph.get(list.get(i-1)).add(email);
                graph.get(email).add(list.get(i-1));
            }
        }

        //4. 把graph遍历一边,取出每一个email,再加入res
        for(String e: emails){
            if(!visited.contains(e)){
                visited.add(e);
                List<String> temp = new ArrayList<>();
                temp.add(e);
                //dfs作用是为了当我拿到一个email时，去找到他邻居的信息
                //所以dfs完之后出现list of email
                dfs(e,graph,visited,temp);
                Collections.sort(temp);
                //在index0 位置加上username
                temp.add(0,emailToName.get(e));
                res.add(temp);
            }
        }
        return res;
    }

    private void dfs(String e, Map<String, Set<String>> graph, Set<String> visited, List<String> temp){
        // 为了取到所有的neighbor，遍历一边graph
        for(String nei : graph.get(e)){
            if(!visited.contains(nei)){
                visited.add(nei);
                temp.add(nei);
                //再去找neighbor的neighbor
                dfs(nei,graph,visited,temp);
            }
        }

    }
}
public class MainClass {
}
