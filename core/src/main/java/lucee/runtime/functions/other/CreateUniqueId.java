/**
 *
 * Copyright (c) 2014, the Railo Company Ltd. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library.  If not, see <http://www.gnu.org/licenses/>.
 * 
 **/

package lucee.runtime.functions.other;

import lucee.print;
import lucee.runtime.PageContext;
import lucee.runtime.ext.function.Function;

public final class CreateUniqueId implements Function {
	private static final long CREATION_POINT = 1624883489387L;

	private static long counter = System.currentTimeMillis() - CREATION_POINT;

	/**
	 * method to invoke the function
	 * 
	 * @param pc
	 * @return UUID String
	 */
	public static String call(PageContext pc) {
		return invoke();
	}

	public static synchronized String invoke() {
		counter++;
		if (counter < 0) counter = 1;
		return Long.toString(counter, Character.MAX_RADIX);
	}

	public static void main(String[] args) {
		print.e(invoke());
	}
}