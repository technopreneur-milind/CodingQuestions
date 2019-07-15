package com.example.demo.CodingQuestions;

import java.util.Arrays;

/**
 * https://leetcode.com/discuss/interview-question/334191/google-oa-min-days-to-bloom
 *
 */

//https://leetcode.com/discuss/interview-question/334191/google-oa-min-days-to-bloom
public class RoseBoquette 
{
    public static void main( String[] args )
    {
        int[] roses = {1, 2, 4, 9, 3, 4, 1};
        int k = 2, n = 2;
        int result = minDaysBloom(roses, k, n);
        System.out.println(result != -1 ? "It will take "+result+" no of days for getting "+n+" Bouquetsof Size "+k : " It is not possible to get "+n+" Bouquets of Size "+k);
    }
    
    static int minDaysBloom(int[] roses, int k, int n) {
    	
    	//Paired Min Days
    	if(n > roses.length/k)
    		return -1;
    	int[] rosePair = new int[roses.length-k+1];
    	for(int i=0; i<rosePair.length;i++)
    	{
    		rosePair[i] = getMax(roses,i,k);
    	}
    	Arrays.sort(rosePair);
    	//Catch is you can take alternative pairs only not immediate since 
    	//For K =2 pair at 0 is of 0 & 1 while pair at 1 is of 1 & 2 , pair at 2 is of 2 &3
    	//Since it is sorted go for leftmost pair as it would be lowest
    	//so two pairs would pair[0]= 0 &1 , pair[2]= 2 & 3
    	//It becomes more difficult for K =3 and so on
    	//Simple logic is to skip k-1 elements every alternative 
    	//for K=2 you skip 1 element , 0th, 2nd, 4th and so on ..
    	//so for k=2 n=1 , return rosePairs[0], n=2 , return rosePairs[2], n=3 ,rosePair[4]..
    	//so it is n*k -k= k*(n-1) TH element..
    	//for K=3 , you skip 2 elements , 0th, 3rd, 5th , and so on..
    	// k=3, n=1 : return 3*0= oth element ; k=3 , n=2 : return 3*1 = 3rd element and so on..
    	
    	return rosePair[k*(n-1)];
    	
    }

	private static int getMax(int[] roses, int startIndex, int range) {
		if(roses == null || roses.length < 1 || startIndex >= roses.length  || startIndex + range -1 >= roses.length)
			return -1;
		if(range < 2)
			return roses[startIndex];
		if(range == 2)
			return Math.max(roses[startIndex], roses[startIndex+1]);
		int result = roses[startIndex];
		for(int i=1; i< range;i++)
		{
			if(roses[startIndex + i] > result)
				result = roses[startIndex + i];
		}
		return result;
	}
    
    
}
