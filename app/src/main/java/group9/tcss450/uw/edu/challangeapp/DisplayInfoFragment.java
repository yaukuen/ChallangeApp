package group9.tcss450.uw.edu.challangeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayInfoFragment extends Fragment {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
//    private OnFragmentInteractionListener mListener;

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            TextView et = (TextView) getActivity().findViewById(R.id.displayName);
            et.setText(getArguments().getString(USERNAME));
            et = (TextView) getActivity().findViewById(R.id.displayPassword);
            et.setText(getArguments().getString(PASSWORD));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_info, container, false);
    }


}
