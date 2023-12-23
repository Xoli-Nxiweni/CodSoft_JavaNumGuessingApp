import java.util.*;

class myException extends Exception{
    String exception;
    public myException(String exception){
        this.exception = exception;
    }
}
class NumberGuessingGame{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        myException mE = new myException("Invalid input, try numbers instead !!");

        byte minRange = 1;
        byte maxRange = 100;
        byte maxAttempts = 10;
        byte score = 0;


            do {
                int systemNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                byte attempts = 0;
                boolean GuessedCorrectly = false;

                System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Guess it!");

                while (attempts < maxAttempts) {
                    try {
                        System.out.println((maxAttempts - attempts) + " Attempts left.");
                        System.out.print("Enter your guess: ");
                        int userGuess = scanner.nextInt();
                        attempts++;

                        if (userGuess == systemNumber) {
                            System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                            GuessedCorrectly = true;
                            break;
                        } else if (userGuess < systemNumber) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }
                    catch (InputMismatchException ime){
                        System.out.println(mE.exception);
                        scanner.next();
                    }
                }

                if (!GuessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + systemNumber);
                } else {
                    score++;
                }
                System.out.print("Do you want to play again? (yes/no): ");
            } while (scanner.next().equalsIgnoreCase("yes"));


        System.out.println("Thanks for playing! Your final score is: " + score);

        scanner.close();
    }
}
