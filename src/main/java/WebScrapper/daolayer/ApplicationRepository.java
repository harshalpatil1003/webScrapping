package WebScrapper.daolayer;



import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by harshal on 20/12/20.
 */
public class ApplicationRepository {


    MongoTemplate mongoTemplate;

    public ApplicationRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public void save(ChannelURL c){

      mongoTemplate.save(c);
//        mongoTemplate.save(c);
    }

}
