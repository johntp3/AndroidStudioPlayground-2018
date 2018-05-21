package com.example.john.war;
//package com.example.john.war.Card;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    //card structure: H 2-A, C 2-A, S 2-A, D 2-A
    int[] regularCards = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,
            8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
    int[] drawableRes = {R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6,
            R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.hj, R.drawable.hq,
            R.drawable.hk, R.drawable.ha, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.cj,
            R.drawable.cq, R.drawable.ck, R.drawable.ca, R.drawable.s2, R.drawable.s3, R.drawable.s4,
            R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk, R.drawable.sa, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9,
            R.drawable.d10, R.drawable.dj, R.drawable.dq, R.drawable.dk, R.drawable.da};
    ImageView leftCard;
    ImageView rightCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Card> tempDeck = new ArrayList<Card>();

        for (int i = 0; i < 52; i++) {
            Card newCard = new Card(regularCards[i], drawableRes[i]);
            tempDeck.add(newCard);
        }
        final ArrayList<Card> deck = new ArrayList<Card>(tempDeck);

        final Queue<Card> playerOne = new LinkedList<Card>();
        final Queue<Card> playerTwo = new LinkedList<Card>();
        // next Queue will be used to temporarily hold values while war is occurring
        final Queue<Card> temp1 = new LinkedList<Card>();
        final Queue<Card> temp2 = new LinkedList<Card>();
        final int[] biggerTemp = new int[1];
        final boolean[] greaterThanExecuted = new boolean[1];
        final boolean[] lessThanExecuted = new boolean[1];

        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Collections.shuffle(deck);
                for (int i = 0; i < 26; i++) {
                    playerOne.add(deck.get(i));
                    playerTwo.add(deck.get(i + 26));
                }

                while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
                    greaterThanExecuted[0] = false;
                    lessThanExecuted[0] = false;
                    if (playerOne.peek().getCardNumber() > playerTwo.peek().getCardNumber()) {
                        greaterThanExecuted[0] = true;
                        if (temp1.size() >= temp2.size()) {
                            biggerTemp[0] = temp1.size();
                        } else {
                            biggerTemp[0] = temp2.size();
                        }
                        if (biggerTemp[0] == 0) {
                            playerOne.add(playerOne.remove());
                            playerOne.add(playerTwo.remove());
                        } else {
                            for (int i = 0; i < biggerTemp[0]; i++) {
                                if (!temp1.isEmpty()) {
                                    playerOne.add(temp1.remove());
                                }
                                if (!temp2.isEmpty()) {
                                    playerOne.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted[0] && (playerOne.peek().getCardNumber() < playerTwo.peek().getCardNumber())) {
                        lessThanExecuted[0] = true;
                        if (temp1.size() >= temp2.size()) {
                            biggerTemp[0] = temp1.size();
                        } else {
                            biggerTemp[0] = temp2.size();
                        }
                        if (biggerTemp[0] == 0) {
                            playerTwo.add(playerTwo.remove());
                            playerTwo.add(playerOne.remove());
                        } else {
                            for (int i = 0; i < biggerTemp[0]; i++) {
                                if (!temp1.isEmpty()) {
                                    playerTwo.add(temp1.remove());
                                }
                                if (!temp2.isEmpty()) {
                                    playerTwo.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted[0] && !lessThanExecuted[0] && (playerOne.peek().getCardNumber() == playerTwo.peek().getCardNumber())) {
                        for (int i = 0; i < 4; i++) {
                            if (playerOne.size() > 1) {
                                temp1.add(playerOne.remove());
                            }
                            if (playerTwo.size() > 1) {
                                temp2.add(playerTwo.remove());
                            }
                        }
                    }
                }
            }
        });

        Button changePlayerNames = (Button) findViewById(R.id.changePlayerNames);
        changePlayerNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_player_names, null);
                final EditText mPlayerOne = (EditText) mView.findViewById(R.id.etplayerOne);
                final EditText mPlayerTwo = (EditText) mView.findViewById(R.id.etplayerTwo);
                Button mReady = (Button) mView.findViewById(R.id.btnDialogReady);

                mReady.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mPlayerOne.getText().toString().isEmpty() && !mPlayerTwo.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this,
                                    "Names successfully changed! Go back to home screen to play the game!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Please fill any empty fields",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }
}

