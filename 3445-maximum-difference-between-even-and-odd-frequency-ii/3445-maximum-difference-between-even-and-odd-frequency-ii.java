class Solution {
    private final static int INF = Integer.MAX_VALUE/2;

    public int maxDifference(String s, int k) {
        int n = s.length();
        int[][] preFreq = new int[n+1][5]; // preFreq[i][c] - frequency of character c in s[0, i)
        for(int i=1; i<=n; i++){
            for(int c=0; c<5; c++){
                preFreq[i][c] = preFreq[i-1][c];
            }
            preFreq[i][s.charAt(i-1)-'0']++;
        }

        int ans = -INF;
        for(int a=0; a<5; a++){ // character that has an odd frequency in subs
            for(int b=0; b<5; b++){ // character that has an even frequency in subs
                if(a==b){
                    continue;
                }

                ans = Math.max(ans, maxDifference(a, b, s, k, preFreq));
            }
        }

        return ans;
    }

    // maximum preFreq[j][a] - preFreq[i][a] - (preFreq[j][b] - preFreq[i][b])
    private int maxDifference(int a, int b, String s, int k, int[][] preFreq){
        int res = -INF;
        // minPreFreq[x][y] - minimum preFreq[a]-preFreq[b] when preFreq[a]%2==x and preFreq[b]%2==y
        int[][] minPreFreq = {{INF, INF},{INF, INF}};
        for(int i=0, j=1; j<=s.length(); j++){
            int ra = preFreq[j][a], rb = preFreq[j][b];
            while(j-i>=k && ra != preFreq[i][a] && rb != preFreq[i][b]){
                int la = preFreq[i][a], lb = preFreq[i][b];
                minPreFreq[la&1][lb&1] = Math.min(minPreFreq[la&1][lb&1], la-lb);
                i++;
            }
            res = Math.max(res, ra - rb - minPreFreq[ra&1^1][rb&1]);
        }
        
        return res;
    }
}