package fr.flowarg.materialdesignfontfx;

import de.jensd.fx.glyphs.GlyphIcons;

public interface MaterialDesignIconGlyphs<TYPE extends Enum<TYPE> & MaterialDesignIconGlyphs<TYPE>> extends GlyphIcons
{
    TYPE getDefaultGlyph();
}
