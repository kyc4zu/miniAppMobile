package kevinchau.miniappmobile;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity{
    ArrayList<BucketItem> bucketlist = new ArrayList<BucketItem>();
    EditText nameField;
    EditText descField;
    EditText latNum;
    EditText longNum;
    CalendarView calendar;
    RecyclerView rvBuckets;
    long calDate;
    //Creates objects for all the items in the layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        descField = (EditText)findViewById(R.id.descriptionText);
        nameField = (EditText)findViewById(R.id.nameText);
        latNum = (EditText)findViewById(R.id.latText);
        longNum = (EditText)findViewById(R.id.longText);
        calendar = (CalendarView)findViewById(R.id.calendarView);
        super.onCreate(savedInstanceState);
        //rvBuckets= (RecyclerView) findViewById(R.id.rvBuckets); <--- look at this
        //look up how to use recycler view on differnt layout/screen.
        setTitle("Add New Item");
        setContentView(R.layout.itemactivity_main);
        //sets layout view to the proper screen, and instantiates objects.
        bucketlist = BucketItem.createBucketList(1);
        //creates bucketlist to add to main screen.
        saveNewItem(nameField, descField, latNum, longNum, calendar);
        //creates bucketitem


    }
    // Called when you tap the Save New Item Button
    public void saveNewItem(EditText name, EditText desc, EditText lat, EditText lon, CalendarView cal) {
        calDate = calendar.getDate();
        String value= lat.getText().toString();
        int latVal =Integer.parseInt(value);
        String value2 = lon.getText().toString();
        int lonVal =Integer.parseInt(value);
        //turns calendar date and lat/lon values to integers/long
        bucketlist.add(new BucketItem(name.toString(), desc.toString(), latVal, lonVal, calDate));
        // Get the adapter that manages the data set and let it know something new was added
        rvBuckets.getAdapter().notifyDataSetChanged();
        }
    }

}