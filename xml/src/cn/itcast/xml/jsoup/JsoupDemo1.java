package cn.itcast.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/*
* jsoup解析xml文档
* */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //2.获得Document对象，根据xml文档获取
        //2.1获得student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8"); //jsoup是一个工具类，有parse方法
        //3.获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

//        System.out.println(elements.size());
//        //获取第一个name的element对象
//        Element element = elements.get(0);
////        System.out.println(element);
//        String name1 = element.text();
//        System.out.println(name1);

        //parse(URL url,int timeoutMillis)`:通过网络路径获取指定的html或xml文档
//        URL url = new URL("https://www.baidu.com/");
//        Document document1 = Jsoup.parse(url, 10000);
//        System.out.println(document1);
//        System.out.println("-----------------------------------");
//        Element zhangsan = document.getElementById("zs");
//        System.out.println(zhangsan);
//        System.out.println("-----------------------------------");
//        Elements name = zhangsan.getElementsByTag("name");
//        System.out.println(name);
//        System.out.println("-----------------------------------");
//        String a = zhangsan.attr("number");
//        String text1 = zhangsan.text();
//        System.out.println(text1);
//        System.out.println("-----------------------------------");
//        String html1 = zhangsan.html();
//        System.out.println(html1);
//        System.out.println("-----------------------------------");
//        Elements age1 = document.getElementsByTag("age");
//        System.out.println(age1);
//        System.out.println("-----------------------------------");
        //select选择器
//        Elements elements2 = document.select("student[number='s001']>age");
//        System.out.println(elements2);
        //用Xpath
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes){
            System.out.println(jxNode);
            System.out.println("-----------------------------------");

        }


    }
}
