/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.jface.bindings.keys.formatting;



/**
 * <p>
 * A cache for formatters. It keeps a few instances of pre-defined instances of
 * <code>IKeyFormatter</code> available for use. It also allows the default
 * formatter to be changed.
 * </p>
 * <p>
 * <em>EXPERIMENTAL</em>. The commands architecture is currently under
 * development for Eclipse 3.1. This class -- its existence, its name and its
 * methods -- are in flux. Do not use this class yet.
 * </p>
 * 
 * @since 3.1
 * @see org.eclipse.jface.bindings.keys.formatting.IKeyFormatter
 */
public final class KeyFormatterFactory {

    /**
     * The formatter that renders multiple key stroke bindings in a more compact
     * form.
     */
    private static final IKeyFormatter COMPACT_KEY_FORMATTER = new CompactKeyFormatter();

    /**
     * The formatter that renders key bindings in a platform-dependent manner.
     */
    private static final IKeyFormatter FORMAL_KEY_FORMATTER = new FormalKeyFormatter();

    /**
     * The formatter that renders key bindings in a form similar to XEmacs
     */
    private static final IKeyFormatter EMACS_KEY_FORMATTER = new EmacsKeyFormatter();

    /**
     * The default formatter. This is normally the formal key formatter, but can
     * be changed by users of this API.
     */
    private static IKeyFormatter defaultKeyFormatter = FORMAL_KEY_FORMATTER;

    /**
     * Provides an instance of <code>CompactKeyFormatter</code>.
     * 
     * @return The compact formatter; never <code>null</code>.
     */
    public static final IKeyFormatter getCompactKeyFormatter() {
        return COMPACT_KEY_FORMATTER;
    }

    /**
     * An accessor for the current default key formatter.
     * 
     * @return The default formatter; never <code>null</code>.
     */
    public static final IKeyFormatter getDefault() {
        return defaultKeyFormatter;
    }

    /**
     * Provides an instance of <code>EmacsKeyFormatter</code>.
     * 
     * @return The Xemacs formatter; never <code>null</code>.
     */
    public static final IKeyFormatter getEmacsKeyFormatter() {
        return EMACS_KEY_FORMATTER;
    }

    /**
     * Provides an instance of <code>FormalKeyFormatter</code>.
     * 
     * @return The formal formatter; never <code>null</code>.
     */
    public static final IKeyFormatter getFormalKeyFormatter() {
        return FORMAL_KEY_FORMATTER;
    }

    /**
     * Sets the default key formatter.
     * 
     * @param defaultKeyFormatter
     *            the default key formatter. Must not be <code>null</code>.
     */
    public static final void setDefault(final IKeyFormatter defaultKeyFormatter) {
        if (defaultKeyFormatter == null)
            throw new NullPointerException();

        KeyFormatterFactory.defaultKeyFormatter = defaultKeyFormatter;
    }

    /**
     * This class should not be instantiated.
     */
    private KeyFormatterFactory() {
        // Not to be constructred.
    }
}
