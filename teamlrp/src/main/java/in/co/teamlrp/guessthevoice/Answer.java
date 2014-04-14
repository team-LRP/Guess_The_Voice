package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Answer extends Activity {


    MediaPlayer mPlayer2;

    int a1, b1=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);


        mPlayer2 = MediaPlayer.create(this, R.raw.omg);
        mPlayer2.start();

        TextView answer = (TextView)findViewById(R.id.answer);

        final Intent intent = getIntent();
        a1 = intent.getIntExtra("Cas_value", b1);
        final Intent gameover;

        if(a1==0) {
            answer.setText("Lol, your answer is Wrong!, Game Over");

            gameover = new Intent(this, FinalResult.class);
            startActivity(gameover);
            mPlayer2.stop();

        }
        else {

            answer.setText("OMG, it's Right!"+" You get +10");


        }
        Button cont = (Button)findViewById(R.id.cont);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                mPlayer2.stop();
                startActivity(i);

            }
        });


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.answer, menu);
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
