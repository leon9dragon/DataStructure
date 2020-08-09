package com.leo9.dc36.greedy_algorithm;

import javax.management.MXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台, 放到Map中
        HashMap<String, HashSet<String>> broadcast = new HashMap<String, HashSet<String>>();
        //定义各个电台, 并将各个电台放入到broadcast中
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcast.put("K1", hashSet1);
        broadcast.put("K2", hashSet2);
        broadcast.put("K3", hashSet3);
        broadcast.put("K4", hashSet4);
        broadcast.put("K5", hashSet5);

        //定义地点集合存放所有的地区
        HashSet<String> all_areas = new HashSet<String>();
        all_areas.add("北京");
        all_areas.add("上海");
        all_areas.add("天津");
        all_areas.add("广州");
        all_areas.add("深圳");
        all_areas.add("成都");
        all_areas.add("杭州");
        all_areas.add("大连");

        //定义选择集合存放将来选择要加入的电台
        ArrayList<String> selectList = new ArrayList<String>();

        //定义临时集合, 存放遍历过程中的电台覆盖的区域和当前地点集合的交集
        HashSet<String> temp_set = new HashSet<String>();

        //定义 maxKey, 保存在一次遍历过程中能够覆盖最大未覆盖地区对应电台的key
        //如果 maxKey 不为 null, 则会加入到选择集合当中
        String max_key = null;

        while (all_areas.size() != 0) {
            //开始遍历, 如果地点集合的成员数量不为 0, 则表示还没覆盖到所有区域
            //每次循环前需要将 max_key 置空, 防止空指针异常
            max_key = null;

            //遍历电台列表, 取出对应的电台key
            for (String now_key : broadcast.keySet()) {
                //每次遍历前也需要将临时集合清空一次
                temp_set.clear();
                //取出当前key能够覆盖的区域
                HashSet<String> key_areas = broadcast.get(now_key);
                //在临时集合中加入当前key所覆盖的区域
                temp_set.addAll(key_areas);
                //将临时集合和地点集合进行取交集操作
                //这个交集会重新赋给临时集合
                //因此临时集合的成员数就是当前key所覆盖的区域数量
                temp_set.retainAll(all_areas);

                //当临时集合的地区数量不为0时, 并且max_key为空或者临时集合的地区数量大于当前max_key所对应的电台覆盖的地区数量
                //则 max_key 重新赋值
                if (temp_set.size() > 0 && (max_key == null || temp_set.size() > broadcast.get(max_key).size())) {
                    max_key = now_key;
                }
            }

            //经过一轮筛选过后, 如果max_key不为空, 则加入到选择集合当中
            if(max_key != null){
                selectList.add(max_key);
                //同时将max_key指向的广播电台覆盖的区域从地区集合中去除
                all_areas.removeAll(broadcast.get(max_key));
            }
        }

        //输出结果
        System.out.println("============================");
        System.out.println("the result is:" + selectList);
    }
}
