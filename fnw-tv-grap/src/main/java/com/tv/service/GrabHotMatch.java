package com.tv.service;/**
 * Created by HUXU on 2017/10/22.
 */

import com.tv.dao.GrabMatchDao;
import com.tv.model.HotMatch;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 抓取热门赛事   https://www.zhibo8.cc/
 *
 * @author huxu
 * @create 2017-10-22 9:33
 **/
@Service
public class GrabHotMatch {

    @Autowired
    private GrabMatchDao grabMatchDao;

    private static final String zhibo8_url = "https://www.zhibo8.cc";

    /**
     * 抓取网页数据
     */
    public void getData() {

        try {
            Document doc = Jsoup.connect(zhibo8_url).timeout(10000).get();
            Elements elements = doc.select(".schedule_container .box");
            List<HotMatch> list = new ArrayList<HotMatch>();
            //获取迭代器
            Iterator it = elements.iterator();
            while(it.hasNext()) {
                Element element = (Element)it.next();
                String hTime = element.select("h2").text();
                Elements lis = element.select("li");
                for (Element li : lis) {
                    li.select("a").empty();
                    String label = li.attr("label");
                    String id = li.attr("id");
                    String dataTime = li.attr("data-time");
                    String title = li.text();
                    Elements children = li.children();
                    Element e1 = children.get(0);
                    String matchType = null;
                    String homePic = null;
                    String guestPic = null;
                    String homeTeam = null;
                    String guestTeam = null;
                    if (li.toString().indexOf("img") > 1) {
                        Elements img = li.select("img");
                        homePic = img.get(0).attr("src");
                        guestPic = img.get(1).attr("src");
                    }else {
                        matchType = e1.text();
                    }
                    if (title.indexOf("-") != -1){
                        String[] arr = title.split(" ");
                        for(int i = 0; i < arr.length; i++){
                            if (i == 1) {matchType = arr[i];}
                            if (i == 2) {homeTeam = arr[i];}
                            if (i == 4) {guestTeam = arr[i];}
                        }
                    } else {
                        String[] arr = title.split(" ");
                        homeTeam = arr[1];
                    }
                    HotMatch hm = new HotMatch();
                    hm.setLabel(label);
                    hm.setId(id);
                    hm.setDataTime(dataTime);
                    hm.setHomeTeam(homeTeam);
                    hm.setHomePic(homePic);
                    hm.setGuestTeam(guestTeam);
                    hm.setGuestPic(guestPic);
                    hm.setTitle(title);
                    hm.setMatchType(matchType);
                    hm.setHTime(hTime);
                    list.add(hm);
                    //System.out.println("对象： "+matchType+ "   hTime:"+hTime +"    "+ title+ "    "+label+"  "+id+"   "+dataTime+"  "+homeTeam+"   "+guestTeam+"   "+homePic+"  "+guestPic);
                }
            }
            grabMatchDao.addHotMatch(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
