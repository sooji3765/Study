# 리스트 정렬하기

  #### `Comparable` 과 `Comparator`의 차이점 ?


  > Comparable Interface

   - 자연스러운 순서로 정렬할 때 사용
   - 기본 정렬기준을 구현하는데 사용

  `Array`, `Collection` 클래스에 내장된 라이브러리 사용

  ~~~java
  //int 타입 배열을 순서대로 정렬하기

  @Test
  public void sortInts() {

		final int[] numbers = {7,-3,4,-5,-2,1};
		final int[] expected = {-5,-3,-2,1,4,7};

    // 정렬
		Arrays.sort(numbers);
		assertArrayEquals(expected,numbers);
	}

  ~~~

  ~~~java

  // 객체배열을 정렬하려면 Comparable 인터페이스를 구현해야함

  public void sortInts() {

		final String[] strings = {"z","f","c","u"};
		final String[] expected = {"abc","f","t","u"};

		Arrays.sort(strings);
		assertArrayEquals(expected,strings);
	}

  ~~~



  > Comparator Interface

   - 원하는 대로 정렬 순서를 지정하고 싶을 때
   - 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용


   Comparator 인터페이스를 구현하는데 필요한 메서드
   1. int compare(T o1, T o2) ====> 결과 양수 , 0 , 음수
   2. boolean equals(Object o)


   ~~~java
   // 숫자 역순 정렬
   package example;

  import java.util.Arrays;
  import java.util.Collections;
  import java.util.Comparator;
  import java.util.List;

  public class ReverseNumerical implements Comparator<Integer> {

  	public static void main(String[] args) {
  		customSorting();
  	}

  	@Override
  	public int compare(Integer arg0, Integer arg1) {
  		// TODO Auto-generated method stub
  		return arg1-arg0;
  	}

  	public static void customSorting() {
  		final List<Integer> numbers = Arrays.asList(4,7,1,6,3,5,4);
  		final List<Integer> expected = Arrays.asList(7,6,5,4,4,3,1);

  		Collections.sort(numbers, new ReverseNumerical());

      // 동일여부 체크
      if(expected.equals(numbers)) {
  			System.out.println("동일");
  		}else {
  			System.out.println("동일하지 않음");
  		}
  	 }

   }
   ~~~  
