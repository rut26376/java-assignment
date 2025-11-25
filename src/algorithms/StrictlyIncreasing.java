package algorithms;

import java.util.ArrayList;
import java.util.List;

public class StrictlyIncreasing {

	public static void main(String[] args) {
		int [] arr = {1 , 2 , 1 , 2 , 3 };
		System.out.println(strictly_increasing(arr));
		
		
	}

	public static List<List<Integer>> strictly_increasing(int [] arr)
	{
		if(arr == null || arr.length == 0)
			return null;
		List<List<Integer>> newArr = new ArrayList<List<Integer>>();
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(arr[0]);
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > arr [i - 1])
				lst.add(arr[i]);
			else 
			{
				if(lst.size() > 1)
					newArr.add(lst);
				lst = new ArrayList<Integer>();
				lst.add(arr[i]);
			}
				
		}
		if(lst.size() > 1)
			newArr.add(lst);
		return newArr;
	}
	
}
