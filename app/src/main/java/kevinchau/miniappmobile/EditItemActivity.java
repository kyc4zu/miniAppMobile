package kevinchau.miniappmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

//test
public class EditItemActivity extends AppCompatActivity implements Serializable {
    BucketItem item;
    EditText nameField;
    EditText descField;
    EditText latNum;
    EditText longNum;
    CalendarView calendar;
    Button save;
    String calDate;
    BucketItem holder;
    int loc;
    long dateOld;
    //Creates objects for all the items in the layout
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Edit New Item");
        //sets layout view to the proper screen, and instantiates objects.
        setContentView(R.layout.itemactivity_main);
        save = (Button)findViewById(R.id.saveNewItemButton);
        descField = (EditText)findViewById(R.id.descriptionText);
        nameField = (EditText)findViewById(R.id.nameText);
        latNum = (EditText)findViewById(R.id.latText);
        longNum = (EditText)findViewById(R.id.longText);
        calendar = (CalendarView)findViewById(R.id.calendarView);

        holder = (BucketItem) getIntent().getSerializableExtra("bucketItem");
        loc =  getIntent().getIntExtra("aLocation", 0);
        descField.setText(holder.getDesc());
        nameField.setText(holder.getName());
        latNum.setText(String.valueOf(holder.getLat()));
        longNum.setText(String.valueOf(holder.getLong()));

        String date = holder.getDate();
        String parts[] = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        //Toast.makeText(this, "" + year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
        TimeZone utc = TimeZone.getTimeZone("America/New_York");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, month - 1, day);

        long milliTime = calendar1.getTimeInMillis();
        calendar.setDate (milliTime, true, true);
        calDate = holder.getDate();

        //Write this to set the given bucket item to the new values using setters
        //Then after setting up setters, pass object back and notify changes on recycler.
        // then set up rotate.

    save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String value= latNum.getText().toString();
                double latVal =Double.parseDouble(value);
                String value2 = longNum.getText().toString();
                double lonVal =Double.parseDouble(value2);
                //turns  lat/lon values to integers
                item = new BucketItem(nameField.getText().toString(), descField.getText().toString(), latVal, lonVal, calDate);

                int resultCode = RESULT_OK;
                Intent addItemIntent = new Intent(EditItemActivity.this, BucketListActivity.class);
                addItemIntent.putExtra( "changedItem" , item);
                addItemIntent.putExtra("location", loc);
                setResult(resultCode, addItemIntent);
                finish();

            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                int correctMonth = month + 1;
                calDate = String.valueOf(year + "-" + correctMonth + "-" + dayOfMonth);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}