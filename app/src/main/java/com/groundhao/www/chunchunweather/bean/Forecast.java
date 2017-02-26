package com.groundhao.www.chunchunweather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haokun on 2017/2/26.
 */

public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt_d")
        public String info;
    }

    public class Temperature {
        public String max;
        public String min;
    }
}
