package com.example.android.jokesource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class JokeActivityFragment extends Fragment {

    TextView jokeTextView;
    ProgressBar jokeProgressBar;

    public JokeActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        jokeTextView = (TextView) root.findViewById(R.id.joke_textview);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return root;
    }
}
