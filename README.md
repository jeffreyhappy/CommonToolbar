### CommonToolbar
####用Relative定义了个toolbar

####预览
![screen.png](https://github.com/jeffreyhappy/CommonToolbar/blob/master/device-2017-02-16-211759.png)


####使用
```
<com.jeffrey.commontoolbar.CommonToolbar
    android:id="@+id/toolbar_menu"
    app:leftImg="@drawable/ic_arrow_back_white_24dp"
    app:title="@string/app_title"
    android:layout_marginTop="10dp"
    android:background="@android:color/holo_red_dark"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"/>
```

#####所有属性
```
<resources>
    <declare-styleable name="CommonToolbar">
        <attr name="showDefaultBack" format="boolean"/>        //是否显示默认返回按钮
        <attr name="leftImg" format="reference"/>              //左边的图片
        <attr name="leftText" format="string"/>                //左边的文字
        <attr name="leftTextSize" format="dimension"/>         //左边的文字大小
        <attr name="leftTextColor" format="color"/>             //左边的文字颜色

        <attr name="title" format="string"/>                    //标题
        <attr name="titleSize" format="dimension"/>             //标题大小
        <attr name="titleColor" format="color"/>                //标题颜色


        <attr name="menuTextSize" format="dimension"/>          //菜单文字大小
        <attr name="menuTextColor" format="color"/>             //菜单文字颜色
    </declare-styleable>
</resources>
```
#####也可以代码设置
```
CommonToolbar commonToolbar = (CommonToolbar) findViewById(R.id.toolbar_left);
commonToolbar.setLeftText("左边");
commonToolbar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了左边", Toast.LENGTH_SHORT).show();
            }
        });
```
* 设置标题
```
commonToolbar.setTitle("标题哈");
```
* 添加菜单
```
 ArrayList<CommonToolbar.RightMenu> menus = new ArrayList<>();
 CommonToolbar.RightMenu menu1 = new CommonToolbar.TextRightMenu(1,"菜单1");//文字菜单
 CommonToolbar.RightMenu menu2 = new CommonToolbar.ImageRightMenu(2,R.drawable.icon_share_blue);//图片菜单
 menus.add(menu1);
 menus.add(menu2);
 commonToolbar.setRightMenu(menus);
 //添加菜单点击监听
 commonToolbar.setOnMenuClickListener(new OnMenuClickListener() {
            @Override
            public void onClick(int id, View view) {
                Toast.makeText(MainActivity.this, "id = " + id, Toast.LENGTH_SHORT).show();
            }
        });
```

* 添加自定义菜单
```
//子需要实现RightMenu的getView就可以了
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
```
