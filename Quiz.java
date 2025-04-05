import java.util.*;
import java.util.concurrent.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class Quiz {
    private List<Question> questions;
    private int score;
    private List<String> summary;
    private static final int TIME_LIMIT = 10;
    
    public Quiz() {
        questions = new ArrayList<>();
        summary = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Paris", "2. Berlin", "3. Madrid", "4. Rome"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2));
        questions.add(new Question("What is 5 + 3?", new String[]{"1. 5", "2. 7", "3. 8", "4. 10"}, 3));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.question);
            for (String option : q.options) {
                System.out.println(option);
            }

            Callable<Integer> task = () -> {
                System.out.print("Your answer (1-4): ");
                return scanner.nextInt();
            };

            Future<Integer> future = executor.submit(task);
            int answer = -1;

            try {
                answer = future.get(TIME_LIMIT, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.out.println("Time's up! Moving to the next question.");
                future.cancel(true);
            } catch (Exception e) {
                System.out.println("Invalid input. Moving to the next question.");
                future.cancel(true);
            }

            if (answer == q.correctAnswer) {
                score++;
                summary.add("Question " + (i + 1) + ": Correct");
            } else {
                summary.add("Question " + (i + 1) + ": Incorrect (Correct answer: " + q.correctAnswer + ")");
            }
        }

        executor.shutdown();
        displayResult();
    }

    private void displayResult() {
        System.out.println("\nQuiz Over! Here are your results:");
        System.out.println("Final Score: " + score + "/" + questions.size());
        for (String result : summary) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
      Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}
