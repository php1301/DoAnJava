/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.beans.PropertyChangeEvent;
import java.util.Objects;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Admin
 */
public class Helper {
    public static void addChangeListener(JTextComponent text, ChangeListener changeListener) {
    Objects.requireNonNull(text);
    Objects.requireNonNull(changeListener);
    DocumentListener dl = new DocumentListener() {
        private int lastChange = 0, lastNotifiedChange = 0;

        @Override
        public void insertUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changedUpdate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            lastChange++;
            SwingUtilities.invokeLater(() -> {
                if (lastNotifiedChange != lastChange) {
                    lastNotifiedChange = lastChange;
                    changeListener.stateChanged(new ChangeEvent(text));
                }
            });
        }
    };
    text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
        Document d1 = (Document)e.getOldValue();
        Document d2 = (Document)e.getNewValue();
        if (d1 != null) d1.removeDocumentListener(dl);
        if (d2 != null) d2.addDocumentListener(dl);
        dl.changedUpdate(null);
    });
    Document d = text.getDocument();
    if (d != null) d.addDocumentListener(dl);
}

}
