package org.swa.mocktails.config;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Mocktail Resource", description = "Mocktail Management interface."),
                @Tag(name = "Cocktail Resource", description = "Cocktail Management interface.")
        },
        info = @Info(
                title = "Mocktail app API with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Nelson Morais",
                        url = "https://github.com/Nelson-Morais",
                        email = "nelson.morais@hs-osnabrueck.de"),
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/licenses/MIT"))
)

public class SwaggerConfig extends Application {
}
