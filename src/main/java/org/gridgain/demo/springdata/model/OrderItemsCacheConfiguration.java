package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.ORDER_ITEMS_CACHE;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;

import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class OrderItemsCacheConfiguration<K, V> extends CacheConfiguration<Integer, OrderItems> {
	private static final long serialVersionUID = 0L;

	public OrderItemsCacheConfiguration() {
		setName(ORDER_ITEMS_CACHE);
		setIndexedTypes(Integer.class, OrderItems.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, OrderItems> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType orderItemsType = new JdbcType();
		orderItemsType.setDatabaseSchema(SCHEMA);
		orderItemsType.setDatabaseTable("ORDER_ITEMS");
		orderItemsType.setCacheName(ORDER_ITEMS_CACHE);
		orderItemsType.setKeyType(Integer.class);
		orderItemsType.setValueType(OrderItems.class);

		orderItemsType.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "ORDER_ID", Integer.class, "ORDER_ID"));

		orderItemsType.setValueFields(new JdbcTypeField(java.sql.Types.INTEGER, "ORDER_ID", Integer.class, "ORDER_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "LINE_ITEM_ID", Integer.class, "LINE_ITEM_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "PRODUCT_ID", Integer.class, "PRODUCT_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "UNIT_PRICE", Integer.class, "UNIT_PRICE"),
				new JdbcTypeField(java.sql.Types.INTEGER, "QUANTITY", Integer.class, "QUANTITY"),
				new JdbcTypeField(java.sql.Types.INTEGER, "SHIPMENT_ID", Integer.class, "SHIPMENT_ID"));

		factory.setTypes(orderItemsType);

		setCacheStoreFactory(factory);
	}
}