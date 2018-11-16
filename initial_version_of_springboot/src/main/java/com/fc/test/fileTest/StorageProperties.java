package com.fc.test.fileTest;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther: 高希阳
 * @Date: 2018/10/11 11:24
 * @Description:
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
