package com.fc.test;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Auther: 高希阳
 * @Date: 2018/10/8 16:02
 * @Description:利用mybatis-generator自动生成代码
 * https://blog.csdn.net/shaohe18362202126/article/details/79338974
 */
public class MybatisGeneratorTest {

    /**
     * 功能描述：
     * @author gxy
     * @date 2018/10/10 12:26
     * @param 
     * @return 
     */
    @Test
    public void testMbg() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //mybatis-generator.xml为上面创建的配置文件。
        File configFile = new File("src/main/resources/mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
