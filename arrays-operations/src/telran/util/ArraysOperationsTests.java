package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

import java.util.Arrays;
class ArraysOperationsTests {
 private static final String INSERTED_STRING = "World end ";
private static final int INSERTED_NUMBER = 100;
	@Test
	void testInsert() {
		String arStr[]= {"Hello","Java"};
		String expectedStr[] = {"Hello",INSERTED_STRING,"Java"};
		String actualStr[] = new String[3];
		int indexInsert = 1;
		assertEquals(OK, insert(arStr,INSERTED_STRING,indexInsert,actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX, insert(arStr,INSERTED_STRING,100,actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH, insert(arStr,INSERTED_STRING,indexInsert,actualStr));
		Integer numbers[] = {1,2,3};
		indexInsert=0;
		Integer actualNumbers[] = new Integer[numbers.length+1];
		Integer expextedFirst[] = {INSERTED_NUMBER,1,2,3};
		insert(numbers,INSERTED_NUMBER,indexInsert,actualNumbers);
		assertArrayEquals(expextedFirst, actualNumbers);
		indexInsert = numbers.length;
		Integer expextedLast[] = {1,2,3,INSERTED_NUMBER};
		insert(numbers,INSERTED_NUMBER,indexInsert,actualNumbers);
		assertArrayEquals(expextedLast, actualNumbers);
	}

	@Test
	void testRemove() {
		String arStr[]= {"aa","bb","ab","cc"};
		String expectedStr[] = {"aa","bb","cc"};
		String actualStr[] = new String[3];
		int index = 2;
		remove(arStr, index, actualStr);
		assertArrayEquals(expectedStr, actualStr);
		String expectedStrFirst[] = {"bb","ab","cc"};
		index = 0;
		remove(arStr, index, actualStr);
		assertArrayEquals(expectedStrFirst, actualStr);
		String expectedStrLast[] = {"aa","bb","ab"};
		index = 3;
		remove(arStr, index, actualStr);
		assertArrayEquals(expectedStrLast, actualStr);
	}

	@Test
	void testInsertSorted() {
		String arStr[]= {"aa","bb","ab"};
		String expectedStr[] = {"aa","baa","bb","ab"};
		String actualStr[] = new String[4];
		String element = "baa";
		insertSorted(arStr, element, actualStr);
		assertArrayEquals(expectedStr, actualStr);
		Integer arInt[]= {10,20,30};
		Integer expectedInt[] = {10,20,25,30};
		Integer actualInt[] = new Integer[4];
		Integer elementInt = 25;
		insertSorted(arInt, elementInt, actualInt);
		assertArrayEquals(expectedInt, actualInt);
	}

	@Test
	void testAddLast() {
		String arStr[]= {"aa","bb","cc"};
		String expectedStr[] = {"aa","bb","cc","dd"};
		String actualStr[] = new String[4];
		String element = "dd";
		addLast(arStr, element, actualStr);
		assertArrayEquals(expectedStr, actualStr);
	}
	
	@Test
	void testAddFirst() {
		String arStr[]= {"aa","bb","cc"};
		String expectedStr[] = {"dd","aa","bb","cc"};
		String actualStr[] = new String[4];
		String element = "dd";
		addFirst(arStr, element, actualStr);
		assertArrayEquals(expectedStr, actualStr);
	}

}
