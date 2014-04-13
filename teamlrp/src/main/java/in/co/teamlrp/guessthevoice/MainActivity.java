package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shephertz.app42.paas.sdk.android.App42API;


public class MainActivity extends Activity {




   Button button ;
    Button leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App42API.initialize(this, "46301e5ea46a6e878160f7548b56b2ef06c4868cd18f2508a33aeabaa619de82", "cbe1369b0fdca4079e6b3458e40a21775ac2ca9a8b72e4460dc53424c2c4c1a9");

        EditText usrnm = (EditText) findViewById(R.id.username);
        Scoring.username = String.valueOf(usrnm.getText());

        // MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.letsgetstarted);
        //mPlayer.start();

        button = (Button) findViewById(R.id.singleplayerbutton);
        leaderboard = (Button) findViewById(R.id.leaderboardbutton);

        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //delay in ms
                //int DELAY = 1700;

                //Handler handler = new Handler();
                //handler.postDelayed(new Runnable() {
                // @Override
                //  public void run() {
                Intent intent = new Intent(MainActivity.this, Leaderboard.class);
                startActivity(intent);
                //    }
                //  }, DELAY);
            }


        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //delay in ms
                //int DELAY = 1700;

                //Handler handler = new Handler();
                //handler.postDelayed(new Runnable() {
                // @Override
                //  public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                //    }
                //  }, DELAY);
            }


        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
