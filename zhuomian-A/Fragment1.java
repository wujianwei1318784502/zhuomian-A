package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    String something = new String();
    EditText editText;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        View view= inflater.inflate(R.layout.layout1, container, false);

//帅哥 美女  卡通

        //对View中控件的操作方法

        Button btn_fjjz = (Button)view.findViewById(R.id.but_fjjz);
        Button btn_mxxz = (Button)view.findViewById(R.id.but_mxxz);
        ImageView btn_sou = (ImageView) view.findViewById(R.id.but_sou);




        editText = (EditText)view.findViewById(R.id.edit_sou);


        btn_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                something = editText.getText().toString();
                Intent intent = new Intent(getActivity(),Sou_activity.class);
                intent.putExtra("name",something);
                startActivity(intent);
                Log.d("Fra", "something is " + something);
            }
        });


        btn_fjjz.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(),Image_show_activity.class);
                intent.putExtra("name","fjjz");
                startActivity(intent);
               // Toast.makeText(getActivity(), "点击了第一个fragment的BTN", Toast.LENGTH_SHORT).show();

            }

        });

        btn_mxxz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Image_show_activity.class);
                intent.putExtra("name","mxxz");
                startActivity(intent);
            }
        });

        return view;
//美女
    }

}