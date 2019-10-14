package www.xyz.uhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    String[] customers = new String[] {
            "customer1","customer2","customer3","customer4","customer5","customer6","customer7","customer8","customer9",
            "customer10",
            "customer11",
            "customer12",
            "customer13",
            "customer14",
            "customer15"

    };

    ListView lvCourses;
    TextView tvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        ArrayList arrayList = new ArrayList(Arrays.asList(customers));
//
//        ListView listView = (ListView) findViewById(R.id.myListView);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1);
//        listView.setAdapter(arrayAdapter);


        lvCourses = findViewById(R.id.lvCourses);
        tvCourse = findViewById(R.id.tvCourse);
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                customers);

        lvCourses.setAdapter(courseAdapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i =new Intent(SecondActivity.this , QRGenerator.class );
                i.putExtra("NAME", customers[position]);
                startActivity(i);

            }
        });




    }
}
