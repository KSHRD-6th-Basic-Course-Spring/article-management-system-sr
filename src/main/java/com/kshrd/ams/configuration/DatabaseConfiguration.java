package com.kshrd.ams.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatabaseConfiguration {

	// Production DB
	@Bean
	@Profile("database")
	public DataSource production() {
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClassName("org.postgresql.Driver");
		db.setUrl("jdbc:postgresql://localhost:5432/ams_sr");
		db.setUsername("postgres");
		db.setPassword("12345");
		return db;
	}
	
	// Development DB
	@Bean
	@Profile("memory")
	public DataSource development() {
		EmbeddedDatabaseBuilder db = new EmbeddedDatabaseBuilder();
		db.setType(EmbeddedDatabaseType.H2);
		db.addScript("sql/table.sql");
		db.addScript("sql/data.sql");
		return db.build();
	}
	
}
