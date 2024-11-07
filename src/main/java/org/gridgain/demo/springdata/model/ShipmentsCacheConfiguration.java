package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;
import static org.gridgain.demo.springdata.config.Constants.SHIPMENTS_CACHE;

import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class ShipmentsCacheConfiguration<K, V> extends CacheConfiguration<Integer, Shipments> {
	private static final long serialVersionUID = 0L;

	public ShipmentsCacheConfiguration() {
		setName(SHIPMENTS_CACHE);
		setIndexedTypes(Integer.class, Shipments.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, Shipments> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType shipmentsType = new JdbcType();
		shipmentsType.setDatabaseSchema(SCHEMA);
		shipmentsType.setDatabaseTable("SHIPMENTS");
		shipmentsType.setCacheName(SHIPMENTS_CACHE);
		shipmentsType.setKeyType(Integer.class);
		shipmentsType.setValueType(Shipments.class);

		shipmentsType
				.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "SHIPMENT_ID", Integer.class, "SHIPMENT_ID"));

		shipmentsType.setValueFields(
				new JdbcTypeField(java.sql.Types.INTEGER, "SHIPMENT_ID", Integer.class, "SHIPMENT_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "STORE_ID", Integer.class, "STORE_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "CUSTOMER_ID", Integer.class, "CUSTOMER_ID"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "DELIVERY_ADDRESS", String.class, "DELIVERY_ADDRESS"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "SHIPMENT_STATUS", String.class, "SHIPMENT_STATUS"));

		factory.setTypes(shipmentsType);

		setCacheStoreFactory(factory);
	}
}