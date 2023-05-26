package service;

import repository.RepositorioUsuario;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import model.Usuario;

public class GerarPdf {

	public void gerarPdfUsuario() {
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		
		Document doc = new Document();// Objeto que representa o documento
		float fntSize, lineSpacing;//Tamanho da fonte
		fntSize = 6.7f; // Tamanho da fonte
		lineSpacing = 10f;// Espaçamento das linhas
		String arquivoPdf = "usuarios.pdf"; //local e nome do arquivo
		try {
			//FileOutputStream -> Objeto que vai conectar o sistema com o local que o arquivo vai ser salvo
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));// Realiza a escrita do PDF
			doc.open();// Abrir a conexão com o Documento
			Paragraph paragrafo = new Paragraph();//Criação paragrafo
			paragrafo.setAlignment(1);//Alinhamento do paragrafo
			doc.add(paragrafo);//Adiciona o paragrafo no pdf
			
			Image image = Image.getInstance("imagens/logo.png"); // Cria um objeto imagem(logo da impacta)
			image.setAlignment(1);//Alinhamento da imagem
			image.scaleToFit(200, 200);// Dimensão da imagem
			doc.add(image);//Adiciona a imagem no documento
			
			
			
			paragrafo = new Paragraph("Usuarios",FontFactory.getFont(FontFactory.TIMES, 20f));// Titulo
			paragrafo.setAlignment(1);
			doc.add(paragrafo);
			
			paragrafo = new Paragraph("  ",FontFactory.getFont(FontFactory.TIMES, 20f));
			paragrafo.setAlignment(1);
			doc.add(paragrafo);
			
			PdfPTable tabelaPDF = new PdfPTable(new float[] { 900f, 2500f,3500f,1000f});// Criação da tabela
			
			PdfPCell celulaMatricula = new PdfPCell(new Paragraph("Matricula",FontFactory.getFont(FontFactory.TIMES, fntSize)));
			PdfPCell celulaNome = new PdfPCell(new Paragraph("Nome",FontFactory.getFont(FontFactory.TIMES, fntSize)));
			PdfPCell celulaEmail = new PdfPCell(new Paragraph("Email",FontFactory.getFont(FontFactory.TIMES, fntSize)));
			PdfPCell celulaTipoUsuario = new PdfPCell(new Paragraph("TipoUsuario",FontFactory.getFont(FontFactory.TIMES, fntSize)));
			
			
			
			tabelaPDF.addCell(celulaMatricula);
			tabelaPDF.addCell(celulaNome);
			tabelaPDF.addCell(celulaEmail);
			tabelaPDF.addCell(celulaTipoUsuario);
			
			
			
			
			for (Usuario usuario: repositorioUsuario.retornaUsuarios()) {
				celulaMatricula = new PdfPCell(new Paragraph(usuario.getMatricula(),FontFactory.getFont(FontFactory.TIMES, fntSize)));
				celulaNome = new PdfPCell(new Paragraph(usuario.getNome(),FontFactory.getFont(FontFactory.TIMES, fntSize)));
				celulaEmail = new PdfPCell(new Paragraph(usuario.getEmail(),FontFactory.getFont(FontFactory.TIMES, fntSize)));
				celulaTipoUsuario = new PdfPCell(new Paragraph(usuario.getTipoUsuario(),FontFactory.getFont(FontFactory.TIMES, fntSize)));
				//celulaSenha = new PdfPCell(new Paragraph(usuario.getSenha(),FontFactory.getFont(FontFactory.TIMES, fntSize)));
				
				tabelaPDF.addCell(celulaMatricula);
				tabelaPDF.addCell(celulaNome);
				tabelaPDF.addCell(celulaEmail);
				tabelaPDF.addCell(celulaTipoUsuario);
				
				
			}
			
			doc.add(tabelaPDF);
			doc.close();
			Desktop.getDesktop().open(new File (arquivoPdf)); // Abro o PDF autoticamente
			JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "PDF com erro!!");
		}
	
		
		
	}
	
	
}
