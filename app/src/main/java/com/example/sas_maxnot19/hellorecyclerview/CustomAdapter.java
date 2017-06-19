package com.example.sas_maxnot19.hellorecyclerview;

/**
 * Created by sas-maxnot19 on 6/19/2017 AD.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Player> mPlayers;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mClub;

        public ViewHolder(View view) {
            super(view);

            mName = (TextView) view.findViewById(R.id.name);
            mClub = (TextView) view.findViewById(R.id.club);
        }
    }

    public CustomAdapter(Context context, List<Player> dataset) {
        mPlayers = dataset;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_view_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Player player = mPlayers.get(position);

        if(!player.getClub().equals("Real Madrid")) {
            viewHolder.mName.setText(player.getName());
            viewHolder.mClub.setText(player.getClub());

            if(player.getClub().equals("Barcelona")) {
                viewHolder.mClub.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

}
