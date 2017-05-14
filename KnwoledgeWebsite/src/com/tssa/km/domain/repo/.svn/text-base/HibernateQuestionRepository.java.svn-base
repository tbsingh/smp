package com.tssa.km.domain.repo;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tssa.km.domain.hibernate.QuestionCategory;
import com.tssa.km.domain.hibernate.QuestionExt;

public class HibernateQuestionRepository extends HibernateDaoSupport implements QuestionRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionExt> getQuestionList() {
		//return getHibernateTemplate().findByNamedQuery("question.listAll");
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from QuestionExt");
		return query.list();
	}

	@Override
	public List<QuestionCategory> getQuestionCategories() {
		//return getHibernateTemplate().findByNamedQuery("question.category.listAll");
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from QuestionCategory");
		return query.list();
	}

}
