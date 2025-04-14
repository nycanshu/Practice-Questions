//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
        //so i am given just a array of words ineed to build an adj list and a indegree but itis  charater so i use map
        HashMap<Character,HashSet<Character>>adj=new HashMap<>(); // i need hashset also coz the char can point to multipal character
        HashMap<Character,Integer>indegree=new HashMap<>();   // for track of indegree i use map
        //Now initiallize the size
        for(String str: words){   //this give me each and every word of array
            for(char ch: str.toCharArray()){   //convert the word to array and provide individual char
                adj.putIfAbsent(ch,new HashSet<>()); 
                indegree.putIfAbsent(ch,0);        //finding unique char and declearing value as 0
            }
        }
        
        //now making graph and filling  indegree
        for(int i=0; i<words.length-1;i++){
            String current=words[i];    //simple intuition we compare 2 -2 string 1st char
            String next=words[i+1];
            int len=Math.min(current.length(),next.length()); 
            for(int j=0;j<len;j++){
                char c=current.charAt(j);
                char n=next.charAt(j);
                if(c!=n){
                 if(!adj.get(c).contains(n)){ // i need to check this coz a>b might be multipal in diff cases but i dont want to increase my indegree 
                     indegree.put(n,indegree.get(n)+1);   //i increase the indegree by 1 for graph
                     adj.get(c).add(n); //basically i added n in hashmap of c ,c>n
                     
                 }
                 break;    // only we see first diff we follow lexicographally so obey dictionary rule  if alrady added then we need breakmight cause trouble in ans so we break here down
                }
                if(j==len-1 && current.length()> next.length()){  //it is must do step coz if we dont find similar and we reach to end mean abc and ab then accordig to our loop we ignore it but if may result in incorrect result as we will be comparinf ab with3rd word and c will treated as component 
                    return "";         
                }
                
            }
        }
        //now we will topo sort graph and make our ans
        StringBuilder s=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(char it: indegree.keySet()){    //basically we are finding all keys
            if(indegree.get(it)==0){        //checking key with 0 ans as a>b a will be 0
                q.offer(it);
            }
        }
        
        while(!q.isEmpty()){
            char temp=q.poll();
            s.append(temp);
            for(char c:adj.get(temp)){   // as we pop temp we go to temp and get its set and decrese their indegree
                indegree.put(c,indegree.get(c)-1); //we are decreasing the values of indegree 
                if(indegree.get(c)==0)
                q.offer(c);
            }
        }
        
        return s.length()==indegree.size()?s.toString() : "";
}
}


//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends