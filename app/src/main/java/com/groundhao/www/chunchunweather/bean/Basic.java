package com.groundhao.www.chunchunweather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haokun on 2017/2/26.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;

    public Update update;

   public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
