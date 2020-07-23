package com.example.firstapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listView;
    private List<String> list= new ArrayList<>();
    private MyAdapter adapter;

    private ListView Lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lv = (ListView) findViewById(R.id.list_view);

        final String[] name = new String[] { "火影忍者第一集剧情", "火影忍者第二集剧情", "火影忍者第三集剧情" };
        final String[] message = new String[] {
                "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。",
                "木叶村每一代的首领被称为“火影”，只有忍者中实力最强者才能拥有此殊荣。“猿飞”正是现在的第三代火影，他有个孙子叫做“木叶丸”。好不容易才从忍者学校毕业的鸣人刚从学校拿到忍者证书，就遇到了木叶丸。木叶丸开口就叫鸣人“老大”，而且一直跟随在鸣人身后。这是因为，只有鸣人没有把他当做“火影的孙子”来特别对待，而木叶丸的目标就是要成为受人尊敬的“火影”……",
                "鸣人终于成为忍者啦，因为任务需要，鸣人必须同另外两个人组成三人一组的小队。与他分到同组的是同班的“宇智波佐助”及“春野樱”。鸣人非常喜欢可爱的小樱，可是小樱却暗恋着佐助。更糟糕的是，比起鸣人，佐助不但帅气而且是实力拔群的优等生。于是，郁闷的鸣人为了接近小樱，又想出了一个鬼主意…"
                   };
                final int[] photo = new int[] { R.drawable.p1, R.drawable.p2, R.drawable.p3 };
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.p1);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.p2);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.p3);
        map3.put("name", name[2]);
        data.add(map3);

        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.item_text,new String[] { "photo", "name" }, new int[] { R.id.imageView,R.id.textView }));
        Lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("message", message[arg2]);
                bundle.putString("name", name[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, Activity_1.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(R.id.list_view);

        list.add(" 火影忍者第一集剧情");
        list.add(" 火影忍者第二集剧情");
        list.add(" 火影忍者第三集剧情");


        adapter = new MyAdapter(MainActivity.this, list,photo);
        listView.setAdapter(adapter);

        adapter.setOnItemDeleteClickListener(new MyAdapter.onItemDeleteListener() {
            @Override
            public void onDeleteClick(int i) {
                list.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
