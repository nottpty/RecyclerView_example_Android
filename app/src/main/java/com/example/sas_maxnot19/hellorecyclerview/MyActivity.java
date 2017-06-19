package com.example.sas_maxnot19.hellorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CustomAdapter(this, initPlayer());
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter = new CustomAdapter(this, listBarca());
//        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
        snapHelperStart.attachToRecyclerView(mRecyclerView);
    }

    private List<Player> initPlayer() {

        Player messi = new Player("Leonel Missi", "Barcelona");
        Player ronaldo = new Player("Cristiano Ronaldo", "Real Madrid");
        Player suarez = new Player("Luis Suarez", "Liverpool");

        List<Player> dataset = new ArrayList<Player>();

        dataset.add(messi);
        dataset.add(ronaldo);
        dataset.add(suarez);

        return dataset;
    }

    private List<Player> listBarca() {

        Player messi = new Player("Leonel Missi", "Barcelona");
        Player suarez = new Player("Luis Suarez", "Liverpool");

        List<Player> dataset = new ArrayList<Player>();

        dataset.add(messi);
        dataset.add(suarez);

        return dataset;
    }
}
