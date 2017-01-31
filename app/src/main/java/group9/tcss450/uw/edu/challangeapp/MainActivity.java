package group9.tcss450.uw.edu.challangeapp;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ChoicesFragment.OnFragmentInteractionListener{

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
    }
}
