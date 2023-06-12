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

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphIcons;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public abstract class MaterialDesignIconView<TYPE extends Enum<TYPE> & GlyphIcons> extends GlyphIcon<TYPE> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/materialdesignicons/materialdesignicons-webfont.ttf";

    static {
        try {
            Font.loadFont(MaterialDesignIconView.class.getResource(TTF_PATH).openStream(), 10.0d);
        } catch (IOException ex) {
            Logger.getLogger(MaterialDesignIconView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MaterialDesignIconView(TYPE icon) {
        super(icon.getDeclaringClass());
        this.setIcon(icon);
        this.setStyle(String.format("-fx-font-family: %s; -fx-font-size: %s;", icon.fontFamily(), "1em"));
    }

    public static class A extends MaterialDesignIconView<MaterialDesignIcon.A>
    {
        public A(MaterialDesignIcon.A icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.A getDefaultGlyph()
        {
            return MaterialDesignIcon.A.ANDROID;
        }
    }

    public static class B extends MaterialDesignIconView<MaterialDesignIcon.B>
    {
        public B(MaterialDesignIcon.B icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.B getDefaultGlyph()
        {
            return MaterialDesignIcon.B.BELL;
        }
    }

    public static class C extends MaterialDesignIconView<MaterialDesignIcon.C>
    {
        public C(MaterialDesignIcon.C icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.C getDefaultGlyph()
        {
            return MaterialDesignIcon.C.CAMERA;
        }
    }

    public static class D extends MaterialDesignIconView<MaterialDesignIcon.D>
    {
        public D(MaterialDesignIcon.D icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.D getDefaultGlyph()
        {
            return MaterialDesignIcon.D.DICE_6;
        }
    }

    public static class E extends MaterialDesignIconView<MaterialDesignIcon.E>
    {
        public E(MaterialDesignIcon.E icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.E getDefaultGlyph()
        {
            return MaterialDesignIcon.E.EARTH;
        }
    }

    public static class F extends MaterialDesignIconView<MaterialDesignIcon.F>
    {
        public F(MaterialDesignIcon.F icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.F getDefaultGlyph()
        {
            return MaterialDesignIcon.F.FACEBOOK;
        }
    }

    public static class G extends MaterialDesignIconView<MaterialDesignIcon.G>
    {
        public G(MaterialDesignIcon.G icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.G getDefaultGlyph()
        {
            return MaterialDesignIcon.G.GAMEPAD;
        }
    }

    public static class H extends MaterialDesignIconView<MaterialDesignIcon.H>
    {
        public H(MaterialDesignIcon.H icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.H getDefaultGlyph()
        {
            return MaterialDesignIcon.H.HAMMER;
        }
    }

    public static class I extends MaterialDesignIconView<MaterialDesignIcon.I>
    {
        public I(MaterialDesignIcon.I icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.I getDefaultGlyph()
        {
            return MaterialDesignIcon.I.INBOX;
        }
    }

    public static class J extends MaterialDesignIconView<MaterialDesignIcon.J>
    {
        public J(MaterialDesignIcon.J icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.J getDefaultGlyph()
        {
            return MaterialDesignIcon.J.JEEPNEY;
        }
    }

    public static class K extends MaterialDesignIconView<MaterialDesignIcon.K>
    {
        public K(MaterialDesignIcon.K icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.K getDefaultGlyph()
        {
            return MaterialDesignIcon.K.KEY;
        }
    }

    public static class L extends MaterialDesignIconView<MaterialDesignIcon.L>
    {
        public L(MaterialDesignIcon.L icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.L getDefaultGlyph()
        {
            return MaterialDesignIcon.L.LAMP;
        }
    }

    public static class M extends MaterialDesignIconView<MaterialDesignIcon.M>
    {
        public M(MaterialDesignIcon.M icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.M getDefaultGlyph()
        {
            return MaterialDesignIcon.M.MAGNET;
        }
    }

    public static class N extends MaterialDesignIconView<MaterialDesignIcon.N>
    {
        public N(MaterialDesignIcon.N icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.N getDefaultGlyph()
        {
            return MaterialDesignIcon.N.NATURE_PEOPLE;
        }
    }

    public static class O extends MaterialDesignIconView<MaterialDesignIcon.O>
    {
        public O(MaterialDesignIcon.O icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.O getDefaultGlyph()
        {
            return MaterialDesignIcon.O.OCTAGON;
        }
    }

    public static class P extends MaterialDesignIconView<MaterialDesignIcon.P>
    {
        public P(MaterialDesignIcon.P icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.P getDefaultGlyph()
        {
            return MaterialDesignIcon.P.PENCIL;
        }
    }

    public static class Q extends MaterialDesignIconView<MaterialDesignIcon.Q>
    {
        public Q(MaterialDesignIcon.Q icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.Q getDefaultGlyph()
        {
            return MaterialDesignIcon.Q.QUORA;
        }
    }

    public static class R extends MaterialDesignIconView<MaterialDesignIcon.R>
    {
        public R(MaterialDesignIcon.R icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.R getDefaultGlyph()
        {
            return MaterialDesignIcon.R.RAY_END;
        }
    }

    public static class S extends MaterialDesignIconView<MaterialDesignIcon.S>
    {
        public S(MaterialDesignIcon.S icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.S getDefaultGlyph()
        {
            return MaterialDesignIcon.S.SCALE_BALANCE;
        }
    }

    public static class T extends MaterialDesignIconView<MaterialDesignIcon.T>
    {
        public T(MaterialDesignIcon.T icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.T getDefaultGlyph()
        {
            return MaterialDesignIcon.T.TABLE;
        }
    }

    public static class U extends MaterialDesignIconView<MaterialDesignIcon.U>
    {
        public U(MaterialDesignIcon.U icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.U getDefaultGlyph()
        {
            return MaterialDesignIcon.U.UMBRELLA;
        }
    }

    public static class V extends MaterialDesignIconView<MaterialDesignIcon.V>
    {
        public V(MaterialDesignIcon.V icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.V getDefaultGlyph()
        {
            return MaterialDesignIcon.V.VIDEO;
        }
    }

    public static class W extends MaterialDesignIconView<MaterialDesignIcon.W>
    {
        public W(MaterialDesignIcon.W icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.W getDefaultGlyph()
        {
            return MaterialDesignIcon.W.WALLET;
        }
    }

    public static class X extends MaterialDesignIconView<MaterialDesignIcon.X>
    {
        public X(MaterialDesignIcon.X icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.X getDefaultGlyph()
        {
            return MaterialDesignIcon.X.XML;
        }
    }

    public static class Y extends MaterialDesignIconView<MaterialDesignIcon.Y>
    {
        public Y(MaterialDesignIcon.Y icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.Y getDefaultGlyph()
        {
            return MaterialDesignIcon.Y.YIN_YANG;
        }
    }

    public static class Z extends MaterialDesignIconView<MaterialDesignIcon.Z>
    {
        public Z(MaterialDesignIcon.Z icon)
        {
            super(icon);
        }

        @Override
        public MaterialDesignIcon.Z getDefaultGlyph()
        {
            return MaterialDesignIcon.Z.ZIP_BOX;
        }
    }
}
