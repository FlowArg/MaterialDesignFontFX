/**
 * Copyright (c) 2015 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package fr.flowarg.materialdesignfontfx.demo;

import de.jensd.fx.glyphs.GlyphIcons;
import fr.flowarg.materialdesignfontfx.MaterialDesignIcon;
import fr.flowarg.materialdesignfontfx.MaterialDesignIconView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Jens Deters
 */
@SuppressWarnings("unchecked")
public class MaterialDesignIconsDemoApp extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        FlowPane iconsPane = new FlowPane(3,3);
        iconsPane.setPrefWrapLength(1200);
        for (GlyphIcons icon : MaterialDesignIcon.GLYPH_ICONS) {
            final var letter = icon.getClass().getSimpleName();
            try
            {
                Class<MaterialDesignIconView<?>> viewClass = (Class<MaterialDesignIconView<?>>)Class.forName(MaterialDesignIconView.class.getName() + "$" + letter);
                final var view = viewClass.getConstructor(icon.getClass()).newInstance(icon);
                view.setSize("5em");
                iconsPane.getChildren().add(view);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e)
            {
                throw new RuntimeException(e);
            }
        }
        Scene scene = new Scene(new ScrollPane(iconsPane), 1200, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX: MaterialDesignIcons Demo: " + MaterialDesignIcon.GLYPH_ICONS.size() + " Icons");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
