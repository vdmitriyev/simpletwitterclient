package twitterclient.utils;

import java.util.Properties;

/**
 * Singletone for the proxy connection.
 * 
 * @author viktor
 */
public class ProxySettings {

    private static ProxySettings singletonInstance = null ;
    private String proxyIP = "proxy.iitu.kz";
    private String proxyPort = "3128";
    private String login = "";
    private String password = "";
    /** Properties*/
    private Properties props = System.getProperties();
    
    /**
     * Constructor.
     */
    private ProxySettings(){
        
    }

    /**
     * 
     * @return
     */
    static public ProxySettings getSingletoneInstance() {
        
        if (singletonInstance == null ) {
               singletonInstance = new ProxySettings();
        }
        
        return singletonInstance;
    }


    /**
     * Setting proxy settings like porxy ip adress, port , login and the password.
     */
    public void setProxy(
                            String newProxyIP,
                            String newProxyPort,
                            String newLogin,
                            String newPassword
                    ) {

        this.proxyIP = newProxyIP;
        this.proxyPort = newProxyPort;
        this.login = newLogin;
        this.password = newPassword;
        changeProxy();

    }

    /**
     * Changes the proxy.
     */
    private void changeProxy() {

         props.setProperty("http.proxySet","true");
         props.setProperty("http.proxyHost",proxyIP);
         props.setProperty("http.proxyPort",proxyPort);
         props.setProperty("http.proxyUserName",login);
         props.setProperty("http.proxyPassword",password);
    }

}


