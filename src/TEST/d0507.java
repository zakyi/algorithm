package TEST;

import java.util.Arrays;

public class d0507 {

    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for(int i=1;i<n;i++){
            //len(dp[i]) = 6 * (i+1) - 1*(i+1) + 1 = 5i+6;
            double[] dpi = new double[(5*i+6)];
            for(int j=0;j<(5*i+6);j++){
                int min = Math.min(5,j);
                for(int x = 0;x<min;x++){
                    if((j-x) < dp.length){
                        dpi[j] += dp[j-x]/6.0;
                    }
                }
            }
            dp = dpi;
        }
        return dp;
    }


    public static void main(String[] args) {
        System.out.println(dicesProbability(2));
    }
}

