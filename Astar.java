package astar;
import java.util.*;
import java.math.*;

public class Astar {
	
	public static void printPuzzle(int [][] node)
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(node[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("");
	}
	//calculates the distance from its goalstate
	public static int distance(int num, int x, int y)
	{	
		//given the value passed in, determine where its final location should be
		//then find how many moves away they are within the two dimentional array
		if(num == 0)
		{
			return (Math.abs(0-x) + Math.abs(0-y));
		}
		
		else if(num == 1)
		{
			return(Math.abs(0-x)+ Math.abs(1-y));
		}
		
		else if(num == 2)
		{
			return(Math.abs(0-x)+ Math.abs(2-y));
		}
		
		else if(num == 3)
		{
			return(Math.abs(1-x)+ Math.abs(0-y));
		}
		
		else if(num == 4)
		{
			return(Math.abs(1-x)+ Math.abs(1-y));
		}
		
		else if(num == 5)
		{
			return(Math.abs(1-x)+ Math.abs(2-y));
		}
		
		else if(num ==6)
		{
			return(Math.abs(2-x)+ Math.abs(0-y));
		}
		
		else if(num == 7)
		{
			return(Math.abs(2-x)+ Math.abs(1-y));
		}
		
		else
		{
			return(Math.abs(2-x)+ Math.abs(2-y));
		}

	}
	
	public static int costToGo(int[][] state)
	{
		int optCost = 0;
		int i = 0;
		//run through all of the possible numbers that can be within the array
		while(i<9)
		{
			//find the numbers
			for(int x = 0; x<3; x++)
			{
				for(int y = 0; y<3; y++)
				{
					if(i == state[x][y])
					{
						//then calculate the Manhattan distance by using the distance function 
						optCost = optCost + distance(i,x,y);
					}
				}
			}
			i++;
		}
		
		return optCost;
	}
	
	//runs through the two dimensional array to find the open node location
	public static int findOpening(int[][] node)
	{
		int loc = 0;
		for(int x = 0; x<3; x++)
		{
			for(int y = 0; y<3; y++)
			{
				if(node[x][y] == 0)
				{
				   loc = (x*10) + y;
				}
			}
		}
		
		return loc;
	}
	
	//moves the 0 to the left, unless its already against the wall
	public static int[][] moveLeft(int[][] node)
	{
		int x = 0;
		int y = 0;
		int loc = findOpening(node);
		int switchValue = 0;
		int [][] change = node.clone();
		
		if(loc == 0){
			x = 0;
			y = 0;
		}else if(loc<10){
			x = 0;
			y = loc;
		}else{
			x = loc / 10;
			y = loc % 10;
		}
		
		if(y > 0)
		{
			switchValue = node[x][y-1];
			change[x][y-1] = 0;
			change[x][y] = switchValue;
		}
		
		return change;
		
	}
	
	//moves the 0 right unless its already against the wall
	public static int[][] moveRight(int[][] node)
	{
		int x = 0;
		int y = 0;
		int loc = findOpening(node);
		int switchValue = 0;
		int[][] change = node.clone();
		
		if(loc == 0){
			x = 0;
			y = 0;
		}else if(loc<10){
			x = 0;
			y = loc;
		}else{
			x = loc / 10;
			y = loc % 10;
		}
		
		if(y < 2)
		{
			switchValue = node[x][y+1];
			change[x][y+1] = 0;
			change[x][y] = switchValue;
		}	
		
		return change;
	}
	
	//moves the 0 down unless its already at the bottom
	public static int[][] moveDown(int[][] node)
	{
		int x = 0;
		int y = 0;
		int loc = findOpening(node);
		int switchValue = 0;
		int[][] change = node.clone();
		
		if(loc == 0){
			x = 0;
			y = 0;
		}else if(loc<10){
			x = 0;
			y = loc;
		}else{
			x = loc / 10;
			y = loc % 10;
		}
		
		if(x < 2)
		{
			switchValue = node[x+1][y];
			change[x+1][y] = 0;
			change[x][y] = switchValue;
		}
		
		return change;
	}
	
	//moves the 0 up unless its already at the ceiling
	public static int[][] moveUp(int[][] node)
	{
		int x = 0;
		int y = 0;
		int loc = findOpening(node);
		int switchValue = 0;
		int [][] change = node.clone();
		
		if(loc == 0){
			x = 0;
			y = 0;
		}else if(loc<10){
			x = 0;
			y = loc;
		}else{
			x = loc / 10;
			y = loc % 10;
		}
		
		if(x > 0)
		{
			switchValue = change[x-1][y];
			change[x-1][y] = 0;
			change[x][y] = switchValue;
		}	
		
		return change;
	}
	
	public static void astarSearch(ArrayList<Node> tree, int [][] goalstate)
	{
		//first, go through the tree and determine the node with that should be expanded on
		//this is determined by finding its cost2go and adding that value with its current depth
		Node best = new Node();
		Node current = new Node();
		int currentCost = 0;
		int bestCost = 999;
		int bestC2G = 999;
		int currentC2G = 0;
		
		for(int i = 0; i<tree.size(); i++)
		{
			current = tree.get(i);
			currentCost = current.getCost2go() + current.getDepth();
			
			if(currentCost<bestCost)
			{
				best = current;
				bestCost = currentCost;
				bestC2G = currentC2G;
				
			}
			
			else if(currentC2G<bestC2G)
			{
				best = current;
				bestCost = currentCost;
				bestC2G = currentC2G;
				System.out.println(best.getDepth());
			}
		}
		//once that node has been found generate 4 new nodes with each of the possible moves
		Node up = new Node(moveUp(best.getTwoState()),best,"up",best.getPathCost()+1,best.getDepth()+1,costToGo(moveUp(best.getTwoState())));
		Node down = new Node(moveDown(best.getTwoState()),best,"down",best.getPathCost()+1,best.getDepth()+1,costToGo(moveDown(best.getTwoState())));
		Node left = new Node(moveLeft(best.getTwoState()),best,"left",best.getPathCost()+1,best.getDepth()+1,costToGo(moveLeft(best.getTwoState())));
		Node right = new Node(moveRight(best.getTwoState()),best,"right",best.getPathCost()+1,best.getDepth()+1,costToGo(moveRight(best.getTwoState())));
		//then check to see if any of these children are the goalstate
		if(up.getTwoState().equals(goalstate))
		{
			printPuzzle(up.getTwoState());
		}else if(down.getTwoState().equals(goalstate)){
			printPuzzle(down.getTwoState());
		}else if(left.getTwoState().equals(goalstate)){
			printPuzzle(left.getTwoState());
		}else if(right.getTwoState().equals(goalstate)){
			printPuzzle(right.getTwoState());
		}
		//if not add them to the tree and call the function again
		//then print out the node that created the child (recursively printing the solution)
		else{
			tree.add(up);
			tree.add(down);
			tree.add(left);
			tree.add(right);
			astarSearch(tree,goalstate);
			printPuzzle(best.getTwoState());
		}
		
	}
	
	public static void main(String[] args)
	{
		int[][] initialState = {{5,1,4},{2,0,3},{6,7,8}};
		int[][] goalState = {{0,1,2},{3,4,5},{6,7,8}};
        int cost = 0;
        
        ArrayList<Node> tree = new ArrayList<Node>();
        
        Node root = new Node(initialState,null,"",0,0,costToGo(initialState));
        
        tree.add(root);
        astarSearch(tree,goalState);


	}
}
