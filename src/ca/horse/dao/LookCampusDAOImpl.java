package ca.horse.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.horse.core.data.LocationSearchCriteria;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<LookCampus> search(LocationSearchCriteria c) {
		DetachedCriteria dc = DetachedCriteria.forClass(LookCampus.class, "lc");
		if(c.getCd() != null) {
			dc.add(Restrictions.eq("lc.cd", c.getCd()));
		}
		
		if(c.getName() != null) {
			dc.add(Restrictions.ilike("lc.name", getLikeText(c.getName())));
		}
		
		if(c.getAddress() != null) {
			dc.add(Restrictions.ilike("lc.address", getLikeText(c.getAddress())));
		}
		
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return (List<LookCampus>) criteria.list();
	}
	
	
	
	private String getLikeText(String text) {
		StringBuilder sb = new StringBuilder();
		return sb.append("%").append(text).append("%").toString();
	}

	@Override
	public LookCampus save(LookCampus lookCampus) {
		return (LookCampus) getSession().merge(lookCampus);
	}

}
