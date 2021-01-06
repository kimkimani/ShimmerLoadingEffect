package kim.shimmer.loading.effect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kim.shimmer.loading.effect.Adapter.RecyclerViewAdapter;
import kim.shimmer.loading.effect.Model.Students;

public class MainActivity extends AppCompatActivity {
    private JsonArrayRequest mJsonArrayRequest;
    private RequestQueue mRequestQueue;
    private List<Students> studentsList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ShimmerFrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.RV_student_list);
        mFrameLayout = findViewById(R.id.shimmerLayout);
        RequestJsonData();
    }

    public void RequestJsonData() {
        mJsonArrayRequest = new JsonArrayRequest(
                "https://jsonkeeper.com/b/3JMS", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Students students = new Students();
                        students.setName(jsonObject.getString("name"));
                        students.setDescription(jsonObject.getString("description"));
                        students.setCollege(jsonObject.getString("college"));
                        students.setSpecialization(jsonObject.getString("specialization"));
                        students.setProfile_img(jsonObject.getString("profile_img"));
                        studentsList.add(students);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                SetRecyclerViewAdapter(studentsList);
                mFrameLayout.startShimmer();
                mFrameLayout.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(mJsonArrayRequest);
    }

    public void SetRecyclerViewAdapter(List<Students> list) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void onResume() {
        mFrameLayout.startShimmer();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mFrameLayout.stopShimmer();
        super.onPause();
    }
}