package com.trendyol.pdfcreator.module;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.openhtmltopdf.util.XRLog;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

@NoArgsConstructor
@Component
public class PdfCreator {


    /**
     * @param htmlContent  , this parameter is REQUIRED and represents the HTML file content
     * @param fontMap, this parameter is REQUIRED and represents the map of tff files which is used on html file.
     * @return byte[] that represents the output pdf file.
     * @throws IOException
     */
    public byte[] createWithOpenHtmlToPdf(String htmlContent, Map<String, byte[]> fontMap) throws IOException {
        XRLog.listRegisteredLoggers().forEach(logger -> XRLog.setLevel(logger, Level.OFF));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfRendererBuilder pdfRendererBuilder = new PdfRendererBuilder();
        fontMap.forEach((key, value) -> pdfRendererBuilder.useFont(() -> new ByteArrayInputStream(value), key));
        pdfRendererBuilder.withHtmlContent(htmlContent, null);
        pdfRendererBuilder.toStream(byteArrayOutputStream);
        pdfRendererBuilder.useFastMode();
        pdfRendererBuilder.run();

        return byteArrayOutputStream.toByteArray();
    }
}
