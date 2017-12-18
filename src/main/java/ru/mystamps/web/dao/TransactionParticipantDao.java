/*
 * Copyright (C) 2009-2017 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.dao;

import java.util.List;

import ru.mystamps.web.dao.dto.AddParticipantDbDto;
import ru.mystamps.web.dao.dto.EntityWithIdDto;
import ru.mystamps.web.dao.dto.EntityWithParentDto;

public interface TransactionParticipantDao {
	void add(AddParticipantDbDto participant);
	List<EntityWithParentDto> findBuyersWithParents();
	List<EntityWithParentDto> findSellersWithParents();
	List<EntityWithIdDto> findAllGroups();
}
