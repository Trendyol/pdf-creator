package com.trendyol.pdfcreator.annotation;

import com.trendyol.pdfcreator.config.PdfCreatorConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({PdfCreatorConfiguration.class})
@Configuration
public @interface EnablePdfCreator {
}
