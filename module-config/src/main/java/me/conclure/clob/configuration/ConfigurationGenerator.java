package me.conclure.clob.configuration;

import me.conclure.clob.configuration.processing.Configuration;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.function.Predicate;

@SupportedAnnotationTypes("me.conclure.clob.configuration.processing.*")
public class ConfigurationGenerator extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return !roundEnv.getElementsAnnotatedWith(Configuration.class)
                .stream()
                .sequential()
                .map(element -> processConfigurable(element,annotations,roundEnv,this))
                .filter(isClaimedByProcessor -> !isClaimedByProcessor)
                .findFirst()
                .orElse(Boolean.TRUE);
    }

    private static boolean processConfigurable(
            Element element,
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv,
            ConfigurationGenerator processor
    ) {
        String simpleName = element.getClass().getSimpleName();
        Filer filer = processor.processingEnv.getFiler();
        try {
            FileObject resource = filer.createResource(StandardLocation.CLASS_OUTPUT, "", simpleName + ".json");
            try (Writer writer = resource.openWriter();
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)
            ) {
                bufferedWriter.write("ddddddddddddd");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
