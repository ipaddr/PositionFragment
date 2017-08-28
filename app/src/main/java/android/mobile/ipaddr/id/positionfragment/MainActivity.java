package android.mobile.ipaddr.id.positionfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private List<SomeObject> someObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            someObjects = initObject();
            initFragment(someObjects);
        }
    }

    private List<SomeObject> initObject(){
        List<SomeObject> someObjects  = new ArrayList<>();
        for(int i = 1; i < 100 ; i++){
            SomeObject someObject = new SomeObject();
            someObject.variable1 = String.format("number-%s%s%s", String.valueOf(i), "-", String.valueOf(random.nextInt(100)));
            someObject.variable2 = String.format("number-%s%s%s", String.valueOf(i), "-", String.valueOf(random.nextInt(100)));
            someObject.variable3 = String.format("number-%s%s%s", String.valueOf(i), "-", String.valueOf(random.nextInt(100)));
            someObjects.add(someObject);
        }
        return someObjects;
    }

    private void initFragment(List<SomeObject> someObjects){
        Fragment fragment = MainFragment.newInstance(someObjects);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }
}
