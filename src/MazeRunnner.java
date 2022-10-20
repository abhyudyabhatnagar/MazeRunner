import java.util.*;
public class MazeRunnner {
    Maze myMap = new Maze();


    public static void main(String[] args) {
        MazeRunnner cc = new MazeRunnner();
        cc.intro();
        int moves=0;
        while(moves<=100 || cc.myMap.didIWin()==false){
            cc.userMover();
            cc.myMap.printMap();
            moves++;

        }
        if(cc.myMap.didIWin()== true){
            System.out.println("you`ve escaped!");
        }else{
            System.out.println("Sorry you`ve reached the end..");
        }
    }

    public void intro(){
        System.out.println("WELCOME TO MAZE RUNNER!!");
        System.out.println("Here is your current position: ");
        myMap.printMap();

    }


    public String userMover(){
        Scanner input = new Scanner(System.in);
        System.out.print("In which direction would you like to move? (R, L, U, D): ");
        String dir = input.next();

       // if(Character.toString(dir).matches("RLUD")) {
          if(dir.equals("R") || dir.equals("L") || dir.equals("U") || dir.equals("D")){
            if (dir.equals("R") && myMap.canIMoveRight() == true) {
                myMap.moveRight();
            }else if (dir.equals("L") && myMap.canIMoveLeft() == true) {
                myMap.moveLeft();
            } else if (dir.equals("U") && myMap.canIMoveUp()==true) {
                myMap.moveUp();
            }else if (dir.equals("D") && myMap.canIMoveDown() == true) {
                myMap.moveDown();
            } else {
                if (myMap.isThereAPit(dir) == true) {
                    navigatePit(dir);
                } else {
                    System.out.println("Sorry! you`ve hit a wall..");
                }
            }
        } else{
            System.out.println("Please Enter a valid input. ");
            return userMover();
        }
        return "";
    }



    public void movesMessage(int m){
        if(m==100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }else if(m==90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }else if(m==75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }else if(m==50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
        }


    }
    public static void navigatePit(String p){
    MazeRunnner cc = new MazeRunnner();
        Scanner input = new Scanner(System.in);
        System.out.println("You`ve hit a pit! ");
        System.out.println("Would you like to escape the pit? (Y/N): ");
        String ans = input.next();

        if(ans.equalsIgnoreCase("Y")){
            cc.userMover();
            }else{
            System.out.println("Exited Maze");
        }


    }
}
