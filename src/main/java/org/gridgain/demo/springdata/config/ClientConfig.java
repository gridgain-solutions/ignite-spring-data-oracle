package org.gridgain.demo.springdata.config;

import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.DeploymentMode;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteConfigurer;
import org.gridgain.demo.springdata.model.Customers;
import org.gridgain.demo.springdata.model.CustomersCacheConfiguration;
import org.gridgain.demo.springdata.model.Inventory;
import org.gridgain.demo.springdata.model.InventoryCacheConfiguration;
import org.gridgain.demo.springdata.model.OrderItems;
import org.gridgain.demo.springdata.model.OrderItemsCacheConfiguration;
import org.gridgain.demo.springdata.model.Orders;
import org.gridgain.demo.springdata.model.OrdersCacheConfiguration;
import org.gridgain.demo.springdata.model.Products;
import org.gridgain.demo.springdata.model.ProductsCacheConfiguration;
import org.gridgain.demo.springdata.model.Shipments;
import org.gridgain.demo.springdata.model.ShipmentsCacheConfiguration;
import org.gridgain.demo.springdata.model.Stores;
import org.gridgain.demo.springdata.model.StoresCacheConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("igniteCfg")
@EnableIgniteRepositories
public class ClientConfig {

	@Bean(name = "igniteInstance")
	public Ignite igniteInstance(Ignite ignite) {
		System.err.println("Create caches");
		
		System.err.println("Load Customers cache");
		ignite.getOrCreateCache(new CustomersCacheConfiguration<Integer, Customers>()).loadCache(null);
		ignite.getOrCreateCache(new InventoryCacheConfiguration<Integer, Inventory>()).loadCache(null);
		ignite.getOrCreateCache(new OrderItemsCacheConfiguration<Integer, OrderItems>()).loadCache(null);
		ignite.getOrCreateCache(new OrdersCacheConfiguration<Integer, Orders>()).loadCache(null);
		ignite.getOrCreateCache(new ProductsCacheConfiguration<Integer, Products>()).loadCache(null);
		ignite.getOrCreateCache(new ShipmentsCacheConfiguration<Integer, Shipments>()).loadCache(null);
		ignite.getOrCreateCache(new StoresCacheConfiguration<Integer, Stores>()).loadCache(null);

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

			// Enabling peer-class loading feature.
			igniteConfiguration.setPeerClassLoadingEnabled(true);
			igniteConfiguration.setDeploymentMode(DeploymentMode.CONTINUOUS);
		};
	}
}