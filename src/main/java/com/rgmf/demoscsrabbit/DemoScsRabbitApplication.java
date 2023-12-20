package com.rgmf.demoscsrabbit;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.ErrorMessage;

@SpringBootApplication
public class DemoScsRabbitApplication {

  private static final Logger log = LoggerFactory.getLogger(DemoScsRabbitApplication.class);

  private AtomicInteger counter = new AtomicInteger();

  public static void main(String[] args) {
    SpringApplication.run(DemoScsRabbitApplication.class, args);
  }

  @Bean
  public Supplier<String> source() {
    return () -> {
      String message = "Ciao" + counter.incrementAndGet();
      log.info("Sending value: " + message);
      return message;
    };
  }

  @Bean
  public Consumer<String> sink() {
    return message -> log.info("Received message " + message);
  }

  @Bean
  public Consumer<ErrorMessage> myErrorHandler() {
    return v -> log.error("************ App in error {} **************", v.getOriginalMessage());
  }

}
