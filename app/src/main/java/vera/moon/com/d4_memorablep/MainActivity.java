package vera.moon.com.d4_memorablep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;

    static ArrayList<String> lugares;
    static ArrayAdapter adapter;

    static ArrayList<LatLng> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listView);
        lugares = new ArrayList<>();
        lugares.add("Add a place");

        locations = new ArrayList<>();
        locations.add(new LatLng(0,0));


        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lugares);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent in = new Intent(getApplicationContext(),MapsActivity.class);
                in.putExtra("location",(i));
                startActivity(in);
            }
        });
    }
}
