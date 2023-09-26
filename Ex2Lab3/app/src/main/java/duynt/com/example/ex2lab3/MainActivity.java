package duynt.com.example.ex2lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> itemList = new ArrayList<>();


    private String[] sampleData = {"Item 1", "Item 2", "Item 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);
        Button addButton = findViewById(R.id.button4);
        Button editButton = findViewById(R.id.button5);
        Button deleteButton = findViewById(R.id.button6);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        for (String item : sampleData) {
            itemList.add(item);
        }
        adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = itemList.get(position);
                editText.setText(selectedItem);
                listView.setItemChecked(position, true);
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString();
                if (!newItem.isEmpty()) {
                    itemList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = listView.getCheckedItemPosition();
                if (position != ListView.INVALID_POSITION) {
                    String editedItem = editText.getText().toString();
                    if (!editedItem.isEmpty()) {
                        itemList.set(position, editedItem);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a new item.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to edit.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = listView.getCheckedItemPosition();
                if (position != ListView.INVALID_POSITION) {
                    itemList.remove(position);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to delete.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}