package duynt.com.example.ex3lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFruit;
    ArrayList<Fruit> fruitArrayList;
    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        fruitAdapter = new FruitAdapter(this, R.layout.list_row, fruitArrayList);
        lvFruit.setAdapter(fruitAdapter);
    }

    private void mapping(){
        lvFruit=(ListView) findViewById(R.id.listView);
        fruitArrayList = new ArrayList<>();
        fruitArrayList.add(new Fruit("Avocado",
                "Avocado description", R.drawable.avocado ));

        fruitArrayList.add(new Fruit("Orange",
                "Orange description", R.drawable.cam ));

        fruitArrayList.add(new Fruit("Kiwi",
                "Kiwi description", R.drawable.kiwi ));

        fruitArrayList.add(new Fruit("Pineapple",
                "Pineapple description", R.drawable.pineapple ));

        fruitArrayList.add(new Fruit("Strawberry",
                "Strawberry description", R.drawable.strawberry ));
    }
}