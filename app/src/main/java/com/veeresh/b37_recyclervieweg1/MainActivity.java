package com.veeresh.b37_recyclervieweg1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //8. go to activity java file declare all variables above myadapter
    EditText et1, et2;
    Button b1;
    RecyclerView rv;
    ArrayList<Movie> al;
    MyAdapter m;
    LinearLayoutManager manager; //extra for recyclerview
    int counter = 1; //for serial numbers

    //11. fill custom adapter code
    //7. go to activity java file, create an inner class MyAdapter
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getLayoutInflater().inflate(R.layout.courses_row, null);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Movie movieObject = al.get(position);
            int sno = movieObject.getSno();
            String actor_name = movieObject.getActor_name();
            String movie_name = movieObject.getMovie_name();
            holder.tv1.setText(""+sno);
            holder.tv2.setText(actor_name);
            holder.tv3.setText(movie_name);
        }
        @Override
        public int getItemCount() {
            return al.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            //define views of row.xml here
            public TextView tv1, tv2, tv3;

            public ViewHolder(View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.textView1);
                tv2 = itemView.findViewById(R.id.textView2);
                tv3 = itemView.findViewById(R.id.textView3);

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //9. go to oncreate() of mainactivity - initialize all variables
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button1);
        rv = (RecyclerView) findViewById(R.id.recyclerView1);
        al = new ArrayList<Movie>();
        m = new MyAdapter();
        //  ~~~establish link between recyclerview & adapter
        rv.setAdapter(m); //---similar as lv.setadapter(m)
        //~~~create layoutmanager
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //~~~establish link between recyclerview & manager
        rv.setLayoutManager(manager);
        //10. button click listener with adding movie objects to arraylist code
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String actor_name = et1.getText().toString().trim();
                String movie_name = et2.getText().toString().trim();
                Movie obj = new Movie(counter++, actor_name, movie_name);
                al.add(obj);
                m.notifyDataSetChanged();
                et1.setText(""); et2.setText("");
                et1.requestFocus();
            }
        });
    }
}
