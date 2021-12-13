package snakesandladder;

public class Dice{
    private int dice;

    Dice(int dice) {
        this.dice=dice;
    }

    int diceCount(){
        return ((int)(Math.random()*(6*dice - 1*dice)))+1;
    }

        
}