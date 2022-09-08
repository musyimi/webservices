package com.musyimiworks.fraud;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FraudConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String fraudQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingkey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue fraudQueue() {
        return new Queue(this.fraudQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(fraudQueue())
                .to(internalTopicExchange())
                .with(this.internalNotificationRoutingkey);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getFraudQueue() {
        return fraudQueue;
    }

    public String getInternalNotificationRoutingkey() {
        return internalNotificationRoutingkey;
    }
}
