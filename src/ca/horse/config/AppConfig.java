package ca.horse.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class is for configuring Spring MVC. There is no view here..sort of... the view here is the json returned
 * 
 * @author whkd2
 *
 */
@Configuration
@ComponentScan("ca.horse")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//configures http response body to be json
		converters.add(new MappingJackson2HttpMessageConverter());
	}
}
