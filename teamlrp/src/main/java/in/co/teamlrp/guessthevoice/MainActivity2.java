package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;



public class MainActivity2 extends Activity {

    Button butt1 ;
    Button butt2 ;
    Button butt3 ;
    Button butt4 ;
    Context context;
    String option1 ;
    String option2 ;
    String option3 ;
    String option4 ;
    TextView display;
    String randomArray;
    String array[] = {"femaleEnglish","maleEnglish","hindi"};

    int right_ans;
    int i=0,j=0,k=0,l=0;

    int cas=0;

    String id="";
    MediaPlayer m;
    String file;
    int arraghav[] = new int[]{R.raw.aamir, R.raw.amitabh, R.raw.bomanirani, R.raw.deepika, R.raw.kajol, R.raw.kapil, R.raw.kareena, R.raw.pareshrawal, R.raw.salman};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Intent intentscore = getIntent();
        //score = intentscore.getIntExtra("Score", score);

        display = (TextView)findViewById(R.id.score);
       display.setText("Your Score is "+Scoring.Score);


        butt1 = (Button) findViewById(R.id.button1);


        butt2 = (Button) findViewById(R.id.button2);


        butt3 = (Button) findViewById(R.id.button3);

        butt4 = (Button) findViewById(R.id.button4);


        context = this;


        Random random = new Random();
        randomArray = array[random.nextInt(3)];

        ArrayList<Integer> arr = new ArrayList<Integer>();


        try {

            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = object.getJSONArray("englishMale");


            i = random.nextInt(8);
            option1 = jsonArray.getJSONObject(i).getString("name");
            j = i;
            i = random.nextInt(8);
            while (i == j) {
                i = random.nextInt(8);
            }
            option2 = jsonArray.getJSONObject(i).getString("name");
            k = i;
            while (i == j || i == k) {
                i = random.nextInt(8);
            }


            option3 = jsonArray.getJSONObject(i).getString("name");
            l = i;
            while (i == j || i == k || i == l) {
                i = random.nextInt(8);
            }
            option4 = jsonArray.getJSONObject(i).getString("name");

            arr.add(i);
            arr.add(j);
            arr.add(k);
            arr.add(l);

            right_ans = arr.get(random.nextInt(4));
              //id = jsonArray.getJSONObject(right_ans).getString("id");
              //file="R.raw."+id;

               m = MediaPlayer.create(this, arraghav[right_ans]);
              m.start();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        butt1.setText(option1);
        butt2.setText(option2);
        butt3.setText(option3);
        butt4.setText(option4);
        butt1.setOnClickListener(new btn1OnClick());
        butt2.setOnClickListener(new btn2OnClick());
        butt3.setOnClickListener(new btn3OnClick());
        butt4.setOnClickListener(new btn4OnClick());


    }

        public class btn1OnClick implements Button.OnClickListener{

            Intent intent;
        @Override
        public void onClick(View view) {
            if (right_ans == j) {
                cas = 1;

              Scoring.Score  = Scoring.Score +10;

            }
            intent = new Intent(getApplicationContext(), Answer.class);
            intent.putExtra("Cas_value", cas);
            m.stop();
            startActivity(intent);


        }
    }
    public class btn2OnClick implements Button.OnClickListener{

        Intent intent;
        @Override
        public void onClick(View view) {
            if (right_ans == k) {
                cas = 1;
                Scoring.Score  = Scoring.Score +10;
            }
            intent = new Intent(getApplicationContext(), Answer.class);
            intent.putExtra("Cas_value", cas);

            startActivity(intent);
              m.stop();
            startActivity(intent);


        }
    }
    public class btn3OnClick implements Button.OnClickListener{

        Intent intent;
        @Override
        public void onClick(View view) {
            if (right_ans == l) {
                cas = 1;

                Scoring.Score  = Scoring.Score +10;
            }
            intent = new Intent(getApplicationContext(), Answer.class);
            intent.putExtra("Cas_value", cas);
           m.stop();
            startActivity(intent);


        }
    }
    public class btn4OnClick implements Button.OnClickListener{

        Intent intent;
        @Override


        public void onClick(View view) {
            if (right_ans == i) {
                cas = 1;


                Scoring.Score  = Scoring.Score +10;
            }
            intent = new Intent(getApplicationContext(), Answer.class);
            intent.putExtra("Cas_value", cas);
           m.stop();

            startActivity(intent);

        }
    }






    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = context.getAssets().open("guess_the_voice.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
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
