package in.co.teamlrp.guessthevoice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {



    Button butt1 ;
    Button butt2 ;
    Button butt3 ;
    Button butt4 ;
    Context context;
    String option1 ;
    String option2 ;
    String option3 ;
    String option4 ;

    private ButtonClickListener btnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        butt1 = (Button) findViewById(R.id.button1);
        butt1.setOnClickListener(btnClick);

        butt2 = (Button) findViewById(R.id.button2);
        butt2.setOnClickListener(btnClick);

        butt3 = (Button) findViewById(R.id.button3);
        butt3.setOnClickListener(btnClick);

        butt4 = (Button) findViewById(R.id.button4);
        butt4.setOnClickListener(btnClick);

        btnClick= new ButtonClickListener();

        context = this;




        try
        {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray femaleEnglish = object.getJSONArray("femaleEnglish");
            option1 = femaleEnglish.getJSONObject(0).getString("name");
            option2 = femaleEnglish.getJSONObject(1).getString("name");
            option3 = femaleEnglish.getJSONObject(2).getString("name");
            option4 = femaleEnglish.getJSONObject(3).getString("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }



        butt1.setText(option1);
        butt2.setText(option2);
        butt3.setText(option3);
        butt4.setText(option4);

    }

    private class ButtonClickListener implements View.OnClickListener {


        public void onClick(View v) {



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
