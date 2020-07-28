package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class First_Fragment extends Fragment {
    private View view;

    private List<ActivityOneClass> list1;
    private RecyclerView mRv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_first, null);
        }
        initList1();

        mRv = view.findViewById(R.id.mRv);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(manager);

        MyAdapter myAdapter = new MyAdapter( list1,parallel(list1.size()));
        mRv.setAdapter(myAdapter);
        return view;
    }

    private void initList1() {
        list1 = new ArrayList<>();
        ActivityOneClass one = new ActivityOneClass("火影忍者第一集剧情", "鸣人刚出场就让我们吓了一跳，伊鲁卡追着逃课的他满村子跑。好不容易抓住了鸣人，但是在变身的考核上，鸣人却变出了一个裸女，并美其名曰是色诱之术。他是一个十足的钓车尾，但是他一点都不讨人厌，尽管他不被认同，但是他不退缩，永不服输，爱吃拉面，爱恶搞，而这样的人，才是我们心中的鸣人，感动从这一刻开始了。",R.drawable.p3);
        list1.add(one);
        ActivityOneClass two = new ActivityOneClass("火影忍者第二集剧情","木叶村每一代的首领被称为“火影”，只有忍者中实力最强者才能拥有此殊荣。“猿飞”正是现在的第三代火影，他有个孙子叫做“木叶丸”。好不容易才从忍者学校毕业的鸣人刚从学校拿到忍者证书，就遇到了木叶丸。木叶丸开口就叫鸣人“老大”，而且一直跟随在鸣人身后。这是因为，只有鸣人没有把他当做“火影的孙子”来特别对待，而木叶丸的目标就是要成为受人尊敬的“火影”……",R.drawable.p1);
        list1.add(two);
        ActivityOneClass three = new ActivityOneClass("火影忍者第三集剧情","鸣人终于成为忍者啦，因为任务需要，鸣人必须同另外两个人组成三人一组的小队。与他分到同组的是同班的“宇智波佐助”及“春野樱”。鸣人非常喜欢可爱的小樱，可是小樱却暗恋着佐助。更糟糕的是，比起鸣人，佐助不但帅气而且是实力拔群的优等生。于是，郁闷的鸣人为了接近小樱，又想出了一个鬼主意…",R.drawable.p2);
        list1.add(three);
    }

    int[] parallel(int size){
        int[] numbers = new int[size];
        for (int i=0;i<size;i++)
        {
            numbers[i]=i;
        }
        return numbers;
    }


}

