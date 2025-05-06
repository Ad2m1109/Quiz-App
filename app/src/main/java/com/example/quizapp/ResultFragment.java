package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {
    private static final String ARG_SCORE = "score";
    private static final String ARG_TOTAL = "total";

    public static ResultFragment newInstance(int score, int total) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SCORE, score);
        args.putInt(ARG_TOTAL, total);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        
        TextView scoreText = view.findViewById(R.id.scoreText);
        Button tryAgainButton = view.findViewById(R.id.tryAgainButton);

        int score = getArguments().getInt(ARG_SCORE);
        int total = getArguments().getInt(ARG_TOTAL);
        
        scoreText.setText("Your Score: " + score + "/" + total);
        
        tryAgainButton.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).restartQuiz();
            }
        });
        
        return view;
    }
}
