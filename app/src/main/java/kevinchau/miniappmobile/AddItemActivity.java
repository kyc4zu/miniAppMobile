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

public class AddItemActivity extends AppCompatActivity{
    EditText nameField;
    EditText descField;
    EditText latNum;
    EditText longNum;
    CalendarView calendar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descField = (EditText)findViewById(R.id.descriptionText);
        nameField = (EditText)findViewById(R.id.nameText);
        latNum = (EditText)findViewById(R.id.latText);
        longNum = (EditText)findViewById(R.id.longText);
        calendar = (CalendarView)findViewById(R.id.calendarView);
        super.onCreate(savedInstanceState);
        setTitle("Add New Item");
        setContentView(R.layout.itemactivity_main);

    }
    // Called when you tap the Save New Item Button
    public void saveNewItem(EditText name, EditText desc, EditText lat, EditText lon, CalendarView cal) {
        // Make sure it is a name
        if(nameField.getText().toString() != null && !nameField.getText().toString().equals("")) {
            // Log the action
            Log.d("ListExample", "addContact " + nameField.getText().toString());
            // Make a new contact
            contacts.add(new Contact(nameField.getText().toString(), true));
            // Get the adapter that manages the data set and let it know something new was added
            rvContacts.getAdapter().notifyDataSetChanged();
            // Blank the name field
            nameField.setText("");
        }
    }

}