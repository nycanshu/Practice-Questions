class Solution {
    public boolean ValidCorner(int mat[][]) {
        HashMap<Integer,HashSet<Integer>> colwise = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<m;i++)
        {
            colwise.put(i,new HashSet<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1) colwise.get(j).add(i);
            }
        }
        //now checking pairwise each column
    
        for(int i=0;i<m-1;i++)
        {    
            for(int j=i+1;j<m;j++)
            {    int count =0;
                for(Integer el :colwise.get(i))
                {
                    if(colwise.get(j).contains(el)) count++;
                    if(count==2) return true;
                }
            }
        }
            
        
        return false;
        
    }
}