import java.util.Scanner;
import java.util.Random;

 class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the game !");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ". Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + targetNumber + ".");
            }

            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nThank you for playing! Your final score is: " + score);
                break;
            }
        }

        scanner.close();
    }
}
