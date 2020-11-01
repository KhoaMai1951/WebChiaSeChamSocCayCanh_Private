package com.myclass.utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileHandler {
	public String fileName;

	// copy img to project's resources folder and add the name of the copied img
	public void imageUpload(HttpServletRequest request, String resourcesPath) throws IOException, ServletException {
		Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
		InputStream in = null;
		if (filePart.getContentType().startsWith("image/")) {
			in = filePart.getInputStream();
		}
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}
		String filePath = resourcesPath + "\\" + UUID.randomUUID().toString() + ".png";
		Path path = Paths.get(filePath);
		Files.copy(in, path);

		// return copied file's name
		int i = filePath.lastIndexOf('\\');
		String lastToken = filePath.substring(i + 1);
		this.fileName = lastToken;
	}
}