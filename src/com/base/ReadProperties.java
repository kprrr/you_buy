package com.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 解析键值对文件
 * @author 张宏 on 14-10-14
 */
public class ReadProperties {

    private String fileName;

    public ReadProperties(String fileName){
        this.fileName = fileName;
    }

    public String getValue(String key){
        InputStream ins = ReadProperties.class.getResourceAsStream(fileName);
        Properties p = new Properties();
        try {
            p.load(ins);
            return p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
