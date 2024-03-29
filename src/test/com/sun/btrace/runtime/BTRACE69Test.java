/*
 * Copyright 2008-2010 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package com.sun.btrace.runtime;

import support.InstrumentorTestBase;
import org.junit.Test;

/**
 *
 * @author Jaroslav Bachorik
 */
public class BTRACE69Test extends InstrumentorTestBase {
    @Test
    public void bytecodeValidation() throws Exception {
        originalBC = loadTargetClass("OnMethodTest");
        transform("issues/BTRACE69");
        checkTransformation("TRYCATCHBLOCK L4 L5 L5 java/lang/Throwable\n" +
                            "TRYCATCHBLOCK L4 L6 L6 java/lang/Throwable\n" +
                            "L7\nLINENUMBER 108 L7\nDUP\nASTORE 2\nALOAD 2\n" +
                            "INVOKESTATIC resources/OnMethodTest.$btrace$traces$issues$BTRACE69$onSyncEntry (Ljava/lang/Object;)V\n" +
                            "L8\nLINENUMBER 110 L8\nDUP\nASTORE 3\nALOAD 3\n" +
                            "INVOKESTATIC resources/OnMethodTest.$btrace$traces$issues$BTRACE69$onSyncExit (Ljava/lang/Object;)V\n" +
                            "GOTO L4\nASTORE 4\nDUP\n" +
                            "ASTORE 5\nALOAD 5\n" +
                            "INVOKESTATIC resources/OnMethodTest.$btrace$traces$issues$BTRACE69$onSyncExit (Ljava/lang/Object;)V\n" +
                            "ALOAD 4\nATHROW\nL4\nLINENUMBER 111 L4\nRETURN\nL5\nATHROW");
    }
}
