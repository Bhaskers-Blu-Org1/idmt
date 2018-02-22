/*
 * Copyright 2008 Ayman Al-Sairafi ayman.alsairafi@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 *       at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jsyntaxpane.actions;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Ayman Al-Sairafi
 */
public class ComboCompletionDialog extends javax.swing.JDialog {

    /**
     * The result returned to the caller
     */
    private String result = null;
    /**
     * The current filter, to avoid refiltering the items
     */
    public String escapeChars = ";(= \t\n";
    public String[] items;

    /** Creates new form ComboCompletionDialog
     * @param parent
     * @param modal
     * @param items
     */
    public ComboCompletionDialog(java.awt.Frame parent, boolean modal,
            String[] items) {
        super(parent, modal);
        initComponents();
        this.items = items;
        jLstItems.setListData(items);
        jTxtItem.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                refilterList();
            }

            public void removeUpdate(DocumentEvent e) {
                refilterList();
            }

            public void changedUpdate(DocumentEvent e) {
                refilterList();
            }
        });
        // This will allow the textfield to receive TAB keys
        jTxtItem.setFocusTraversalKeysEnabled(false);
    }

    public void setFonts(Font font) {
        jTxtItem.setFont(font);
        jLstItems.setFont(font);
        doLayout();
    }

    public void setText(String abbrev) {
        jTxtItem.setText(abbrev);
    }

    private void refilterList() {
        String prefix = jTxtItem.getText();
        Vector<String> filtered = new Vector<String>();
        Object selected = jLstItems.getSelectedValue();
        for (String s : items) {
            if (s.startsWith(prefix)) {
                filtered.add(s);
            }
        }
        jLstItems.setListData(filtered);
        if (selected != null) {
            jLstItems.setSelectedValue(selected, true);
        } else {
            jLstItems.setSelectedIndex(0);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstItems = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        jTxtItem.setBorder(null);
        jTxtItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtItemKeyPressed(evt);
            }
        });

        jLstItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jLstItems.setFocusable(false);
        jScrollPane1.setViewportView(jLstItems);

        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTxtItem, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTxtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );*/

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtItemKeyPressed

        int i = jLstItems.getSelectedIndex();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                result = jTxtItem.getText();
                setVisible(false);
                return;
            case KeyEvent.VK_DOWN:
                if (i < jLstItems.getModel().getSize() - 1) {
                    i++;
                }
                jLstItems.setSelectedIndex(i);
                jLstItems.ensureIndexIsVisible(i);
                break;
            case KeyEvent.VK_UP:
                if (i > 0) {
                    i--;
                }
                jLstItems.setSelectedIndex(i);
                jLstItems.ensureIndexIsVisible(i);
                break;
        }

        if (escapeChars.indexOf(evt.getKeyChar()) >= 0) {
            if (jLstItems.getSelectedIndex() >= 0) {
                result = jLstItems.getSelectedValue().toString();
            } else {
                result = jTxtItem.getText();
            }
            char pressed = evt.getKeyChar();
            // we need to just accept ENTER, and replace the tab with a single
            // space
            if (pressed != '\n') {
                result += (pressed == '\t') ? ' ' : pressed;
            }
            setVisible(false);
        }
    }//GEN-LAST:event_jTxtItemKeyPressed

    /**
     * Gets the selected text shown on the dialog.
     * @return the selected text, or empty string if nothing is selected
     */
    public String getResult() {
        return result == null ? "" : result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jLstItems;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtItem;
    // End of variables declaration//GEN-END:variables
}
