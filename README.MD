# MaterialDesignFont for JavaFx

This is the updated version of the [Jensd's lib](https://bitbucket.org/Jerady/fontawesomefx/src/master/fontawesomefx/fontawesomefx-materialdesignfont/).

It's made for Java 17.

## Help Wanted
Feel free to open a PR if you want to help me with this project.


Because of the limitations imposed by Java, it is not possible to create enums that are too large, so I had to split `MaterialDesignIcon` into multiple enums. I've chosen to separate them with the first letter.

I seriously need help with the `MaterialDesignIconView` class to be compatible with the new enums without making one class per letter.

I need a generic solution so we can remove this slow reflection mess in the demo app.

## Usage
```java
import fr.flowarg.materialdesignfontfx.MaterialDesignIcon;
import fr.flowarg.materialdesignfontfx.MaterialDesignIconView;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        // scene logic
        var accountIcon = new MaterialDesignIconView.A(MaterialDesignIcon.ACCOUNT);
        var yinYangIcon = new MaterialDesignIconView.Y(MaterialDesignIcon.YIN_YANG);
        // add the icons to your UI
    }
}
```

## Generator
The Generator subproject aims to generate the `MaterialDesignIcon` class with the provided _variables.scss file.