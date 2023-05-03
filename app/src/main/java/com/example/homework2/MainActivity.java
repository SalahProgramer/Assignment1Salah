package com.example.homework2;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText editText;
TextView hobbies;
    EditText areatext;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        editText=findViewById(R.id.editTextTextPersonName);
        hobbies=findViewById(R.id.hobbies);
       areatext=findViewById(R.id.MultiLine2);
       String[] hob={"frontend","Gaming","Swimming","Driving"};

areatext.append("\n");
        for(;i<hob.length;i++){
    areatext.append("       "+(i+1)+") "+hob[i]+"\n");


}
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getText().toString().equals("")){

                    hobbies.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,"Error the Hobbies Are empty",Toast.LENGTH_SHORT).show();


                }

                else {

                    hobbies.setEnabled(true);
                    hobbies.setVisibility(View.VISIBLE);
                    hobbies.setText(editText.getText().toString());

                    areatext.append("       "+(i+1)+") "+editText.getText().toString()+"\n");

i++;


                    Toast.makeText(MainActivity.this,editText.getText().toString()+" Was added",Toast.LENGTH_SHORT).show();

                }


            }
        });
        areatext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(view.getId()==R.id.MultiLine2){

                    view.getParent().requestDisallowInterceptTouchEvent(true);

                    switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){

                        case MotionEvent.ACTION_UP: view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }



                return false;
            }
        });


    }
}