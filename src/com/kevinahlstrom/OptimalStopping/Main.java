package com.kevinahlstrom.OptimalStopping;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	
	public static void main(String[] args) throws IOException {
		Scanner resources = new Scanner(new File("resources.txt"));
		Scanner input = new Scanner(System.in);
		
		List<StopObject> stopObjects = new ArrayList<StopObject>();
		while(resources.hasNext()) {
			stopObjects.add(new StopObject(resources.next()));
		}
		Collections.shuffle(stopObjects);
		float scoreTarget = -Float.MAX_VALUE;
		int earliestStopIndex = (int) Math.floor((stopObjects.size() - 1) * .37);
		StopObject decision;
		
		for(int i = 0; i < stopObjects.size(); i++) {
			if(stopObjects.get(i).isUrl) {
				System.out.println("Opening url '" + stopObjects.get(i).name + "'...");
				try {
					openUrl(stopObjects.get(i).name);
				} catch(Exception e) {
					System.out.println("Url could not be open. ");
				}
			} else {
				System.out.println("Item " + (i+1) + ": " + stopObjects.get(i).name);
			}
			System.out.println("Enter score value: ");
			Float score = input.nextFloat();
			stopObjects.get(i).setScore(score);
			
			if(score > scoreTarget) {
				scoreTarget = score;
				decision = stopObjects.get(i);
				if(i >= earliestStopIndex) {
					System.out.println("Decision made: " + decision.name);
					break;
				}
			}
		}
		
	}
	
	private static void openUrl(String url) throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    Desktop.getDesktop().browse(new URI(url));
		}
	}
}
