/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.guestbook.service.persistence.impl;

import com.liferay.docs.guestbook.exception.NoSuchPetException;
import com.liferay.docs.guestbook.model.Pet;
import com.liferay.docs.guestbook.model.PetTable;
import com.liferay.docs.guestbook.model.impl.PetImpl;
import com.liferay.docs.guestbook.model.impl.PetModelImpl;
import com.liferay.docs.guestbook.service.persistence.PetPersistence;
import com.liferay.docs.guestbook.service.persistence.PetUtil;
import com.liferay.docs.guestbook.service.persistence.impl.constants.GBPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @generated
 */
@Component(service = {PetPersistence.class, BasePersistence.class})
public class PetPersistenceImpl
	extends BasePersistenceImpl<Pet> implements PetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PetUtil</code> to access the pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PetPersistenceImpl() {
		setModelClass(Pet.class);

		setModelImplClass(PetImpl.class);
		setModelPKClass(int.class);

		setTable(PetTable.INSTANCE);
	}

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	@Override
	public void cacheResult(Pet pet) {
		entityCache.putResult(PetImpl.class, pet.getPrimaryKey(), pet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	@Override
	public void cacheResult(List<Pet> pets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Pet pet : pets) {
			if (entityCache.getResult(PetImpl.class, pet.getPrimaryKey()) ==
					null) {

				cacheResult(pet);
			}
		}
	}

	/**
	 * Clears the cache for all pets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PetImpl.class);

		finderCache.clearCache(PetImpl.class);
	}

	/**
	 * Clears the cache for the pet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pet pet) {
		entityCache.removeResult(PetImpl.class, pet);
	}

	@Override
	public void clearCache(List<Pet> pets) {
		for (Pet pet : pets) {
			entityCache.removeResult(PetImpl.class, pet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PetImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PetImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param pid the primary key for the new pet
	 * @return the new pet
	 */
	@Override
	public Pet create(int pid) {
		Pet pet = new PetImpl();

		pet.setNew(true);
		pet.setPrimaryKey(pid);

		return pet;
	}

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	@Override
	public Pet remove(int pid) throws NoSuchPetException {
		return remove((Serializable)pid);
	}

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	@Override
	public Pet remove(Serializable primaryKey) throws NoSuchPetException {
		Session session = null;

		try {
			session = openSession();

			Pet pet = (Pet)session.get(PetImpl.class, primaryKey);

			if (pet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pet);
		}
		catch (NoSuchPetException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Pet removeImpl(Pet pet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pet)) {
				pet = (Pet)session.get(PetImpl.class, pet.getPrimaryKeyObj());
			}

			if (pet != null) {
				session.delete(pet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pet != null) {
			clearCache(pet);
		}

		return pet;
	}

	@Override
	public Pet updateImpl(Pet pet) {
		boolean isNew = pet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pet);
			}
			else {
				pet = (Pet)session.merge(pet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PetImpl.class, pet, false, true);

		if (isNew) {
			pet.setNew(false);
		}

		pet.resetOriginalValues();

		return pet;
	}

	/**
	 * Returns the pet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	@Override
	public Pet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPetException {

		Pet pet = fetchByPrimaryKey(primaryKey);

		if (pet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pet;
	}

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	@Override
	public Pet findByPrimaryKey(int pid) throws NoSuchPetException {
		return findByPrimaryKey((Serializable)pid);
	}

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	@Override
	public Pet fetchByPrimaryKey(int pid) {
		return fetchByPrimaryKey((Serializable)pid);
	}

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	@Override
	public List<Pet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @return the range of pets
	 */
	@Override
	public List<Pet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pets
	 */
	@Override
	public List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pets
	 * @param end the upper bound of the range of pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pets
	 */
	@Override
	public List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Pet> list = null;

		if (useFinderCache) {
			list = (List<Pet>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PET;

				sql = sql.concat(PetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Pet>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Pet pet : findAll()) {
			remove(pet);
		}
	}

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PET);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "pid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pet persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setPetUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPetUtilPersistence(null);

		entityCache.removeCache(PetImpl.class.getName());
	}

	private void _setPetUtilPersistence(PetPersistence petPersistence) {
		try {
			Field field = PetUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, petPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PET = "SELECT pet FROM Pet pet";

	private static final String _SQL_COUNT_PET =
		"SELECT COUNT(pet) FROM Pet pet";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Pet exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PetPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PetModelArgumentsResolver _petModelArgumentsResolver;

}