package WebScrapper.daolayer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

/**
 * Created by harshal on 19/12/20.
 */

@Document(collection = "channel")
public class ChannelURL {



    @Id
    private  String channel;
    private LinkedList<String> urls;
    private LinkedList<String> subUrls;
    private LinkedList<String> imgUrls;
    private LinkedList<String> content;

    public LinkedList<String> getUrls() {
        return urls;
    }
    public void setUrls(LinkedList<String> urls) {
        this.urls = urls;
    }
    public LinkedList<String> getSubUrls() {
        return subUrls;
    }
    public void setSubUrls(LinkedList<String> subUrls) {
        this.subUrls = subUrls;
    }
    public LinkedList<String> getImgUrls() {
        return imgUrls;
    }
    public void setImgUrls(LinkedList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
    public LinkedList<String> getContent() {
        return content;
    }
    public void setContent(LinkedList<String> content) {
        this.content = content;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }



}
