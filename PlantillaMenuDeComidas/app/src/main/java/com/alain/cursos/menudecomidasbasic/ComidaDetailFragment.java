package com.alain.cursos.menudecomidasbasic;

import android.app.Activity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alain.cursos.menudecomidasbasic.dummy.DummyContent;

/* *
 * Firebase for Android
 * Created by Alain Nicolás Tello on 01/04/2020 at 01:16pm
 * All rights reserved 2020.
 * Course Specialize in Firebase for Android with MVP 2018-2020
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

/**
 * A fragment representing a single Comida detail screen.
 * This fragment is either contained in a {@link ComidaListActivity}
 * in two-pane mode (on tablets) or a {@link ComidaDetailActivity}
 * on handsets.
 */
public class ComidaDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy name this fragment is presenting.
     */
    private DummyContent.Comida mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ComidaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy name specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load name from a name provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.comida_detail, container, false);

        // Show the dummy name as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.comida_detail)).setText(mItem.getPrice());
        }

        return rootView;
    }
}
