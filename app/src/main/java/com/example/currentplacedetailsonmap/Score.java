package com.example.currentplacedetailsonmap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);
        TextView score_showing = findViewById(R.id.score_shown);
        Button stats_button = findViewById(R.id.stats_button);
        TextView comments = findViewById(R.id.comments);
        TextView RSSI = findViewById(R.id.RSSI);
        String RSSI_string = " ";
        for(Short string: DeviceListActivity.RSSI){
            RSSI_string = RSSI_string + " " + string + " ";
        }
        int total_score = DeviceListActivity.distance_score + DeviceListActivity.number_score + HealthSurvey.health_score;
        RSSI.setText(RSSI_string);
        score_showing.setText(Integer.toString(total_score));
        if(total_score < 5){
            score_showing.setTextColor(this.getResources().getColor(R.color.quantum_lightgreen));
            comments.setText("Good job! You have been successful in social distancing! Keep doing what you are doing! ");
        }else if(total_score > 5 && total_score < 10){
            score_showing.setTextColor(this.getResources().getColor(R.color.quantum_yellow));
            comments.setText("Okay job! Stay away from crowded areas in the future!");
        }else if(total_score > 10){
            score_showing.setTextColor(this.getResources().getColor(R.color.quantum_orange));
            comments.setText("Please avoid any crowded areas in the future, as this puts at a large risk!");
        }
        stats_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,MapsActivityCurrentPlace.class));
            }
        });

    }
}
