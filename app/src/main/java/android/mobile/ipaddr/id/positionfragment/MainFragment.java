package android.mobile.ipaddr.id.positionfragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iip on 8/28/17.
 */

public class MainFragment extends Fragment {

    private List<SomeObject> someObjects;
    private RecyclerView recyclerView;

    public MainFragment(){}

    public static MainFragment newInstance(List<SomeObject> someObjects){
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        SomeObject[] objects = new SomeObject[someObjects.size()];
        objects = someObjects.toArray(objects);
        bundle.putParcelableArray("data", objects);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey("data")){
            SomeObject[] objects = (SomeObject[]) getArguments().getParcelableArray("data");
            someObjects = Arrays.asList(objects);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = rootView.findViewById(R.id.rv);
        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView(){
        Adapter adapter = new Adapter(someObjects);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private static final String BUNDLE_RECYCLER_LAYOUT = "classname.recycler.layout";

    /**
     * This is a method for Fragment.
     * You can do the same in onCreate or onRestoreInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null)
        {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, recyclerView.getLayoutManager().onSaveInstanceState());
    }
}
