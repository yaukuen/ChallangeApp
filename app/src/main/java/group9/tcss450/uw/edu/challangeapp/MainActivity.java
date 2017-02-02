package group9.tcss450.uw.edu.challangeapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ChoicesFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener, RegistrationFragment.OnFragmentInteractionListener,
DisplayInfoFragment.OnFragmentInteractionListener{

    private LoginFragment mLogin;
    private RegistrationFragment mReg;
    private DisplayInfoFragment mDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState == null) {
//            if (findViewById(R.id.fragmentContainer) != null) {
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.fragmentContainer, new ChoicesFragment())
//                        .commit();
//            }
//        }
    }

    @Override
    public void onFragmentInteraction(int choice) {
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
        if (choice == R.id.loginButton) {
            mLogin = new LoginFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, mLogin)
                    .addToBackStack(null);
            // Commit the transaction
            transaction.commit();

        } else if (choice == R.id.registrationButton) {
            mReg = new RegistrationFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.choice, mReg)
                    .addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        } else if (choice == R.id.loginSignin || choice == R.id.regSignup) {
            mDis = new DisplayInfoFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, mDis)
                    .addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }
    }
}
