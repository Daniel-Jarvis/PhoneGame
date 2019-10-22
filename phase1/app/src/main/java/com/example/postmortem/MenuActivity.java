package com.example.postmortem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

  private  GameMenu menu_controller;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    Intent intent = getIntent();
    String menu_type = intent.getStringExtra(GameMenu.MENU_TYPE);

    //create the backbone of the menu
    this.menu_controller = GameMenu.createMenu(menu_type);

    //build the menu interface
    ConstraintLayout layout = findViewById(R.id.constrain_layout);
    List<View> items = menu_controller.buildMenuItems(this);
    for(View item: items){
      layout.addView(item);
    }

  }
}
