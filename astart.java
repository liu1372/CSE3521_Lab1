java.util.priorityQueue

public class Astart extends Node
{
    public static void main(String[] args) {
        int[] initialState = {5,0,4,2,1,3,6,7,8};
        for (int i = 0; i<initialState.length; i++){
            System.out.print(initialState[i]+" ");
            if((i + 1) % 3 == 0){
                System.out.println(" ");
            }
        }
    }