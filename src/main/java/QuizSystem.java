import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuizSystem {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        JSONParser jsonparser = new JSONParser();
        System.out.print("Enter your username:");
        String userName = sc.nextLine();
        System.out.print("Enter Password:");
        String userPass = sc.nextLine();
        String userFile = "./src/main/resources/users.json";
        JSONArray jsonArray = (JSONArray) jsonparser.parse(new FileReader(userFile));
        JSONObject adminInfo = (JSONObject) jsonArray.get(0);
        JSONObject stdInfo = (JSONObject) jsonArray.get(1);
        String role = null;
        if (adminInfo.get("username").toString().equals(userName) && adminInfo.get("password").toString().equals(userPass)) {
            System.out.println("Welcome admin! Please create new questions in the question bank.");
            role = adminInfo.get("role").toString();
        } else if (stdInfo.get("username").toString().equals(userName) && stdInfo.get("password").toString().equals(userPass)) {
            System.out.println("Welcome salman to the quiz! We will throw you 10 questions. " +
                    "Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
            role = stdInfo.get("role").toString();
        } else {
            System.out.println("Invalid username or password");
            return;
        }
        if (role.equals("admin")) {
            String quizFile = "./src/main/resources/quiz.json";
            JSONArray quizArray = (JSONArray) jsonparser.parse(new FileReader(quizFile));
            String action = "s";
            while (action.equals("s")) {
                System.out.print("Input your question: ");
                String que = sc.nextLine();
                System.out.print("Input option 1: ");
                String op1 = sc.nextLine();
                System.out.print("Input option 2: ");
                String op2 = sc.nextLine();
                System.out.print("Input option 3: ");
                String op3 = sc.nextLine();
                System.out.print("Input option 4: ");
                String op4 = sc.nextLine();
                System.out.print("What is the answer key? ");
                int ans = sc.nextInt();
                sc.nextLine();
                JSONObject question = new JSONObject();
                question.put("Question", que);
                question.put("Option 1", op1);
                question.put("Option 2", op2);
                question.put("Option 3", op3);
                question.put("Option 4", op4);
                question.put("Answer Key", ans);
                quizArray.add(question);


                FileWriter fw = new FileWriter(quizFile);
                fw.write(quizArray.toString());
                fw.flush();
                fw.close();
                System.out.print("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
                action = sc.nextLine();
                if (!action.equals("q") && !action.equals("s")) {
                    System.out.print("Invalid Input");
                    break;
                }
                if (action.equals("q")) {
                    System.out.println("You Quited !!");
                    break;
                }
            }
        }

        else if (role.equals("student")) {
            String quizStart = sc.nextLine();
            while (quizStart.equals("s")) {
                String quizFile = "./src/main/resources/quiz.json";
                JSONArray quizArray = (JSONArray) jsonparser.parse(new FileReader(quizFile));
                int marks = 0;
                Random rnd = new Random();
                for (int i = 0; i < 10; i++) {
                    int rndIndex = rnd.nextInt(quizArray.size());
                    JSONObject question = (JSONObject) quizArray.get(rndIndex);
                    String que = (String) question.get("Question");
                    String op1 = (String) question.get("Option 1");
                    String op2 = (String) question.get("Option 2");
                    String op3 = (String) question.get("Option 3");
                    String op4 = (String) question.get("Option 4");
                    int ans = Integer.parseInt(question.get("Answer Key").toString());
                    System.out.println("\nQuestion " + (i + 1) + ". " + que);
                    System.out.println("1. " + op1);
                    System.out.println("2. " + op2);
                    System.out.println("3. " + op3);
                    System.out.println("4. " + op4);
                    int userAns = Integer.parseInt(sc.nextLine());
                    if (userAns == ans) {
                        marks++;
                    } else if (userAns < 1 || userAns > 4) {
                        System.out.println("Invalid answer, considered as 0 for this question.");
                    }
                }
                if (marks >= 8) System.out.println("Excellent! You have got " + marks + " out of 10");
                else if (marks >= 5) System.out.println("Good. You have got " + marks + " out of 10");
                else if (marks >= 2) System.out.println("Very poor! You have got " + marks + " out of 10");
                else System.out.println("Very sorry you are failed. You have got " + marks + "  out of 10");

                System.out.print("Would you like to start again? Press 's' for start or 'q' for quit: ");
                quizStart = sc.nextLine();
                while (!quizStart.equals("q") && !quizStart.equals("s")) {
                    System.out.println("Invalid input.");
                    quizStart = sc.nextLine();
                }
                if (quizStart.equals("q")) {
                    System.out.println("You Quited");
                    break;
                }
            }

        }
    }
}
