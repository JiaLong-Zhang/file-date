package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DemoAdapter adpter;
    final String[] titles = new String[] { "火影忍者第一集剧情", "火影忍者第二集剧情", "火影忍者第三集剧情", "火影忍者第四集剧情", "火影忍者第五集剧情", "火影忍者第六集剧情" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        final GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);
        adpter = new DemoAdapter(this);
        initData();
        recyclerView.setAdapter(adpter);


    }

    private void initData() {


        List<ActivityOneClass> list1 = new ArrayList<>();
        List<ActivityTwoClass> list2 = new ArrayList<>();
        List<ActivityThreeClass> list3 = new ArrayList<>();


        ActivityOneClass one = new ActivityOneClass("火影忍者第一集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。",R.drawable.p3);
        list1.add(one);

        ActivityTwoClass two = new ActivityTwoClass("火影忍者第一集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。");
        list2.add(two);

        ActivityThreeClass three = new ActivityThreeClass("火影忍者第er集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。","https://txmov2.a.yximgs.com/upic/2017/06/22/23/BMjAxNzA2MjIyMzEyMThfNzAyMzQ4Ml8yNDU3OTA1MjA1XzJfMw==_b.mp4");
        list3.add(three);

        adpter.addList_ONE(list1);
        adpter.addList_TWO(list2);
        adpter.addList_THREE(list3);
        adpter.notifyDataSetChanged();
    }

}
