package ejemplotwitter;

import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author igonzaleziglesias
 */
public class metodos {
    /**
     * Metodo hacer un tuit
     */
    public void tuit() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        String latestStatus = JOptionPane.showInputDialog("Introduce texto: ");
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
    /**
     * Metodo para traer la linea de tiempo
     */
    public void traerLineaTiempo() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }
    /**
     * Metodo para filtrar y ver tuits
     */
    public void filtrado() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("source:twitter4j yusukey");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

}
