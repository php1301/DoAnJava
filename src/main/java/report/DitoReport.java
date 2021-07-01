/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import com.itextpdf.dito.sdk.core.data.JsonData;
import com.itextpdf.dito.sdk.output.PdfProducer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Admin
 */
public class DitoReport {
//    DitoLicense.loadLic

    public DitoReport() {
        print();
    }

    public static void print() {
        FileOutputStream pdfStream = null;
        try {

            String jsonString = "{'hotel_name': 'Test'}";
            File projectFile = new File("../../../../ticket-booking.dito");
            String templateName = "output";
//            File targetDirectory = new File(".");
            pdfStream = FileUtils.openOutputStream(new File("../../../../invoice1.pdf"));
            try {
                PdfProducer.convertTemplateFromPackage(projectFile, templateName, pdfStream, new JsonData(jsonString));
            } catch (IOException ex) {
                Logger.getLogger(DitoReport.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    pdfStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(DitoReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DitoReport.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfStream.close();
            } catch (IOException ex) {
                Logger.getLogger(DitoReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Running database test");
        print();
    }
}
