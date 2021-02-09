package com.salesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@SpringBootApplication
public class SalesManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApplication.class, args);
	}
}
