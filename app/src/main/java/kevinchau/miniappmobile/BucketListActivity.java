package kevinchau.miniappmobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import static kevinchau.miniappmobile.BucketItem.sort;

public class BucketListActivity extends AppCompatActivity implements Serializable {

    ArrayList<BucketItem> bucketlist;
    RecyclerView rvBucket;
    static final int requestCodeAdd = 1;
    static final int requestCodeEdit = 2;

    //Request code for intent
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("UVa Bucket List");
        setContentView(R.layout.activity_main);
        rvBucket = (RecyclerView) findViewById(R.id.rvBucket);


        // Initialize bucket list
        bucketlist = BucketItem.CreateInitialBucketList(4);

        // Create adapter passing in the sample user data

        rvBucket.setAdapter(new BucketListAdapter(this, bucketlist, new BucketListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BucketItem item) {
                Intent addItemIntent = new Intent(BucketListActivity.this, EditItemActivity.class);
                addItemIntent.putExtra("bucketItem", item);
                addItemIntent.putExtra("aLocation", bucketlist.indexOf(item));
                startActivityForResult(addItemIntent, requestCodeEdit);
            }
        }));


        // Set layout manager to position the items
        rvBucket.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton GoToNewActivity;
        GoToNewActivity = (FloatingActionButton) findViewById(R.id.FAB);

        GoToNewActivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent addItemIntent = new Intent(BucketListActivity.this, AddItemActivity.class);
                startActivityForResult(addItemIntent, requestCodeAdd);

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

                BucketItem item = (BucketItem) result.getExtras().getSerializable("i");
                bucketlist.add(item);
                rvBucket.getAdapter().notifyDataSetChanged();
            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {

                BucketItem item = (BucketItem) result.getExtras().getSerializable("changedItem");
                int locat = result.getExtras().getInt("location");
                bucketlist.set(locat, item);
                rvBucket.getAdapter().notifyDataSetChanged();
            }
            if (resultCode == RESULT_CANCELED) {
                //do nothing

            }
        }

    }
    protected void reorder(View v){
        boolean checked = ((CheckBox) v).isChecked();

        if (checked) {

            // determine related object
            View item = findViewById(R.id.bucket_name);
            String name = ((TextView) item).getText().toString();

            BucketItem me = find(name, bucketlist);

            me.setChecked(true);

            boolean check = me.getChecked();

            // test
            Toast toast = Toast.makeText(getApplicationContext(), "" + check, Toast.LENGTH_SHORT);
            toast.show();

            rvBucket.getAdapter().notifyDataSetChanged();
        }

        else {

            // determine related object
            View item = findViewById(R.id.bucket_name);
            String name = ((TextView) item).getText().toString();

            BucketItem me = find(name, bucketlist);

            me.setChecked(false);

            boolean check = me.getChecked();

            // test
            Toast toast = Toast.makeText(getApplicationContext(), "" + check, Toast.LENGTH_SHORT);
            toast.show();

            sort(bucketlist);
            rvBucket.getAdapter().notifyDataSetChanged();
        }

    }
    public static BucketItem find(String name, ArrayList <BucketItem> bucketlist){

        int length = bucketlist.size();
        for(int i = 0; i < length; i++){
            if(bucketlist.get(i).getName().equals(name)){
                return bucketlist.get(i);
            }
        }

        return null;
    }
}
