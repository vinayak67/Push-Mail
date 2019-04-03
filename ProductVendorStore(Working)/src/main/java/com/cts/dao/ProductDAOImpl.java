package com.cts.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

import com.cts.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
@Autowired
private SessionFactory sessionFactory;

@Override
public void saveProduct(Product product) {
	
	
	sessionFactory.getCurrentSession().saveOrUpdate(product);

	
}

@Override
public List<Product> listAllProducts() {
	
	
	Session session=sessionFactory.getCurrentSession();
	CriteriaBuilder cb=session.getCriteriaBuilder();
	CriteriaQuery<Product> cq=cb.createQuery(Product.class);
	Root<Product> root =cq.from(Product.class);
	cq.select(root);
	Query query =session.createQuery(cq);
	return query.getResultList();
}

@Override
public Product getProduct(int id) {
	Session session=sessionFactory.getCurrentSession();
	Product theProduct =session.get(Product.class,id);
	return theProduct;
	
}

@Override
public void deleteProduct(int id) {

	Session session=sessionFactory.getCurrentSession();
	Product product =session.byId(Product.class).load(id);
	session.delete(product);
	
}


	


}
