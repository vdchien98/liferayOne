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

package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.model.Pet;
import com.liferay.docs.guestbook.service.base.PetLocalServiceBaseImpl;
import com.liferay.docs.guestbook.service.persistence.PetFinder;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	property = "model.class.name=com.liferay.docs.guestbook.model.Pet",
	service = AopService.class
)
public class PetLocalServiceImpl extends PetLocalServiceBaseImpl {
	public List<Pet> getPetsByName(String pName){
		return getPetsByName(pName);
	}
}