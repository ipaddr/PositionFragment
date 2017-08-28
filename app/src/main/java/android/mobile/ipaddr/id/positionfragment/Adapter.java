package android.mobile.ipaddr.id.positionfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iip on 8/28/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private Context context;
    private List<SomeObject> someObjects;

    public Adapter(List<SomeObject> someObjects) {
        this.someObjects = someObjects;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        SomeObject someObject = someObjects.get(position);
        holder.tv1.setText(someObject.variable1);
        holder.tv2.setText(someObject.variable2);
        holder.tv3.setText(someObject.variable3);
    }

    @Override
    public int getItemCount() {
        return someObjects.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        TextView tv1, tv2, tv3;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }

}
