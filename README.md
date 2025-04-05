# Simple Quiz System Using Java
## Features

- **Admin User**:
  - Can add multiple MCQs with four options and an answer key.
  - Can store the questions in a `quiz.json` file.
  - Can manage questions until quitting the input process.

- **Student User**:
  - Can take a quiz consisting of 10 random MCQs.
  - The system checks answers and provides feedback based on score.
  - No negative marking; each correct answer is worth 1 mark.



## Description
This is a **Java-based quiz application** that allows both **Admin** and **Student** users to interact with a quiz system. The **Admin** can add multiple MCQs (Multiple Choice Questions) to a quiz bank, 
and the **Student** can take a quiz consisting of randomly selected questions from the bank. The system supports basic login functionality with separate roles for **Admin** and **Student**.

[

  {
  
    "username": "admin",
    "password": "1234",
    "role": "admin"
  },
  
  {
  
    "username": "salman",
    "password": "1234",
    "role": "student"
    
  }
  
]

Output:**[For admin user]**

System:> Enter your username

User:> admin

System:> Enter password

User:> 1234

System:> Welcome admin! Please create new questions in the question bank.

Output:**[For student user]**

System:> Enter your username

User:> salman

System:> Enter password

User:> 1234

System:> Welcome salman to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.


**My task:**

As an admin logged in user, until you press 'q' from keyboard, you can add multiple MCQ. Add atleast 30 questions in quiz bank. The 30 questions must be SQA related questions. For an 
example:

System:> Input your question

Admin:> Which is not part of system testing?

System: Input option 1:

Admin: Regression Testing

System: Input option 2:

Admin: Sanity Testing

System: Input option 3:

Admin: Load Testing

System: Input option 4:

Admin: Unit Testing

System: What is the answer key?

Admin: 4

System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)


Here is the example of architecture of **quiz.json** file.


[

{

    "question": "Which is not part of system testing?",
    "option 1": "Regression Testing",
    "option 2": "Sanity Testing",
    "option 3": "Load Testing",
    "option 4": "Unit Testing",
    "answerkey": 4
    
  },
  
  {
  
  
    "question": "Which is whitebox testing technique?",
    "option 1": "Equivalent Partitioning",
    "option 2": "Boundary value testing",
    "option 3": "Decision table testing",
    "option 4": "Adhoc Testing",
    "answerkey": 3
      
  }
  
]

Now its time to role play as a student.
When you login as a student to the system, system will generate 10 random questions from the quiz bank. 

**Here No questions will be repeated in the same quiz, that is ensured**.

Let show an example of output when student will login to the system.

System:> Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' for start.

Student:> s

System:> 

[Question 1] Which is not part of system testing?

1. Regression Testing

2. Sanity Testing

3. Load Testing

4. Unit Testing

Student:> 4

[Question 2] Which is whitebox testing technique?

1.Equivalent Partitioning

2. Boundary value testing

3. Decision table testing

4. Adhoc Testing

Student:> 3

In this way, 10 questions will be shown and finally the system will show the result. You will not show the answer from the json. Just match the json file answer key with the user input key. If matches, score should be counted. Otherwise if user input wrong or invalid number from keyboard, it will be considered as 0 mark and generate the next question.

For an example output:

if mark is above 8>= message: **Excellent! You have got [marks] out of 10**

if mark is above 5>= but less than 8, message: **Good. You have got [marks] out of 10**

if mark is above 2>= but less than 5, message: **Very poor! You have got [marks] out of 10**

if mark is 0 or less than 2 message: **Very sorry you are failed. You have got [marks] out of 10**

Would you like to start again? press s for start or q for quit.

## Prerequisites
- Java Development Kit (JDK) installed
- Java IDE installed

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/RayhanAyon/Simple_Quiz_System.git
   cd Simple_Quiz_System
2. Compile and run the Java program:
   ```bash
   javac src/*.java
   java Main
3. Follow the on-screen prompts to log in as Admin or Student and interact with the system.
   
## Project Output Video.
[Click Here To see the project output video.](https://drive.google.com/file/d/1C9U9wJ5zbjqSwL6ku9-hcxv2v2Z4Yu7A/view?usp=sharing)
