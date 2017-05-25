package com.example.bima.pregnancyandbabycare.lib;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by RAHMA on 11/8/2016.
 */

public class InternetTask extends AsyncTask<String, Void, Void> {
    private OnInternetTaskFinishedListener onInternetTaskFinishedListener;
    private String method;
    private String urlString;
    private ArrayList<KeyValue> requestData;

    private String responseString;
    private String tag;

    private Exception exception;

    private FormData formData;
    private boolean usesForm;

    public InternetTask(String urlString, FormData data){
        this.method = InternetHelper.REQUEST_METHOD_POST;
        this.urlString = urlString;
        this.formData = data;
        this.onInternetTaskFinishedListener = null;
        this.responseString = "";
        this.tag = "";
        this.usesForm = true;
    }

    public InternetTask(String method, String urlString, ArrayList<KeyValue> requestData){
        this.method = method;
        this.urlString = urlString;
        this.requestData = requestData;
        this.onInternetTaskFinishedListener = null;
        this.responseString = "";
        this.tag = "";
        this.exception=null;
    }

    public String getTag(){
        return tag;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public void setOnInternetTaskFinishedListener(OnInternetTaskFinishedListener onInternetTaskFinishedListener){
        this.onInternetTaskFinishedListener = onInternetTaskFinishedListener;
    }

    public String getResponseString(){
        return responseString;
    }
    public Exception getException(){
        return exception;
    }
    @Override
    protected Void doInBackground(String... params){
        try {
            if(this.usesForm){
                this.responseString = InternetHelper.uploadFiles(this.urlString, this.formData);
            }else{
                this.responseString = InternetHelper.sendHttpRequest(this.method, this.urlString, this.requestData);
            }
        }
        catch (Exception e){
            this.exception = e;
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        if(this.onInternetTaskFinishedListener != null){
            if(this.exception == null){
                this.onInternetTaskFinishedListener.OnInternetTaskFinished(this);
            }else {
                this.onInternetTaskFinishedListener.OnInternetTaskFailed(this);
            }
        }
    }
}
