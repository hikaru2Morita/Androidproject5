package com.example.intentsample;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class MainActivity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
  setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


  BiFunction<String, Object, Map<String, Object>> menuMapGenerator = (name, price) -> {
   Map<String, Object> menu = new HashMap<>();
   menu.put("name", name);
   menu.put("price", price);
   return menu;
  };
  ListView lvMenu = findViewById(R.id.lvMenu);
  List<Map<String, Object>> menuList = new ArrayList<>();
  menuList.add(menuMapGenerator.apply("から揚げ定食", "800円"));
  menuList.add(menuMapGenerator.apply("から揚げ定食", "800円"));
  menuList.add(menuMapGenerator.apply("ハンバーグ定食", "850円"));
  menuList.add(menuMapGenerator.apply("生姜焼き定食", "850円"));
  menuList.add(menuMapGenerator.apply("ステーキ定食", "1000円"));
  menuList.add(menuMapGenerator.apply("野菜炒め定食", "750円"));
  menuList.add(menuMapGenerator.apply("とんかつ定食", "900円"));
  menuList.add(menuMapGenerator.apply("ミンチかつ定食", "850円"));
  menuList.add(menuMapGenerator.apply("チキンカツ定食", "900円"));
  menuList.add(menuMapGenerator.apply("コロッケ定食", "850円"));
  menuList.add(menuMapGenerator.apply("回鍋肉定食", "750円"));
  menuList.add(menuMapGenerator.apply("麻婆豆腐定食", "800円"));
  menuList.add(menuMapGenerator.apply("青椒肉絲定食", "900円"));
  menuList.add(menuMapGenerator.apply("八宝菜定食", "800円"));
  menuList.add(menuMapGenerator.apply("酢豚定食", "700円"));
  menuList.add(menuMapGenerator.apply("豚の角煮定食", "600円"));
  menuList.add(menuMapGenerator.apply("焼き鳥定食", "700円"));
  menuList.add(menuMapGenerator.apply("焼き魚定食", "800円"));
  menuList.add(menuMapGenerator.apply("焼肉定食", "900円"));

  String[] from = {"name", "price"};
  int[] to = {android.R.id.text1, android.R.id.text2};
  SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, android.R.layout.simple_list_item_2, from, to);
  lvMenu.setAdapter(adapter);
  lvMenu.setOnItemClickListener(new ListItemClickListener());
 }


 private class ListItemClickListener implements AdapterView.OnItemClickListener {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
   Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
   String menuName = item.get("name");
   String menuPrice = item.get("price");
   Intent intent =new Intent(MainActivity.this, MenuThanksActivity.class);
   intent.putExtra("menuName", menuName);
   intent.putExtra("menuPrice", menuPrice);
   startActivity(intent);
  }
 }
}
