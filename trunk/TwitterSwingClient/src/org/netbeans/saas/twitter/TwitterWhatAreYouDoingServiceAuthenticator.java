/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterclient.AuthDialog;

/**
 *
 * @author lukas
 */
public class TwitterWhatAreYouDoingServiceAuthenticator extends Authenticator {

    private static String username;
    private static String password;
    private static final String PROP_FILE = TwitterWhatAreYouDoingServiceAuthenticator.class.getSimpleName().toLowerCase() + ".properties";
    
    static {
        try {
            Properties props = new Properties();
            props.load(TwitterWhatAreYouDoingServiceAuthenticator.class.getResourceAsStream(PROP_FILE));
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException ex) {
            Logger.getLogger(TwitterWhatAreYouDoingServiceAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static TwitterWhatAreYouDoingServiceAuthenticator singleton = new TwitterWhatAreYouDoingServiceAuthenticator();
    
    public static void login() throws IOException {
        if (!isValidUsernamePassword()) {
            AuthDialog dlg = new AuthDialog(null, true);
            if (1 == dlg.getStatus()) {
                username = dlg.getUserName();
                password = dlg.getPassword();
            }
            if (!isValidUsernamePassword()) {
                throw new IOException("Invalid username and password");
            }
        }
        
        Authenticator.setDefault(singleton);
    }
        
    private static boolean isValidUsernamePassword() {
        return (username != null && username.length() > 0 &&
                password != null && password.length() > 0);
    }

    private TwitterWhatAreYouDoingServiceAuthenticator() {
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}