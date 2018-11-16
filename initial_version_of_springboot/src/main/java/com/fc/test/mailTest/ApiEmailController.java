package com.fc.test.mailTest;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 高希阳
 * @Date: 2018/10/12 12:16
 * @Description:Spring boot 集成JavaMail服务发送邮件
 * https://blog.csdn.net/a78270528/article/details/78643916?reload
 * https://blog.csdn.net/forezp/article/details/71024024
 */

@RestController
@RequestMapping("/api/email")
@Api("发送Email接口")
public class ApiEmailController {

    private static Logger log = LoggerFactory.getLogger(ApiEmailController.class);

    @Autowired
    EmailConfig mc;

    /**
     * 功能描述：发送包含简单文本的邮件
     * @author gxy
     * @date 2018/10/12 13:49
     * @param
     * @return
     */
    @GetMapping("/send")
    public void testEmailConfig(){
        EmailEntity email = new EmailEntity();
        email.setReceiver("1625209581@qq.com");
        email.setContent("welcome Email Sender");
        email.setSubject("Spring Boot Java EE Developer");
        mc.sendSimpleMail(email);
        log.info("successful to send message!");
    }

    /**
     * 功能描述：发送包含内嵌图片的邮件
     * @author gxy
     * @date 2018/10/12 13:43
     * @param 
     * @return 
     */
    @GetMapping("/sendtwo")
    public void emailConfig(){
        EmailEntity email = new EmailEntity();
        email.setReceiver("gaoxiyang1237@126.com");
        email.setSubject("Spring Boot Java EE Developer");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
        // cid为固定写法，imageId指定一个标识
        sb.append("<img src=\"cid:imageId\"/></body>");

        sb.append("</html>");
        email.setContent(sb.toString());

        mc.sendMimeMail(email);
        log.info("successful to send message!");
    }
    /**
     * 功能描述：发送包含附件的邮件
     * @author gxy
     * @date 2018/10/12 13:53
     * @param 
     * @return 
     */
    @GetMapping("/sendthree")
    public void emailFileConfig(){
        EmailEntity email = new EmailEntity();
        email.setReceiver("gaoxiyang1237@126.com");
        email.setSubject("Spring Boot Java EE Developer");

        StringBuilder sb = new StringBuilder();
//        sb.append("<html><head></head>");
//        sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
//        // cid为固定写法，imageId指定一个标识
//        sb.append("</html>");
        sb.append("<html><head>\n" +
                "<base target=\"_blank\">\n" +
                "<style type=\"text/css\">\n" +
                "::-webkit-scrollbar{ display: none; }\n" +
                "</style>\n" +
                "<style id=\"cloudAttachStyle\" type=\"text/css\">\n" +
                "#divNeteaseBigAttach, #divNeteaseBigAttach_bak{display:none;}\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "<body tabindex=\"0\" role=\"listitem\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<table align=\"center\" style=\"font-family:Microsoft YaHei,Simsun;width:750px;table-layout:fixed;\"" +
                " bgcolor=\"#ffffff\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"display:none;\">10月13日测试</td></tr>" +
                " <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1b1b3f;\">" +
                "<img src=\"http://mimg.127.net/hz/uploader/20181013/15394102192465412.jpeg\" style=\"display:block;border:0;\"></td></tr>" +
                "</tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr>" +
                "<td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#171f3f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102194485413.jpeg\" style=\"display:block;border:0;\">" +
                "</td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#172640;\">" +
                "<img src=\"http://mimg.127.net/hz/uploader/20181013/15394102196865414.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  " +
                "<tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#112740;\">" +
                "<img src=\"http://mimg.127.net/hz/uploader/20181013/15394102199185415.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>" +
                "  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#102a40;\">" +
                "<img src=\"http://mimg.127.net/hz/uploader/20181013/15394102201235416.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102203615417.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102205955418.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102207975419.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102210015420.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102212365421.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102214765422.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102217415423.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:100px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102219795424.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><td style=\"width:750px;height:34px;font-family:Microsoft YaHei,Simsun;background:#1d193f;\"><img src=\"http://mimg.127.net/hz/uploader/20181013/15394102221835425.jpeg\" style=\"display:block;border:0;\"></td></tr></tbody></table></td></tr>  <tr><td><table style=\"width:750px;\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr></tr></tbody></table></td></tr> </tbody></table><img src=\"http://count.mail.163.com/beacon/edm.gif?no=60565162&amp;domain=email&amp;date=20181015&amp;uid=\" style=\"display:none\"><div class=\"dm-unsub-div\"><div style=\"text-align:center;padding-top:15px;font-size:10px;color:#777\">如果你不想再收到该产品的推荐邮件，请点击 <a style=\"font-size:10px\" href=\"http://dm.mail.163.com/anonymous/adsubscribe/unsubscribe?depId=1&amp;proId=106003&amp;mitId=60565162&amp;sec=B2dNABymtYhyZOtxxB1bacyNIogjqPwa\" hidefocus=\"true\">这里退订</a></div>\n" +
                "</div>\n" +
                " \n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "body{font-size:14px;font-family:arial,verdana,sans-serif;line-height:1.666;padding:0;margin:0;overflow:auto;white-space:normal;word-wrap:break-word;min-height:100px}\n" +
                "td, input, button, select, body{font-family:Helvetica, 'Microsoft Yahei', verdana}\n" +
                "pre {white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;white-space:-o-pre-wrap;word-wrap:break-word;width:95%}\n" +
                "th,td{font-family:arial,verdana,sans-serif;line-height:1.666}\n" +
                "img{ border:0}\n" +
                "header,footer,section,aside,article,nav,hgroup,figure,figcaption{display:block}\n" +
                "blockquote{margin-right:0px}\n" +
                "</style>\n" +
                "\n" +
                "<style id=\"ntes_link_color\" type=\"text/css\">a,td a{color:#138144}</style>\n" +
                "\n" +
                "</body></html>");

        email.setContent(sb.toString());

        mc.sendFileMail(email);
        log.info("successful to send message!");
    }
}
