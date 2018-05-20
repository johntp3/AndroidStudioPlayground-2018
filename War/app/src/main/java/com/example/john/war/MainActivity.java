package com.example.john.war;
//package com.example.john.war.Card;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

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
        /* creates random integer 0-51
        Random rand = new Random();
        int num = rand.nextInt(52);
        //connecting back end code to front end
        leftCard = findViewById(R.id.playerOne);

        int imageResource = drawableRes[num];
        Drawable res = ResourcesCompat.getDrawable(getResources(), imageResource, null);
        leftCard.setImageDrawable(res);

        num = rand.nextInt(52);
        rightCard =findViewById(R.id.playerTwo);
        imageResource = drawableRes[num];
        res = ResourcesCompat.getDrawable(getResources(), imageResource, null);
        rightCard.setImageDrawable(res);
        */
        // make a Card(int value, int img) class, generate all 52 cards and add them to the player queues.

        ArrayList<Card> tempDeck = new ArrayList<Card>();

        for (int i = 0; i < 52; i++) {
            Card newCard = new Card(regularCards[i], drawableRes[i]);
            tempDeck.add(newCard);
        }
        final ArrayList<Card> deck = new ArrayList<Card>();


        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Queue<Card> playerOne = new LinkedList<Card>();
                Queue<Card> playerTwo = new LinkedList<Card>();
                // next Queue will be used to temporarily hold values while war is occurring
                Queue<Card> temp1 = new LinkedList<Card>();
                Queue<Card> temp2 = new LinkedList<Card>();
                int biggerTemp;
                boolean greaterThanExecuted;
                boolean lessThanExecuted;

                Collections.shuffle(deck);
                for (int i = 0; i < 26; i++)
                {
                    playerOne.add(deck.get(i));
                    playerTwo.add(deck.get(i+26));
                }

                while(!playerOne.isEmpty() && !playerTwo.isEmpty())
                {
                    greaterThanExecuted = false;
                    lessThanExecuted = false;
                    if (playerOne.peek().getCardNumber() > playerTwo.peek().getCardNumber())
                    {
                        greaterThanExecuted = true;
                        if(temp1.size() >= temp2.size())
                        {
                            biggerTemp = temp1.size();
                        }
                        else
                        {
                            biggerTemp = temp2.size();
                        }
                        if (biggerTemp == 0)
                        {
                            playerOne.add(playerOne.remove());
                            playerOne.add(playerTwo.remove());
                        }
                        else
                        {
                            for (int i = 0; i < biggerTemp; i++)
                            {
                                if (!temp1.isEmpty())
                                {
                                    playerOne.add(temp1.remove());
                                }
                                if (!temp2.isEmpty())
                                {
                                    playerOne.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted && (playerOne.peek().getCardNumber() < playerTwo.peek().getCardNumber()))
                    {
                        lessThanExecuted = true;
                        if(temp1.size() >= temp2.size())
                        {
                            biggerTemp = temp1.size();
                        }
                        else
                        {
                            biggerTemp = temp2.size();
                        }
                        if (biggerTemp == 0)
                        {
                            playerTwo.add(playerTwo.remove());
                            playerTwo.add(playerOne.remove());
                        }
                        else
                        {
                            for (int i = 0; i < biggerTemp; i++)
                            {
                                if (!temp1.isEmpty())
                                {
                                    playerTwo.add(temp1.remove());
                                }
                                if (!temp2.isEmpty())
                                {
                                    playerTwo.add(temp2.remove());
                                }
                            }
                        }
                    }
                    if (!greaterThanExecuted && !lessThanExecuted && (playerOne.peek().getCardNumber() == playerTwo.peek().getCardNumber()))
                    {
                        for (int i = 0; i < 4; i++)
                        {
                            if (playerOne.size() > 1)
                            {
                                temp1.add(playerOne.remove());
                            }
                            if (playerTwo.size() > 1)
                            {
                                temp2.add(playerTwo.remove());
                            }
                        }
                    }
                }
            }
        });
    }
}
