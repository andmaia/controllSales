package com.fiap.controllSales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
	public class  ControllSalesApplication implements WebMvcConfigurer {

	private final LocaleChangeInterceptor localInterceptor;


	public ControllSalesApplication(LocaleChangeInterceptor localInterceptor) {
		this.localInterceptor = localInterceptor;
	}

	public static void main(String[] args) {
			SpringApplication.run(ControllSalesApplication.class, args);
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(localInterceptor);
		}
}
