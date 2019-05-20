package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {
    Button butt_shangchuan ;
    Button butt_xiazai;
    Button butt_benji;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view=inflater.inflate(R.layout.layout3, container, false);

        butt_xiazai = (Button)view.findViewById(R.id.but_xiazai);
        butt_shangchuan = (Button)view.findViewById(R.id.but_shangchuan);
        butt_benji = (Button)view.findViewById(R.id.benji_shangchuan) ;

        butt_xiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Xiazai_mainactiviity.class);
                startActivity(intent);

            }
        });
        butt_shangchuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),shangchuan_activity.class);
                startActivity(intent);
            }
        });
        butt_benji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SelectPicActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}