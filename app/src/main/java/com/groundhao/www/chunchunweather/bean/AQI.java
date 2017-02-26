package com.groundhao.www.chunchunweather.bean;

/**
 * Created by haokun on 2017/2/26.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
