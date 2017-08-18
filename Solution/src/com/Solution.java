package com;

import java.util.Arrays;

public class Solution {
    public boolean judgeCircle(String moves) {
    	int LF=0;
    	int UD=0;
    	for(int i=0;i<moves.length();i++){
    		switch (moves.charAt(i)){
    		case 'L': LF++;break;
    		case 'R': LF--;break;
    		case 'U': UD++;break;
    		case 'D': UD--;break;
    		default: return false;
    		}
    		
    	}
    	if(LF==0&&UD==0)
    		return true;
    	else return false;
        
    }
    
    public boolean detectCapitalUse(String word) {
    	
    	int capitalCount =0;
    	for(int i=0;i<word.length();i++){
    		if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
    			capitalCount ++;
    		}
    	}
    	
    	if(capitalCount==0||capitalCount==word.length()||(capitalCount==1&&(word.charAt(0)>='A'&&word.charAt(0)<='Z'))){
    		return true;
    	}
    	else return false;
        
    }
    
    public int maxProfit(int[] prices) {
    	
    	int [] result = new int[prices.length];
    	if (prices.length<2)
    		return 0;
        result[0]=0;
        for(int i=1;i<prices.length;i++){
        	if(result[i-1]==0){
        		if(prices[i]>prices[i-1]){
        			result[i]=prices[i]=prices[i-1];
        		}
        		else result[i]=0;
        	}
        	else{
        		result[i]=(result[i-1]+prices[i]-prices[i]>0)?result[i-1]+prices[i]-prices[i]:0;
        	}
        }
        int max=0;
        for(int i=0;i<result.length;i++){
        	max=Math.max(result[i], max);
        	
        }
        return max;
    }
    public double findMaxAverage(int[] nums, int k) {
    	int maxSum = Integer.MIN_VALUE;
    	int preSum=0;
    	for(int i=0;i<k;i++){
    		preSum += nums[i];
    	}
    	maxSum = preSum;
    	for(int i=k;i<nums.length;i++){
    		if(preSum+nums[i]-nums[i-4]>maxSum){
    			maxSum=preSum+nums[i]-nums[i-4];
    		}
    		preSum=preSum+nums[i]-nums[i-4];
    	}
    	
    	return (double)maxSum/4;
        
    }
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int sum=0;
    	for(int i=nums.length/2;i<nums.length;i++){
    		sum+=nums[i];
    	}
    	return sum;
        
    }// newRow*c+newColumn=i*column+j
    public int[][] matrixReshape(int[][] nums, int r, int c) {
    	int rows=nums.length;
    	int colums=nums[0].length;
    	if(rows*colums!=r*c)
    		return nums;
    	int [][] result = new int[r][c];
    	for(int i=0;i<nums.length;i++){
    		for(int j=0;j<nums[0].length;j++){
    			int newRow=(i*colums+j)/c;
    			int newColumn=(i*colums+j)%c;
    			result[newRow][newColumn]=nums[i][j];
    			
    		}
    	}
    	return result;
        
    }
    public boolean isAvailable(int[] input,int index) {
    	
    	if(input.length==0)
    		return false;
    	if(index==0) {
    		if(input.length>1) {
    			if (input[1]==0) {
    				return false;
    			}
    		}
    		else return input[index]==0?true:false;
    	}
    	if(index==input.length-1) {
    		if(input.length>1) {
    			if(input[input.length-2]==0) {
    				return false;
    			}
    		}
    	}
    	
    	if(input[index-1]==0&&input[index+1]==0)
    		return true;
    
    	
    	return false;
    	
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	
    	int count=0;
    	
    	for(int i=0;i<flowerbed.length;i++) {
    		if(isAvailable(flowerbed, i)) {
    			flowerbed[i]=1;
    			count++;
    			if(count==n)
    				return true;
    		}
    		else continue;
    	}
    	return false;
     
    }
    public int[] transformToBucket(String input){
    	  int[] result=new int[26];
    	  for(int i=0;i<input.length();i++) {
    		  result[input.charAt(i)-'a']++;
    	  }
    	  return result;
    	
    }
    public boolean canConstruct(String ransomNote, String magazine) {
    	int[] ransom = transformToBucket(ransomNote);
    	int[] magazi = transformToBucket(magazine);
    	for(int i=0;i<26;i++) {
    		magazi[i]-=ransom[i];
    		if(magazi[i]<0)
    			return false;
    	}
       return true; 
    }
    public String reverseVowels(String s) {
    	
    char[] temp=	s.toCharArray();
    	
    	String aeiou = "aeiouAEIOU";
    	int i=0;
    	int j=s.length()-1;
    	while(i<j) {
    		while(!aeiou.contains(temp[i]+"")&&i<j) {
    			i++;
    		}
    		while(!aeiou.contains(temp[j]+"")&&i<j) {
    			j--;
    		}
    		if(i>j) break;
    		char tempChar = temp[i];
    		temp[i]=temp[j];
    		temp[j]=tempChar;
    		i++;
    		j--;
    	}
    String result = new String(temp);
    return result;
    }
    
    public static void main(String[] args) {
    	String s="hello";
    	Solution sol=new Solution();
    	sol.reverseVowels(s);
    }
}