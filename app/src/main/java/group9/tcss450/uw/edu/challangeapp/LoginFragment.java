package group9.tcss450.uw.edu.challangeapp;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LoginFragment extends Fragment /*implements View.OnClickListener*/ {

    public static final String LOGIN = "loginKey";
    public static final String PASSWORD = "loginPassword";
    private static final String PARTIAL_URL = "http://cssgate.insttech.washington.edu/~yktsang/";
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
//                    mListener.onFragmentInteraction(R.id.loginSignin, userName, password);
                    AsyncTask<String, Void, String> task = new LoginTask();
                    task.execute(PARTIAL_URL, userName, password);
                }
            }
        });
        return mV;
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

    private class LoginTask extends AsyncTask<String, Void, String> {
        private final String SERVICE = "login.php";

        @Override
        protected String doInBackground(String... strings) {
            if (strings.length != 3) {
                throw new IllegalArgumentException("Three String arguments required.");
            }
            String response = "";
            HttpURLConnection urlConnection = null;
            String url = strings[0];
            try {
                URL urlObject = new URL(url + SERVICE);
                urlConnection = (HttpURLConnection) urlObject.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
                String data = URLEncoder.encode("my_login_name", "UTF-8") +
                        "=" + URLEncoder.encode(strings[1], "UTF-8") +
                        "&" + URLEncoder.encode("my_login_pwd", "UTF-8") +
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
            // Without "|| result.isEmoty()" can login even failed
            if (result.startsWith("Unable to") /*||result.isEmpty()*/) {
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), result +"\nLogin Successful!", Toast.LENGTH_LONG).show();
                GetSetlistFragement mSL = new GetSetlistFragement();
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
            }
            Log.d("result", result);
        }
    }
}
