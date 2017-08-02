package ca.horse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.horse.core.data.LookCampus;

@Repository
@Transactional//transactions start in the dao layer
public class LookCampusDAOImpl implements LookCampusDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public LookCampus getLookCampusById(int id) {
		return getSession().get(LookCampus.class, id);
	}

}
