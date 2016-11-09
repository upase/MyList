package com.example.shubhm.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Shubhm on 02-11-2016.
 */


public class MyListFragment extends android.support.v4.app.Fragment {

        static public  String[] topic=new String[100];// = {"Breakfast", "Class Assignment", "Lunch", "Play", "Dinner"};
        static  public  String[] description=new String[100];; //= {"Shahrukh is coming for breakfast!", "Give Mobile computing assignment today", "Lunch with Obama", "A Tennis match with Roger", "Deepika is free today.Take her to dinner"};
        static public int i=0;
   static  MyList s =new MyList();
    static  MyList s2 =new MyList();
    static  MyList s3 =new MyList();
    static int once=0;
    public static ArrayList<MyList> mlist= new ArrayList<>();;
    private RecyclerView mRecyclerView;
    private mylistAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       /* for (int i = 0; i < topic.length; i++) {

            MyList s = new MyList();
            s.setName(topic[i]);
            s.setDescription(description[i]);
            mlist.add(s);

        }*/
    if(once==0) {
        s.setName("Get Up");
        s.setDescription("Have a good jog Tomorrow");
        mlist.add(s);

        s2 = new MyList();
        s2.setName("Have a Breakfast");
        s2.setDescription("It's been long since you had breakfast .Have one today");
        mlist.add(s2);

        s3 = new MyList();
        s3.setName("Get Healthy");
        s3.setDescription("Exercise daily as its important to maintain a good physic");
        mlist.add(s3);
        once=1;
    }
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        // return super.onCreateView(inflater, container, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        mAdapter = new mylistAdapter(mlist);
        mRecyclerView.setAdapter(mAdapter);
    }


 private class MyListHolder extends RecyclerView.ViewHolder {

     private MyList mylist;
     public TextView mTopicTextView;
     public TextView mDescriptionTextView;

     public MyListHolder(View itemView) {
         super(itemView);

         mTopicTextView = (TextView) itemView.findViewById(R.id.textview_title);
         mDescriptionTextView = (TextView) itemView.findViewById(R.id.textview_description);
         itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getActivity(),
                         mylist.getName() + " clicked!", Toast.LENGTH_SHORT)
                         .show();
                 try {

                     for(i=0;i<mlist.size();i++)
                     {
                         MyList l=mlist.get(i);

                         if(l.getName().toString().equals(mylist.getName().toString()))
                         {ScreenSlidePageFragment.mPageNumber=i;break;}
                     }
                     startActivity(new Intent(getActivity(), toscreenslide.class));
                 }
                 catch(Exception e){Toast.makeText(getActivity(),
                         e+ " ", Toast.LENGTH_SHORT)
                         .show();}


             }
         });

     }


     public void bindData(MyList s) {
         mylist = s;

         mTopicTextView.setText(s.getName());
         mDescriptionTextView.setText(s.getDescription());


     }

 }
     private class mylistAdapter extends RecyclerView.Adapter<MyListHolder> {
         private ArrayList<MyList> mlist;

         public mylistAdapter(ArrayList<MyList> m_list) {
             mlist = m_list;

         }

         @Override
         public MyListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
             View view = layoutInflater.inflate(R.layout.category_list_item_1, parent, false);
             return new MyListHolder(view);
         }

         @Override
         public void onBindViewHolder(MyListHolder holder, int position) {
             MyList s = mlist.get(position);
             holder.bindData(s);
         }

         @Override
         public int getItemCount() {
             return mlist.size();
         }
     }

 }