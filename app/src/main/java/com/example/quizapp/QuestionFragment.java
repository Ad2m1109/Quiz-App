package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {
    private Question question;
    private int questionIndex;

    public static QuestionFragment newInstance(Question question, int index) {
        QuestionFragment fragment = new QuestionFragment();
        // Pass question index as argument
        Bundle args = new Bundle();
        // Use a unique key for the question index
        args.putInt("questionIndex", index);
        fragment.setArguments(args);
        fragment.question = question;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView questionText = view.findViewById(R.id.questionText);
        questionText.setText(question.getQuestionText());
        
        int[] buttonIds = {R.id.option1, R.id.option2, R.id.option3, R.id.option4};
        String[] options = question.getOptions();
        
        for (int i = 0; i < buttonIds.length; i++) {
            Button button = view.findViewById(buttonIds[i]);
            button.setText(options[i]);
            final int optionIndex = i;
            button.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).checkAnswer(optionIndex);
                }
            });
        }
        
        return view;
    }
}
