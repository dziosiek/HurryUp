package com.example.adam.quizgame.database;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private static final Questions ourInstance = new Questions();

    List<Question> questionsList = new ArrayList<>();

    public List<Question> getQuestionsList() {
        return questionsList;
    }


    public static Questions getInstance() {
        return ourInstance;
    }

    private Questions() {
    }


    public void createDatabase(final Context context, String URL){
        RequestQueue queue = Volley.newRequestQueue(context);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray questionsArrayJSON = new JSONArray(jsonObject.getString("records"));

                            for (int i = 0; i < questionsArrayJSON.length(); i++) {
                                jsonObject = questionsArrayJSON.getJSONObject(i);
//                                jsonObject.getInt("id");
                                Question question = new Question(
                                        jsonObject.getString("question"),
                                        jsonObject.getInt("id"),
                                        jsonObject.getInt("points"),
                                        jsonObject.getString("answerA"),
                                        jsonObject.getString("answerB"),
                                        jsonObject.getString("answerC"),
                                        jsonObject.getString("answerD"),
                                        jsonObject.getString("correctAnswer"));
                                questionsList.add(question);
                            }
                            Toast.makeText(context,questionsList.size()-1+"Questions downloaded",Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}
