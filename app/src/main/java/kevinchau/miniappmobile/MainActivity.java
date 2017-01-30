package kevinchau.miniappmobile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("UVa Bucket List");
        setContentView(R.layout.activity_main);
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
