package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.math.BigDecimal;


public class FinalResult extends Activity {

    String gamename = "Guess the voice";

    BigDecimal score = new BigDecimal(Scoring.Score);


    String username = Scoring.username;

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        ScoreBoardService scoreBoardService= App42API.buildScoreBoardService();
       // txt = (TextView)findViewById(R.id.textView);
        Toast.makeText(getBaseContext(),"Congratulations " + Scoring.username + " your score is " + Scoring.Score, Toast.LENGTH_SHORT).show();
        //txt.setText(Scoring.Score);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });



        scoreBoardService.saveUserScore(gamename, username, BigDecimal.valueOf(Scoring.Score), new App42CallBack() {

            public void onSuccess(Object response) {

            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.final_result, menu);
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
