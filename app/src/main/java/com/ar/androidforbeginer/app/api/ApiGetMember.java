package com.ar.androidforbeginer.app.api;

import android.content.Context;
import android.util.Log;

import com.ar.androidforbeginer.app.model.ModelMemberAndroid4Beginer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.radyalabs.async.AsyncHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created by Ade Rifaldi on 4/9/2016.
 */
abstract public class ApiGetMember extends BaseApi{

    private static final String TAG = "GetMember";

    protected ModelMemberAndroid4Beginer data;
    private JsonObject object;
    private JsonObject json;
    private String rawContent;
    private Gson gson;
    private GsonBuilder gsonBuilder;

    public ApiGetMember(Context context) {
        super(context);

        ajaxType = AjaxType.GET;
        endpointApi = "json-sample.json";

        responseHandler = new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int codeReturn, Header[] headers, byte[] content) {
                try {
                    rawContent = new String(content);
                    json = new JsonParser().parse(rawContent).getAsJsonObject();
                    object = json.getAsJsonObject();

                    gsonBuilder = new GsonBuilder();
                    gson = gsonBuilder.create();

                    data = gson.fromJson(object, ModelMemberAndroid4Beginer.class);

                    Log.i(TAG, "Result : " + rawContent);

                    onFinishRequest(true, rawContent);
                } catch(Exception e) {
                    e.printStackTrace();
                    onFinishRequest(false, rawContent);
                }
            }

            @Override
            public void onFailure(int codeReturn, Header[] headers, byte[] content, Throwable error) {
                String textContent = null;
                if (content != null){
                    textContent = new String(content);
                }
                onFinishRequest(false, textContent);
            }
        };
    }
}
