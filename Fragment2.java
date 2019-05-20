package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment2 extends Fragment {
private Button but_touxiang;
private ImageView iv_zhuanji;
private ImageView iv_zhuanji_top;
String type = "0";


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        View view=inflater.inflate(R.layout.layout2, container, false);

        but_touxiang = (Button)view.findViewById(R.id.but_spbz);
        iv_zhuanji = (ImageView)view.findViewById(R.id.Iv_zhuanji_bottom);
        iv_zhuanji_top = (ImageView)view.findViewById(R.id.iv_zhuanji_top);


        but_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Image_show_tow.class);
                intent.putExtra("name","spbz");//锁屏壁纸
                startActivity(intent);
            }
        });

        iv_zhuanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Show_zhuanji.class);
                intent.putExtra("name",type);
                startActivity(intent);            }
        });

        iv_zhuanji_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("0"))
                {
                    type = "1";
                    iv_zhuanji.setImageResource(R.drawable.zhuanji_bottom_one);
                }
                else if (type.equals("2"))
                {
                    type = "0";
                    iv_zhuanji.setImageResource(R.drawable.zhuangji_bottom);

                }
                else if (type.equals("1"))
                {
                    type = "2";
                    iv_zhuanji.setImageResource(R.drawable.zhuanji_show_waibu);

                }

            }
        });


        return view;

    }



}