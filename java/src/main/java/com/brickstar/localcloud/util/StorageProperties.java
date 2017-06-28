package com.brickstar.localcloud.util;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by bricks on 17-6-28.
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
