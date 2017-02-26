package com.groundhao.www.chunchunweather.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.groundhao.www.chunchunweather.bean.Weather;
import com.groundhao.www.chunchunweather.db.City;
import com.groundhao.www.chunchunweather.db.County;
import com.groundhao.www.chunchunweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by haokun on 2017/2/26.
 */

public class Utility {
    /**
     * 解析处理省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provincesJson = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provincesJson.getString("name"));
                    province.setProvinceCode(provincesJson.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析处理城市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCity = new JSONArray(response);
                for (int i = 0; i < allCity.length(); i++) {
                    JSONObject cityJson = allCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityJson.getString("name"));
                    city.setCityCode(cityJson.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析处理县级数据
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounty = new JSONArray(response);
                for (int i = 0; i < allCounty.length(); i++) {
                    JSONObject cityJson = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(cityJson.getString("name"));
                    county.setWeatherId(cityJson.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Json解析Weather类
     */
    public static Weather handleWhatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weahterContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weahterContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
