package com.douzone.container.videosystem;


public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	public DVDPlayer() {
		
	}
	
	

	public String play() {
		return dvd.play();
	}
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
}
