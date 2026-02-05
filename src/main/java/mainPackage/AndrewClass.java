package mainPackage;

import java.io.PrintStream;

public class AndrewClass {
	private String[] buckets;
	private int size = 0;
	private static final int EXPANSION_RATIO = 2;

	public AndrewClass() {
		buckets = new String[10];
		size = 0;
	}

	public AndrewClass(AndrewClass ac) {
		buckets = new String[ac.getSize()];

		for (int i = 0; i < ac.getSize(); i++) {
			buckets[i] = ac.buckets[i];
		}

		size = ac.size;
	}

	public void addToEnd(String s) {
		if (size >= buckets.length) {
			int newSize = size * EXPANSION_RATIO;

			String[] newBuckets = new String[newSize];

			for (int i = 0; i < size; i++) {
				newBuckets[i] = buckets[i];
			}

			buckets = newBuckets;
		}

		buckets[size] = s;
		size++;
	}

	public void replace(String s, int idx) {
		buckets[idx] = s;
	}

	public void addToBucket(String s, int idx) {
		if (size >= (buckets.length - 1)) {
			int newSize = size * EXPANSION_RATIO;

			String[] newBuckets = new String[newSize];

			for (int i = 0; i < size; i++) {
				newBuckets[i] = buckets[i];
			}

			buckets = newBuckets;
		}

		size++;
		for (int i = size; i > idx; i--) {
			buckets[i] = buckets[i - 1];
		}

		buckets[idx] = s;
	}

	public int getSize() {
		return size;
	}

	public String at(int idx) throws AndrewClassException {
		if (idx < 0) {
			throw new AndrewClassException("Index can not be negative.");
		}

		if (idx >= size) {
			throw new AndrewClassException(String.format("Index at %d is more than the maximum of %d.", idx, size));
		}

		return buckets[idx];
	}

	public int findCount(String s) {
		int strCount = 0;

		for (int i = 0; i < size; i++) {
			if (buckets[i].equals(s)) {
				strCount++;
			}
		}

		return strCount;
	}

	public void printBuckets(PrintStream ps) {
		ps.print('[');

		for (int i = 0; i < size; i++) {
			ps.print(buckets[i]);

			if (i < (size - 1)) {
				ps.print(", ");
			}
		}

		ps.print(']');
	}

	public boolean find(String s) {
		for (int i = 0; i < size; i++) {
			if (buckets[i].equals(s)) {
				return true;
			}
		}

		return false;
	}

	public void remove(int idx) throws AndrewClassException {
		if (idx < 0) {
			throw new AndrewClassException("Index can not be negative.");
		}

		if (idx >= size) {
			throw new AndrewClassException(String.format("Index at %d is more than the maximum of %d.", idx, size));
		}

		buckets[idx] = null;
		size--;

		for (int i = idx; i < size; i++) {
			buckets[i] = buckets[i + 1];
		}
	}
}