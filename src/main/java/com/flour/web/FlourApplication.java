package com.flour.web;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = {"com.flour.web.mapper"})
public class FlourApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlourApplication.class, args);
	}
		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);

			Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml");
			sessionFactory.setMapperLocations(res);
			return sessionFactory.getObject();
		}
}
