package com.bingsin.crm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 
* @ClassName: GeneratorSqlmap 
* @Description: Mybatis自动构建
* @author wangege
* @date 2018年1月26日 下午6:25:00 
*
 */
public class CrmSqlmap{
	
	public static void main(String[] args){
		try {
			CrmSqlmap generatorSqlmap = new CrmSqlmap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	* @Title: generator 
	* @Description: 读取配置文件并生产po和dao
	* @param    
	* @return void    
	* @throws
	 */
	public void generator() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定获取自动构建xml文件
		InputStream inputStream = CrmSqlmap.class.getClassLoader().getResourceAsStream("config/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(inputStream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	} 

}
