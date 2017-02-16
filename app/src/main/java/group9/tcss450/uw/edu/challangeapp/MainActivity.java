package group9.tcss450.uw.edu.challangeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ChoicesFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener, RegistrationFragment.OnFragmentInteractionListener, GetSetlistFragement.OnFragmentInteractionListener {

//    private LoginFragment mLogin;
//    private RegistrationFragment mReg;
//    private DisplayInfoFragment mDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            if (findViewById(R.id.choice) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.choice, new ChoicesFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onFragmentInteraction(int choice, String username, String password) {
//        Log.d("ACTIVITY", "Red: ");
//
//        FlowerFragment flowerFragment;
//        flowerFragment = (FlowerFragment) getSupportFragmentManager().
//                findFragmentById(R.id.flower);
//        if (flowerFragment != null) {
//            flowerFragment.updateContent(color);
//        } else {
//            flowerFragment = new FlowerFragment();
//            Bundle args = new Bundle();
//            args.putSerializable(flowerFragment.COLOR, color);
//            flowerFragment.setArguments(args);
//            FragmentTransaction transaction = getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragmentContainer, flowerFragment)
//                    .addToBackStack(null);
//            // Commit the transaction
//            transaction.commit();
//        }
//        FragmentTransaction transaction = getSupportFragmentManager();
        switch (choice) {
            case R.id.loginButton:
                LoginFragment mLogin = new LoginFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.choice, mLogin)
                        .addToBackStack(null)
                        // Commit the transaction
                        .commit();
                break;
            case R.id.registrationButton:
                RegistrationFragment mReg = new RegistrationFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.choice, mReg)
                        .addToBackStack(null)
                        // Commit the transaction
                        .commit();
                break;
//            case R.id.loginSignin:
//                GetSetlistFragement mGet = new GetSetlistFragement();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fragmentContainer, mGet)
//                        .addToBackStack(null)
//                        // Commit the transaction
//                        .commit();

//                break;
//            default:
//                DisplayInfoFragment mDis = new DisplayInfoFragment();
//                Bundle args = new Bundle();
//                args.putSerializable(DisplayInfoFragment.USERNAME, username);
//                args.putSerializable(DisplayInfoFragment.PASSWORD, password);
//                mDis.setArguments(args);
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fragmentContainer, mDis)
//                        .addToBackStack(null)
//                        // Commit the transaction
//                        .commit();
//                break;
        }
//        if (choice ==  R.id.loginButton) {
//            mLogin = new LoginFragment();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.choice, mLogin)
//                        .addToBackStack(null)
//                        // Commit the transaction
//                        .commit();
//        }

    }

    @Override
    public void onFragmentInteraction() {

    }
}
