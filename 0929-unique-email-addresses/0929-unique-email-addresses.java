class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> valid = new HashSet<>();

        for( String str : emails){
            String[] words = str.split("@");

            String local = words[0];
            String domain = words[1];

            if(local.contains("+")){
                int position = local.indexOf('+');
                local = local.substring(0, position);

            }
            local = local.replace(".","");

            String newEmail = local+"@"+domain;
            valid.add(newEmail);
        }

        return valid.size();
    }
}