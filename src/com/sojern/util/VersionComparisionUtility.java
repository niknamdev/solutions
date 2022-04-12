package com.sojern.util;

public class VersionComparisionUtility {

	public static void main(String[] args) {
		Version a = new Version("1.1");
		Version b = new Version("1.1.1");
		System.out.println(a.compareTo(b)); // return -1 (a<b)
		Version c = new Version("2.6.1.2");
		Version d = new Version("2.6.1");
		System.out.println(c.compareTo(d)); // return 1 (c>d)
	}

}

/**
 * This class compare two version numbers version1 and version2. condition :If
 * version1 > version2 return 1 If version1 < version2 return -1 otherwise
 * return 0
 */

class Version implements Comparable<Version> {

	private String version;

	public final String get() {
		return this.version;
	}

	public Version(String version) {
		if (version == null)
			throw new IllegalArgumentException("Version can not be null");
		if (!version.matches("[0-9]+(\\.[0-9]+)*"))
			throw new IllegalArgumentException("Invalid version format");
		this.version = version;
	}

	@Override
	public int compareTo(Version that) {
		if (that == null)
			return 1;
		String[] thisParts = this.get().split("\\.");
		String[] thatParts = that.get().split("\\.");
		int length = Math.max(thisParts.length, thatParts.length);
		for (int i = 0; i < length; i++) {
			int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i]) : 0;
			int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i]) : 0;
			if (thisPart < thatPart)
				return -1;
			if (thisPart > thatPart)
				return 1;
		}
		return 0;
	}

}
