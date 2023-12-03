// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

 

// Example 1:

// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:

// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.
// Example 3:

// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 




class Leetcode {
    public boolean isMatch(String s, String p) {
        int dp[][]=new int[s.length()][p.length()];
        for(int ar[]:dp)
         Arrays.fill(ar,-1);
        return match(s.length()-1,p.length()-1,s,p,dp)==0?false:true;
    }
    static int match(int i,int j,String s,String p,int dp[][]){
        if(i<0&&j<0)
         return 1;
        if(i<0){
            for(int j1=0;j1<=j;j1++){
                if(p.charAt(j1)!='*')
                 return 0;
            }
            return 1;
          }
           if(j<0)
          return 0;
          if(dp[i][j]!=-1)
          return dp[i][j];
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
          return  dp[i][j]=match(i-1, j-1, s, p,dp);
        int ans=0;
        if(p.charAt(j)=='*'){
            for(int a=0;a<=s.length();a++){
                ans=ans+match(i-a, j-1, s, p,dp);
            }
            return  dp[i][j]=ans;
          }
        return  dp[i][j]=0;
    }

}