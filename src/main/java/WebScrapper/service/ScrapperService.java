package WebScrapper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by harshal on 18/12/20.
 */

@Service
public class ScrapperService {

    private String html;

    public static boolean getDocument(String html){
        try {
            Document document = Jsoup.connect(html).get();
            return true;

        }catch (Exception e) {
            return false;
        }

    }

    public static boolean urlValidator(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }
        catch (MalformedURLException exception) {
            return false;
        }
    }


    public ScrapperService( String url){
        this.html= url;
    }


    public LinkedList<String> GetSubUrls(String html) throws IOException{

        LinkedList<String> urlList = new LinkedList();

        if(getDocument(html)) {

            Document document = Jsoup.connect(html).get();

            Elements links = document.select("a[href]");
            String Url;
            for (Element link : links) {
                Url = link.attr("href");

                if (urlValidator(Url)) {
                    urlList.add(Url);

                    System.out.println("URL : " + Url);
                }
            }

        }
       return  urlList;

    }


    public HashMap<String, LinkedList<String>> GetUrls(int flag)  throws IOException {

        HashMap<String , LinkedList<String>> hashMap = new HashMap<String, LinkedList<String>>();

        LinkedList<String> urlList = new LinkedList();
        LinkedList<String> subUrlList = new LinkedList();

        if(getDocument(html)) {

            Document document = Jsoup.connect(html).get();
            Elements links = document.select("a[href]");
            String Url;



            for (Element link : links) {
                Url = link.attr("href");

                if (urlValidator(Url)) {
                    urlList.add(Url);

                    if (flag <= 50) {
                        subUrlList.addAll(GetSubUrls(Url));
                          flag++;
                    }


                    System.out.println("URL : " + Url);
                }

            }

        }

    hashMap.put("urlList", urlList);
        hashMap.put("subUrlList",subUrlList);

       return  hashMap;

    }

    public LinkedList<String> GetImgUrls() throws IOException {

        LinkedList<String> imgUrls = new LinkedList();
        Document document = Jsoup.connect(html).get();
        Elements links = document.select("img");

        for (Element link : links) {

            String Url = link.attr("src");
            imgUrls.add(link.attr("src"));
            System.out.println("Image URL : " + Url);

        }



        return imgUrls;



    }


    public LinkedList<String> GetContent() throws IOException{

        LinkedList<String> content = new LinkedList();
        Document document = Jsoup.connect(html).get();
        Elements links = document.select("a");

        for (Element link : links) {

            String Url = link.text();

            content.add(Url);
            System.out.println("Text : \n" + Url);

        }

        return content;



    }



}
