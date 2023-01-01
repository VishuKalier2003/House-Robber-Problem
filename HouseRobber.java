/*You are a professional robber planning to rob houses along a street... Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night... Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police...
 * Eg 1: nums = [1, 2, 3, 1]              Output = 1+3 = 4
 * Eg 2: nums = [2, 7, 9, 3, 1]           Output = 2+9+1 = 12
 * Eg 3: nums = [2, 1, 1, 2]              Output = 2+2 = 4
 */
import java.util.*;
public class HouseRobber
{
    public int MaximumLoot(Vector<Integer> vec)
    {
        int n = vec.size();
        int dp[] = new int[n];
        dp[0] = vec.get(0);
        for(int j = 1; j < vec.size(); j++)
        {
            if(j >= 2)
                dp[j] = Math.max(dp[j], Math.max(vec.get(j)+dp[j-2], dp[j-1]));
            else
                dp[j] = Math.max(vec.get(j), dp[j-1]);
        }
        return dp[n-1];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x, a;
        System.out.print("Enter the number of Houses : ");
        x = sc.nextInt();
        Vector<Integer> houses = new Vector<Integer>(x);
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the money in House "+(i+1)+" : ");
            a = sc.nextInt();
            houses.add(i, a);
        }
        System.out.println("The House Array ");
        for(int j = 0; j < houses.size(); j++)
            System.out.print(houses.get(j)+", ");
        System.out.println();
        HouseRobber robbery = new HouseRobber();
        System.out.println("The Maximum loot possible : "+robbery.MaximumLoot(houses));
        sc.close();
    }
}
