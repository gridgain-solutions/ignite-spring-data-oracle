package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.INVENTORY_CACHE;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;


import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class InventoryCacheConfiguration<K, V> extends CacheConfiguration<Integer, Inventory> {
	private static final long serialVersionUID = 0L;

	public InventoryCacheConfiguration() {
		setName(INVENTORY_CACHE);
		setIndexedTypes(Integer.class, Inventory.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, Inventory> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType inventoryType = new JdbcType();
		inventoryType.setDatabaseSchema(SCHEMA);
		inventoryType.setDatabaseTable("INVENTORY");
		inventoryType.setCacheName(INVENTORY_CACHE);
		inventoryType.setKeyType(Integer.class);
		inventoryType.setValueType(Inventory.class);

		inventoryType
				.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "INVENTORY_ID", Integer.class, "INVENTORY_ID"));

		inventoryType.setValueFields(
				new JdbcTypeField(java.sql.Types.INTEGER, "INVENTORY_ID", Integer.class, "INVENTORY_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "STORE_ID", Integer.class, "STORE_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "PRODUCT_ID", Integer.class, "PRODUCT_ID"),
				new JdbcTypeField(java.sql.Types.INTEGER, "PRODUCT_INVENTORY", Integer.class, "PRODUCT_INVENTORY"));

		factory.setTypes(inventoryType);

		setCacheStoreFactory(factory);
	}
}