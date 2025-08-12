class Solution {

    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {

        // code here

        Arrays.sort(prices);

        int n = prices.length;

 

        int minCost = 0;

        int i = 0, end = n - 1;

 

        // Calculate minimum cost:

        // Buy cheapest, skip up to k most expensive each time.

        while (i <= end) {

            minCost += prices[i++];

            end -= k;

        }

 

        int maxCost = 0;

        int start = 0;

        i = n - 1;

        while (i >= start) {

            maxCost += prices[i--];

            start += k;

        }

 

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(minCost);

        ans.add(maxCost);

        return ans;

    }

}