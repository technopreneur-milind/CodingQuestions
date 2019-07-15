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
        System.out.println(result != -1 ? "It will take "+result+" no of days for getting "+n+" Bouquets" : " It is not possible to get "+n+" Bouquets");
    }
    
    static int minDaysBloom(int[] roses, int k, int n) {
    	
    	//Paired Min Days
    	int[] rosePair = new int[roses.length-k+1];
    	for(int i=0; i<rosePair.length;i++)
    	{
    		rosePair[i] = getMax(roses,i,k);
    	}
    	Arrays.sort(rosePair);
    	if(n > rosePair.length)
    		return -1;
    	return rosePair[n-1];
    	
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
