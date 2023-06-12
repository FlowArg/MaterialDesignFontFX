package fr.flowarg.materialdesigniconfx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator
{
    private static final Map<Character, StringBuilder> LETTERS = new HashMap<>();

    public static void main(String[] args) throws IOException
    {
        final Path generatedFolder = Path.of("generated");

        if(Files.notExists(generatedFolder))
        {
            try
            {
                Files.createDirectory(generatedFolder);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        if(Files.isRegularFile(generatedFolder))
        {
            try
            {
                Files.delete(generatedFolder);
                Files.createDirectory(generatedFolder);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        AtomicReference<String> version = new AtomicReference<>();
        final var reader = new BufferedReader(new InputStreamReader(Generator.class.getResourceAsStream("/_variables.scss")));
        processFile(reader.lines().filter(s -> !s.contains("/*")).filter(s -> {
            if(s.startsWith("$"))
            {
                if(s.startsWith("$mdi-version"))
                {
                    version.set(s.split(":")[1]
                                        .replace(";", "")
                                        .replace("\"", "")
                                        .replace("!default", "")
                                        .trim());
                }
                return false;
            }
            return true;
        }).filter(s -> !s.startsWith(");")).filter(s -> s.startsWith("  ")).toList(), version.get());
    }

    private static void processFile(List<String> file, String version) throws IOException
    {
        System.out.println("Generating file for version " + version + ".");

        final String startClass = """
                /**
                 * Copyright (c) 2013-2016 Jens Deters http://www.jensd.de
                 *
                 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
                 * use this file except in compliance with the License. You may obtain a copy of
                 * the License at
                 *
                 * http://www.apache.org/licenses/LICENSE-2.0
                 *
                 * Unless required by applicable law or agreed to in writing, software
                 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
                 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
                 * License for the specific language governing permissions and limitations under
                 * the License.
                 *
                 */
                package fr.flowarg.materialdesignfontfx;

                import de.jensd.fx.glyphs.GlyphIcons;
                                
                import java.util.ArrayList;
                import java.util.Arrays;
                import java.util.Collections;
                import java.util.List;

                /**
                 *
                 * Icon Enum based on Material Design Icons v%s
                 * https://materialdesignicons.com
                 *
                 * @author Jens Deters (mail@jensd.de)
                 */
                public class MaterialDesignIcon_GEN_%s {
                                
                """.formatted(version, version.replace('.', '_'));
        final String enumValues = generateEnumValues(file);
        final String endClass1 = """
                    public static final List<GlyphIcons> GLYPH_ICONS;
                                
                    static {
                        final List<GlyphIcons> icons = new ArrayList<>();
                """;

        final StringBuilder listAdder = new StringBuilder();
        LETTERS.keySet().forEach(character -> listAdder.append("        icons.addAll(Arrays.asList(%s.values()));\n".formatted(character)));

        final String endClass2 = """                               
                        
                        GLYPH_ICONS = Collections.unmodifiableList(icons);
                    }
                }
                """;

        Files.writeString(Path.of("generated", "MaterialDesignIcon_GEN_" + version.replace('.', '_') + ".java"), startClass + enumValues + endClass1 + listAdder + endClass2, StandardCharsets.UTF_8);
    }

    private static String generateEnumValues(List<String> file)
    {
        LETTERS.clear();
        final String regex = "\"([^\"]+)\":\\s*([^,\n]+)";
        final Pattern pattern = Pattern.compile(regex);
        final StringBuilder enumValues = new StringBuilder();

        for (String ligne : file) {
            Matcher matcher = pattern.matcher(ligne);
            if (matcher.find()) {
                String cle = matcher.group(1);

                final var firstLetter = cle.toUpperCase().charAt(0);
                LETTERS.computeIfAbsent(firstLetter, k -> new StringBuilder());

                String value = matcher.group(2);
                LETTERS.get(firstLetter).append("        %s(new String(Character.toChars(0x%s))),\n".formatted(
                        cle.toUpperCase().replace('-', '_'),
                        value
                ));
            }
        }

        final String startEnum = """
                    public enum %s implements GlyphIcons {
                    
                """;

        final String endEnum = """

                        private final String unicode;

                        %s(String unicode) {
                            this.unicode = unicode;
                        }

                        @Override
                        public String unicode() {
                            return unicode;
                        }

                        @Override
                        public String fontFamily() {
                            return "'Material Design Icons'";
                        }
                    }
                    
                """;

        LETTERS.values().forEach(stringBuilder -> {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(";");
            stringBuilder.append("\n");
        });

        LETTERS.forEach((character, stringBuilder) -> {
            enumValues.append(startEnum.formatted(character));
            enumValues.append(stringBuilder);
            enumValues.append(endEnum.formatted(character));
        });

        return enumValues.toString();
    }
}
