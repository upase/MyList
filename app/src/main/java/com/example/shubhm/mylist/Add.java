package com.example.shubhm.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Add extends AppCompatActivity {
    TextView mtextTopic,mtextDesc;
    Button addbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mtextTopic=(TextView) findViewById(R.id.Topictext);
        mtextDesc=(TextView) findViewById(R.id.Descriptiontext);
        addbutton=(Button) findViewById(R.id.addbutton);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(mtextTopic.getText().toString()))
                {

                    mtextTopic.setError("This Field can't be Empty");
                    return;
                }
                if(TextUtils.isEmpty(mtextDesc.getText().toString()))
                {

                    mtextDesc.setError("This Field can't be Empty");
                    return;
                }
                MyList s = new MyList();
                MyListFragment.topic[MyListFragment.i]=mtextTopic.getText().toString();
                MyListFragment.description[MyListFragment.i]=mtextDesc.getText().toString();
                MyListFragment.i++;
                s.setName(mtextTopic.getText().toString());
                s.setDescription(mtextDesc.getText().toString());
                MyListFragment.mlist.add(s);
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(this, MainActivity.class));

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish();

                startActivity(i);

            }
        });
    }



}
