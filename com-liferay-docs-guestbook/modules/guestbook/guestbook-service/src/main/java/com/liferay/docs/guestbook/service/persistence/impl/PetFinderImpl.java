package com.liferay.docs.guestbook.service.persistence.impl;

import com.liferay.docs.guestbook.model.Pet;
import com.liferay.docs.guestbook.model.impl.PetImpl;
import com.liferay.docs.guestbook.service.persistence.PetFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = PetFinder.class)
public class PetFinderImpl extends PetFinderBaseImpl implements PetFinder {
	@Reference
	private CustomSQL _customSQL;

	public List<Pet> getPetsByName(String pName) {
		System.out.println("Inside custom sql");
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), "getPetsByName");
			System.out.println("Query==>" + sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Pet", PetImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(pName);
			return (List<Pet>) sqlQuery.list();
		} catch (Exception e) {

		} finally {
			closeSession(session);
		}
		return null;
	}
}