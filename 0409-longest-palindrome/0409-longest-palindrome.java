class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charset = new HashSet<>();
        int len = 0;
        for(char c: s.toCharArray()){
            if(charset.contains(c)){
                charset.remove(c);
                len += 2;
            }else{
                charset.add(c);
        
            }
        }
        if(!charset.isEmpty()){
            len += 1;
        }
        return len;
    }
}