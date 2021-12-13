package snakesandladder;
import java.util.*;

public class SnakesAndLadder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of dice");
        int noOfDice=sc.nextInt();
        Dice dice = new Dice(noOfDice);
        Queue<Players> numberofplayers = new LinkedList<>();
        Map<String,Integer> position= new HashMap<>();
        System.out.println("Enter number of players");
        int noOfPlayers=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter player name");
            String p=sc.nextLine();
            Players p1=new Players(p);
            numberofplayers.offer(p1);
            position.put(p,1);
        }
        LinkedList<Jump> snakes=new LinkedList<>();
        System.out.println("Enter number of snakes");
        int noOfSnakes=sc.nextInt();
        System.out.println("Please enter such that head is always greater than tail");
        for(int i=0;i<noOfSnakes;i++){
            System.out.println("Enter head of snake");
            int head=sc.nextInt();
            System.out.println("Enter tail of snake");
            int tail=sc.nextInt();
            Jump s= new Jump(head,tail);
            snakes.add(s);
        }
        LinkedList<Jump> ladders=new LinkedList<>();
        System.out.println("Enter number of ladders");
        int noOfLadders=sc.nextInt();
        System.out.println("Please enter such that foot is always smaller than top");
        for(int i=0;i<noOfLadders;i++){
            System.out.println("Enter foot of ladder");
            int foot=sc.nextInt();
            System.out.println("Enter top of ladder");
            int top=sc.nextInt();
            Jump l= new Jump(foot,top);
            ladders.add(l);
        }
        
        Game play = new Game(dice,numberofplayers,snakes,ladders,position,100);
        sc.close();
        play.beginGame();


    }
}
