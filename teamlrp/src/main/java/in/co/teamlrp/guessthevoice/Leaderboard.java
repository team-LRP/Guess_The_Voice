package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.util.ArrayList;


public class Leaderboard extends Activity {


    String gamename= "Guess the voice";
    int max=5;
    ArrayList<String> arrayList = new ArrayList<String>();
    ListView listview = (ListView) findViewById(R.id.listView);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        ScoreBoardService scoreBoardService= App42API.buildScoreBoardService();

        scoreBoardService.getTopNRankers(gamename,max, new App42CallBack() {
            public void onSuccess(Object response)
            {
                Game game = (Game)response;
                for(int i = 0;i<game.getScoreList().size();i++)
                {
                    arrayList.add(game.getScoreList().get(i).getUserName()+" "+game.getScoreList().get(i).getValue());

                }
            }
            public void onException(Exception ex)
            {
                System.out.println("Exception Message"+ex.getMessage());
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.leaderboard, menu);
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
