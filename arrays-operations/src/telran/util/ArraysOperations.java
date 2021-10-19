package telran.util;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysOperations {
	public static final String OK = "ok";
	public static final String WRONG_INDEX = "wrong-index";
	public static final String WRONG_RESULT_LENGTH = "wrong-result-length";

	public static <T> String insert(T[] array, T element, int index, T[] res) {
		//TODO insert any object at given index into the given "res" array
		if(index<0 || index>array.length) {
			return WRONG_INDEX;
		}
		if(res.length!=array.length+1) {
			return WRONG_RESULT_LENGTH;
		}
		System.arraycopy(array, 0, res, 0, index);
		res[index]= element;
		System.arraycopy(array, index, res, index+1, array.length-index);
		return OK;
	}
	public  static <T> String remove(T[] array, int index, T[] res) {
		//[YG] major bug see comment in tests
		if(index<0 || index>array.length) {
			return WRONG_INDEX;
		}
		if(res.length!=array.length-1) {
			return WRONG_RESULT_LENGTH;
		}
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index+1, res, index, res.length-index);
		return OK;
	}
	public static <T> String insertSorted (T[] sortedArray,T element, T[] res) {
		//TODO insert a given element at index keep array sorted
		//below is the example of binarySearch call
		//How to use a result  of that call - is your challenge
		int index = Arrays.binarySearch(sortedArray, element,(Comparator<T>) Comparator.naturalOrder());
		if(index<0) {
			index= Math.abs(index)-1;
		}
		//[YG] better to apply already written and tested method insert
		if(res.length!=sortedArray.length+1) {
			return WRONG_RESULT_LENGTH;
		}
		System.arraycopy(sortedArray, 0, res, 0, index);
		res[index]= element;
		System.arraycopy(sortedArray, index, res, index+1, sortedArray.length-index);
		return OK;
	}
	public static <T> String addLast(T[] array, T element, T[] res) {
		//TODO adds a given element at end of the result array
		//[YG] better to apply already written and tested method insert
		if(res.length!=array.length+1) {
			return WRONG_RESULT_LENGTH;
		}
		System.arraycopy(array, 0, res, 0, array.length);
		res[array.length]=element;
		return OK;
	}
	public static <T> String addFirst(T[] array, T element, T[] res) {
		//TODO adds a given element at beginning of the result array
		//[YG] better to apply already written and tested method insert
		if(res.length!=array.length+1) {
			return WRONG_RESULT_LENGTH;
		}
		System.arraycopy(array, 0, res, 1, array.length);
		res[0]=element;
		return OK;
	}
}
