package com.boss.test;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName Dom4jPaser.java
 * @Description TODO
 * @createTime 2022年06月19日 18:30:00
 */
public class Dom4jPaser implements Parser {
    @Override
    public User[] parse(String url) {
        SAXReader sr = new SAXReader();
        Document document = null;
        User[] users=null;
        try {
            document = sr.read(new File(url));
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            users=new User[elementList.size()];
            for(int i=0;i<elementList.size();i++){
                User user=new User();
                user.setId(Integer.parseInt(elementList.get(i).attributeValue("id")));
                user.setName(elementList.get(i).elementText("name"));
                users[i]=user;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return users;
    }
}
