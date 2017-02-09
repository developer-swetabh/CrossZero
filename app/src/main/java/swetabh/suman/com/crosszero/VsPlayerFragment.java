package swetabh.suman.com.crosszero;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VsPlayerFragment extends Fragment {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private int turn;
    private Context mContext;
    private LayoutInflater mInflater;
    private TextView mInfo, mPlayerOneCount, mTieCount, mPlayerTwoCount;
    private int mPlayerOneCounter = 0;
    private int mTieCounter = 0;
    private int mPlayerTwoCounter = 0;
    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;
    private static final int NONE = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vs_android, container, false);
        mContext = getActivity();
        mInflater = inflater;
        findViews(view);
        turn = 1;
        clickListenerForButtons();
        return view;
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViews(view);
        turn = 1;
        clickListenerForButtons();
        //drawLine(1000, 200, 2, 0f);// for position1
        // drawLine(1000, 600, 2, 0f);// for position2
        // drawLine(1000, 1000, 2, 0f);//for position3
        // drawLine(1000, 1500, 2, 0f, 4);// for position 4
        //drawLine(1000, 1500, 2, 0f, 5);// for position 5
        //drawLine(1000, 1500, 2, 0f, 6);// for position 6
        //drawLine(1000, 1500, 2, 0f, 7);// for position 7
        //drawLine(1000, 1500, 2, 68, 7);// for position 8
    }*/

    private void findViews(View view) {
        b1 = (Button) view.findViewById(R.id.button1);
        b2 = (Button) view.findViewById(R.id.button2);
        b3 = (Button) view.findViewById(R.id.button3);
        b4 = (Button) view.findViewById(R.id.button4);
        b5 = (Button) view.findViewById(R.id.button5);
        b6 = (Button) view.findViewById(R.id.button6);
        b7 = (Button) view.findViewById(R.id.button7);
        b8 = (Button) view.findViewById(R.id.button8);
        b9 = (Button) view.findViewById(R.id.button9);

        mInfo = (TextView) view.findViewById(R.id.info);
        mPlayerOneCount = (TextView) view.findViewById(R.id.human_count);
        mTieCount = (TextView) view.findViewById(R.id.tie_count);
        mPlayerTwoCount = (TextView) view.findViewById(R.id.android_count);

        mPlayerOneCount.setText(getString(R.string.player_one, Integer.toString(mPlayerOneCounter)));
        mTieCount.setText(getString(R.string.ties, Integer.toString(mTieCounter)));
        mPlayerTwoCount.setText(getString(R.string.player_two, Integer.toString(mPlayerTwoCounter)));
    }

    private void clickListenerForButtons() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b1.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b1.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b1.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b2.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b2.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b2.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b3.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b3.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b3.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b4.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b4.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b4.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b5.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b5.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b5.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b6.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b6.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b6.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b7.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b7.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b7.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b8.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b8.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b8.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b9.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        b9.setText("X");
                        mInfo.setText(getString(R.string.turn_player_two));
                    } else if (turn == 2) {
                        turn = 1;
                        b9.setText("0");
                        mInfo.setText(getString(R.string.turn_player_one));
                    }
                }
                endGame();
            }
        });
    }

    public void endGame() {
        String a, b, c, d, e, f, g, h, i;
        boolean end = false;
        a = b1.getText().toString();
        b = b2.getText().toString();
        c = b3.getText().toString();
        d = b4.getText().toString();
        e = b5.getText().toString();
        f = b6.getText().toString();
        g = b7.getText().toString();
        h = b8.getText().toString();
        i = b9.getText().toString();

        // Conditions for player 1 win
        if (a.equals("X") && b.equals("X") && c.equals("X")) {
            changeColor(b1, b2, b3);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;

        }

        if (a.equals("X") && e.equals("X") && i.equals("X")) {
            changeColor(b1, b5, b9);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }

        if (a.equals("X") && d.equals("X") && g.equals("X")) {
            changeColor(b1, b4, b7);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }

        if (b.equals("X") && e.equals("X") && h.equals("X")) {
            changeColor(b2, b5, b8);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }

        if (c.equals("X") && f.equals("X") && i.equals("X")) {
            changeColor(b3, b6, b9);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }

        if (c.equals("X") && e.equals("X") && g.equals("X")) {
            changeColor(b3, b5, b7);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }
        if (d.equals("X") && e.equals("X") && f.equals("X")) {
            changeColor(b4, b5, b6);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }
        if (g.equals("X") && h.equals("X") && i.equals("X")) {
            changeColor(b7, b8, b9);
            showToast("Player 1 wins Hurray");
            mPlayerOneCounter++;
            updateInfoAndCounter(PLAYER_ONE);
            end = true;
        }

        //Conditions for player 2 wins
        if (a.equals("0") && b.equals("0") && c.equals("0")) {
            changeColor(b1, b2, b3);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (a.equals("0") && e.equals("0") && i.equals("0")) {
            changeColor(b1, b5, b9);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (a.equals("0") && d.equals("0") && g.equals("0")) {
            changeColor(b1, b4, b7);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (b.equals("0") && e.equals("0") && h.equals("0")) {
            changeColor(b2, b5, b8);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (c.equals("0") && f.equals("0") && i.equals("0")) {
            changeColor(b3, b6, b9);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (c.equals("0") && e.equals("0") && g.equals("0")) {
            changeColor(b3, b5, b7);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }
        if (d.equals("0") && e.equals("0") && f.equals("0")) {
            changeColor(b4, b5, b6);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }
        if (g.equals("0") && h.equals("0") && i.equals("0")) {
            changeColor(b7, b8, b9);
            showToast("Player 2 wins Hurray");
            mPlayerTwoCounter++;
            updateInfoAndCounter(PLAYER_TWO);
            end = true;
        }

        if (end) {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        } else {
            if (!TextUtils.isEmpty(a)
                    && !TextUtils.isEmpty(b)
                    && !TextUtils.isEmpty(c)
                    && !TextUtils.isEmpty(d)
                    && !TextUtils.isEmpty(e)
                    && !TextUtils.isEmpty(f)
                    && !TextUtils.isEmpty(g)
                    && !TextUtils.isEmpty(h)
                    && !TextUtils.isEmpty(i)) {
                showToast("Game Draw");
                mTieCounter++;
                updateInfoAndCounter(NONE);
            }
        }
    }

    private void updateInfoAndCounter(int who) {
        if (who == PLAYER_ONE) {
            mInfo.setText(getString(R.string.result_player_one));
            mPlayerOneCount.setText(getString(R.string.player_one, Integer.toString(mPlayerOneCounter)));
        } else if (who == PLAYER_TWO) {
            mInfo.setText(getString(R.string.result_player_two));
            mPlayerTwoCount.setText(getString(R.string.player_two, Integer.toString(mPlayerTwoCounter)));
        } else {
            mInfo.setText(getString(R.string.result_tie));
            mTieCount.setText(getString(R.string.ties, Integer.toString(mTieCounter)));
        }
    }

    private void changeColor(Button b1, Button b2, Button b3) {
        b1.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
        b2.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
        b3.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
    }

    public void showToast(String msg) {

        View customToastroot = mInflater.inflate(R.layout.layout_custom_toast, null);
        TextView toastText = (TextView) customToastroot.findViewById(R.id.textView_toast);
        toastText.setText(msg);

        Toast customtoast = new Toast(mContext);

        customtoast.setView(customToastroot);
        customtoast.setDuration(Toast.LENGTH_LONG);
        customtoast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reset:
                // for button 1
                b1.setText("");
                b1.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b1.setEnabled(true);

                // for button 2
                b2.setText("");
                b2.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b2.setEnabled(true);

                // for button 3
                b3.setText("");
                b3.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b3.setEnabled(true);

                // for button 4
                b4.setText("");
                b4.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b4.setEnabled(true);

                // for button 5
                b5.setText("");
                b5.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b5.setEnabled(true);

                // for button 6
                b6.setText("");
                b6.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b6.setEnabled(true);

                // for button 7
                b7.setText("");
                b7.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b7.setEnabled(true);

                // for button 8
                b8.setText("");
                b8.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b8.setEnabled(true);

                // for button 9
                b9.setText("");
                b9.setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
                b9.setEnabled(true);

                turn = 1;
                mInfo.setText(getString(R.string.first_human));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
