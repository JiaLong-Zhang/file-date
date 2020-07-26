package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ActivityOneClass> list1;
    private List<ActivityTwoClass> list2;
    private int sizeOne;
    private int sizeTwo;
    private RecyclerView mRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList1();
        initList2();
        initView();




    }

    protected void initList1() {
        list1 = new ArrayList<>();
        ActivityOneClass one = new ActivityOneClass("火影忍者第一集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。",R.drawable.p3);
        list1.add(one);
    }

    protected void initList2() {
        list2 = new ArrayList<>();
        ActivityTwoClass one = new ActivityTwoClass("火影忍者第一集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了");
        list2.add(one);
    }


    protected void initView() {
        mRv = (RecyclerView) findViewById(R.id.mRv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(MainActivity.this);
         myAdapter.addTypeOne(list1);
         myAdapter.addTypeTwo(list2);
        myAdapter.notifyDataSetChanged();
        mRv.setAdapter(myAdapter);

    }



}
