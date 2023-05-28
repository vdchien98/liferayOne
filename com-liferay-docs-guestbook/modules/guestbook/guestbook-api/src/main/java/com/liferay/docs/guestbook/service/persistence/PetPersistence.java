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

import com.liferay.docs.guestbook.exception.NoSuchPetException;
import com.liferay.docs.guestbook.model.Pet;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see PetUtil
 * @generated
 */
@ProviderType
public interface PetPersistence extends BasePersistence<Pet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetUtil} to access the pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pet in the entity cache if it is enabled.
	 *
	 * @param pet the pet
	 */
	public void cacheResult(Pet pet);

	/**
	 * Caches the pets in the entity cache if it is enabled.
	 *
	 * @param pets the pets
	 */
	public void cacheResult(java.util.List<Pet> pets);

	/**
	 * Creates a new pet with the primary key. Does not add the pet to the database.
	 *
	 * @param pid the primary key for the new pet
	 * @return the new pet
	 */
	public Pet create(int pid);

	/**
	 * Removes the pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet that was removed
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet remove(int pid) throws NoSuchPetException;

	public Pet updateImpl(Pet pet);

	/**
	 * Returns the pet with the primary key or throws a <code>NoSuchPetException</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet
	 * @throws NoSuchPetException if a pet with the primary key could not be found
	 */
	public Pet findByPrimaryKey(int pid) throws NoSuchPetException;

	/**
	 * Returns the pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pid the primary key of the pet
	 * @return the pet, or <code>null</code> if a pet with the primary key could not be found
	 */
	public Pet fetchByPrimaryKey(int pid);

	/**
	 * Returns all the pets.
	 *
	 * @return the pets
	 */
	public java.util.List<Pet> findAll();

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
	public java.util.List<Pet> findAll(int start, int end);

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
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet>
			orderByComparator);

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
	public java.util.List<Pet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pet> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pets.
	 *
	 * @return the number of pets
	 */
	public int countAll();

}