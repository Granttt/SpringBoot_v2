package com.fc.test.mailTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

/**
 * @auther: 高希阳
 * @Date: 2018/10/12 12:14
 * @Description:注册Bean
 */
@Component
public class EmailConfig {
    @Value("${stmp.host}")
    private String host;
    @Value("${stmp.account}")
    private String account;
    @Value("${stmp.password}")
    private String password;

    @Value("${mail.smtp.auth}")
    private String isAuth;
    @Value("${mail.smtp.timeout}")
    private String outTime;
    @Value("${mail.attach.img}")
    private String imgPath;
    @Value("${mail.attach.html}")
    private String htmlPath;


    @Bean(name = "JavaMailSenderImpl")
    public JavaMailSenderImpl getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setUsername(account);
        javaMailSender.setPassword(password);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", isAuth);
        properties.put("mail.smtp.timeout", outTime);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    public void sendSimpleMail(EmailEntity email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(account);
        String receiver = email.getReceiver();
        String receivers[] = receiver.split(";");
        simpleMailMessage.setTo(receivers);
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getContent());
        getMailSender().send(simpleMailMessage);
    }

    /**
     * 发送包含内嵌图片的邮件
     * @throws Exception
     */
    public void sendMimeMail(EmailEntity email) {
        MimeMessage mimMessage = getMailSender().createMimeMessage();
        try {
            // multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimMessage, true, "utf-8");
            messageHelper.setFrom(account);
            String receiver = email.getReceiver();
            String receivers[] = receiver.split(";");
            messageHelper.setTo(receivers);

            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getContent(), true);// Set the second
            // Param to True
            FileSystemResource res = new FileSystemResource(new File(imgPath));
            //生成图片，放到指定位置
            messageHelper.addInline("imageId", res);
            getMailSender().send(mimMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能描述：发送包含附件的邮件
     * @author gxy
     * @date 2018/10/12 13:50
     * @param 
     * @return 
     */
    public void sendFileMail(EmailEntity email) {
        MimeMessage mimMessage = getMailSender().createMimeMessage();
        try {
            // multipart模式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimMessage, true, "utf-8");
            messageHelper.setFrom(account);
            String receiver = email.getReceiver();
            String receivers[] = receiver.split(";");
            messageHelper.setTo(receivers);

            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(email.getContent(), true);// Set the second
            // Param to True
            FileSystemResource res = new FileSystemResource(new File(imgPath));
            FileSystemResource res2 = new FileSystemResource(new File(htmlPath));
            //生成附件
            messageHelper.addAttachment("image.jpg", res);
            messageHelper.addAttachment("email.html", res2);
            getMailSender().send(mimMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
