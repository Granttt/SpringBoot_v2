package com.fc.test.mailTest;

/**
 * @auther: 高希阳
 * @Date: 2018/10/12 12:12
 * @Description:创建实体类
 */
public class EmailEntity {
    private String receiver;
    private String subject;
    private String text;
    private String content;
    /** 内容格式(默认html) */
    private String contentType;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
