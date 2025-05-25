import java.util.*;

class Game {
    private final int rounds = 3;
    private final int chances = 5;
    private int score = 0;
    private ArrayList<Integer> scores;

    public Game(){
        System.out.println("\tWELCOME TO THE NUMBER GAME\n");
        scores = new ArrayList<>();
    }

    public void howToPlay(){
        System.out.println("\t----TUTORIAL----");
        System.out.println("1.A random number will be generated from 1 to 100.");
        System.out.println("2.Your task is to guess the number.");
        System.out.println("3.You will have 3 rounds and 5 attempts each round.");
        System.out.println("4.For every wrong guess, additional information such as (too high OR too low) will be provided.");
        System.out.println("5.Each round a new random number will be generated.");
        System.out.println("6.Score Calculation : ");
        System.out.println("\ti.Correct Guess = +15 points.");
        System.out.println("\tii.Wrong Guess = -5 points.");
        System.out.println("7.Good Luck!");
        System.out.println("--------");
    }
    
    public void startGame(){
        int guess;
        Scanner input = new Scanner(System.in);
        Round:for(int round = 1 ; round <= rounds ; round++){
            score = 0;
            int random = new Random().nextInt(100) + 1;
            System.out.println("Round " + round + "/" + rounds);
            System.out.println("Number Generated!");
            Attempt:for(int attempt = 1 ; attempt <= chances ; attempt++){
                System.out.print("Enter your guess : ");
                guess = input.nextInt();
                if(guess == random){
                    System.out.println("Wow! Right Guess");
                    score+=15;
                    System.out.println("Score at the end of round " + round + ": " + score);
                    scores.add(score);
                    if(round != rounds) System.out.println("Get ready for next round.");
                    else break;
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException e){}
                    continue Round;
                }
                else{
                    if(score > 0) {
                        score -= 5;
                    }
                    if (Math.max(guess, random) == guess) {
                        System.out.println("Woah! Too high");
                    } else {
                        System.out.println("Oops! Too low");
                    }
                }
            }
            System.out.println("The generated number was = " + random);
            System.out.println("Score at the end of round " + round + ": " + score);
            scores.add(score);
            if(round != rounds) System.out.println("Hard Luck! Get ready for next round.");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}
        }
        System.out.println("Game Over");
        scoreCard();
    }

    public void scoreCard(){
        int gameTotal = 0;
        System.out.println("--------");
        System.out.println("User = Guest");
        if(!scores.isEmpty()){
            System.out.println("Scores :");
            for(int i = 0 ; i < scores.size() ; i++){
                System.out.println("Round " + (i+1) + " = " + scores.get(i));
                gameTotal += scores.get(i);
            }
            System.out.println("Total Score = " + gameTotal);
        }
        else{
            System.out.println("Game has to be started for scores.");
        }
        System.out.println("--------");
    }
}

public class NumberGame{
    public static void main(String[] args){
        Game numbergame = new Game();
        int choice;
        Menu:do{
            System.out.println("1.Start");
            System.out.println("2.Score Card");
            System.out.println("3.How to play ?");
            System.out.println("4.Exit");
            System.out.print("Enter your choice : ");
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    System.out.println("--------");
                    numbergame.startGame();
                    break;
                case 2:
                    numbergame.scoreCard();
                    break;
                case 3:
                    numbergame.howToPlay();
                    break;
                case 4:
                    System.out.println("Thank You for playing!!");
                    break Menu;
            }
        }while(choice < 5);
    }
}
