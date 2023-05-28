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

package com.liferay.docs.guestbook.model.impl;

import com.liferay.docs.guestbook.model.Pet;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Pet in entity cache.
 *
 * @author liferay
 * @generated
 */
public class PetCacheModel implements CacheModel<Pet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetCacheModel)) {
			return false;
		}

		PetCacheModel petCacheModel = (PetCacheModel)object;

		if (pid == petCacheModel.pid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{pid=");
		sb.append(pid);
		sb.append(", pname=");
		sb.append(pname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pet toEntityModel() {
		PetImpl petImpl = new PetImpl();

		petImpl.setPid(pid);

		if (pname == null) {
			petImpl.setPname("");
		}
		else {
			petImpl.setPname(pname);
		}

		petImpl.resetOriginalValues();

		return petImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pid = objectInput.readInt();
		pname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(pid);

		if (pname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pname);
		}
	}

	public int pid;
	public String pname;

}