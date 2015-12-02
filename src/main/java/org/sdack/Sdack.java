//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'sdack' project.
// Copyright 2015 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//	  http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package org.sdack;

import de.esoco.entity.Entity;
import de.esoco.entity.EntityManager;

import de.esoco.history.HistoryManager;
import de.esoco.history.HistoryRecord;

import de.esoco.storage.StorageDefinition;
import de.esoco.storage.StorageManager;

import java.util.Collection;

import org.obrel.core.ObjectRelations;


/********************************************************************
 * This is a central class for SDACK that contains static methods that perform
 * some typical framework initializations and operations.
 *
 * @author eso
 */
public class Sdack
{
	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Private, only static use.
	 */
	private Sdack()
	{
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * This method invokes several framework initializations.
	 *
	 * @param rDefaultStorage The default storage to be used by the application
	 *                        or NULL for none
	 * @param rEntityTypes    A collection of the entity classes used by the
	 *                        application or NULL for none
	 */
	public static void init(
		StorageDefinition					rDefaultStorage,
		Collection<Class<? extends Entity>> rEntityTypes)
	{
		ObjectRelations.init();

		if (rDefaultStorage != null)
		{
			StorageManager.setDefaultStorage(rDefaultStorage);
		}

		if (rEntityTypes.contains(HistoryRecord.class))
		{
			HistoryManager.init();
		}

		EntityManager.init(rEntityTypes);
	}
}
