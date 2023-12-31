/**
 * Copyright (c) 2013-2016 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 */
package fr.flowarg.materialdesignfontfx;

import javafx.scene.text.Font;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class MaterialDesignIconView<TYPE extends Enum<TYPE> & MaterialDesignIconGlyphs<TYPE>> extends GlyphIcon<TYPE> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/materialdesignicons/materialdesignicons-webfont.ttf";

    static {
        try {
            Font.loadFont(MaterialDesignIconView.class.getResource(TTF_PATH).openStream(), 10.0d);
        } catch (IOException ex) {
            Logger.getLogger(MaterialDesignIconView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private final TYPE icon;

    @SuppressWarnings("unchecked")
    public MaterialDesignIconView(MaterialDesignIconGlyphs<?> icon)
    {
        this((TYPE)icon);
    }

    @SuppressWarnings("unchecked")
    public MaterialDesignIconView(MaterialDesignIconGlyphs<?> icon, String size)
    {
        this((TYPE)icon, size);
    }

    public MaterialDesignIconView(TYPE icon) {
        this(icon, GlyphIcon.DEFAULT_FONT_SIZE);
    }

    public MaterialDesignIconView(TYPE icon, String size) {
        super(icon.getDeclaringClass(), false);
        this.icon = icon;
        this.initProperties();
        this.setIcon(icon);
        this.setStyle(String.format("-fx-font-family: %s; -fx-font-size: %s;", icon.fontFamily(), size));
    }

    @Override
    public TYPE getDefaultGlyph()
    {
        return this.icon.getDefaultGlyph();
    }
}
