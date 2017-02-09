package swetabh.suman.com.crosszero;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VsAndroidFragment extends Fragment {

    private CrossZeroGame mGame;
    private Button mBoardButtons[];
    private TextView mInfo, mHumanCount, mTieCount, mAndroidCount;
    private int mHumanCounter = 0;
    private int mTieCounter = 0;
    private int mAndroidCounter = 0;

    private boolean mHumanFirst = true;
    private boolean mGameOver = false;
    private Context mContext;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vs_android);
        mGame = new CrossZeroGame();

        mBoardButtons = new Button[CrossZeroGame.getBoardSize()];
        mBoardButtons[0] = (Button) findViewById(R.id.button1);
        mBoardButtons[1] = (Button) findViewById(R.id.button2);
        mBoardButtons[2] = (Button) findViewById(R.id.button3);
        mBoardButtons[3] = (Button) findViewById(R.id.button4);
        mBoardButtons[4] = (Button) findViewById(R.id.button5);
        mBoardButtons[5] = (Button) findViewById(R.id.button6);
        mBoardButtons[6] = (Button) findViewById(R.id.button7);
        mBoardButtons[7] = (Button) findViewById(R.id.button8);
        mBoardButtons[8] = (Button) findViewById(R.id.button9);

        mInfo = (TextView) findViewById(R.id.info);
        mHumanCount = (TextView) findViewById(R.id.human_count);
        mTieCount = (TextView) findViewById(R.id.tie_count);
        mAndroidCount = (TextView) findViewById(R.id.android_count);

        mHumanCount.setText(getString(R.string.human, Integer.toString(mHumanCounter)));
        mTieCount.setText(getString(R.string.ties, Integer.toString(mTieCounter)));
        mAndroidCount.setText(getString(R.string.android, Integer.toString(mAndroidCounter)));

        mGame = new CrossZeroGame();
        startNewGame();
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vs_android, container, false);

        mContext = getActivity();
        mGame = new CrossZeroGame();

        mBoardButtons = new Button[CrossZeroGame.getBoardSize()];
        mBoardButtons[0] = (Button) view.findViewById(R.id.button1);
        mBoardButtons[1] = (Button) view.findViewById(R.id.button2);
        mBoardButtons[2] = (Button) view.findViewById(R.id.button3);
        mBoardButtons[3] = (Button) view.findViewById(R.id.button4);
        mBoardButtons[4] = (Button) view.findViewById(R.id.button5);
        mBoardButtons[5] = (Button) view.findViewById(R.id.button6);
        mBoardButtons[6] = (Button) view.findViewById(R.id.button7);
        mBoardButtons[7] = (Button) view.findViewById(R.id.button8);
        mBoardButtons[8] = (Button) view.findViewById(R.id.button9);

        mInfo = (TextView) view.findViewById(R.id.info);
        mHumanCount = (TextView) view.findViewById(R.id.human_count);
        mTieCount = (TextView) view.findViewById(R.id.tie_count);
        mAndroidCount = (TextView) view.findViewById(R.id.android_count);

        mHumanCount.setText(getString(R.string.human, Integer.toString(mHumanCounter)));
        mTieCount.setText(getString(R.string.ties, Integer.toString(mTieCounter)));
        mAndroidCount.setText(getString(R.string.android, Integer.toString(mAndroidCounter)));

        mGame = new CrossZeroGame();
        startNewGame();
        return view;
    }

    private void startNewGame() {

        mGame.clearBoard();
        mGameOver = false;

        for (int i = 0; i < mBoardButtons.length; i++) {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setTextColor(ContextCompat.getColor(mContext, R.color.colorBlack));
            mBoardButtons[i].setOnClickListener(new ButtonBoardClickListener(i));
        }

        if (mHumanFirst) {
            mInfo.setText(getString(R.string.first_human));
            mHumanFirst = false;
        } else {
            mInfo.setText(getString(R.string.turn_android));
            int move = mGame.getComputerMove();
            setMove(mGame.ANDROID_PLAYER, move);
            mHumanFirst = true;
        }
    }

    private void setMove(char player, int location) {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
    }

    private class ButtonBoardClickListener implements View.OnClickListener {
        int location;

        public ButtonBoardClickListener(int i) {
            location = i;
        }

        @Override
        public void onClick(View view) {
            if (!mGameOver) {
                if (mBoardButtons[location].isEnabled()) {
                    setMove(mGame.HUMAN_PLAYER, location);
                    int winner = mGame.checkForWinner();

                    if (winner == 0) {
                        mInfo.setText(getString(R.string.turn_android));
                        int move = mGame.getComputerMove();
                        setMove(mGame.ANDROID_PLAYER, move);
                        winner = mGame.checkForWinner();
                    }
                    if (winner == 0) {
                        mInfo.setText(getString(R.string.turn_human));
                    } else if (winner == 1) {
                        mInfo.setText(getString(R.string.result_tie));
                        mTieCounter++;
                        mTieCount.setText(getString(R.string.ties, Integer.toString(mTieCounter)));
                        mGameOver = true;
                    } else if (winner == 2) {
                        mInfo.setText(getString(R.string.result_human));
                        mHumanCounter++;
                        mHumanCount.setText(getString(R.string.human, Integer.toString(mHumanCounter)));
                        changeColor(mGame.HUMAN_PLAYER);
                        mGameOver = true;
                    } else if (winner == 3) {
                        mInfo.setText(getString(R.string.result_android));
                        mAndroidCounter++;
                        mAndroidCount.setText(getString(R.string.android, Integer.toString(mAndroidCounter)));
                        mGameOver = true;
                        changeColor(mGame.ANDROID_PLAYER);
                    }
                }
            }
        }
    }

    private void changeColor(char player) {
        switch (player) {
            case '0':
                if (mBoardButtons[0].getText().equals("0") &&
                        mBoardButtons[1].getText().equals("0") &&
                        mBoardButtons[2].getText().equals("0")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[1].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[0].getText().equals("0") &&
                        mBoardButtons[4].getText().equals("0") &&
                        mBoardButtons[8].getText().equals("0")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[0].getText().equals("0") &&
                        mBoardButtons[3].getText().equals("0") &&
                        mBoardButtons[6].getText().equals("0")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[3].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[1].getText().equals("0") &&
                        mBoardButtons[4].getText().equals("0") &&
                        mBoardButtons[7].getText().equals("0")) {
                    mBoardButtons[1].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[7].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[2].getText().equals("0") &&
                        mBoardButtons[5].getText().equals("0") &&
                        mBoardButtons[8].getText().equals("0")) {
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[5].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[3].getText().equals("0") &&
                        mBoardButtons[4].getText().equals("0") &&
                        mBoardButtons[5].getText().equals("0")) {
                    mBoardButtons[3].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[5].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[6].getText().equals("0") &&
                        mBoardButtons[7].getText().equals("0") &&
                        mBoardButtons[8].getText().equals("0")) {
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[7].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[2].getText().equals("0") &&
                        mBoardButtons[4].getText().equals("0") &&
                        mBoardButtons[6].getText().equals("0")) {
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                }
                break;
            case 'X':
                if (mBoardButtons[0].getText().equals("X") &&
                        mBoardButtons[1].getText().equals("X") &&
                        mBoardButtons[2].getText().equals("X")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[1].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[0].getText().equals("X") &&
                        mBoardButtons[4].getText().equals("X") &&
                        mBoardButtons[8].getText().equals("X")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[0].getText().equals("X") &&
                        mBoardButtons[3].getText().equals("X") &&
                        mBoardButtons[6].getText().equals("X")) {
                    mBoardButtons[0].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[3].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[1].getText().equals("X") &&
                        mBoardButtons[4].getText().equals("X") &&
                        mBoardButtons[7].getText().equals("X")) {
                    mBoardButtons[1].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[7].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[2].getText().equals("X") &&
                        mBoardButtons[5].getText().equals("X") &&
                        mBoardButtons[8].getText().equals("X")) {
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[5].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[3].getText().equals("X") &&
                        mBoardButtons[4].getText().equals("X") &&
                        mBoardButtons[5].getText().equals("X")) {
                    mBoardButtons[3].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[5].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[6].getText().equals("X") &&
                        mBoardButtons[7].getText().equals("X") &&
                        mBoardButtons[8].getText().equals("X")) {
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[7].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[8].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                } else if (mBoardButtons[2].getText().equals("X") &&
                        mBoardButtons[4].getText().equals("X") &&
                        mBoardButtons[6].getText().equals("X")) {
                    mBoardButtons[2].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[4].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                    mBoardButtons[6].setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setHasOptionsMenu(true);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reset:
                startNewGame();
                break;
        }
        return true;
    }
}
