package com.fc.test.fileTest;

/**
 * @auther: 高希阳
 * @Date: 2018/10/11 11:17
 * @Description:
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
