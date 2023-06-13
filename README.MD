[version]: https://img.shields.io/maven-central/v/fr.flowarg/materialdesignfontfx.svg?label=Download
[download]: https://central.sonatype.com/artifact/fr.flowarg/materialdesignfontfx

[ ![version][] ][download]

# MaterialDesignFont for JavaFx

This is the updated version of the [Jensd's lib](https://bitbucket.org/Jerady/fontawesomefx/src/master/fontawesomefx/fontawesomefx-materialdesignfont/).

It's made for Java 17.

## Download
MaterialDesignFontFX is available on Maven Central.

### Maven
```xml
<dependency>
    <groupId>fr.flowarg</groupId>
    <artifactId>materialdesignfontfx</artifactId>
    <version>VERSION</version>
</dependency>
```

### Gradle
```gradle
dependencies {
    implementation 'fr.flowarg:materialdesignfontfx:VERSION'
}
```

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
        var accountIcon = new MaterialDesignIconView<>(MaterialDesignIcon.A.ACCOUNT);
        var yinYangIcon = new MaterialDesignIconView<>(MaterialDesignIcon.Y.YIN_YANG);
        // add the icons to your UI
    }
}
```

## Generator
The Generator subproject aims to generate the `MaterialDesignIcon` class with the provided _variables.scss file.