package com.ibairah.lc1029TwoCityScheduling;

import java.util.Arrays;

/**
 * Created by ibairah on 6/5/20.
 * There are 2N people a company is planning to interview. The cost
 * of flying the i-th person to city A is costs[i][0], and the cost
 * of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that
 * exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *          [A,B] , [A,B]
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 *          到A花费10，到B花费20
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half
 * the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */


//1. Send all person to city A, Cost  = 10 + 30 + 400 + 30 = 470
//2. Check how much diff we will get if we send person to city B
// instead of city A
//	Diff for  person1, D1 20 - 10 = 10
//	Diff for  person2, D2 200 - 30 = 170
//	Diff for  person3, D3 50 - 400 = -350
//	Diff for  person4, D4 20 - 30 = -10
//3. Sort the diff cost of persons - D3, D4, D1, D2
//4. Now we will pick N person which giving more diff to sending
// them city  B instead of city A, P3, P4 we will send them to city B
//5. Add the diff cost of N person in Cost = 470 - 350 - 10 = 110

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        for(int i = 0; i < costs.length; i++){
            minCost += costs[i][0];  // 先把所有人送到A
        }

        int[] diff = new int[costs.length];
        for(int j = 0; j< costs.length; j++){
            diff[j] = costs[j][1] - costs[j][0];
        }

        //	Diff for  person3, D3 50 - 400 = -350   送去B发现会比送去A 少给350快
        //	Diff for  person4, D4 20 - 30 = -10     送去B发现会比送去A 少给10快
        Arrays.sort(diff);
        int N = costs.length/2; //一半的人得送走
        for(int k = 0; k < N ; k++){
            minCost += diff[k];
        }

        return minCost;
    }
}


//How much money can we save if we fly a person to A vs. B? To
// minimize the total cost, we should fly the person with the
// maximum saving to A, and with the minimum - to B.
//
//P1 [10, 20] -> 10 - 20 = -10
//P2 [30, 200] -> 30 - 200 = -170
//P3 [400, 50] -> 400 - 50 = 350
//P4 [30, 20] -> 30 - 20 = 10
//
//Sort based on the cost of diff of sending A to B -> -170, -10,
// 10, 350 ([[30, 200], [10, 20], [30, 20], [400, 50]])
//P2 P1 P4 P3 -> A = P2, P1 -> 30 + 10 = 40
//               B = P4, P3 -> 20 + 50 = 70
//			   A + B = 40 + 70 = 110
class Solution2 {
    public int twoCitySchedCost(int[][] costs) {
        // Approach 2
        Arrays.sort(costs, (p1, p2) -> (p1[0] - p2[0]) - (p1[1] - p2[1]));
        int minCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            minCost += costs[i][0]; // send first N to A
            minCost += costs[costs.length / 2 + i][1]; // send last N to B
        }
        return minCost;
    }
}

public class MainClass {
}
