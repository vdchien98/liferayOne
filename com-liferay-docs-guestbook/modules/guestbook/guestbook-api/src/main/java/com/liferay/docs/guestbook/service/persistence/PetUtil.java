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

package com.liferay.docs.guestbook.service.persistence;

import com.liferay.docs.guestbook.model.Pet;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet service. This utility wraps <code>com.liferay.docs.guestbook.service.persistence.impl.PetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see PetPersistence
 * @generated
 */
public class PetUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Pet pet) {
		getPersistence().clearCache(pet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Pet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Pet> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Pet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Pet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Pet update(Pet pet) {
		return getPersistence().update(pet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Pet update(Pet pet, ServiceContext serviceContext) {
		return getPersistence().update(pet, serviceContext);
	}

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	public static void cacheResult(Pet pet) {
		getPersistence().cacheResult(pet);
	}

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	public static void cacheResult(List<Pet> pets) {
		getPersistence().cacheResult(pets);
	}

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param pid the primary key for the new pet
	 * @return the new pet
	 */
	public static Pet create(int pid) {
		return getPersistence().create(pid);
	}

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet remove(int pid)
		throws com.liferay.docs.guestbook.exception.NoSuchPetException {

		return getPersistence().remove(pid);
	}

	public static Pet updateImpl(Pet pet) {
		return getPersistence().updateImpl(pet);
	}

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public static Pet findByPrimaryKey(int pid)
		throws com.liferay.docs.guestbook.exception.NoSuchPetException {

		return getPersistence().findByPrimaryKey(pid);
	}

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	public static Pet fetchByPrimaryKey(int pid) {
		return getPersistence().fetchByPrimaryKey(pid);
	}

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	public static List<Pet> findAll() {
		return getPersistence().findAll();
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
	public static List<Pet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Pet> findAll(
		int start, int end, OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetPersistence _persistence;

}