/*
 * Copyright (C) 2007-2010 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package ua.pocketbook.fb2viewer.zlibrary.core.optionEntries;

import java.util.*;

import ua.pocketbook.fb2viewer.zlibrary.core.dialogs.ZLOptionEntry;
import ua.pocketbook.fb2viewer.zlibrary.core.options.ZLBooleanOption;
import ua.pocketbook.fb2viewer.zlibrary.core.util.*;

public class ZLToggleBooleanOptionEntry extends ZLSimpleBooleanOptionEntry {
	private final ArrayList myDependentEntries = new ArrayList();
	
	public ZLToggleBooleanOptionEntry(ZLBooleanOption option) {
		super(option);
	}

	public void addDependentEntry(ZLOptionEntry dependent) {
		myDependentEntries.add(dependent);
	}
	
	public void onStateChanged(boolean state) {
		final int size = myDependentEntries.size();
		for (int i = 0; i < size; i++) {
			((ZLOptionEntry)myDependentEntries.get(i)).setVisible(state);
		}
	}

	public void onReset() {
		onStateChanged(initialState());
	}
}
