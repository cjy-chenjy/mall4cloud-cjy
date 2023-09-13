package com.mall4j.cloud.common.util;

/**
 * @program: mall4cloud-cjy
 * @ClassName BeanUtil
 * @description:
 * @author: chenjy
 * @create: 2023-09-12 15:56
 * @Version 1.0
 **/


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lanhai
 */
public class BeanUtil {
    public static <S, D> List<D> mapAsList(final Iterable<S> sourceObject, Class<D> clazz) {
        return JSONArray.parseArray(JSONArray.toJSONString(sourceObject), clazz);
    }
    public static <S, D> D map(final S sourceObject, Class<D> clazz) {
        return JSONObject.parseObject(JSONObject.toJSONString(sourceObject), clazz);
    }
}
