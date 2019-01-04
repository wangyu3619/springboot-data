package com.example.demo.utils;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyu
 * @date 2018/12/14 13:00
 */
public class JsonConverters {

    public static HttpMessageConverters fastJsonConverter() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> types = new ArrayList<>();
        types.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        fastConverter.setSupportedMediaTypes(types);
        fastConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }
}
