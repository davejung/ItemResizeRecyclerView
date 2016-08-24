package com.example.jaehoonjung.practice_interaction;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jaehoonjung.practice_interaction.Activity.CustomLayoutManager;
import com.example.jaehoonjung.practice_interaction.Activity.CustomRecyclerView;
import com.example.jaehoonjung.practice_interaction.Activity.MagazineAdapter;
import com.example.jaehoonjung.practice_interaction.Custom.BaseActivity;
import com.example.jaehoonjung.practice_interaction.Data.MagazineData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeDatas();

    }

    @Bind(R.id.recyclerview)
    CustomRecyclerView recyclerview;

    List<MagazineData> magazineDatas = new ArrayList<MagazineData>();
    MagazineAdapter magazineAdapter;
    CustomLayoutManager customLayoutManager;

    private void makeDatas(){

        magazineDatas.add(new MagazineData("Main Title\n1", "Summary1", R.drawable.image1));
        magazineDatas.add(new MagazineData("Main Title\n2", "Summary2", R.drawable.image2));
        magazineDatas.add(new MagazineData("Main Title\n3", "Summary3", R.drawable.image3));
        magazineDatas.add(new MagazineData("Main Title\n4", "Summary4", R.drawable.image4));
        magazineDatas.add(new MagazineData("Main Title\n5", "Summary5", R.drawable.image5));
        magazineDatas.add(new MagazineData("Main Title\n6", "Summary6", R.drawable.image6));
        magazineDatas.add(new MagazineData("Main Title\n7", "Summary7", R.drawable.image7));
        magazineDatas.add(new MagazineData("Main Title\n8", "Summary8", R.drawable.image8));
        magazineDatas.add(new MagazineData("Main Title\n9", "Summary9", R.drawable.image1));
        magazineDatas.add(new MagazineData("Main Title\n10", "Summary10", R.drawable.image2));
        magazineDatas.add(new MagazineData("Main Title\n11", "Summary11", R.drawable.image3));
        magazineDatas.add(new MagazineData("Main Title\n12", "Summary12", R.drawable.image4));
        magazineDatas.add(new MagazineData("Main Title\n13", "Summary13", R.drawable.image5));
        magazineDatas.add(new MagazineData("Main Title\n14", "Summary14", R.drawable.image6));
        magazineDatas.add(new MagazineData("Main Title\n15", "Summary15", R.drawable.image7));
        magazineDatas.add(new MagazineData("Main Title\n16", "Summary16", R.drawable.image8));
        magazineDatas.add(new MagazineData("Main Title\n17", "Summary17", R.drawable.image1));
        magazineDatas.add(new MagazineData("Main Title\n18", "Summary18", R.drawable.image2));
        magazineDatas.add(new MagazineData("Main Title\n19", "Summary19", R.drawable.image3));
        magazineDatas.add(new MagazineData("Main Title\n20", "Summary20", R.drawable.image4));
        magazineDatas.add(new MagazineData("Main Title\n21", "Summary21", R.drawable.image5));

        magazineAdapter = new MagazineAdapter(getResources().getDisplayMetrics().widthPixels);
        magazineAdapter.setSource(magazineDatas);
        customLayoutManager = new CustomLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerview.setLayoutManager(customLayoutManager);
        recyclerview.setAdapter(magazineAdapter);
        recyclerview.setItemAnimator(new DefaultItemAnimator());


    }


}
