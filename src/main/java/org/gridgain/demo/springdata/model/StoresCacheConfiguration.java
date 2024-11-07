package org.gridgain.demo.springdata.model;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.gridgain.demo.springdata.config.Constants.SCHEMA;
import static org.gridgain.demo.springdata.config.Constants.STORES_CACHE;

import java.sql.Date;

import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.OracleDialect;
import org.apache.ignite.configuration.CacheConfiguration;

public class StoresCacheConfiguration<K, V> extends CacheConfiguration<Integer, Stores> {
	private static final long serialVersionUID = 0L;

	public StoresCacheConfiguration() {
		setName(STORES_CACHE);
		setIndexedTypes(Integer.class, Stores.class);
		setCacheMode(PARTITIONED);
		setSqlSchema(SCHEMA);
		setBackups(1);
		setReadThrough(true);
		setWriteThrough(true);

		CacheJdbcPojoStoreFactory<Integer, Stores> factory = new CacheJdbcPojoStoreFactory<>();
		factory.setDialect(new OracleDialect());
		factory.setDataSourceBean("oracleDataSource");

		JdbcType storesType = new JdbcType();
		storesType.setDatabaseSchema(SCHEMA);
		storesType.setDatabaseTable("STORES");
		storesType.setCacheName(STORES_CACHE);
		storesType.setKeyType(Integer.class);
		storesType.setValueType(Stores.class);

		storesType.setKeyFields(new JdbcTypeField(java.sql.Types.INTEGER, "STORE_ID", Integer.class, "STORE_ID"));

		storesType.setValueFields(new JdbcTypeField(java.sql.Types.INTEGER, "STORE_ID", Integer.class, "STORE_ID"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "STORE_NAME", String.class, "STORE_NAME"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "WEB_ADDRESS", String.class, "WEB_ADDRESS"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "PHYSICAL_ADDRESS", String.class, "PHYSICAL_ADDRESS"),
				new JdbcTypeField(java.sql.Types.INTEGER, "LATITUDE", Integer.class, "LATITUDE"),
				new JdbcTypeField(java.sql.Types.INTEGER, "LONGITUDE", Integer.class, "LONGITUDE"),
				new JdbcTypeField(java.sql.Types.BLOB, "LOGO", Object.class, "LOGO"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "LOGO_MIME_TYPE", String.class, "LOGO_MIME_TYPE"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "LOGO_FILENAME", String.class, "LOGO_FILENAME"),
				new JdbcTypeField(java.sql.Types.VARCHAR, "LOGO_CHARSET", String.class, "LOGO_CHARSET"),
				new JdbcTypeField(java.sql.Types.DATE, "LOGO_LAST_UPDATED", Date.class, "LOGO_LAST_UPDATED"));

		factory.setTypes(storesType);

		setCacheStoreFactory(factory);
	}
}