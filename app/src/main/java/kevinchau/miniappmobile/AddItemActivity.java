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
import android.content.Intent;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;

import static android.R.attr.name;

public class AddItemActivity extends AppCompatActivity implements Serializable {
    BucketItem item;
    EditText nameField;
    EditText descField;
    EditText latNum;
    EditText longNum;
    CalendarView calendar;
    Button save;
    long calDate;
    //Creates objects for all the items in the layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add New Item");
        //sets layout view to the proper screen, and instantiates objects.
        setContentView(R.layout.itemactivity_main);
        save = (Button)findViewById(R.id.saveNewItemButton);
        save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                descField = (EditText)findViewById(R.id.descriptionText);
                nameField = (EditText)findViewById(R.id.nameText);
                latNum = (EditText)findViewById(R.id.latText);
                longNum = (EditText)findViewById(R.id.longText);
                calendar = (CalendarView)findViewById(R.id.calendarView);
                calDate = calendar.getDate(); // fix this so that date is fixed right now it just gets current. see website pages
                String value= latNum.getText().toString();
                int latVal =Integer.parseInt(value);
                String value2 = longNum.getText().toString();
                int lonVal =Integer.parseInt(value2);
                //turns calendar date and lat/lon values to integers/long
                item = new BucketItem(nameField.getText().toString(), descField.getText().toString(), latVal, lonVal, calDate);

                int resultCode = RESULT_OK;
                Intent addItemIntent = new Intent(AddItemActivity.this, MainActivity.class);
                addItemIntent.putExtra( "i" , item);
                setResult(resultCode, addItemIntent);
                finish();

            }
        });


    }

    //@Override
    //public void onBackPressed() {
        //Intent intent = new Intent();
        //intent.putExtra("no", 1);
        //setResult(RESULT_CANCELED, intent);
       // super.onBackPressed();

    //}
    }