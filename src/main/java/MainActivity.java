package com.example.maurya.stonepaper;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock,b_paper,b_scissors;
    TextView tv_score;
    ImageView iv_ComputerChoice,iv_HumanChoice;

    int HumanScore =0, ComputerScore =0;

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_paper = (Button)findViewById(R.id.b_paper);
        b_scissors = (Button)findViewById(R.id.b_scissors );
        b_rock = (Button)findViewById(R.id.b_rock);

        iv_ComputerChoice = (ImageView)findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice = (ImageView)findViewById(R.id.iv_HumanChoice);

        tv_score = (TextView)findViewById(R.id.tv_score);

        b_rock.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                score();
                tv_score.setText("Score: Human ="+Integer.toString(HumanScore)+"Computer ="+Integer.toString(ComputerScore));

            }

        });

        b_paper.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message =  play_turn("paper");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                score();
                tv_score.setText("Score: Human ="+Integer.toString(HumanScore)+"Computer ="+Integer.toString(ComputerScore));
            }


        });
        b_scissors.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                iv_HumanChoice.setImageResource(R.drawable.scissors);
               String message= play_turn("scissors");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                score();
                tv_score.setText("Score: Human ="+Integer.toString(HumanScore)+"Computer ="+Integer.toString(ComputerScore));

            }
        });

    }
    public String play_turn(String player_choice){
            String computerchoice = "";
            Random r = new Random();

            int computer_choice_number = r.nextInt(3)+1;

            if(computer_choice_number == 1){
                computerchoice = "rock";
            }else if(computer_choice_number == 2){
                computerchoice = "scissors";
            }else if(computer_choice_number == 3){
                computerchoice = "paper";
            }

            //set computer image based on  his choice
            if(computerchoice == "rock"){
                iv_ComputerChoice.setImageResource(R.drawable.rock);
            }else if(computerchoice == "scissors"){
                iv_ComputerChoice.setImageResource(R.drawable.scissors);
            }else if(computerchoice == "paper"){
                iv_ComputerChoice.setImageResource(R.drawable.paper);
            }

            //Determine who won
            if(computerchoice == player_choice){
                return "Draw Nobody Won..";
            }else if(player_choice == "rock" && computerchoice == "scissors"){
                HumanScore++;
                return "Rock crushes scissor. You win!!";
            }else if(player_choice == "rock" && computerchoice == "paper"){
                ComputerScore++;
                return "Paper covers rock. Computer win!!";
            }else if(player_choice == "scissors" && computerchoice == "rock"){
                ComputerScore++;
                return "Rock crushes Scissor. Computer win!!";
            }else if(player_choice == "scissors" && computerchoice == "paper"){
                HumanScore++;
                return "Scissor cuts paper. you win!!";
            }else if(player_choice == "paper" && computerchoice == "rock"){
                HumanScore++;
                return "Paper covers rock. You win!!";
            }else if(player_choice == "paper" && computerchoice == "scissors") {
                ComputerScore++;
                return "Scissor cuts paper. Computer win!!";
            }
            else
                return "Not Sure";




}
    public void score(){
        
     if(HumanScore == 5){
            new AlertDialog.Builder(this)
                    .setMessage("You Win!!!!!")
                   // .setCancelable(false)
                   // .setPositiveButton("Exist", new DialogInterface.OnClickListener() {
                   //     public void onClick(DialogInterface dialog, int id) {
                    //        MainActivity.this.finish();
                   //     }
                 //   })
                    .setNegativeButton("Play Again", null)
                    .show();
                    ComputerScore = 0;
                     HumanScore = 0;
           // String message= play_turn("scissors");
           // Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            tv_score.setText("Score: Human =0  Computer =0");

        }else if(ComputerScore == 5){
            new AlertDialog.Builder(this)
                    .setMessage("You Lose!!!!!")
                 //   .setCancelable(false)
                   // .setPositiveButton("Exist", new DialogInterface.OnClickListener() {
                 //       public void onClick(DialogInterface dialog, int id) {
                 //           MainActivity.this.finish();
                //        }
               //     })
                    .setNegativeButton("Play Again", null)
                    .show();
            ComputerScore = 0;
            HumanScore = 0;
         //   String message= play_turn("scissors");
          //  Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            tv_score.setText("Score: Human =0  Computer =0");
        }
      
    }
    

}
