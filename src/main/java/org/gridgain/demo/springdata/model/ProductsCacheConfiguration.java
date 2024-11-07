package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.PRODUCTS_CACHE;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;

import java.sql.Date;

import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class ProductsCacheConfiguration<K, V> extends CacheConfiguration<Integer, Products> {
	private static final long serialVersionUID = 0L;

	public ProductsCacheConfiguration() {
		setName(PRODUCTS_CACHE);
		setIndexedTypes(Integer.class, Products.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, Products> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType productsType = new JdbcType();
		productsType.setDatabaseSchema(SCHEMA);
		productsType.setDatabaseTable("PRODUCTS");
		productsType.setCacheName(PRODUCTS_CACHE);
		productsType.setKeyType(Integer.class);
		productsType.setValueType(Products.class);

		productsType.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "PRODUCT_ID", Integer.class, "PRODUCT_ID"));

		productsType.setValueFields(
				new JdbcTypeField(java.sql.Types.INTEGER, "PRODUCT_ID", Integer.class, "PRODUCT_ID"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "PRODUCT_NAME", String.class, "PRODUCT_NAME"),
				new JdbcTypeField(java.sql.Types.INTEGER, "UNIT_PRICE", Integer.class, "UNIT_PRICE"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "IMAGE_MIME_TYPE", String.class, "IMAGE_MIME_TYPE"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "IMAGE_FILENAME", String.class, "IMAGE_FILENAME"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "IMAGE_CHARSET", String.class, "IMAGE_CHARSET"),
				new JdbcTypeField(java.sql.Types.DATE, "IMAGE_LAST_UPDATED", Date.class, "IMAGE_LAST_UPDATED"));

		factory.setTypes(productsType);

		setCacheStoreFactory(factory);
	}
}