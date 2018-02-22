/*
 * Copyright (c) 2001-2009 JGoodies Karsten Lentzsch. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of JGoodies Karsten Lentzsch nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jgoodies.looks.plastic;

import javax.swing.plaf.basic.BasicComboBoxEditor;

import com.jgoodies.looks.common.ComboBoxEditorTextField;

/**
 * The default editor for editable combo boxes in the
 * JGoodies Plastic Look&amp;Feel. <p>
 *
 * It differs from {@link javax.swing.plaf.metal.MetalComboBoxEditor} in that
 * the border is quite the same as for text fields:
 * a compound border with an inner <code>MarginBorder</code>.
 *
 * @author Karsten Lentzsch
 * @version $Revision: 1.1 $
 */
class PlasticComboBoxEditor extends BasicComboBoxEditor {

    PlasticComboBoxEditor(boolean isTableCellEditor) {
        editor = new ComboBoxEditorTextField(isTableCellEditor);
    }

    public void setItem(Object item) {
        super.setItem(item);
        editor.selectAll();
    }


    /**
     * A subclass of BasicComboBoxEditor that implements UIResource.
     * BasicComboBoxEditor and PlasticComboBoxEditor don't implement UIResource
     * directly so that applications can safely override the cellRenderer
     * property with BasicListCellRenderer subclasses.
     */
    static final class UIResource extends PlasticComboBoxEditor implements
            javax.swing.plaf.UIResource {
        // Just an implementation of UIResource

        UIResource(boolean isTableCellEditor) {
            super(isTableCellEditor);
        }
    }


}