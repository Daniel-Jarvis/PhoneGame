package com.example.postmortem.LevelSystems;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.postmortem.R;

public class PickUpLevelActivity extends LevelActivity {
    PickUpLevel level;
    Button[] selectButtons;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_level);

        level = new PickUpLevel(1); //TODO temp value to be passed in as extra

        scoreText = findViewById(R.id.score);
        scoreText.setText("0");

        selectButtons = getButtons();
        assignButtonVals(selectButtons);

        updateSearchPrompt();

        startTimer(10);
    }

    private void updateSearchPrompt(){
        TextView searchPrompt = findViewById(R.id.searchPrompt);
        String searchStr = "Find the " + level.getTarget() + "!";
        searchPrompt.setText(searchStr);
    }

    //TODO need to make sure at least one button has a target
    private void assignButtonVals(Button[] selectButtons) {
        String[] selectables = level.getSelectables();
        for(int i = 0; i < selectButtons.length; i++){
            selectButtons[i].setContentDescription(selectables[i]);
            assignButtonImage(selectButtons[i], selectables[i]);
        }
        System.out.println(selectables.toString());
    }

    private void assignButtonImage(Button button, String buttonVal){
        switch(buttonVal){
            case "Deodorant":
                button.setBackgroundResource(R.mipmap.deodorant);
                break;

            case "Laptop":
                button.setBackgroundResource(R.mipmap.laptop_open);
                break;

            case "Phone":
                button.setBackgroundResource(R.mipmap.phone);
                break;

            case "Pencil":
                button.setBackgroundResource(R.mipmap.pencil);
                break;

            case "TCard":
                button.setBackgroundResource(R.mipmap.tcard);
                break;

            case "Wallet":
                button.setBackgroundResource(R.mipmap.wallet);
                break;

            case "Notebook":
                button.setBackgroundResource(R.mipmap.notebook);
                break;

            case "Gym Bag":
                button.setBackgroundResource(R.mipmap.gymbag);
                break;

            case "Glasses":
                button.setBackgroundResource(R.mipmap.glasses);
                break;

            case "Snack":
                button.setBackgroundResource(R.mipmap.tasty_snack);
                break;

            default:
                button.setBackgroundResource(R.drawable.ic_launcher_foreground);
        }
    }

    private Button[] getButtons(){
        Button[] buttons = new Button[6];

        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);

        return buttons;
    }

    public void clickHandler(View target){
        Button clickedButton = (Button) target;
        String clickedVal = (String) clickedButton.getContentDescription();

        boolean correctSelect = level.checkSelectVal(clickedVal);

        if(correctSelect){
            level.increaseScore();
            scoreText.setText(level.getScore() + "");
            assignButtonVals(selectButtons);
            updateSearchPrompt();
        }else{
            //TODO display x on screen and cease checks for indeterminate time
        }

    }

}
