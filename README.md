# Unwanted YAML tag in auto-generated OpenAPI spec file

## Overview
This example shows how a YAML tag issue appears when a combination of tools is used:
- SpringBoot Web
- SpringDoc OpenAPI
- Jackson

## Issue
See the `components/examples` section of the spec file:
```yaml
  examples:
    umbrellaExample:
      value:
        object: !<Type A>
          type: TYPE_A
          name: x
          description: "y"
```

`!<Type A>` doesn't seem to be a valid YAML tag.
Swagger Online Editor tool also complains about this tag and refuses to render such YAML file.

## Using this example app
Two ways to get auto-generated OpenAPI spec:
- `mvn clean verify` puts generated spec into file `./target/api-docs.yaml`
- run SpringBoot App and open `http://localhost:8080/api-docs.yaml`

## Key notes
The issue appears when:
- there's an abstract class (`AbstractObject`) with one or more concrete implementations
- the abstract class (`AbstractObject`) has a `type` field
- annotation `@JsonTypeInfo` is used on the abstract class (`AbstractObject`) to properly deserialize concrete implementation(s) into abstract reference
- there's a model class (`Umbrella`) which references the abstract class (`AbstractObject`)
- an example object for model class (`Umbrella`) is defined in OpenAPI `components/examples` section via OpenAPI bean (see `Application#openApi`)
