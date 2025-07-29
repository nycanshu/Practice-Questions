class Solution {
    public int[] preffixSum(String s)
    {
        int n = s.length();
        int[] result = new int[n];
        
        result[0] = (int) (s.charAt(0));
        
        for(int i=1; i<n; i++)
        {
            result[i] = result[i-1] + (int) (s.charAt(i));
        }
        
        return result;
    }
    public ArrayList<Integer> asciirange(String s) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int pre[] = preffixSum(s);
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        
        for(int i=0; i<n; i++)
        {
            char ch = s.charAt(i);
            if(!map.containsKey(ch))
            {
                List<Integer> list = new ArrayList<>();
                map.put(ch, list);
            }
            map.get(ch).add(i);
        }
        
        for(char key : map.keySet())
        {
            if(map.get(key).size() > 1)
            {
                //System.out.println(key + "  " + map.get(key));
                List<Integer> list = map.get(key);
                int left = list.get(0);
                int right = list.get(list.size() - 1);
                int sum = pre[right] - pre[left] - (int)(s.charAt(right));
                if(sum > 0)
                {                       

                     result.add(sum);

                }
            }
        }
        
        return result;
    }
}