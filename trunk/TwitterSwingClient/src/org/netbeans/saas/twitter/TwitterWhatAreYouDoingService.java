/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * TwitterWhatAreYouDoingService Service
 *
 * @author viktor
 */

public class TwitterWhatAreYouDoingService {

    /** Creates a new instance of TwitterWhatAreYouDoingService */
    public TwitterWhatAreYouDoingService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param since
     * @param sinceId
     * @param page
     * @param count
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse getUserTimeline(String since, String sinceId, String page, String count, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"since", since}, {"since_id", sinceId}, {"page", page}, {"count", count}};
        RestConnection conn = new RestConnection("http://twitter.com/statuses/user_timeline.{format}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param status
     * @param inReplyToStatusId
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse updateStatus(String status, String inReplyToStatusId, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"status", status}, {"in_reply_to_status_id", inReplyToStatusId}};
        RestConnection conn = new RestConnection("http://twitter.com/statuses/update.{format}", pathParams, null);
        sleep(1000);
        return conn.post(null, queryParams);
    }

    /**
     *
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse getPublicTimeline(String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection("http://twitter.com/statuses/public_timeline.{format}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }

    /**
     *
     * @param since
     * @param sinceId
     * @param page
     * @param count
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse getFriendsTimeline(String since, String sinceId, String page, String count, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"since", since}, {"since_id", sinceId}, {"page", page}, {"count", count}};
        RestConnection conn = new RestConnection("http://twitter.com/statuses/friends_timeline.{format}", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
