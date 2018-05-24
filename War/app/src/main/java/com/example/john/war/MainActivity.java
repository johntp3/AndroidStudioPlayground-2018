package com.example.john.war;
//package com.example.john.war.Card;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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
    Button changePlayerNames;
    TextView countPlayerOne, countPlayerTwo;
    Thread thread1, thread2;
    Handler updater1, updater2;
    ArrayList<Card> deck;
    Queue<Card> playerOne, playerTwo, temp1, temp2;
    int biggerTemp;
    boolean greaterThanExecuted, lessThanExecuted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deck = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            Card newCard = new Card(regularCards[i], drawableRes[i]);
            deck.add(newCard);
        }
        playerOne = new LinkedList<>();
        playerTwo = new LinkedList<>();
        // next Queue will be used to temporarily hold values while war is occurring
        temp1 = new LinkedList<>();
        temp2 = new LinkedList<>();
        //the following TextViews will be edited during the code to match the amount of cards in each player's hand
        countPlayerOne = findViewById(R.id.countPlayerOne);
        countPlayerTwo = findViewById(R.id.countPlayerTwo);

        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Collections.shuffle(deck);

                for (int i = 0; i < 52; i++) {
                    if(!playerOne.isEmpty()) {
                        playerOne.remove(deck.get(i));
                    }
                    if(!playerTwo.isEmpty()) {
                        playerTwo.remove(deck.get(i));
                    }
                }

                for (int i = 0; i < 26; i++) {
                    playerOne.add(deck.get(i));
                    playerTwo.add(deck.get(i + 26));
                }

                while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
                    greaterThanExecuted = false;
                    lessThanExecuted = false;
                    if (playerOne.peek().getCardNumber() > playerTwo.peek().getCardNumber()) {
                        greaterThanExecuted = true;
                        if (temp1.size() >= temp2.size()) {
                            biggerTemp = temp1.size();
                        } else {
                            biggerTemp = temp2.size();
                        }
                        if (biggerTemp == 0) {
                            playerOne.add(playerOne.remove());
                            playerOne.add(playerTwo.remove());
                        } else {
                            for (int i = 0; i < biggerTemp; i++) {
                                if (!temp1.isEmpty()) {
                                    playerOne.add(temp1.remove());
                                }
                                if (!temp2.isEmpty()) {
                                    playerOne.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted && (playerOne.peek().getCardNumber() < playerTwo.peek().getCardNumber())) {
                        lessThanExecuted = true;
                        if (temp1.size() >= temp2.size()) {
                            biggerTemp = temp1.size();
                        } else {
                            biggerTemp = temp2.size();
                        }
                        if (biggerTemp == 0) {
                            playerTwo.add(playerTwo.remove());
                            playerTwo.add(playerOne.remove());
                        } else {
                            for (int i = 0; i < biggerTemp; i++) {
                                if (!temp1.isEmpty()) {
                                    playerTwo.add(temp1.remove());
                                }
                                if (!temp2.isEmpty()) {
                                    playerTwo.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted && !lessThanExecuted && (playerOne.peek().getCardNumber() == playerTwo.peek().getCardNumber())) {
                        for (int i = 0; i < 4; i++) {
                            if (playerOne.size() > 1) {
                                temp1.add(playerOne.remove());
                            }
                            if (playerTwo.size() > 1) {
                                temp2.add(playerTwo.remove());
                            }
                        }
                    }
                    /*thread1 = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            updater1.post(new Runnable() {
                                @Override
                                public void run() {
                                    countPlayerOne.setText("" + playerOne.size());
                                }
                            });
                        }
                    };

                    thread2 = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            updater2.post(new Runnable() {
                                @Override
                                public void run() {
                                    countPlayerTwo.setText("" + playerTwo.size());
                                }
                            });
                        }
                    };*/
                }

                SharedPreferences SP1 = getApplicationContext().getSharedPreferences("PLAYER1", 0);
                SharedPreferences SP2 = getApplicationContext().getSharedPreferences("PLAYER2", 0);

                if (!playerOne.isEmpty()) {
                    if(SP1.getString("PLAYER1", null) == "" || SP1.getString("PLAYER1", null) == null) {
                        Toast.makeText(MainActivity.this, "Player One won!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Congratulations " +
                                SP1.getString("PLAYER1", null) + "! You won!",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if(SP2.getString("PLAYER2", null) == "" || SP2.getString("PLAYER2", null) == null) {
                        Toast.makeText(MainActivity.this, "Player Two won!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Congratulations " +
                                        SP2.getString("PLAYER2", null) + "! You won!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        changePlayerNames = findViewById(R.id.changePlayerNames);

        changePlayerNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.dialog_player_names, null);
                final EditText etPlayerOne = mView.findViewById(R.id.etplayerOne);
                final EditText etPlayerTwo = mView.findViewById(R.id.etplayerTwo);
                Button btnDialogReady = mView.findViewById(R.id.btnDialogReady);

                etPlayerOne.setEnabled(true);
                etPlayerTwo.setEnabled(true);
                btnDialogReady.setEnabled(true);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();

                btnDialogReady.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPrefesSAVE1(etPlayerOne.getText().toString());
                        SharedPrefesSAVE2(etPlayerTwo.getText().toString());
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    public void SharedPrefesSAVE1 (String player1) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PLAYER1", 0);
        SharedPreferences.Editor prefEDIT1 = prefs.edit();
        prefEDIT1.putString("PLAYER1", player1);
        prefEDIT1.apply();
    }

    public void SharedPrefesSAVE2 (String player2) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PLAYER2", 0);
        SharedPreferences.Editor prefEDIT2 = prefs.edit();
        prefEDIT2.putString("PLAYER2", player2);
        prefEDIT2.apply();
    }
}

