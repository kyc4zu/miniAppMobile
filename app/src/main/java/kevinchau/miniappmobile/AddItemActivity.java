package kevinchau.miniappmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//test
public class AddItemActivity extends AppCompatActivity implements Serializable {
    BucketItem item;
    EditText nameField;
    EditText descField;
    EditText latNum;
    EditText longNum;
    CalendarView calendar;
    Button save;
    String calDate;
    long dateOld;
    //Creates objects for all the items in the layout
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle("Add New Item");
        //sets layout view to the proper screen, and instantiates objects.
        setContentView(R.layout.itemactivity_main);
        save = (Button)findViewById(R.id.saveNewItemButton);
        descField = (EditText)findViewById(R.id.descriptionText);
        nameField = (EditText)findViewById(R.id.nameText);
        latNum = (EditText)findViewById(R.id.latText);
        longNum = (EditText)findViewById(R.id.longText);
        calendar = (CalendarView)findViewById(R.id.calendarView);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calDate = df.format(c.getTime());
        save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String value= latNum.getText().toString();
                Double latVal = Double.parseDouble(value);
                String value2 = longNum.getText().toString();
                Double lonVal = Double.parseDouble(value2);
                //turns  lat/lon values to integers
                item = new BucketItem(nameField.getText().toString(), descField.getText().toString(), latVal, lonVal, calDate);

                int resultCode = RESULT_OK;
                Intent addItemIntent = new Intent(AddItemActivity.this, BucketListActivity.class);
                addItemIntent.putExtra( "i" , item);
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