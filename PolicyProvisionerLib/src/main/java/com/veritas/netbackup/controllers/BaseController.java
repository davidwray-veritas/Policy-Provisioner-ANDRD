/*
 * PolicyProvisionerLib
 *
 * This file was automatically generated by APIMATIC BETA v2.0 on 02/08/2016
 */
package com.veritas.netbackup.controllers;

import com.veritas.netbackup.http.client.HttpClient;
import com.veritas.netbackup.http.client.VolleyClient;

public abstract class BaseController {
    /**
     * Protected variable to keep reference of client instance
     */
    protected HttpClient clientInstance = null;

    /**
     * Initialize with the default http client
     */
    public BaseController() {
        clientInstance = VolleyClient.getSharedInstance();
    }

    /**
     * Initialize the base controller using the given http client
     *
     * @param _client The given http client
     */
    public BaseController(HttpClient _client) {
        clientInstance = _client;
    }
}
