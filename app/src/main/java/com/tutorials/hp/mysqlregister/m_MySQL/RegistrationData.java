package com.tutorials.hp.mysqlregister.m_MySQL;

import com.tutorials.hp.mysqlregister.m_DataObject.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by Oclemy on 6/9/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class RegistrationData {


    User user;

    public RegistrationData(User user) {
        this.user = user;
    }

    public String packRegistrationData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer jsonData=new StringBuffer();

        try
        {
            jo.put("FULLNAME",user.getFullname());
            jo.put("USERNAME",user.getUsername());
            jo.put("EMAIL",user.getEmail());
            jo.put("PASSWORD",user.getPassword());

            Boolean isFirstValue=true;
            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(isFirstValue)
                {
                    isFirstValue=false;
                }else {
                    jsonData.append("&");
                }

                jsonData.append(URLEncoder.encode(key,"UTF-8"));
                jsonData.append("=");
                jsonData.append(URLEncoder.encode(value,"UTF-8"));


            }while (it.hasNext());

            return jsonData.toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return ErrorTracker.REGISTRATION_DATA_ERROR;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ErrorTracker.REGISTRATION_DATA_ENCODING_ERROR;
        }

    }
}
