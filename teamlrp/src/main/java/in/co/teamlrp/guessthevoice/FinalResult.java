package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.math.BigDecimal;


public class FinalResult extends Activity {

    String gamename = "Guess the voice";
    BigDecimal score = new BigDecimal(Scoring.Score);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        App42API.initialize(this, "46301e5ea46a6e878160f7548b56b2ef06c4868cd18f2508a33aeabaa619de82", "cbe1369b0fdca4079e6b3458e40a21775ac2ca9a8b72e4460dc53424c2c4c1a9");

        ScoreBoardService scoreBoardService= App42API.buildScoreBoardService();


        scoreBoardService.saveUserScore(gamename,username,score,new App42CallBack() {
            public void onSuccess(Object response)
            {

            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
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
