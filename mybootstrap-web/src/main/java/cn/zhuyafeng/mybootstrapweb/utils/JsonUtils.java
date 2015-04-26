package cn.zhuyafeng.mybootstrapweb.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class JsonUtils {

    public static List<?> getList(List<?> obj,Class<?> beanClass,Map<?, ?> classMap) {

        JSONArray jsonArray = JSONArray.fromObject(obj);
        
        @SuppressWarnings("rawtypes")
        List<?> list = new ArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            /*list.add( JSONObject.toBean(jsonArray.getJSONObject(i), beanClass,
                    classMap));*/
        }

        return list;
    }

}
