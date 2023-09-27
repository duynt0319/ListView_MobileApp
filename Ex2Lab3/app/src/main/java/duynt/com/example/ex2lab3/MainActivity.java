package duynt.com.example.ex2lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> itemList = new ArrayList<>();
    ArrayList<Integer> selectedItems = new ArrayList<>();
    String message;
    Integer indexValue;


    private String[] sampleData = {"Android", "PHP", "IOS", "Unity", "ASP.Net"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);
        Button addButton = findViewById(R.id.button4);
        Button editButton = findViewById(R.id.button5);
        Button deleteButton = findViewById(R.id.button6);

        for (String item : sampleData) {
            itemList.add(item);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                indexValue = position;
                editText.setText(adapterView.getItemAtPosition(position).toString());
                message = adapterView.getItemAtPosition(position).toString() + " has been selected";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
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
                if (indexValue != null) {
                    if (indexValue >= 0 && indexValue < itemList.size()) {
                        itemList.remove(indexValue.intValue());
                        adapter.notifyDataSetChanged();
                        Toast.makeText(
                                MainActivity.this, "Deleted success", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                        indexValue = null;
                    } else {
                        Toast.makeText(
                                MainActivity.this, "Invalid item index", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(
                            MainActivity.this, "No item selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}