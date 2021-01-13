# [ArrayList] Array List 개념, 구현

Array List에 대해 알아볼겠습니다.



## Array List란?

> 크기가 고정되지 않은 배열



언어별 Array Size

* PHP - Dynamic
* Java - Fixed

Java에서 제공해주는 ArrayList는 데이터를 넣어주는만큼 사이즈가 늘어남.



## Array List의 입력 및 검색 시간

ArrayList는 배열이 다 차면 배열을 두배로 늘려준다.

그래서 검색시 고정된 배열에서 검색을 하게 된다. (검색 시간 O(1))



> Doubling - 기존 배열에서 2배로 늘려준 배열에 데이터를 복사(O(n))

ArrayList에서 Doubling을 할때 기존 데이터를 복사해오는 작업은 n/2가 소요된다.

이전에는 n/4가 소요됐을 것이고 그 이전에는 n/8이 소요됐을 것이다.

n/2 + n/4 + n/8 + ... + 2 + 1 < n

때문에 n개의 데이터를 넣을때 n의 시간보다 적게 걸리므로 O(1)이 된다.



### 결론

ArrayList의 평균시간

* 검색 시간 O(1)
* 입력 시간 O(1)



## Array List 구현 코드 in Java

```java
class ArrayList{
	private Object[] data;
	private int size;
	private int index;
	
	public ArrayList() {
		this.size = 1;
		this.data = new Object[this.size];
		this.index = 0;
	}
	public void add(Object obj) {
		System.out.println("index: " + this.index
						+ ", size: " + this.size
						+ ", data size: " + this.data.length);
		if(this.index == this.size -1) {
			doubling();
		}
		data[this.index] = obj;
		this.index++;
	}
	private void doubling() {
		this.size = this.size * 2;
		Object[] newData = new Object[this.size];
		for(int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		this.data = newData;
		System.out.println("doubling >>> index: " + this.index
						+ ", size: " + this.size
						+ ", data size: " + this.data.length);
	}
	public Object get(int i) throws Exception{
		if(i > this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i < 0) {
			throw new Exception("Negative Value");
		}
		return this.data[i];
	}
	public void remove(int i) throws Exception{
		if(i > this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i < 0) {
			throw new Exception("Negative Value");
		}
		System.out.println("data removed: " + this.data[i]);
		for(int x = i; x < this.data.length -1; x++) {
			data[x] = data[x + 1];
		}
		this.index--;
	}
}

public class ArrayListTest {
	public static void main(String[] args) throws Exception{
		ArrayList al = new ArrayList();
		al.add("0");
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		System.out.println(al.get(5));
		al.remove(5);
		System.out.println(al.get(5));
	}
}
```





## 링크

아래 강의를 참고하여 작성하였습니다.

* [엔지니어대한민국 - 자바의 ArrayList에 대해 알아보고 구현하기](https://www.youtube.com/watch?v=I4_uFyjWZn4&list=PLjSkJdbr_gFaPf3ojJFZYXXA__8zcUpdZ&index=2)