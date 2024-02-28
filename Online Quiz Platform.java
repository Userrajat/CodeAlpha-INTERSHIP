import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String question;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
        // Initialize questions here, you can also read from a file
        // Example:
        // questions.add(new Question("What is 2 + 2?", new ArrayList<>(Arrays.asList("1", "2", "3", "4")), 3));
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            ArrayList<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
       
        quiz.start();
    }
}
