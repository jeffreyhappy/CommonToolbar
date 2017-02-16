package com.jeffrey.toolbarhelper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jeffrey.commontoolbar.CommonToolbar;
import com.jeffrey.commontoolbar.OnMenuClickListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /********** 左边是文字 ****************/
        CommonToolbar commonToolbar1 = (CommonToolbar) findViewById(R.id.toolbar_left);
        commonToolbar1.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了左边", Toast.LENGTH_SHORT).show();
            }
        });
        commonToolbar1.setLeftText("左边");

        /**********右边显示文字菜单****************/
        CommonToolbar commonToolbar = (CommonToolbar) findViewById(R.id.toolbar_menu);
        commonToolbar.setRightMenu(mockSimpleMenu());
        commonToolbar.setOnMenuClickListener(new OnMenuClickListener() {
            @Override
            public void onClick(int id, View view) {
                Toast.makeText(MainActivity.this, "id = " + id, Toast.LENGTH_SHORT).show();
            }
        });


        /**********右边显示文字和图片菜单****************/
        CommonToolbar commonToolbarMultiMenu = (CommonToolbar) findViewById(R.id.toolbar_menu_multi);
        commonToolbarMultiMenu.setRightMenu(mockMenu2());
        commonToolbarMultiMenu.setOnMenuClickListener(new OnMenuClickListener() {
            @Override
            public void onClick(int id, View view) {
                Toast.makeText(MainActivity.this, "id = " + id, Toast.LENGTH_SHORT).show();
            }
        });


        CommonToolbar commonToolbarMultiMenu2 = (CommonToolbar) findViewById(R.id.toolbar_menu_multi2);
        commonToolbarMultiMenu2.setRightMenu(mockMenu3());
        commonToolbarMultiMenu2.setTitle(null);
        commonToolbarMultiMenu2.setOnMenuClickListener(new OnMenuClickListener() {
            @Override
            public void onClick(int id, View view) {
                Toast.makeText(MainActivity.this, "id = " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }


    ArrayList<CommonToolbar.RightMenu> mockSimpleMenu(){
        ArrayList<CommonToolbar.RightMenu> menus = new ArrayList<>();
        CommonToolbar.RightMenu menu1 = new CommonToolbar.TextRightMenu(1,"菜单1");
        CommonToolbar.RightMenu menu2 = new CommonToolbar.TextRightMenu(2,"菜单2");
        menus.add(menu1);
        menus.add(menu2);
        return menus;
    }

    ArrayList<CommonToolbar.RightMenu> mockMenu2(){
        ArrayList<CommonToolbar.RightMenu> menus = new ArrayList<>();


        CommonToolbar.RightMenu menu1 = new CommonToolbar.TextRightMenu(1,"菜单1");
        CommonToolbar.RightMenu menu2 = new CommonToolbar.ImageRightMenu(2,R.drawable.icon_share_blue);
        menus.add(menu1);
        menus.add(menu2);
        return menus;
    }


    ArrayList<CommonToolbar.RightMenu> mockMenu3(){
        ArrayList<CommonToolbar.RightMenu> menus = new ArrayList<>();


        CommonToolbar.RightMenu menu1 = new CommonToolbar.TextRightMenu(1,"菜单1");
        CommonToolbar.RightMenu menu2 = new CommonToolbar.ImageRightMenu(2,R.drawable.icon_share_blue);
        CommonToolbar.RightMenu menu3 = new CommonToolbar.RightMenu() {
            @Override
            public View getView(Context context) {
                RadioButton radioButton = new RadioButton(context);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "check = " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
                return radioButton;
            }

            @Override
            public int getId() {
                return 3;
            }
        };
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        return menus;
    }


}
