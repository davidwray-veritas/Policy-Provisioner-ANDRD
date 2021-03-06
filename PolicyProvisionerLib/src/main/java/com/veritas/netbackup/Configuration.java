/*
 * PolicyProvisionerLib
 *
 * This file was automatically generated by APIMATIC BETA v2.0 on 02/08/2016
 */
package com.veritas.netbackup;

import android.content.Context;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Configuration {
    //The base Uri for API calls
    public static String baseUri = "http://mocksvc.mulesoft.com/mocks/8429771d-7341-45bb-b6fc-681193c181c1";

    //retains status whether we have already initialized
    private static boolean initialized = false;
    private static RequestQueue requestQueue = null;

    //Initialization of configuration
    public static void initialize(Context context){
        if(initialized)
            throw new IllegalStateException("Already initialized");

        requestQueue = Volley.newRequestQueue(context);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo app = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;

            basicAuthUserName = bundle.getString("basicauthusername");
            basicAuthPassword = bundle.getString("basicauthpassword");

            initialized = true;
        }
        catch (Exception ex){
            throw new IllegalStateException("Unable to initialize", ex);
        }
    }

    // volley request queue needs to be initialized before use
    public static RequestQueue getRequestQueue() {
        if(!initialized)
            throw new IllegalStateException("Must initialize before accessing request queue");
        return requestQueue;
    }
    

    //private backing field for BasicAuthUserName
    private static String basicAuthUserName = null;

    //The username to use with basic authentication

    public static String getBasicAuthUserName() {
        if(!initialized)
            throw new IllegalStateException("Must initialize configuration before use");

        return basicAuthUserName;
    }

    //private backing field for BasicAuthPassword
    private static String basicAuthPassword = null;

    //The password to use with basic authentication

    public static String getBasicAuthPassword() {
        if(!initialized)
            throw new IllegalStateException("Must initialize configuration before use");

        return basicAuthPassword;
    }
}
