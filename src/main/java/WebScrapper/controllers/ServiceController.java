package WebScrapper.controllers;

import WebScrapper.daolayer.ApplicationRepository;
import WebScrapper.daolayer.ChannelURL;
import WebScrapper.daolayer.MongoDBTemplate;
import WebScrapper.service.ScrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by harshal on 18/12/20.
 */
public class ServiceController {

    @Autowired
    private MongoTemplate mongoTemplate;



public ServiceController(){
    MongoDBTemplate mongoDBTemplate = new MongoDBTemplate();
    mongoDBTemplate.connect();
    this.mongoTemplate = mongoDBTemplate.getTemplate();
}




    private static HashMap<String,String> channels = new HashMap<String, String>();



    public void execute() throws IOException {

        channels.put("timesofindia", "https://timesofindia.indiatimes.com/");
        channels.put("indianexpress", "https://indianexpress.com/");
        channels.put("moneycontrol", "https://www.moneycontrol.com/");

        ApplicationRepository repository = new ApplicationRepository(this.mongoTemplate);

        for (Map.Entry en : channels.entrySet()) {

            ChannelURL t = new ChannelURL();

            String channel = (String) en.getKey();
            String url = (String) en.getValue();
            ScrapperService scrapperService = new ScrapperService(url);
            HashMap<String, LinkedList<String>> hashMap = scrapperService.GetUrls(0);
            LinkedList<String> img =  scrapperService.GetImgUrls();
            LinkedList<String> content = scrapperService.GetContent();



            LinkedList<String> urls = hashMap.get("urlList");
            LinkedList<String> subUrls = hashMap.get("subUrlList");
            t.setUrls(urls);
            t.setSubUrls(subUrls);
            t.setImgUrls(img);
            t.setContent(content);
            t.setChannel(channel);

            repository.save(t);


        }


    }



}
