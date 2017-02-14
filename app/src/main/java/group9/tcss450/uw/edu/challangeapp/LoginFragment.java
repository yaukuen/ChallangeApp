package group9.tcss450.uw.edu.challangeapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LoginFragment extends Fragment /*implements View.OnClickListener*/ {

    public static final String LOGIN = "loginKey";
    public static final String PASSWORD = "loginPassword";

    private OnFragmentInteractionListener mListener;

    private View mV;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mV = inflater.inflate(R.layout.fragment_login, container, false);
        Button button = (Button) mV.findViewById(R.id.loginSignin);
//        button.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    EditText editText = (EditText) mV.findViewById(R.id.loginName);
                    String userName = editText.getText().toString();
                    editText = (EditText) mV.findViewById(R.id.loginPassword);
                    String password = editText.getText().toString();
                    mListener.onFragmentInteraction(R.id.loginSignin, userName, password);
                }
            }
        });
        return mV;
    }

//    @Override
//    public void onClick(View v) {
//        if (mListener != null) {
//            EditText editText = (EditText) mV.findViewById(R.id.loginName);
//            String userName = editText.getText().toString();
//            editText = (EditText) mV.findViewById(R.id.loginPassword);
//            String password = editText.getText().toString();
//            mListener.onFragmentInteraction(R.id.loginSignin, userName, password);
//        }
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


//    @Override
//    public void onClick(View v) {
//        if (mListener != null) {
//            EditText et = (EditText)
//        }
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int choice, String username, String password);
    }
}
