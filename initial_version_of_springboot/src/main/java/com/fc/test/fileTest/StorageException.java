package com.fc.test.fileTest;

/**
 * @auther: 高希阳
 * @Date: 2018/10/11 11:16
 * @Description:StorageException 自定义异常类
 */
public class StorageException extends RuntimeException{
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
