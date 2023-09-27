package duynt.com.example.ex31lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Legend> legendArrayList;

    LegendAdapter legendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        legendAdapter = new LegendAdapter(this, R.layout.list_row, legendArrayList);
        listView.setAdapter(legendAdapter);
    }

    public void mapping() {
        listView = findViewById(R.id.listView);
        legendArrayList = new ArrayList<>();

        legendArrayList.add(new Legend(R.drawable.pele, R.drawable.brazil,
                "Pele", "October 23, 1940 (age 72)"));
        legendArrayList.add(new Legend(R.drawable.maradona, R.drawable.arg,
                "Diego Maradona", "October 23, 1940 (age 72)"));
        legendArrayList.add(new Legend(R.drawable.johan, R.drawable.holland,
                "Johan Cruyff", "October 23, 1940 (age 72)"));
        legendArrayList.add(new Legend(R.drawable.ronaldo, R.drawable.brazil,
                "Ronaldo De Lima", "October 23, 1940 (age 72)"));
        legendArrayList.add(new Legend(R.drawable.m10, R.drawable.arg,
                "Lionel Messi", "October 23, 1940 (age 72)"));
        legendArrayList.add(new Legend(R.drawable.cr7, R.drawable.arg,
                "Cristiano Ronaldo", "October 23, 1940 (age 72)"));


    }

}