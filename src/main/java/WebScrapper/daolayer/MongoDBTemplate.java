package WebScrapper.daolayer;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;



/**
 * Created by harshal on 20/12/20.
 */
public class MongoDBTemplate {

    private static String url = "mongodb://localhost:27017";
    private String DB_NAME  = "webscrapper";



    private  MongoTemplate template;

    public void connect(){
        try {
            this.template = mongoTemplate(url , DB_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  MongoTemplate mongoTemplate(String uri , String db) throws  Exception{
        MongoTemplate mongoTemplate = null;

        MongoClient mongoClient = MongoClients.create(uri);


        mongoTemplate = new MongoTemplate(mongoClient,db);
        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);


        return mongoTemplate;


    }


    public MongoTemplate getTemplate() {
        return template;
    }

    public void setTemplate(MongoTemplate template) {
        this.template = template;
    }




}
