package vn.com.gsoft.security.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {
    // common
    @Value("${kafka.internal.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${kafka.concurrency:10}")
    private Integer concurrency;
    // Security
    @Value("${kafka.security-protocol}")
    private String securityProtocol;
    @Value("${kafka.sasl.mechanism}")
    private String saslMechanism;
    @Value("${kafka.internal.sasl.jaas-config}")
    private String saslJAAS;
    // Consumer
    @Value("${kafka.internal.consumer.group-id}")
    private String groupId;
    @Value("${kafka.internal.consumer.max-poll-records:30}")
    private Integer maxPollRecords;
    @Value("${kafka.internal.consumer.max-poll-interval:600000}")
    private Integer maxPollInterval;
    @Value("${kafka.internal.consumer.session-timeout:30000}")
    private Integer sessionTimeout;
    @Value("${kafka.internal.consumer.receive-buffer:1000000}")
    private Integer receiveBuffer;

    private Map<String, Object> initConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // security
        props.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, securityProtocol);
        props.put(SaslConfigs.SASL_MECHANISM, saslMechanism);
        props.put(SaslConfigs.SASL_JAAS_CONFIG, saslJAAS);
        return props;
    }

    // consumer
    @Bean
    public Map<String, Object> consumerInternalConfigs() {
        Map<String, Object> props = initConfig();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, receiveBuffer);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollInterval);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        // allows a pool of processes to divide the work of consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // automatically reset the offset to the earliest offset
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerInternalFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerInternalConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaInternalListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerInternalFactory());
        factory.setConcurrency(concurrency);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        return factory;
    }

    /* Producer */
    @Bean
    public Map<String, Object> producerInternalConfigs() {
        Map<String, Object> props = initConfig();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerInternalFactory() {
        return new DefaultKafkaProducerFactory<>(producerInternalConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaInternalTemplate() {
        return new KafkaTemplate<>(producerInternalFactory());
    }
}