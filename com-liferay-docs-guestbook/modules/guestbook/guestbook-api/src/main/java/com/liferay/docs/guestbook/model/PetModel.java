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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Pet service. Represents a row in the &quot;GB_Pet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.docs.guestbook.model.impl.PetModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.docs.guestbook.model.impl.PetImpl</code>.
 * </p>
 *
 * @author liferay
 * @see Pet
 * @generated
 */
@ProviderType
public interface PetModel extends BaseModel<Pet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pet model instance should use the {@link Pet} interface instead.
	 */

	/**
	 * Returns the primary key of this pet.
	 *
	 * @return the primary key of this pet
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this pet.
	 *
	 * @param primaryKey the primary key of this pet
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the pid of this pet.
	 *
	 * @return the pid of this pet
	 */
	public int getPid();

	/**
	 * Sets the pid of this pet.
	 *
	 * @param pid the pid of this pet
	 */
	public void setPid(int pid);

	/**
	 * Returns the pname of this pet.
	 *
	 * @return the pname of this pet
	 */
	@AutoEscape
	public String getPname();

	/**
	 * Sets the pname of this pet.
	 *
	 * @param pname the pname of this pet
	 */
	public void setPname(String pname);

	@Override
	public Pet cloneWithOriginalValues();

}