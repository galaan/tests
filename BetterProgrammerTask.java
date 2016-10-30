import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetterProgrammerTask 
{
	// TASK 1
	public static int getSumOfNumbers(String s) 
	{
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
    	
    	String[] ss = s.split(" ");
		int sum = 0;
		for (String value : ss)
		{
			try
			{
				Integer val = Integer.valueOf(value.trim());
				sum = sum + val;
			}
			catch (java.lang.NumberFormatException e) {}			
		}
		return sum;
    }
	
	// TASK 2
	public static String getBinaryRepresentation(int n) 
	{
        /*
         Please implement this method to
         return a String with the binary representation of any number n, where n >= 0.
         Example: "101" is a binary representation of 5
        */
    	return Integer.toBinaryString(n);
    }
	
	
	// TASK 3
	// Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

	// TASK 3
    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
    	
    	if (root == null) 
    		return 0;
        int maxSum = 0;
        for (Node node : root.getChildren()) 
        {
            int sum = getLargestRootToLeafSum(node);
            if (sum > maxSum)
                maxSum = sum;
        }

        return root.getValue() + maxSum;
    }
    
    
    // TASK 4
    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */
    	
    	List<Integer> result = new ArrayList<Integer>(a.length);
        if (a == null || a.length < 2) 
        	return result;

        List<Integer> copy = new ArrayList<Integer>(a.length);
        for (int i : a) {
            copy.add(i);
        }
        
        int length = a.length;
        System.out.println(copy);
        for (int i = length - 1; i >=0; i--)
        {
        	int nmax = getMaxNum(copy, i);
        	if (nmax == i) {} // OK
        	else if (nmax == 0)
        	{
        		Collections.reverse(copy.subList(0, i + 1));
        		result.add(i + 1);
        	}
        	else 
        	{
        		Collections.reverse(copy.subList(0, nmax + 1));
        		result.add(nmax + 1);
        		Collections.reverse(copy.subList(0, i + 1));
        		result.add(i + 1);
        	}        		
        }
        return result;
    }
        
    private static int getMaxNum(List<Integer> list, int to)
    {
    	int nmax = 0;
    	int max = list.get(0);
    	for (int i = 1; i <= to; i++)
    	{
    		if (list.get(i) > max)
    		{
    			max = list.get(i);
    			nmax = i;
    		}
    	}
    	return nmax;
    }
}
