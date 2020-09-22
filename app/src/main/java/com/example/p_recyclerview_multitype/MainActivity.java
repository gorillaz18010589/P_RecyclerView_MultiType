package com.example.p_recyclerview_multitype;
//1.API     implementation 'me.drakeet.multitype:multitype:3.4.4'
//2.創建bean
//3.
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView1,recyclerView2;
    private MultiTypeAdapter multiTypeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setMultiTypeAdapter();
    }

    private void init() {
        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView2 = findViewById(R.id.recyclerView2);
    }

    private void setMultiTypeAdapter(){
        Items items = new Items();
        items.add(new Student("王大明","18"));
//        items.add(new Dog("哈士奇","2"));
        multiTypeAdapter = new MultiTypeAdapter(items);
        multiTypeAdapter.register(Student.class,new StudentProvider());
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(multiTypeAdapter);
    }
}