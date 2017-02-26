package com.groundhao.www.chunchunweather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haokun on 2017/2/26.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
