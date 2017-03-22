package com.project.dagger2.xeample1.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：递乐app
 * 类描述： ShredPreferences数据存取类
 * 创建人：mj
 * 创建时间： 2016/7/8  10:00
 * 修改人：
 * 修改时间：
 * 修改备注：
 * Version:  1.0.0
 */
public class HnPrefUtil {

    private static final String PERF_NAME="config";
    private static SharedPreferences sp;
    /**
     * 初始化sharedpreference
     * @param context
     */
    public  static void init(Context context){
        if(sp==null) {
            sp = context.getSharedPreferences(PERF_NAME, Context.MODE_PRIVATE);
        }
    }

    /**
     * 存储boolean类型的数据
     * @param key
     * @param value
     */
    public static void setBoolean(String key, Boolean value){
        sp.edit().putBoolean(key,value).commit();
    }

    /**
     * 通过键获取boolean数据
     * @param key
     * @param value
     * @return
     */
    public  static Boolean getBoolean(String key, boolean value){
        return sp.getBoolean(key,value);
    }

    /**
     * 存储String类型的数据
     * @param key
     * @param value
     */
    public static void setString(String key, String value){
        sp.edit().putString(key,value).commit();
    }

    /**
     * 通过键获取String数据
     * @param key
     * @param value
     * @return
     */
    public  static String getString(String key, String value){
        return sp.getString(key,value);
    }
    /**
     * 存储int类型的数据
     * @param key
     * @param value
     */
    public static void setInt(String key, int value){
        sp.edit().putInt(key,value).commit();
    }

    /**
     * 通过键获取int数据
     * @param key
     * @param value
     * @return
     */
    public  static  int  getInt(String key, int value){
        return sp.getInt(key,value);
    }

    /**
     * 以数组的形式进行存储
     */
    public static void setStrings(String[] keys, String[] values){
        for (int i = 0; i <keys.length ; i++) {
            sp.edit().putString(keys[i],values[i]).commit();
        }
    }

    /**
     * 根据键值进行数据移除
     * @param key
     */
    public static void removeValue(String key){
        sp.edit().remove(key).commit();
    }
}
