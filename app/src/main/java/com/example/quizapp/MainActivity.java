package com.example.quizapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Question[] questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeQuestions();
        showStartScreen();
    }

    private void showStartScreen() {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainer, new StartFragment())
            .commit();
    }

    public void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        showQuestion(currentQuestionIndex);
    }

    public void restartQuiz() {
        startQuiz();
    }

    private void initializeQuestions() {
        questions = new Question[] {
            new Question("What is a Fragment in Android?",
                new String[] {
                    "A portion of UI in an activity",
                    "A database component",
                    "A type of Intent",
                    "A network request"
                }, 0),
            new Question("Which method is called to create a Fragment's view?",
                new String[] {
                    "onCreate()",
                    "onCreateView()",
                    "onStart()",
                    "onResume()"
                }, 1),
            new Question("What is the purpose of AndroidManifest.xml?",
                new String[] {
                    "To write Java code",
                    "To store user data",
                    "To declare app components and permissions",
                    "To define app layouts"
                }, 2),
            new Question("Which layout arranges its children in relative positions?",
                new String[] {
                    "LinearLayout",
                    "FrameLayout",
                    "RelativeLayout",
                    "GridLayout"
                }, 2),
            new Question("What is the default orientation of LinearLayout?",
                new String[] {
                    "Horizontal",
                    "Vertical",
                    "Grid",
                    "None"
                }, 1),
            new Question("Which component is used to store simple key-value pairs?",
                new String[] {
                    "SQLite Database",
                    "SharedPreferences",
                    "Content Provider",
                    "File System"
                }, 1),
            new Question("What is the parent class for all Android Activities?",
                new String[] {
                    "Activity",
                    "AppCompatActivity",
                    "FragmentActivity",
                    "Context"
                }, 1),
            new Question("Which lifecycle method is called when an activity becomes visible?",
                new String[] {
                    "onCreate()",
                    "onStart()",
                    "onResume()",
                    "onVisible()"
                }, 1)
        };
    }

    private void showQuestion(int index) {
        if (index < questions.length) {
            QuestionFragment fragment = QuestionFragment.newInstance(questions[index], index);
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
        } else {
            showResult();
        }
    }

    public void checkAnswer(int selectedAnswer) {
        if (questions[currentQuestionIndex].getCorrectAnswerIndex() == selectedAnswer) {
            score++;
        }
        
        currentQuestionIndex++;
        showQuestion(currentQuestionIndex);
    }

    private void showResult() {
        ResultFragment resultFragment = ResultFragment.newInstance(score, questions.length);
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainer, resultFragment)
            .commit();
    }
}