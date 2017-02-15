package group9.tcss450.uw.edu.challangeapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistrationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RegistrationFragment extends Fragment {

    private static final String PARTIAL_URL = "http://cssgate.insttech.washington.edu/~yktsang/";
    private OnFragmentInteractionListener mListener;
    private View mV;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mV = inflater.inflate(R.layout.fragment_registration, container, false);
        Button b = (Button) mV.findViewById(R.id.regSignup);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    EditText editText = (EditText) mV.findViewById(R.id.regName);
                    String userName = editText.getText().toString();
                    editText = (EditText) mV.findViewById(R.id.regPassword);
                    String password = editText.getText().toString();
                    //mListener.onFragmentInteraction(R.id.regSignup, userName, password);
                    AsyncTask<String, Void, String> task = new RegistrationTask();
                    task.execute(PARTIAL_URL, userName, password);
                }
            }
        });
        return mV;
    }

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

    private class RegistrationTask extends AsyncTask<String, Void, String> {
        private final String SERVICE = "reg.php";

        @Override
        protected String doInBackground(String... strings) {
            if (strings.length != 3) {
                throw new IllegalArgumentException("Three String arguments required.");
            }
            String  response = "";
            HttpURLConnection urlConnection = null;
            String url = strings[0];
            try {
                URL urlObject = new URL(url + SERVICE);
                urlConnection = (HttpURLConnection) urlObject.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
                String data = URLEncoder.encode("my_reg_name", "UTF-8") +
                        "=" + URLEncoder.encode(strings[1], "UTF-8") +
                        "&" + URLEncoder.encode("my_reg_pwd", "UTF-8") +
                        "=" + URLEncoder.encode(strings[2], "UTF-8");
                wr.write(data);
                wr.flush();
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
            if (result.startsWith("Unable to")) {
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
            Log.d("result", result);
        }
    }
}
