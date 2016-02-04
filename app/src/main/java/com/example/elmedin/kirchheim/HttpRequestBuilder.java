package com.example.elmedin.kirchheim;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Michael on 04.02.2016.
 */
public class HttpRequestBuilder {
    public static InputStream retrieveInputStreamFromGet(String targetURL) throws Exception {
        URL url = new URL(targetURL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        return new BufferedInputStream(urlConnection.getInputStream());
    }
}
