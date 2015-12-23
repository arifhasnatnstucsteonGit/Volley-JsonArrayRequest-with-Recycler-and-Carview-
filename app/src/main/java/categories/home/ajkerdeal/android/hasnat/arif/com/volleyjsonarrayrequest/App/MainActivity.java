package categories.home.ajkerdeal.android.hasnat.arif.com.volleyjsonarrayrequest.App;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import categories.home.ajkerdeal.android.hasnat.arif.com.volleyjsonarrayrequest.R;

public class MainActivity extends AppCompatActivity {

    public static final String url="http://api.androidhive.info/volley/person_array.json";
    private static String TAG = MainActivity.class.getSimpleName();
    private static String TAG1 = MainActivity.class.getPackage().getName();

    public String JsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, TAG1, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void makeArrayRequest(){
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonResponse="";
                        try {

                            for (int i = 0; i <response.length() ; i++) {
                                JSONObject jsonobject= (JSONObject) response.get(i);
                                String name,email,home,mobile;
                                JSONObject phone =jsonobject.getJSONObject("phone");

                                name=jsonobject.getString("name");
                                email=jsonobject.getString("email");

                                //now these two json array are sub form Phone
                                home=phone.getString("home");
                                mobile=phone.getString("mobile");







                            }

                        }catch (Exception e){

                        }








                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
