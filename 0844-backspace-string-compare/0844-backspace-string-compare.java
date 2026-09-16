class Solution {
    public boolean backspaceCompare(String s, String t) {
        return removeHash(s).equals(removeHash(t));
    }

    public static String removeHash(String str){
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()){
            
            if(ch == '#'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }

            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}