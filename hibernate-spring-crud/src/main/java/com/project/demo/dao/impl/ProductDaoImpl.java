package com.project.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.dao.ProductDao;
import com.project.demo.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOrModifyProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.byId(Product.class).load(id);
		session.delete(product);
	}

	@Override
	public Product getProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

}
