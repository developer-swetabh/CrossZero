package swetabh.suman.com.crosszero;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeScreenFragment extends Fragment {
    private Context mContext;


    public HomeScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);
        mContext = getActivity();
        final CardView _vsPlayerCard = (CardView) view.findViewById(R.id.card_vs_player);
        final CardView _vsAndroidCard = (CardView) view.findViewById(R.id.card_vs_android);
        final CardView _vsExitCard = (CardView) view.findViewById(R.id.card_exit);

        final Animation slide_down = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_down);

        final Animation slide_up = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_up);
        final Animation slide_right = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_right);

        final Animation slide_return_from_up = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_return_from_up);

        final Animation slide_return_from_down = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_return_from_down);

        final Animation slide_return_from_right = AnimationUtils.loadAnimation(mContext,
                R.anim.slide_return_from_right);

        _vsPlayerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                _vsAndroidCard.startAnimation(slide_up);
                _vsPlayerCard.startAnimation(slide_right);
                _vsExitCard.startAnimation(slide_down);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((HomeScreenActivity) mContext).flipCard(new VsPlayerFragment());
                    }
                }, 300);

            }
        });

        _vsAndroidCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _vsAndroidCard.startAnimation(slide_up);
                _vsPlayerCard.startAnimation(slide_right);
                _vsExitCard.startAnimation(slide_down);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((HomeScreenActivity) mContext).flipCard(new VsAndroidFragment());
                    }
                }, 300);
            }
        });

        _vsExitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _vsAndroidCard.startAnimation(slide_up);
                _vsPlayerCard.startAnimation(slide_right);
                _vsExitCard.startAnimation(slide_down);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((HomeScreenActivity) mContext).finish();
                    }
                }, 300);
            }
        });

        _vsAndroidCard.startAnimation(slide_return_from_up);
        _vsPlayerCard.startAnimation(slide_return_from_right);
        _vsExitCard.startAnimation(slide_return_from_down);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(false);
    }

}
