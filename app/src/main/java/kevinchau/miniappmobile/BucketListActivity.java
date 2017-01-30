package kevinchau.miniappmobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class BucketListActivity extends AppCompatActivity implements Serializable{

    ArrayList<BucketItem> bucketlist;
    RecyclerView rvBucket;
    static final int requestCode = 1;
    //Request code for intent
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("UVa Bucket List");
        setContentView(R.layout.activity_main);
        rvBucket = (RecyclerView) findViewById(R.id.rvBucket);


        // Initialize bucket list
        bucketlist = BucketItem.CreateInitialBucketList(4);

        // Create adapter passing in the sample user data
        BucketListAdapter adapter = new BucketListAdapter(this, bucketlist);

        // Attach the adapter to the recyclerview to populate items
        rvBucket.setAdapter(adapter);

        // Set layout manager to position the items
        rvBucket.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton GoToNewActivity;
        GoToNewActivity = (FloatingActionButton)findViewById(R.id.FAB);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                    Intent addItemIntent = new Intent(BucketListActivity.this, AddItemActivity.class);
                    startActivityForResult(addItemIntent, requestCode);

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                BucketItem item =(BucketItem) result.getExtras().getSerializable("i");
                bucketlist.add(item); //not returning an actual object why?
                rvBucket.getAdapter().notifyDataSetChanged();
            }
        }
    }

}
