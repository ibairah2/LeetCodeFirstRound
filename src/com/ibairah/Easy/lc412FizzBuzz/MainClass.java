package com.ibairah.Easy.lc412FizzBuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ibairah on 6/23/20.
 * Write a program that outputs the string representation of
 * numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of
 * the number and for the multiples of five output “Buzz”. For
 * numbers which are multiples of both three and five output
 * “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

//follow up 如何让这个问题有扩展性，使用hashmap
class Solution2{
    public List<String> fizzBuzz(int n){

        HashMap<Integer,String> map= new HashMap<Integer,String>();
        // we can extend more number in here
        map.put(3,"Fizz");
        map.put(5,"Buzz");

        List<String> res = new ArrayList<>();
        // loop every n and loop map;
        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            for(int key: map.keySet()){
                if( i % key == 0){
                    //!!!!! n = 15, 15/3 = 0 sb.append(Fizz)
                    // 15/ 5 = 0; sb.appen(Buzz);
                    sb.append(map.get(key));
                    System.out.println(" i :"+ i);
                    System.out.println(" sb :"+ sb.toString());
                }
            }
            if(sb.length() == 0){
                res.add(String.valueOf(i));
            }else{
                res.add(sb.toString());
            }
        }
        System.out.println(" res :"+ res.toString());
        return res;
    }
}
class Solution {
    public List<String> fizzBuzz(int n) {
        //1.loop 1 to n
        List<String> res = new ArrayList<>();
        String temp = "";
        for( int i = 1; i <= n ; i++){
            if( i % 15 == 0) {
                temp = "FizzBuzz";
                res.add(temp);
            }
            else if( i % 3 == 0) {
                temp = "Fizz";
                res.add(temp);
            }
            else if (i % 5 == 0){
                temp = "Buzz";
                res.add(temp);
            }
            else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
public class MainClass {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.fizzBuzz(15);
    }
}
