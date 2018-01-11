package com.my.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 15:27  2018/1/11
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String age;
    private String name;
    private String cupSize;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
