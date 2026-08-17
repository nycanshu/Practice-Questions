class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> seenPosition = new HashSet<String>();
        seenPosition.add("0,0");

        int x =0;
        int y=0;

        for(char ch : path.toCharArray()){
            if(ch == 'N'){
                y++;
            }else if( ch == 'S'){
                y--;
            }else if( ch == 'E'){
                x++;
            }else{
                x--;
            }

            String pos = x+ ","+ y;
            if(seenPosition.contains(pos)) return true;

            seenPosition.add(pos);

        }
        return false;
    }
}