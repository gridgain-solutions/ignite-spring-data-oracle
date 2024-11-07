package org.gridgain.demo.springdata.service;

import org.gridgain.demo.springdata.dao.CustomersRepository;
import org.gridgain.demo.springdata.dao.InventoryRepository;
import org.gridgain.demo.springdata.dao.OrderItemsRepository;
import org.gridgain.demo.springdata.dao.OrdersRepository;
import org.gridgain.demo.springdata.dao.ProductsRepository;
import org.gridgain.demo.springdata.dao.ShipmentsRepository;
import org.gridgain.demo.springdata.dao.StoresRepository;
import org.gridgain.demo.springdata.model.Customers;
import org.gridgain.demo.springdata.model.Inventory;
import org.gridgain.demo.springdata.model.OrderItems;
import org.gridgain.demo.springdata.model.Orders;
import org.gridgain.demo.springdata.model.Products;
import org.gridgain.demo.springdata.model.Shipments;
import org.gridgain.demo.springdata.model.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CODatabaseService {

	@Autowired
	CustomersRepository customersDao;
	@Autowired
	InventoryRepository inventoryDao;
	@Autowired
	OrderItemsRepository orderItemsDao;
	@Autowired
	OrdersRepository ordersDao;
	@Autowired
	ProductsRepository productsDao;
	@Autowired
	ShipmentsRepository shipmentsDao;
	@Autowired
	StoresRepository storesDao;

	public Customers getCustomerById(int id) {
		return customersDao.findById(id).getValue();
	}

	public Inventory getInventoryById(int id) {
		return inventoryDao.findById(id).getValue();
	}

	public OrderItems getOrderItemById(int id) {
		return orderItemsDao.findById(id).getValue();
	}

	public Orders getOrdersById(int id) {
		return ordersDao.findById(id).getValue();
	}

	public Products getProductById(int id) {
		return productsDao.findById(id).getValue();
	}

	public Shipments getShipmentById(int id) {
		return shipmentsDao.findById(id).getValue();
	}

	public Stores getStoreById(int id) {
		return storesDao.findById(id).getValue();
	}

	public Boolean getAlive() {
		return true;
	}

}