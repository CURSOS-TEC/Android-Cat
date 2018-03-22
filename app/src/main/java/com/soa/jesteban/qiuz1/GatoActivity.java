package com.soa.jesteban.qiuz1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GatoActivity extends AppCompatActivity {

    private Button button_1_1 = null;
    Button button_1_2 = null;
    Button button_1_3 = null;
    Button button_2_1 = null;
    Button button_2_2 = null;
    Button button_2_3 = null;
    Button button_3_1 = null;
    Button button_3_2 = null;
    Button button_3_3 = null;

    String label_1_1 = "";
    String label_1_2 = "";
    String label_1_3 = "";
    String label_2_1 = "";
    String label_2_2 = "";
    String label_2_3 = "";
    String label_3_1 = "";
    String label_3_2 = "";
    String label_3_3 = "";

    Boolean x_used = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);


        this.button_1_1 = (Button) findViewById(R.id.number_1_1);
        button_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_1_1);
            }
        });


        this.button_1_2 = (Button) findViewById(R.id.number_1_2);
        button_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_1_2);
            }
        });


        this.button_1_3 = (Button) findViewById(R.id.number_1_3);
        button_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_1_3);
            }
        });


        this.button_2_1 = (Button) findViewById(R.id.number_2_1);
        button_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_2_1);
            }
        });


        this.button_2_2 = (Button) findViewById(R.id.number_2_2);
        button_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_2_2);
            }
        });


        this.button_2_3 = (Button) findViewById(R.id.number_2_3);
        button_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_2_3);
            }
        });




        this.button_3_1 = (Button) findViewById(R.id.number_3_1);
        button_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_3_1);
            }
        });


        this.button_3_2 = (Button) findViewById(R.id.number_3_2);
        button_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_3_2);
            }
        });


        this.button_3_3 = (Button) findViewById(R.id.number_3_3);
        button_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(button_3_3);
            }
        });

    }

    public void setValue (Button btn){
        if (this.x_used){
            btn.setText("O");
        }
        else {
            btn.setText("X");
        }
        this.x_used = !this.x_used;
        this.evaluate();
    }


    /**
     * Show a message using a toast alert
     * @param  data the message to show
     */
    public void showMessage (String data){
        CharSequence winner = "";
        if (this.x_used){
            winner = "X";
        }
        else {
            winner = "O";
        }
        Context context = getApplicationContext();
        CharSequence text = data.concat(" ").concat(winner.toString());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        this.finish();
    }

    public void evaluate(){
        this.label_1_1 = this.button_1_1.getText().toString();
        this.label_1_2 = this.button_1_2.getText().toString();
        this.label_1_3 = this.button_1_3.getText().toString();

        this.label_2_1 = this.button_2_1.getText().toString();
        this.label_2_2 = this.button_2_2.getText().toString();
        this.label_2_3 = this.button_2_3.getText().toString();

        this.label_3_1 = this.button_3_1.getText().toString();
        this.label_3_2 = this.button_3_2.getText().toString();
        this.label_3_3 = this.button_3_3.getText().toString();


        //check horizontal
        if(this.label_1_1.equals(this.label_1_2) && this.label_1_2.equals(this.label_1_3)){
            showMessage("Win");
        }
        else if(this.label_2_1.equals(this.label_2_2) && this.label_2_2.equals(this.label_2_3)){
            showMessage("Win");
        }
        else if(this.label_3_1.equals(this.label_3_2) && this.label_3_2.equals(this.label_3_3)){
            showMessage("Win");
        }

        //check vertical

        else if(this.label_1_1.equals(this.label_2_1) && this.label_2_1.equals(this.label_3_1)){
            showMessage("Win");
        }
        else if(this.label_1_2.equals(this.label_2_2) && this.label_2_2.equals(this.label_3_2)){
            showMessage("Win");
        }
        else if(this.label_1_3.equals(this.label_2_3 )&& this.label_2_3.equals(this.label_3_3)){
            showMessage("Win");
        }
        //check diagonal
        else if(this.label_1_1.equals(this.label_2_2) && this.label_2_2.equals(this.label_3_3)){
            showMessage("Win");
        }
        else if(this.label_3_1.equals(this.label_2_2) && this.label_2_2.equals(this.label_1_3)){
            showMessage("Win");
        }
        else {
            //showMessage("fail");
        }
    }
}
