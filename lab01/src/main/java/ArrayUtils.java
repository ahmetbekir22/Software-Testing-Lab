public class ArrayUtils {

	/**
	 * Finds the last index of the given value in the array starting at the given
	 * index.
	 * 
	 * A negative startIndex will return -1.
	 * startIndex larger than the array length will search from the end of the
	 * array.
	 *
	 * @param array
	 *                   the array to traverse for looking for the object, may be
	 *                   null
	 * @param value
	 *                   the value to find
	 * @param startIndex
	 *                   the start index to traverse backwards from
	 * @return the last index of the value within the array,
	 *         -1 if not found or null array input
	 */
	public static void main(String[] args) {

		int[] array = { 1, 1, 1, 1, 1, 1 };
		int lenght = array.length;
		int value = 1;
		int startIndex = lenght - 1;

		int result = findLastIndex(array, value, startIndex);
		System.out.println("lenght of array: " + lenght);
		System.out.println("Last index of " + value + " starting from index " + startIndex + " is: " + result);
	}

	public static int findLastIndex(int[] array, int value, int start) {
		if (array == null) {
			return -1;
		}
		if (start < 0) {
			return -1;
		}
		if (start > array.length) {
			start = array.length;
		}
		for (int i = start - 1; i >= 0; i--) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;

	}
}
