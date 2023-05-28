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

package com.liferay.docs.guestbook.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Pet}.
 * </p>
 *
 * @author liferay
 * @see Pet
 * @generated
 */
public class PetWrapper
	extends BaseModelWrapper<Pet> implements ModelWrapper<Pet>, Pet {

	public PetWrapper(Pet pet) {
		super(pet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pid", getPid());
		attributes.put("pname", getPname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer pid = (Integer)attributes.get("pid");

		if (pid != null) {
			setPid(pid);
		}

		String pname = (String)attributes.get("pname");

		if (pname != null) {
			setPname(pname);
		}
	}

	@Override
	public Pet cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the pid of this pet.
	 *
	 * @return the pid of this pet
	 */
	@Override
	public int getPid() {
		return model.getPid();
	}

	/**
	 * Returns the pname of this pet.
	 *
	 * @return the pname of this pet
	 */
	@Override
	public String getPname() {
		return model.getPname();
	}

	/**
	 * Returns the primary key of this pet.
	 *
	 * @return the primary key of this pet
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the pid of this pet.
	 *
	 * @param pid the pid of this pet
	 */
	@Override
	public void setPid(int pid) {
		model.setPid(pid);
	}

	/**
	 * Sets the pname of this pet.
	 *
	 * @param pname the pname of this pet
	 */
	@Override
	public void setPname(String pname) {
		model.setPname(pname);
	}

	/**
	 * Sets the primary key of this pet.
	 *
	 * @param primaryKey the primary key of this pet
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected PetWrapper wrap(Pet pet) {
		return new PetWrapper(pet);
	}

}