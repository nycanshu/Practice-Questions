import java.util.*;
class GFG {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int cases=sc.nextInt();
        while(cases-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->{
                if(map.get(a)==map.get(b)) return a-b;
                return map.get(b)-map.get(a);
            });
            for(int val:map.keySet()){
                q.add(val);
            }
            while(!q.isEmpty()){
                int val=q.poll();
                for(int i=0;i<map.get(val);i++){
                    System.out.print(val+" ");
                }
            }
            System.out.println();
        }
        
    }
}

