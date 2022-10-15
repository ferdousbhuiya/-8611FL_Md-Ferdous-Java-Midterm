package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.SharedStepsDatabase;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CnnAPI {
    /**
     * INSTRUCTIONS
     * Go to this URL: https://newsapi.org/s/cnn-api
     * <p>
     * Get your API Key from this website. Once you have your key, you can append your key to the end of the URL, as
     * shown below.
     * <p>
     * https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY
     * <p>
     * When you navigate to that full URL, you will be submitting a request, and the response should be CNN's
     * top headline news at the current moment
     * <p>
     * After retrieving the JSON response, you can go to the following link to validate that it is, in fact, valid JSON:
     * https://jsonlint.com/
     * <p>
     * "articles": [{
     * "source": {
     * "id": "cnn",
     * "name": "CNN"
     * },
     * "author": null,
     * "title": "Who is affected by a shutdown? - CNN Video",
     * "description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
     * "url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
     * "urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
     * "publishedAt": "2018-12-23T01:09:50.8583193Z",
     * "content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
     * },{}]
     * <p>
     * Follow along in the code implemented below to understand what is going on. You must implement the rest of the
     * code in the for loop. Your goal is to create a new object of the inner class for each headline your JSON response
     * contains. You will assign the values that are being retrieved by the JSON parser, to the object attributes. Then,
     * store each of those objects in the provided List<NewsData>
     * <p>
     * You can also choose to store these instances in a Map, instead.
     * <p>
     * Lastly, store the data that is in your data structure into a database table, called `news_headlines`, and then
     * demonstrate that you can read from the table and print all the results to the console
     * <p>
     * Feel free to use the JsonReaderUtil for reference.
     */

    public static void main(String[] args) throws IOException, JSONException, SQLException {
        String apiKey = "c43d0fe77dfd44e4a1b8db225bc33e6b";
        //String apiKey = "e021b2595ba84a6dae27222593908fd4";
        String URL = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=" + apiKey;

        NewsData news = null;
        List<NewsData> newsDataList = new ArrayList<>();
        java.net.URL url1 = new URL(URL);
        URLConnection request = url1.openConnection();//establish the connection with  the server
        request.connect();

        JsonArray jsonArray = null;
        JsonObject rootObj = null;
        JsonParser jp = new JsonParser();

        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

        if (root instanceof JsonObject) {
            rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray = root.getAsJsonArray();
        }

        // If response is not a JSON array, then convert the response into a JSON array
        if (jsonArray == null)
            jsonArray = rootObj.getAsJsonArray("articles");

        String source;
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;
        String content;
        Map<Object, Object> jsonOutput = new HashMap<>();
        for (int i = 0; i < jsonArray.size() - 1; i++) {

            try {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                title = jsonObject.get("title").toString();
                author = jsonObject.get("author").toString();
                source = jsonObject.get("source").getAsJsonObject().get("name").toString();
                description = jsonObject.get("description").toString();
                url = jsonObject.get("url").toString();
                urlToImage = jsonObject.get("urlToImage").toString();
                publishedAt = jsonObject.get("publishedAt").toString();
                content = jsonObject.get("content").toString();

                NewsData headline = new NewsData(source, author, title, description, url, urlToImage, publishedAt, content);
                newsDataList.add(headline);
                for (NewsData newsData : newsDataList) {
                    jsonOutput.put(newsData.source, newsData.title);
                }

                System.out.println("TITLE: " + headline.title + "\nAUTHOR: " + headline.author + "\nSOURCE: " + headline.source +
                        "\nDESCRIPTION: " + headline.description + "\nURL: " + headline.url + "\nURL TO IMAGE: " +
                        headline.urlToImage + "\nPUBLISHED AT: " + headline.publishedAt + "\nCONTENT: " + headline.content + "\n");

                for (NewsData newsData : newsDataList) {
                    jsonOutput.put(i, newsData.title);
                    jsonOutput.put(i, newsData.publishedAt);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        SharedStepsDatabase sharedStepsDatabase = new SharedStepsDatabase();
        sharedStepsDatabase.insertMap("NewsHeadlinesCNN", jsonOutput);
        String queryToSql = "Select * From NewsHeadLinesCNN";
        sharedStepsDatabase.executeQueryReadAll(queryToSql);
        System.out.println(sharedStepsDatabase.executeQueryReadAll(queryToSql));
    }

    // Inner Class
    private static class NewsData {

        String source;
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;
        String content;

        public NewsData(String source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
            this.source = source;
            this.author = author;
            this.title = title;
            this.description = description;
            this.url = url;
            this.urlToImage = urlToImage;
            this.publishedAt = publishedAt;
            this.content = content;


        }


    }

}

