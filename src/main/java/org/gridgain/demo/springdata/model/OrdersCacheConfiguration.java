package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

import static org.gridgain.demo.springdata.config.Constants.ORDERS_CACHE;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;

public class OrdersCacheConfiguration<K, V> extends CacheConfiguration<Integer, Orders> {
	private static final long serialVersionUID = 0L;

	public OrdersCacheConfiguration() {
		setName(ORDERS_CACHE);
		setIndexedTypes(Integer.class, Orders.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, Orders> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType ordersType = new JdbcType();
		ordersType.setDatabaseSchema(SCHEMA);
		ordersType.setDatabaseTable("ORDERS");
		ordersType.setCacheName(ORDERS_CACHE);
		ordersType.setKeyType(Integer.class);
		ordersType.setValueType(Orders.class);

		ordersType.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "ORDER_ID", Integer.class, "ORDER_ID"));

		ordersType.setValueFields(new JdbcTypeField(java.sql.Types.INTEGER, "ORDER_ID", Integer.class, "ORDER_ID"),
				new JdbcTypeField(java.sql.Types.TIMESTAMP, "ORDER_TMS", Timestamp.class, "ORDER_TMS"),
				new JdbcTypeField(java.sql.Types.INTEGER, "CUSTOMER_ID", Integer.class, "CUSTOMER_ID"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "ORDER_STATUS", String.class, "ORDER_STATUS"),
				new JdbcTypeField(java.sql.Types.INTEGER, "STORE_ID", Integer.class, "STORE_ID"));

		factory.setTypes(ordersType);

		setCacheStoreFactory(factory);

		QueryEntity qryEntity = new QueryEntity();

		qryEntity.setKeyType(Integer.class.getName());
		qryEntity.setValueType(Orders.class.getName());
		qryEntity.setKeyFieldName("ORDER_ID");

		Set<String> keyFields = new HashSet<>();
		keyFields.add("ORDER_ID");
		qryEntity.setKeyFields(keyFields);

		LinkedHashMap<String, String> fields = new LinkedHashMap<>();
		fields.put("ORDER_ID", "java.lang.Integer");
		fields.put("ORDER_TMS", "java.lang.Timestamp");
		fields.put("CUSTOMER_ID", "java.lang.Integer");
		fields.put("ORDER_STATUS", "java.lang.String");
		fields.put("STORE_ID", "java.lang.Integer");

		qryEntity.setFields(fields);

		setQueryEntities(Collections.singletonList(qryEntity));

	}
}