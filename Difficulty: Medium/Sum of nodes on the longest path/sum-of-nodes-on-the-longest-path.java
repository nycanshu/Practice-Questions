/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        return addMax(root);
    }
    
    int addMax(Node root){
        if(root==null)
         return 0;
         
         if(root.left ==null && root.right==null)
            return root.data;
        
        Queue<Node> q=new LinkedList<>();
        List<Node> leaves=new ArrayList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
        
        List<Node> temp=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                
                Node child=q.poll();
                int data=child.data;
                
                if(child.left!=null){
                  child.left.data+=data;
                  q.offer(child.left);
                  temp.add(child.left);
                }
                  
                  
                if(child.right!=null){
                  child.right.data+=data;
                  temp.add(child.right);
                  q.offer(child.right);
            }
            }
            if(temp.size()>0)
            leaves=temp;
            
        }
        
        
        int max=0;
        
        for(Node child:leaves){
          //  System.out.println(child.data);
        
            max=Math.max(child.data,max);
            
        }
        
        
        return max;
    }
    
}