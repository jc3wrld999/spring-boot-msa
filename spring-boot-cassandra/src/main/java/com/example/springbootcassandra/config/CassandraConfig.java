package com.example.springbootcassandra.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name: simple_crud}")
    private String keyspace;

    @Value("${spring.data.cassandra.contact-points: localhost}")
    private String contactPoint;

    @Value("${spring.data.cassandra.port: 9042}")
    private int port;
    
	@Value("${spring.data.cassandra.username}")
	private String username;

	@Value("${spring.data.cassandra.password}")
	private String password;


    @Override
    public String getContactPoints() {
        return contactPoint;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keyspace)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication(3L));
    }

    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.testapp3.model"};
    }
    
    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();//super session should be called only once
        cassandraSession.setUsername(username);
        cassandraSession.setPassword(password);
        return cassandraSession;
    }

}