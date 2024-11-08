# ignite-spring-data-oracle
SpringBoot, SpringData &amp; REST API with Oracle as 3rd party data store and JPA client

In this tutorial you will learn how to build an application Ignite Spring Boot Autoconfigure then use
Ignite Spring Data Extension to configure caches that use Oracle as a 3rd party datasource as well as a simple RESTful Service to access the data.
You will also learn how to use the Java Persistence API (JPA) which provides a POJO persistence model for object-relational mapping.

## Background

1. Ignite Spring Boot Autoconfigure comes in two flavours
	* For Ignite server nodes and thick clients
	* For Ignite thin clients
1. You can customize Ignite settings
	* Via Spring Boot configuration file
	* Programmatically
1. Spring Data Framework provides a unified and widely used API that allows abstracting an underlying data storage from the application layer. Spring Data helps you avoid locking to a specific database vendor, making it easy to switch from one database to another with minimal efforts. Apache Ignite integrates with Spring Data by implementing Spring Data `CrudRepository` interface.
	* `IgniteRepository<ValueType, KeyType>`
		* Implements `CrudRepository<V, K>` abstraction
		* Uses “igniteInstance” bean for connectivity

	* Basic CRUD operations use Ignite k/v APIs
	* Ignite SQL queries are generated from signatures of custom repository methods
		* Direct SQL queries are supported for complex requests

## Configuring Caches/tables

1. Create a POJO for each table

	```java
	public class Customers {
		@QuerySqlField(index = true)
		private Integer CUSTOMER_ID;
		@QuerySqlField
		private String EMAIL_ADDRESS;
		@QuerySqlField
		private String FULL_NAME;
	
		...
	}
	```
		
1. Create CacheConfiguration

	```java
	public class CustomersCacheConfiguration<K, V> extends CacheConfiguration<Integer, Customers> {
	
	    public CustomersCacheConfiguration() {
			setName(CUSTOMERS_CACHE);
			setIndexedTypes(Integer.class, Customers.class);
			setCacheMode(PARTITIONED);
			setSqlSchema(SCHEMA);
			setBackups(1);
			setReadThrough(true);
			setWriteThrough(true);
			
			CacheJdbcPojoStoreFactory<Integer, Customers> factory = new CacheJdbcPojoStoreFactory<>();
			factory.setDialect(new OracleDialect());
			factory.setDataSourceBean("oracleDataSource");
			
			JdbcType customersType = new JdbcType();
			customersType.setDatabaseSchema(SCHEMA);
			customersType.setDatabaseTable("CUSTOMERS");
			customersType.setCacheName(CUSTOMERS_CACHE);
			customersType.setKeyType(Integer.class);
			customersType.setValueType(Customers.class);
			
			customersType.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "CUSTOMER_ID", Integer.class, "CUSTOMER_ID"));
			
			customersType.setValueFields(
					new JdbcTypeField(java.sql.Types.INTEGER, "CUSTOMER_ID", Integer.class, "CUSTOMER_ID"), 
					new JdbcTypeField(java.sql.Types.VARCHAR, "EMAIL_ADDRESS", String.class, "EMAIL_ADDRESS"), 
					new JdbcTypeField(java.sql.Types.VARCHAR, "FULL_NAME", String.class, "FULL_NAME")
					);
			
			factory.setTypes(customersType);
			
			setCacheStoreFactory(factory);
	    }
	    
	}	
	```

1. Add DataSource to the server.xml Configuration

	```xml
	<?xml version="1.0" encoding="UTF-8"?>

	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

		<bean class="org.apache.ignite.configuration.IgniteConfiguration">
		...
		</bean>
		<!-- Data source bean -->
		<bean class="oracle.jdbc.datasource.impl.OracleDataSource" id="oracleDataSource">
			<property name="URL" value="jdbc:oracle:thin:@localhost:1521:FREE?user=system&amp;password=oracle"/>
		</bean>
	</beans>
	```
	
1. Create Spring AutoConfigure class

	```java
	@Configuration("igniteCfg")
	@EnableIgniteRepositories
	public class ClientConfig {
	
		@Bean(name = "igniteInstance")
		public Ignite igniteInstance(Ignite ignite) {
			IgniteCache<Integer, Customers> customersCache = ignite.getOrCreateCache(new CustomersCacheConfiguration<Integer, Customers>());
			customersCache.loadCache(null);
			...
	
			return ignite;
		}
	
		@Bean
		public IgniteConfigurer configurer() {
			return igniteConfiguration -> {
				igniteConfiguration.setClientMode(true);
				igniteConfiguration.setIgniteInstanceName("IgniteClient");
	
				TcpDiscoverySpi spi = new TcpDiscoverySpi();
				TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
				ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
				spi.setIpFinder(ipFinder);
				igniteConfiguration.setDiscoverySpi(spi);
			};
		}
	}
	```

1. Create the SpringBoot Application
	
	```java
	@SpringBootApplication
	@EnableIgniteRepositories
	public class IgniteSpringDataDemoApplication {
	
		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(IgniteSpringDataDemoApplication.class);
			app.run(args);
		}
	}
	```
	