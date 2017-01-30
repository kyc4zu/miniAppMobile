package kevinchau.miniappmobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BucketItem> bucketlist;
    RecyclerView rvBucket;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("UVa Bucket List");
        setContentView(R.layout.activity_main);
        rvBucket = (RecyclerView) findViewById(R.id.rvBucket);


        // Initialize bucket list
        bucketlist = BucketItem.createBucketList(10);

        // Create adapter passing in the sample user data
        BucketAdapter adapter = new BucketAdapter(this, bucketlist);

        // Attach the adapter to the recyclerview to populate items
        rvBucket.setAdapter(adapter);

        // Set layout manager to position the items
        rvBucket.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton GoToNewActivity;
        GoToNewActivity = (FloatingActionButton)findViewById(R.id.FAB);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);

            }
        });
    }
}
