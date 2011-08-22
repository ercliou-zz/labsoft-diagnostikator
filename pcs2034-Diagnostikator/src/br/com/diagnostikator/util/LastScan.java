package br.com.diagnostikator.util;

import java.util.Calendar;

public class LastScan {

	private Calendar cal;
	private boolean hasScanned;
	private boolean isScanning;

	private final static LastScan instance = new LastScan();

	private LastScan() {
		this.cal = Calendar.getInstance();
		this.hasScanned = false;
		this.isScanning = false;
	}

	public static LastScan getInstance() {
		return instance;
	}

	public boolean shouldScan() {
		if (!this.hasScanned) {
			if (this.isScanning)
				return false;
			else {
				this.isScanning = true;
				return true;
			}
		} else {
			Calendar today = Calendar.getInstance();

			boolean sameDay = this.cal.get(Calendar.YEAR) == today
					.get(Calendar.YEAR)
					&& this.cal.get(Calendar.DAY_OF_YEAR) == today
							.get(Calendar.DAY_OF_YEAR);

			if (sameDay) {
				this.isScanning = false;
				return false;
			} else {
				if (this.isScanning) {
					return false;
				} else {
					this.cal = today;
					this.isScanning = true;
					return true;
				}
			}
		}
	}

	public void finishedScan() {
		this.hasScanned = true;
		this.isScanning = false;
	}

	public void problemOnScan() {
		this.hasScanned = false;
		this.isScanning = false;
	}
}
