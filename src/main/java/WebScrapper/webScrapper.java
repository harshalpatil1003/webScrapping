package WebScrapper;

import WebScrapper.controllers.ServiceController;

import java.io.IOException;

/**
 * Created by harshal on 17/12/20.
 */
public class webScrapper {

       public static void main(String[] args) throws IOException {


        ServiceController serviceController = new ServiceController();
        serviceController.execute();
        System.out.println("\nDone\n");
           System.exit(0);

    }
}
