/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfgenerator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author ajay
 */
public class PDFGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(null);
        
        File file = fileChooser.getSelectedFile();
        
        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter(file.getCanonicalPath()));
            Document document = new Document(pdf);
            
            document.add(new Paragraph("Hello, World!"));
            document.close();
            pdf.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
