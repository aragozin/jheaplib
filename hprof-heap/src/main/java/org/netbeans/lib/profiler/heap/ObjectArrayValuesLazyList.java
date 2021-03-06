/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.lib.profiler.heap;

import java.util.AbstractList;


/**
 *
 * @author Jiri Sedlacek
 */
class ObjectArrayValuesLazyList extends AbstractList<ArrayItemValue> {
    //~ Instance fields ----------------------------------------------------------------------------------------------------------

    private final ClassDump dumpClass;
    private final int length;
    private final long offset;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    ObjectArrayValuesLazyList(ClassDump dump, int len, long off) {
        dumpClass = dump;
        length = len;
        offset = off;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    public ArrayItemValue get(int index) {
        return new HprofArrayValue(dumpClass, offset, index);
    }

    public int size() {
        return length;
    }
}
