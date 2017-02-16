package group9.tcss450.uw.edu.challangeapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GetSetlistFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GetSetlistFragement extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    private static final String PARTIAL_URL = "http://cssgate.insttech.washington.edu/~cfb3/TCSS450A-W17/phish/setlist/";
    private OnFragmentInteractionListener mListener;
    private TextView mTV;
    private View mV;

    public GetSetlistFragement() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mV = inflater.inflate(R.layout.fragment_get_setlist_fragement, container, false);
        mTV = (TextView) mV.findViewById(R.id.tv_testing);
        final String[] IDs = getResources().getStringArray(R.array.auto_complete_show_id);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_dropdown_item_1line,
                        IDs);
        AutoCompleteTextView text = (AutoCompleteTextView) mV.findViewById(R.id.autoCompleteTextView);
        text.setAdapter(adapter);
        Button b = (Button) mV.findViewById(R.id.search_random_button);
        b.setOnClickListener(this);
//        b = (Button) mV.findViewById(R.id.search_recent_button);
//        b.setOnClickListener(this);
//        b = (Button) mV.findViewById(R.id.search_id_button);
//        b.setOnClickListener(this);
        return mV;
    }

    @Override
    public void onClick(View view) {
        AsyncTask<String, Void, String> task = null;
        if (mListener != null) {
            Log.d("result", String.valueOf(mListener));
            switch (view.getId()) {
                case R.id.search_random_button:
//                    mListener.onFragmentInteraction(null);
                    Button b = (Button) mV.findViewById(R.id.search_random_button);
                    b.setClickable(false);
                    task = new RandomTask();
                    break;
////                case R.id.search_recent_button:
////                    mListener.onFragmentInteraction(null);
////                    break;
////                case R.id.search_id_button:
////                    AutoCompleteTextView actv = (AutoCompleteTextView) mV.findViewById(R.id.autoCompleteTextView);
////                    String s = actv.getText().toString();
////                    mListener.onFragmentInteraction(s);
////                    break;
            }
//            Button b = (Button) mV.findViewById(R.id.search_random_button);
//            b.setClickable(false);
//            mTV.setText("HAHA");
//            task = new RandomTask();
            task.execute(PARTIAL_URL);
        }
    }
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction("");
//        }
//    }

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
        void onFragmentInteraction();
//        void onFragmentInteraction(int choice, String username, String password);
    }

    private class RandomTask extends AsyncTask<String, Void, String> {
        private final String SERVICE = "random.php";

        @Override
        protected String doInBackground(String... strings) {
            String response = "";
            HttpURLConnection urlConnection = null;
            String url = strings[0];
            try {
                URL urlObject = new URL(url + SERVICE);
                urlConnection = (HttpURLConnection) urlObject.openConnection();
                InputStream content = urlConnection.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                String s = "";
                while ((s = buffer.readLine()) != null) {
                    response += s;
                }
            } catch (Exception e) {
                response = "Unable to connect, Reason: " + e.getMessage();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
//            if (result.startsWith("Unable to") || result.isEmpty()) {
//                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//            } else {
            Toast.makeText(getActivity().getApplicationContext(), "heyheyhey", Toast.LENGTH_LONG).show();
            SetlistFragment mSL = new SetlistFragment();
//                Bundle args = new Bundle();
//                args.putSerializable(DisplayInfoFragment.USERNAME, username);
//                args.putSerializable(DisplayInfoFragment.PASSWORD, password);
//                mDis.setArguments(args);
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.fragmentContainer, mSL)
                    .addToBackStack(null)
                    // Commit the transaction
                    .commit();
            // WHY THIS ONE DOESN'T WORK!!!!!!!!!?????????????????
//                FragmentTransaction ft = fm.beginTransaction();
//                        ft.replace(R.id.fragmentContainer, mDis)
//                        .addToBackStack(null)
//                        // Commit the transaction
//                        .commit();
//            }
            Log.d("result", result);

        }
    }
}
