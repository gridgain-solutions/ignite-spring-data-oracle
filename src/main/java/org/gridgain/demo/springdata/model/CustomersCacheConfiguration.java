package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.CUSTOMERS_CACHE;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;

import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class CustomersCacheConfiguration<K, V> extends CacheConfiguration<Integer, Customers> {
    private static final long serialVersionUID = 0L;

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