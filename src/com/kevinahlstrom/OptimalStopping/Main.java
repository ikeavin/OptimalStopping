package com.kevinahlstrom.OptimalStopping;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

	
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		//Add command line functionality
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    Desktop.getDesktop().browse(new URI("http://www.google.com"));
		}
	}
}
