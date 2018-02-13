package main;

import java.util.LinkedList;

public class Collatz
{
	
	
	public LinkedList<Integer> run(int start)
	{
		LinkedList<Integer> states = new LinkedList<Integer>();
		
		states.add(start);
		
		int next = start;
		
		while( next > 1 )
		{
			next = getNextInt(next);
			states.add(next);
		}
				
		return states;
	}
	
	
	private int getNextInt(int input)
	{
		if( input % 2 == 0 )
		{
			return input / 2;
			
		} else
		{
			return (input * 3) + 1;
		}
	}
	
	

}
