package snakesandladder;
import java.util.*;

public class Game {
    private Dice dice;
    private Queue<Players> turns;
    private List<Jump> snakes;
    private List<Jump> ladders;
    private Map<String,Integer> position;
    int size;
    public Game(Dice dice,Queue<Players> turns,List<Jump> snakes,List<Jump> ladders,Map<String,Integer> position,int size){
        this.dice=dice;
        this.turns=turns;
        this.snakes=snakes;
        this.ladders=ladders;
        this.position=position;
        this.size=size;

    }
    void beginGame()
    {for (int i=0;i<turns.size();i++){
        Players player = turns.poll();
        System.out.println(player.getName()+" is at position 1");
        turns.offer(player);
    }
        while(turns.size()>1){
            Players player = turns.poll();
            int currPosition=position.get(player.getName());
            int diceCount = dice.diceCount();
            int nextPosition=currPosition+diceCount;
            if(nextPosition>size){
                turns.offer(player);
            }
            else if (nextPosition==size){
                System.out.println("$$$$$$$$$$$$$"+player.getName()+" won the game $$$$$$$$$$$$$$");
            }
            else{
                int[] nextposition = new int[1];
                boolean[] snakeorladder=new boolean[1];
                nextposition[0]=nextPosition;
                snakes.forEach(s->{
                    if(s.start==nextPosition){
                        nextposition[0]=s.end;
                    }
                });
                if(nextposition[0]!=nextPosition){
                    System.out.println(player.getName()+" bitten by snake ");
                }
                ladders.forEach(l->{
                    if(l.start==nextPosition){
                        nextposition[0]=l.end;
                        snakeorladder[0]=true;
                    }
                });
                if(nextposition[0]!=nextPosition && snakeorladder[0]){
                    System.out.println(player.getName()+" climbed on ladder ");
                    }
                
                if(nextposition[0]==size){
                    System.out.println(player.getName()+" won the game");

                }
                else{
                    position.put(player.getName(),nextposition[0]);
                    System.out.println(player.getName()+" is at position "+position.get(player.getName()));
                    turns.offer(player);

                }
            }
        }
    }




    
}
